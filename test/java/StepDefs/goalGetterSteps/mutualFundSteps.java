package StepDefs.goalGetterSteps;

import Screens.goalGetterScreens.GoalGetterScreen;
import Screens.goalGetterScreens.ProductsScreen;
import Screens.goalGetterScreens.SuitabilityScreen;
import Screens.homeScreen.HomepageScreen;
import TestBases.TestBase;
import io.cucumber.java.en.Then;

import static TestBases.DriverManager.getAppiumDriver;


public class mutualFundSteps extends TestBase {
    HomepageScreen homepageScreen;
    GoalGetterScreen goalGetterScreen;
    ProductsScreen productsScreen;
    SuitabilityScreen suitabilityScreen;

    @Then("User selects Mutual Fund product and Navigates to suitability Questions screen")
    public void userSelectsMutualFuncProduct() {
        logStep("User selects Mutual Fund product and Navigates to suitability Questions screen");
        homepageScreen = new HomepageScreen(getAppiumDriver());
        homepageScreen.clickOngoalGetterTab();
        goalGetterScreen = new GoalGetterScreen(getAppiumDriver());
        goalGetterScreen.clickOnExploreProductBtn();
        productsScreen = new ProductsScreen(getAppiumDriver());
        productsScreen.clickOnMutualFundIcon();
        productsScreen.clickOnMutualFundStartBtn();
    }

    @Then("User fill and submit all the questions with {string} mobile number and {string} Investment value and {string} passport number")
    public void userFillAndSubmitAllTheQuestion(String mobileNumber, String investmentValue,String passportNumber){
        logStep("User fill and submit all the questions in suitability Questions screen");
        suitabilityScreen = new SuitabilityScreen(getAppiumDriver());
        suitabilityScreen.clickOnQuestionOne();
        suitabilityScreen.selectQuestionList("Short term (less than 1 year)");
        suitabilityScreen.clickOnSelectBtn();
        suitabilityScreen.clickOnQuestionTwo();
        suitabilityScreen.selectQuestionList("Yes");
        suitabilityScreen.clickOnSelectBtn();
        suitabilityScreen.clickOnQuestionThree();
        suitabilityScreen.selectQuestionList(" Extensive");
        suitabilityScreen.clickOnSelectBtn();
        suitabilityScreen.clickOnQuestionFour();
        suitabilityScreen.selectQuestionList("Achieve Income");
        suitabilityScreen.clickOnSelectBtn();
        suitabilityScreen.clickOnQuestionFive();
        suitabilityScreen.selectQuestionList("Yes");
        suitabilityScreen.clickOnSelectBtn();
        suitabilityScreen.clickOnQuestionSix();
        suitabilityScreen.selectQuestionList("Less than 1 year");
        suitabilityScreen.clickOnSelectBtn();
//        suitabilityScreen.clickOnQuestionSeven();
//        suitabilityScreen.selectQuestionList("25,001 - 100,000");
//        suitabilityScreen.clickOnSelectBtn();
//        suitabilityScreen.clickOnQuestionEight(mobileNumber);
//        suitabilityScreen.clickOnQuestionNine();
//        suitabilityScreen.selectQuestionList("25,000 or less");
//        suitabilityScreen.clickOnSelectBtn();
//        suitabilityScreen.clickOnQuestionTen(investmentValue);
//        suitabilityScreen.clickOnQuestionEleven();
//        suitabilityScreen.selectQuestionList("Yes");
//        suitabilityScreen.clickOnSelectBtn();
//        suitabilityScreen.clickOnQuestionTwelve();
//        suitabilityScreen.selectQuestionList("Yes");
//        suitabilityScreen.clickOnSelectBtn();
//        suitabilityScreen.clickOnQuestionThirteen();
//        suitabilityScreen.selectQuestionList("Yes");
//        suitabilityScreen.clickOnSelectBtn();
//        suitabilityScreen.clickOnQuestionFourteen();
//        suitabilityScreen.selectQuestionList("0% - 25%");
//        suitabilityScreen.clickOnSelectBtn();
//        suitabilityScreen.clickOnQuestionFifteen();
//        suitabilityScreen.selectQuestionList("Shares");
//        suitabilityScreen.clickOnSelectBtn();
//        suitabilityScreen.clickOnQuestionSixteen();
//        suitabilityScreen.selectQuestionList("3");
//        suitabilityScreen.clickOnSelectBtn();
//        suitabilityScreen.clickOnQuestionSeventeen();
//        suitabilityScreen.selectQuestionList("2");
//        suitabilityScreen.clickOnSelectBtn();
//        suitabilityScreen.clickOnQuestionEighteen();
//        suitabilityScreen.selectQuestionList("0% - 25%");
//        suitabilityScreen.clickOnSelectBtn();
//        suitabilityScreen.clickOnQuestionNineteen(passportNumber);
//        suitabilityScreen.clickOnQuestionTwenty();
//        suitabilityScreen.selectQuestionList("Intermediate");
//        suitabilityScreen.clickOnSelectBtn();
//        suitabilityScreen.clickOnQuestionTwentyOne();
//        suitabilityScreen.selectQuestionList("Medium");
//        suitabilityScreen.clickOnSelectBtn();
//        suitabilityScreen.clickOnQuestionTwentyTwo();
//        suitabilityScreen.selectQuestionList("Married");
//        suitabilityScreen.clickOnSelectBtn();
//        suitabilityScreen.clickOnConfirmBtn();
    }


}
