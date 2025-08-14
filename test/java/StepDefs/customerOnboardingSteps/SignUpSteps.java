package StepDefs.customerOnboardingSteps;

import Screens.customerOnBoardingScreens.*;
import Screens.homeScreen.HomepageScreen;
import Screens.homeScreen.IVRScreen;
import Screens.homeScreen.OTPScreen;
import Screens.settingScreen.SettingsScreen;
import TestBases.DriverManager;
import TestBases.TestBase;
import Utilities.APIs.CommonAPIs;
import Utilities.DataBase.DynamicDatabaseConnectionManager;
import Utilities.commonClasses.AppConstants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.Platform;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static TestBases.DriverManager.getAppiumDriver;
import static Utilities.Helper.generateValidCredentials.generatePhoneNumber;
import static Utilities.Helper.generateValidCredentials.generateValidID;

public class SignUpSteps extends TestBase {
    HomepageScreen homepage = new HomepageScreen(getAppiumDriver());
    AppIntroductionScreen appIntroductionScreen = new AppIntroductionScreen(getAppiumDriver());
    OnboardingScreen onboardingScreen = new OnboardingScreen(getAppiumDriver());
    CongratulationsEligibleToUseTheAppScreen congratulationsEligibleToUseTheAppScreen = new CongratulationsEligibleToUseTheAppScreen(getAppiumDriver());
    PassCodeScreen passCodeScreen = new PassCodeScreen(getAppiumDriver());
    OTPScreen otpScreen = new OTPScreen(getAppiumDriver());
    OnboardingInformationScreen onboardingInformationScreen = new OnboardingInformationScreen(getAppiumDriver());
    PlaceOfBirthScreen placeOfBirthScreen = new PlaceOfBirthScreen(getAppiumDriver());
    FastOnboardingScreen fastOnboardingScreen = new FastOnboardingScreen(getAppiumDriver());
    SettingsScreen settingsScreen = new SettingsScreen(getAppiumDriver());

    TermsAndConditionScreen termsAndConditionScreen;
    PersonalDetailsScreen personalDetailsScreen;
    NafathScreen nafathScreen;
    OcupationalInformationScreen ocupationalInformationScreen;
    FinancialInformationScreen financialInformationScreen;

    @And("the customer is at the FATCA details and checked Are You Pep")
    public void theCustomerIsAtTheFATCADetailsAreYouPepText() {
        logStep("the customer is at the FATCA details and checked out all the required details");
        onboardingInformationScreen = new OnboardingInformationScreen(getAppiumDriver());
        onboardingInformationScreen.retryWaitElement(onboardingInformationScreen.confirmPEPFastOnboarding);
        onboardingInformationScreen.assertElementIsDisplayed(onboardingInformationScreen.confirmPEPFastOnboarding, "confirmPEPFastOnboarding");
        onboardingInformationScreen.declinePEP();
    }

    @Then("the app directs the customer to the T&C page and accept the T&C")
    public void theAppDirectsTheCustomerToTheTCPage() {
        logStep("the app directs the customer to the T&C page and accept the T&C");
        try {
            onboardingInformationScreen.assertElementIsDisplayed(onboardingInformationScreen.termsAndConditionsScreen, "termsAndConditionsScreen");
            onboardingInformationScreen.chickTermsAndConditions();
            onboardingInformationScreen.chickSamaTermsAndConditions(); // new check box
            onboardingInformationScreen.clickOnTermsAndConditionsContinueButton();
        } catch (NoSuchElementException e) {
            //if something went wrong appear but still can't catch it in real execution
        }
    }


    @And("the customer create a passcode")
    public void theCustomerCreateAPasscode() throws InterruptedException {
        logStep("the customer create a passcode");

        AppConstants.Passcode.set("135792");
        Thread.sleep(13000);
        passCodeScreen.userEnterPassCode(AppConstants.Passcode.get());
        passCodeScreen.retryWaitElement(passCodeScreen.confirmPasscodeScreen);
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.confirmPasscodeScreen, "confirmPasscodeScreen");
        passCodeScreen.userEnterPassCode(AppConstants.Passcode.get());
    }

    @And("add money to the user account")
    public void addMoneyToTheUserAccount() {
        CommonAPIs CommonAPIs = new CommonAPIs();
        AppConstants.accountNumber = homepage.accountNumber.getText().replaceAll(" ", "");
        //todo check if user has balance
        CommonAPIs.topUpBalance(AppConstants.accountNumber, "100000");
    }


    @And("the customer is confirm PEP and add Tax residency")
    public void theCustomerIsConfirmPEPAndAddTaxResidency() {
        onboardingInformationScreen.confirmPep();
        onboardingInformationScreen.confirmAndSetTax();
//        Assert.assertTrue(onboardingInformationScreen.UTR.isDisplayed());
    }


    @When("error msg is appearing")
    public void errorMsgIsAppearing() {
        onboardingScreen.assertElementIsDisplayed(onboardingScreen.errorMessageTxt, "errorMessageTxt");
    }


    @Then("set static data")
    public void setStaticData() {
        AppConstants.OnboardNationalID.set("1622453163");
        AppConstants.OnboardMobileNumber.set("549072658");
        AppConstants.Passcode.set("135792");
    }

    @And("Add {string} points to the account")
    public void addPointsToTheAccount(String points) {
        if (AppConstants.cic.get() == null) {
            CommonAPIs.findUserCic(AppConstants.OnboardNationalID.get());
        }
        try {
            String[] connectionDetails = DynamicDatabaseConnectionManager.getConnectionForScenario("LIMIT_MANAGEMENT_DB_CIT");
            if (connectionDetails == null) {
                throw new RuntimeException("No database configuration found for scenario: " + "LIMIT_MANAGEMENT_DB_CIT");
            }
            String serverIP = connectionDetails[0];
            String port = connectionDetails[1];
            String serviceName = connectionDetails[2];
            String user = connectionDetails[3];
            String password = connectionDetails[4];
            Map<String, String> parameters = new HashMap<>();
            parameters.put("points", points);
            parameters.put("OnboardedCRMCustomerID", AppConstants.cic.get());
            DynamicDatabaseConnectionManager.dataBaseConnection(serverIP, port, serviceName, user, password);
            DynamicDatabaseConnectionManager.executePreparedQueries(String.valueOf(Paths.get(System.getProperty("user.dir"), "src/main/java/properties/DataBaseQueries.sql")), "ChangeThePointForAnAccount", parameters);
            DynamicDatabaseConnectionManager.clearThreadLocalConnections();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            Assert.fail("Failed to add points=" + points + " to the User account " + AppConstants.cic.get());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the customer clicks on FATCA continue")
    public void theCustomerClicksOnFATCAContinue() {
        onboardingInformationScreen = new OnboardingInformationScreen(getAppiumDriver());
        onboardingInformationScreen.clickOnFatcaDetailsScreenContinueButton();
    }

    @Then("the customer redirect to activate {string} and select later")
    public void theCustomerRedirectToActivateAndSelectLater(String screen) {
        if (screen.equalsIgnoreCase("card")) {
            onboardingInformationScreen.tapOnaActivateCardLaterLabel();

        } else if (screen.equalsIgnoreCase("touch")) {
            onboardingInformationScreen.tapOnaActivateCardLaterLabel();

        }
    }


    @Given("prospect croatia customer is fast onboarding at croatia using mobileNumber {string} and NationalId {string}")
    public void prospectCroatiaCustomerIsFastOnboardingAtCroatiaUsingMobileNumberAndNationalId(String mobileNumber, String nationalId) {
        logStep("prospect croatia customer is onboarding at croatia");

        appIntroductionScreen = new AppIntroductionScreen(getAppiumDriver());
        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        try {
            appIntroductionScreen.allowLocationPermissionIfAppears();

            boolean isLocalIOS = TestBase.deployment.equalsIgnoreCase("local") && TestBase.platformName.equalsIgnoreCase("ios");

            if (!isLocalIOS) {
                appIntroductionScreen.completeAppIntro();
            } else if (appIntroductionScreen.isDisplayed(appIntroductionScreen.StartBtn)) {
                appIntroductionScreen.tapOnStartBtn();
            } else {
                appIntroductionScreen.tabOnSignOutPasscode();
            }

            onboardingScreen.enterUserCredentials(mobileNumber, nationalId);
            fastOnboardingScreen.waitUntilElementAppear(fastOnboardingScreen.fastOnboardingWelcomeTitle, 100);
            fastOnboardingScreen.assertElementIsDisplayed(fastOnboardingScreen.fastOnboardingWelcomeTitle, "fastOnboardingWelcomeTitle");
        } catch (TimeoutException timeoutException) {
            //log or something
            System.out.println("the error:" + timeoutException.getCause().toString());
            Assert.fail(timeoutException.getMessage());
        }
    }

    @And("the customer has login to Alrajhi Online using username {string} and password {string}")
    public void theCustomerHasLoginToAlrajhiOnlineUsingUsernameAndPassword(String username, String password) {
        fastOnboardingScreen.tapOnFastOnboardingBtn();
        fastOnboardingScreen.loginToAlrajhiOnline(username, password);
    }

    @And("user enter {string} on fast onboarding")
    public void userEnterOnFastOnboarding(String otp) {
        logStep("And user enter {string}");
        otpScreen = new OTPScreen(getAppiumDriver());
        otpScreen.waitUntilElementAppear(otpScreen.oneTimePasswordScreenTitle, 30);
        otpScreen.tapOnotpEtFastOnboarding();
        if (String.valueOf(getAppiumDriver().getCapabilities().getPlatformName()).equalsIgnoreCase("ios")) {
            otpScreen.userTapOnMore();
            otpScreen.userEnterOtp("1");
            otpScreen.tapOnotpEtSecOnboarding();
            otpScreen.userTapOnMore();
            otpScreen.userEnterOtp("2");
            otpScreen.tapOnotpEtThirdOnboarding();
            otpScreen.userTapOnMore();
            otpScreen.userEnterOtp("3");
            otpScreen.tapOnotpEtFourthOnboarding();
            otpScreen.userTapOnMore();
            otpScreen.userEnterOtp("4");
        }
        if (String.valueOf(getAppiumDriver().getCapabilities().getPlatformName()).equalsIgnoreCase("Android")) {
            otpScreen.userEnterOtp(otp);
        }

        getAppiumDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }


    @Then("customer is redirected to the FOB financial information section")
    public void customerIsRedirectedToTheFOBFinancialInformationSection() {
        logStep("customer selects or add their financial information");
        onboardingInformationScreen = new OnboardingInformationScreen(getAppiumDriver());
        onboardingInformationScreen.clickOnSetButtonSelectMainIncome();
        onboardingInformationScreen.selectProfession("Salary");
        onboardingInformationScreen.clickOnSetButton();
        onboardingInformationScreen.clickOnSelectIncomeAmount();
        onboardingInformationScreen.selectProfession("From 3001 to 6000");
        onboardingInformationScreen.clickOnSetButton();
        onboardingInformationScreen.clickOnSelectAnAmount();
        onboardingInformationScreen.selectProfession("2,501 - 5,000");
//        onboardingInformationScreen.selectProfession("2,501-5,000");
        onboardingInformationScreen.clickOnSetButton();
        onboardingInformationScreen.clickOnIncomeDetailsUpdateScreenContinueBtn();
    }

    @And("user SignOut after onboarding")
    public void userSignOutAfterOnboarding() {
        logStep("And user SignOut from one time use");
        settingsScreen = new SettingsScreen(getAppiumDriver());
        settingsScreen.signOut();
        passCodeScreen.waitUntilElementAppear(passCodeScreen.zeroBtn, 80);
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
    }


    @And("the customer is confirm PEP")
    public void theCustomerIsConfirmPEP() {
        onboardingInformationScreen.confirmPep();
    }

    @When("customer select profession {string} Sector {string} occupation {string} companyName {string}")
    public void customerSelectProfessionSectorOccupationCompanyName(String profession, String sector, String occupation, String companyName) throws InterruptedException {
        logStep("customer selects or add their occupational information");
        ocupationalInformationScreen = new OcupationalInformationScreen(getAppiumDriver());
        ocupationalInformationScreen.userSelectProfession(profession);
        ocupationalInformationScreen.retryWaitElement(ocupationalInformationScreen.selectYourSectorBt);
        ocupationalInformationScreen.userSelectSector(sector);
        ocupationalInformationScreen.retryWaitElement(onboardingInformationScreen.selectYourOccupationBt);
        ocupationalInformationScreen.userSelectOccupation(occupation);
        ocupationalInformationScreen.addCompanyName(companyName);
        ocupationalInformationScreen.clickOnOccupationalInfoContinueButton();
    }


    @And("user enter there birth information if applicable")
    public void userEnterThereBirthInformationIfApplicable() {
        logStep("user enter there birth information if applicable");
        try {
            if (!onboardingInformationScreen.ConfirmButton.isEnabled()) {
                onboardingInformationScreen.clickOnSelectCountryButton();
                onboardingInformationScreen.clickOnSetCountryButton();
                onboardingInformationScreen.typingTextIn(onboardingInformationScreen.cityTxt, "city");
            }
            onboardingInformationScreen.clickOnConfirmButton();
        } catch (Exception ignored) {
        }
    }


    @Then("the customer is stopped at pending approval screen")
    public void theCustomerIsStoppedAtPendingApprovalScreen() {
        logStep("the customer is stopped at pending approval screen");

        onboardingInformationScreen.waitUntilElementAppear(onboardingInformationScreen.pendingApprovalTxt, 10); // wait for pending approval screen
        onboardingInformationScreen.assertElementIsDisplayed(onboardingInformationScreen.pendingApprovalTxt, "pendingApprovalTxt");
    }

    @Given("Generate valid credentials ID {} and phone Number")
    public void generateValidCredentialsIDAndPhoneNumber(String idStartWith) {
        AppConstants.OnboardNationalID.set(generateValidID(idStartWith));
        AppConstants.OnboardMobileNumber.set(generatePhoneNumber());

    }


    @And("Tahaqoq validates the credentials entered by the user")
    public void tahaqoqValidatesTheCredentialsEnteredByTheUser() {
        logStep("Tahaqoq validates the credentials entered by the user");
        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.enterUserCredentials(AppConstants.OnboardMobileNumber.get(), AppConstants.OnboardNationalID.get());
        congratulationsEligibleToUseTheAppScreen = new CongratulationsEligibleToUseTheAppScreen(getAppiumDriver());
        congratulationsEligibleToUseTheAppScreen.continueOnboarding();
    }


    @And("OTP validation is sent by the system to the phone number entered by the user")
    public void otpValidationIsSentByTheSystemToThePhoneNumberEnteredByTheUser() {
        otpScreen = new OTPScreen(getAppiumDriver());
        otpScreen.waitUntilElementAppear(otpScreen.otpEt.get(0), 20);
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp("0000");
    }

    @And("The user allows nera to retrieve data from Nafath")
    public void theUserAllowsNeraToRetrieveDataFromNafath() throws InterruptedException {
        nafathScreen = new NafathScreen(getAppiumDriver());
        nafathScreen.assertElementIsDisplayed(nafathScreen.nafathAppBt, "nafathAppBt");
        nafathScreen.clickOnNafathAppButton();
        nafathScreen.clickOnNafath();
        Thread.sleep(2000);
        DriverManager.restartApp();//to bypass nafath
        Thread.sleep(5000);
    }

    @And("The user enters place of birth data")
    public void theUserEntersPlaceOfBirthData() {
        placeOfBirthScreen = new PlaceOfBirthScreen(getAppiumDriver());
        placeOfBirthScreen.setBirthDetailsOutSideSaudiArabia();

    }

    @And("The user enters email{}")
    public void theUserEntersEmail(String email) {
        personalDetailsScreen = new PersonalDetailsScreen(getAppiumDriver());
        personalDetailsScreen.enterUserEmail(email);
        Assert.assertTrue(personalDetailsScreen.ContinueBtn.isEnabled());
        personalDetailsScreen.confirmPersonalInformation();
    }


    @And("The user enters occupation {string} information details")
    public void theUserEntersOccupationInformationDetails(String occupation) {
        ocupationalInformationScreen = new OcupationalInformationScreen(getAppiumDriver());
        ocupationalInformationScreen.userSelectProfession(occupation);
        ocupationalInformationScreen.clickOnOccupationalInfoContinueButton();
    }

    @And("The user enter financial information {string} {string} {string}")
    public void theUserEnterFinancialInformation(String sourceOfIncome, String incomeAmount, String monthlyDebitCreditAmount) {
        financialInformationScreen = new FinancialInformationScreen(getAppiumDriver());
        financialInformationScreen.clickOnSetButtonSelectMainIncome();
        financialInformationScreen.selectProfession(sourceOfIncome);
        financialInformationScreen.clickOnSetButton();
        financialInformationScreen.clickOnSelectIncomeAmount();
        financialInformationScreen.selectProfession(incomeAmount);
        financialInformationScreen.clickOnSetButton();
        financialInformationScreen.clickOnSelectAnAmount();
        financialInformationScreen.selectProfession(monthlyDebitCreditAmount);
//        financialInformationScreen.selectProfession("2,501-5,000");
        financialInformationScreen.clickOnSetButton();
        financialInformationScreen.clickOnIncomeDetailsScreenContinueBtn();
    }

    @And("the user clicks on FATCA continue")
    public void theUserClicksOnFATCAContinue() {
        onboardingInformationScreen = new OnboardingInformationScreen(getAppiumDriver());
        onboardingInformationScreen.clickOnFatcaDetailsScreenContinueButton();
    }

    @And("the user accept Terms&conditions and Sama consent")
    public void theUserAcceptTermsConditionsAndSamaConsent() {
        termsAndConditionScreen = new TermsAndConditionScreen(getAppiumDriver());
        termsAndConditionScreen.assertElementIsDisplayed(termsAndConditionScreen.termsAndConditionsScreen, "termsAndConditionsScreen");
        termsAndConditionScreen.chickTermsAndConditions();
        if (environment.equalsIgnoreCase("sit")) {
            termsAndConditionScreen.chickSamaTermsAndConditions(); // new check box
        }
        termsAndConditionScreen.chickPrivacyPolicy(); // new check box

        termsAndConditionScreen.clickOnTermsAndConditionsContinueButton();
    }

    @And("the user Activate ALO card")
    public void theUserActivateALOCard() {
        onboardingInformationScreen.tapOnaActivateCardBtn();
    }

    @And("the user create card pin {string}")
    public void theUserCreateCardPin(String CardPIN) throws InterruptedException {
        passCodeScreen = new PassCodeScreen(getAppiumDriver());
        Thread.sleep(3000);
        passCodeScreen.userEnterPassCode(CardPIN);
        passCodeScreen.assertElementIsDisplayed(passCodeScreen.zeroBtn, "zeroButton");
        passCodeScreen.waitUntilElementAppear(passCodeScreen.confirmPINLabel, 30);
        Thread.sleep(3000);
        passCodeScreen.userEnterPassCode(CardPIN);
    }

    @And("the user create passcode {string}")
    public void theUserCreatePasscode(String passcode) throws InterruptedException {
        AppConstants.Passcode.set(passcode);
        Thread.sleep(4000);
        passCodeScreen.userEnterPassCode(AppConstants.Passcode.get());
        Thread.sleep(4000);
        passCodeScreen.userEnterPassCode(AppConstants.Passcode.get());
    }

    @And("the user redirect to activate {string} and select later")
    public void theUserRedirectToActivateAndSelectLater(String screen) {
        if (screen.equalsIgnoreCase("card")) {
            onboardingInformationScreen.tapOnaActivateCardLaterLabel();

        } else if (screen.equalsIgnoreCase("touch")) {
            onboardingInformationScreen.tapOnaActivateCardLaterLabel();

        }
    }

    @Then("the user is onboarded successfully")
    public void theUserIsOnboardedSuccessfully() throws InterruptedException {
        IVRScreen IVRScreen = new IVRScreen(getAppiumDriver());
        IVRScreen.passIVR();

        onboardingInformationScreen.passPleaseWait();
        onboardingInformationScreen.clickOnGetStartedBt();

        try {
            homepage.acceptNotificationDialog();
        } catch (NoSuchElementException | TimeoutException ignored) {
        }
    }

    @And("the user Activate ALO card Later")
    public void theUserActivateALOCardLater() {
        onboardingInformationScreen.tapOnaActivateCardLaterLabel();
    }

    @And("The user enter missing Address")
    public void theUserEnterMissingAddress() {
        PersonalDetailsScreen personalDetailsScreen = new PersonalDetailsScreen(getAppiumDriver());
        personalDetailsScreen.clickOnAddress();
        AddressScreen addressScreen = new AddressScreen(getAppiumDriver());
        addressScreen.selectCity();
        addressScreen.enterStreetName("wadi nawar");
        addressScreen.confirmAddress();

    }

    @And("The user confirm BirthPlace return from nafath")
    public void theUserConfirmBirthPlaceReturnFromNafath() {
        placeOfBirthScreen = new PlaceOfBirthScreen(getAppiumDriver());
        placeOfBirthScreen.confirmBirthPlace();

    }

    @Then("The user back to Onboarding screen")
    public void theUserBackToOnboardingScreen() {
        onboardingScreen = new OnboardingScreen(getAppiumDriver());
        onboardingScreen.nationalIdEt.isDisplayed();
    }


    @And("The user set Birth Country")
    public void theUserSetBirthCountry() throws InterruptedException {
        placeOfBirthScreen = new PlaceOfBirthScreen(getAppiumDriver());
        placeOfBirthScreen.setBirthCountry();
    }

    @Then("error message of authentication fail")
    public void errorMessageOfAuthenticationFail() {

    }

    @Then("wait {int} min then back to onboarding screen")
    public void waitMinThenBackToOnboardingScreen(int arg0) {
    }

    @And("The user skip App introduction")
    public void theUserSkipAppIntroduction() {
        appIntroductionScreen = new AppIntroductionScreen(getAppiumDriver());
        appIntroductionScreen.allowLocationPermissionIfAppears();

        boolean isLocalIOS = TestBase.deployment.equalsIgnoreCase("local") && TestBase.platformName.equalsIgnoreCase("ios");

        if (!isLocalIOS) {
            appIntroductionScreen.completeAppIntro();
        } else if (appIntroductionScreen.isDisplayed(appIntroductionScreen.StartBtn)) {
            appIntroductionScreen.tapOnStartBtn();
        } else {
            appIntroductionScreen.tabOnSignOutPasscode();
        }
    }


    @And("The user enter missing Address streetName")
    public void theUserEnterMissingAddressStreetName() {
        PersonalDetailsScreen personalDetailsScreen = new PersonalDetailsScreen(getAppiumDriver());
        personalDetailsScreen.clickOnAddress();
        AddressScreen addressScreen = new AddressScreen(getAppiumDriver());
        addressScreen.enterStreetName("wadi nawar");
        addressScreen.confirmAddress();
    }

    @And("select later for adding card to apple wallet if applicable")
    public void selectLaterForAddingCardToAppleWallet() {
        logStep("select later for adding card to apple wallet if applicable ");
        if (platformName.equalsIgnoreCase("ios")) {
            Assert.assertTrue(onboardingInformationScreen.laterButton.isDisplayed(), "add to apple wallet pop up is not visible");
            onboardingInformationScreen.tapOnaLaterButton();
        }
    }

    @And("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        logStep("the user is on the homepage");
        Assert.assertTrue(homepage.SettingsBtn.isDisplayed(), "User did not onboard successfully");
    }
}
