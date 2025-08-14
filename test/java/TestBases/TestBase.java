package TestBases;

import Screens.homeScreen.ScreenBase;
import Utilities.AppManager.BrowserStackUploader;
import Utilities.AppManager.BuildDownloader;
import Utilities.AppManager.FirebaseClient;
import Utilities.AppManager.PropertiesManager;
import Utilities.DeviceManager.CloudDeviceManager;
import Utilities.DeviceManager.LocalDeviceManager;
import Utilities.Reader.DataReaderManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

import java.net.URL;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.testng.annotations.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static Utilities.DeviceManager.CloudDeviceManager.selectedCloudDevice;
import static TestBases.DriverManager.*;
import static Utilities.DeviceManager.LocalDeviceManager.selectedLocalDevice;
import static Utilities.Reader.CustomDataProvider.readCsvData;
import static Utilities.Reader.CustomDataProvider.updateCsvData;
import static Utilities.commonClasses.AppConstants.connectedDeviceList;

public class TestBase extends AbstractTestNGCucumberTests {

    public static Map<String, String> failedScreenshot = new ConcurrentHashMap<>();
    public static ThreadLocal<String> scenarioId =  ThreadLocal.withInitial(String::new);

    public static boolean JiraDefectCreation = false;
    public static boolean UploadExecutionResult = false;

    public static String BrowserStack_ID = UUID.randomUUID().toString().replace("-", "").substring(0, 4); // 4 characters;
    public static String retry = "";
    public static String version = "";
    public static String deployment;
    public static String environment;
    public static String executionCycle;
    public static String platformName;
    public static String automationName;
    public static String udid;
    public static String language;
    public static String url;
    public static String port;
    public static String app;
    public static String locale;
    UiAutomator2Options androidOptions;
    XCUITestOptions iosOptions;
    public static String appPathAndroid;
    public static String appPathIos;
    public static ThreadLocal<Object[]> data = new ThreadLocal<>();
    public static Object[][] csvData;


    @Parameters({"deployment", "environment", "platformName", "automationName", "udid", "language", "url", "port", "locale"})
    @BeforeTest
    public void beforeAll(String deployment, String environment, String platformName, String automationName,
                          String udid, String language, String url, String port, String locale) throws IOException {

        System.out.println("Start time: " + ConfigurationManager.dateTime().toString().substring(11, 19));

        // Load configuration settings
        JiraDefectCreation = Boolean.parseBoolean(DataReaderManager.readConfigXml("JiraDefectCreation"));
        UploadExecutionResult = Boolean.parseBoolean(DataReaderManager.readConfigXml("UploadExecutionResult"));

        // Assign environment variables to TestBase
        TestBase.deployment = deployment;
        ScreenBase.deployment = deployment;
        TestBase.platformName = platformName;
        TestBase.automationName = automationName;
        TestBase.udid = udid;
        TestBase.language = language;
        TestBase.url = url;
        TestBase.port = port;
        TestBase.locale = locale;
        TestBase.environment = environment;
        PropertiesManager propsManager = new PropertiesManager();
        FirebaseClient firebaseClient = new FirebaseClient("google/serviceAccount/croatia-93478-41aa93be2758.json");

        // Determine a deployment type and set the application source
        if ("cloud".equalsIgnoreCase(deployment)) {
            BrowserStackUploader uploader = new BrowserStackUploader(propsManager, firebaseClient);

            TestBase.app = uploader.uploadToBrowserStack(platformName.toLowerCase(), environment.toLowerCase());
            //TestBase.app="bs://76425af08639335fa091d6289c26813d4aff29c6";
            // Generate and store build ID
            try {
                String projectName = String.format("%s - %s - %s %s ID: %s",
                        version,
                        System.getProperty("user.name"),
                        environment.toUpperCase(),
                        platformName,
                        TestBase.BrowserStack_ID);

                if (System.getProperty("user.name").equalsIgnoreCase("jenkins"))
                    Files.write(Paths.get("BuildKey.txt"), projectName.getBytes(),
                            StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING); //todo local devise AI analyzer
            } catch (IOException e) {
                System.err.println("Error writing BuildKey.txt: " + e.getMessage());
                e.printStackTrace();
            }

        } else if("local".equalsIgnoreCase(deployment)){
            if (connectedDeviceList.isEmpty()) {
                LocalDeviceManager.getLocalConnectedDevices(); // Fetch all locally connected iOS and Android devices
            }

            BuildDownloader Downloader = new BuildDownloader(propsManager, firebaseClient);
            TestBase.app =  "/"+Downloader.downloadBuild(platformName.toLowerCase(), environment.toLowerCase());
        }
        // Read CSV data
        csvData = readCsvData();
    }

    public void startMobileApp(String scenarioName, String featureFileName) throws IOException {
        switch (deployment) {
            case "Local" -> {
                LocalDeviceManager.randomlySelectDevice(connectedDeviceList); // select a devise from the list
                platformName = selectedLocalDevice.get().getPlatformName();// update the platform name from the selectedLocalDevice list

                switch (platformName) {
                    case "Android" -> {
                        androidOptions = new UiAutomator2Options()
                                .setPlatformName(platformName)
                                .setIgnoreHiddenApiPolicyError(true)
                                .setAllowTestPackages(true)
                                .setUdid(selectedLocalDevice.get().getUdid())
                                .setDeviceName(selectedLocalDevice.get().getDeviceName())
                                .setPlatformVersion(selectedLocalDevice.get().getPlatformVersion())
                                .setAutoGrantPermissions(true)
                                .enablePerformanceLogging()
                                .setFullReset(true)
                                .setLanguage(language)
                                .setClearDeviceLogsOnStart(true)
                                .setApp(System.getProperty("user.dir") + app)
                                .setNoReset(false)
                                .setDisableWindowAnimation(true)
                                .setAppWaitDuration(Duration.ofSeconds(30))
                                .eventTimings();

                        androidOptions.setCapability("enforceXPath1", true);

                        setDriver(new AndroidDriver(new URL(url + port), androidOptions));
                        appPathAndroid = (String) getAppiumDriver().getCapabilities().getCapability("app");
                    }
                    case "iOS" -> {
                        iosOptions = new XCUITestOptions()
                                .setPlatformName(platformName)
                                .setUdid(selectedLocalDevice.get().getUdid())
                                .setDeviceName(selectedLocalDevice.get().getDeviceName())
                                .setPlatformVersion(selectedLocalDevice.get().getPlatformVersion())
                                .setBundleId("com.neraapp.ksa.uat")
                                .setLocale(locale)
                                .setLanguage(language);

                        iosOptions.setCapability("enforceXPath1", true);
                        iosOptions.setCapability("xcodeOrgId", "E9L4734HKJ");
                        iosOptions.setCapability("xcodeSigningId", "iPhone Developer");
                        iosOptions.setCapability("updatedWDABundleId", "com.Rahaf.WebDriverAgentRunner");

                        setDriver(new IOSDriver(new URL(url + port), iosOptions));
                        appPathIos = (String) getAppiumDriver().getCapabilities().getCapability("app");
                    }
                    default -> throw new IllegalArgumentException("Unsupported platform: " + platformName);
                }
            }
            case "Cloud" -> {
                CloudDeviceManager.selectDeviceType(platformName);
                ConfigurationManager configManager = new ConfigurationManager();
                HashMap<String, Object> browserStackOptions = configManager.createBrowserStackOptions(platformName, environment, version, featureFileName, scenarioName, app, retry);
                HashMap<String, Object> appiumOptions = configManager.CreateAppiumOptions(automationName, app, language, locale, selectedCloudDevice.get()[1], selectedCloudDevice.get()[0]);
                DesiredCapabilities capabilities = configManager.createDesiredCapabilities(platformName, browserStackOptions, appiumOptions);
                DriverManager.initializeDriver(platformName, capabilities, url);
            }
            default -> throw new IllegalArgumentException("Unsupported deployment: " + deployment);
        }
        retry = "";

        getAppiumDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // allure report annotation to log scenario steps in allure report
    @Step("{step}")
    public static void logStep(String step) {
        Allure.step(step);
    }

    @AfterMethod
    public void releaseDevices() {
        updateCsvData();
    }

    @AfterTest
    public void afterAll() {
        System.out.println("finish time " + ConfigurationManager.dateTime().toString().substring(11, 19));
    }

    public boolean isLocalDeployment() {
        return TestBase.deployment.equalsIgnoreCase("local");
    }
    public boolean isCloudDeployment() {
        return TestBase.deployment.equalsIgnoreCase("cloud");
    }

}