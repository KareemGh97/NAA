package Screens.customerOnBoardingScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class FastOnboardingScreen extends ScreenBase {
    public FastOnboardingScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Great News!\"]")
    @iOSXCUITFindBy(accessibility = "Great News!")
    public WebElement fastOnboardingWelcomeTitle;
    @AndroidFindBy(className = "android.widget.Button")
    @iOSXCUITFindBy(accessibility  = "Proceed to Fast Onboarding")
    public WebElement fastOnboardingBtn;
    @AndroidFindBy(xpath = "//android.webkit.WebView[@text=\"On Boarding\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Username\"]")
    public WebElement rajhiOnlineUsername;
    @AndroidFindBy(xpath = "//android.webkit.WebView[@text=\"On Boarding\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText\n")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Password\"]")
    public WebElement rajhiOnlinePassword;
    @AndroidFindBy(className = "android.widget.Button")
    @iOSXCUITFindBy(xpath  = "//XCUIElementTypeButton[@name=\"Login\"]")
    public WebElement loginBtn;

    public void tapOnFastOnboardingBtn(){tapOn(fastOnboardingBtn);
        }
    public void loginToAlrajhiOnline(String username,String password){
        typingTextIn(rajhiOnlineUsername,username);
        typingTextIn(rajhiOnlinePassword,password);
        tapOn(loginBtn);
    }
}
