package newDesignScreens.Onboarding;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class appIntroductionScreen extends ScreenBase {
    public appIntroductionScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\")")
    @iOSXCUITFindBy(accessibility = "Allow While Using App")
    public WebElement allowLocationWhileUsingTheAppBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.WelcomeCarousel:SkipButton\")")
    @iOSXCUITFindBy(accessibility  = "Onboarding.WelcomeCarousel:SkipButton")
    public WebElement skipBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.SplashScreen:SignUpButton-Pressable\")")
    @iOSXCUITFindBy(accessibility  = "Onboarding.SplashScreen:SignUpButton-Pressable")
    public WebElement StartBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"SignIn.PasscodeScreen:signOut\")")
    @iOSXCUITFindBy(accessibility  = "SignIn.PasscodeScreen:signOut")
    public WebElement signOutPasscode;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.SplashScreen:LanguageToggle\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.SplashScreen:LanguageToggle")
    public  WebElement languageBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.ChangeLanguageModal:RestartButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Settings.ChangeLanguageModal:RestartButton-Pressable")
    public WebElement restartNowBtnBottomSheet;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.ChangeLanguageModal:CancelButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Settings.ChangeLanguageModal:CancelButton-Pressable")
    public WebElement cancelBtnBottomSheet;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.WelcomeCarouselScreen:NextButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.WelcomeCarouselScreen:NextButton-Pressable")
    public WebElement getStartedBtn;

    public void allowLocationPermissionIfAppears() {
        try {
            waitUntilElementAppear(allowLocationWhileUsingTheAppBtn, 20);
            tapOn(allowLocationWhileUsingTheAppBtn);
        }catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException  ignored)
        {

        }
    }

    public void completeAppIntro(){
        int maxScrolls = 10;
        int scrollCount = 0;

        while(!isDisplayed(getStartedBtn) && scrollCount < maxScrolls) {
            horizontalScrollOnScreen(0.9, 0.1);
            scrollCount++;
        }
        tabOnGetStartedBtn();
    }

    public void tapOnStartBtn(){
        tapOn(StartBtn);
    }
    public void tabOnSignOutPasscode(){
        tapOn(signOutPasscode);
    }
    public void tabOnGetStartedBtn(){
        tapOn(getStartedBtn);
    }
    public void changeLanguage(){
        tapOn(languageBtn);
        tapOn(restartNowBtnBottomSheet);
    }
    public void cancelChangeLanguage(){
        tapOn(languageBtn);
        tapOn(cancelBtnBottomSheet);
    }
}
