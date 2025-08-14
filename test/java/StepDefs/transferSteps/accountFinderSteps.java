package StepDefs.transferSteps;

import Screens.homeScreen.HomepageScreen;

import Screens.homeScreen.IVRScreen;
import Screens.homeScreen.OTPScreen;
import Screens.transferScreens.*;

import TestBases.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
import org.testng.Assert;

import static TestBases.DriverManager.getAppiumDriver;


public class accountFinderSteps extends TestBase {
    HomepageScreen homepageScreen = new HomepageScreen(getAppiumDriver());
    AccountFinderScreen accountFinderScreen = new AccountFinderScreen(getAppiumDriver());

    @Then("user goes to Account Finder option from transfer quick action")
    public void userGoesToAccountFinderOptionFromTransferQuickAction (){
        if(TestBase.environment.equalsIgnoreCase("sit"))
        {
            homepageScreen.clickOnQuickActionByText("Transfer");

        }
        else if(TestBase.environment.equalsIgnoreCase("uat"))
        {
            homepageScreen.clickOnQuickActionByText("Transfers");

        }        accountFinderScreen.assertElementIsDisplayed(accountFinderScreen.accountFinderBtn,"accountFinderButton");
        accountFinderScreen.tapOnAccountFinderBtn();
    }

    @When("a message 'You have to activate account finder first' appear")
    public void aMessageYouHaveToActivateAccountFinderFirstAppear (){
        accountFinderScreen.tapOnActivateBtn();
        Assert.assertTrue(accountFinderScreen.isConfirmBtnDisplayed(),"account finder confirm button is not displayed");
    }
    @Then("user click on confirm to activate account finder")
    public void userClickOnConfirmToActivateAccountFinder (){
        accountFinderScreen.tapOnConfirmBtn();
    }

    @And("pass IVR call")
    public void passIVRCall (){
        IVRScreen ivrScreen=new IVRScreen(getAppiumDriver());
        ivrScreen.passIVR();
    }

    @Then("account finder is activated successfully")
    public void accountFinderIsActivatedSuccessfully (){
        Assert.assertTrue(accountFinderScreen.isSuccessfullyTxtDisplayed(),"account finder did not activate");
        accountFinderScreen.tapOnCloseButton();
    }

    @And("user select Inquiry option")
    public void userSelectInquiryOption (){
        accountFinderScreen.tapOnInquiryBtn();
        Assert.assertFalse(accountFinderScreen.isAccountFinderIsDisabledTxtDisplayed(),"Account finder is disabled 24H Remaining time");
    }

    @When("user enter the OTP as {string}")
    public void userEnterTheOTPAs (String otp){
        OTPScreen otpScreen=new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp(otp);

    }

    @Then("user did get Inquiry screen successfully")
    public void userDidGetInquiryScreenSuccessfully (){
        Assert.assertTrue(accountFinderScreen.isBankParticipantCardTxtDisplayed(),"the first element on account finder screen is not displayed");
    }

    @And("active account finder if it not active")
    public void activeAccountFinderIfItNotActive() {
        logStep("active account finder if it not active");
        if (!accountFinderScreen.isDisplayed(accountFinderScreen.inquiryBtn)){
            aMessageYouHaveToActivateAccountFinderFirstAppear();
            userClickOnConfirmToActivateAccountFinder();
            passIVRCall();
            accountFinderIsActivatedSuccessfully();
        }
    }
}
