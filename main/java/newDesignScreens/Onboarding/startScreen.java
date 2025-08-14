package newDesignScreens.Onboarding;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class startScreen extends ScreenBase {

    public startScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.UnifiedIqamaInputScreen:NavHeader-BackButton\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.UnifiedIqamaInputScreen:NavHeader-BackButton")
    public WebElement backBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IqamaInputScreen:PhoneNumberInput->InputBox\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IqamaInputScreen:PhoneNumberInput->InputBox")
    public WebElement phoneNumberET;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IqamaInputScreen:NationalIdInput\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IqamaInputScreen:NationalIdInput")
    public WebElement nationalIqamaIdET;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IqamaInputScreen:MobileAndNationalIdForm-RegisterMessage-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IqamaInputScreen:MobileAndNationalIdForm-RegisterMessage-View")
    public WebElement hint;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IqamaInputScreen:ContinueButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IqamaInputScreen:ContinueButton-Button-Pressable")
    public  WebElement continueBtn;
    public void enterPhoneNumber(String phoneNumber){
        typingTextIn(phoneNumberET,phoneNumber);
    }
    public void enterNationalIqamaId(String id){
        typingTextIn(nationalIqamaIdET,id);
    }
    public void ClickContinue(){
        tapOn(continueBtn);
    }
    public void getHintText(){
        hint.getText();
    }
    public void clickBack(){
        tapOn(backBtn);
    }




}
