package newDesignScreens.Transfers;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class ReviewTransferScreen extends ScreenBase {
    public ReviewTransferScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.InternalTransferScreen:NavHeader-BackButton\"))")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ReviewTransferScreen:NavHeader-BackButton")
    public WebElement backBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.ReviewTransferScreen:NavHeader-EndButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ReviewTransferScreen:NavHeader-EndButton")
    public WebElement closeBtn;

    // Issue here : same Id
    @AndroidFindBy(uiAutomator = "")
    @iOSXCUITFindBy(accessibility = "")
    public WebElement senderAccountNameTextView;

    @AndroidFindBy(uiAutomator = "")
    @iOSXCUITFindBy(accessibility = "")
    public WebElement senderAccountNumberTextView;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.ReviewTransferScreen:ReviewTransferDetail-RecipientAccountNameText\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ReviewTransferScreen:ReviewTransferDetail-RecipientAccountNameText")
    public WebElement recipientAccountNameTextView;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.ReviewTransferScreen:ReviewTransferDetail-RecipientAccountAliasValue\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ReviewTransferScreen:ReviewTransferDetail-RecipientAccountAliasValue")
    public WebElement recipientAccountAliasTextView;

    // no test id
    @AndroidFindBy()
    @iOSXCUITFindBy()
    public WebElement transferAmountTextView;

    @AndroidFindBy()
    @iOSXCUITFindBy()
    public WebElement editTransferAmountIcon;

    // menu contains items should be added
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.ReviewTransferScreen:ReviewTransferDetail-TransferReasonInput-Box\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ReviewTransferScreen:ReviewTransferDetail-TransferReasonInput-Box")
    public WebElement personalRemittancesMenu;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.ReviewTransferScreen:ReviewTransferDetail-ContentInput-TextInput\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ReviewTransferScreen:ReviewTransferDetail-ContentInput-Pressable")
    public WebElement noteEditText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.ReviewTransferScreen:SendMoneyButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ReviewTransferScreen:SendMoneyButton-Pressable")
    public WebElement confirmBtn;

    @AndroidFindBy(accessibility = "android:id/text1")
    @iOSXCUITFindBy()
    public List<WebElement> remittanceOptions;


    public String getSenderName(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return getText(senderAccountNameTextView);
    }

    public String getSenderAccountNumber(){
        return getText(senderAccountNumberTextView);
    }

    public String getRecipientName(){
        return getText(recipientAccountNameTextView);
    }

    public String getRecipientAccountAlias(){
        return getText(recipientAccountAliasTextView);
    }

    public String getTransferAmount(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return getText(transferAmountTextView);
    }

    public void tapOnEditTransferAmount(){
        tapOn(editTransferAmountIcon);
    }

    public void selectPersonalRemittance(String personalRemittance){
        tapOn(personalRemittancesMenu);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        for(WebElement option : remittanceOptions){
            if(getText(option).equals(personalRemittance)){
                tapOn(option);
            }
        }
    }

    public void addNotes(String noteText){
        tapOn(noteEditText);
        typingTextIn(noteEditText, noteText);
    }

    public void tapOnConfirmButton(){
        tapOn(confirmBtn);
    }



}
