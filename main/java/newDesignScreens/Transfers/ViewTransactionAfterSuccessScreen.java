package newDesignScreens.Transfers;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class ViewTransactionAfterSuccessScreen extends ScreenBase {
    public ViewTransactionAfterSuccessScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }



    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.ViewTransactionsScreen:NavHeader-BackButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ViewTransactionsScreen:NavHeader-BackButton")
    public WebElement backBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.LocalTransferSuccessScreen:ShareIconTouchableOpacity\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ViewTransactionsScreen:NavHeader-CloseButton")
    public WebElement shareBtn;

    //Duplicate IDs
    @AndroidFindBy()
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ViewTransactionsScreen:RecipientAccountName")
    public WebElement recipientAccountNameTextView;

    @AndroidFindBy()
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ViewTransactionsScreen:RecipientIban")
    public WebElement recipientIbanTextView;

    @AndroidFindBy()
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ViewTransactionsScreen:TransferAmount-IntegerPart")
    public WebElement transferAmountTextView;


    @AndroidFindBy()
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ViewTransactionsScreen:TransactionType-Value-Text")
    public WebElement transactionTypeTextView;

    @AndroidFindBy()
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ViewTransactionsScreen:BankName-Value-Text")
    public WebElement bankNameTextView;

    // There is no id
    @AndroidFindBy()
    @iOSXCUITFindBy()
    public WebElement feeIncludeVatTextView;

    @AndroidFindBy()
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ViewTransactionsScreen:PurposeOfTransfer-Value-Text")
    public WebElement purposeOfTransferTextView;

    @AndroidFindBy()
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ViewTransactionsScreen:ReferenceNo-Value-Text")
    public WebElement referenceNoTextView;

    @AndroidFindBy()
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ViewTransactionsScreen:CloseTransactionButton-Pressable")
    public WebElement closeBtn;


    public String getRecipientAccountName(){
        return getText(recipientAccountNameTextView);
    }

    public String getRecipientIban(){
        return getText(recipientIbanTextView);
    }

    public String getTransferAmount(){
        return getText(transferAmountTextView);
    }

    public String getTransactionType(){
        return getText(transactionTypeTextView);
    }

    public String getBankName(){
        return getText(bankNameTextView);
    }

    public String getFeeIncludeVat(){
        return getText(feeIncludeVatTextView);
    }

    public String getPurposeOfTransfer(){
        return getText(purposeOfTransferTextView);
    }

    public String getReferenceN(){
        return getText(referenceNoTextView);
    }


}
