package newDesignScreens.Onboarding;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class onboardingScreen extends ScreenBase {
    public onboardingScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IqamaInputScreen:PhoneNumberInput->InputBox\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IqamaInputScreen:PhoneNumberInput->InputBox")
    public WebElement phoneNumberBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IqamaInputScreen:PhoneNumberInput\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IqamaInputScreen:PhoneNumberInput->InputBox")
    public WebElement phoneNumberEt;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"Onboarding.IqamaInputScreen:NationalIdInput\").className(\"android.widget.EditText\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IqamaInputScreen:NationalIdInput")
    public WebElement nationalIdEt;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IqamaInputScreen:ContinueButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IqamaInputScreen:ContinueButton-Button-Pressable")
    public WebElement continueBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IqamaInputScreen:MobileAndNationalIdForm-RegisterMessage-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IqamaInputScreen:MobileAndNationalIdForm-RegisterMessage-View")
    public WebElement registerMessage;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(22)")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"The details don’t match our records. Check carefully and try again.\"]")
    public WebElement errorMessageTxt;


    public String getErrorMsgText(WebElement element)
    {
        return getText(element);
    }

    public void enterUserCredentials(String phoneNumber, String id){
//        retryWaitElement(phoneNumberBtn);
        enterPhoneNumber(phoneNumber);
        enterID(id);
        clickConfirmButton();
    }

    public void enterPhoneNumber(String phoneNumber){
        tapOn(phoneNumberBtn);
        typingTextIn(phoneNumberEt,phoneNumber);
    }
    public void enterID(String id){
        typingTextIn(nationalIdEt,id);
    }
    public void clickConfirmButton(){
        tapOn(continueBtn);
    }
}
