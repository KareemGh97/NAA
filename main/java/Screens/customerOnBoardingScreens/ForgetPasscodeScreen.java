package Screens.customerOnBoardingScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class ForgetPasscodeScreen extends ScreenBase {

    public ForgetPasscodeScreen(AppiumDriver appiumDriver){
        super(appiumDriver);
    }
    @AndroidFindBy(uiAutomator = "resourceId(\"SignIn.ForgotPassword:MobileAndNationalIdForm-PhoneNumberInput->InputBox\")")
    @iOSXCUITFindBy(accessibility = "SignIn.ForgotPassword:MobileAndNationalIdForm-PhoneNumberInput->InputBox")
    public WebElement forgotPasswordMobileField;
    @AndroidFindBy(uiAutomator = "resourceId(\"SignIn.ForgotPassword:MobileAndNationalIdForm-PhoneNumberInput->InputBox\").childSelector(className(\"android.widget.EditText\"))")
    @iOSXCUITFindBy(accessibility = "SignIn.ForgotPassword:MobileAndNationalIdForm-PhoneNumberInput->InputBox")
    public WebElement forgotPasswordMobileET;
    @AndroidFindBy(uiAutomator = "resourceId(\"SignIn.ForgotPassword:MobileAndNationalIdForm-NationalIdInput\")")
    @iOSXCUITFindBy(accessibility = "SignIn.ForgotPassword:MobileAndNationalIdForm-NationalIdInput")
    public WebElement forgotPasswordNationalField;
    @AndroidFindBy(uiAutomator = "resourceId(\"SignIn.ForgotPassword:MobileAndNationalIdForm-NationalIdInput\").childSelector(className(\"android.widget.EditText\"))")
    @iOSXCUITFindBy(accessibility = "SignIn.ForgotPassword:MobileAndNationalIdForm-NationalIdInput")
    public WebElement forgotPasswordNationalEt;
    @AndroidFindBy(uiAutomator = "resourceId(\"SignIn.ForgotPassword:MobileAndNationalIdForm-SubmitButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SignIn.ForgotPassword:MobileAndNationalIdForm-SubmitButton-Button-Pressable")
    public WebElement SubmitButton;
    public void enterValidCredentials(String mobileNumber,String nationalId){
        tapOn(forgotPasswordMobileField);
        typingTextIn(forgotPasswordMobileET,mobileNumber);
        tapOn(forgotPasswordNationalField);
        typingTextIn(forgotPasswordNationalEt,nationalId);
        tapOn(SubmitButton);
    }

}
