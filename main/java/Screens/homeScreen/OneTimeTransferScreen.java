package Screens.homeScreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OneTimeTransferScreen extends ScreenBase {
    public OneTimeTransferScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(className = "android.widget.HorizontalScrollView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeScrollView[`visible == 1`]")
    public WebElement NeraToNeraTabsContainer;

    @AndroidFindBy(className = "android.widget.HorizontalScrollView")
    @iOSXCUITFindBy(accessibility = "Beneficiaries IBAN Mobile ID Email")
    public WebElement croToArbTabsContainer;
    @AndroidFindBy(className = "android.widget.HorizontalScrollView")
    @iOSXCUITFindBy(className = "XCUIElementTypeScrollView")
    public WebElement RequestToPayTabsContainer;
    @AndroidFindBy(className = "android.widget.HorizontalScrollView")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterBeneficiaryDetailsScreen:ScrollView")
    public WebElement tabsBenficiaryContainer;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.InternalTransferCTCAndCTAScreen:TransferMethodPill-beneficiaries-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.InternalTransferCTCAndCTAScreen:TransferMethodPill-beneficiaries-Pressable")
    public WebElement beneficiariesTab;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterLocalTransferBeneficiaryScreen:TransferMethodPill-beneficiaries-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterLocalTransferBeneficiaryScreen:TransferMethodPill-beneficiaries-Pressable")
    public WebElement beneficiariesLocalTab;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.BeneficiaryListsWithSearchForTransfersScreen:BeneficiariesListWithSearchForTransfer-AddBeneficiaryButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.BeneficiaryListsWithSearchForTransfersScreen:BeneficiariesListWithSearchForTransfer-AddBeneficiaryButton")
    public WebElement addLocalBeneficiaryBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*TransferMethodPill-Account.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*TransferMethodPill-Account.*'")
    public WebElement accountNumberTab;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.InternalTransferCTCAndCTAScreen:TransferMethodPill-phoneNumber-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.InternalTransferCTCAndCTAScreen:TransferMethodPill-phoneNumber-Pressable")
    public WebElement mobileNumberTab;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.InternalTransferCTCAndCTAScreen:TransferMethodPill-nationalId-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.InternalTransferCTCAndCTAScreen:TransferMethodPill-nationalId-Pressable")
    public WebElement nationalIdTab;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterBeneficiaryDetailsScreen:TransferMethodPill-ID-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterBeneficiaryDetailsScreen:TransferMethodPill-ID-Pressable")
    public WebElement beneficiaryNationalIdTab;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.InternalTransferCTCAndCTAScreen:TransferMethodPill-email-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.InternalTransferCTCAndCTAScreen:TransferMethodPill-email-Pressable")
    public WebElement emailTab;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.InternalTransferCTCAndCTAScreen:TransferMethodPill-IBAN-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.InternalTransferCTCAndCTAScreen:TransferMethodPill-IBAN-Pressable")
    public WebElement ibanTab;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*EnterBeneficiaryByAccountNumberForm-AccountNumberInput.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*EnterBeneficiaryByAccountNumberForm-AccountNumberInput.*'")
    public WebElement accountNumberOption;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Account number\"]")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.InternalTransferCTCAndCTAScreen:AccountNoInput")
    public WebElement accountNumberField;

    // Edit text field for account number
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").resourceIdMatches(\".*EnterBeneficiaryByAccountNumberForm-AccountNumberInput.*\")")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name CONTAINS 'EnterBeneficiaryByAccountNumberForm-AccountNumberInput'`]")
    public WebElement accountNumberEditText;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.InternalTransferCTCAndCTAScreen:PhoneNumberInput->InputBox\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.InternalTransferCTCAndCTAScreen:PhoneNumberInput->InputBox")
    public WebElement mobileBtn;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Mobile\"]")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.InternalTransferCTCAndCTAScreen:PhoneNumberInput->InputBox")
    public WebElement mobileBtnField;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterLocalTransferBeneficiaryScreen:PhoneNumberInput->InputBox\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterLocalTransferBeneficiaryScreen:PhoneNumberInput->InputBox")
    public WebElement localMobileBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterLocalTransferBeneficiaryScreen:PhoneNumberInput\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterLocalTransferBeneficiaryScreen:PhoneNumberInput")
    public WebElement localMobileEt;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.InternalTransferCTCAndCTAScreen:NationalIDInput\").childSelector(className(\"android.widget.EditText\"))")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.InternalTransferCTCAndCTAScreen:NationalIDInput")
    public WebElement nationalEt;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByNationalIdForm-NickNameTextInput\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByNationalIdForm-NickNameTextInput")
    public WebElement nationalTxt;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Nickname\"]")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByNationalIdForm-NickNameTextInput")
    public WebElement nationalField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"ID\"]")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByNationalIdForm-NationalIdMaskedTextInput")
    public WebElement beneficiaryNationalEt;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByNationalIdForm-NationalIdMaskedTextInput\").childSelector(className(\"android.widget.EditText\"))")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByNationalIdForm-NationalIdMaskedTextInput")
    public WebElement beneficiaryNationalBox;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.InternalTransferCTCAndCTAScreen:EmailInput-Stack\").childSelector(className(\"android.widget.EditText\"))")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.InternalTransferCTCAndCTAScreen:EmailInput")
    public WebElement emailEt;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.InternalTransferCTCAndCTAScreen:IBANFullNameInput-Stack\").childSelector(className(\"android.widget.EditText\"))")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.InternalTransferCTCAndCTAScreen:IBANFullNameInput-Stack")
    public WebElement fullNameEt;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterLocalTransferBeneficiaryScreen:FullNameInput\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterLocalTransferBeneficiaryScreen:FullNameInput")
    public WebElement fullNameLocalEt;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").resourceIdMatches(\".*FullNameInput.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name MATCHES '.*FullNameInput.*'")
    public WebElement fullNameLocalField;

    @AndroidFindBy(uiAutomator = "resourceId(\"IPS.EnterLocalTransferBeneficiaryScreen:FullNameInput\")")
    @iOSXCUITFindBy(accessibility = "IPS.EnterLocalTransferBeneficiaryScreen:FullNameInput")
    public WebElement ipsFullNameEt;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").resourceIdMatches(\".*IBANInput.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name MATCHES '.*IBANInput.*'")
    public WebElement IBANFieldEt;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterLocalTransferBeneficiaryScreen:TransferMethodPill-IBAN-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterLocalTransferBeneficiaryScreen:TransferMethodPill-IBAN-Pressable")
    public WebElement LocalIban;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterLocalTransferBeneficiaryScreen:ContinueButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterLocalTransferBeneficiaryScreen:ContinueButton-Button-Pressable")
    public WebElement localTransferContinueBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'AlRajhi Bank')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'AlRajhi Bank')]")
    public WebElement ArbActiveBeneficiary;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Nera Bank')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Nera Bank')]")
    public WebElement NeraActiveBeneficiary;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterLocalTransferBeneficiaryScreen:TransferMethodPill-mobileNo-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterLocalTransferBeneficiaryScreen:TransferMethodPill-mobileNo-Pressable")
    public WebElement localMobileTab;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterLocalTransferBeneficiaryScreen:TransferMethodPill-nationalId-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterLocalTransferBeneficiaryScreen:TransferMethodPill-nationalId-Pressable")
    public WebElement localNationalIdTab;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterLocalTransferBeneficiaryScreen:NationalIDInput\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterLocalTransferBeneficiaryScreen:NationalIDInput")
    public WebElement localNationalIdEt;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"ID\"]")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterLocalTransferBeneficiaryScreen:NationalIDInput")
    public WebElement localNationalIdFieldEt;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterLocalTransferBeneficiaryScreen:TransferMethodPill-email-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterLocalTransferBeneficiaryScreen:TransferMethodPill-email-Pressable")
    public WebElement localEmailTab;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterLocalTransferBeneficiaryScreen:EmailInput\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterLocalTransferBeneficiaryScreen:EmailInput")
    public WebElement localEmailEt;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Email\"]")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterLocalTransferBeneficiaryScreen:EmailInput")
    public WebElement localEmailFieldEt;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterLocalTransferBeneficiaryScreen:BeneficiaryBankDropdown-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterLocalTransferBeneficiaryScreen:BeneficiaryBankDropdown-Stack")
    public WebElement bankBtn;
    @AndroidFindBy(uiAutomator = "className(\"android.view.ViewGroup\").childSelector(className(\"android.widget.TextView\"))")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeScrollView/**/XCUIElementTypeOther/**/XCUIElementTypeOther/**/XCUIElementTypeOther")
    public List<WebElement> bankList;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterLocalTransferBeneficiaryScreen:BeneficiaryBankDropdown-DropdownInput-ConfirmButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterLocalTransferBeneficiaryScreen:BeneficiaryBankDropdown-DropdownInput-ConfirmButton-Pressable")
    public WebElement selectBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*ContinueButton-Button-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*ContinueButton-Button-Pressable.*'")
    public WebElement transferContinueBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"IPS.EnterQuickTransferBeneficiaryScreen:TransferMethodPill-accountNumber-Pressable\")")
    @iOSXCUITFindBy(accessibility = "IPS.EnterQuickTransferBeneficiaryScreen:TransferMethodPill-accountNumber-Pressable")
    public WebElement ipsTransferByAccountNumberBut;
    @AndroidFindBy(uiAutomator = "resourceId(\"IPS.EnterQuickTransferBeneficiaryScreen:TransferMethodPill-IBAN-Pressable\")")
    @iOSXCUITFindBy(accessibility = "IPS.EnterQuickTransferBeneficiaryScreen:TransferMethodPill-IBAN-Pressable")
    public WebElement ipsTransferByIbanBut;
    @AndroidFindBy(uiAutomator = "resourceId(\"IPS.EnterQuickTransferBeneficiaryScreen:BeneficiaryBankDropdown-Stack\")")
    @iOSXCUITFindBy(accessibility = "IPS.EnterQuickTransferBeneficiaryScreen:BeneficiaryBankDropdown-Stack")
    public WebElement ipsBeneficiaryBankDropdown;
    @AndroidFindBy(className = "android.widget.ScrollView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
    public WebElement listScrollView;
    @AndroidFindBy(uiAutomator = "resourceId(\"IPS.EnterQuickTransferBeneficiaryScreen:BeneficiaryBankDropdown-DropdownInput-ConfirmButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "IPS.EnterQuickTransferBeneficiaryScreen:BeneficiaryBankDropdown-DropdownInput-ConfirmButton-Pressable")
    public WebElement selectBankBut;
    @AndroidFindBy(uiAutomator = "resourceId(\"IPS.EnterQuickTransferBeneficiaryScreen:TransferMethodPill-mobileNo-Pressable\")")
    @iOSXCUITFindBy(accessibility = "IPS.EnterQuickTransferBeneficiaryScreen:TransferMethodPill-mobileNo-Pressable")
    public WebElement ipsTransferByMobileBut;
    @AndroidFindBy(uiAutomator = "resourceId(\"IPS.EnterQuickTransferBeneficiaryScreen:TransferMethodPill-nationalId-Pressable\")")
    @iOSXCUITFindBy(accessibility = "IPS.EnterQuickTransferBeneficiaryScreen:TransferMethodPill-nationalId-Pressable")
    public WebElement ipsTransferByNationalIdBut;
    @AndroidFindBy(uiAutomator = "resourceId(\"IPS.EnterQuickTransferBeneficiaryScreen:TransferMethodPill-email-Pressable\")")
    @iOSXCUITFindBy(accessibility = "IPS.EnterQuickTransferBeneficiaryScreen:TransferMethodPill-email-Pressable")
    public WebElement ipsTransferByEmailBut;
    @AndroidFindBy(uiAutomator = "resourceId(\"IPS.EnterQuickTransferBeneficiaryScreen:PhoneNumberInput->InputBox\")")
    @iOSXCUITFindBy(accessibility = "IPS.EnterQuickTransferBeneficiaryScreen:PhoneNumberInput->InputBox")
    public WebElement ipsMobileEF;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterBeneficiaryDetailsScreen:SubmitButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterBeneficiaryDetailsScreen:SubmitButton-Button-Pressable")
    public WebElement ipsContinueBut;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByNationalIdForm-ContinueButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterBeneficiaryDetailsScreen:EnterBeneficiaryByNationalIdForm-ContinueButton-Button-Pressable")
    public WebElement transferByNationalContinueBut;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").resourceIdMatches(\".*PhoneNumberInput.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name MATCHES '.*PhoneNumberInput.*'")
    public WebElement ipsMobileField;

    @AndroidFindBy(uiAutomator = "resourceId(\"IPS.EnterQuickTransferBeneficiaryScreen:NationalIDInput\")")
    @iOSXCUITFindBy(accessibility = "IPS.EnterQuickTransferBeneficiaryScreen:NationalIDInput")
    public WebElement ipsNationalIdEl;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"ID number\"]")
    @iOSXCUITFindBy(accessibility = "IPS.EnterQuickTransferBeneficiaryScreen:NationalIDInput")
    public WebElement ipsNationalIdField;
    @AndroidFindBy(uiAutomator = "resourceId(\"IPS.EnterQuickTransferBeneficiaryScreen:EmailInput\")")
    @iOSXCUITFindBy(accessibility = "IPS.EnterQuickTransferBeneficiaryScreen:EmailInput")
    public WebElement ipsEmailEl;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Email\"]")
    @iOSXCUITFindBy(accessibility = "IPS.EnterQuickTransferBeneficiaryScreen:EmailInput")
    public WebElement ipsEmailField;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterBeneficiaryDetailsScreen:SubmitButtonContainer\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterBeneficiaryDetailsScreen:SubmitButtonContainer")
    public WebElement croatiaLogo;
    @iOSXCUITFindBy(accessibility = "Return")
    public WebElement PressReturn;

    public void transferByAccountNumber(String accountNumber) {
        tapOn(accountNumberTab);
        tapOn(accountNumberOption);
        typingTextIn(accountNumberEditText, accountNumber);
        tapOn(accountNumberTab);
        tapOn(transferContinueBtn);
    }

    public void transferByMobileNumber(String phoneNumber) {
        tapOn(mobileNumberTab);
        tapOn(mobileBtn);
        typingTextIn(mobileBtnField, phoneNumber);
        tapOn(transferContinueBtn);
    }

    public void transferByNationalId(String nationalId, String transferType) {
        if (transferType.equalsIgnoreCase("CroToCro")) {
            horizontalScroll(NeraToNeraTabsContainer, 0.9, 0.1);

        } else if (transferType.equalsIgnoreCase("CroToArb")) {
            horizontalScroll(croToArbTabsContainer, 0.9, 0.1);
        }
        tapOn(nationalIdTab);
        tapOn(nationalEt);
        typingTextIn(nationalEt, nationalId);
        tapOn(transferContinueBtn);
    }

    public void transferByBeneficiaryNationalId(String nationalId, String nicname) {
        ScreenBase.ThreadSleep(3000);
        horizontalScroll(tabsBenficiaryContainer, 0.9, 0.1);
        tapOn(beneficiaryNationalIdTab);
        tapOn(beneficiaryNationalBox);
        typingTextIn(beneficiaryNationalEt, nationalId);
        tapOn(nationalTxt);
        //  typingTextIn(nationalField,nicname);
        tapOn(transferByNationalContinueBut);
    }

    public void transferToArbByEmail(String email) {
        horizontalScroll(croToArbTabsContainer, 0.9, 0.1);
        tapOn(emailTab);
        typingTextIn(emailEt, email);
        tapOn(transferContinueBtn);
    }

    public void transferByEmail(String email, String transferType) {
        if (transferType.equalsIgnoreCase("NeraToNera")) {
            horizontalScroll(NeraToNeraTabsContainer, 0.9, 0.1);
        } else if (transferType.equalsIgnoreCase("CroToArb")) {
            horizontalScroll(croToArbTabsContainer, 0.9, 0.1);
        }
        tapOn(emailTab);
        typingTextIn(emailEt, email);
        tapOn(transferContinueBtn);
    }

    public void transferByIBAN(String fullName, String iban) {
        tapOn(ibanTab);
        typingTextIn(fullNameEt, fullName);
        typingTextIn(IBANFieldEt, iban);
        tapOn(transferContinueBtn);
    }

    public void transferByLocalIBAN(String fullName, String iban) {
        tapOn(LocalIban);
        tapOn(fullNameLocalEt);
        typingTextIn(fullNameLocalField, fullName);
        tapOn(IBANFieldEt);
        typingTextIn(IBANFieldEt, iban);
        tapOn(localTransferContinueBtn);
    }

    public void transferByLocalMobile(String bankName, String phoneNumber) {
        tapOn(localMobileTab);
        clickOnSelectYourBank();
        selectBank(bankName);
        tapOn(selectBtn);
        tapOn(localMobileBtn);
        typingTextIn(localMobileEt, phoneNumber);
        tapOn(localTransferContinueBtn);
    }

    public void transferByLocalNationalId(String bankName, String nationalId) {
        horizontalScroll(croToArbTabsContainer, 0.9, 0.1);
        tapOn(localNationalIdTab);
        clickOnSelectYourBank();
        selectBank(bankName);
        tapOn(selectBtn);
        tapOn(localNationalIdEt);
        typingTextIn(localNationalIdFieldEt, nationalId);
        tapOn(localTransferContinueBtn);
    }

    public void transferByLocalEmail(String bankName, String nationalId) {
        horizontalScroll(croToArbTabsContainer, 0.9, 0.1);
        tapOn(localEmailTab);
        clickOnSelectYourBank();
        selectBank(bankName);
        tapOn(selectBtn);
        tapOn(localEmailEt);
        typingTextIn(localEmailFieldEt, nationalId);
        tapOn(localTransferContinueBtn);
    }

    public void clickOnActiveBeneficiary(String transferType) {
        if (transferType.equalsIgnoreCase("NeraToArb")) {
            tapOn(ArbActiveBeneficiary);
        } else if (transferType.equalsIgnoreCase("NeraToNera")) {
            tapOn(NeraActiveBeneficiary);
        }
    }

    public void clickOnUATActiveBeneficary(String transferType) {
        if (transferType.equalsIgnoreCase("NeraToArb")) {
            tapOn(ArbActiveBeneficiary);
        } else if (transferType.equalsIgnoreCase("NeraToNera")) {
            tapOn(NeraActiveBeneficiary);
        }
    }

    public void clickOnSelectYourBank() {
        tapOn(bankBtn);
    }

    public void selectBank(String bankName) {
        for (WebElement element : bankList) {
            try {
                if (element.getText().equalsIgnoreCase(bankName)) {
                    element.click();
                    break;
                }

            } catch (org.openqa.selenium.StaleElementReferenceException ignored) {
            }
        }
    }

    public void selectItem(String item) {
        //Update method to scrolle inside List by Aseel
        scrollThenTapOnElementByText(bankList, "الاسم بالعربي", item, listScrollView);
    }

    public void transferByIPSIBAN(String fullName, String iban, String bankName) {
        tapOn(ipsTransferByIbanBut);
        tapOn(ipsFullNameEt);
        typingTextIn(ipsFullNameEt, fullName);
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("Android")) {
            pressEnter();
        } else if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("ios")) {
            tapOnReturn();
        }
        tapOn(IBANFieldEt);
        typingTextIn(IBANFieldEt, iban);
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("Android")) {
            pressEnter();
        } else if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("ios")) {
            tapOnReturn();
        }
//        tapOn(ipsBeneficiaryBankDropdown);
//        selectItem(bankName);
//        tapOn(selectBankBut);
        tapOn(ipsContinueBut);
    }

    public void transferByIPSMobile(String mobile, String bankName) {
        tapOn(ipsTransferByMobileBut);
        tapOn(ipsMobileEF);
        typingTextIn(ipsMobileField, mobile);
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("Android")) {
            pressEnter();
        } else if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("ios")) {
            tapOnReturn();
        }
        tapOn(ipsBeneficiaryBankDropdown);
        selectItem(bankName);
        tapOn(selectBankBut);
        tapOn(ipsContinueBut);
    }

    public void requestToPayCroByIPSMobile(String mobile) {
        tapOn(ipsTransferByMobileBut);
        tapOn(ipsMobileEF);
        typingTextIn(ipsMobileField, mobile);
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("Android")) {
            pressEnter();
        } else if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("ios")) {
            tapOnAnyware();
        }
        tapOn(ipsContinueBut);
    }

    public void rquestToPayToCroByAccountNumber(String accountNumber) {
        tapOn(ipsTransferByAccountNumberBut);
        tapOn(accountNumberOption);
        typingTextIn(accountNumberField, accountNumber);
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("Android")) {
            pressEnter();
        } else if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("ios")) {
            // tapOnReturn();
            tapOnAnyware();
        }
        tapOn(ipsContinueBut);
    }

    public void requestToPayCroByNationalId(String nationalId) {
        horizontalScroll(RequestToPayTabsContainer, 0.9, 0.1);
        tapOn(ipsTransferByNationalIdBut);
        tapOn(ipsNationalIdEl);
        typingTextIn(ipsNationalIdField, nationalId);
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("Android")) {
            pressEnter();
        } else if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("ios")) {
            tapOnAnyware();
        }
        tapOn(ipsContinueBut);
    }

    public void transferByIPSNationalId(String nationalId, String bankName) {
        horizontalScroll(croToArbTabsContainer, 0.9, 0.1);

        tapOn(ipsTransferByNationalIdBut);
        tapOn(ipsNationalIdEl);
        typingTextIn(ipsNationalIdField, nationalId);
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("Android")) {
            pressEnter();
        } else if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("ios")) {
            tapOnReturn();
        }
        tapOn(ipsBeneficiaryBankDropdown);
        selectItem(bankName);
        tapOn(selectBankBut);
        tapOn(ipsContinueBut);
    }

    public void requestToPayCroByEmail(String email) {
        horizontalScroll(RequestToPayTabsContainer, 0.9, 0.1);
        tapOn(ipsTransferByEmailBut);
        tapOn(ipsEmailEl);
        typingTextIn(ipsEmailField, email);
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("Android")) {
            pressEnter();
        } else if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("ios")) {
            tapOnAnyware();
        }

        tapOn(ipsContinueBut);
    }

    public void transferByIPSEmail(String email, String bankName) {
        horizontalScroll(croToArbTabsContainer, 0.9, 0.1);
        tapOn(ipsTransferByEmailBut);
        tapOn(ipsEmailEl);
        typingTextIn(ipsEmailField, email);
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("Android")) {
            pressEnter();
        } else if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("ios")) {
            tapOnReturn();
        }
        tapOn(ipsBeneficiaryBankDropdown);
        selectItem(bankName);
        tapOn(selectBankBut);
        tapOn(ipsContinueBut);
    }

    public void tapOnReturn() {
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("ios")) {
            tapOn(PressReturn);
        }
    }

    public void tapOnAnyware() {
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("ios")) {
            tapOn(croatiaLogo);
        }
    }
}
