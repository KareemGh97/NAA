package Screens.customerOnBoardingScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


import org.openqa.selenium.WebElement;


import java.util.List;

import java.util.stream.Collectors;

public class PassCodeScreen extends ScreenBase {


    public PassCodeScreen (AppiumDriver appiumDriver){
        super(appiumDriver);
    }

//    @AndroidFindBy()
//    @iOSXCUITFindBy(iOSNsPredicate ="name ENDSWITH 'PasscodeScreen:NavHeader-BackButton'")
//    public WebElement backBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*NumberPad-NumPad-Button-1\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'NumberPad-NumPad-Button-1'")
    public WebElement oneBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*NumberPad-NumPad-Button-2\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'NumberPad-NumPad-Button-2'")
    public WebElement twoBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*NumberPad-NumPad-Button-3\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'NumberPad-NumPad-Button-3'")
    public WebElement threeBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*NumberPad-NumPad-Button-4\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'NumberPad-NumPad-Button-4'")
    public WebElement fourBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*NumberPad-NumPad-Button-5\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'NumberPad-NumPad-Button-5'")
    public WebElement fiveBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*NumberPad-NumPad-Button-6\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'NumberPad-NumPad-Button-6'")
    public WebElement sixBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*NumberPad-NumPad-Button-7\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'NumberPad-NumPad-Button-7'")
    public WebElement sevenBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*NumberPad-NumPad-Button-8\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'NumberPad-NumPad-Button-8'")
    public WebElement eightBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*NumberPad-NumPad-Button-9\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'NumberPad-NumPad-Button-9'")
    public WebElement nineBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*NumberPad-NumPad-Button-0\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'NumberPad-NumPad-Button-0'")
    public WebElement zeroBtn;



    // Type of signIn OneTime or register device
    @AndroidFindBy(uiAutomator="resourceId(\"SignIn.PasscodeScreen:SignInByDeviceStatusModal-HandleSignInButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SignIn.PasscodeScreen:SignInByDeviceStatusModal-HandleSignInButton-Pressable")
    public WebElement registerDeviceBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"SignIn.PasscodeScreen:SignInByDeviceStatusModal-OneTimeUseButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SignIn.PasscodeScreen:SignInByDeviceStatusModal-OneTimeUseButton-Pressable")
    public WebElement oneTimeUseBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Confirm password\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Onboarding.ConfirmPasscodeScreen:PasscodeInput-Title\"]")
    public WebElement confirmPasscodeScreen;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup")
    @iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'PasscodeScreen:PasscodeInput-Alert'")
    public WebElement errorMessageTxt;
    @AndroidFindBy(uiAutomator = "resourceId(\"SignIn.PasscodeScreen:signOut\")")
    @iOSXCUITFindBy(accessibility = "SignIn.PasscodeScreen:signOut")
    public WebElement signOutBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"SignIn.ConfirmPasscodeScreen:goBackButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SignIn.ConfirmPasscodeScreen:goBackButton-Pressable")
    public WebElement passcodeBackBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"SignIn.CreatePasscodeScreen:ErrorMessagePopup\")")
    @iOSXCUITFindBy(accessibility = "SignIn.CreatePasscodeScreen:ErrorMessagePopup")
    public WebElement errorPasscodeMessagePopup;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Passcode you entered doesn't match, try again.\"]")
    @iOSXCUITFindBy(xpath ="(//XCUIElementTypeOther[@name=\"Passcode you entered doesn't match, try again.\"])[1]")
    public WebElement errorMissMatchPasscodeMessagePopup;
    @AndroidFindBy(uiAutomator = "resourceId(\"SignIn.PasscodeScreen:PasscodeInput\")")
    @iOSXCUITFindBy(accessibility = "Enter your passcode to log in.")
    public WebElement enterPasscodeLabel;
    @AndroidFindBy(uiAutomator = "resourceId(\"SignIn.PasscodeScreen:forgotPasswordText\")")
    @iOSXCUITFindBy(accessibility = "SignIn.PasscodeScreen:forgotPasswordText")
    public WebElement forgetPasscodeLabel;
    @AndroidFindBy(uiAutomator = "resourceId(\"SignIn.CardPinScreen:InputForgotCardPin\")")
    @iOSXCUITFindBy(accessibility = "SignIn.CardPinScreen:InputForgotCardPin")
    public WebElement forgetCardPinCode;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Confirm PIN\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Confirm PIN\"]")
    public WebElement confirmPINLabel;

    public void userEnterPassCode(String passCode)  {
        try {
            List<Integer> passCodeList = convertStringToListOfIntegers(passCode);
            for (int item : passCodeList) {
                Thread.sleep(1000);
                switch (item) {
                    case 0 -> tapOn(zeroBtn);
                    case 1 -> tapOn(oneBtn);
                    case 2 -> tapOn(twoBtn);
                    case 3 -> tapOn(threeBtn);
                    case 4 -> tapOn(fourBtn);
                    case 5 -> tapOn(fiveBtn);
                    case 6 -> tapOn(sixBtn);
                    case 7 -> tapOn(sevenBtn);
                    case 8 -> tapOn(eightBtn);
                    case 9 -> tapOn(nineBtn);
                }
            }
        } catch (Exception e) {
             throw new RuntimeException(e);
        }
    }
    public void userEnterPassCodeTimes(String passCode , int times)  {
        for (int i = 0; i < times; i++){
            ScreenBase.ThreadSleep(3000);
            userEnterPassCode(passCode);
        }
    }
    public void userChooseOneTimeUse(){tapOn(oneTimeUseBtn);
    }
    public void UserChooseRegisterDevice() {tapOn(registerDeviceBtn);
    }
    public void userCloseBottomSheet() {
        tapOn(oneTimeUseBtn);}

    // this to convert passCode From string data type to list of integer
    public static List<Integer> convertStringToListOfIntegers(String str) {
        return str.chars()
                .mapToObj(c -> Character.getNumericValue((char) c))
                .collect(Collectors.toList());
    }
    public void clickOnPasscodeBackBtn()
    {
        tapOn(passcodeBackBtn);
    }
    public void clickOnForgetPasscodeLabel()
    {
        tapOn(forgetPasscodeLabel);
    }
    public void clickOnForgetCardPinCode()
    {
        tapOn(forgetCardPinCode);
    }

}
