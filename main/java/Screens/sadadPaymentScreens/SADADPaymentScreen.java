package Screens.sadadPaymentScreens;


import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class SADADPaymentScreen extends ScreenBase {
    public SADADPaymentScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    //    ******************** PaymentHomeScreen Start  ***********************************************************************
    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillPaymentHomeScreen:OnAddBillPressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillPaymentHomeScreen:OnAddBillPressable")
    public WebElement AddBillBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillPaymentHomeScreen:PaymentDueItem-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillPaymentHomeScreen:PaymentDueItem-Pressable")
    public WebElement PaymentDueSection;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillPaymentHomeScreen:PaymentDueCard-NetworkImage\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillPaymentHomeScreen:PaymentDueCard-NetworkImage")
    public WebElement PaymentLogo;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillPaymentHomeScreen:SavedBillsItem-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillPaymentHomeScreen:SavedBillsItem-Pressable")
    public WebElement savedBillsTab;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillPaymentHomeScreen:ViewAll-ViewAllBeneficiaries\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillPaymentHomeScreen:ViewAll-ViewAllBeneficiaries")
    public WebElement viewAllBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillPaymentHomeScreen:OneTimePaymentItem-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillPaymentHomeScreen:OneTimePaymentItem-Pressable")
    public WebElement oneTimePaymentBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillPaymentHomeScreen:OnSplitPaymentItem-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillPaymentHomeScreen:OnSplitPaymentItem-Pressable")
    public WebElement splitBillsBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillPaymentHomeScreen:PaymentHistoryItem-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillPaymentHomeScreen:PaymentHistoryItem-Pressable")
    public WebElement paymentHistoryBtn;

//    ******************************* PaymentHomeScreen End **********************************************************************************

    //    ******************************* AddBill-SelectBillerCategory Screen Start **********************************************************
    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.SelectBillerCategoryScreen:NavHeader-BackButton\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.SelectBillerCategoryScreen:NavHeader-BackButton")
    public WebElement selectBillerScreenBackBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.SelectBillerCategoryScreen:OneTimePaymentTitle-HeaderText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.SelectBillerCategoryScreen:OneTimePaymentTitle-HeaderText")
    public WebElement AddNewBillTitle;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.SelectBillerCategoryScreen:BillerCategoryTitle\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.SelectBillerCategoryScreen:BillerCategoryTitle")
    public WebElement SelectBillerCategoryTitle;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"SadadBillPayment.SelectBillerCategoryScreen:CategoryList-ListItem-Stack\"])[1]/com.horcrux.svg.SvgView")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.SelectBillerCategoryScreen:CategoryList-ListItem-Stack")
    public WebElement CategoryArrow;

    //  ******** Select BillerSubCategoryScreen **********
    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.SelectBillerScreen:SelectBillerText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.SelectBillerScreen:SelectBillerText")
    public WebElement SelectBillerTitle;

//    ******************************* AddBill-SelectBiller Screen End **********************************************************************************

    //    ******************************* AddBill-EnterAccountNumber Screen Start **********************************************************************************
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add A New Bill\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add A New Bill\"]")
    public WebElement AddANewBillTitle;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.EnterAccountNoScreen:NavHeader-BackButton\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.EnterAccountNoScreen:NavHeader-BackButton")
    public WebElement EnterAccNumBackBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.EnterAccountNoScreen:NavHeader-CloseButton\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.EnterAccountNoScreen:NavHeader-CloseButton")
    public WebElement EnterAccNumXBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.EnterAccountNoScreen:AccountNumberTextInput-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.EnterAccountNoScreen:AccountNumberTextInput-Pressable")
    public WebElement AccountNumberExternalField;
    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.EnterAccountNoScreen:AccountNumberTextInput-Pressable")
    public WebElement AccountNumberField;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.EnterAccountNoScreen:ContinueButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.EnterAccountNoScreen:ContinueButton-Pressable")
    public WebElement EnterAccNumContinueBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.EnterAccountNoScreen:ErrorModal-Title\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.EnterAccountNoScreen:ErrorModal-Title")
    public WebElement errorMessage;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.EnterAccountNoScreen:RetryButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.EnterAccountNoScreen:RetryButton-Pressable")
    public WebElement retryBtn;

//    ******************************* AddBill-EnterAccountNumber Screen End **********************************************************************************

    //    ******************************* AddBill-EnterBillDescription Screen Start **********************************************************************************
    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.EnterBillDescriptionScreen:NavHeader-BackButton\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.EnterBillDescriptionScreen:NavHeader-BackButton")
    public WebElement enterBillDescBackBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.EnterBillDescriptionScreen:NavHeader-CloseButton\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.EnterBillDescriptionScreen:NavHeader-CloseButton")
    public WebElement enterBillDescXBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.EnterBillDescriptionScreen:EnterBillDescTitle-HeaderText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.EnterBillDescriptionScreen:EnterBillDescTitle-HeaderText")
    public WebElement EnterBillDescTitle;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.EnterBillDescriptionScreen:BillDescriptionInput-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.EnterBillDescriptionScreen:BillDescriptionInput-Pressable")
    public WebElement BillDescExternalTxt;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Bill Description\"]")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.EnterBillDescriptionScreen:BillDescriptionInput-Pressable")
    public WebElement BillDescTxt;
    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.EnterBillDescriptionScreen:SubmitButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.EnterBillDescriptionScreen:SubmitButton-Pressable")
    public WebElement EnterBillDesContinueBtn;

//    ******************************* AddBill-EnterBillDescription Screen End **********************************************************************************

    //    ******************************* AddBill-BillDescription Screen Start **********************************************************************************
    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:NavHeader-CloseButton\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:NavHeader-CloseButton")
    public WebElement billDesXBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:BillDescriptionText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:BillDescriptionText")
    public WebElement BillDescription;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:DescriptionEditPressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:DescriptionEditPressable")
    public WebElement EditButton;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:BillProviderText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:BillProviderText")
    public WebElement BillProvider;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:NetworkImage\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:NetworkImage")
    public WebElement BillProviderLogo;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:BillAmountText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:BillAmountText")
    public WebElement BillAmount;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:AccountNumberText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:AccountNumberText")
    public WebElement AccountNumber;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:BillerNumberText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:BillerNumberText")
    public WebElement BillerNumber;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:CurrentDueText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:CurrentDueText")
    public WebElement CurrentDueDate;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:BillStatusText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:BillStatusText")
    public WebElement billStatus;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:IsPaidText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:IsPaidText")
    public WebElement paidBill;
    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:PayBillButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:PayBillButton-Pressable")
    public WebElement AddTheBillBtn;

//    ******************************* AddBill-BillDescription Screen End **********************************************************************************

    //    ******************************* BillSavedSuccess Screen Start **********************************************************************************
    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillSavedSuccessScreen:BillAddedText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillSavedSuccessScreen:BillAddedText")
    public WebElement BillAddedSuccessfullyTitle;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillSavedSuccessScreen:OnPayNowButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillSavedSuccessScreen:OnPayNowButton-Pressable")
    public WebElement PayNowBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillSavedSuccessScreen:OnCloseText-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillSavedSuccessScreen:OnCloseText-Pressable")
    public WebElement CloseBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillSavedSuccessScreen:BillAddedText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillSavedSuccessScreen:BillAddedText")
    public WebElement billPaidSucc;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillSavedSuccessScreen:ReferenceNumberText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillSavedSuccessScreen:ReferenceNumberText")
    public WebElement referenceNum;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillSavedSuccessScreen:OneTimePaymentButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillSavedSuccessScreen:OneTimePaymentButton-Pressable")
    public WebElement makeAnotherPaymentBtn;

//    ******************************* BillSavedSuccess Screen End **********************************************************************************

    //    ******************************* Full Payment - BillAmountDescription Screen Start **********************************************************************************
    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillAmountDescriptionScreen:ConfirmBillDetails\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillAmountDescriptionScreen:ConfirmBillDetails")
    public WebElement ConfirmBillDetailsTitle;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillAmountDescriptionScreen:ConfirmButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillAmountDescriptionScreen:ConfirmButton-Pressable")
    public WebElement ConfirmBtn;

//    ******************************* BillAmountDescription Screen End **********************************************************************************

    //    ********************* Payment BillDescription-DetailsView Screen Start **********************************************************************************
    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:NavHeader-BackButton\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:NavHeader-BackButton")
    public WebElement billDesBackBtn;
    @AndroidFindBy(className = "android.widget.ScrollView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
    public WebElement listScrollView;
    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:BillDetailsView-BillDescriptionText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:BillDetailsView-BillDescriptionText")
    public WebElement billDetailsDescription;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:BillDetailsView-BillDescriptionPressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:BillDetailsView-BillDescriptionPressable")
    public WebElement billDetailsEditBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:BillDetailsView-BillProviderText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:BillDetailsView-BillProviderText")
    public WebElement billDetailsProvider;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:BillDetailsView-ImageView\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:BillDetailsView-ImageView")
    public WebElement billDetailsProviderLogo;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:BillDetailsView-BillAmountText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:BillDetailsView-BillAmountText")
    public WebElement billDetailsAmount;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:BillDetailsView-AccountNumberText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:BillDetailsView-AccountNumberText")
    public WebElement billDetailsAccNum;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:BillDetailsView-BillerNumberText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:BillDetailsView-BillerNumberText")
    public WebElement billDetailsBillerNum;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:BillDetailsView-DateAndTimeText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:BillDetailsView-DateAndTimeText")
    public WebElement billDetailsCurrentDueDate;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:PayBillButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:PayBillButton-Pressable")
    public WebElement PayTheBillBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:DeleteBillButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:DeleteBillButton-Pressable")
    public WebElement DeleteTheBillBtn;

//    *********************** Payment BillDescription-DetailsView Screen End **********************************************************************************

    //    *********************** Partial/Over Payment EnterBillAmount Screen Start **********************************************************************************
    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.EnterBillAmountScreen:SpecifyBillAmount-HeaderText\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.EnterBillAmountScreen:SpecifyBillAmount-HeaderText")
    public WebElement SpecifyBillAmountTitle;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.EnterBillAmountScreen:OtherAmountRadioButton-Lable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.EnterBillAmountScreen:OtherAmountRadioButton-Lable")
    public WebElement OtherAmountTitle;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.EnterBillAmountScreen:NavHeader-CloseButton\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.EnterBillAmountScreen:NavHeader-CloseButton")
    public WebElement enterBillAmountXBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.EnterBillAmountScreen:EnterCustomAmountInput-TextInput\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.EnterBillAmountScreen:EnterCustomAmountInput-Pressable")
    public WebElement enterCustomAmountField;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.EnterBillAmountScreen:ContinueButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.EnterBillAmountScreen:ContinueButton-Pressable")
    public WebElement enterBillAmountContinueBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.EnterBillAmountScreen:OtherAmountRadioButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.EnterBillAmountScreen:OtherAmountRadioButton-Pressable")
    public WebElement otherAmountRadioButton;

//    *********************** Partial/Over Payment EnterBillAmount Screen End **********************************************************************************

    //    *********************** Delete Bill Popup Start ************************************
    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:DeleteConfirmationModal-Title\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:DeleteConfirmationModal-Title")
    public WebElement deleteBillTitle;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:DeleteButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:DeleteButton-Pressable")
    public WebElement deleteBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:DeleteSuccessModal-Title\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:DeleteSuccessModal-Title")
    public WebElement billDeletedSucc;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:OkButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:OkButton-Pressable")
    public WebElement OkBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"SadadBillPayment.BillDescriptionScreen:CancelButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SadadBillPayment.BillDescriptionScreen:CancelButton-Pressable")
    public WebElement cancelBtn;

//    *********************** Delete Bill Popup End ************************************


    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Pay Bill\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Pay Bill\"]")
    public WebElement PayBillHeader;

    @AndroidFindBy(uiAutomator = "className(\"android.view.ViewGroup\").childSelector(className(\"android.widget.TextView\"))")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeScrollView/**/XCUIElementTypeOther/**/XCUIElementTypeOther/**/XCUIElementTypeOther")
    public List<WebElement> itemList;


    public void clickOnPayTheBillBtn() {
        tapOn(PayTheBillBtn);
    }

    public void clickOnConfirmBtn() {
        tapOn(ConfirmBtn);
    }

    public void clickOnAddBillBtn() {
        tapOn(AddBillBtn);
    }

    public void setAccountNumber(String AccountNumber) {
        tapOn(AccountNumberExternalField);
        waitUntilElementAppear(AccountNumberField, 5);
        typingTextIn(AccountNumberField, AccountNumber);
        if(String.valueOf(driver.getCapabilities().getPlatformName()).equalsIgnoreCase("android"))
        {
            pressEnter();
        }

    }

    public void setBillDescription(String BillDesc) {
        waitUntilElementAppear(BillDescTxt, 5);
        tapOn(BillDescExternalTxt);
        typingTextIn(BillDescTxt, BillDesc);
        if(String.valueOf(driver.getCapabilities().getPlatformName()).equalsIgnoreCase("android"))
        {
            pressEnter();
        }
    }

    public void clickOnAddTheBillBtn() {
        tapOn(AddTheBillBtn);
    }

    public void waitToLoad(AppiumDriver driver, Integer time) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public void setBillAmount(String BillAmount) {
        tapOn(otherAmountRadioButton);
        typingTextIn(enterCustomAmountField, BillAmount);
        if(String.valueOf(driver.getCapabilities().getPlatformName()).equalsIgnoreCase("android"))
        {
            pressEnter();
        }
    }

    public void clickOnCloseBtn() {
        tapOn(CloseBtn);
    }

    public void clickOnPayNowBtn() {
        tapOn(PayNowBtn);
    }

    public void selectItem(String item) {
        //Update method to scrolle inside List by Aseel
        scrollThenTapOnElementByText(itemList,"الاسم بالعربي",item,listScrollView);
    }

    public void clickOnSavedBillsTab() {
        tapOn(savedBillsTab);
    }

    public void clickOnViewAllBtn() {
        tapOn(viewAllBtn);
    }

    public void clickOnAccNumContinueBtn() {
        tapOn(EnterAccNumContinueBtn);
    }

    public void clickOnBillDesContinueBtn() {
        tapOn(EnterBillDesContinueBtn);
    }

    public void clickOnEnterBillAmountContinueBtn() {
        tapOn(enterBillAmountContinueBtn);
    }

    public void clickOnDeleteTheBillBtn() {
        tapOn(DeleteTheBillBtn);
    }

    public void clickOnCancelBtn(){
        tapOn(cancelBtn);
    }

    public void clickOnbillDesBackBtn(){
        tapOn(billDesBackBtn);
    }

    public void clickOnDeleteBtn(){
        tapOn(deleteBtn);
    }

}