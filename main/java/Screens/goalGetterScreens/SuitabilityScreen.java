package Screens.goalGetterScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SuitabilityScreen extends ScreenBase {

    public SuitabilityScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"Home.GoalDashboardScreen:MutalFund\")")
    //@iOSXCUITFindBy()
    public WebElement MutualFundIcon;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(21)")
    //@iOSXCUITFindBy()
    public WebElement InvestedMoneyPeriodQuestion;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(24)")
    //@iOSXCUITFindBy()
    public WebElement FinancialExperienceQuestion;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(27)")
    //@iOSXCUITFindBy()
    public WebElement InvestmentLevelQuestion;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(30)")
    //@iOSXCUITFindBy()
    public WebElement InvestmentGoalsQuestion;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(33)")
    //@iOSXCUITFindBy()
    public WebElement AreYouAFinancialWorkerQuestion;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(36)")
    //@iOSXCUITFindBy()
    public WebElement NumberOfYearsOfInvestmentInSecurityQuestion;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup")
    //@iOSXCUITFindBy()
    public WebElement ApproximateAnnualIncomeQuestion;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Landing Phone Number?\")")
    //@iOSXCUITFindBy()
    public WebElement LandingPhoneNumberQuestion;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(25)")
    //@iOSXCUITFindBy()
    public WebElement ApproximateNetWealthQuestion;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Investment Asset Value in SAR\")")
    //@iOSXCUITFindBy()
    public WebElement InvestmentAssetValueQuestion;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(29)")
    //@iOSXCUITFindBy()
    public WebElement RelativeOrganizationQuestion;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(23)")
    //@iOSXCUITFindBy()
    public WebElement SeniorPositionQuestion;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(26)")
    //@iOSXCUITFindBy()
    public WebElement BoardMemberQuestion;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(29)")
    //@iOSXCUITFindBy()
    public WebElement InvestmentLoanRatioQuestion;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(32)")
    //@iOSXCUITFindBy()
    public WebElement PreferredInvestmentItemQuestion;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(35)")
    //@iOSXCUITFindBy()
    public WebElement MarginTransactionOverFiveYearsQuestion;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(38)")
    //@iOSXCUITFindBy()
    public WebElement HowManyDependantsQuestion;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(24)")
    //@iOSXCUITFindBy()
    public WebElement IdealInvestmentProfilePercentageQuestion;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Passport number\"]")
    //@iOSXCUITFindBy()
    public WebElement PassportNumberQuestion;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(28)")
    //@iOSXCUITFindBy()
    public WebElement EducationalLvelQuestion;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(31)")
    //@iOSXCUITFindBy()
    public WebElement ClientRiskApetiteQuestion;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(34)")
    //@iOSXCUITFindBy()
    public WebElement MaritalStatusQuestion;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"CroatiaMobileApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    public WebElement screenContainer;

    @AndroidFindBy(uiAutomator = "resourceId(\"MutualFund.Onboarding-Confirm:SubmitButton\")")
//    @iOSXCUITFindBy()
    public WebElement ConfirmBtn;

    @AndroidFindBy(uiAutomator = "className(\"android.view.ViewGroup\").childSelector(className(\"android.widget.TextView\"))")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeScrollView/**/XCUIElementTypeOther/**/XCUIElementTypeOther/**/XCUIElementTypeOther")
    public List<WebElement> questionList;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Select\")")
    public WebElement SelectBtn;

    public void clickOnQuestionOne() {
        waitUntilElementAppear(InvestedMoneyPeriodQuestion, 10);
        tapOn(InvestedMoneyPeriodQuestion);
    }

    public void clickOnQuestionTwo() {
        waitUntilElementAppear(FinancialExperienceQuestion, 10);
        tapOn(FinancialExperienceQuestion);
    }

    public void clickOnQuestionThree() {
        waitUntilElementAppear(InvestmentLevelQuestion, 10);
        tapOn(InvestmentLevelQuestion);
    }

    public void clickOnQuestionFour() {
        waitUntilElementAppear(InvestmentGoalsQuestion, 10);
        tapOn(InvestmentGoalsQuestion);
    }

    public void clickOnQuestionFive() {
        waitUntilElementAppear(AreYouAFinancialWorkerQuestion, 10);
        tapOn(AreYouAFinancialWorkerQuestion);
    }

    public void clickOnQuestionSix() {
//        verticalScroll(screenContainer, 0.9, 0.1);
//        waitUntilElementAppear(NumberOfYearsOfInvestmentInSecurityQuestion, 10);
     //   scrollDown(NumberOfYearsOfInvestmentInSecurityQuestion);
        tapOn(NumberOfYearsOfInvestmentInSecurityQuestion);
    }

    public void clickOnQuestionSeven() {
        waitUntilElementAppear(ApproximateAnnualIncomeQuestion, 10);
        tapOn(ApproximateAnnualIncomeQuestion);
    }

    public void clickOnQuestionEight(String value) {
        tapOn(LandingPhoneNumberQuestion);
        typingTextIn(LandingPhoneNumberQuestion, value);
    }

    public void clickOnQuestionNine() {
        waitUntilElementAppear(ApproximateNetWealthQuestion, 10);
        tapOn(ApproximateNetWealthQuestion);
    }

    public void clickOnQuestionTen(String value) {
        tapOn(InvestmentAssetValueQuestion);
        typingTextIn(InvestmentAssetValueQuestion, value);
    }

    public void clickOnQuestionEleven() {
        verticalScroll(screenContainer, 0.9, 0.1);
        waitUntilElementAppear(RelativeOrganizationQuestion, 10);
        tapOn(RelativeOrganizationQuestion);
    }

    public void clickOnQuestionTwelve() {
        waitUntilElementAppear(SeniorPositionQuestion, 10);
        tapOn(SeniorPositionQuestion);
    }

    public void clickOnQuestionThirteen() {
        waitUntilElementAppear(BoardMemberQuestion, 10);
        tapOn(BoardMemberQuestion);
    }

    public void clickOnQuestionFourteen() {
        waitUntilElementAppear(InvestmentLoanRatioQuestion, 10);
        tapOn(InvestmentLoanRatioQuestion);
    }

    public void clickOnQuestionFifteen() {
        waitUntilElementAppear(PreferredInvestmentItemQuestion, 10);
        tapOn(PreferredInvestmentItemQuestion);
    }

    public void clickOnQuestionSixteen() {
        waitUntilElementAppear(MarginTransactionOverFiveYearsQuestion, 10);
        tapOn(MarginTransactionOverFiveYearsQuestion);
    }

    public void clickOnQuestionSeventeen() {
        verticalScroll(screenContainer, 0.9, 0.1);
        waitUntilElementAppear(HowManyDependantsQuestion, 10);
        tapOn(HowManyDependantsQuestion);
    }

    public void clickOnQuestionEighteen() {
        waitUntilElementAppear(IdealInvestmentProfilePercentageQuestion, 10);
        tapOn(IdealInvestmentProfilePercentageQuestion);
    }

    public void clickOnQuestionNineteen(String value) {
        tapOn(PassportNumberQuestion);
        typingTextIn(PassportNumberQuestion, value);
    }

    public void clickOnQuestionTwenty() {
        waitUntilElementAppear(EducationalLvelQuestion, 10);
        tapOn(EducationalLvelQuestion);
    }

    public void clickOnQuestionTwentyOne() {
        waitUntilElementAppear(ClientRiskApetiteQuestion, 10);
        tapOn(ClientRiskApetiteQuestion);
    }

    public void clickOnQuestionTwentyTwo() {
        waitUntilElementAppear(MaritalStatusQuestion, 10);
        tapOn(MaritalStatusQuestion);
    }

    public void clickOnConfirmBtn() {
        waitUntilElementAppear(ConfirmBtn, 10);
        tapOn(ConfirmBtn);
    }

    public void selectQuestionList(String Item) {
        for (WebElement element : questionList) {
            try {
                if (element.getText().equalsIgnoreCase(Item)) {
                    element.click();
                    break;
                }

            } catch (org.openqa.selenium.StaleElementReferenceException ignored) {
            }
        }
    }

    public void clickOnSelectBtn() {
        waitUntilElementAppear(SelectBtn, 10);
        tapOn(SelectBtn);
    }


}