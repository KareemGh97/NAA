package Utilities.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static TestBases.TestBase.csvData;
import static TestBases.TestBase.environment;

public class CustomDataProvider {

    //    private static final List<String[]> testData = new CopyOnWriteArrayList<>();
    static String csvFile = environment.equals("uat")
            ? "src/test/resources/DataProvider/testData_uat.csv"
            : "src/test/resources/DataProvider/testData_sit.csv";

//    @DataProvider(name = "parallelDataProvider", parallel = true)
//    public static Object[][] parallelDataProvider() {
//        int totalThreads = 10;  // Set the number of parallel threads
//        int threadIndex = (int) (Thread.currentThread().getId() % totalThreads);
//        Object[][] data = getDataForThread(threadIndex);
//
//        // Set login data for the current thread
//        if (data.length > 0) {
//            setLoginData((String[]) data[0]);
//        }
//
//        return data;
//    }

//
//    public static List<String[]> getAllData() {
//        String environment = TestBase.environment;
//        String fileName = environment.equals("uat")
//                ? "/DataProvider/testData_uat.csv"
//                : "/DataProvider/testData_sit.csv";
//
//        List<String[]> data = new ArrayList<>();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(
//                Objects.requireNonNull(CustomDataProvider.class.getResource(fileName)).getFile()))) {
//            String line;
//            boolean firstLine = true;
//            while ((line = br.readLine()) != null) {
//                if (firstLine) {
//                    firstLine = false;
//                    continue;  // Skip header row
//                }
//                String[] split = line.split(",");
//                data.add(split);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return data;
//    }
//
//    public static Object[][] getDataForThread(int threadIndex) {
//        // Calculate the index for this thread
//        int dataIndex = threadIndex % testData.size(); // Ensure it's within bounds
//
//        // Get one row of data for the thread
//        Object[][] data = new Object[1][];
//        data[0] = testData.get(dataIndex);
//
//        return data;
//    }

    public static Object[][] readCsvData() {
        List<Object[]> data = new ArrayList<>();
        try (Reader in = new FileReader(csvFile)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            for (CSVRecord record : records) {
                // Assuming you want to read two columns, adjust as necessary
                String phoneNumberColumn = record.get("phoneNumber"); // Replace with your actual column name
                String nationalNumberColumn = record.get("nationalNumber"); // Replace with your actual column name
                String cicColumn = record.get("CIC");
                String passCodeColumn = record.get("passCode");
                String lockedColumn = record.get("Locked");
                data.add(new Object[]{phoneNumberColumn, nationalNumberColumn, cicColumn, passCodeColumn, lockedColumn});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toArray(new Object[0][]); // Convert List to Object[][]
    }

    public static void updateCsvData() {
        // Write the updated data back to the CSV
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            writer.write("phoneNumber,nationalNumber,CIC,passCode,Locked\n"); // Write header
            for (Object[] row : csvData) {
                writer.write(row[0] + "," + row[1] + "," + row[2] + "," + row[3] + "," + row[4] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}