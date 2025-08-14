package StepDefs.transferSteps;

import Screens.beneficiaryScreens.ActivateBeneficiaryScreen;
import Screens.homeScreen.HomepageScreen;
import Screens.homeScreen.OTPScreen;
import Screens.homeScreen.OneTimeTransferScreen;
import Screens.homeScreen.ScreenBase;
import Screens.transferScreens.TransferConfirmationScreen;
import Screens.transferScreens.TransferDetailsScreen;
import Screens.transferScreens.TransfersScreen;
import TestBases.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static TestBases.DriverManager.getAppiumDriver;


public class requestToPaySteps extends TestBase {
    OneTimeTransferScreen oneTimeTransferScreen;
    TransferDetailsScreen transferDetailsScreen;
    TransferConfirmationScreen transferConfirmationScreen;
    TransfersScreen transfersScreen;

    OTPScreen otpScreen;
    @And("user Request to Pay from Nera using accountNumber {string}")
    public void userIPSRequestToPayNeraByUsingAccountNumber(String accountNumber)  {
        logStep("and user transfer by using receiver fullName {string} and IBAN {string}");
//        oneTimeTransferScreen=new OneTimeTransferScreen(getAppiumDriver());
//        oneTimeTransferScreen.waitUntilElementAppear(oneTimeTransferScreen.ipsTransferByAccountNumberBut,30 );
//        oneTimeTransferScreen.assertElementIsDisplayed(oneTimeTransferScreen.ipsTransferByAccountNumberBut,"ipsTransferByAccountNumberBut");
        oneTimeTransferScreen=new OneTimeTransferScreen(getAppiumDriver());
        oneTimeTransferScreen.rquestToPayToCroByAccountNumber(accountNumber);
        transferDetailsScreen =new TransferDetailsScreen(getAppiumDriver());
        transferDetailsScreen.assertElementIsDisplayed(transferDetailsScreen.confirmRequestScreenTitle,"confirmRequestScreenTitle");
        transferDetailsScreen.confirmRequestMoney("03 days");

    }
    @And("user Request to Pay from Nera using Mobile {string}")
    public void userIPSTransferByUsingMobileNumber(String mobile)  {
        logStep("and user transfer by using receiver fullName {string} and IBAN {string}");
        oneTimeTransferScreen=new OneTimeTransferScreen(getAppiumDriver());
        oneTimeTransferScreen.waitUntilElementAppear(oneTimeTransferScreen.ipsTransferByAccountNumberBut,30 );
        oneTimeTransferScreen.assertElementIsDisplayed(oneTimeTransferScreen.ipsTransferByAccountNumberBut,"ipsTransferByAccountNumberBut");
        oneTimeTransferScreen=new OneTimeTransferScreen(getAppiumDriver());
        oneTimeTransferScreen.requestToPayCroByIPSMobile(mobile);
        transferDetailsScreen =new TransferDetailsScreen(getAppiumDriver());
        transferDetailsScreen.assertElementIsDisplayed(transferDetailsScreen.confirmRequestScreenTitle,"confirmRequestScreenTitle");
        transferDetailsScreen.confirmRequestMoney("03 days");

    }
    @And("user Request to Pay from Nera using NationalID {string}")
    public void userIPSTransferByUsingNationalID(String nationalId)  {
        logStep("and user transfer by using receiver fullName {string} and IBAN {string}");
        oneTimeTransferScreen=new OneTimeTransferScreen(getAppiumDriver());
        oneTimeTransferScreen.waitUntilElementAppear(oneTimeTransferScreen.ipsTransferByAccountNumberBut,30 );
        oneTimeTransferScreen.assertElementIsDisplayed(oneTimeTransferScreen.ipsTransferByAccountNumberBut,"ipsTransferByAccountNumberBut");
        oneTimeTransferScreen=new OneTimeTransferScreen(getAppiumDriver());
        oneTimeTransferScreen.requestToPayCroByNationalId(nationalId);
        transferDetailsScreen =new TransferDetailsScreen(getAppiumDriver());
        transferDetailsScreen.assertElementIsDisplayed(transferDetailsScreen.confirmRequestScreenTitle,"confirmRequestScreenTitle");
        transferDetailsScreen.confirmRequestMoney("03 days");

    }
    @And("user Request to Pay from Nera using Email {string}")
    public void userIPSTransferByUsingEmail(String email)  {
        logStep("and user transfer by using receiver fullName {string} and IBAN {string}");
        oneTimeTransferScreen=new OneTimeTransferScreen(getAppiumDriver());
        oneTimeTransferScreen.waitUntilElementAppear(oneTimeTransferScreen.ipsTransferByAccountNumberBut,30 );
        oneTimeTransferScreen.assertElementIsDisplayed(oneTimeTransferScreen.ipsTransferByAccountNumberBut,"ipsTransferByAccountNumberBut");
        oneTimeTransferScreen=new OneTimeTransferScreen(getAppiumDriver());
        oneTimeTransferScreen.requestToPayCroByEmail(email);
        transferDetailsScreen =new TransferDetailsScreen(getAppiumDriver());
        transferDetailsScreen.assertElementIsDisplayed(transferDetailsScreen.confirmRequestScreenTitle,"confirmRequestScreenTitle");
        transferDetailsScreen.confirmRequestMoney("03 days");
    }
    
    @Then("the amount {string} Requested successfully")
    public void theAmountRequestedSuccessfully(String amount)  {
        logStep("then the amount {string}requested  successfully");
        transferConfirmationScreen =new TransferConfirmationScreen(getAppiumDriver());
        Screens.homeScreen.ScreenBase.ThreadSleep(5000);
        transferConfirmationScreen.waitUntilElementAppear(transferConfirmationScreen.requestToPayDoneBtn,30);
        transferConfirmationScreen.clickOnRTPDone();
        Screens.homeScreen.ScreenBase.ThreadSleep(5000);
        if(transferConfirmationScreen.isPendingRequest())
        {
            transferConfirmationScreen.waitUntilElementAppear(transferConfirmationScreen.RTPAmount,30);
            Assert.assertTrue(transferConfirmationScreen.getRTPAmount().contains(amount));
        } else {
            Assert.fail("RTP failed");
        }
        transferConfirmationScreen.clickBackBtn();
    }

    @Then("user accept Nera request to pay from receiver screen")
    public void userAcceptCroRequestToPayFromReceiverScreen()  {
        transfersScreen=new TransfersScreen(getAppiumDriver());
        transfersScreen.tapOnReceivedRequest();
        transfersScreen.assertElementIsDisplayed(transfersScreen.payButton,"payButton");
        Screens.homeScreen.ScreenBase.ThreadSleep(6000);
        transfersScreen.tapOnPayBut();
        Screens.homeScreen.ScreenBase.ThreadSleep(3000);
        transfersScreen.tapOnPurposeDDL();
        transfersScreen.selectPurpose("Investment");
        transfersScreen.tapOnPayBut();

    }

    @Then("the RTP accepted successfully")
    public void theAmountAcceptedSuccessfully()  {

        transferConfirmationScreen =new TransferConfirmationScreen(getAppiumDriver());
        ScreenBase.ThreadSleep(5000);

        transferConfirmationScreen.assertElementIsDisplayed(transferConfirmationScreen.confirmRTPDoneBtn,"confirmRTPDoneButton");
        ScreenBase.ThreadSleep(12000);

        transferConfirmationScreen.clickOncConfirmRTPDoneBtn();

        transferConfirmationScreen.assertElementIsDisplayed(transferConfirmationScreen.detaileScreenBackBtn,"detaileScreenBackButton");
        Assert.assertTrue(transferConfirmationScreen.getRequestStatus());

    }

    @And("user enter RTP {string}")
    public void userEnterRTP(String otp)  {
        logStep("And user enter {string}");
        Screens.homeScreen.ScreenBase.ThreadSleep(5000);

        otpScreen=new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp(otp);

        transferConfirmationScreen =new TransferConfirmationScreen(getAppiumDriver());
        transferConfirmationScreen.assertElementIsDisplayed(transferConfirmationScreen.confirmRTPDoneBtn,"confirmRTPDoneButton");

    }

    @Then("receiver reject RTP")
    public void userReceiverRejectRTP() {
        transfersScreen=new TransfersScreen(getAppiumDriver());
        transfersScreen.tapOnReceivedRequest();
        transfersScreen.waitUntilElementAppear(transfersScreen.rejectButton,30);
        transfersScreen.assertElementIsDisplayed(transfersScreen.rejectButton,"rejectButton");
        transfersScreen.tapOnRejectBut();
        transfersScreen.waitUntilElementAppear(transfersScreen.acceptRejectionButton,30);
        transfersScreen.assertElementIsDisplayed(transfersScreen.acceptRejectionButton,"acceptRejectionButton");
        transfersScreen.tapOnConfirmRejectPayment();


    }

    @And("verify request status is {string}")
    public void verifyRequestStatusIs(String status)  {
        Screens.homeScreen.ScreenBase.ThreadSleep(5000);
        Assert.assertTrue(transfersScreen.verifyRequestStatus(status));
    }

    @When("user accept RTP popup")
    public void userAcceptRTPPopup() {
        HomepageScreen homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.tapOnAcceptRtpPopup();
    }

    @When("user select later for RTP popup")
    public void userSelectLaterForRTPPopup() {
        HomepageScreen homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.tapOnRemindMeLater();
    }

    @Then("tap on done for adding RTP beneficiary")
    public void tapOnDoneForAddingRTPBeneficiary() {
        transfersScreen=new TransfersScreen(getAppiumDriver());
        transfersScreen.tapOnDoneBtn();
        transferDetailsScreen =new TransferDetailsScreen(getAppiumDriver());
        transferDetailsScreen.assertElementIsDisplayed(transferDetailsScreen.confirmRequestScreenTitle,"confirmRequestScreenTitle");
        transferDetailsScreen.confirmRequestMoney("03 days");
    }

    @And("user click back from beneficiary details screen")
    public void userClickBackFromBeneficiaryDetailsScreen() {
        ActivateBeneficiaryScreen activateBeneficiaryScreen = new ActivateBeneficiaryScreen(getAppiumDriver());
        activateBeneficiaryScreen.tapOnCloseBeneficiaryDetailsScreen();
    }

    @And("user click back from RTP screen")
    public void userClickBackFromRTPScreen() {
        transferConfirmationScreen.waitUntilElementAppear(transferConfirmationScreen.backBtn,30);
        transferConfirmationScreen.clickBackBtn();
        transferConfirmationScreen.assertElementIsDisplayed(transferConfirmationScreen.backBtn, "Transfer screen "); // checking if the back button in the Transfer screen is displayed
    }
}
