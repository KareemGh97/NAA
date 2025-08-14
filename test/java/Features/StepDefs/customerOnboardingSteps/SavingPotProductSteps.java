package StepDefs.customerOnboardingSteps;

import Screens.goalGetterScreens.SavingPotProductScreen;
import Screens.homeScreen.HomepageScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static TestBases.DriverManager.getAppiumDriver;

import static TestBases.TestBase.logStep;
import static Utilities.commonClasses.Helper.generateUniqueRandomIntegerCharacter;

public class SavingPotProductSteps {

    HomepageScreen homepageScreen;
    SavingPotProductScreen savingPotProductScreen = new SavingPotProductScreen(getAppiumDriver());
    static ThreadLocal<Integer> numberOfCreatedSavingPot = new ThreadLocal<>();
    static ThreadLocal<String> savingPotName = new ThreadLocal<>();
    static ThreadLocal<Double> savingPotCurrentAmount = new ThreadLocal<>();
    static ThreadLocal<Integer> addedWithdrewMoney = new ThreadLocal<>();

    // -------

    public void createSavingPort() {

        savingPotProductScreen.assertElementIsDisplayed(savingPotProductScreen.continueSubmitBtn,"continueSubmitButton");

        savingPotName.set("Rahaf " + generateUniqueRandomIntegerCharacter(3));//set a random pot name

        savingPotProductScreen.typingTextInGoalName(savingPotName.get());//pass the name to the text filed
        savingPotProductScreen.pressEnter();

        savingPotProductScreen.tapOnContinueSubmitBtn();// press Continue

        numberOfCreatedSavingPot.set(numberOfCreatedSavingPot.get() + 1);// update the number of pots

    }

    // -------

    @Then("user goes to saving pots page from the shortcut")
    public void userGoesToSavingPotsPageFromTheShortcut() {
        logStep("user goes to saving pots page from the shortcut");
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.clickOnQuickActionByText("Saving");
        savingPotProductScreen.assertElementIsDisplayed(savingPotProductScreen.savingPotScreen,"savingPotScreen");
        numberOfCreatedSavingPot.set(savingPotProductScreen.getListSize(savingPotProductScreen.savingPotList));
    }

    @When("user create a new saving pot")
    public void userCreateANewSavingPot() {
        logStep("user create a new saving pot");

        int createdSavingPots = numberOfCreatedSavingPot.get();// get the number of goals

        switch (createdSavingPots) {
            case 0 -> savingPotProductScreen.tapOnFirstAddNewSavingPotBtn(); // No saving pots created yet, tap the first add button
            case 4 -> {
                enterAnExistingSavingPot(); // enter any saving pot
                closeTheSavingPot();  // Call the method to close the saving pot
                savingPotProductScreen.tapOnAddNewSavingPotBtn();
            }
            default -> savingPotProductScreen.tapOnAddNewSavingPotBtn();
        }

        createSavingPort(); //method to create a saving pot as it is comment for all TCs
    }

    @And("verify that saving pot is created")
    public void verifyThatSavingPotIsCreated() {
        logStep("verify that saving pot is created");
        Assert.assertTrue(savingPotProductScreen.isSavingPotCreated(savingPotName.get()), "saving pot did not get created");

        savingPotName.remove();
        numberOfCreatedSavingPot.remove();
    }

    @And("enter an existing saving pot")
    public void enterAnExistingSavingPot() {
        logStep("enter an existing saving pot");

        if (numberOfCreatedSavingPot.get() == 0) { // no saving pot in the account
            savingPotProductScreen.tapOnFirstAddNewSavingPotBtn();
            createSavingPort();
        } else {
            savingPotName.set(savingPotProductScreen.savingPotList.get(0).getText());
        }

        savingPotProductScreen.tapOnSpecificSavingPotList(savingPotName.get());
    }

    @Then("add money to saving pot product")
    public void addMoneyToSavingPotProduct() {
        logStep("add money to saving pot product");
        savingPotCurrentAmount.set(
                savingPotProductScreen.currencyAmountFromString(
                        savingPotProductScreen.availableBalanceAmountTxt.getText()));// saves the pot current balance

        savingPotProductScreen.tapOnAddMoneyBtn();
        addedWithdrewMoney.set(Integer.valueOf(generateUniqueRandomIntegerCharacter(3)));// saves the added amount

        savingPotProductScreen.tapOnCurrencyInput();
        savingPotProductScreen.pressNativeNumberPad(addedWithdrewMoney.get().toString());

        savingPotProductScreen.tapOnContinueSubmitBtn();// press Continue

        if (savingPotProductScreen.isDisplayed(savingPotProductScreen.skipBtn)) {
            savingPotProductScreen.tapOnSkipBtn();
        }

    }

    @And("verify the amount added is correct")
    public void verifyTheAmountAddedIsCorrect() {
        logStep("verify the amount added is correct");
        double actual = savingPotProductScreen.currencyAmountFromString(savingPotProductScreen.availableBalanceAmountTxt.getText());
        double expected = (savingPotCurrentAmount.get() + addedWithdrewMoney.get());

        Assert.assertEquals(actual, expected, 0.01, "the current amount of the saving pot does not add up after adding the money");

        savingPotCurrentAmount.remove();
        addedWithdrewMoney.remove();
        savingPotName.remove();
        numberOfCreatedSavingPot.remove();
    }

    @Then("user withdraw money from the saving pot")
    public void userWithdrawMoneyFromTheSavingPot()  {
        logStep("user withdraw money from the saving pot");

        savingPotCurrentAmount.set(savingPotProductScreen.currencyAmountFromString(savingPotProductScreen.availableBalanceAmountTxt.getText()));

        if (savingPotCurrentAmount.get() < 100) {
            addMoneyToSavingPotProduct();
            savingPotCurrentAmount.remove();
            savingPotCurrentAmount.set(savingPotProductScreen.currencyAmountFromString(savingPotProductScreen.availableBalanceAmountTxt.getText()));
        }

        savingPotProductScreen.tapOnWithdrawBtn();

        int maxAmount = savingPotCurrentAmount.get().intValue();
        Assert.assertTrue(maxAmount>0,"saving pot amount is 0 and can not be withdrawn from due to adding the money failed");
        int withdrawAmount = Integer.parseInt(generateUniqueRandomIntegerCharacter(1, maxAmount));

        addedWithdrewMoney.set(withdrawAmount);// saves the amount

        savingPotProductScreen.tapOnWithdrawCurrencyInput();
        savingPotProductScreen.pressNativeNumberPad(addedWithdrewMoney.get().toString());

        savingPotProductScreen.tapOnWithdrawSubmitBtn();// press Continue to Withdraw

        savingPotProductScreen.tapOnExitPopup();// close the Withdrew popup

    }

    @And("verify the amount withdrew is correct")
    public void verifyTheAmountWithdrewIsCorrect() {
        logStep("verify the amount withdrew is correct");

        double actual = savingPotProductScreen.currencyAmountFromString(savingPotProductScreen.availableBalanceAmountTxt.getText());
        double expected = (savingPotCurrentAmount.get() - addedWithdrewMoney.get());

        Assert.assertEquals(actual, expected, 0.01, "the current amount of the saving pot does not add up after deducting the money");

        savingPotCurrentAmount.remove();
        addedWithdrewMoney.remove();
        savingPotName.remove();
        numberOfCreatedSavingPot.remove();

    }

    @Then("edit the saving pot")
    public void editTheSavingPot() {
        logStep("edit the saving pot");

        savingPotProductScreen.tapOnEditPotBtn(); // edit the pot
        savingPotName.set("Edit Rahaf " + generateUniqueRandomIntegerCharacter(4));//set a random new name

        savingPotProductScreen.typingTextInEditGoalNameTxt(savingPotName.get());
        savingPotProductScreen.pressEnter();

        Assert.assertTrue(savingPotProductScreen.saveBtn.isEnabled(), "save button is disabled after changing the name");

        savingPotProductScreen.tapOnSaveBtn();

    }

    @And("verify that the saving pot is edited correctly")
    public void verifyThatTheSavingPotIsEditedCorrectly() {
        logStep("verify that the saving pot is edited correctly");

        savingPotProductScreen.tapOnBackBtn();

        for (WebElement element : savingPotProductScreen.savingPotList) {
            if (element.getText().equals(savingPotName.get())) {
                return;
            }
        }

        Assert.fail("saving pot name did not match new change");
    }

    @Then("close the saving pot")
    public void closeTheSavingPot() {
        logStep("close the saving pot");
        savingPotProductScreen.tapOnEditPotBtn(); // edit the pot
        savingPotProductScreen.tapOnClosePotBtn(); // close pot
        savingPotProductScreen.tapOnContinueConfirmBtn();// press Continue
    }

    @And("verify that the saving pot is closed")
    public void verifyThatTheSavingPotIsClosed() {
        logStep("verify that the saving pot is closed");
        savingPotProductScreen.assertElementIsDisplayed(savingPotProductScreen.savingPotScreen,"savingPotScreen");
        Assert.assertEquals((savingPotProductScreen.getListSize(savingPotProductScreen.savingPotList)), (numberOfCreatedSavingPot.get() - 1), "saving pot is not closed");
    }
}
