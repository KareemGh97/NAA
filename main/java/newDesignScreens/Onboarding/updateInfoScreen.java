package newDesignScreens.Onboarding;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class updateInfoScreen extends ScreenBase {
    public updateInfoScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*ProfilePressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*ProfilePressable.*'")
    public WebElement profileBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Financial Information\")")
    @iOSXCUITFindBy(accessibility = "Financial Information Keep your income & Spending details to get personalized offers")
    public WebElement financialInformationBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.FinancialInformation.ViewFinancialInformationScreen:NavHeader-PressableIcon\")")
    @iOSXCUITFindBy(accessibility  = "Settings.FinancialInformation.ViewFinancialInformationScreen:NavHeader-PressableIcon")
    public WebElement financialInformationEditBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.FinancialInformation.IncomeDetailsScreen:WhatIsMainTypeIncomeModal-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Settings.FinancialInformation.IncomeDetailsScreen:WhatIsMainTypeIncomeModal-DropdownInput-Stack")
    public WebElement selectMainIncomeType;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.FinancialInformation.IncomeDetailsScreen:WhatIsAmountOfMainIncomeModal-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Settings.FinancialInformation.IncomeDetailsScreen:WhatIsAmountOfMainIncomeModal-DropdownInput-Stack")
    public WebElement selectMainIncomeAmount;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.FinancialInformation.IncomeDetailsScreen:MonthlyDebitCreditAmountModal-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Settings.FinancialInformation.IncomeDetailsScreen:MonthlyDebitCreditAmountModal-DropdownInput-Stack")
    public WebElement selectMonthlyCreditDebitAmount;
    @AndroidFindBy(uiAutomator = "className(\"android.view.ViewGroup\").childSelector(className(\"android.widget.TextView\"))")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeScrollView/**/XCUIElementTypeOther/**/XCUIElementTypeOther/**/XCUIElementTypeOther")
    public List<WebElement> questionsList;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IncomeDetailsScreen:SetButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IncomeDetailsScreen:SetButton-Pressable")
    public WebElement setDataBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.FinancialInformation.IncomeDetailsScreen:UpdateButton-Title\")")
    @iOSXCUITFindBy(accessibility = "Settings.FinancialInformation.IncomeDetailsScreen:UpdateButton-Pressable")
    public WebElement incomeDetailsUpdateBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.FinancialInformation.OccupationalInfoScreen:selectAProfessionText-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Settings.FinancialInformation.OccupationalInfoScreen:selectAProfessionText-DropdownInput-Stack")
    public WebElement selectProfession;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.FinancialInformation.OccupationalInfoScreen:Update-Title\")")
    @iOSXCUITFindBy(accessibility = "Settings.FinancialInformation.OccupationalInfoScreen:Update-Pressable")
    public WebElement occupationalInfoUpdateBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.FinancialInformation.FatcaDetailsScreen:Done-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Settings.FinancialInformation.FatcaDetailsScreen:Done-Button-Pressable")
    public WebElement pepFlagDoneBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.FinancialInformation.ViewFinancialInformationScreen:SourceOfIncome-Value\")")
    @iOSXCUITFindBy(accessibility = "Settings.FinancialInformation.ViewFinancialInformationScreen:SourceOfIncome-Value")
    public WebElement mainSourceIncomeValue;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.FinancialInformation.ViewFinancialInformationScreen:AmountOfIncome-Value\")")
    @iOSXCUITFindBy(accessibility = "Settings.FinancialInformation.ViewFinancialInformationScreen:AmountOfIncome-Value")
    public WebElement mainSourceIncomeAmountValue;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.FinancialInformation.ViewFinancialInformationScreen:SpendEachMonth-Value\")")
    @iOSXCUITFindBy(accessibility = "Settings.FinancialInformation.ViewFinancialInformationScreen:SpendEachMonth-Value")
    public WebElement monthlyExpensesValue;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.FinancialInformation.ViewFinancialInformationScreen:Profession-Value\")")
    @iOSXCUITFindBy(accessibility = "Settings.FinancialInformation.ViewFinancialInformationScreen:Profession-Value")
    public WebElement professionValue;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.FinancialInformation.ViewFinancialInformationScreen:AreYouPEP-Value\")")
    @iOSXCUITFindBy(accessibility = "Settings.FinancialInformation.ViewFinancialInformationScreen:AreYouPEP-Value")
    public WebElement pepFlagValue;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"CroatiaMobileApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")//no accessibility id
    public WebElement fullScreenContainer;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.FinancialInformation.EditFinancialInformationScreen:Stack\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")//no accessibility id
    public WebElement additionalIncomeFullScreenContainer;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(49)")
    @iOSXCUITFindBy(accessibility = "Settings.FinancialInformation.IncomeDetailsScreen:ToggleHaveAdditionalInfo")
    public WebElement additionalIncomeRadioBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.FinancialInformation.IncomeDetailsScreen:InputAdditionalIncomeType-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Settings.FinancialInformation.IncomeDetailsScreen:InputAdditionalIncomeType-DropdownInput-Stack")
    public WebElement selectAdditionalIncomeType;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.FinancialInformation.IncomeDetailsScreen:InputSelectAmount-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Settings.FinancialInformation.IncomeDetailsScreen:InputSelectAmount-DropdownInput-Stack")
    public WebElement selectAdditionalIncomeAmount;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"Settings.CustomerAccountManagement:SettingSection-Stack\").instance(0)")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Settings.CustomerAccountManagement:SettingSection-Stack\" and @label=\"Profile Details My Personal Information\"]")//todo do for ios
    public WebElement profileDetailsBtn;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Country Saudi Arabia Region City AL RIYADH District Olaya Street olaya street Postal Code 12222 Building Number 2458\"]/XCUIElementTypeOther[1]")
    public WebElement nationalAddressInformationEditBtn;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Country\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Country\"]")
    public WebElement countryDropdownInput;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"District\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"District\"]")
    public WebElement districtEditText;

    @AndroidFindBy(uiAutomator = "resourceId(\"AllInOneCard.SetAddressScreen:CityDropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "AllInOneCard.SetAddressScreen:CityDropdownInput-InputText-View")
    public WebElement cityEditText;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Update\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Update\"]")
    public WebElement updateBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sorry, something has gone wrong\"]")
    @iOSXCUITFindBy(accessibility = "Sorry, something has gone wrong")
    public WebElement someThingHasGoneWrongMessage;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Save\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Save\"]")
    public WebElement saveButton;

    public void clickOnProfileBtn (){
        tapOn(profileBtn);
    }
    public void clickOnFinancialInformationBtn (){
        tapOn(financialInformationBtn);
    }

    public void clickOnFinancialInformationEditBtn (){
        tapOn(financialInformationEditBtn);
    }
    public void clickOnNationalAddressInformationEditBtn (){
        verticalScroll(fullScreenContainer, 0.9, 0.1);
        tapOn(nationalAddressInformationEditBtn);
    }
    public void clickOnSelectMainIncomeType (){
        tapOn(selectMainIncomeType);
    }
    public void clickOnSelectMainIncomeAmount (){
        tapOn(selectMainIncomeAmount);
    }
    public void clickOnSelectMonthlyCreditDebitAmount (){
        tapOn(selectMonthlyCreditDebitAmount);
    }

    public void clickOnSetDataBtn (){
        tapOn(setDataBtn);
    }

    public void clickOnSelectProfession (){
        waitUntilElementAppear(selectProfession,10);
        tapOn(selectProfession);
    }

    public void selectQuestionData (String data){
        for (WebElement element : questionsList) {
            try {
                if(element.getText().equalsIgnoreCase(data)) {
                    element.click();
                    break;
                }

            } catch (org.openqa.selenium.StaleElementReferenceException ignored) {
            }
        }
    }
    public void clickOnIncomeDetailsUpdateBtn (){
        tapOn(incomeDetailsUpdateBtn);
    }

    public void clickOnOccupationalInfoUpdateBtn (){
        tapOn(occupationalInfoUpdateBtn);
    }
    public void clickOnPepFlagDoneBtn (){
        tapOn(pepFlagDoneBtn);
    }
    public void clickOnAdditionalIncomeRadioBtn (){
        tapOn(additionalIncomeRadioBtn);
    }

    public void clickOnSelectAdditionalIncomeType (){
        tapOn(selectAdditionalIncomeType);
    }
    public void clickOnSelectAdditionalIncomeAmount (){
        verticalScroll(additionalIncomeFullScreenContainer, 0.9, 0.1);
        tapOn(selectAdditionalIncomeAmount);
    }

    public void clickOnProfileDetailsBtn (){
        tapOn(profileDetailsBtn);
    }

    public void clickOnUpdateBtn (){
        tapOn(updateBtn);
    }

    public void clickOnSaveBtn (){
        tapOn(saveButton);
    }

    public String getFieldsText(WebElement element){
        return getText(element);
    }
}
