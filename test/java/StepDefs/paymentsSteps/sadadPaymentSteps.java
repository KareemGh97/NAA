package StepDefs.paymentsSteps;

import Screens.homeScreen.CurrentAccountScreen;
import Screens.homeScreen.HomepageScreen;
import Screens.homeScreen.OTPScreen;
import Screens.sadadPaymentScreens.SADADPaymentScreen;
import TestBases.TestBase;
import Utilities.commonClasses.AppConstants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.time.Duration;

import static TestBases.DriverManager.getAppiumDriver;

public class sadadPaymentSteps extends TestBase {
    HomepageScreen homepageScreen = new HomepageScreen(getAppiumDriver());
    CurrentAccountScreen currentAccountScreen = new CurrentAccountScreen(getAppiumDriver());
    SADADPaymentScreen sadadPaymentScreen = new SADADPaymentScreen(getAppiumDriver());
    OTPScreen otpScreen = new OTPScreen(getAppiumDriver());


    @And("user navigates to SADAD payment screen")
    public void userNavigatesToSADADPaymentScreen() {
        logStep("And user navigates to SADAD payment screen");
//        homepageScreen.clickOnAccountNumber();
        homepageScreen.clickOnQuickActionByText("Payments");
//        currentAccountScreen.clickOnSADADpayBtn();
    }

    @Then("Verify that payment section and data appeared successfully")
    public void verifyThatAllSectionsAndDataAppearedSuccessfully() {
        logStep("Then Verify that all sections and data appeared successfully");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.PaymentDueSection,"PaymentDueSection");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.PaymentLogo,"PaymentLogo");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.savedBillsTab,"savedBillsTab");
    }

    @Then("Verify that bill details are appeared successfully")
    public void verifyThatBillDetailsAreAppearedSuccessfully() {
        logStep("Then Verify that bill details are appeared successfully");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDesBackBtn,"billDesBackBtn");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDetailsDescription,"billDetailsDescription");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDetailsEditBtn,"billDetailsEditBtn");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDetailsProvider,"billDetailsProvider");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDetailsProviderLogo,"billDetailsProviderLogo");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDetailsAmount,"billDetailsAmount");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDetailsAccNum,"billDetailsAccNum");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDetailsBillerNum,"billDetailsBillerNum");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDetailsCurrentDueDate,"billDetailsCurrentDueDate");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.PayTheBillBtn,"PayTheBillBtn");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.DeleteTheBillBtn,"DeleteTheBillBtn");
    }

    @And("user clicks on pay bill")
    public void userClickOnPayBill() {
        logStep("And user clicks on pay bill");
        sadadPaymentScreen.clickOnPayTheBillBtn();
    }

    @Then("user navigates to pay bill screen")
    public void userNavigatesToPayBillScreen() {
        logStep("Then user navigates to pay bill screen");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.PayBillHeader,"PayBillHeader");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.SpecifyBillAmountTitle,"SpecifyBillAmountTitle");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.OtherAmountTitle,"OtherAmountTitle");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.enterBillAmountXBtn,"enterBillAmountXBtn");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.enterBillAmountContinueBtn,"enterBillAmountContinueBtn");
    }

    @And("user clicks on continue button")
    public void userClicksOnContinueButton() {
        logStep("And user clicks on continue button");
        sadadPaymentScreen.clickOnEnterBillAmountContinueBtn();
    }

    @Then("user navigates to confirm bill details screen")
    public void userNavigatesToConfirmBillDetailsScreen() {
        logStep("Then user navigates to confirm bill details screen");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.PayBillHeader,"PayBillHeader");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.ConfirmBillDetailsTitle,"ConfirmBillDetailsTitle");

    }

    @And("user clicks on confirm button")
    public void userClicksOnConfirmButton() {
        logStep("And user clicks on confirm button");
        sadadPaymentScreen.clickOnConfirmBtn();
    }

    @And("user enters a valid otp {string}")
    public void userEntersAValidOtp(String otp) {
        logStep("And user enters a valid otp {string}");
        otpScreen = new OTPScreen(getAppiumDriver());
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp(otp);
        getAppiumDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @And("user clicks on add bill button")
    public void userClicksOnAddBillButton() {
        logStep("And user clicks on add bill button");
        sadadPaymentScreen.clickOnAddBillBtn();
    }

    @And("user selects bill Category {string}")
    public void userSelectsBillType(String billCategory) {
        logStep("And user selects bill Category and Subcategory");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.AddNewBillTitle,"AddNewBillTitle");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.SelectBillerCategoryTitle,"SelectBillerCategoryTitle");
        sadadPaymentScreen.waitToLoad(getAppiumDriver(), 3);
        sadadPaymentScreen.selectItem(billCategory);

    }

    @And("user selects bill Subcategory {string}")
    public void userSelectsBillSubCat(String billSubcategory) {
        logStep("And user selects bill Subcategory");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.SelectBillerTitle,"SelectBillerTitle");
        sadadPaymentScreen.selectItem(billSubcategory);
    }

    @And("user set the account number {string} of the bill")
    public void userSetTheAccountNumberOfTheBill(String AccountNumber) {
        logStep("And user set the amount {string} of bill");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.AddANewBillTitle,"AddANewBillTitle");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.EnterAccNumBackBtn,"EnterAccNumBackBtn");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.EnterAccNumXBtn,"EnterAccNumXBtn");
        sadadPaymentScreen.setAccountNumber(AccountNumber);
        sadadPaymentScreen.clickOnAccNumContinueBtn();
    }

    @And("user set the bill description {string} and continue")
    public void userSetTheBillDescriptionAndContinue(String billDesc) {
        logStep("And set the bill description {String} and continue");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.AddANewBillTitle,"AddANewBillTitle");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.enterBillDescBackBtn,"enterBillDescBackBtn");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.enterBillDescXBtn,"enterBillDescXBtn");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.EnterBillDescTitle,"EnterBillDescTitle");
        sadadPaymentScreen.setBillDescription(billDesc);
        sadadPaymentScreen.clickOnBillDesContinueBtn();
        AppConstants.BillDesc = billDesc;
    }

    @And("user clicks on add the bill button")
    public void userClicksOnAddTheBillButton() {
        logStep("And user clicks on add the bill button");
        sadadPaymentScreen.clickOnAddTheBillBtn();
    }

    @Then("user navigates to -bill added successfully- screen")
    public void userNavigatesToBillAddedSuccessfullyScreen() {
        logStep("Then user navigates to -bill added successfully- screen");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.BillAddedSuccessfullyTitle,"BillAddedSuccessfullyTitle");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.PayNowBtn,"PayNowBtn");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.CloseBtn,"CloseBtn");
    }

    @Then("user navigates to add bill screen")
    public void userNavigatesToAddBillScreen() {
        logStep("Then user navigates to add bill screen");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.selectBillerScreenBackBtn,"selectBillerScreenBackBtn");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.AddNewBillTitle,"AddNewBillTitle");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.SelectBillerCategoryTitle,"SelectBillerCategoryTitle");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.CategoryArrow,"CategoryArrow");
    }

    @Then("user navigates to bill details screen")
    public void userNavigatesToBillDetailsScreen() {
        logStep("Then user navigates to bill details screen");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.AddANewBillTitle,"AddANewBillTitle");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDesXBtn,"billDesXBtn");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.BillDescription,"BillDescription");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.EditButton,"EditButton");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.BillProvider,"BillProvider");
//        Assert.assertTrue(sadadPaymentScreen.BillProviderLogo.isDisplayed());
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.BillAmount,"BillAmount");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.AccountNumber,"AccountNumber");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.BillerNumber,"BillerNumber");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.CurrentDueDate,"CurrentDueDate");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.AddTheBillBtn,"AddTheBillBtn");
    }

    @And("user clicks on the new added bill")
    public void userClicksOnTheNewAddedBill() {
        logStep("And user clicks on the new added bill");
        sadadPaymentScreen.clickOnSavedBillsTab();
//        sadadPaymentScreen.clickOnViewAllBtn();
        System.out.println(AppConstants.BillDesc);
        sadadPaymentScreen.selectItem(AppConstants.BillDesc);
    }

    @And("user clicks on close button")
    public void userClicksOnCloseButton() {
        logStep("And user clicks on close button");
        sadadPaymentScreen.clickOnCloseBtn();
    }

    @And("user clicks on pay now button")
    public void userClicksOnPayNowButton() {
        logStep("And user clicks on pay now button");
        sadadPaymentScreen.clickOnPayNowBtn();
    }

    @And("Verify that success message bill paid successfully appears")
    public void verifyThatSuccessMessageAppears() {
        logStep("And Verify that success message bill paid successfully appears");
        sadadPaymentScreen.waitToLoad(getAppiumDriver(), 20);
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billPaidSucc,"billPaidSucc");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.referenceNum,"referenceNum");
        AppConstants.ReferenceNum = sadadPaymentScreen.getText(sadadPaymentScreen.referenceNum);
        System.out.println(AppConstants.ReferenceNum);
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.makeAnotherPaymentBtn,"makeAnotherPaymentBtn");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.CloseBtn,"CloseBtn");

    }


    @And("Try to pay the bill partially {string}")
    public void tryToPayTheBillPartially(String PaidAmount) {
        logStep("And Try to pay the bill partially {string}");
        sadadPaymentScreen.setBillAmount(PaidAmount);
        sadadPaymentScreen.clickOnEnterBillAmountContinueBtn();
    }

    @And("Try to over pay the bill {string}")
    public void tryToOverPayTheBill(String PaidAmount) {
        logStep("And Try to over pay the bill {string}");
        sadadPaymentScreen.setBillAmount(PaidAmount);
        sadadPaymentScreen.clickOnEnterBillAmountContinueBtn();
    }

    @Then("Verify that add the bill button is disabled")
    public void verifyThatAddTheBillButtonIsDisabled() {
        logStep("Then Verify that add the bill button is disabled");
        Assert.assertFalse(sadadPaymentScreen.AddTheBillBtn.isEnabled());
    }

    @Then("Verify that bill status is paid")
    public void verifyThatBillStatusIsPaid() {
        logStep("Then Verify that bill status is paid");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billStatus,"billStatus");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.paidBill,"paidBill");


    }

    @And("Verify that user can't make partial or over payment")
    public void tryToMakePartialOrOverPaymentForTheBill() {
        logStep("And Verify that user can't make partial or over payment");
//        Assert.assertFalse(sadadPaymentScreen.otherAmountRadioButton.isEnabled());
        Assert.assertFalse(sadadPaymentScreen.otherAmountRadioButton.isSelected());
    }

    @Then("Verify that account not found error message appears")
    public void verifyThatAccountNotFoundErrorMessageAppears() {
        logStep("Then Verify that account not found error message appears");
        sadadPaymentScreen.waitToLoad(getAppiumDriver(), 10);
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.errorMessage,"errorMessage");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.retryBtn,"retryBtn");
    }

    @And("Try to underpay the bill {string}")
    public void tryToUnderpayTheBill(String PaidAmount) {
        logStep("And Try to underpay the bill {string}");
        sadadPaymentScreen.setBillAmount(PaidAmount);
    }


    @And("Verify that pay now button is disabled")
    public void verifyThatPayNowButtonIsDisabled() {
        logStep("Then Verify that pay now button is disabled");
        Assert.assertFalse(sadadPaymentScreen.PayNowBtn.isEnabled());
    }

    @And("user clicks on delete the bill button")
    public void userClicksOnDeleteTheBillButton() {
        logStep("And user clicks on delete the bill button");
        sadadPaymentScreen.clickOnDeleteTheBillBtn();
    }

    @And("user clicks on cancel button")
    public void userClicksOnCancelButton() {
        logStep("And user clicks on cancel button");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.deleteBillTitle,"deleteBillTitle");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.deleteBtn,"deleteBtn");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.cancelBtn,"cancelBtn");
        sadadPaymentScreen.clickOnCancelBtn();
    }

    @Then("the bill isn't deleted and user able to redirect to saved bill screen")
    public void theBillIsnTDeletedAndUserAbleToRedirectToSavedBillScreen() {
        logStep("Then the bill isn't deleted and user able to redirect to saved bill screen");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDesBackBtn,"billDesBackBtn");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDetailsDescription,"billDetailsDescription");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDetailsEditBtn,"billDetailsEditBtn");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDetailsProvider,"billDetailsProvider");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDetailsProviderLogo,"billDetailsProviderLogo");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDetailsAmount,"billDetailsAmount");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDetailsAccNum,"billDetailsAccNum");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDetailsBillerNum,"billDetailsBillerNum");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDetailsCurrentDueDate,"billDetailsCurrentDueDate");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.PayTheBillBtn,"PayTheBillBtn");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.DeleteTheBillBtn,"DeleteTheBillBtn");
        sadadPaymentScreen.clickOnbillDesBackBtn();
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.PaymentDueSection,"PaymentDueSection");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.savedBillsTab,"savedBillsTab");

    }

    @And("user clicks on delete button")
    public void userClicksOnDeleteButton() {
        logStep("And user clicks on delete button");
        sadadPaymentScreen.clickOnDeleteBtn();
    }

    @Then("the bill is deleted and a confirmation message appears")
    public void theBillIsDeletedAndAConfirmationMessageAppears() {
        logStep("Then the bill is deleted and a confirmation message appears");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.billDeletedSucc,"billDeletedSucc");
        sadadPaymentScreen.assertElementIsDisplayed(sadadPaymentScreen.OkBtn,"OkBtn");
    }
}