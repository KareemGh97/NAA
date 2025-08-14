package TestBases;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static TestBases.TestBase.locale;

public class DriverManager {

    private static final ThreadLocal<AppiumDriver> AppiumDriver = new ThreadLocal<>();

    public static AppiumDriver getAppiumDriver() {
        return AppiumDriver.get();
    }
    public static void setDriver(AppiumDriver appiumDriver) {
        AppiumDriver.set(appiumDriver);
    }
    public static void initializeDriver(String platformName, DesiredCapabilities capabilities, String url) throws MalformedURLException {
        AppiumDriver appiumDriver;
        switch (platformName.toLowerCase()) {
            case "android" -> appiumDriver = new AndroidDriver(new URL(url), capabilities);
            case "ios" -> appiumDriver = new IOSDriver(new URL(url), capabilities);
            default -> throw new IllegalArgumentException("Unsupported platform: " + platformName);
        }
        setDriver(appiumDriver);
        if(platformName.equalsIgnoreCase("ios")&& TestBase.deployment.equalsIgnoreCase("cloud"))
        {
            DriverManager.restartApp();//to relaunch ios-app
        }
    }

    public static void quitDriver() {
        System.out.println("in closeMobileApp()------------------------ " + locale);
        if (getAppiumDriver() != null) {
            getAppiumDriver().quit();
            AppiumDriver.remove();
        }
    }

    public static void restartApp (){
        switch (getAppiumDriver().getCapabilities().getPlatformName()) {
            case ANDROID -> {
                ((AndroidDriver) AppiumDriver.get()).activateApp("com.croatia.consumerapp.sit");
                ((AndroidDriver) getAppiumDriver()).rotate(ScreenOrientation.PORTRAIT);
            }
            case IOS ->
                    AppiumDriver.get().execute("activateApp", ImmutableMap.of("appId",getAppiumDriver().getCapabilities().getCapability("bundleId")));

            default -> System.out.println("Wrong platform Name");
        }
    }
}
