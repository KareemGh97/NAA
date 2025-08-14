package newDesignScreens.Transfers;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class TransferSuccessScreen extends ScreenBase {
    public TransferSuccessScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.LocalTransferSuccessScreen:IconView\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.LocalTransferSuccessScreen:IconView")
    public WebElement successIcon;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.LocalTransferSuccessScreen:SuccessTitleText\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.LocalTransferSuccessScreen:SuccessTitleText")
    public WebElement successTitleTextView;


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.LocalTransferSuccessScreen:BeneficiaryName\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.LocalTransferSuccessScreen:BeneficiaryName")
    public WebElement beneficiaryNameTextView;


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.LocalTransferSuccessScreen:TransferAmount-IntegerPart\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.LocalTransferSuccessScreen:TransferAmount-IntegerPart")
    public WebElement transferAmountTextView;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.LocalTransferSuccessScreen:FormattedDate\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.LocalTransferSuccessScreen:FormattedDate")
    public WebElement dateTimeTextView;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.LocalTransferSuccessScreen:TransactionId\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.LocalTransferSuccessScreen:TransactionId")
    public  WebElement referenceNumberTextView;


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.LocalTransferSuccessScreen:DoneTransactionButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.LocalTransferSuccessScreen:DoneTransactionButton-Pressable")
    public WebElement doneBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.LocalTransferSuccessScreen:ViewTransactionButton-Title\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.LocalTransferSuccessScreen:ViewTransactionButton-Pressable")
    public WebElement viewTransactionBtn;

    public boolean successIconVisible(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return successIcon.isDisplayed();
    }

    public String getSuccessText(){
        return getText(successTitleTextView);
    }

    public String getBeneficiaryName(){
        return getText(beneficiaryNameTextView);
    }

    public String getTransferAmount(){
        return getText(transferAmountTextView);
    }

    public String getDateTimeText(){
        return getText(dateTimeTextView);
    }

    public String getReferenceNumberText(){
        return getText(referenceNumberTextView);
    }

    public void tapOnDoneButton(){
        tapOn(doneBtn);
    }

    public void navigateToViewTransaction(){
        tapOn(viewTransactionBtn);
    }


}
