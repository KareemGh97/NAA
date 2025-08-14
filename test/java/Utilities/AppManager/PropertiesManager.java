package Utilities.AppManager;

import java.io.*;
import java.util.Properties;

public class PropertiesManager {
    private static final String LOCAL_BUILDS_PATH = "src/main/java/properties/Builds/LocalBuilds.properties";
    private static final String BROWSERSTACK_BUILDS_PATH = "src/main/java/properties/Builds/BrowserStackBuilds.properties";
    private static final String CREDENTIALS_PATH = "src/main/java/properties/BrowserStackCredentials.properties";

    public String getLocalBuildVersion(String environment, String platform) throws IOException {
        return getProperty(LOCAL_BUILDS_PATH, buildKey(environment, platform, "AppVersion"));
    }

    public String getBrowserStackBuildVersion(String environment, String platform) throws IOException {
        return getProperty(BROWSERSTACK_BUILDS_PATH, buildKey(environment, platform, "AppVersion"));
    }

    public String getBrowserStackAppUrl(String environment, String platform) throws IOException {
        return getProperty(BROWSERSTACK_BUILDS_PATH, buildKey(environment, platform, "AppUrl"));
    }

    public String getBrowserStackUsername() throws IOException {
        return getProperty(CREDENTIALS_PATH, "browserstackUser");
    }

    public String getBrowserStackKey() throws IOException {
        return getProperty(CREDENTIALS_PATH, "browserstackKey");
    }

    public void updateLocalBuildVersion(String environment, String platform, String version) throws IOException {
        updateProperty(LOCAL_BUILDS_PATH, buildKey(environment, platform, "AppVersion"), version);
    }

    public void updateBrowserStackBuild(String environment, String platform, String version, String appUrl) throws IOException {
        Properties props = loadProperties(BROWSERSTACK_BUILDS_PATH);
        props.setProperty(buildKey(environment, platform, "AppVersion"), version);
        props.setProperty(buildKey(environment, platform, "AppUrl"), appUrl);
        saveProperties(BROWSERSTACK_BUILDS_PATH, props);
    }

    private String buildKey(String environment, String platform, String suffix) {
        return environment.toLowerCase() + "-" + platform.toLowerCase() + suffix;
    }

    private String getProperty(String filePath, String key) throws IOException {
        Properties props = loadProperties(filePath);
        return props.getProperty(key);
    }

    private void updateProperty(String filePath, String key, String value) throws IOException {
        Properties props = loadProperties(filePath);
        props.setProperty(key, value);
        saveProperties(filePath, props);
    }

    private Properties loadProperties(String filePath) throws IOException {
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream(filePath)) {
            props.load(in);
        }
        return props;
    }

    private void saveProperties(String filePath, Properties props) throws IOException {
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            props.store(out, null);
        }
    }
}