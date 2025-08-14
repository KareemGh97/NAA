package Utilities.DataBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import TestBases.TestBase;


public class DynamicDatabaseConnectionManager {

    private static final Properties properties = new Properties();
    private static final Map<String, String[]> connectionPool = new HashMap<>();
    private static final ThreadLocal<Map<String, String[]>> threadLocalConnections = ThreadLocal.withInitial(HashMap::new);
    static Connection con;
    static {
        String db_config = System.getProperty("user.dir") + "/src/main/java/properties/sit-db-config.properties";
        switch (TestBase.environment) {
            case "sit" ->
                    db_config = System.getProperty("user.dir") + "/src/main/java/properties/sit-db-config.properties";
            case "uat" ->
                    db_config = System.getProperty("user.dir") + "/src/main/java/properties/uat-db-config.properties";
        }
        try (FileInputStream fileInputStream = new FileInputStream(db_config)) {
            properties.load(fileInputStream);

            // Load connections into the pool
            properties.forEach((key, value) -> {
                String keyString = key.toString();
                if (keyString.matches(".*\\.serverIP")) { // Match connection keys
                    String prefix = keyString.substring(0, keyString.lastIndexOf("."));
                    connectionPool.put(prefix, new String[] {
                            properties.getProperty(prefix + ".serverIP"),
                            properties.getProperty(prefix + ".port"),
                            properties.getProperty(prefix + ".serviceName"),
                            properties.getProperty(prefix + ".user"),
                            properties.getProperty(prefix + ".password")
                    });
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file.");
        }
    }

    /**
     * Get a connection based on the scenario name or tag.
     *
     * @param DBName The name or tag of the test scenario.
     * @return The connection details or null if not found.
     */
    public static String[] getConnectionForScenario(String DBName) {
        // Use the thread-local map for scenario-based connection retrieval
        Map<String, String[]> threadLocalMap = threadLocalConnections.get();

        // If the connection already exists in the current thread, return it
        if (threadLocalMap.containsKey(DBName)) {
            return threadLocalMap.get(DBName);
        }

        // Map scenario names to specific connection keys
        String connectionKey = switch (DBName) {
            case "AUTHENTICATION_DB_CIT" -> "AUTHENTICATION_DB_CIT";
            case "TRANSFER_DB_CIT" -> "TRANSFER_DB_CIT";
            case "LIMIT_MANAGEMENT_DB_CIT" -> "LIMIT_MANAGEMENT_DB_CIT";
            default -> throw new RuntimeException("No database configuration found for scenario: " + DBName);
        };

        // Add the connection details to the thread-local map and return it
        String[] connectionDetails = connectionPool.get(connectionKey);
        threadLocalMap.put(DBName, connectionDetails);
        return connectionDetails;
    }

    /**
     * Clear the thread-local connections after test execution.
     */
    public static void clearThreadLocalConnections() {
        threadLocalConnections.remove();
    }

    public static void dataBaseConnection(String serverIP, String port, String serviceName, String user, String password) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@" + serverIP + ":" + port + "/" + serviceName + "?TNS_ADMIN=/path/to/tns", user, password);
//      or ->  con = DriverManager.getConnection("jdbc:oracle:thin:@" + serverIP + ":" + port+ "/" + serviceName, user, password);

    }

    // Method to load and replace placeholders in queries
    public static String[] loadAndPrepareQueries(String queriesFilePath, String queryKeyword, Map<String, String> placeholders) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(queriesFilePath)));
        String[] queries = content.split(";");

        for (int i = 0; i < queries.length; i++) {
            if (queries[i].contains("-- " + queryKeyword)) {
                String query = queries[i].replace("-- " + queryKeyword, "").trim();

                // Replace placeholders with actual values
                for (Map.Entry<String, String> entry : placeholders.entrySet()) {
                    query = query.replace("${" + entry.getKey() + "}", entry.getValue());
                }
                queries[i] = query;
            } else {
                queries[i] = null; // Ignore non-matching queries
            }
        }


        return queries;
    }


    public static void executePreparedQueries(String queriesFilePath, String queryKeyword, Map<String, String> placeholders) throws SQLException, IOException {
        String[] queries = loadAndPrepareQueries(queriesFilePath, queryKeyword, placeholders);

        for (String query : queries) {

            if (query != null && !query.isBlank()) {
                System.out.println(query);
                try (PreparedStatement stmt = con.prepareStatement(query)) {
                    System.out.println("Query"+query);
                    stmt.executeUpdate();
                }
            }
        }
    }


    public void closeDataBaseConnection() throws SQLException {
        con.close();
    }
}
