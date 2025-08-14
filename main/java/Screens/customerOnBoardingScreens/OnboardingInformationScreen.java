package Screens.customerOnBoardingScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OnboardingInformationScreen extends ScreenBase {

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.ConfirmPersonalDetailsScreen:AddAddress\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.ConfirmPersonalDetailsScreen:AddAddress")
    public WebElement personalDetailsBt;
    @AndroidFindBy(uiAutomator = "className(\"android.view.ViewGroup\").childSelector(className(\"android.widget.TextView\"))")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeScrollView/**/XCUIElementTypeOther/**/XCUIElementTypeOther/**/XCUIElementTypeOther")
    public List<WebElement> itemList;
    @AndroidFindBy(className = "android.widget.ScrollView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
    public WebElement listScrollView;

    // 1\5
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.ConfirmPersonalDetailsScreen:EmailInput-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.ConfirmPersonalDetailsScreen:EmailInput-Pressable")
    public WebElement emailExternalEt;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"Onboarding.ConfirmPersonalDetailsScreen:EmailInput-TextInput\"]")
    @iOSXCUITFindBy(accessibility = "Onboarding.ConfirmPersonalDetailsScreen:EmailInput-Pressable")
    public WebElement emailEt;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Personal details\"]")
    @iOSXCUITFindBy(accessibility = "Personal details")
    public WebElement PersonalDetailsTitle;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.ConfirmDetails:ContinueButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.ConfirmDetails:ContinueButton-Button-Pressable")
    public WebElement confirmdetailsContinueBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IncomeDetailsScreen:ContinueButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IncomeDetailsScreen:ContinueButton-Pressable")
    public WebElement incomeDetailsScreenContinueBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IncomeDetailsScreen:UpdateButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IncomeDetailsScreen:UpdateButton-Pressable")
    public WebElement incomeDetailsUpdateScreenContinueBtn;

    // 2\5 Birth information screen

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.AddBirthScreen:CityInput-Stack\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.AddBirthScreen:CityInput-Stack")
    public WebElement selectCountryButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Afganistan\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.AddBirthScreen:CityInput-DropdownInput-ConfirmButton-Pressable")
    public WebElement setCountryButton;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.AddBirthScreen:CityInput\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.AddBirthScreen:CityInput")
    public WebElement cityTxt;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.AddBirthScreen:ConfirmButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.AddBirthScreen:ConfirmButton-Button-Pressable")
    public WebElement ConfirmButton;


    // 3/5
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.OccupationalInfoScreen:selectAProfessionText-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.OccupationalInfoScreen:selectAProfessionText-DropdownInput-Stack")
    public WebElement selectYourProfessionBt;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.OccupationalInfoScreen:SelectASector-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.OccupationalInfoScreen:SelectASector-DropdownInput-Stack")
    public WebElement selectYourSectorBt;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.OccupationalInfoScreen:Occupation-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.OccupationalInfoScreen:Occupation-DropdownInput-Stack")
    public WebElement selectYourOccupationBt;

    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Search\"])[5]")
    public WebElement occupationSearchEt;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.OccupationalInfoScreen:CompanyName\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.OccupationalInfoScreen:CompanyName")
    public WebElement addYourCompanyName;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Company Name\"]")
    @iOSXCUITFindBy(accessibility = "Onboarding.OccupationalInfoScreen:CompanyName")
    public WebElement addYourCompanyNameEt;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.OccupationalInfoScreen:titleText\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.OccupationalInfoScreen:titleText")
    public WebElement YourOccupationalInformationTx;


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

    // 4\5

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IncomeDetailsScreen:WhatIsMainTypeIncomeModal-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IncomeDetailsScreen:WhatIsMainTypeIncomeModal-View")
    public WebElement selectMainIncomeDd;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IncomeDetailsScreen:ToggleHaveAdditionalInfo\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IncomeDetailsScreen:ToggleHaveAdditionalInfo")
    public WebElement toggleHaveAdditionalInfo;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IncomeDetailsScreen:WhatIsAmountOfMainIncomeModal-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IncomeDetailsScreen:WhatIsAmountOfMainIncomeModal-View")
    public WebElement selectIncomeAmountDd;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IncomeDetailsScreen:MonthlyDebitCreditAmountModal-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IncomeDetailsScreen:MonthlyDebitCreditAmountModal-View")
    public WebElement selectAnAmountDd;

    // 5\5
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.FatcaDetailsScreen:AreYouPepText\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.FatcaDetailsScreen:AreYouPepText")
    public WebElement areYouPEPTx;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.FatcaDetailsScreen:ContinueButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.FatcaDetailsScreen:ContinueButton-Button-Pressable")
    public WebElement fatcaDetailsScreenContinueButton;
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

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.TermsAndConditionsScreen:ContinueButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.TermsAndConditionsScreen:ContinueButton-Pressable")//no accessibility id

    public WebElement TermsAndConditionsContinueButton;
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

    public void chickTermsAndConditions() {
        tapOn(termsAndConditionsCheckBox);
    }

    public void chickSamaTermsAndConditions() {
        tapOn(samaTermsAndConditionsCheckBox);
    }

    public void clickOnSetButtonSelectMainIncome() {
        retryWaitElement(selectMainIncomeDd);
        tapOn(selectMainIncomeDd);
    }

    public void passPleaseWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.invisibilityOf(passPleaseWait));
    }

    public void clickOnGetStartedBt() {
        waitUntilElementAppear(getStartedBt, 20);
        tapOn(getStartedBt);
    }

    public void clickOnSelectIncomeAmount() {
        tapOn(selectIncomeAmountDd);
    }

    public void clickOnTermsAndConditionsContinueButton() {
        tapOn(TermsAndConditionsContinueButton);
    }

    public void clickOnSelectAnAmount() {
        tapOn(selectAnAmountDd);
    }

    public void clickOnIncomeDetailsScreenContinueBtn() {
        tapOn(incomeDetailsScreenContinueBtn);
    }

    public void clickOnIncomeDetailsUpdateScreenContinueBtn() {
        tapOn(incomeDetailsUpdateScreenContinueBtn);
    }

    public void clickOnSetButton() {
        tapOn(setBt);
    }

    public void clickOnSelectCountryButton() {
        tapOn(selectCountryButton);
    }

    public void clickOnSetCountryButton() {
        tapOn(setCountryButton);
    }

    public void clickOnConfirmButton() {
        tapOn(ConfirmButton);
    }

    public void clickOnOccupationalInfoContinueButton() {
        tapOn(occupationalInfoContinueButton);
    }

    public void clickOnOccupationalInfoUpdateContinueButton() {
        tapOn(occupationalInfoUpdateContinueButton);
    }

    public void clickOnSelectYourProfession() {
        tapOn(selectYourProfessionBt);
    }

    public void clickOnSelectYourSectorBt() {
        tapOn(selectYourSectorBt);
    }

    public void clickOnSelectYourOccupationBt() {
        tapOn(selectYourOccupationBt);
    }

    public void addCompanyName(String companyName) {
        ScreenBase.ThreadSleep(2000);
        verticalScroll(listScrollView, 0.8, 0.2);
        tapOn(addYourCompanyName);
        typingTextIn(addYourCompanyNameEt, companyName);
    }

    public void clickOnContinueButton() {
        tapOn(confirmdetailsContinueBtn);
    }

    public void clickOnFatcaDetailsScreenContinueButton() {
        tapOn(fatcaDetailsScreenContinueButton);
    }

    public void enterUserEmail(String email) {
        tapOn(emailExternalEt);
        retryWaitElement(emailEt);
        typingTextIn(emailEt, email);
        tapOn(PersonalDetailsTitle);
    }

    public OnboardingInformationScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void clickOnToggleHaveAdditionalInfo() {
        tapOn(toggleHaveAdditionalInfo);
        verticalScroll(fullScreenContainer, 0.9, 0.1);
    }

    public void clickOnPersonalDetailsBt() {
        tapOn(personalDetailsBt);
    }

    public void selectProfession(String occupation) {
        scrollThenTapOnElementByText(itemList, "الاسم بالعربي", occupation, listScrollView);

    }

    public void selectOccupationBySearch(String occupation) {
        typingTextIn(occupationSearchEt, occupation);
        scrollThenTapOnElementByText(itemList, "الاسم بالعربي", occupation, listScrollView);
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

