package newDesignScreens.Onboarding;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class passcodeScreen extends ScreenBase {
    public passcodeScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    @AndroidFindBy(uiAutomator = "resourceId(\"SignIn.PasscodeScreen:NavHeader-BackButton\")")
    @iOSXCUITFindBy(accessibility = "SignIn.PasscodeScreen:NavHeader-BackButton")
    public WebElement backBtn;

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

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*NumberPad-NumPad-Button-FaceIdButton\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'NumberPad-NumPad-Button-FaceIdButton'")
    public  WebElement faceIdIcon;
    @AndroidFindBy(uiAutomator = "resourceId(\"SignIn.PasscodeScreen:NumberPad-NumPad-Button-RemoveButton\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'NumberPad-NumPad-Button-RemoveButton'")
    public WebElement removeIcon;

    @AndroidFindBy(uiAutomator = "resourceId(\"SignIn.PasscodeScreen:forgotPasswordText\")")
    @iOSXCUITFindBy(accessibility = "SignIn.PasscodeScreen:forgotPasswordText")
    public WebElement forgetPassword;

    public void clickBack(){
        tapOn(backBtn);
    }
    public void userEnterPassCode(String passCode) {
        List<Integer> passCodeList = convertStringToListOfIntegers(passCode);
        for (int item:passCodeList){
            switch (item)
            {
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
    }
    public static List<Integer> convertStringToListOfIntegers(String str) {
        return str.chars()
                .mapToObj(c -> Character.getNumericValue((char) c))
                .collect(Collectors.toList());
    }
    public void clickRemove(){
        tapOn(removeIcon);
    }
    public void clickFaceId() {
        tapOn(faceIdIcon);
    }
    public void clickForgetPassword(){
        tapOn(forgetPassword);
    }












}
