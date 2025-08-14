package Screens.customerOnBoardingScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FinancialInformationScreen extends ScreenBase {
    public FinancialInformationScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IncomeDetailsScreen:WhatIsMainTypeIncomeModal-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IncomeDetailsScreen:WhatIsMainTypeIncomeModal-View")
    public WebElement selectMainIncomeDd;

    @AndroidFindBy(className = "android.widget.ScrollView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
    public WebElement listScrollView;
    @AndroidFindBy(uiAutomator = "className(\"android.view.ViewGroup\").childSelector(className(\"android.widget.TextView\"))")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeScrollView/**/XCUIElementTypeOther/**/XCUIElementTypeOther/**/XCUIElementTypeOther")
    public List<WebElement> itemList;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IncomeDetailsScreen:SetButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IncomeDetailsScreen:SetButton-Pressable")
    public WebElement setBt;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IncomeDetailsScreen:WhatIsAmountOfMainIncomeModal-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IncomeDetailsScreen:WhatIsAmountOfMainIncomeModal-View")
    public WebElement selectIncomeAmountDd;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IncomeDetailsScreen:MonthlyDebitCreditAmountModal-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IncomeDetailsScreen:MonthlyDebitCreditAmountModal-View")
    public WebElement selectAnAmountDd;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IncomeDetailsScreen:ContinueButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IncomeDetailsScreen:ContinueButton-Pressable")
    public WebElement incomeDetailsScreenContinueBtn;
    public void clickOnSetButtonSelectMainIncome (){
        retryWaitElement(selectMainIncomeDd);
        tapOn(selectMainIncomeDd);
    }

    public void clickOnSelectAnAmount (){
        tapOn(selectAnAmountDd);
    }



    public void clickOnSetButton (){
        tapOn(setBt);
    }

    public void selectProfession (String occupation){
        scrollThenTapOnElementByText(itemList,"الاسم بالعربي",occupation,listScrollView);

    }
    public void clickOnSelectIncomeAmount (){
        tapOn(selectIncomeAmountDd);
    }
    public void clickOnIncomeDetailsScreenContinueBtn (){
        tapOn(incomeDetailsScreenContinueBtn);
    }
}
