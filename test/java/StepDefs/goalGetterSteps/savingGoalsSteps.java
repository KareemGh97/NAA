package StepDefs.goalGetterSteps;

import Screens.homeScreen.HomepageScreen;
import Screens.goalGetterScreens.SavingGoalScreen;
import Screens.homeScreen.ScreenBase;
import TestBases.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import java.util.Random;

import static TestBases.DriverManager.getAppiumDriver;

public class savingGoalsSteps extends TestBase {
    SavingGoalScreen savingGoalScreen;
    static int goalAvailableBalance;
    HomepageScreen homepageScreen;

    static ThreadLocal <Integer> numberOfGoals=new ThreadLocal<>();
    static ThreadLocal <Integer> numberOfCreatedGoals=new ThreadLocal<>();


    @Then("user goes to saving goals page")
    public void userGoesToSavingGoalsPage (){
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.clickOnQuickActionByText("Saving");
        savingGoalScreen = new SavingGoalScreen(getAppiumDriver());
        savingGoalScreen.setCreatedGoalsList();
        try {
            numberOfCreatedGoals.set(savingGoalScreen.getCreatedGoalsList().size());
            System.out.println("numberOfGoals"+numberOfCreatedGoals.get());
            if(numberOfCreatedGoals.get() >=4) {
                savingGoalScreen.deleteGoal(null);
                numberOfCreatedGoals.set(numberOfCreatedGoals.get()-1);
            }
        } catch (NoSuchElementException e) {
            numberOfCreatedGoals .set(0);
        }
    }

    @And("user fill in the needed data name as {string} amount as {string} and time as {string}")
    public void userFillInTheNeededDataNameAsAmountAsAndTimeAs (String SavingName,String SavingAmount,String Time){
        savingGoalScreen.tabOnCreateGoalBtn();
        Random random=new Random();
        savingGoalScreen.userEnterGoalDetails(SavingName+random.nextInt(1000),SavingAmount,Time);
    }

    @Then("the continue button is enabled and press continue the goal will be created")
    public void theContinueButtonIsEnabledAndPressContinueTheGoalWillBeCreated (){
        savingGoalScreen.tabOnCreateGoalScreenSubmitBtn();
        savingGoalScreen.tabOnNotNowBtn();
        System.out.println("numberOfGoals"+numberOfCreatedGoals.get());
        savingGoalScreen.waitUntilElementAppear(savingGoalScreen.getCreatedGoalsList().get(0),10);
        Assert.assertEquals(savingGoalScreen.getCreatedGoalsList().size(),numberOfCreatedGoals.get()+1);
    }
    @And("user edit one of the goals")
    public void userEditOneOfTheGoals (){
        logStep("user edit one of the goals");
        numberOfCreatedGoals.set(savingGoalScreen.getCreatedGoalsList().size());
        System.out.println("numberOfGoals"+numberOfCreatedGoals.get());
        if(numberOfCreatedGoals.get() == 0) {
            savingGoalScreen.tabOnCreateGoalBtn();
            savingGoalScreen.userEnterGoalDetails("goal1","5500","6 Months");
            savingGoalScreen.tabOnCreateGoalScreenSubmitBtn();
            savingGoalScreen.tabOnNotNowBtn();
        }
        savingGoalScreen.tabOnEditGoalBtn();
    }

    @Then("user can edit the goal in any sort of: Name Goal Amount \\(SAR) Target Date")
    public void userCanEditTheFollowingNameGoalAmountSARTargetDate (){
        logStep("user can edit the following: Name Goal Amount (SAR) Target Date");
        Random rand = new Random();
        savingGoalScreen.editAmount("7500");
        savingGoalScreen.editGoalName("NewName"+ rand.nextInt(1000));
        savingGoalScreen.tapOnReturnTap();
        savingGoalScreen.tabOnSaveEditBtn();
//        Assert.assertEquals();
    }

    @When("user closes a Savings Goal")
    public void userClosesASavingsGoal (){
        logStep("user closes a Savings Goal");
        savingGoalScreen.tabOnEditIcon();
        ScreenBase.ThreadSleep(9000);

        savingGoalScreen.tapOnCloseBtn();
        savingGoalScreen.tapOnConfirmBtn();
    }

    @Then("directed back to the Savings Goal landing page")
    public void theCustomerIsDirectedBackToTheSavingsGoalLandingPage (){
        logStep("the customer is directed back to the Savings Goal landing page");
//        Assert.assertTrue(savingGoalScreen.yourGoalsPage.isDisplayed());
    }

    @Then("user closes regular payment option and fill in the details")
    public void userClosesRegularPaymentOptionAndFillInTheDetails (){
        logStep("user closes regular payment option and fill in the details");
        savingGoalScreen.tabOnCreateGoalScreenSubmitBtn();
        savingGoalScreen.tabOnRecurringPaymentsBtn();
        savingGoalScreen.tabOnAmountBtn();
        savingGoalScreen.RecurringPaymentsAmount("50");
        savingGoalScreen.tabOnSubmitBtn();
        savingGoalScreen.tabOnConfirmModalCloseBtn();
        savingGoalScreen.assertElementIsDisplayed(savingGoalScreen.GoalsPage,"Goals Page");

    }

    @Then("tha amount will be add to the saving goal")
    public void thaAmountWillBeAddToTheSavingPot () {
        ScreenBase.ThreadSleep(4000);
        Assert.assertEquals(Integer.parseInt(savingGoalScreen.SavingsGoalsAvailableBalanceAmount.getText()),goalAvailableBalance);
    }

    @When("user added {string} to there goal")
    public void userAddedToThereGoal (String moneyAmount){
        savingGoalScreen.tabOnAddMoneyBtn();
        savingGoalScreen.tabOnAmountBtn();
        savingGoalScreen.RecurringPaymentsAmount(moneyAmount);
        savingGoalScreen.tabOnSubmitBtn();
        try {
            savingGoalScreen.tabOnConfirmSkipBtn();
        } catch (NoSuchElementException ignored) {
        }
        goalAvailableBalance += Integer.parseInt(moneyAmount);
    }

    @Then("tha amount will be deducted from the saving pot")
    public void thaAmountWillBeDeductedFromTheSavingPot () {
        savingGoalScreen.tabOnYouHaveWithdrawnMsg();
        ScreenBase.ThreadSleep(2500);
        Assert.assertEquals(Integer.parseInt(savingGoalScreen.SavingsGoalsAvailableBalanceAmount.getText()),goalAvailableBalance);
    }

    @And("user withdraw {string} from there goal")
    public void userAddedFromThereGoal (String withdrawAmount) {
        logStep("user withdraw amount from there goal");
        ScreenBase.ThreadSleep(4500);
        goalAvailableBalance = Integer.parseInt(savingGoalScreen.SavingsGoalsAvailableBalanceAmount.getText());
        savingGoalScreen.tabOnWithdrawBtn();
        savingGoalScreen.tabOnPaymentAmountInputBtn();
        savingGoalScreen.RecurringPaymentsAmount(withdrawAmount);
        savingGoalScreen.tabOnConfirmWithdrawBtn();
        goalAvailableBalance -= Integer.parseInt(withdrawAmount);
    }

    @And("user enters one of the goals")
    public void userEntersOneOfTheGoals () {
        logStep("user enters one of the goals");
        if(numberOfCreatedGoals.get()==0){
            savingGoalScreen.tabOnCreateGoalBtn();
            savingGoalScreen.userEnterGoalDetails("goal1","5000","6 Months");
            savingGoalScreen.tabOnCreateGoalScreenSubmitBtn();
            savingGoalScreen.tabOnNotNowBtn();
//            numberOfCreatedGoals.set(savingGoalScreen.createdGoalsList.size());
//            savingGoalScreen.waitUntilElementAppear(savingGoalScreen.createdGoalsList.get(0),10);
//            Assert.assertEquals(savingGoalScreen.createdGoalsList.size(),(numberOfCreatedGoals.get() + 1));
        }
        savingGoalScreen.tabOnAnyOfTheFourthGoals(0);
        ScreenBase.ThreadSleep(4500);
        goalAvailableBalance = Integer.parseInt(savingGoalScreen.SavingsGoalsAvailableBalanceAmount.getText());
    }
}
