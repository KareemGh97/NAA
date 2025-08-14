package newDesignScreens.Transfers;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class MoneyTransferScreen extends ScreenBase {
    public MoneyTransferScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.InternalTransferScreen:NavHeader-BackButton\"))")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.InternalTransferScreen:NavHeader-BackButton")
    public WebElement backBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.InternalTransferScreen:TransferAmountInput-AccountBalanceCard-FormattedBalanceText-IntegerPart\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.InternalTransferScreen:TransferAmountInput-AccountBalanceCard-FormattedBalanceText-IntegerPart")
    public WebElement balanceView;

    // this to click on it to allow the keyboard to appear to enter the amount
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.InternalTransferScreen:TransferAmountInput-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.InternalTransferScreen:TransferAmountInput-Pressable")
    public WebElement enterAmountField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.InternalTransferScreen:TransferLimitsText-IntegerPart\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.InternalTransferScreen:TransferLimitsText-IntegerPart")
    public WebElement dailyLimitView;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.InternalTransferScreen:ContinueButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.InternalTransferScreen:ContinueButton-Pressable")
    public  WebElement continueBtn;

    public void tapOnTransferAmountField() {
        tapOn(enterAmountField);
    }

    public void enterAmount(String amount) {
        useNativeKeyboard(amount);
    }

    public void clickOnContinue() {
        tapOn(continueBtn);
    }

}
