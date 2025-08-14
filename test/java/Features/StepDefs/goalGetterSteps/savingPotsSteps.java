package StepDefs.goalGetterSteps;

import Screens.homeScreen.OTPScreen;
import Screens.goalGetterScreens.SavingGoalScreen;
import Screens.goalGetterScreens.SavingPotsScreen;
import TestBases.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static TestBases.DriverManager.getAppiumDriver;

public class savingPotsSteps extends TestBase {
    static String goalName;
    SavingPotsScreen savingPotsScreen = new SavingPotsScreen(getAppiumDriver());
    OTPScreen otpScreen = new OTPScreen(getAppiumDriver());
    SavingGoalScreen savingGoalScreen = new SavingGoalScreen(getAppiumDriver());
    static ThreadLocal <Integer>  numberOfGoals=new ThreadLocal<>();
    int multiplier;
    static ThreadLocal<Double> goalTargetAmount=new ThreadLocal<>();

    static double summaryTargetAmount;
    static double summaryContributionAmount;
    static double editedTargetAmount;
    static double editedContributionAmount;

    @Then("user goes to saving pots from goal getter footer tap")
    public void userGoesToSavingPotsFromGoalGetterFooterTap (){
        logStep("User navigates to saving pots from goal getter footer tap");
        savingPotsScreen.tapOnGoalGetterTabBtn();
        if(savingPotsScreen.isFirstCreateGoalBtnDisplayed()) {
            savingPotsScreen.tapOnFirstCreateGoalBtn();
        } else{
            numberOfExistingGoals();
            savingPotsScreen.tapOnCreateGoalBtn();
        }
        savingPotsScreen.tapOnUnknownBtn();
        savingPotsScreen.tapOnContinue();
        savingPotsScreen.assertElementIsDisplayed(savingPotsScreen.noRiskBtn,"noRiskButton");
        savingPotsScreen.tapOnNoRiskBtn();
        savingPotsScreen.tapOnSavingPotBtn();
        savingPotsScreen.tapOnContinue();
    }

    @And("user complete the saving pot details")
    public void userCompleteTheSavingPotDetails (){
        logStep("User completes the saving pot details");

        // fill goal details

        savingPotsScreen.tapOnCalendarBtn();
        savingPotsScreen.tapOnCalendarDay();
        savingPotsScreen.tapOnSelectDateButton();
        savingPotsScreen.tapOnSubmitButton();

        // page two
        savingPotsScreen.tapOnPhotoButton();
        savingPotsScreen.tapOnPredefinedOption();
        savingPotsScreen.tapOnImage();
        savingPotsScreen.tapOnSelectImageButton();
        savingPotsScreen.tapOnContinue();

        // end of fill goal details

        goalName = savingPotsScreen.SavingPotNameTxt.getText();
        savingPotsScreen.tapOnSavingPotCheckBox();
        savingPotsScreen.tapOnConfirmBtn();
        Assert.assertFalse(otpScreen.otpEt.isEmpty(),"OTP page is not displayed");
        otpScreen.userEnterOtp("0000");
        savingPotsScreen.assertElementIsDisplayed(savingPotsScreen.CheckItOutBtn,"CheckItOutButton");
        savingPotsScreen.tapOnCheckItOutBtn();
    }

    @And("saving pot is created successfully")
    public void savingPotIsCreatedSuccessfully () {
        logStep("Saving pot is created successfully");
        Screens.homeScreen.ScreenBase.ThreadSleep(6000);
        Assert.assertFalse(savingPotsScreen.goalGetterGoalsList.isEmpty(),"goal Getter Goals List is not displayed");
        //Assert.assertEquals(savingPotsScreen.goalGetterGoalsList.size(),(numberOfGoals + 1));
    }

    @Then("user added money to there goal")
    public void userAddedMoneyToThereGoal (){
        logStep("User adds money to their goal");
        savingPotsScreen.tapOnGoalGetterGoalsList(goalName);
        savingPotsScreen.assertElementIsDisplayed(savingPotsScreen.goalTargetAmount,"goalTargetAmount");
        goalTargetAmount.set(parseCurrencyAmount(savingPotsScreen.goalTargetAmount.getText()));
        savingPotsScreen.tapOnAddMoney();

        savingGoalScreen.RecurringPaymentsAmount(goalTargetAmount.get() + "");
        savingPotsScreen.tapOnConfirm();
        Assert.assertFalse(otpScreen.otpEt.isEmpty(),"OTP page is not displayed");
        otpScreen.userEnterOtp("0000");
        savingPotsScreen.tapOnViewGoalBtn();
    }

    @Then("tha amount will be add to the saving pot")
    public void thaAmountWillBeAddToTheSavingPot (){
        logStep("The amount will be added to the saving pot");
        double goalCurrentValue = Double.parseDouble(savingPotsScreen.goalCurrentValue.getText().split(" ")[0]);
        Assert.assertEquals(goalCurrentValue,goalTargetAmount.get(),0.001,"goal amount");

    }

    @When("user enter the saving pot goal and click on three dots on the top right corner")
    public void userEnterTheSavingPotGoalAndClickOnThreeDotsOnTheTopRightCorner (){
        logStep("User enters the saving pot goal and clicks on three dots on the top right corner");
        savingPotsScreen.tapOnGoalGetterGoalsList(goalName);
        savingPotsScreen.tapOnGoalOptionsBtn();
    }

    @And("user end the goal and collect it")
    public void userendthegoalandcollectit (){
        logStep("User ends the goal while keeping the actual product");
        savingPotsScreen.assertElementIsDisplayed(savingPotsScreen.endAndKeepProductBtn,"endAndKeepProductButton");
        savingPotsScreen.tapOnEndAndKeepProductBtn();
        savingPotsScreen.tapOnEndGoalBtn();

        savingPotsScreen.assertElementIsDisplayed(savingPotsScreen.endGoalTxt,"endGoalTxt");
        savingPotsScreen.tapOnConfirmBtn();
        savingPotsScreen.tapOnEndGoalBtn();
        savingPotsScreen.tapOnContinue();

        Assert.assertFalse(otpScreen.otpEt.isEmpty(),"OTP page is not displayed");
        otpScreen.userEnterOtp("0000");
    }

    @And("delete saving pot")
    public void deleteSavingPot (){
        logStep("User deletes saving pot");
        try {
            savingPotsScreen.deleteSavingPot(goalName);
            Assert.assertFalse(otpScreen.otpEt.isEmpty(),"OTP page is not displayed");
            otpScreen.userEnterOtp("0000");
            savingPotsScreen.tapOnViewProductBtn();
            savingPotsScreen.tapOnSavingPotProductsTapBtn();
            savingGoalScreen.deleteGoal(goalName);
        } catch (Exception ignored) {
        }
    }

    @When("user open a completed goal")
    public void userOpenACompletedGoal (){
        logStep("User opens a completed goal");
        savingPotsScreen.tapOnGoalGetterGoalsList(goalName);
    }

    @And("choose extend your goal options")
    public void chooseExtendYourGoalOptions (){
        logStep("User chooses to extend their goal options");
        savingPotsScreen.tapOnExtendYourGoalBtn();
    }

    @And("choose collect your goal options")
    public void chooseCollectYourGoalOptions (){
        logStep("User chooses to collect their goal options");
        savingPotsScreen.tapOnCollectPotBtn();
        savingPotsScreen.tapOnCollectBtn();
        savingPotsScreen.tapOnContinue();
        Assert.assertFalse(otpScreen.otpEt.isEmpty(),"OTP page is not displayed");
        otpScreen.userEnterOtp("0000");
        savingPotsScreen.tapOnViewProductBtn();
    }

    @Then("the saving pot goal is ended successfully")
    public void thesavingpotgoalisendedsuccessfully  (){
        logStep("the saving pot goal is ended successfully");
        savingPotsScreen.tapOnViewProductBtn();
        savingPotsScreen.assertElementIsDisplayed(savingPotsScreen.firstCreateGoalBtn,"goalGetterMainScreen");
    }

    private void numberOfExistingGoals (){
        try {
            numberOfGoals.set(savingPotsScreen.goalGetterGoalsList.size());
            if(numberOfGoals.get() == 4) {
                goalName=savingPotsScreen.goalGetterGoalsList.get(0).getText();
                savingPotsScreen.deleteSavingPot(goalName);
                Assert.assertFalse(otpScreen.otpEt.isEmpty(),"OTP page is not displayed");
                otpScreen.userEnterOtp("0000");
                savingPotsScreen.tapOnViewProductBtn();
                savingPotsScreen.tapOnSavingPotProductsTapBtn();
                savingGoalScreen.deleteGoal(goalName);
                numberOfGoals.set(numberOfGoals.get()-1);
                Assert.fail("number of goals are 4 can not create more goals");
            }
            //this code to delete a saving pot goal
//            if(numberOfGoals >= 1) {
//                savingPotsScreen.deleteSavingPot();
//                otpScreen.userEnterOtp("0000");
//                savingPotsScreen.tapOnViewProductBtn();
//                Assert.assertTrue(savingPotsScreen.isProductsTapDisplayed());
//                savingPotsScreen.tapOnSavingPotProductsTapBtn();
//                savingGoalScreen.deleteGoal();
//                savingGoalScreen.TapOnBackButton();
//                numberOfGoals -= 1;
//            }
        } catch (NoSuchElementException e) {
            numberOfGoals.set(0);
        }
    }

    @And("extend there goal with extra amount of {string}")
    public void extendThereGoalWithExtraAmountOf (String extraAmount){
        navigateThroughGoalExtensionSteps();
        verifyContributionAmount(extraAmount);
        confirmGoalExtension();
        enterOtpAndViewGoal();
        validateNewGoalTargetAmount(extraAmount);
    }

    private void navigateThroughGoalExtensionSteps (){
        savingPotsScreen.tapOnSelectDateBtn();
        savingPotsScreen.tapOnSetDateBtn();
        savingPotsScreen.tapOnUpdateDateBtn();
        savingPotsScreen.tapOnContributionAmount();
    }

    private void verifyContributionAmount (String extraAmount){
        savingGoalScreen.RecurringPaymentsAmount("delete");
        savingGoalScreen.RecurringPaymentsAmount(extraAmount);
        savingPotsScreen.tapOnUpdate();

        savingPotsScreen.assertElementIsDisplayed(savingPotsScreen.contributionAmountTxt,"contributionAmountTxt");

        double displayedAmount = parseCurrencyAmount(savingPotsScreen.contributionAmountTxt.getText());
        double expectedAmount = Double.parseDouble(extraAmount);
        Assert.assertEquals(expectedAmount,displayedAmount,0.001,"Extend amount did not match in the confirm details page");
        multiplier = savingPotsScreen.recurringTypeValueText.getText().equalsIgnoreCase("weekly") || savingPotsScreen.recurringTypeValueText.getText().equalsIgnoreCase("اسبوعي") ? 54 : 12;
    }

    private void confirmGoalExtension (){
        savingPotsScreen.tapOnConfirm();
    }

    private void enterOtpAndViewGoal (){
        Assert.assertFalse(otpScreen.otpEt.isEmpty(),"OTP page is not displayed");
        otpScreen.userEnterOtp("0000");
        savingPotsScreen.tapOnViewGoalBtn();
    }

    private void validateNewGoalTargetAmount (String extraAmount){
        double expectedAmount = Double.parseDouble(extraAmount);
        double totalAmountAfterExtending = goalTargetAmount.get() + (expectedAmount * multiplier);

        double updatedGoalTargetAmount = parseCurrencyAmount(savingPotsScreen.goalTargetAmount.getText());
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(updatedGoalTargetAmount,totalAmountAfterExtending,0.001,"Calculation for extending the goal is not correct");
        goalTargetAmount.set(updatedGoalTargetAmount);
    }
    // Utility method to parse and validate currency amounts
    private double parseCurrencyAmount (String amountText){
        if (amountText == null || amountText.isEmpty()) {
            throw new IllegalArgumentException("Amount text is null or empty");
        }
        String cleaned = amountText.replace(",", "").trim();
        if (cleaned.contains(" ")) {
            cleaned = cleaned.split(" ")[0];
        }
        return Double.parseDouble(cleaned);
    }

    @And("user edit the goal details with {string} target amount and {string} as contribution")
    public void userEditTheGoalDetailsWithTargetAmountAndAsContribution (String target,String contribution){
        editedTargetAmount = Integer.parseInt(target);
        editedContributionAmount = Integer.parseInt(contribution);
        goalName = "Rahaf edit";
        savingPotsScreen.assertElementIsDisplayed(savingPotsScreen.editGoalBtn,"editGoalButton");
        savingPotsScreen.tapOnEditGoalBtn();
        savingPotsScreen.editGoal(goalName);
        savingPotsScreen.tapOnEditGoalAmountTxt();
        savingGoalScreen.RecurringPaymentsAmount("delete");
        savingGoalScreen.RecurringPaymentsAmount(target);
        savingGoalScreen.tapOnScreen();
        savingPotsScreen.tapOnEditGoalContinueBtn();
    }


    @Then("confirm the changes of the goal on the summary")
    public void confirmTheChangesOfTheGoalOnTheSummary (){
        if(savingPotsScreen.isDisplayed(savingPotsScreen.proceedWithoutChangesBtn)) {
            savingPotsScreen.tapOnProceedWithoutChangesBtn();
        }
        savingPotsScreen.assertElementIsDisplayed(savingPotsScreen.goalSummaryTxt,"goalSummaryTxt");

        summaryTargetAmount = parseCurrencyAmount(savingPotsScreen.summaryTargetAmountTxt.getText());

        Assert.assertEquals(summaryTargetAmount,editedTargetAmount,"target amount does match what was provided to it in edit screen");

        savingPotsScreen.tapOnConfirm();
    }

    @And("click on Check It Out button")
    public void clickOnCheckItOutButton (){
        savingPotsScreen.assertElementIsDisplayed(savingPotsScreen.ViewGoalBtn,"ViewGoalButton");
        savingPotsScreen.tapOnViewGoalBtn();
    }

    @Then("verify that edits are reflected to the goal")
    public void verifyThatEditsAreReflectedToTheGoal (){
        savingPotsScreen.assertElementIsDisplayed(savingPotsScreen.goalTargetAmount,"goalTargetAmount");
        goalTargetAmount.set(parseCurrencyAmount(savingPotsScreen.goalTargetAmount.getText()));
        System.out.println("goalTargetAmount = " + goalTargetAmount.get());
        Assert.assertEquals(goalTargetAmount.get(),editedTargetAmount,"new target amount is not reflected");
    }
}
