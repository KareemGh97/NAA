package StepDefs.transferSteps;

import Screens.homeScreen.IVRScreen;
import Utilities.DataBase.DynamicDatabaseConnectionManager;
import Screens.beneficiaryScreens.ActivateBeneficiaryScreen;
import Screens.beneficiaryScreens.BeneficiariesListScreen;
import Screens.beneficiaryScreens.BeneficiaryDetailsScreen;
import Screens.beneficiaryScreens.EnterBeneficiaryDetailsScreen;
import Screens.homeScreen.HomepageScreen;
import Screens.homeScreen.OTPScreen;
import Screens.transferScreens.TransfersScreen;
import TestBases.TestBase;
import Utilities.commonClasses.AppConstants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static TestBases.DriverManager.getAppiumDriver;

public class beneficiaryTest extends TestBase {

    HomepageScreen homepageScreen = new HomepageScreen(getAppiumDriver());
    TransfersScreen transfersScreen = new TransfersScreen(getAppiumDriver());
    EnterBeneficiaryDetailsScreen enterBeneficiaryDetailsScreen = new EnterBeneficiaryDetailsScreen(getAppiumDriver());
    ActivateBeneficiaryScreen activateBeneficiaryScreen = new ActivateBeneficiaryScreen(getAppiumDriver());
    BeneficiaryDetailsScreen beneficiaryDetailsScreen = new BeneficiaryDetailsScreen(getAppiumDriver());
    OTPScreen otpScreen = new OTPScreen(getAppiumDriver());

    @And("user Add active beneficiary by using phoneNumber {string} and nickName {string}")
    public void userAddActiveBeneficiaryByUsingPhoneNumber(String phoneNumber, String nickname) {

        enterBeneficiaryDetailsScreen.addBeneficiaryByUsingMobileNumber(phoneNumber, nickname);

        activateBeneficiaryScreen.tapOnConfirmBtn();

        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp("0000");

        //beneficiaryDetailsScreen.waitUntilElementAppear(beneficiaryDetailsScreen.sendMoneyBtn, 10);
        //beneficiaryDetailsScreen.assertElementIsDisplayed(beneficiaryDetailsScreen.sendMoneyBtn, "sendMoneyButton");

    }


    @And("user Add active beneficiary by using IBAN {string} and nickName {string}")
    public void userAddBeneficiaryByUsingIBAN(String iban, String nickName) {

        enterBeneficiaryDetailsScreen.addBeneficiaryByUsingIBAN(iban, nickName);

        activateBeneficiaryScreen.tapOnConfirmBtn();

        otpScreen.waitUntilElementAppear(otpScreen.otpEt.get(0), 30);
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp("0000");

        //pass iVR
        IVRScreen ivrScreen = new IVRScreen(getAppiumDriver());
        ivrScreen.passIVR();


        //beneficiaryDetailsScreen.waitUntilElementAppear(beneficiaryDetailsScreen.sendMoneyBtn, 49);
        //beneficiaryDetailsScreen.assertElementIsDisplayed(beneficiaryDetailsScreen.sendMoneyBtn, "sendMoneyButton");
    }

    @And("user Add active beneficiary by using local IBAN {string} and nickName {string}")
    public void userAddBeneficiaryByUsingLocalIBAN(String iban, String nickName) {

        enterBeneficiaryDetailsScreen.addLocalBeneficiaryByUsingIBAN(iban, nickName);

        activateBeneficiaryScreen.tapOnConfirmBtn();

       // beneficiaryDetailsScreen.assertElementIsDisplayed(beneficiaryDetailsScreen.sendMoneyBtn, "sendMoneyButton");
    }

    @And("user Add active beneficiary by using AccountNumber {string} and nickName {string}")
    public void userAddBeneficiaryByUsingAccountNumber(String accountNumber, String nickname) {

        enterBeneficiaryDetailsScreen.addBeneficiaryByUsingAccountNumber(accountNumber, nickname);

        activateBeneficiaryScreen.tapOnConfirmBtn();


        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp("0000");

        Screens.homeScreen.ScreenBase.ThreadSleep(10000);
    }

    @And("user Add active beneficiary by using nationalId {string} and nickName {string}")
    public void userAddActiveBeneficiaryByUsingNationalId(String nationalId, String nickname) {

        enterBeneficiaryDetailsScreen.addBeneficiaryByUsingNationalId(nationalId, nickname);

        activateBeneficiaryScreen.tapOnConfirmBtn();

        otpScreen.waitUntilElementAppear(otpScreen.otpEt.get(0), 30);
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp("0000");

    }

    @And("user Add Nera beneficiary")
    public void userAddNeraBeneficiary() {
        transfersScreen.addNewNeraBeneficiary();
    }

    @And("user send to new beneficiary")
    public void sendToAddCRONationalBeneficiary() {
        transfersScreen.sendToNewARBBeneficiary();
    }

    @And("user activate the added beneficiary")
    public void userActivateTheAddedBeneficiary() {
        activateBeneficiaryScreen.tapOnConfirmBtn();

        beneficiaryDetailsScreen.backToTransferScreen();
    }

    @And("user Add ARB beneficiary")
    public void userAddARBBeneficiary() {

        if (TestBase.environment.equalsIgnoreCase("sit")) {
            homepageScreen.clickOnQuickActionByText("Transfer");

        } else if (TestBase.environment.equalsIgnoreCase("uat")) {
            homepageScreen.clickOnQuickActionByText("Transfers");

        }

        transfersScreen.addNewARBBeneficiary();
        enterBeneficiaryDetailsScreen = new EnterBeneficiaryDetailsScreen(getAppiumDriver());
//        Assert.assertTrue(enterBeneficiaryDetailsScreen.ibanEt.isDisplayed());
//        Assert.assertTrue(enterBeneficiaryDetailsScreen.ibanNickNameEt.isDisplayed());
    }

    @And("user Add Local beneficiary")
    public void userAddLocalBeneficiary() {

        if (TestBase.environment.equalsIgnoreCase("sit")) {
            homepageScreen.clickOnQuickActionByText("Transfer");

        } else if (TestBase.environment.equalsIgnoreCase("uat")) {
            homepageScreen.clickOnQuickActionByText("Transfers");

        }

        transfersScreen.addNewLocalBeneficiary();
        enterBeneficiaryDetailsScreen = new EnterBeneficiaryDetailsScreen(getAppiumDriver());
        enterBeneficiaryDetailsScreen.assertElementIsDisplayed(enterBeneficiaryDetailsScreen.localIbanEt, "localIbanEt");
        enterBeneficiaryDetailsScreen.assertElementIsDisplayed(enterBeneficiaryDetailsScreen.localIbanNickNameEt, "localIbanNickNameEt");
    }

    @And("user edit beneficiary nickName{string}")
    public void userEditBeneficiaryNickName(String newNickName) {

        beneficiaryDetailsScreen.editNickname(newNickName);
        Assert.assertEquals(beneficiaryDetailsScreen.nickNameTxt.getText(), newNickName);
    }

    @And("user delete beneficiary")
    public void userDeleteBeneficiary() {

        beneficiaryDetailsScreen.deleteBeneficiary();
        Screens.homeScreen.ScreenBase.ThreadSleep(4000);

        transfersScreen.backToHomeScreen();

        homepageScreen.assertElementIsDisplayed(homepageScreen.SettingsBtn, "SettingsButton");
    }


    @And("user delete beneficiary if exist by using DataBase{string}")
    public void userDeleteBeneficiaryIfExistByUsingDataBase(String cic) throws SQLException, ClassNotFoundException, IOException {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cic", cic);
        String[] connectionDetails = DynamicDatabaseConnectionManager.getConnectionForScenario("TRANSFER_DB_CIT");
        if (connectionDetails == null) {
            throw new RuntimeException("No database configuration found for scenario: " + "AUTHENTICATION_DB_CIT");
        }

        String serverIP = connectionDetails[0];
        String port = connectionDetails[1];
        String serviceName = connectionDetails[2];
        String user = connectionDetails[3];
        String password = connectionDetails[4];
        if (cic == null) {
            cic = AppConstants.cic.get();
        }
        parameters.put("cic", cic);
        DynamicDatabaseConnectionManager.dataBaseConnection(serverIP, port, serviceName, user, password);
        DynamicDatabaseConnectionManager.executePreparedQueries(String.valueOf(Paths.get(System.getProperty("user.dir"), "src/main/java/properties/DataBaseQueries.sql")), "DeleteAllBeneficiariesForUserByUserCic", parameters);
        DynamicDatabaseConnectionManager.clearThreadLocalConnections();

    }

    @And("user Add active beneficiary by adding Arb mobile number {string} and nickName {string}")
    public void userAddActiveBeneficiaryByAddingArbMobileNumberAndNickName(String phoneNumber, String nickname) {
        logStep("And user transfer by using receiver phoneNumber {string}");
        enterBeneficiaryDetailsScreen.addBeneficiaryByUsingMobileNumber(phoneNumber, nickname);

        activateBeneficiaryScreen.tapOnConfirmBtn();
        otpScreen.userEnterOtp("0000");

        Screens.homeScreen.ScreenBase.ThreadSleep(10000);
    }

    @Then("user activate beneficiary {string}")
    public void userActivateBeneficiary(String transferType) {
        BeneficiariesListScreen beneficiariesListScreen = new BeneficiariesListScreen(getAppiumDriver());
        Screens.homeScreen.ScreenBase.ThreadSleep(3000);
        beneficiariesListScreen.waitUntilElementAppear(beneficiariesListScreen.viewAll, 40);
        beneficiariesListScreen.tapOnBeneficiaries(transferType);

        activateBeneficiaryScreen.assertElementIsDisplayed(activateBeneficiaryScreen.activateBtn, "activateButton");
        activateBeneficiaryScreen.activateExistingBeneficiary();

        //beneficiaryDetailsScreen.assertElementIsDisplayed(beneficiaryDetailsScreen.sendMoneyBtn, "sendMoneyButton");
    }

    @And("user add and active beneficiary by using {string} as {string} and nickName as {string}")
    public void userAddAndActiveBeneficiaryByUsingAsAndNickNameAs(String type, String identifierNumber, String nickName) {
        Screens.homeScreen.ScreenBase.ThreadSleep(3000);

        switch (type.toLowerCase()) {
            case "iban" -> {
                enterBeneficiaryDetailsScreen.assertElementIsDisplayed(enterBeneficiaryDetailsScreen.ibanTab, "ibanTab");
                enterBeneficiaryDetailsScreen.addBeneficiaryByUsingIBAN(identifierNumber, nickName);
            }
            case "accountnumber" -> {
                enterBeneficiaryDetailsScreen.assertElementIsDisplayed(enterBeneficiaryDetailsScreen.accountTab, "accountTab");
                enterBeneficiaryDetailsScreen.addBeneficiaryByUsingAccountNumber(identifierNumber, nickName);
            }
            case "nationalid" -> {
                enterBeneficiaryDetailsScreen.assertElementIsDisplayed(enterBeneficiaryDetailsScreen.nationalIdTab, "nationalIdTab");
                enterBeneficiaryDetailsScreen.addBeneficiaryByUsingNationalId(identifierNumber, nickName);
            }
            case "phonenumber" -> {
                enterBeneficiaryDetailsScreen.assertElementIsDisplayed(enterBeneficiaryDetailsScreen.mobileTab, "mobileTab");
                enterBeneficiaryDetailsScreen.addBeneficiaryByUsingMobileNumber(identifierNumber, nickName);
            }
            default -> throw new RuntimeException("not valid Beneficiary type " + type);
        }
        activateBeneficiaryScreen.tapOnConfirmBtn();

        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp("0000");

        Screens.homeScreen.ScreenBase.ThreadSleep(10000);
        IVRScreen IVRScreen = new IVRScreen(getAppiumDriver());
        IVRScreen.passIVR();

    }

    @Then("user select active beneficiary")
    public void userActivateBeneficiary() {
        BeneficiariesListScreen beneficiariesListScreen = new BeneficiariesListScreen(getAppiumDriver());
        Screens.homeScreen.ScreenBase.ThreadSleep(3000);
        //beneficiariesListScreen.waitUntilElementAppear(beneficiariesListScreen.viewAll, 40);
        beneficiariesListScreen.tapOnActiveBeneficiary();
        System.out.println(" $$$ tapped successfully on Active Beneficiary!");

       // activateBeneficiaryScreen.assertElementIsDisplayed(activateBeneficiaryScreen.activateBtn, "activateButton");
        //activateBeneficiaryScreen.activateExistingBeneficiary();

        //beneficiaryDetailsScreen.assertElementIsDisplayed(beneficiaryDetailsScreen.sendMoneyBtn, "sendMoneyButton");
    }
}
