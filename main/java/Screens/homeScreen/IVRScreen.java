package Screens.homeScreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class IVRScreen extends ScreenBase {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*IvrWaitingScreen.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*IvrWaitingScreen.*'")
    public WebElement ivr;

    public IVRScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void passIVR() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        try {
            wait.until(ExpectedConditions.invisibilityOf(ivr));
        } catch (TimeoutException e) {
            throw new AssertionError("IVR overlay did not disappear after 50 seconds.", e);
        }
    }
}
