package StepDefs.cardsSteps;

import Screens.cardsScreen.AioScreen;
import Screens.cardsScreen.DebitCardScreen;
import Screens.homeScreen.HomepageScreen;
import Screens.homeScreen.OTPScreen;
import TestBases.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static TestBases.DriverManager.getAppiumDriver;

public class debitCardsSteps extends TestBase {
    HomepageScreen homepageScreen;
    DebitCardScreen debitCardScreen;
    OTPScreen otpScreen;
    @And("user activate debit card")
    public void userActivateDebitCard()  {
        debitCardScreen=new DebitCardScreen(getAppiumDriver());
        debitCardScreen.retryWaitElement(debitCardScreen.activateCardBtn);
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.activateCardBtn,"activateCardButton");
        debitCardScreen.clickOnActivateCardBtn();
        otpScreen=new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterPin("2580");
        otpScreen.userEnterPin("2580");
        Screens.homeScreen.ScreenBase.ThreadSleep(10000);
        debitCardScreen.retryWaitElement(debitCardScreen.finishButton);
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.finishButton,"finishButton");
        debitCardScreen.clickOnFinishButton();
    }

    @And("user user click on cards tab")
    public void userUserClickOnCardsTab() {
        debitCardScreen=new DebitCardScreen(getAppiumDriver());
        debitCardScreen.retryWaitElement(debitCardScreen.debitCardStack);
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.debitCardStack,"debitCardStack");

        debitCardScreen.clickOnDebitCardStack();
    }
    @And("verify card details after activation")
    public void verifyCardDetailsAfterActivation() {
        homepageScreen=new HomepageScreen(getAppiumDriver());
        homepageScreen.assertElementIsDisplayed(homepageScreen.CopyNumberBtn,"CopyNumberButton");
        homepageScreen.clickOnNavigateToAccountBtn();
        debitCardScreen=new DebitCardScreen(getAppiumDriver());
        userUserClickOnCardsTab();
    }

    @And("user wait for card to be displayed")
    public void userWaitForCardToBeDisplayed()  {
        debitCardScreen=new DebitCardScreen(getAppiumDriver());
        debitCardScreen.clickOnBackBt();
        homepageScreen=new HomepageScreen(getAppiumDriver());
        homepageScreen.assertElementIsDisplayed(homepageScreen.CopyNumberBtn,"CopyNumberButton");
        homepageScreen.clickOnNavigateToAccountBtn();
    }

    @And("user click on card setting")
    public void userClickOnCardSetting() {        
        debitCardScreen=new DebitCardScreen(getAppiumDriver());
        debitCardScreen.clickOnCardSettings();
    }
    @And("user update with new pin {string}")
    public void userUpdateOldPinAsWithNewPin( String newPin)  {
        debitCardScreen=new DebitCardScreen(getAppiumDriver());
        debitCardScreen.clickOnCardChangePinBtn();
        otpScreen=new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterPin(newPin);
        Screens.homeScreen.ScreenBase.ThreadSleep(3000);
        otpScreen.userEnterPin(newPin);
        Screens.homeScreen.ScreenBase.ThreadSleep(3000);
        otpScreen.userEnterOtp("0000");

    }

    @And("verify pin code updated successfully")
    public void verifyPinCodeUpdatedSuccessfully(){
        debitCardScreen=new DebitCardScreen(getAppiumDriver());
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.successChangePinBtn,"successChangePinButton");
    }

    @And("user update with week pin {string}")
    public void userUpdateOldPinAsWithWeekPin(String newPin) {
        debitCardScreen=new DebitCardScreen(getAppiumDriver());
        debitCardScreen.clickOnCardChangePinBtn();
        otpScreen=new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterPin(newPin);
        otpScreen.tapOnPinCodeScreenHeader();

    }

    @And("verify that error PincodeTooEasyAlert message is appearing")
    public void verifyThatErrorMessageIsAppearing() {
        debitCardScreen=new DebitCardScreen(getAppiumDriver());
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.PincodeTooEasyAlert,"PincodeTooEasyAlert");
    }

    @Then("user order physical card")
    public void userOrderPhysicalCard() {
        debitCardScreen=new DebitCardScreen(getAppiumDriver());
        debitCardScreen.clickOnOrderPhysicalCard();
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.requestPhysicalCardModalConfirmButton,"requestPhysicalCardModalConfirmButton");
        debitCardScreen.clickOnRequestPhysicalCardModalConfirmButton();
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.cardConfirmAddressButton,"cardConfirmAddressButton");
        debitCardScreen.clickOnCardConfirmAddressButton();
        debitCardScreen.retryWaitElement(debitCardScreen.orderReviewScreen);
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.orderReviewScreen,"orderReviewScreen");
        debitCardScreen.retryWaitElement(debitCardScreen.paymentSection);
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.paymentSection,"paymentSection");
        debitCardScreen.clickOnDoneBtn();
        otpScreen=new OTPScreen(getAppiumDriver());
        otpScreen.retryWaitElement(otpScreen.otpEt.get(0));
//        Assert.assertTrue(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterPin("0000");
    }

    @Then("user verify that order is send successfully")
    public void userVerifyThatOrderIsSendSuccessfully()  {
        debitCardScreen.retryWaitElement(debitCardScreen.ApplyPhysicalCardSuccessScreenBtn);
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.ApplyPhysicalCardSuccessScreenBtn,"ApplyPhysicalCardSuccessScreenButton");
        debitCardScreen.clickOnApplyPhysicalCardSuccessScreenBtn();
    }

    @Then("user view setting screen options")
    public void userViewSettingScreenOptions() {
        debitCardScreen=new DebitCardScreen(getAppiumDriver());
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.settingsScreenTitle,"settingsScreenTitle");
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.cardChangePinBtn,"cardChangePinButton");
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.reportCardBtn,"reportCardButton");
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.cardPOSTransactionLimit,"cardPOSTransactionLimit");
//        debitCardScreen.assertElementIsDisplayed(debitCardScreen.cardOnlineTransactionLimit,"cardOnlineTransactionLimit");
        if (environment.equalsIgnoreCase("ios"))
        {
            debitCardScreen.assertElementIsDisplayed(debitCardScreen.AddToAppleWallet,"AddToAppleWallet");

        }

    }

    @Then("user verify activate aio card is displayed")
    public void userActivateAioCardIsDisplayed() {
        AioScreen aioScreen =new AioScreen(getAppiumDriver());
        aioScreen.retryWaitElement(aioScreen.cardActivationButton);
        aioScreen.assertElementIsDisplayed(aioScreen.cardActivationButton,"cardActivationButton");
    }

    @Then("user verify card is active")
    public void userVerifyCardIsActive() {
        debitCardScreen=new DebitCardScreen(getAppiumDriver());
        debitCardScreen.clickOnCardSettings();
        debitCardScreen=new DebitCardScreen(getAppiumDriver());
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.settingsScreenTitle,"settingsScreenTitle");
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.cardChangePinBtn,"cardChangePinButton");
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.reportCardBtn,"reportCardButton");

    }

    @And("user freez Debit card")
    public void userFreezDebitCard() {
        debitCardScreen=new DebitCardScreen(getAppiumDriver());
        debitCardScreen.waitUntilElementAppear(debitCardScreen.freezDebitCard,10);
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.freezDebitCard,"freezDebitCard");
        debitCardScreen.clickOnFreezCard();
        debitCardScreen.waitUntilElementAppear(debitCardScreen.confirmFreezDebitCard,10);
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.confirmFreezDebitCard,"confirmFreezDebitCard");
        debitCardScreen.clickOnConfirmFreezCard();
        debitCardScreen.waitUntilElementAppear(debitCardScreen.freezLockSuccessfulModalOkButton,10);
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.freezLockSuccessfulModalOkButton,"freezLockSuccessfulModalOkButton");
        debitCardScreen.clickOnFreezLockSuccessfulModalOkButton();
        debitCardScreen.waitUntilElementAppear(debitCardScreen.defrostFreezDebitCard,10);
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.defrostFreezDebitCard,"defrostFreezDebitCard");
    }

    @Then("user un-freez Debit card")
    public void userUnFreezDebitCard() {
        debitCardScreen=new DebitCardScreen(getAppiumDriver());
        debitCardScreen.clickOnDeforstFreezCard();
        debitCardScreen.retryWaitElement(debitCardScreen.confirmDefrostFreezDebitCard);
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.confirmDefrostFreezDebitCard,"confirmDefrostFreezDebitCard");
        debitCardScreen.clickOnConfirmDefrostFreezDebitCard();
        debitCardScreen.retryWaitElement(debitCardScreen.confirmUnFreezSuccessDebitCard);
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.confirmUnFreezSuccessDebitCard,"confirmUnFreezSuccessDebitCard");
        debitCardScreen.clickOnConfirmUnFreezSuccessDebitCard();
        debitCardScreen.retryWaitElement(debitCardScreen.freezDebitCard);
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.freezDebitCard,"freezDebitCard");

    }

    @And("user user click on request cards tab")
    public void userUserClickOnRequestCardsTab()  {
        debitCardScreen=new DebitCardScreen(getAppiumDriver());
        debitCardScreen.retryWaitElement(debitCardScreen.requestDebitCard);
        debitCardScreen.assertElementIsDisplayed(debitCardScreen.requestDebitCard,"requestDebitCard");
        debitCardScreen.clickOnRequestDebitCardStack();

    }
}
