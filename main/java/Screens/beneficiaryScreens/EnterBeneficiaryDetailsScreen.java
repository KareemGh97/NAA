package Screens.beneficiaryScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class EnterBeneficiaryDetailsScreen extends ScreenBase {
    public EnterBeneficiaryDetailsScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterBeneficiaryDetailsScreen:TransferMethodPill-IBAN-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterBeneficiaryDetailsScreen:TransferMethodPill-IBAN-Pressable")
    public WebElement ibanTab;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterBeneficiaryDetailsScreen:TransferMethodPill-ID-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterBeneficiaryDetailsScreen:TransferMethodPill-ID-Pressable")
    public WebElement nationalIdTab;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterBeneficiaryDetailsScreen:TransferMethodPill-Mobile-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterBeneficiaryDetailsScreen:TransferMethodPill-Mobile-Pressable")
    public WebElement mobileTab;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterBeneficiaryDetailsScreen:TransferMethodPill-Account number-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterBeneficiaryDetailsScreen:TransferMethodPill-Account number-Pressable")
    public WebElement accountTab;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByIBANForm-NickNameTextInput-Stack\").childSelector(className(\"android.widget.EditText\"))")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextField\" AND name == \"InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByIBANForm-NickNameTextInput\"")
    public WebElement ibanNickNameEt;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.LocalTransferBeneficiaryScreen:NicknameInput\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.LocalTransferBeneficiaryScreen:NicknameInput")
    public WebElement localIbanNickNameEt;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Nickname\"]")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.LocalTransferBeneficiaryScreen:NicknameInput")
    public WebElement localIbanNickNameField;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByNationalIdForm-NickNameTextInput-Stack\").childSelector(className(\"android.widget.EditText\"))")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextField\" AND name == \"InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByNationalIdForm-NickNameTextInput\"")
    public WebElement nationalIdNickNameEt;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByMobileForm-NickNameTextInput-Stack\").childSelector(className(\"android.widget.EditText\"))")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextField\" AND name == \"InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByMobileForm-NickNameTextInput\"")
    public WebElement mobileNickNameEt;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByAccountNumberForm-NickNameTextInput-Stack\").childSelector(className(\"android.widget.EditText\"))")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextField\" AND name == \"InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByAccountNumberForm-NickNameTextInput\"")
    public WebElement accountNumberNickNameEt;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*EnterBeneficiaryByIBANForm-MaskedTextInput.*\").className(\"android.widget.EditText\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*EnterBeneficiaryByIBANForm-MaskedTextInput.*'")
    public WebElement ibanEt;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.LocalTransferBeneficiaryScreen:IBANInput\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.LocalTransferBeneficiaryScreen:IBANInput")
    public WebElement localIbanEt;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"IBAN\"]")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.LocalTransferBeneficiaryScreen:IBANInput")
    public WebElement localIbanField;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterLocalTransferBeneficiaryScreen:IBANInput\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterLocalTransferBeneficiaryScreen:IBANInput")
    public WebElement ipsLocalIbanEt;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"IBAN number\"]")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterLocalTransferBeneficiaryScreen:IBANInput")
    public WebElement ipsLocalIbanField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*EnterBeneficiaryByAccountNumberForm-AccountNumberInput.*\").className(\"android.widget.EditText\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*EnterBeneficiaryByAccountNumberForm-AccountNumberInput.*'")
    public WebElement accountNumberEt;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByMobileForm-PhoneNumberInput->InputBox\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByMobileForm-PhoneNumberInput->InputBox")
    public WebElement phoneNumberBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByMobileForm-PhoneNumberInput->InputBox\").childSelector(className(\"android.widget.EditText\"))")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByMobileForm-PhoneNumberInput->InputBox")
    public WebElement phoneNumberEt;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*EnterBeneficiaryByNationalIdForm-NationalIdMaskedTextInput.*\").className(\"android.widget.EditText\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*EnterBeneficiaryByNationalIdForm-NationalIdMaskedTextInput.*'")
    public WebElement nationalIdEt;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*ContinueButton-Button-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*ContinueButton-Button-Pressable.*'")
    public WebElement continueBtn;

    @AndroidFindBy(className = "android.widget.Button")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByNationalIdForm-ContinueButton-Button-Pressable")
    public WebElement continueByNationalIdBtn;
    @AndroidFindBy(className = "android.widget.Button")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByAccountNumberForm-ContinueButton-Button-Pressable")
    public WebElement continueByAccountBtn;
    @AndroidFindBy(className = "android.widget.Button")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByMobileForm-ContinueButton-Button-Pressable")
    public WebElement continueByPhoneBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.LocalTransferBeneficiaryScreen:ContinueButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.LocalTransferBeneficiaryScreen:ContinueButton-Button-Pressable")
    public WebElement localContinueBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.SendToBeneficiaryScreen:AddBeneficiaryButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.SendToBeneficiaryScreen:AddBeneficiaryButton")
    public WebElement requestToPayAddBeneficiaryBut;

    public void addBeneficiaryByUsingIBAN(String ibanValue, String nickName) {
        tapOn(ibanTab);
        typingTextIn(ibanEt, ibanValue);
        typingTextIn(ibanNickNameEt, nickName);
        tapOn(continueBtn);

    }

    public void addLocalBeneficiaryByUsingIBAN(String ibanValue, String nickName) {
        tapOn(localIbanEt);
        typingTextIn(localIbanField, ibanValue);
        tapOn(localIbanNickNameEt);
        typingTextIn(localIbanNickNameField, nickName);
        tapOn(localContinueBtn);

    }

    public void addIpsBeneficiaryByUsingIBAN(String ibanValue, String nickName) {
        tapOn(ipsLocalIbanEt);
        typingTextIn(ipsLocalIbanField, ibanValue);
        typingTextIn(localIbanNickNameField, nickName);
        tapOn(localContinueBtn);

    }

    public void addBeneficiaryByUsingNationalId(String nationalIdValue, String nickName) {
        tapOn(nationalIdTab);
        typingTextIn(nationalIdEt, nationalIdValue);
        typingTextIn(nationalIdNickNameEt, nickName);
        tapOn(continueByNationalIdBtn);
    }

    public void addBeneficiaryByUsingAccountNumber(String accountNumber, String nickName) {
        tapOn(accountTab);
        typingTextIn(accountNumberEt, accountNumber);
        typingTextIn(accountNumberNickNameEt, nickName);
        tapOn(continueByAccountBtn);
    }

    public void addBeneficiaryByUsingMobileNumber(String mobileNumber, String nickName) {
        tapOn(mobileTab);
        tapOn(phoneNumberBtn);
        typingTextIn(phoneNumberEt, mobileNumber);
        typingTextIn(mobileNickNameEt, nickName);
        tapOn(continueByPhoneBtn);
    }

    public void tapOnAddNewBeneficiary() {
        tapOn(requestToPayAddBeneficiaryBut);
    }
}
