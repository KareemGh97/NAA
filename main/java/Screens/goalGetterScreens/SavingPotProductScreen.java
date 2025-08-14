package Screens.goalGetterScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SavingPotProductScreen extends ScreenBase {
    public SavingPotProductScreen (AppiumDriver appiumDriver){
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*SavingsGoals.SavingsGoalsScreen:NavHeader-BackButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*SavingsGoals.SavingsGoalsScreen:NavHeader-BackButton.*'")
    public WebElement savingPotScreen;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add new saving pot\")")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Add new saving pot'`]")
    public WebElement firstAddNewSavingPotBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*SavingsGoals.SavingsGoalsScreen:AddGoalButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*SavingsGoals.SavingsGoalsScreen:AddGoalButton.*'")
    public WebElement addNewSavingPotBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"^.*SavingsGoals.SavingsGoalsScreen:GoalCard.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'SavingsGoals.SavingsGoalsScreen:GoalCard'")
    public List<WebElement> savingPotList;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"^.*SavingsGoals.CreateGoalScreen:GoalNameInput*$\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'SavingsGoals.CreateGoalScreen:GoalNameInput'")
    public WebElement GoalNameInputTxt;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*SubmitButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*SubmitButton.*'")
    public WebElement continueSubmitBtn;

    // ----- pot details screen -----

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*AvailableBalanceAmount-IntegerPart.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*AvailableBalanceAmount-IntegerPart.*'")
    public WebElement availableBalanceAmountTxt;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*AddMoneyButton-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*AddMoneyButton-Pressable.*'")
    public WebElement addMoneyBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*WithdrawButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*WithdrawButton.*'")
    public WebElement withdrawBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*CurrencyInput-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*CurrencyInput-Pressable.*'")
    public WebElement currencyInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*PaymentAmountInput-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*PaymentAmountInput-Pressable.*'")
    public WebElement withdrawCurrencyInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*WithdrawButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*WithdrawButton.*'")
    public WebElement withdrawSubmitBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*SavingsGoals.GoalDetailsScreen:WithdrawConfirmationModal-ParentModal-CloseButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*SavingsGoals.GoalDetailsScreen:WithdrawConfirmationModal-ParentModal-CloseButton.*'")
    public WebElement exitPopup;
//    SavingsGoals.GoalDetailsScreen:WithdrawConfirmationModal-ParentModal-CloseButton

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*ConfirmSkipButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*ConfirmSkipButton.*'")
    public WebElement skipBtn;


    // ----- pot edit screen -----

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*GoalDetailsScreen:NavHeader-IconButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*GoalDetailsScreen:NavHeader-IconButton.*'")
    public WebElement editPotBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*EditGoalModal:CloseButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*EditGoalModal:CloseButton.*'")
    public WebElement closePotBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*ConfirmButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*ConfirmButton.*'")
    public WebElement continueConfirmBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*SavingsGoals.EditGoalModal:GoalNameInput.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*SavingsGoals.EditGoalModal:GoalNameInput-Pressable.*'")
    public WebElement editGoalNameTxt;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"SavingsGoals.EditGoalModal:GoalNameInput\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*SavingsGoals.EditGoalModal:GoalNameInput-Pressable.*'")
    public WebElement editGoalNameField;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*SaveButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*SaveButton.*'")
    public WebElement saveBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*BackButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*BackButton.*'")
    public WebElement backBtn;

    public void tapOnFirstAddNewSavingPotBtn (){
        tapOn(firstAddNewSavingPotBtn);
    }

    public void tapOnAddNewSavingPotBtn (){
        tapOn(addNewSavingPotBtn);
    }

    public void typingTextInGoalName (String name){
        typingTextIn(GoalNameInputTxt,name);
    }

    public void tapOnContinueSubmitBtn (){
        tapOn(continueSubmitBtn);
    }

    public boolean isSavingPotCreated(String goalName){
        for (WebElement element : savingPotList) {
            if(element.getText().contains(goalName)) {
                return true;
            }
        }
        return false;
    }

    public void tapOnSpecificSavingPotList (String goalName){
        for (WebElement element : savingPotList) {
            if(element.getText().contains(goalName)) {
                tapOn(element);
                break;
            }
        }
    }

    // ----- pot details screen -----

    public void tapOnAddMoneyBtn (){
        tapOn(addMoneyBtn);
    }
    public void tapOnWithdrawBtn (){
        tapOn(withdrawBtn);
    }
    public void tapOnCurrencyInput (){
        tapOn(currencyInput);
    }
    public void tapOnWithdrawCurrencyInput (){
        tapOn(withdrawCurrencyInput);
    }
    public void tapOnWithdrawSubmitBtn (){
        tapOn(withdrawSubmitBtn);
    }
    public void tapOnExitPopup ()  {
        tapOn(exitPopup);
    }
    public void tapOnSkipBtn (){
        tapOn(skipBtn);
    }

    // ----- pot edit screen -----

    public void tapOnEditPotBtn (){
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        tapOn(editPotBtn);
    }
    public void tapOnClosePotBtn (){
        tapOn(closePotBtn);
    }
    public void tapOnContinueConfirmBtn (){
        tapOn(continueConfirmBtn);
    }

    public void typingTextInEditGoalNameTxt (String name){
        tapOn(editGoalNameTxt);
        clearTextFrom(editGoalNameField);
        typingTextIn(editGoalNameField,name);
    }
    public void tapOnSaveBtn (){
        tapOn(saveBtn);
    }
    public void tapOnBackBtn (){
        tapOn(backBtn);
    }
}
