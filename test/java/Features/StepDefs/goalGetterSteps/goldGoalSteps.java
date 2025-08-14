package StepDefs.goalGetterSteps;

import Screens.goalGetterScreens.GoalGetterScreen;
import Screens.goalGetterScreens.GoalsScreen;
import Screens.goalGetterScreens.GoldScreen;
import Screens.goalGetterScreens.ProductsScreen;
import Screens.homeScreen.HomepageScreen;
import Screens.homeScreen.OTPScreen;
import TestBases.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static TestBases.DriverManager.getAppiumDriver;


public class goldGoalSteps extends TestBase {
    HomepageScreen homepageScreen = new HomepageScreen(getAppiumDriver());
    ProductsScreen productsScreen = new ProductsScreen(getAppiumDriver());
    GoldScreen goldScreen = new GoldScreen(getAppiumDriver());
    OTPScreen otpScreen = new OTPScreen(getAppiumDriver());
    GoalsScreen goalsScreen = new GoalsScreen(getAppiumDriver());
    GoalGetterScreen goalGetterScreen = new GoalGetterScreen(getAppiumDriver());


    @Then("User selects gold product and Navigates to the Buy or Sell gold screen")
    public void userSelectsGoldWalletProduct() {
        logStep("User selects gold product and Navigates to the Buy/Sell gold screen");
        homepageScreen.clickOngoalGetterTab();
        goalsScreen.clickOnProductsBtn();
        productsScreen.clickOnGoldIcon();
    }

    @Then("New User selects gold wallet product")
    public void newUserSelectsGoldWalletProduct() {
        logStep("New User selects gold wallet product");
        homepageScreen.clickOngoalGetterTab();
        goalGetterScreen.clickOnExploreProductBtn();
        productsScreen.clickOnGoldIcon();
    }

    @And("User navigates to buy gold screen and orders the gold grams")
    public void userNavigatesToBuyGoldScreen() {
        logStep("User navigates to buy gold screen and orders the gold grams");
        goldScreen.clickOnBuyGoldBtn();
        if (platformName.equalsIgnoreCase("iOS")) {
            goldScreen.selectGoldGramsIOS("5g");
        } else {
            goldScreen.selectGoldGramsAndroid("5g");
        }
        goldScreen.clickOnBuyGoldContinueBtn();
        goldScreen.clickOnOrderSummaryContinueBtn();
        if (platformName.equalsIgnoreCase("iOS")) {
            goldScreen.clickOnOTPFirstNumber();
        }
        otpScreen.waitUntilElementAppear(otpScreen.otpEt.get(0), 50);
        Assert.assertFalse(otpScreen.otpEt.isEmpty());
        otpScreen.userEnterOtp("0000");
        Assert.assertTrue(goldScreen.isSuccessMessageAppeared());
    }


    @And("User accepts buy or sell gold terms and conditions then press on confirm button")
    public void userAcceptsBuyOrSellGoldTermsAndConditionsThenPressOnConfirmButton() {
        logStep("User accepts buy or sell gold terms and conditions then press on confirm button");
        goldScreen.clickOnTermsAndConditionsCheckBox();
        goldScreen.clickOnConfirmBtn();
    }

    @And("User view gold transactions")
    public void userViewGoldTransactions() {
        logStep("User view gold transactions");
        goldScreen.clickOnViewTransactionsBtn();
        Assert.assertEquals(goldScreen.getTransactionCardStatus(), "Confirmed");
        System.out.println("Gold transaction Text is " + goldScreen.getTransactionCardStatus());
    }

}
