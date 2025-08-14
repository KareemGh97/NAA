package Screens.transferScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class TransferAmountScreen extends ScreenBase {
    public TransferAmountScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.InternalTransferScreen:ContinueButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.InternalTransferScreen:ContinueButton-Pressable")
    public WebElement continueBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.QuickTransferScreen:ContinueButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.QuickTransferScreen:ContinueButton-Pressable")
    public WebElement continueBtnForLocalTransfer;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.CreateRequestScreen:ContinueButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.CreateRequestScreen:ContinueButton-Pressable")
    public WebElement createRequestContinueBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*CurrencyInput.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*CurrencyInput.*'")
    public WebElement amountField;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").descriptionContains(\"Done\")")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND (name CONTAINS 'Pay' OR label CONTAINS 'Done')")
    public WebElement doneKey;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.InternalTransferScreen:TransferAmountInput-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.InternalTransferScreen:TransferAmountInput-IntegerText")
    public WebElement transferAmountField;

    public void enterAmount(String amount) {
        useNativeKeyboard(amount);
    }

    public void tapOnTransferAmountField() {
        tapOn(transferAmountField);
    }

    public void clickOnContinue() {
        tapOn(continueBtn);
    }

    public void continueBtnForLocalTransfer() {
        tapOn(continueBtnForLocalTransfer);
    }

    public void tapOnCreateRequestContinueBtn() {
        tapOn(createRequestContinueBtn);
    }

    public void tapOnAmountField() {

        tapOn(amountField);
    }

    public void pressDone() {
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("Android")) {
            pressEnter();
        } else {
            tapOn(doneKey);
        }
    }
}
