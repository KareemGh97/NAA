package Screens.homeScreen;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.WebElement;

import java.util.List;

public class OTPScreen extends ScreenBase {


    public OTPScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "className(\"android.widget.Button\").childSelector(className(\"android.view.ViewGroup\"))")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton'")
    public List<WebElement> otpEt;
    @AndroidFindBy(className = "com.horcrux.svg.SvgView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"The code you entered was invalid. You have 2 more attempts.\"])[1]")
    public WebElement errorMessage;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.ResetPinCodeScreen:PageMainTitle-HeaderText\")")
    @iOSXCUITFindBy(accessibility = "CardActions.ResetPinCodeScreen:PageMainTitle-HeaderText")
    public WebElement pinCodeScreenHeader;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[@name=\"more\"]")
    public WebElement moreKey;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"One Time Password\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Enter the code you recieved via SMS\"]")
    public WebElement oneTimePasswordScreenTitle;
    @AndroidFindBy(xpath = "//android.webkit.WebView[@text=\"On Boarding\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"On Boarding\"]/XCUIElementTypeTextField[1]")
    public WebElement otpEtFastOnboarding;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"On Boarding\"]/XCUIElementTypeTextField[2]")
    public WebElement otpEtSecOnboarding;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"On Boarding\"]/XCUIElementTypeTextField[3]")
    public WebElement otpEtThirdOnboarding;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"On Boarding\"]/XCUIElementTypeTextField[4]")
    public WebElement otpEtFourthOnboarding;

    public void userEnterOtp(String otp) {
        useNativeKeyboard(otp);
    }

    public void userTapOnMore() {
        tapOn(moreKey);
    }

    public void userEnterPin(String pin) {
        useNativeKeyboard(pin);
    }

    public void userEnterOtpMultipleTimes(String otp, int times) {
        waitUntilElementsAppear(otpEt, 15);
        for (int i = 0; i < times; i++) {
            tapOn(otpEt.get(0));
            useNativeKeyboard(otp);
        }
    }

    public void tapOnPinCodeScreenHeader() {
        tapOn(pinCodeScreenHeader);
    }

    public void tapOnotpEtFastOnboarding() {
        tapOn(otpEtFastOnboarding);
    }

    public void tapOnotpEtSecOnboarding() {
        tapOn(otpEtSecOnboarding);
    }

    public void tapOnotpEtThirdOnboarding() {
        tapOn(otpEtThirdOnboarding);
    }

    public void tapOnotpEtFourthOnboarding() {
        tapOn(otpEtFourthOnboarding);
    }
}
