package StepDefs.customerOnboardingSteps;

import Screens.deviceScreen.DeviceScreen;
import TestBases.DriverManager;
import Utilities.DataBase.DynamicDatabaseConnectionManager;
import Screens.customerOnBoardingScreens.*;
import Screens.homeScreen.HomepageScreen;
import Screens.homeScreen.IVRScreen;
import Screens.homeScreen.LockScreen;
import Screens.homeScreen.OTPScreen;
import Screens.settingScreen.SettingsScreen;
import Utilities.APIs.CommonAPIs;


import TestBases.TestBase;
import Utilities.commonClasses.AppConstants;
import Utilities.commonClasses.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static TestBases.DriverManager.getAppiumDriver;
import static Utilities.commonClasses.AppConstants.OnboardMobileNumber;
import static Utilities.commonClasses.AppConstants.Passcode;


public class signInSteps extends TestBase {
    AppIntroductionScreen appIntroductionScreen;
    OnboardingScreen onboardingScreen;
    CommonAPIs commonAPIs;
    PassCodeScreen passCodeScreen;
    OTPScreen otpScreen;
    HomepageScreen homepageScreen;
    SettingsScreen settingsScreen;
    LockScreen lockScreen;
    IVRScreen ivrScreen;
    DeviceScreen deviceScreen;
    String otp = "0000";

    private static final ThreadLocal<String[]> loginData = new ThreadLocal<>();

    @Given("activate user status {string} by using API")
    public void activateUserStatus(String CIC) {
        logStep("When activate user status" + CIC);
        commonAPIs = new CommonAPIs();
        if (CIC.equalsIgnoreCase("EMPTY")) {
            CommonAPIs.findUserCic(AppConstants.OnboardNationalID.get());
        } else {
            AppConstants.cic.set(CIC);
        }

        commonAPIs.activateUser(AppConstants.cic.get());
        commonAPIs.activateUserInCRM(AppConstants.cic.get());
    }

    @And("user SignIn oneTimeUse with phoneNumber {string} NationalId {string} passCode {string} OTP{string}")
    public void userSignInOneTimeUseWithPhoneNumberNationalIdPassCode(String phoneNumber, String nationalId, String passcode, String otp) {

        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.enterUserCredentials(phoneNumber, nationalId);
        AppConstants.OnboardNationalID.set(nationalId);

        commonAPIs = new CommonAPIs();
        Passcode.set(commonAPIs.resetPasscode(nationalId));

        OnboardMobileNumber.set(phoneNumber);
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        Screens.homeScreen.ScreenBase.ThreadSleep(7000);
        passCodeScreen.waitUntilElementAppear(passCodeScreen.zeroBtn, 20);
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        passCodeScreen.userEnterPassCode(Passcode.get());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.oneTimeUseBtn, "oneTimeUseButton");
        passCodeScreen.userChooseOneTimeUse();
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty(), "OTP screen is not showing");
        otpScreen.userEnterOtp(otp);
        ivrScreen = new IVRScreen(getAppiumDriver());
        ivrScreen.passIVR();
        homepageScreen = new HomepageScreen(getAppiumDriver());
        try {
            homepageScreen.acceptNotificationDialog();
            homepageScreen.remindMeLaterRTPNotification();
        } catch (NoSuchElementException ignored) {
        }

        homepageScreen.assertElementIsDisplayed(homepageScreen.SettingsBtn, "homeScreen");
        logStep("user SignIn oneTimeUse with phoneNumber: " + phoneNumber + "NationalId: " + nationalId + "passcode: " + Passcode.get() + "OTP: " + otp);

    }

    @And("user SignIn Register Device with phoneNumber {string} NationalId {string} passCode {string} OTP{string}")
    public void userSignInRegisterDeviceWithPhoneNumberNationalIdPassCodeOTP(String phoneNumber, String nationalId, String passcode, String otp) {
        logStep("And user SignIn Register Device with phoneNumber" + phoneNumber + "NationalId" + nationalId + "passCode" + passcode + "OTP" + otp);
        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        commonAPIs = new CommonAPIs();
        Passcode.set(commonAPIs.resetPasscode(nationalId));
        onboardingScreen.enterUserCredentials(phoneNumber, nationalId);
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.userEnterPassCode(Passcode.get());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.oneTimeUseBtn, "oneTimeUseButton");
        passCodeScreen.UserChooseRegisterDevice();
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp(otp);
        ivrScreen = new IVRScreen(getAppiumDriver());
        ivrScreen.passIVR();
        homepageScreen = new HomepageScreen(getAppiumDriver());

        if (!deployment.equalsIgnoreCase("local")) {
            try {
                homepageScreen.acceptNotificationDialog();
                homepageScreen.remindMeLaterRTPNotification();
            } catch (NoSuchElementException ignored) {
            }
        }

        homepageScreen.assertElementIsDisplayed(homepageScreen.SettingsBtn, "SettingsButton");
    }

    @And("user blocked to Sign in with phoneNumber {string} NationalId {string} passCode {string} invalid three times OTP{string}")
    public void userBlockedToSignInWithPhoneNumberNationalIdPassCodeInvalidThreeTimesOTP(String phoneNumber, String nationalId, String passcode, String otp) {
        logStep("And user blocked to Sign in with phoneNumber" + phoneNumber + "NationalId" + nationalId + "passCode" + passcode + "invalid three times OTP" + otp);
        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.enterUserCredentials(phoneNumber, nationalId);
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        commonAPIs = new CommonAPIs();
        passCodeScreen.userEnterPassCode(commonAPIs.resetPasscode(nationalId));
        passCodeScreen.userChooseOneTimeUse();
        otpScreen = new OTPScreen(getAppiumDriver());
        otpScreen.userEnterOtp(otp);
        otpScreen.userEnterOtp(otp);
        otpScreen.userEnterOtp(otp);
        lockScreen = new LockScreen(getAppiumDriver());
        lockScreen.assertElementIsDisplayed(lockScreen.headingTxt, "headingTxt");
        lockScreen.assertElementIsDisplayed(lockScreen.messageTxt, "messageTxt");

    }

    @And("user UnRegister Device")
    public void userUnRegisterDevice() {
        logStep("and user UnRegister Device");
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.clickOnSettingsBtn();
        settingsScreen = new SettingsScreen(getAppiumDriver());
        settingsScreen.unRegisterDevice();
        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.waitUntilElementAppear(onboardingScreen.nationalIdEt, 20);
        onboardingScreen.assertElementIsDisplayed(onboardingScreen.nationalIdEt, "nationalIdEt");

    }

    @Then("user SignOut from one time use")
    public void userSignOutFromOneTimeUse() {
        logStep("And user SignOut from one time use");
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.clickOnSettingsBtn();
        settingsScreen = new SettingsScreen(getAppiumDriver());
        settingsScreen.signOut();
        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.assertElementIsDisplayed(onboardingScreen.nationalIdEt, "nationalIdEt");
    }

    @And("user Sign In Registered Device with his passcode")
    public void userSignInRegisteredDeviceWithHisPassCode() {
        logStep("And user SignIn Registered Device with passCode" + Passcode.get());
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.userEnterPassCode(Passcode.get());
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.remindMeLaterRTPNotification();
        homepageScreen.assertElementIsDisplayed(homepageScreen.SettingsBtn, "SettingsButton");
    }

    @When("User couldn't SignIn with invalid credentials {string} {string}")
    public void UserCouldNotSignInWithInvalidCredentials(String phoneNumber, String nationalNumber) {
        logStep("when user use invalid credentials" + phoneNumber + " " + nationalNumber);
        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.enterUserCredentials(phoneNumber, nationalNumber);
        onboardingScreen.assertElementIsDisplayed(onboardingScreen.errorMessageTxt, "errorMessageTxt");
    }

    @Then("user Couldn't SignIn With {string} and {string} and inValid Passcode{string}")
    public void userCouldNoTSignInWithAndAndInValidPasscode(String phoneNumber, String nationalId, String passcode) {
        logStep("When user couldn't SignIn with phoneNumber" + phoneNumber + "nationalId" + nationalId + "invalid passcode" + passcode);
        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.enterUserCredentials(phoneNumber, nationalId);
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.userEnterPassCode(passcode);
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.errorMessageTxt, "errorMessageTxt");
    }

    @And("user SignOut from registered device")
    public void userSignOutFromRegisteredDevice() {
        logStep("And user SignOut from one time use");
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.clickOnSettingsBtn();
        settingsScreen = new SettingsScreen(getAppiumDriver());
        settingsScreen.signOut();
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
//        Screens.homeScreen.ScreenBase.ThreadSleep(7000);
//        passCodeScreen.waitUntilElementAppear(passCodeScreen.zeroBtn,20);
//        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn,"zeroButton");
    }

    @Then("user blocked to SignIn with phoneNumber {string}NationalId{string}InValid three times passCode{string}")
    public void userBlockedToSignInWithPhoneNumberNationalIdInValidThreeTimesPassCode(String phoneNumber, String nationalNumber, String passcode) {
        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.enterUserCredentials(phoneNumber, nationalNumber);
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.userEnterPassCodeTimes(passcode, 3);
        lockScreen = new LockScreen(getAppiumDriver());
        lockScreen.assertElementIsDisplayed(lockScreen.headingTxt, "headingTxt");
        lockScreen.assertElementIsDisplayed(lockScreen.messageTxt, "messageTxt");
    }

    @And("user UnRegister all Devices related to customer id {string} by using dataBase")
    public void userUnRegisterAllDevicesRelatedTo(String cic) throws SQLException, ClassNotFoundException, IOException {
        String[] connectionDetails = DynamicDatabaseConnectionManager.getConnectionForScenario("AUTHENTICATION_DB_CIT");
        if (connectionDetails == null) {
            throw new RuntimeException("No database configuration found for scenario: " + "AUTHENTICATION_DB_CIT");
        }
        String serverIP = connectionDetails[0];
        String port = connectionDetails[1];
        String serviceName = connectionDetails[2];
        String user = connectionDetails[3];
        String password = connectionDetails[4];
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cic", cic);
        DynamicDatabaseConnectionManager.dataBaseConnection(serverIP, port, serviceName, user, password);
        DynamicDatabaseConnectionManager.executePreparedQueries(String.valueOf(Paths.get(System.getProperty("user.dir"), "src/main/java/properties/DataBaseQueries.sql")), "UnregisterAllDevicesRelatedToCustomerId", parameters);
        DynamicDatabaseConnectionManager.clearThreadLocalConnections();

    }

    @And("user will confirm more time when he leave session away for {string} sec")
    public void userConfirmMoreTimeWhenHeLeaveSessionAwayForSec(String periodTime) {
        Screens.homeScreen.ScreenBase.ThreadSleep(Long.parseLong(periodTime));
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.assertElementIsDisplayed(homepageScreen.timeReminderPopup, "timeReminderPopup");
        homepageScreen.assertElementIsDisplayed(homepageScreen.confirmTimeReminder, "confirmTimeReminder");
        homepageScreen.assertElementIsDisplayed(homepageScreen.declineTimeReminder, "declineTimeReminder");
        homepageScreen.confirmTimeExtension();
        homepageScreen.waitUntilSettingAppear();
        Screens.homeScreen.ScreenBase.ThreadSleep(Long.parseLong(periodTime));
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.waitUntilElementAppear(homepageScreen.timeReminderPopup, 20);
        homepageScreen.assertElementIsDisplayed(homepageScreen.timeReminderPopup, "timeReminderPopup");
    }

    @And("user will reject more time when he leave session away for {string} sec")
    public void userWillRejectMoreTimeWhenHeLeaveSessionAwayForSec(String periodTime) {
        Screens.homeScreen.ScreenBase.ThreadSleep(Long.parseLong(periodTime));
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.assertElementIsDisplayed(homepageScreen.timeReminderPopup, "timeReminderPopup");
        homepageScreen.assertElementIsDisplayed(homepageScreen.confirmTimeReminder, "confirmTimeReminder");
        homepageScreen.assertElementIsDisplayed(homepageScreen.declineTimeReminder, "declineTimeReminder");
        homepageScreen.declineTimeExtension();
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.enterPasscodeLabel, "enterPasscodeLabel");
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.signOutBtn, "signOutButton");
    }

    @And("user will be locked due to inactivity for {string} sec and return back to Login screen")
    public void userWillBeLockedDueToInactivityAndReturnBackToLoginScreenForSec(String periodTime) {
        Screens.homeScreen.ScreenBase.ThreadSleep(Long.parseLong(periodTime));
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.assertElementIsDisplayed(homepageScreen.LockedPopup, "LockedPopup");
        homepageScreen.clickOnLockedPopupOKButton();
        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.assertElementIsDisplayed(onboardingScreen.nationalIdEt, "nationalIdEt");
    }

    @And("user will be locked due to inactivity for {string} sec and return back to Passcode screen")
    public void userWillBeLockedDueToInactivityForSecAndReturnBackToPasscodeScreen(String periodTime) {
        Screens.homeScreen.ScreenBase.ThreadSleep(Long.parseLong(periodTime));
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.waitUntilElementAppear(homepageScreen.LockedPopup, 20);
        homepageScreen.assertElementIsDisplayed(homepageScreen.LockedPopup, "LockedPopup");
        homepageScreen.clickOnLockedPopupOKButton();
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.enterPasscodeLabel, "enterPasscodeLabel");
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.signOutBtn, "signOutButton");
    }

    @And("user could Not Sign in with phoneNumber {string} NationalId {string} passCode {string} invalid OTP{string}")
    public void userCouldNotSignInWithPhoneNumberNationalIdPassCodeInvalidOTP(String phoneNumber, String nationalId, String passcode, String otp) {
        logStep("and user could Not Sign in with phoneNumber" + phoneNumber + "NationalId" + nationalId + "passCode" + passcode + "invalid OTP" + otp);
        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.enterUserCredentials(phoneNumber, nationalId);
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        commonAPIs = new CommonAPIs();
        passCodeScreen.userEnterPassCode(commonAPIs.resetPasscode(nationalId));
        passCodeScreen.UserChooseRegisterDevice();
        otpScreen = new OTPScreen(getAppiumDriver());
        otpScreen.userEnterOtp(otp);
        otpScreen.waitUntilElementAppear(otpScreen.errorMessage, 20);
        otpScreen.assertElementIsDisplayed(otpScreen.errorMessage, "errorMessage");
    }

    @And("user save account balance before transfer")
    public void userSaveAccountBalanceBeforeTransfer() {
        if (homepageScreen.getTextNavigateToAccountBtn().replace(",", "").contains("********")) {
            homepageScreen.clickOnToggleAccountBalanceBtn();
        }
        AppConstants.Balance_Before_Transfer = Double.valueOf(homepageScreen.getTextNavigateToAccountBtn().replace(",", ""));
        System.out.println(AppConstants.Balance_Before_Transfer);
    }

    @And("user save account balance after transfer")
    public void userSaveAccountBalanceAfterTransfer() {

        AppConstants.Balance_After_Transfer = Double.valueOf(homepageScreen.getTextNavigateToAccountBtn().replace(",", ""));
        System.out.println(AppConstants.Balance_After_Transfer);
        Assert.assertEquals(AppConstants.Balance_After_Transfer, AppConstants.Balance_Before_Transfer - AppConstants.TransferAmount);
    }

    @And("user SignOut")
    public void userSignOut() {
        logStep("And user SignOut");
        settingsScreen = new SettingsScreen(getAppiumDriver());
        settingsScreen.signOut();
        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.assertElementIsDisplayed(onboardingScreen.nationalIdEt, "nationalIdEt");
    }


    @And("user SignIn after change passcode with phoneNumber {string} NationalId {string} OTP{string}")
    public void userSignInAfterChangePasscodeWithPhoneNumberNationalIdPassCodeOTP(String phoneNumber, String nationalId, String otp) {
        logStep("user SignIn oneTimeUse with phoneNumber" + phoneNumber + "NationalId" + nationalId + "OTP" + otp);
        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.enterUserCredentials(phoneNumber, nationalId);
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        System.out.println("AppConstants.Passcode" + Passcode.get());
        passCodeScreen.userEnterPassCode(Passcode.get());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.oneTimeUseBtn, "oneTimeUseButton");
        passCodeScreen.userChooseOneTimeUse();
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp(otp);
        ivrScreen = new IVRScreen(getAppiumDriver());
        ivrScreen.passIVR();
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.acceptNotificationDialog();
        homepageScreen.assertElementIsDisplayed(homepageScreen.SettingsBtn, "SettingsButton");
    }

    @And("user update old passcode using old passcode")
    public void userUpdateOldPasscodeUsingOldPasscode() {
        logStep("And user update passcode");
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.clickOnSettingsBtn();
        settingsScreen = new SettingsScreen(getAppiumDriver());
        settingsScreen.clickOnPasscodeBtn();
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        passCodeScreen.userEnterPassCode(Passcode.get());
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp("0000");
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        passCodeScreen.userEnterPassCode(Passcode.get());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        passCodeScreen.userEnterPassCode(Passcode.get());

    }

    @And("user update old passcode using mismatch passcode {string}")
    public void userUpdateOldPasscodeUsingMismatchPasscode(String newPass) {
        logStep("And user update passcode");
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.clickOnSettingsBtn();
        settingsScreen = new SettingsScreen(getAppiumDriver());
        settingsScreen.clickOnPasscodeBtn();
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        passCodeScreen.userEnterPassCode(Passcode.get());
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp("0000");
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        passCodeScreen.userEnterPassCode(newPass);
        passCodeScreen.userEnterPassCode(Passcode.get());


    }

    @Then("user verify {string} error message")
    public void userVerifyErrorMessage(String errorMsg) {
        if (errorMsg.equalsIgnoreCase("same old passcode")) {
            passCodeScreen.assertElementIsDisplayed(passCodeScreen.errorPasscodeMessagePopup, "errorPasscodeMessagePopup");
            // Assert.assertTrue(passCodeScreen.errorSameOldPasscodeMessagePopup.isDisplayed());
        } else if (errorMsg.equalsIgnoreCase("error mismatch")) {
            passCodeScreen.assertElementIsDisplayed(passCodeScreen.errorMissMatchPasscodeMessagePopup, "errorMissMatchPasscodeMessagePopup");
        }
    }


    @And("user SignIn oneTimeUse with phoneNumber {string} NationalId {string} and click on forget passcode")
    public void userSignInOneTimeUseWithPhoneNumberNationalIdAndClickOnForgetPasscode(String phoneNumber, String nationalId) {
        logStep("user SignIn oneTimeUse with phoneNumber" + phoneNumber + "NationalId" + nationalId + "passCode" + "OTP");
//        croatiaIntroScreen =new CroatiaIntroScreen(getAppiumDriver());
//        croatiaIntroScreen.tabOnStartBtn();
        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.enterUserCredentials(phoneNumber, nationalId);
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        passCodeScreen.clickOnForgetPasscodeLabel();
    }

    @And("user sign in with with phoneNumber {string} NationalId {string} OTP {string} card pin {string} in the forget passcode screen")
    public void userSignInWithWithPhoneNumberNationalIdOTPCardPinInTheForgetPasscodeScreen(String mobileNumber, String nationalId, String pass, String pin) {
        ForgetPasscodeScreen forgetPasscodeScreen = new ForgetPasscodeScreen(getAppiumDriver());
        forgetPasscodeScreen.enterValidCredentials(mobileNumber, nationalId);
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp(pass);
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.waitUntilElementAppear(passCodeScreen.zeroBtn, 20);
        passCodeScreen.userEnterPassCode(pin);
    }


    @And("user update old passcode to new passcode")
    public void userUpdateOldPasscodeToNewPasscodeFor() {
        logStep("And user update passcode");
        commonAPIs = new CommonAPIs();
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.clickOnSettingsBtn();
        settingsScreen = new SettingsScreen(getAppiumDriver());
        settingsScreen.clickOnPasscodeBtn();
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        passCodeScreen.userEnterPassCode("135792");
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp("0000");
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        Passcode.set(Helper.randomNumber("passcode"));
        System.out.println(" AppConstants.Passcode " + Passcode.get());
        passCodeScreen.userEnterPassCode(Passcode.get());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        passCodeScreen.userEnterPassCode(Passcode.get());
        passCodeScreen.waitUntilElementAppear(passCodeScreen.passcodeBackBtn, 20);
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.passcodeBackBtn, "passcodeBackButton");
        passCodeScreen.clickOnPasscodeBackBtn();
    }

    @And("user reset passcode to new passcode")
    public void userResetPasscodeToNewPasscode() {
        passCodeScreen.waitUntilElementAppear(passCodeScreen.zeroBtn, 10);
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        Passcode.set(Helper.randomNumber("passcode"));
        System.out.println("new AppConstants.Passcode " + Passcode.get());
        passCodeScreen.userEnterPassCode(Passcode.get());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        passCodeScreen.userEnterPassCode(Passcode.get());
    }

    @And("user SignIn oneTimeUse with onboarding data")
    public void userSignInOneTimeUseWithOnboardingData() {
        logStep("user SignIn oneTimeUse with phoneNumber" + OnboardMobileNumber.get() + "NationalId" + AppConstants.OnboardNationalID.get() + "passcode" + AppConstants.Passcode.get() + "OTP: 0000");


        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.enterUserCredentials(OnboardMobileNumber.get(), AppConstants.OnboardNationalID.get());
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        passCodeScreen.userEnterPassCode(AppConstants.Passcode.get());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.oneTimeUseBtn, "oneTimeUseButton");
        passCodeScreen.userChooseOneTimeUse();
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp("0000");
        ivrScreen = new IVRScreen(getAppiumDriver());
        ivrScreen.passIVR();
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.assertElementIsDisplayed(homepageScreen.SettingsBtn, "SettingsButton");
    }

    @Then("user goes to cards from footer tap")
    public void userGoesToCardsFromFooterTap() {
        logStep("user goes to cards from footer tap");
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.waitUntilElementAppear(homepageScreen.accountNumber, 10);
        homepageScreen.clickOnCardsTab();
    }

    @And("user SignIn Register Device with onboarding data")
    public void userSignInRegisterDeviceWithOnboardingData() {
        logStep("And user SignIn Register Device with phoneNumber: " + OnboardMobileNumber.get() + "NationalId: " + AppConstants.OnboardNationalID.get() + "passCode: " + AppConstants.Passcode.get() + "OTP: 0000 ");

        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.enterUserCredentials(OnboardMobileNumber.get(), AppConstants.OnboardNationalID.get());
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        passCodeScreen.userEnterPassCode(AppConstants.Passcode.get());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.oneTimeUseBtn, "oneTimeUseButton");
        passCodeScreen.UserChooseRegisterDevice();
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp("0000");
        ivrScreen = new IVRScreen(getAppiumDriver());
        ivrScreen.passIVR();
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.acceptNotificationDialog();
        homepageScreen.assertElementIsDisplayed(homepageScreen.SettingsBtn, "SettingsButton");
    }

    @And("user sign in with with phoneNumber {string} NationalId {string} OTP{string} using Nafath")
    public void userSignInWithWithPhoneNumberNationalIdOTPWithoutCardPin(String mobileNumber, String nationalId, String pass) {
        ForgetPasscodeScreen forgetPasscodeScreen = new ForgetPasscodeScreen(getAppiumDriver());
        forgetPasscodeScreen.enterValidCredentials(mobileNumber, nationalId);
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp(pass);
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.clickOnForgetCardPinCode();
        NafathScreen nafathScreen = new NafathScreen(getAppiumDriver());
        nafathScreen.completeNafathJourney();
        DriverManager.restartApp();
        Screens.homeScreen.ScreenBase.ThreadSleep(17000);
        passCodeScreen = new PassCodeScreen(getAppiumDriver());

    }

    @And("user SignIn Registered Device with new passCode")
    public void userSignInRegisteredDeviceWithNewPassCode() {
        logStep("And user SignIn Registered Device with passCode" + Passcode.get());
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.userEnterPassCode("159853");
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.assertElementIsDisplayed(homepageScreen.SettingsBtn, "SettingsButton");
    }

    @Then("rest user nafath count {string} by using API")
    public void restUserNafathCountByUsingAPI(String CIC) {
        logStep("When activate user status" + CIC);
        commonAPIs = new CommonAPIs();
        commonAPIs.updateNafathCount(CIC);
    }

    @Given("remove bloke code for {string} by using API")
    public void removeBlokeCodeForByUsingAPI(String CIC) {
        logStep("When activate user status" + CIC);
        commonAPIs = new CommonAPIs();
        if (CIC.equalsIgnoreCase("EMPTY")) {
            CommonAPIs.findUserCic(AppConstants.OnboardNationalID.get());
        } else {
            AppConstants.cic.set(CIC);
        }
        commonAPIs.removeBlockCode(AppConstants.cic.get());
    }

    // by ola data provder ⬇


    @And("Read user Data from csv file")
    public void ReadDataFromCSVFile() {
        int i = 0;
        while (i < csvData.length) {
            if (csvData[i][4].equals("No")) {
                csvData[i][4] = "Yes";
                data.set(csvData[i]);
                AppConstants.OnboardMobileNumber.set(data.get()[0].toString());
                AppConstants.OnboardNationalID.set(data.get()[1].toString());
                AppConstants.cic.set(data.get()[2].toString());
                AppConstants.Passcode.set(data.get()[3].toString());
                System.out.println("the phoneNumber is " + AppConstants.OnboardMobileNumber.get());
                System.out.println("the nationalId is " + AppConstants.OnboardNationalID.get());
                System.out.println("the passcode is " + AppConstants.Passcode.get());
                System.out.println("the CIC is " + AppConstants.cic.get());
                break;
            } else {
                i++;
            }
        }
    }

    @Given("Activate user status by using API")
    public void activateUserStatusByUsing() {
        logStep("Activate user status by using API");
//        commonAPIs = new CommonAPIs(); // todo remove comment
//        commonAPIs.activateUser(CIC);
//        commonAPIs.activateUserInCRM(CIC);
    }

    @And("user SignIn oneTimeUse with data provided from csv file")
    public void userSignInOneTimeUseWithDataProvided() {
        logStep("user SignIn oneTimeUse with with data provided from csv file phoneNumber: " + AppConstants.OnboardMobileNumber.get() + "NationalId: " + AppConstants.OnboardNationalID.get() + "passcode: " + AppConstants.Passcode.get() + "OTP: 0000");

        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.enterUserCredentials(AppConstants.OnboardMobileNumber.get(), AppConstants.OnboardNationalID.get());

        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        Screens.homeScreen.ScreenBase.ThreadSleep(7000);
        passCodeScreen.waitUntilElementAppear(passCodeScreen.zeroBtn, 30);
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        passCodeScreen.userEnterPassCode(Passcode.get());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.oneTimeUseBtn, "oneTimeUseButton");
        passCodeScreen.userChooseOneTimeUse();
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty(), "OTP screen is not showing");
        otpScreen.userEnterOtp(this.otp);
        ivrScreen = new IVRScreen(getAppiumDriver());
        ivrScreen.passIVR();
        homepageScreen = new HomepageScreen(getAppiumDriver());
        if (!deployment.equalsIgnoreCase("local")) {
            try {
                homepageScreen.acceptNotificationDialog();
                homepageScreen.remindMeLaterRTPNotification();
            } catch (NoSuchElementException ignored) {
            }
        }
        homepageScreen.assertElementIsDisplayed(homepageScreen.SettingsBtn, "homeScreen");

    }

    public static void setLoginData(String[] data) {
        loginData.set(data);
    }

    public static String[] getLoginData() {
        return loginData.get();
    }

    @Then("user register device from device Management")
    public void userRegisterDeviceFromDeviceManagement() {
        logStep("user register device from device Management");
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.clickOnProfileBtn();
        settingsScreen = new SettingsScreen(getAppiumDriver());
        settingsScreen.clickOnDeviceManagementBtn();
        deviceScreen = new DeviceScreen(getAppiumDriver());
        deviceScreen.RegisterDevice();
        deviceScreen.assertElementIsDisplayed(deviceScreen.deviceSectionHeaderTitle, "deviceSectionHeaderTitle");
        deviceScreen.assertElementIsDisplayed(deviceScreen.deviceLoginDetailsText, "deviceLoginDetailsText");
    }

    @Then("user goes to home from footer tap")
    public void userGoesToHomeFromFooterTap() {
        logStep("user goes to home from footer tap");

        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.clickOnHomeTab();
        homepageScreen.waitUntilElementAppear(homepageScreen.accountNumber, 10);
    }

    @And("user SignIn oneTimeUse with phoneNumber NationalId from csv file and click on forget passcode")
    public void userSignInOneTimeUseWithPhoneNumberNationalIdFromCsvFileAndClickOnForgetPasscode() {
        logStep("user SignIn oneTimeUse with phoneNumber NationalId from csv file and click on forget passcode");
        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.enterUserCredentials(AppConstants.OnboardMobileNumber.get(), AppConstants.OnboardNationalID.get());
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        passCodeScreen.clickOnForgetPasscodeLabel();

    }

    @And("user sign in with with phoneNumber NationalId from csv file OTP {string} using Nafath")
    public void userSignInWithWithPhoneNumberNationalIdFromCsvFileOTPUsingNafath(String otp) {
        logStep("user sign in with with phoneNumber NationalId from csv file OTP {string} using Nafath");
        ForgetPasscodeScreen forgetPasscodeScreen = new ForgetPasscodeScreen(getAppiumDriver());
        forgetPasscodeScreen.enterValidCredentials(AppConstants.OnboardMobileNumber.get(), AppConstants.OnboardNationalID.get());
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp(otp);
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.clickOnForgetCardPinCode();
        NafathScreen nafathScreen = new NafathScreen(getAppiumDriver());
        nafathScreen.completeNafathJourney();
        DriverManager.restartApp();
        Screens.homeScreen.ScreenBase.ThreadSleep(17000);
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
    }

    @And("user SignIn after change passcode with phoneNumber NationalId from csv file and OTP {string}")
    public void userSignInAfterChangePasscodeWithPhoneNumberNationalIdOTP(String otp) {
        logStep("user SignIn after change passcode with phoneNumber NationalId from csv file and OTP 0000");
        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.enterUserCredentials(AppConstants.OnboardMobileNumber.get(), AppConstants.OnboardNationalID.get());

        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        passCodeScreen.userEnterPassCode(Passcode.get());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.oneTimeUseBtn, "oneTimeUseButton");
        passCodeScreen.userChooseOneTimeUse();

        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp(otp);

        ivrScreen = new IVRScreen(getAppiumDriver());
        ivrScreen.passIVR();

        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.assertElementIsDisplayed(homepageScreen.SettingsBtn, "SettingsButton");
    }

    @Then("user SignIn Register Device with data provided from csv file")
    public void userSignInRegisterDeviceWithDataProvidedFromCsvFile() {
        logStep("user SignIn Register Device with data provided from csv file");
        onboardingScreen = new OnboardingScreen(getAppiumDriver());

        onboardingScreen.enterUserCredentials(AppConstants.OnboardMobileNumber.get(), AppConstants.OnboardNationalID.get());
        passCodeScreen = new PassCodeScreen(getAppiumDriver());

        passCodeScreen.assertElementIsDisplayed(passCodeScreen.oneBtn, "PasscodeScreen");
        passCodeScreen.userEnterPassCode(AppConstants.Passcode.get());

        passCodeScreen.assertElementIsDisplayed(passCodeScreen.oneTimeUseBtn, "oneTimeUseButton");
        passCodeScreen.UserChooseRegisterDevice();
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp(otp);
        ivrScreen = new IVRScreen(getAppiumDriver());
        ivrScreen.passIVR();
        homepageScreen = new HomepageScreen(getAppiumDriver());
        if (!deployment.equalsIgnoreCase("local")) {
            try {
                homepageScreen.acceptNotificationDialog();
                homepageScreen.remindMeLaterRTPNotification();
            } catch (NoSuchElementException ignored) {
            }
        }
        homepageScreen.assertElementIsDisplayed(homepageScreen.SettingsBtn, "SettingsButton");
    }

    @And("user SignIn oneTimeUse with phoneNumber {string} NationalId {string} OTP {string} for RTP")
    public void userSignInOneTimeUseWithPhoneNumberNationalIdPassCodeOTPForRTP(String phoneNumber, String nationalId, String otp) {

        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.enterUserCredentials(phoneNumber, nationalId);
        AppConstants.OnboardNationalID.set(nationalId);

        commonAPIs = new CommonAPIs();
        Passcode.set(commonAPIs.resetPasscode(nationalId));

        OnboardMobileNumber.set(phoneNumber);
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        Screens.homeScreen.ScreenBase.ThreadSleep(7000);
        passCodeScreen.waitUntilElementAppear(passCodeScreen.zeroBtn, 20);
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        passCodeScreen.userEnterPassCode(Passcode.get());
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.oneTimeUseBtn, "oneTimeUseButton");
        passCodeScreen.userChooseOneTimeUse();
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty(), "OTP screen is not showing");
        otpScreen.userEnterOtp(otp);
        ivrScreen = new IVRScreen(getAppiumDriver());
        ivrScreen.passIVR();
    }
}