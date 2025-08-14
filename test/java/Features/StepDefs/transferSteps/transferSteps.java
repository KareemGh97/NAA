package StepDefs.transferSteps;

import Utilities.DataBase.DynamicDatabaseConnectionManager;
import Screens.beneficiaryScreens.ActivateBeneficiaryScreen;
import Screens.beneficiaryScreens.EnterBeneficiaryDetailsScreen;
import Screens.homeScreen.HomepageScreen;
import Screens.homeScreen.OTPScreen;
import Screens.homeScreen.OneTimeTransferScreen;
import Screens.transferScreens.TransferAmountScreen;
import Screens.transferScreens.TransferConfirmationScreen;
import Screens.transferScreens.TransferDetailsScreen;
import Screens.transferScreens.TransfersScreen;
import Utilities.APIs.CommonAPIs;


import TestBases.TestBase;
import Utilities.commonClasses.AppConstants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import newDesignScreens.Transfers.MoneyTransferScreen;
import newDesignScreens.Transfers.TransferScreen;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static TestBases.DriverManager.getAppiumDriver;


public class transferSteps extends TestBase {

    HomepageScreen homepageScreen;
    TransferScreen transfersScreen = new TransferScreen(getAppiumDriver());
    MoneyTransferScreen moneyTransferScreen = new MoneyTransferScreen(getAppiumDriver());
    OneTimeTransferScreen oneTimeTransferScreen = new OneTimeTransferScreen(getAppiumDriver());
    TransferDetailsScreen transferDetailsScreen = new TransferDetailsScreen(getAppiumDriver());
    OTPScreen otpScreen;
    TransferConfirmationScreen transferConfirmationScreen;
    CommonAPIs commonAPIs;


    @When("user select Nera to Nera transfer")
    public void userSelectNeraToNeraTransfer() {
        logStep("When user select Nera to Nera transfer");

        transfersScreen.navigateToNeraTransfer();
        moneyTransferScreen.assertElementIsDisplayed(moneyTransferScreen.continueBtn, "continueButton");
    }

    @When("user set the amount {string} of transfer")
    public void userSetTheAmountOfTransfer(String amount) {
        logStep("when user set the amount {string} of transfer");

        moneyTransferScreen.tapOnTransferAmountField();
        moneyTransferScreen.enterAmount(amount);
        moneyTransferScreen.clickOnContinue();
        AppConstants.TransferAmount = Double.parseDouble(amount); //+FEES;
    }

    @When("user set the amount {string} of local transfer")
    public void userSetTheAmountOfLocalTransfer(String amount) {
        logStep("when user set the amount {string} of transfer");

        moneyTransferScreen.enterAmount(amount);
//        moneyTransferScreen.pressEnter();
        moneyTransferScreen.clickOnContinue();
        int amountInInteger = (int) Double.parseDouble(amount);
        if (amountInInteger <= 20000) {
            oneTimeTransferScreen.assertElementIsDisplayed(oneTimeTransferScreen.beneficiariesLocalTab, "beneficiariesLocalTab");
            AppConstants.TransferAmount = Double.parseDouble(amount);//+FEES;
        }

    }

    @And("user set the amount {string} greater than the limit of transfer")
    public void userSetTheAmountGreaterThanTheLimitOfTransfer(String amount) {
        logStep("And user set the amount {string} greater than the limit of transfer");

        moneyTransferScreen.tapOnTransferAmountField();
        moneyTransferScreen.enterAmount(amount);
        moneyTransferScreen.assertElementIsDisplayed(moneyTransferScreen.continueBtn, "continueButton");
        moneyTransferScreen.clickOnContinue();
        try {
            moneyTransferScreen.assertElementIsDisplayed(moneyTransferScreen.continueBtn, "continueButton");
        } catch (NoSuchElementException e) {
            moneyTransferScreen.assertElementIsDisplayed(moneyTransferScreen.continueBtn, "continueBtnForLocalTransfer");
        }
    }

    @When("user transfer by using receiver AccountNumber {string}")
    public void userTransferByUsingReceiverAccountNumber(String string) {
        logStep("when user transfer by using receiver AccountNumber {string}");
        
        oneTimeTransferScreen.assertElementIsDisplayed(oneTimeTransferScreen.accountNumberTab, "accountNumberTab");
        oneTimeTransferScreen.transferByAccountNumber(string);

        transferDetailsScreen.confirmSendMoney();
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
    }

    @When("user transfer by send Money now")
    public void userTransferBySendMoneyNow() {
        logStep("when user transfer by using receiver AccountNumber {string}");
        transferDetailsScreen.confirmSendMoney();
    }

    @And("user enter OTP")
    public void userEnterOtp() {
        logStep("And user enter {string}");


    }

    @Then("the amount transferred successfully")
    public void theAmountTransferredSuccessfully() {
        logStep("then the amount {string}transferred successfully");
        Screens.homeScreen.ScreenBase.ThreadSleep(5000);

        transferConfirmationScreen = new TransferConfirmationScreen(getAppiumDriver());
        transferConfirmationScreen.waitUntilElementAppear(transferConfirmationScreen.doneBtn, 30);
        transferConfirmationScreen.assertElementIsDisplayed(transferConfirmationScreen.doneBtn, "doneButton");
        transferConfirmationScreen.clickOnDone();

        transferConfirmationScreen.assertElementIsDisplayed(transferConfirmationScreen.backBtn, "Transfer screen "); // checking if the back button in the Transfer screen is displayed

//        transferConfirmationScreen.clickBackBtn();
//        AppConstants.Balance_After_Transfer= Double.valueOf(homepageScreen.getTextNavigateToAccountBtn().replace(",",""));
//        Assert.assertEquals(AppConstants.Balance_After_Transfer,AppConstants.Balance_Before_Transfer-AppConstants.TransferAmount);
    }

    @And("user transfer by using receiver phoneNumber {string}")
    public void userTransferByUsingReceiverPhoneNumber(String string) {
        logStep("and user transfer by using receiver phoneNumber {string}");
        
        oneTimeTransferScreen.transferByMobileNumber(string);


        transferDetailsScreen.confirmSendMoney();

    }

    @And("user transfer {string} by using receiver nationalId {string}")
    public void userTransferByUsingReceiverNationalId(String transferType, String nationalId) {
        logStep("And user transfer by using receiver nationalId {string}");
        
        oneTimeTransferScreen.transferByNationalId(nationalId, transferType);

        transferDetailsScreen.confirmSendMoney();
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
    }

    @And("user transfer by using beneficiary nationalId {string}")
    public void userTransferByUsingBeneficiaryNationalId(String nationalId) {
        logStep("And user transfer by using receiver nationalId {string}");
        
        oneTimeTransferScreen.transferByBeneficiaryNationalId(nationalId, "AutomationNational");
        ActivateBeneficiaryScreen activateBeneficiaryScreen = new ActivateBeneficiaryScreen(getAppiumDriver());
        activateBeneficiaryScreen.tapOnConfirmBtn();
        otpScreen = new OTPScreen(getAppiumDriver());
        otpScreen.userEnterOtp("0000");
        Screens.homeScreen.ScreenBase.ThreadSleep(10000);
    }

    @And("user transfer {string} by using receiver email {string}")
    public void userTransferByUsingReceiverEmail(String transferType, String email) {
        logStep("And user transfer by using receiver email {string}");
        


        oneTimeTransferScreen.transferByEmail(email, transferType);
        transferDetailsScreen.confirmSendMoney();

    }

    @And("user transfer to arb by using receiver email {string}")
    public void userTransferToArbByUsingReceiverEmail(String arg0) {
        logStep("And user transfer by using receiver email {string}");
        
        oneTimeTransferScreen.transferToArbByEmail(arg0);

        transferDetailsScreen.confirmSendMoney();
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
    }

    @And("user select Cro to ARB transfer")
    public void userSelectCroToARBTransfer() {
        logStep("and user select Cro to ARB transfer");
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.clickOnQuickActionByText("Transfer");

        transfersScreen.navigateToAlrajhiBankTransfer();

        moneyTransferScreen.assertElementIsDisplayed(moneyTransferScreen.continueBtn, "continueButton");

    }

    @And("user transfer by using receiver fullName {string} and IBAN {string}")
    public void userTransferByUsingReceiverIBAN(String fullName, String IBAN) {
        logStep("and user transfer by using receiver fullName {string} and IBAN {string}");
        
        oneTimeTransferScreen.transferByIBAN(fullName, IBAN);

        transferDetailsScreen.waitUntilElementAppear(transferDetailsScreen.listScrollView, 10);
        transferDetailsScreen.confirmSendMoney();
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
    }

    @And("user local transfer by using receiver fullName {string} and IBAN {string}")
    public void userLocalTransferByUsingReceiverIBAN(String fullName, String IBAN) {
        logStep("and user transfer by using receiver fullName {string} and IBAN {string}");
        
        oneTimeTransferScreen.transferByLocalIBAN(fullName, IBAN);

        transferDetailsScreen.confirmSendMoney();
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
    }

    @And("user select Cro to Local transfer")
    public void userSelectCroToLocalTransfer() {
        logStep("and user select Cro to Local transfer");
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.clickOnQuickActionByText("Transfer");

//        if (TestBase.environment.equalsIgnoreCase("UAT")) {
//            transfersScreen.clickOnSettingsButton();
//            transfersScreen.updateQuickTransferAmount();
//        }
        transfersScreen.navigateToLocalBankTransfer();

        moneyTransferScreen.assertElementIsDisplayed(moneyTransferScreen.continueBtn, "continueBtnForLocalTransfer");
        AppConstants.TransferType = "LocalTransfer";

    }

    @And("user update registered device Date in DataBase by using CIC {string} with -7 days by using dataBase")
    public void userUpdateRegisteredDeviceDateInDataBaseByUsingCICWithDays(String cic) throws SQLException, ClassNotFoundException, IOException {
        logStep("and user update registered device Date in DataBase by using CIC {string} with -7 days");
        String[] connectionDetails = DynamicDatabaseConnectionManager.getConnectionForScenario("AUTHENTICATION_DB_CIT");
        if (connectionDetails == null) {
            throw new RuntimeException("No database configuration found for scenario: " + "AUTHENTICATION_DB_CIT");
        }
        if (cic.matches("\\d+"))
            AppConstants.cic.set(cic);

        String serverIP = connectionDetails[0];
        String port = connectionDetails[1];
        String serviceName = connectionDetails[2];
        String user = connectionDetails[3];
        String password = connectionDetails[4];
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cic", AppConstants.cic.get());
        DynamicDatabaseConnectionManager.dataBaseConnection(serverIP, port, serviceName, user, password);
        DynamicDatabaseConnectionManager.executePreparedQueries(String.valueOf(Paths.get(System.getProperty("user.dir"), "src/main/java/properties/DataBaseQueries.sql")), "ChangeTheRegisteredDateToBeBeforeTheCurrentDateBySevenDays", parameters);
        DynamicDatabaseConnectionManager.clearThreadLocalConnections();

    }

    @And("user remove restriction for the user")
    public void userRemoveRestrictionRTP() {
        commonAPIs = new CommonAPIs();
        commonAPIs.removeRestriction(AppConstants.cic.get());
    }

    @And("user set the amount {string} of transfer greater Than the limit")
    public void userSetTheAmountOfTransferGreaterThanTheLimit(String amount) {

        moneyTransferScreen.tapOnTransferAmountField();
        moneyTransferScreen.enterAmount(amount);
        moneyTransferScreen.assertElementIsDisplayed(moneyTransferScreen.continueBtn, "continueButton");
    }

    @When("user is not able to transfer the amount")
    public void userIsNotAbleToTransferTheAmount() {
        Assert.assertFalse(moneyTransferScreen.continueBtn.isEnabled(), "Element should be disabled");
    }

    @And("user topUp his account {string} with balance {string} by using API")
    public void userTopUpHisAccountWithBalanceByUsingAPI(String account, String balance) {
        CommonAPIs commonAPIs = new CommonAPIs();
        double FEES = 10.0;
        commonAPIs.topUpBalance(account, Double.toString(Double.parseDouble(balance) + FEES));


    }

    @And("user transfer money")
    public void userTransferMoney() {

        transferDetailsScreen.inactiveBeneficiaryConfirmSendMoney();
    }

    @And("user set the amount {string}")
    public void userSetTheAmount(String amount) {
        logStep("when user set the amount {string} of transfer");

        moneyTransferScreen.assertElementIsDisplayed(moneyTransferScreen.continueBtn, "continueButton");
        moneyTransferScreen.enterAmount(amount);
        moneyTransferScreen.clickOnContinue();
        AppConstants.TransferAmount = Double.parseDouble(amount);//+FEES;
    }

    @And("user transfer locally by using receiver phoneNumber {string} and bank {string}")
    public void userTransferLocallyByUsingReceiverPhoneNumberAndBank(String phoneNumber, String bankName) {
        logStep("and user transfer by using receiver fullName {string} and phone {string}");
        
        oneTimeTransferScreen.transferByLocalMobile(bankName, phoneNumber);

        transferDetailsScreen.confirmSendMoney();
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
    }

    @And("user transfer by using active {string} existing beneficiary")
    public void userTransferByUsingActiveExistingBeneficiary(String transferType) {
        logStep("and user transfer by using receiver fullName {string} and IBAN {string}");
        oneTimeTransferScreen.clickOnActiveBeneficiary(transferType);
        transferDetailsScreen.confirmSendMoney();
    }

    @And("user select request to pay transfer")
    public void userSelectRequestToPayTransfer() {
        logStep("and user select request to pay");
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.clickOnQuickActionByText("Transfer");

//        transfersScreen.clickOnRequestToPay();
//        Screens.homeScreen.ScreenBase.ThreadSleep(5000);
//        transfersScreen.waitUntilElementAppear(transfersScreen.toCroBank, 30);
    }

    @Then("user create new request")
    public void userCreateNewRequest() {
        logStep("and user select Cro to local transfer");

//        transfersScreen.tapOnCreateRequest();
//
//        moneyTransferScreen.waitUntilElementAppear(moneyTransferScreen.createRequestContinueBtn, 30);
//        moneyTransferScreen.assertElementIsDisplayed(moneyTransferScreen.createRequestContinueBtn, "createRequestContinueButton");
    }

    @And("user set the amount {string} of request")
    public void userSetTheAmountOfRequest(String amount) {
        logStep("when user set the amount {string} of transfer");

//        moneyTransferScreen.assertElementIsDisplayed(moneyTransferScreen.createRequestContinueBtn, "createRequestContinueButton");
//        moneyTransferScreen.tapOnAmountField();
//        moneyTransferScreen.enterAmount(amount);
//        moneyTransferScreen.pressDone();
//        moneyTransferScreen.tapOnCreateRequestContinueBtn();

    }

    @And("user IPS transfer by using receiver fullName {string} and IBAN {string} and BankName {string}")
    public void userIPSTransferByUsingReceiverFullNameAndIBANAndBankName(String fullName, String IBAN, String bankName) {
        logStep("and user transfer by using receiver fullName {string} and IBAN {string}");
        
        oneTimeTransferScreen.waitUntilElementAppear(oneTimeTransferScreen.ipsTransferByIbanBut, 30);
        oneTimeTransferScreen.assertElementIsDisplayed(oneTimeTransferScreen.ipsTransferByIbanBut, "ipsTransferByIbanBut");
        
        oneTimeTransferScreen.transferByIPSIBAN(fullName, IBAN, bankName);

        transferDetailsScreen.assertElementIsDisplayed(transferDetailsScreen.confirmRequestScreenTitle, "confirmRequestScreenTitle");
        transferDetailsScreen.confirmRequestMoney("03 days");
    }

    @And("user IPS transfer by using receiver mobile {string} and BankName {string}")
    public void userIPSTransferByUsingReceiverMobileAndBankName(String mobileNumber, String bankName) {
        logStep("and user transfer by using receiver fullName {string} and IBAN {string}");
        
        oneTimeTransferScreen.waitUntilElementAppear(oneTimeTransferScreen.ipsTransferByIbanBut, 30);
        oneTimeTransferScreen.assertElementIsDisplayed(oneTimeTransferScreen.ipsTransferByIbanBut, "ipsTransferByIbanBut");
        
        oneTimeTransferScreen.transferByIPSMobile(mobileNumber, bankName);

        transferDetailsScreen.assertElementIsDisplayed(transferDetailsScreen.confirmRequestScreenTitle, "confirmRequestScreenTitle");
        transferDetailsScreen.confirmRequestMoney("03 days");
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
    }

    @And("user IPS transfer by using receiver ID {string} and BankName {string}")
    public void userIPSTransferByUsingReceiverIDAndBankName(String nationalId, String bankName) {
        logStep("and user transfer by using receiver fullName {string} and IBAN {string}");
        
        oneTimeTransferScreen.waitUntilElementAppear(oneTimeTransferScreen.ipsTransferByIbanBut, 30);
        oneTimeTransferScreen.assertElementIsDisplayed(oneTimeTransferScreen.ipsTransferByIbanBut, "ipsTransferByIbanBut");
        
        oneTimeTransferScreen.transferByIPSNationalId(nationalId, bankName);

        transferDetailsScreen.assertElementIsDisplayed(transferDetailsScreen.confirmRequestScreenTitle, "confirmRequestScreenTitle");
        transferDetailsScreen.confirmRequestMoney("03 days");
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
    }

    @And("user IPS transfer by using receiver email {string} and BankName {string}")
    public void userIPSTransferByUsingReceiverEmailAndBankName(String email, String bankName) {
        logStep("and user transfer by using receiver fullName {string} and IBAN {string}");
        
        oneTimeTransferScreen.waitUntilElementAppear(oneTimeTransferScreen.ipsTransferByIbanBut, 30);
        oneTimeTransferScreen.assertElementIsDisplayed(oneTimeTransferScreen.ipsTransferByIbanBut, "ipsTransferByIbanBut");
        oneTimeTransferScreen.transferByIPSEmail(email, bankName);

        transferDetailsScreen.assertElementIsDisplayed(transferDetailsScreen.confirmRequestScreenTitle, "confirmRequestScreenTitle");
        transferDetailsScreen.confirmRequestMoney("03 days");
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
    }

    @And("user add new RTP beneficiary")
    public void userAddNewRTPBeneficiary() {
        logStep("and user transfer by using receiver fullName {string} and IBAN {string}");
        EnterBeneficiaryDetailsScreen BeneficiaryScreen = new EnterBeneficiaryDetailsScreen(getAppiumDriver());
        BeneficiaryScreen.tapOnAddNewBeneficiary();
    }

    @And("user transfer by using local nationalId {string} and bank {string}")
    public void userTransferByUsingLocalNationalIdAndBank(String nationalId, String bankName) {
        logStep("and user transfer by using receiver fullName {string} and nationalId {string}");
        
        oneTimeTransferScreen.transferByLocalNationalId(bankName, nationalId);

        transferDetailsScreen.confirmSendMoney();
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
    }

    @And("user transfer by using receiver email {string} and bank {string}")
    public void userTransferByUsingReceiverEmailAndBank(String email, String bankName) {
        logStep("and user transfer by using receiver fullName {string} and email {string}");
        
        oneTimeTransferScreen.transferByLocalEmail(bankName, email);

        transferDetailsScreen.confirmSendMoney();
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
    }

    @And("user set the local amount {string} greater than the limit of transfer")
    public void userSetTheLocalAmountGreaterThanTheLimitOfTransfer(String amount) {
        logStep("And user set the amount {string} greater than the limit of transfer");

        moneyTransferScreen.enterAmount(amount);
        // moneyTransferScreen.pressEnter();
        try {
            moneyTransferScreen.assertElementIsDisplayed(moneyTransferScreen.continueBtn, "continueButton");
        } catch (NoSuchElementException e) {
            moneyTransferScreen.assertElementIsDisplayed(moneyTransferScreen.continueBtn, "continueBtnForLocalTransfer");
        }
    }

    @And("user select request to local bank")
    public void userSelectRequestToLocalBank() {

        transfersScreen.navigateToLocalBankTransfer();

    }

    @And("user select request to Nera bank")
    public void userSelectRequestToNeraBank() {
        transfersScreen.navigateToNeraTransfer();
    }

    @And("user remove all restrictions for the user {string}")
    public void userRemoveAllRestrictionsForTheUser(String CIC) {
        commonAPIs = new CommonAPIs();
        commonAPIs.removeRestriction(AppConstants.cic.get());
    }
    @And("user remove rtp restrictions for the user {string}")
    public void userRemoveRTPRestrictionsForTheUser(String CIC) {
        commonAPIs = new CommonAPIs();
        commonAPIs.removeRestriction(CIC);
    }
    @And("user Add active local beneficiary by adding quick IBAN {string} and nickName {string}")
    public void userAddActiveLocalBeneficiaryByAddingQuickIBANAndNickName(String iban, String nickName) {
        EnterBeneficiaryDetailsScreen enterBeneficiaryDetailsScreen;
        ActivateBeneficiaryScreen activateBeneficiaryScreen;
        enterBeneficiaryDetailsScreen = new EnterBeneficiaryDetailsScreen(getAppiumDriver());
        Screens.homeScreen.ScreenBase.ThreadSleep(3000);
        enterBeneficiaryDetailsScreen.assertElementIsDisplayed(enterBeneficiaryDetailsScreen.localIbanEt, "localIbanEt");
        enterBeneficiaryDetailsScreen.addLocalBeneficiaryByUsingIBAN(iban, nickName);
        activateBeneficiaryScreen = new ActivateBeneficiaryScreen(getAppiumDriver());
        activateBeneficiaryScreen.tapOnConfirmBtn();
        otpScreen = new OTPScreen(getAppiumDriver());
        otpScreen.userEnterOtp("0000");
        Screens.homeScreen.ScreenBase.ThreadSleep(10000);
    }

    @Then("user update transaction limit of {string} to {string}")
    public void userUpdateTransactionLimitOfTo(String cic, String amount) throws SQLException, ClassNotFoundException, IOException {
        String[] connectionDetails = DynamicDatabaseConnectionManager.getConnectionForScenario("LIMIT_MANAGEMENT_DB_CIT");
        if (connectionDetails == null) {
            throw new RuntimeException("No database configuration found for scenario: " + "AUTHENTICATION_DB_CIT");
        }

        String serverIP = connectionDetails[0];
        String port = connectionDetails[1];
        String serviceName = connectionDetails[2];
        String user = connectionDetails[3];
        String password = connectionDetails[4];
        Map<String, String> parameters = new HashMap<>();

        parameters.put("cic", AppConstants.cic.get());
        DynamicDatabaseConnectionManager.dataBaseConnection(serverIP, port, serviceName, user, password);
        DynamicDatabaseConnectionManager.executePreparedQueries(String.valueOf(Paths.get(System.getProperty("user.dir"), "src/main/java/Properties/DataBaseQueries.sql")), "UpdateTransferLimitTo50000SAR", parameters);
        DynamicDatabaseConnectionManager.clearThreadLocalConnections();

    }

    @And("add balance to user account {string}")
    public void addBalanceToUserAccount(String account) {
        CommonAPIs CommonAPIs = new CommonAPIs();
        CommonAPIs.topUpBalance(account, "100000");
    }

    @When("user open transfer screen")
    public void userOpenTransferScreen() {
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.clickOnQuickActionByText("Transfer");
    }

    @Then("user goes back to transfer screen")
    public void userGoesBackToTransferScreen() {
        ActivateBeneficiaryScreen activateBeneficiaryScreen = new ActivateBeneficiaryScreen(getAppiumDriver());
        activateBeneficiaryScreen.tapOnBeneficiaryProfileScreenBackButton();
    }
}
