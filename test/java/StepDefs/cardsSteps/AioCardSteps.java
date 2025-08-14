package StepDefs.cardsSteps;

import Screens.customerOnBoardingScreens.PassCodeScreen;
import Screens.homeScreen.OTPScreen;
import TestBases.TestBase;
import Utilities.commonClasses.AppConstants;
import Utilities.commonClasses.Helper;
import io.cucumber.java.en.And;
import Screens.cardsScreen.AioScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.concurrent.ThreadLocalRandom;

import static TestBases.DriverManager.getAppiumDriver;

public class AioCardSteps extends TestBase {
    AioScreen AioScreen = new AioScreen(getAppiumDriver());
    OTPScreen otpScreen=new OTPScreen(getAppiumDriver());
    String platformName = String.valueOf(getAppiumDriver().getCapabilities().getPlatformName());

    String PIN;
    PassCodeScreen passCodeScreen = new PassCodeScreen(getAppiumDriver());


    @And("user navigates to AioScreen and verifies Explore button")
    public void userNavigatesToAioScreenAndVerifiesExploreButton (){
        Assert.assertTrue(AioScreen.isExploreBtnDisplayed());
    }

    @And("user completes initial setup for credit plus")
    public void userCompletesInitialSetup ()  {
        AioScreen.tapOnExploreBtn();
        AioScreen.tapOnApplyForAIOBtn();
        AioScreen.tapOnChooseRewardsMethodBtn();
        AioScreen.tapOnContinueBtn();
        AioScreen.tapOnSelectPaymentOptionScreenContinueBtn();
        AioScreen.tapOnAgreeCheckBox();
        AioScreen.tapOnConfirmBtn();
        Helper.addExtraInfoToDatafile("'credit plus'");
    }

    @And("user completes initial setup for credit")
    public void userCompletesInitialSetupForCredit ()  {
        AioScreen.tapOnExploreBtn();
        AioScreen.activateCreditCard();
        AioScreen.tapOnChooseRewardsMethodBtn();
        AioScreen.tapOnContinueBtn();
        AioScreen.tapOnAgreeCheckBox();
        AioScreen.tapOnConfirmBtn();
        Helper.addExtraInfoToDatafile("'credit'");
    }

    @And("user enters OTP {string} and activates card")
    public void userEntersOtpAndActivatesCard (String otp)  {
        otpScreen.retryWaitElement(otpScreen.otpEt.get(0));
        otpScreen.userEnterOtp(otp);
        AioScreen.waitUntilElementAppear(AioScreen.activateCardBtn,50);
        AioScreen.tapOnActivateCardBtn();
    }

    @And("user sets up passcode {string} twice")
    public void userSetsUpPasscodeTwice (String PIN) {
        Assert.assertFalse(AioScreen.cardsPinPad.isEmpty());
        passCodeScreen.userEnterPassCode(PIN);
        passCodeScreen.userEnterPassCode(PIN);
    }

    @And("user is on the card page")
    public void userIsOnTheCardPage () {
        AioScreen.waitUntilElementAppear(AioScreen.settingsBtn,15);
        AioScreen.assertElementIsDisplayed(AioScreen.settingsBtn,"settingsButton");

    }

    @And("user select credit plus card")
    public void userSelectCreditPlusCard ()  {

        Assert.assertTrue(AioScreen.isExploreBtnDisplayed());
        AioScreen.tapOnExploreBtn();
        AioScreen.tapOnApplyForAIOBtn();
        AioScreen.tapOnChooseRewardsMethodBtn();
        AioScreen.tapOnContinueBtn();
        AioScreen.tapOnContinueBtn();
        AioScreen.tapOnAgreeCheckBox();
        AioScreen.tapOnConfirmBtn();
        otpScreen.userEnterOtp("0000");
        AioScreen.tapOnActivateCardBtn();
        Assert.assertFalse(AioScreen.cardsPinPad.isEmpty());
        passCodeScreen.userEnterPassCode("1245");
        passCodeScreen.userEnterPassCode("1245");
        AioScreen.tapOnViewCardBtn();
        AioScreen.assertElementIsDisplayed(AioScreen.settingsBtn,"settingsButton");
    }

    @And("user select credit card")
    public void userSelectCreditCard ()  {

        Assert.assertTrue(AioScreen.isExploreBtnDisplayed());
        AioScreen.tapOnExploreBtn();
        AioScreen.tapOnApplyForAIOBtn();
        AioScreen.tapOnChooseRewardsMethodBtn();
        AioScreen.tapOnContinueBtn();
        AioScreen.tapOnContinueBtn();
        AioScreen.tapOnAgreeCheckBox();
        AioScreen.tapOnConfirmBtn();
        otpScreen.userEnterOtp("0000");
        AioScreen.tapOnActivateCardBtn();
        Assert.assertFalse(AioScreen.cardsPinPad.isEmpty());
        passCodeScreen.userEnterPassCode("1245");
        passCodeScreen.userEnterPassCode("1245");
        AioScreen.tapOnViewCardBtn();
        AioScreen.assertElementIsDisplayed(AioScreen.settingsBtn,"settingsButton");
    }

    @Then("goes to the settings page")
    public void goesToTheSettingsPage () {
        AioScreen.waitUntilElementAppear(AioScreen.settingsBtn,20);
        AioScreen.tapOnSettingsBtn();
    }

    @And("verify that All 6 options are displayed")
    public void verifyThatAllOptionsAreDisplayed (){
        AioScreen.assertElementIsDisplayed(AioScreen.changeCardPINBtn,"changeCardPINButton");
        AioScreen.assertElementIsDisplayed(AioScreen.orderPhysicalCardBtn,"orderPhysicalCardButton");
        AioScreen.assertElementIsDisplayed(AioScreen.statementsBtn,"statementsButton");
        AioScreen.assertElementIsDisplayed(AioScreen.cardCloseBtn,"cardCloseButton");
        if(platformName.equalsIgnoreCase("ios")) {
            AioScreen.assertElementIsDisplayed(AioScreen.addToWalletBtn,"addToWalletButton");
        }
        AioScreen.assertElementIsDisplayed(AioScreen.permanentCardClosureBtn,"permanentCardClosureButton");
    }

    @And("verify that All 5 options are displayed for nera plus card")
    public void verifyThatAllOptionsAreDisplayedForNeraPlusCard(){
        AioScreen.assertElementIsDisplayed(AioScreen.changeCardPINBtn,"changeCardPINButton");
        AioScreen.assertElementIsDisplayed(AioScreen.statementsBtn,"statementsButton");
        AioScreen.assertElementIsDisplayed(AioScreen.cardCloseBtn,"cardCloseButton");
        if(platformName.equalsIgnoreCase("ios")) {
            AioScreen.assertElementIsDisplayed(AioScreen.addToWalletBtn,"addToWalletButton");
        }
        AioScreen.assertElementIsDisplayed(AioScreen.permanentCardClosureBtn,"permanentCardClosureButton");
    }

    @Then("change card PIN option navigated to the corresponding page")
    public void changeCardPINOptionNavigatedToTheCorrespondingPage (){
        logStep("change card PIN option navigated to the corresponding page");
        AioScreen.tapOnChangeCardPINBtn();
        Assert.assertFalse(AioScreen.cardsPinPad.isEmpty());
        AioScreen.tapOnBackBtn();
    }

    @And("order physical card option navigated to the corresponding page")
    public void orderPhysicalCardOptionNavigatedToTheCorrespondingPage (){
        logStep("order physical card option navigated to the corresponding page");
        AioScreen.tapOnOrderPhysicalCardBtn();
        AioScreen.assertElementIsDisplayed(AioScreen.deliveryAddressScreenConfirmBtn,"deliveryAddressScreenConfirmButton");
        AioScreen.tapOnBackBtn();
    }


    @And("card close and replacement option navigated to the corresponding page")
    public void cardCloseAndReplacementOptionNavigatedToTheCorrespondingPage (){
        logStep("card close and replacement option navigated to the corresponding page");
        AioScreen.tapOnCardCloseBtn();
        AioScreen.assertElementIsDisplayed(AioScreen.replacementCardScreenBtn,"replacementCardScreenButton");
        AioScreen.tapOnBackBtn();
    }

    @And("add to Apple wallet option navigated to the corresponding page")
    public void addToAppleWalletOptionNavigatedToTheCorrespondingPage (){
        logStep("add to Apple wallet option navigated to the corresponding page");
        if(platformName.equalsIgnoreCase("ios")) {
            AioScreen.tapOnAddToWalletBtn();
            AioScreen.waitUntilElementAppear(AioScreen.cardToWalletScreenBtn,3);
            AioScreen.assertElementIsDisplayed(AioScreen.cardToWalletScreenBtn,"cardToWalletScreenButton");
            AioScreen.tapOnBackBtn();
        }
    }

    @And("permanent card closure option navigated to the corresponding page")
    public void permanentCardClosureOptionNavigatedToTheCorrespondingPage (){
        logStep("permanent card closure option navigated to the corresponding page");
        AioScreen.tapOnPermanentCardClosureBtn();
        AioScreen.assertElementIsDisplayed(AioScreen.permanentCardClosureScreenBtn,"permanentCardClosureScreenButton");
        AioScreen.tapOnBackBtn();
    }

    @And("statements option navigated to the corresponding page")
    public void statementsOptionNavigatedToTheCorrespondingPage (){
        logStep("statements option navigated to the corresponding page");
        AioScreen.tapOnStatementsBtn();
        AioScreen.assertElementIsDisplayed(AioScreen.requestNewStatementYear,"requestNewStatementYear");
    }

    @And("click on 'change PIN' option")
    public void clickOnOption (){
        AioScreen.tapOnChangeCardPINBtn();
        Assert.assertFalse(AioScreen.cardsPinPad.isEmpty());
    }

    @Then("enter and confirm a new PIN")
    public void enterAndConfirmANewPIN (){
        PIN = String.valueOf(ThreadLocalRandom.current().nextInt(1000, 10000));
        passCodeScreen.userEnterPassCode(PIN);
        passCodeScreen.userEnterPassCode(PIN);
        otpScreen.waitUntilElementAppear(otpScreen.otpEt.get(0),3);
        otpScreen.userEnterOtp("0000");
    }

    @And("verify that PIN number has changed to the new PIN")
    public void verifyThatPINNumberHaseChangedTo () throws InterruptedException {
        Thread.sleep(10000);
        AioScreen.tapOnBackBtn();
        AioScreen.tapOnViewCardDetailsBtn();
        passCodeScreen.waitUntilElementAppear(passCodeScreen.zeroBtn,30);
        passCodeScreen.userEnterPassCode(PIN);
//        AioScreen.waitUntilElementAppear(AioScreen.cardControlScreen,30);
//        AioScreen.assertElementIsDisplayed(AioScreen.cardControlScreen,"cardControlScreen");
    }

    @And("User press on Close and Replacement option then navigated to Replacement flow")
    public void UserPressOnCloseAndReplacementOptionThenNavigatedToReplacementFlow()  {
        logStep("User press on Close and Replacement option then navigated to Replacement flow");
        AioScreen.tapOnCardCloseBtn();
        AioScreen.assertElementIsDisplayed(AioScreen.replacementCardScreenBtn,"replacementCardScreenButton");
        if (platformName.equalsIgnoreCase("ios"))
        {
            AioScreen.tapOnCardStolen();
        }else {
            AioScreen.selectQuestionList("Card Fraud");
        }

        AioScreen.clickOnReplacementCardBtn();
        AioScreen.clickOnCancelAndReplaceCardBtn();
        AioScreen.clickOnCardReplacementFeesBtn();
        otpScreen.waitUntilElementAppear(otpScreen.otpEt.get(0),20);
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp("0000");
        AioScreen.tapOnActivateCardAfterReplacementBtn();
    }

    @When("customer clicks choose your subscription tab in the benefits section")
    public void customerClicksChooseYourSubscriptionTabInTheBenefitsSection (){
        AioScreen.tapOnChooseYourSubscriptionBtn();
    }

    @Then("verify that 3 cursors displaying the introduction of the subscription with the “unlock Free benefits” button")
    public void verifyThatCursorsDisplayingTheIntroductionOfTheSubscriptionWithTheUnlockFreeBenefitsButton (){
        AioScreen.assertElementIsDisplayed(AioScreen.unlockFreeBenefitsBtn,"unlockFreeBenefitsButton");
        AioScreen.tapOnUnlockFreeBenefitsBtn();
        AioScreen.assertElementIsDisplayed(AioScreen.unlockFreeBenefitsBtn,"unlockFreeBenefitsButton");
        AioScreen.tapOnUnlockFreeBenefitsBtn();
        AioScreen.assertElementIsDisplayed(AioScreen.unlockFreeBenefitsBtn,"unlockFreeBenefitsButton");
        AioScreen.tapOnUnlockFreeBenefitsBtn();

    }

    @And("user will be redirected to the 'Your Benefits' page")
    public void userWillBeRedirectedToThePage (){
        AioScreen.assertElementIsDisplayed(AioScreen.SearchBar,"SearchBar");
        AioScreen.assertElementIsDisplayed(AioScreen.AnghamiActiveBenefitsBtn,"AnghamiActiveBenefitsButton");
        AioScreen.assertElementIsDisplayed(AioScreen.ChooseTwoBenefitsTxt,"ChooseTwoBenefitsTxt");
        AioScreen.assertElementIsDisplayed(AioScreen.BenefitsBackBtn,"BenefitsBackButton");
    }

    @And("user activate a specific subscription")
    public void userActivateASpecificSubscription (){
        AioScreen.tapOnAnghamiActiveBenefitsBtn();
        AioScreen.tapOnConfirmCheckBox();
        AioScreen.tapOnActiveBtn();
    }

    @And("the benefit will disappear from the 'All Benefits' screen")
    public void theBenefitWillDisappearFromTheScreen (){
        AioScreen.assertElementIsDisplayed(AioScreen.successMessage,"successMessage");
        AioScreen.assertElementIsDisplayed(AioScreen.AnghamiActiveBenefitsBtn,"AnghamiActiveBenefitsButton");
    }

    @And("the benefit will move to the 'Active Benefits' screen")
    public void theBenefitWillMoveToTheActiveBenefitsScreen (){
        AioScreen.tapOnActiveBenefitsTap();
        AioScreen.assertElementIsDisplayed(AioScreen.activeTxt,"activeTxt");
    }

    @Then("Set static data for nera card transaction history")
    public void setStaticDataForNeraTransactionHistory(){
        AppConstants.OnboardNationalID.set("1552233220");;
        AppConstants.OnboardMobileNumber.set("552233220");;
        AppConstants.Passcode.set("778899");

    }

    @Then("Set static data for nera plus card transaction history")
    public void setStaticDataForNeraPlusTransactionHistory(){
        AppConstants.OnboardMobileNumber.set("540859489");
        AppConstants.OnboardNationalID.set("1540859488 ");
        AppConstants.Passcode.set("778899");

    }

    @Then("User press on transaction view all button and check all the records")
    public void UserPressOnTransactionViewAllButton()  {
        logStep("User press on transaction view all button and check all the records");
        AioScreen.clickOnHistoryViewAllBtn();
        Assert.assertTrue(AioScreen.isDisplayed(AioScreen.filterByTxt));
        AioScreen.clickOnTransactionListItem();
    }

    @Then("User Freeze the card")
    public void UserFreezeTheCard(){
        logStep("User Freeze the card");
        AioScreen.clickOnFreezeBtn();
        AioScreen.clickOnFreezeMyCardBtn();

    }

    @Then("User DeFrost the card")
    public void UserDefrostTheCard(){
        logStep("User DeFrost the card");
        AioScreen.clickOnDefrostBtn();
        AioScreen.clickOnDefrostMyCardBtn();
        AioScreen.waitUntilElementAppear(AioScreen.freezeBtn,30);
        AioScreen.assertElementIsDisplayed(AioScreen.freezeBtn,"freezeButton");
    }

    @Then("User adds {string} SAR to the card successfully")
    public void UserAddsMoneyToTheCardSuccessfully(String value){
        logStep("User adds {string} SAR to the card successfully");
        AioScreen.clickOnAddMoneyBtn();
        AioScreen.clickOnAndEnterValueInEnterAmountTxt(value);
        AioScreen.clickOnTopUpAndRefundConfirmBtn();
        AioScreen.clickOnTopUpAndRefundContinueBtn();
        AioScreen.waitUntilElementAppear(AioScreen.successMoneyAdditionDoneBtn,30);
        AioScreen.clickOnSuccessMoneyAdditionDoneBtn();
    }

    @Then("User adds {string} SAR which exceeds the available balance to the card")
    public void UserAddsMoneyWhichExceedsTheAvailableBalanceToTheCard(String value){
        logStep("User adds {string} SAR which exceeds the available balance to the card");
        AioScreen.clickOnAddMoneyBtn();
        AioScreen.clickOnAndEnterValueInEnterAmountTxt(value);
        AioScreen.assertElementIsDisplayed(AioScreen.InsufficientFundsErrorMessage,"InsufficientFundsErrorMessage");
    }

    @Then("User refunds money from the card successfully")
    public void userRefundsMoneyFromTheCard(){
        logStep("User refunds money from the card successfully");
        AioScreen.clickOnRefundBtn();
        AioScreen.clickOnRefundConfirmBtn();
        AioScreen.clickOnRefundContinueBtn();
        AioScreen.assertElementIsDisplayed(AioScreen.refundDoneBtn,"refund Done screen");

        AioScreen.clickOnRefundDoneBtn();
    }

    @Then("User refunds {string} SAR which exceeds the available balance in the card")
    public void userRefundsSARWhichExceedsTheAvailableBalanceInTheCards(String value){
        logStep("User refunds {string} SAR which exceeds the available balance in the card");
        AioScreen.clickOnRefundBtn();
        AioScreen.clickOnRefundPartiallyBtn();
        AioScreen.clickOnAndEnterValueInEnterAmountTxt(value);
        AioScreen.assertElementIsDisplayed(AioScreen.InsufficientFundsErrorMessage,"InsufficientFundsErrorMessage");
    }

    @When("user activate nera card")
    public void userActivateNeraCard() {
        AioScreen.tapOnCardActivationButton();
    }
    @When("user on card screen")
    public void userIsCardScreen() {
        logStep("user is card screen");
        AioScreen.waitUntilElementAppear(AioScreen.aioScreenTitle,30);
        AioScreen.assertElementIsDisplayed(AioScreen.aioScreenTitle,"aioScreenTitle");
    }

    @Then("user is activate card successfully")
    public void userIsActivateCardSuccessfully()  {
        AioScreen.waitUntilElementAppear(AioScreen.neraCardActivatedMsg,80);
        AioScreen.assertElementIsDisplayed(AioScreen.neraCardActivatedMsg,"neraCardActivatedMsg");
    }

    @And("user view card details")
    public void userViewCardDetails()  {
        Screens.homeScreen.ScreenBase.ThreadSleep(5000);
        AioScreen.retryWaitElement(AioScreen.viewCard);
        AioScreen.assertElementIsDisplayed(AioScreen.viewCard,"viewCard");
        AioScreen.tapOnViewCard();
    }

    @And("user verify that nera card is already activated")
    public void userVerifyThatNeraCardIsAlreadyActivated() {
        if(platformName.equalsIgnoreCase("Android"))
        {
            AioScreen.assertElementIsDisplayed(AioScreen.cardAvailableBalance,"cardAvailableBalance");
        }
    }
}