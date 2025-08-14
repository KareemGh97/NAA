package Screens.goalGetterScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoldScreen extends ScreenBase {

    public GoldScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoldWallet.OnboardingScreen:CheckboxInput\").instance(2)")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"GoldWallet.OnboardingScreen:CheckboxInput\"])[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    public WebElement termsAndConditionsCheckBox;

    @AndroidFindBy(uiAutomator = "resourceId(\"GoldWallet.OnboardingScreen:ConfirmButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "GoldWallet.OnboardingScreen:ConfirmButton-Pressable")
    public WebElement termsAndConditionsConfirmBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"0.\")")
    //    @iOSXCUITFindBy(accessibility = "GoalGetter.GoalDashboardScreen:MutalFund:ProducyExploreText")
    public WebElement enterGramsField;

    @AndroidFindBy(className = "android.widget.TextView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"GoldWallet.TradeGoldScreen:GoldTradeContent-IngotsWeightStack-Pressable\"`]")
    public List<WebElement> predefinedValues;

    @AndroidFindBy(uiAutomator = "resourceId(\"GoldWallet.TradeGoldScreen:GoldTradeContent-ContinueButton-Title\")")
    @iOSXCUITFindBy(accessibility = "GoldWallet.TradeGoldScreen:GoldTradeContent-ContinueButton-Pressable")
    public WebElement buyGoldContinueBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"GoldWallet.TradeGoldScreen:TransactionSummaryModal-ContinueButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "GoldWallet.TradeGoldScreen:TransactionSummaryModal-ContinueButton-Pressable")

    public WebElement orderSummaryContinueBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"GoldWallet.HubScreen:BuyGoldButton-Title\")")
    @iOSXCUITFindBy(accessibility = "GoldWallet.HubScreen:BuyGoldButton-Pressable")
    public WebElement buyGoldBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Gold Purchased Successfully\")")
    @iOSXCUITFindBy(accessibility = "GoldWallet.CompleteTransactionScreen:Title")
    public WebElement goldPurchasedSuccessfullyMessage;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ScrollView\")")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"GoldWallet.TradeGoldScreen:TransactionSummaryModal-ScrollView\"`]/XCUIElementTypeScrollView")
    public WebElement orderSummaryScrollView;

    @AndroidFindBy(uiAutomator = "resourceId(\"GoldWallet.CompleteTransactionScreen:ViewTransactionsText\")")
    @iOSXCUITFindBy(accessibility = "GoldWallet.CompleteTransactionScreen:ViewTransactionsText")
    public WebElement viewTransactionsBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"GoldWallet.TransactionsScreen:TransactionCard:0-TransactionStatus-Text\")")
    @iOSXCUITFindBy(accessibility = "GoldWallet.TransactionsScreen:TransactionCard:0-TransactionStatus-Text")
    public WebElement transactionCardStatus;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"SignIn.OneTimePasswordModal:PincodeInput-ShowPinCode\"`][1]")
    public WebElement otpFirstNumber;


    public void clickOnTermsAndConditionsCheckBox(){
        waitUntilElementAppear(termsAndConditionsCheckBox, 10);
        tapOn(termsAndConditionsCheckBox);
        clickOnConfirmBtn();
    }

    public void clickOnConfirmBtn() {
        waitUntilElementAppear(termsAndConditionsConfirmBtn, 10);
        termsAndConditionsConfirmBtn.getAttribute("enabled");
        long timeoutInSeconds = 30; // Timeout duration
        long startTime = System.currentTimeMillis();
        while (termsAndConditionsConfirmBtn.getAttribute("enabled").equalsIgnoreCase("false")) {
            if ((System.currentTimeMillis() - startTime) / 1000 > timeoutInSeconds) {
                break;
            }
        }
        tapOn(termsAndConditionsConfirmBtn);
    }

    public void clickOnEnterGramsField() {
        waitUntilElementAppear(enterGramsField, 10);
        tapOn(enterGramsField);
        typingTextIn(enterGramsField, "5");
    }

    public void clickOnBuyGoldContinueBtn() {
        waitUntilElementAppear(buyGoldContinueBtn, 10);
        tapOn(buyGoldContinueBtn);
    }

    public void clickOnOrderSummaryContinueBtn() {
        verticalScroll(orderSummaryScrollView, 0.9, 0.1);
        waitUntilElementAppear(orderSummaryContinueBtn, 10);
        tapOn(orderSummaryContinueBtn);
    }

    public void clickOnBuyGoldBtn() {
        waitUntilElementAppear(buyGoldBtn, 10);
        tapOn(buyGoldBtn);
    }

    public void selectGoldGramsAndroid(String Item) {
        for (WebElement element : predefinedValues) {
            try {
                System.out.println(element.getText());
                if (element.getText().equalsIgnoreCase(Item)) {
                    tapOn(element);
                    tapOn(element);
                    break;
                }

            } catch (org.openqa.selenium.StaleElementReferenceException ignored) {
            }
        }
    }

    public void selectGoldGramsIOS(String Item) {
        for (WebElement element : predefinedValues) {
            try {
                System.out.println(element.getAttribute("label"));
                if (element.getAttribute("label").equalsIgnoreCase(Item)) {
                    tapOn(element);
                    tapOn(element);
                    break;
                }

            } catch (org.openqa.selenium.StaleElementReferenceException ignored) {
            }
        }
    }

    public boolean isSuccessMessageAppeared() {
        return isDisplayed(goldPurchasedSuccessfullyMessage);
    }

    public void clickOnViewTransactionsBtn() {
        waitUntilElementAppear(viewTransactionsBtn, 10);
        tapOn(viewTransactionsBtn);
    }
    public String getTransactionCardStatus(){
        return getText(transactionCardStatus);
    }

    public void clickOnOTPFirstNumber() {
        waitUntilElementAppear(otpFirstNumber, 10);
        tapOn(otpFirstNumber);
    }

}
