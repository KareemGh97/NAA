package TestBases;

import Utilities.Reader.DataReaderManager;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;

public class ConfigurationManager {

    public HashMap<String, Object> createBrowserStackOptions(String platformName, String environment, String version, String featureFileName, String scenarioName, String app, String retry) {
        HashMap<String, Object> browserstackOptions = new HashMap<>();
        browserstackOptions.put("userName", DataReaderManager.getValue("BrowserStackCredentials", "browserstackUser"));
        browserstackOptions.put("accessKey", DataReaderManager.getValue("BrowserStackCredentials", "browserstackKey"));
        browserstackOptions.put("projectName", version + " - " + System.getProperty("user.name") + " - " + environment.toUpperCase() + " " + platformName +" ID: "+ TestBase.BrowserStack_ID );
        browserstackOptions.put("buildName", featureFileName);
        browserstackOptions.put("sessionName", retry + " - " + scenarioName);
        browserstackOptions.put("interactiveDebugging", "true");
        browserstackOptions.put("video", "true");
        browserstackOptions.put("networkLogs", "false");
        browserstackOptions.put("geoLocation", "SA");
        browserstackOptions.put("deviceLogs", "true");
        browserstackOptions.put("appiumVersion", "2.6.0");
        browserstackOptions.put("idleTimeout", 60);
        browserstackOptions.put("midSessionInstallApps", new String[]{app});
        browserstackOptions.put("gpsLocation", "24.7136,46.6753");
        browserstackOptions.put("appiumLogs", true); // Reset appium logs
        browserstackOptions.put("debug", true); // screenshot in logs

        return browserstackOptions;
    }
    public HashMap<String, Object> CreateAppiumOptions(String automationName, String app, String language, String locale, String platformVersion, String deviceName) {

        HashMap<String, Object> appiumOptions = new HashMap<>();
        appiumOptions.put("automationName", automationName);
        appiumOptions.put("deviceOrientation", "portrait");
        appiumOptions.put("app", app);
        appiumOptions.put("enforceXPath1", true);
        appiumOptions.put("language", language);
        appiumOptions.put("locale", locale); // Locale for Saudi Arabia

        appiumOptions.put("platformVersion", platformVersion);
        appiumOptions.put("deviceName", deviceName);

        return appiumOptions;
    }
    public DesiredCapabilities createDesiredCapabilities(String platformName, HashMap<String, Object> browserstackOptions, HashMap<String,Object> appiumOptions) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("bstack:options", browserstackOptions);
        capabilities.setCapability("appium:options", appiumOptions);
        return capabilities;
    }
    public static ZonedDateTime dateTime (){
        long timestamp = System.currentTimeMillis();
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault());
    }
}
