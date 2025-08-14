package Screens.transferScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TransfersScreen extends ScreenBase {
    public TransfersScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.TransfersLandingScreen:NavHeader-BackButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.TransfersLandingScreen:NavHeader-BackButton")
    public WebElement backBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.TransfersLandingScreen:NavHeader-EndButton\")")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeOther[@name=\"InternalTransfers.TransfersLandingScreen:NavHeader\"]")
    public WebElement settingBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.TransferSettingScreen:PaymentOption-3-Stack\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.TransferSettingScreen:PaymentOption-3-Stack")
    public WebElement quickTransferSettingBtn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"InternalTransfers.TransferSettingScreen:PaymentOption-3-TextStack\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Transactions limit Transactions limit\"]")
    public WebElement quickTransferTransactionsLimit;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.TransferPaymentScreen:TransferPaymentSubmitButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.TransferPaymentScreen:TransferPaymentSubmitButton-Button-Pressable")
    public WebElement saveChangesBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.TransferSettingScreen:NavHeader-BackButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.TransferSettingScreen:NavHeader-BackButton")
    public WebElement settingBackBtn;
    @AndroidFindBy( uiAutomator = "resourceId(\"InternalTransfers.TransfersLandingScreen:TransferActionButtons-CroToCroTransferButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.TransfersLandingScreen:TransferActionButtons-CroToCroTransferButton")
    public WebElement NeraToNeraBtn;
    @AndroidFindBy( uiAutomator = "resourceId(\"InternalTransfers.TransfersLandingScreen:TransferActionButtons-ToARBTransferButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.TransfersLandingScreen:TransferActionButtons-ToARBTransferButton")
    public WebElement croToARBBtn;
    @AndroidFindBy( uiAutomator = "resourceId(\"InternalTransfers.TransfersLandingScreen:TransferActionButtons-LocalTransferButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.TransfersLandingScreen:TransferActionButtons-LocalTransferButton")
    public WebElement croToLocalBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.TransfersLandingScreen:AddBeneficiaryButton\").instance(1)")
    @iOSXCUITFindBy(accessibility="InternalTransfers.TransfersLandingScreen:AddBeneficiaryButton")
    public WebElement addNewBeneficiaryBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Send to new beneficiary\"]")
    @iOSXCUITFindBy(accessibility="InternalTransfers.BeneficiaryListsWithSearchForTransfersScreen:BeneficiariesListWithSearchForTransfer-AddBeneficiaryButton")
    public WebElement sendToNewBeneficiaryBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.TransfersLandingScreen:SelectTransferTypeModal-CroatiaTransferButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.TransfersLandingScreen:SelectTransferTypeModal-CroatiaTransferButton")
    public WebElement addNeraBeneficiaryBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.TransfersLandingScreen:SelectTransferTypeModal-AlRajhiTransferButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.TransfersLandingScreen:SelectTransferTypeModal-AlRajhiTransferButton")
    public WebElement addARBBeneficiaryBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.TransfersLandingScreen:SelectTransferTypeModal-LocalTransferButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.TransfersLandingScreen:SelectTransferTypeModal-LocalTransferButton")
    public WebElement addLocalBeneficiaryBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.TransfersLandingScreen:TransferServices-RequestToPayButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.TransfersLandingScreen:TransferServices-RequestToPayButton")
    public WebElement RequestToPayButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"To nera\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"To nera\"]")//todo i change the id but needs to be checked
    public WebElement toCroBank;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"To Local Bank\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"To Local Bank For requests to Al-Rajhi bank accounts\"]")
    public WebElement toLocalBank;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\" All\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"All\"]")
    public WebElement allTab;

//    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.HubScreen:CreateRequestButton-Pressable\")")
//    @iOSXCUITFindBy(accessibility = "InternalTransfers.HubScreen:CreateRequestButton-Pressable")
//    public WebElement createRequest;
@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*CreateRequestButton-Pressable*$\")")
@iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*CreateRequestButton-Pressable.*'")
    public WebElement createRequest;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.HubScreen:SegmentedControlItem-Received-Text\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.HubScreen:SegmentedControlItem-Received-Text")
    public WebElement receivedRequest;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*SuccessModalNavigateButton-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*SuccessModalNavigateButton-Pressable.*'")
    public WebElement doneBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*StatusText.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*StatusText.*'")
    public List<WebElement> pendingRequest;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.RequestDetailsScreen:PrimaryButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.RequestDetailsScreen:PrimaryButton-Pressable")
    public WebElement payButton;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.RequestDetailsScreen:SecondaryButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.RequestDetailsScreen:SecondaryButton-Pressable")
    public WebElement rejectButton;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.RequestDetailsScreen:RejectRequestYesButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.RequestDetailsScreen:RejectRequestYesButton-Pressable")
    public WebElement acceptRejectionButton;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.RequestDetailsScreen:DaysButtonStack\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.RequestDetailsScreen:DaysButtonStack")
    public WebElement purposeTransferDDL;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.RequestDetailsScreen:PurposesOfTransferModal-RadioButton-4\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.RequestDetailsScreen:PurposesOfTransferModal-RadioButton-4")
    public WebElement investmentChoice;
    @AndroidFindBy(uiAutomator = "className(\"android.view.ViewGroup\").childSelector(className(\"android.widget.TextView\"))")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeScrollView/**/XCUIElementTypeOther/**/XCUIElementTypeOther/**/XCUIElementTypeOther")
    public List<WebElement> itemList;
    @AndroidFindBy(className = "android.widget.ScrollView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
    public WebElement listScrollView;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.RequestDetailsScreen:PurposesOfTransferModal-SelectButtonView-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.RequestDetailsScreen:PurposesOfTransferModal-SelectButtonView-Pressable")
    public WebElement selectPurposeBtn;
//    @AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
  @AndroidFindBy(xpath ="//android.view.ViewGroup[@resource-id=\"InternalTransfers.RequestDetailsScreen:Page\"]" )
    @iOSXCUITFindBy(accessibility = "InternalTransfers.RequestDetailsScreen:ScrollView")
    public WebElement ipsScreenContainer;

    public void clickOnNeraToNera(){
        tapOn(NeraToNeraBtn);
    }
    public void clickOnCroToARB(){
        tapOn(croToARBBtn);
    }
    public void clickOnCroToLocal(){
        tapOn(croToLocalBtn);
    }

    public void addNewNeraBeneficiary(){
        tapOn(addNewBeneficiaryBtn);
        tapOn(addNeraBeneficiaryBtn);
    }
    public void addNewARBBeneficiary(){
        tapOn(addNewBeneficiaryBtn);
        tapOn(addARBBeneficiaryBtn);
    }

    public void sendToNewARBBeneficiary()  {
        waitUntilElementAppear(sendToNewBeneficiaryBtn,30);
        tapOn(sendToNewBeneficiaryBtn);
    }
    public void addNewLocalBeneficiary(){
        tapOn(addNewBeneficiaryBtn);
        tapOn(addLocalBeneficiaryBtn);
    }

    public void  backToHomeScreen()  {
        tapOn(backBtn);
    }
    public void  tapOnPayBut()  {
        tapOn(payButton);
    }
    public void  tapOnRejectBut()  {
        tapOn(rejectButton);
    }

    public void clickOnRequestToPay(){
        tapOn(RequestToPayButton);
    }
    public void clickOnToLocalBank(){
        tapOn(toLocalBank);
    }
    public void clickOnToNeraBank(){
        tapOn(toCroBank);
    }
    public void tapOnCreateRequest(){
        tapOn(createRequest);
    }
    public void tapOnDoneBtn(){
        tapOn(doneBtn);
    }
    public void tapOnReceivedRequest(){
        tapOn(receivedRequest);
        for (WebElement element:pendingRequest)
        {
            if (element.getText().equals("Pending")){
                element.click();
                break;
            }
        }
    }
    public boolean verifyRequestStatus(String status){
        for (WebElement element:pendingRequest)
        {
            if (element.getText().equals(status)){
              return  true;
            }
        }
        return false;
    }
    public void tapOnPurposeDDL(){
        verticalScroll(ipsScreenContainer,0.8,0.2);
        waitUntilElementAppear(purposeTransferDDL,30);
        tapOn(purposeTransferDDL);
    }
    public void tapOnConfirmRejectPayment(){
        tapOn(acceptRejectionButton);
    }
    public void selectPurpose (String purpose){
        if(driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("Android"))
        {
            scrollThenTapOnElementByText(itemList,"purpose",purpose,listScrollView);

        }
        else if(driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("ios"))
        {
            tapOn(investmentChoice);

        }
        tapOn(selectPurposeBtn);
    }
    public void tapOnSettingBtn(){
        tapOn(settingBtn);
    }
    public void updateQuickTransferAmount(){
        tapOn(quickTransferSettingBtn);
        tapOn(quickTransferTransactionsLimit);
        typingTextIn(quickTransferTransactionsLimit,"2500");
        tapOn(saveChangesBtn);
        tapOn(settingBackBtn);
    }

}
