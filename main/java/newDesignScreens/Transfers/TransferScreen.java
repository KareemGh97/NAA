package newDesignScreens.Transfers;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class TransferScreen extends ScreenBase {
    public TransferScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }



    // first component
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.InternalTransferScreen:NavHeader-BackButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.TransfersLandingScreen:NavHeader-BackButton")
    public WebElement backBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.TransfersLandingScreen:NavHeader-EndButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.TransfersLandingScreen:NavHeader-EndButton")
    public WebElement settingsBtn;





    // second component
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.TransfersLandingScreen:TransferActionButtons-CroToCroTransferButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.TransfersLandingScreen:TransferActionButtons-CroToCroTransferButton")
    public WebElement neraBankTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.TransfersLandingScreen:TransferActionButtons-ToARBTransferButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.TransfersLandingScreen:TransferActionButtons-ToARBTransferButton")
    public WebElement alrajhiBankTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.TransfersLandingScreen:TransferActionButtons-LocalTransferButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.TransfersLandingScreen:TransferActionButtons-LocalTransferButton")
    public WebElement localBankTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.TransfersLandingScreen:AddBeneficiaryButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.TransfersLandingScreen:AddBeneficiaryButton")
    public WebElement addBeneficiaryTab;




    // Third component :

    //  horizontal scroll should be on this component only not in the screen
    //  all beneficiaries tab should contain the same id

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.TransfersLandingScreen:FrequentBeneficiaries-ViewAllBeneficiaries\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.TransfersLandingScreen:FrequentBeneficiaries-ViewAllBeneficiaries")
    public WebElement viewAllBeneficiariesBtn;



    // fourth component


    @AndroidFindBy(accessibility = "Standing Orders")
    @iOSXCUITFindBy(accessibility = "Standing Orders")
    public WebElement standingOrderServiceBtn;

    @AndroidFindBy(accessibility = "Sarie")
    @iOSXCUITFindBy(accessibility = "Sarie")
    public WebElement sarieServiceBtn;

    @AndroidFindBy(accessibility = "Request to Pay")
    @iOSXCUITFindBy(accessibility = "Request to Pay")
    public WebElement requestToPayServiceBtn;

    @AndroidFindBy(accessibility = "Transfer history")
    @iOSXCUITFindBy(accessibility = "Transfer history")
    public WebElement transferHistoryServiceBtn;


    public void navigateToNeraTransfer(){
        tapOn(neraBankTab);
    }

    public void navigateToAlrajhiBankTransfer(){
        tapOn(alrajhiBankTab);
    }

    public void navigateToLocalBankTransfer(){
        tapOn(localBankTab);
    }

    public void navigateToAddBeneficiary(){
        tapOn(addBeneficiaryTab);
    }

    public void navigateBackToHomeScreen(){
        tapOn(backBtn);
    }

    public void navigateToViewAllBeneficiaries(){
        tapOn(viewAllBeneficiariesBtn);
    }

    public void navigateToStandingOrder(){
        tapOn(standingOrderServiceBtn);
    }

    public void navigateToSarie(){
        tapOn(sarieServiceBtn);
    }

    public void navigateToRequestToPay(){
        tapOn(requestToPayServiceBtn);
    }

    public void navigateToTransferHistory(){
        tapOn(transferHistoryServiceBtn);
    }

    public void clickOnSettingsButton(){ tapOn(settingsBtn); }










}
