package Suites.Local;

import Utilities.DeviceManager.LocalDeviceManager;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static Utilities.commonClasses.AppConstants.connectedDeviceList;

public class TestNGRunner {
    public static void main(String[] args) throws IOException {

        TestNG testng = new TestNG();

        String executionCycle = System.getProperty("executionCycle", "defaultCycle");
        String platformName = System.getProperty("platformName", "Android");
        String featureNameTag = System.getProperty("featureNameTag", "DefaultFeature");


        XmlSuite suite = new XmlSuite();
        suite.setName("local devises suite");

        LocalDeviceManager.getLocalConnectedDevices();

        // Set the thread-count based on the number of connected devises.
        suite.setDataProviderThreadCount(connectedDeviceList.size());
        suite.setParallel(XmlSuite.ParallelMode.TESTS);
        suite.setShareThreadPoolForDataProviders(true);

        // <test name="local test">
        XmlTest test = new XmlTest(suite);
        test.setName("local test");

        // <parameter> in testng.xml
        Map<String, String> parameters = new HashMap<>();
        parameters.put("executionCycle", executionCycle);
        parameters.put("platformName", platformName);
        parameters.put("featureNameTag", featureNameTag);
        parameters.put("deployment", "Local");
        parameters.put("port", "4723");
        parameters.put("udid", "");
        parameters.put("deviceName", "");
        parameters.put("platformVersion", "");
        parameters.put("language", "en");
        parameters.put("environment", "uat");
        parameters.put("url", "http://0.0.0.0:");
        parameters.put("automationName", "uiautomator2");
        parameters.put("locale", "en-US");

        test.setParameters(parameters);

        XmlClass testClass = new XmlClass("TestRunners.AndroidRunnerOneTest");
        test.setXmlClasses(Collections.singletonList(testClass));

        testng.setXmlSuites(Collections.singletonList(suite));
        testng.run();
    }
}

