package Screens.customerOnBoardingScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class NafathScreen extends ScreenBase {
    public NafathScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"^.*SelectNafathAppButton*$\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'SelectNafathAppButton'")
    public WebElement nafathAppBt;

    @AndroidFindBy(className = "android.widget.Button")
    @iOSXCUITFindBy(className = "XCUIElementTypeButton")
    public WebElement openNafathAppBt;

    @AndroidFindBy(uiAutomator = "resourceId(\"android:id/button1\")")
    @iOSXCUITFindBy(accessibility = "App Store")
    public WebElement installNafathBt;


    public void clickOnNafathAppButton() {
        tapOn(nafathAppBt);
    }

    public void clickOnNafath() {
        tapOn(openNafathAppBt);
        tapOn(installNafathBt);
    }


    public void completeNafathJourney() {
        tapOn(nafathAppBt);
        tapOn(openNafathAppBt);
        tapOn(installNafathBt);

    }
}
