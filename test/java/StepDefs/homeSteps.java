package StepDefs;

import Screens.homeScreen.CurrentAccountScreen;
import Screens.homeScreen.HomepageScreen;
import Screens.settingScreen.SettingsScreen;
import TestBases.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static TestBases.DriverManager.getAppiumDriver;


public class homeSteps extends TestBase {
    HomepageScreen homepageScreen;
    CurrentAccountScreen currentAccountScreen;
    SettingsScreen settingsScreen;

    @When("user click on click on navigate to Account button")
    public void userClickOnTheLeftSideHeaderButton()  {
        logStep("user click on the left-side header button");
        homepageScreen=new HomepageScreen(getAppiumDriver());
        Screens.homeScreen.ScreenBase.ThreadSleep(6000);
        homepageScreen.waitUntilElementAppear(homepageScreen.CopyNumberBtn,20);
        homepageScreen.assertElementIsDisplayed(homepageScreen.CopyNumberBtn,"CopyNumberButton");
        homepageScreen.clickOnNavigateToAccountBtn();
    }

    @Then("user can access the customer account management")
    public void userCanAccessTheCustomerAccountManagement (){
        logStep("user can access the customer account management");
        currentAccountScreen = new CurrentAccountScreen(getAppiumDriver());
        currentAccountScreen.assertElementIsDisplayed(currentAccountScreen.IBANBtn,"IBANButton");
        currentAccountScreen.assertElementIsDisplayed(currentAccountScreen.AccountNumBtn,"AccountNumButton");
    }

    @Then("user can view the default shortcut")
    public void userCanViewTheDefaultShortcut (){
        logStep("the user can view the default shortcut");

    }

    @And("click on the edit icon will appear the shortcut overlay")
    public void clickOnTheEditIconWillAppearTheShortcutOverlay (){
        logStep("click on the edit icon will appear the shortcut overlay");
    }

    @And("the customer has pending actions")
    public void theCustomerHasPendingActions (){
        logStep("the customer has pending actions");
        homepageScreen=new HomepageScreen(getAppiumDriver());
        homepageScreen.assertElementIsDisplayed(homepageScreen.BulletinBoardSection,"BulletinBoardSection");
    }

    @When("the customer clicks on View Tasks")
    public void theCustomerClicksOnViewTasks(){
        logStep("the customer clicks on View Tasks");
        homepageScreen.clickOnViewTasksBtn();

    }

    @Then("each pending action shall include the following details: Title AND Description")
    public void eachPendingActionShallIncludeTheFollowingDetailsTitleANDDescription (){
        logStep("each pending action shall include the following details: Title AND Description");
        if(!(homepageScreen.AddMoneyTaskTitle.isDisplayed() & homepageScreen.AddMoneyTaskDes.isDisplayed() & homepageScreen.ActivateCardTaskTitle.isDisplayed() & homepageScreen.ActivateCardTaskDes.isDisplayed() & homepageScreen.lifestyleTaskTitle.isDisplayed() & homepageScreen.lifestyleTaskDes.isDisplayed())) {
            Assert.fail();
        }
    }

    @And("the selected pending action shall display a navigation CTA")
    public void theSelectedPendingActionShallDisplayANavigationCTA (){
        logStep("the selected pending action shall display a navigation CTA");
        Assert.assertEquals(homepageScreen.TaskActionButton.size(),4);
    }

    @And("the customer go to customization Home Section")
    public void theCustomerGoToCustomizationHomeSection() {
        logStep("and user UnRegister Device");
        homepageScreen=new HomepageScreen(getAppiumDriver());
        homepageScreen.clickOnSettingsBtn();
        settingsScreen=new SettingsScreen(getAppiumDriver());
        settingsScreen.TapOncCustomizeHome();

    }

    @And("the customer edit Home Screen")
    public void theCustomerEditHomeScreen() {
        settingsScreen=new SettingsScreen(getAppiumDriver());
//        Assert.assertTrue(settingsScreen.inviteFriend.isDisplayed());
//        settingsScreen.changeHomeOrder();

    }
}
