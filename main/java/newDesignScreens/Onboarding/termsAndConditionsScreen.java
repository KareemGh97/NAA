package newDesignScreens.Onboarding;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class termsAndConditionsScreen extends ScreenBase {
    public termsAndConditionsScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.TermsAndConditionsScreen:HeaderTitle\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.TermsAndConditionsScreen:HeaderTitle")
    public WebElement termsAndConditionsScreen;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.TermsAndConditionsScreen:isTermsCheckedCheckbox\")")
//    @iOSXCUITFindBy(tagName = "Onboarding.TermsAndConditionsScreen:isTermsCheckedCheckbox")//no accessibility id
    @iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'isTermsCheckedCheckbox'")//no accessibility id
    public WebElement termsAndConditionsCheckBox;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.TermsAndConditionsScreen:isSamaConsentCheckedCheckbox\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'Onboarding.TermsAndConditionsScreen:isSamaConsentCheckedCheckbox'")
    public WebElement samaTermsAndConditionsCheckBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']/preceding::android.view.ViewGroup[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"Privacy Policy\"`][1]/XCUIElementTypeOther[2]/XCUIElementTypeOther")
    public WebElement PrivacyPolicy;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.TermsAndConditionsScreen:ContinueButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.TermsAndConditionsScreen:ContinueButton-Pressable")//no accessibility id
    public WebElement TermsAndConditionsContinueButton;

    @AndroidFindBy(uiAutomator = "resourceId(\"android:id/button1\")")
    @iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeButton[`name == \"OK\"`]")
    public WebElement SimaCheckConsentFlag;

    public void clickOnTermsAndConditionsContinueButton (){
        tapOn(SimaCheckConsentFlag);
        tapOn(TermsAndConditionsContinueButton);
    }
    public void chickTermsAndConditions (){
        tapOn(termsAndConditionsCheckBox);
    }
    public void chickSamaTermsAndConditions (){
        tapOn(samaTermsAndConditionsCheckBox);
    }
    public void chickPrivacyPolicy (){
        tapOn(PrivacyPolicy);
    }
}
