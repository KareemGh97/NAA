package newDesignScreens.Onboarding;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class congratulationsEligibleToUseTheAppScreen extends ScreenBase {
    public congratulationsEligibleToUseTheAppScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath ="//android.widget.TextView[@text=\"Continue\"]")
    @iOSXCUITFindBy(accessibility = "Continue")
    public WebElement congratsContinueBtn;

    public void continueOnboarding(){
        tapOn(congratsContinueBtn);
    }

}
