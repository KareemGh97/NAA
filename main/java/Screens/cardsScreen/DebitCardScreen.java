package Screens.cardsScreen;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class DebitCardScreen extends ScreenBase {
    //Sit Mada Card
    @AndroidFindBy(uiAutomator = "resourceId(\"Home.AccountDetailsScreen:DebitCardStatusSectionPressable\")")
    @iOSXCUITFindBy(accessibility = "Home.AccountDetailsScreen:DebitCardStatusSectionPressable")
    public WebElement debitCardStack;
    @AndroidFindBy(uiAutomator = "resourceId(\"Home.AccountDetailsScreen:DebitCardStatusDetailsStack\")")
    @iOSXCUITFindBy(accessibility = "Home.AccountDetailsScreen:DebitCardStatusDetailsStack")
    public WebElement requestDebitCard;
    @AndroidFindBy(uiAutomator = "resourceId(\"Home.AccountDetailsScreen:ProceedButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Home.AccountDetailsScreen:ProceedButton-Pressable")
    public WebElement ProceedButton;
    //UAT Debit Card
    @AndroidFindBy(uiAutomator = "resourceId(\"Home.AccountDetailsScreen:DebitCardStack\")")
    @iOSXCUITFindBy(accessibility = "Home.AccountDetailsScreen:DebitCardStack")
    public WebElement UATdebitCardStack;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.CardDetailsScreen:CardDetailsScreenInner-BankCardHeader-ActiveBankCard-Image\")")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeOther[@name=\"CardActions.CardDetailsScreen:CardDetailsScreenInner-BankCardHeader-ActiveBankCard-TopView\"]")
    public WebElement activateCardBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.CardActivatedScreen:FinishButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "CardActions.CardActivatedScreen:FinishButton-Pressable")
    public WebElement finishButton;
    @AndroidFindBy(uiAutomator = "resourceId(\"Home.AccountDetailsScreen:NavHeader-BackButton\")")
    @iOSXCUITFindBy(accessibility = "Home.AccountDetailsScreen:NavHeader-BackButton")
    public WebElement backBt;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.CardDetailsScreen:CardDetailsScreenInner-NavHeader\")")
    @iOSXCUITFindBy(accessibility = "CardActions.CardDetailsScreen:CardDetailsScreenInner-NavHeader")
    public WebElement cardSettings;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.CardSettingScreen:ChangeCardPINSection-Pressable\")")
    @iOSXCUITFindBy(accessibility = "CardActions.CardSettingScreen:ChangeCardPINSection-Pressable")
   public WebElement cardChangePinBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Settings\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Settings\"]")
    public WebElement settingsScreenTitle;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.CardSettingScreen:OrderPhysicalCardSection-Pressable\")")
    @iOSXCUITFindBy(accessibility = "CardActions.CardSettingScreen:OrderPhysicalCardSection-Pressable")
    public WebElement orderPhysicalCard;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.CardSettingScreen:ReportSection-Pressable\")")
    @iOSXCUITFindBy(accessibility = "CardActions.CardSettingScreen:ReportSection-Pressable")
    public WebElement reportCardBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.CardSettingScreen:POSLimitSection-Pressable\")")
    @iOSXCUITFindBy(accessibility = "CardActions.CardSettingScreen:POSLimitSection-Pressable")
    public WebElement cardPOSTransactionLimit;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.CardSettingScreen:OnlineLimitSection-Pressable\")")
    @iOSXCUITFindBy(accessibility = "CardActions.CardSettingScreen:OnlineLimitSection-Pressable")
    public WebElement cardOnlineTransactionLimit;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.CardSettingScreen:AddToWalletSection-Pressable\")")
    @iOSXCUITFindBy(accessibility = "CardActions.CardSettingScreen:AddToWalletSection-Pressable")
    public WebElement AddToAppleWallet;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Confirm new PIN\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Confirm new PIN\"]")
    public WebElement confirmChangePinBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Your pin is changed successfully\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Your pin is changed successfully\"]")
    public WebElement successChangePinBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.CardDetailsScreen:CardDetailsScreenInner-BankCardHeader-ActiveBankCard-FreezeIcon\")")
    @iOSXCUITFindBy(accessibility = "CardActions.CardDetailsScreen:CardDetailsScreenInner-BankCardHeader-ActiveBankCard-FreezeIcon")
    public WebElement freezDebitCard;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.CardDetailsScreen:CardDetailsScreenInner-CardLockedModalConfirmButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "CardActions.CardDetailsScreen:CardDetailsScreenInner-CardLockedModalConfirmButton-Pressable")
    public WebElement confirmFreezDebitCard;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.CardDetailsScreen:CardDetailsScreenInner-LockSuccessfulModalOkButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "CardActions.CardDetailsScreen:CardDetailsScreenInner-LockSuccessfulModalOkButton-Pressable")
    public WebElement freezLockSuccessfulModalOkButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*InactiveBankCard-LOCK.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*InactiveBankCard-LOCK.*'")
    public WebElement defrostFreezDebitCard;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.CardDetailsScreen:CardDetailsScreenInner-CardUnlockedModalConfirmButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "CardActions.CardDetailsScreen:CardDetailsScreenInner-CardUnlockedModalConfirmButton-Pressable")
    public WebElement confirmDefrostFreezDebitCard;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.CardDetailsScreen:CardDetailsScreenInner-UnlockSuccessfulModalOkButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "CardActions.CardDetailsScreen:CardDetailsScreenInner-UnlockSuccessfulModalOkButton-Pressable")
    public WebElement confirmUnFreezSuccessDebitCard;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.ResetPinCodeScreen:PincodeTooEasyAlert-Message\")")
    @iOSXCUITFindBy(accessibility = "CardActions.ResetPinCodeScreen:PincodeTooEasyAlert-Message")
    public WebElement PincodeTooEasyAlert;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.CardSettingScreen:RequestPhysicalCardModalConfirmButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "CardActions.CardSettingScreen:RequestPhysicalCardModalConfirmButton-Pressable")
    public WebElement requestPhysicalCardModalConfirmButton;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.ApplyPhysicalCardSuccessScreen:OkButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "CardActions.ApplyPhysicalCardSuccessScreen:OkButton-Pressable")
    public WebElement ApplyPhysicalCardSuccessScreenBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.ApplyCardScreen:SelectAddress-primary\")")
    @iOSXCUITFindBy(accessibility = "CardActions.ApplyCardScreen:SelectAddress-primary")
    public WebElement cardPhysicalAddress;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").instance(0)")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirm address\"]")
    public WebElement cardConfirmAddressButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"CardActions.OrderNewCardSummaryScreen:OrderSummaryHeader\"]\n")
    @iOSXCUITFindBy(accessibility = "CardActions.OrderNewCardSummaryScreen:OrderSummaryHeader")
    public WebElement orderReviewScreen;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.OrderNewCardSummaryScreen:PaymentHeader\")")
    @iOSXCUITFindBy(accessibility = "CardActions.OrderNewCardSummaryScreen:PaymentHeader")
    public WebElement paymentSection;
    @AndroidFindBy(uiAutomator = "resourceId(\"CardActions.OrderNewCardSummaryScreen:DoneButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "CardActions.OrderNewCardSummaryScreen:DoneButton-Pressable")
    public WebElement doneBtn;
    public DebitCardScreen(AppiumDriver appiumDriver){
        super(appiumDriver);
    }
    public void clickOnDebitCardStack(){
        tapOn(debitCardStack);
    }
    public void clickOnProceedButton(){
        tapOn(ProceedButton);
    }
    public void clickOnRequestDebitCardStack(){
        tapOn(requestDebitCard);
    }
    public void clickOnUatDebitCardStack(){
        tapOn(UATdebitCardStack);
    }
    public void clickOnActivateCardBtn(){
        tapOn(activateCardBtn);
    }
    public void clickOnFinishButton(){
        tapOn(finishButton);
    }
    public void clickOnBackBt(){
        tapOn(backBt);
    }
    public void clickOnCardSettings(){
        tapOn(cardSettings);
    }
    public void clickOnOrderPhysicalCard(){
        tapOn(orderPhysicalCard);
    }
    public void clickOnCardChangePinBtn(){
        tapOn(cardChangePinBtn);
    }

    public void clickOnRequestPhysicalCardModalConfirmButton(){
        tapOn(requestPhysicalCardModalConfirmButton);
    }
    public void clickOnCardConfirmAddressButton(){
        tapOn(cardConfirmAddressButton);
    }
    public void clickOnDoneBtn(){
        tapOn(doneBtn);
    }
    public void clickOnFreezCard(){
        tapOn(freezDebitCard);
    }
    public void clickOnConfirmFreezCard(){
        tapOn(confirmFreezDebitCard);
    }
    public void clickOnFreezLockSuccessfulModalOkButton(){
        tapOn(freezLockSuccessfulModalOkButton);
    }
    public void clickOnDeforstFreezCard(){
        tapOn(defrostFreezDebitCard);
    }

    public void clickOnConfirmDefrostFreezDebitCard(){
        tapOn(confirmDefrostFreezDebitCard);
    }

    public void clickOnConfirmUnFreezSuccessDebitCard(){
        tapOn(confirmUnFreezSuccessDebitCard);
    }
    public void clickOnApplyPhysicalCardSuccessScreenBtn(){
        tapOn(ApplyPhysicalCardSuccessScreenBtn);
    }

}
