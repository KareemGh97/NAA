package newDesignScreens.Onboarding;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class onboardingInformationScreen extends ScreenBase {
    public onboardingInformationScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IncomeDetailsScreen:SetButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IncomeDetailsScreen:SetButton-Pressable")
    public WebElement setBt;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"Onboarding.CountrySelectorScreen:TaxReferenceNumber-TextInput\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Onboarding.CountrySelectorScreen:TaxReferenceNumber-Pressable\"]")
    public WebElement TaxReferenceNumber;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Add\"]")
    public WebElement addBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.CountrySelectorScreen:CountryName-DropdownInput-ConfirmButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.CountrySelectorScreen:CountryName-DropdownInput-ConfirmButton-Pressable")
    public WebElement setTaxCountry;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.FatcaDetailsScreen:UTR\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Horizontal scroll bar, 1 page\"]")
    public WebElement UTR;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IncomeDetailsScreen:ToggleHaveAdditionalInfo\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IncomeDetailsScreen:ToggleHaveAdditionalInfo")
    public WebElement toggleHaveAdditionalInfo;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.FatcaDetailsScreen:AreYouPepText\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.FatcaDetailsScreen:AreYouPepText")
    public WebElement areYouPEPTx;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.FatcaDetailsScreen:ContinueButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.FatcaDetailsScreen:ContinueButton-Button-Pressable")
    public WebElement fatcaDetailsScreenContinueButton;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"CroatiaMobileApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
//no accessibility id
    public WebElement fullScreenContainer;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IncomeDetailsScreen:InputAdditionalIncomeType-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IncomeDetailsScreen:InputAdditionalIncomeType-View")
    public WebElement additionalIncomeType;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IncomeDetailsScreen:InputSelectAmount-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IncomeDetailsScreen:InputSelectAmount-View")
    public WebElement InputSelectAmount;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Rent\"]")
    @iOSXCUITFindBy(accessibility = "Rent")////XCUIElementTypeOther[@name="Rent"]
    public WebElement rentType;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"0 - 2,500\"]")
    @iOSXCUITFindBy(accessibility = "0 - 2,500")
    public WebElement amountValue;
    //final

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please Wait .. while we secure your information!\")")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Please Wait .. while we secure your information!\"`]")
    public WebElement passPleaseWait;

    @AndroidFindBy(uiAutomator = "className(\"android.widget.Button\")")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton")
    public WebElement getStartedBt;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"Onboarding.FatcaDetailsScreen:YesButton\"])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Onboarding.FatcaDetailsScreen:YesButton\"]")
    public WebElement confirmPEP;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"Onboarding.FatcaDetailsScreen:YesButton\"]/android.view.ViewGroup/com.horcrux.svg.SvgView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Onboarding.FatcaRadioButton:labelText\" and @label=\"Yes\"]")
    public WebElement confirmPEPFastOnboarding;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"Onboarding.FatcaDetailsScreen:NoButton\"]/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.l/com.horcrux.svg.u")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Onboarding.FatcaRadioButton:labelText\" and @label=\"Yes\"]")
    public WebElement declinePEPFastOnboarding;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"Onboarding.FatcaDetailsScreen:YesButton\"])[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Onboarding.FatcaDetailsScreen:YesButton\" and @label=\"Yes, I am\"]")
    public WebElement confirmTax;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.FatcaDetailsScreen:OnAddPress\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.FatcaDetailsScreen:OnAddPress")
    public WebElement addTax;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.CountrySelectorScreen:CountryName-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.CountrySelectorScreen:CountryName-Stack")
    public WebElement countryName;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Albania\"]")
    @iOSXCUITFindBy(accessibility = "Albania")
    public WebElement Albania;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.OccupationalInfoScreen:ContinueButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.OccupationalInfoScreen:ContinueButton-Pressable")
    public WebElement occupationalInfoContinueButton;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.OccupationalInfoScreen:Update-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.OccupationalInfoScreen:Update-Pressable")
    public WebElement occupationalInfoUpdateContinueButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Later\"]")
    @iOSXCUITFindBy(accessibility = "Later")
    public WebElement activateCardLaterLabel;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Activate Now\")")
    @iOSXCUITFindBy(accessibility = "Activate Now")
    public WebElement activateCardBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Later\"]")
    public WebElement laterButton;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Pending approval\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Pending approval\"]")
    public WebElement pendingApprovalTxt;



    public void passPleaseWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.invisibilityOf(passPleaseWait));
    }

    public void clickOnGetStartedBt() {
        waitUntilElementAppear(getStartedBt, 20);
        tapOn(getStartedBt);
    }

    public void clickOnSetButton() {
        tapOn(setBt);
    }

    public void clickOnOccupationalInfoContinueButton() {
        tapOn(occupationalInfoContinueButton);
    }

    public void clickOnOccupationalInfoUpdateContinueButton() {
        tapOn(occupationalInfoUpdateContinueButton);
    }

    public void clickOnFatcaDetailsScreenContinueButton() {
        tapOn(fatcaDetailsScreenContinueButton);
    }

    public void clickOnToggleHaveAdditionalInfo() {
        tapOn(toggleHaveAdditionalInfo);
        verticalScroll(fullScreenContainer, 0.9, 0.1);
    }

    public void setAdditionalIncome() {
        tapOn(additionalIncomeType);
        tapOn(rentType);
        tapOn(setBt);//
        tapOn(InputSelectAmount);
        tapOn(amountValue);
        tapOn(setBt);
    }

    public void declinePEP() {
        tapOn(confirmPEPFastOnboarding);

    }

    public void confirmAndSetTax() {

        tapOn(confirmTax);
        tapOn(addTax);
        retryWaitElement(countryName);
        tapOn(countryName);
        tapOn(Albania);
        tapOn(setTaxCountry);
        tapOn(TaxReferenceNumber);
        typingTextIn(TaxReferenceNumber,"12656666666666");
        tapOn(addBtn);

    }

    public void confirmPep() {
        tapOn(confirmPEP);
    }


    public void tapOnaActivateCardLaterLabel() {

        retryWaitElement(activateCardLaterLabel);
        tapOn(activateCardLaterLabel);
    }

    public void tapOnaActivateCardBtn() {
        retryWaitElement(activateCardBtn);
        tapOn(activateCardBtn);
    }
    public void tapOnaLaterButton() {
        tapOn(laterButton);
    }
}
