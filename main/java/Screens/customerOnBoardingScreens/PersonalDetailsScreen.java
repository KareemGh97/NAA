package Screens.customerOnBoardingScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class PersonalDetailsScreen extends ScreenBase {
    public PersonalDetailsScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.ConfirmPersonalDetailsScreen:AddAddress\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.ConfirmPersonalDetailsScreen:AddAddress")
    public WebElement AddressBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.ConfirmPersonalDetailsScreen:EmailInput-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.ConfirmPersonalDetailsScreen:EmailInput-Pressable")
    public WebElement emailExternalEt;

//    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"Onboarding.ConfirmPersonalDetailsScreen:EmailInput-TextInput\"]")
//    @iOSXCUITFindBy(accessibility = "Onboarding.ConfirmPersonalDetailsScreen:EmailInput-Pressable")
//    public WebElement emailEt;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.ConfirmDetails:ContinueButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.ConfirmDetails:ContinueButton-Button-Pressable")
    public WebElement ContinueBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Personal details\"]")
    @iOSXCUITFindBy(accessibility = "Personal details")
    public WebElement PersonalDetailsTitle;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"Onboarding.ConfirmPersonalDetailsScreen:EmailInput-TextInput\"]")
    @iOSXCUITFindBy(accessibility = "Onboarding.ConfirmPersonalDetailsScreen:EmailInput-Pressable")
    public WebElement emailEt;




    public void clickOnAddress(){
        tapOn(AddressBtn);
    }

    public void enterUserEmail (String email){
        tapOn(emailExternalEt);
        retryWaitElement(emailEt);
        typingTextIn(emailEt,email);
        pressEnter();
        tapOn(PersonalDetailsTitle);
    }

    public void confirmPersonalInformation(){
        tapOn(ContinueBtn);
    }

}
