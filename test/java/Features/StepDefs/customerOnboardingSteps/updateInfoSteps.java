package StepDefs.customerOnboardingSteps;

import Screens.customerOnBoardingScreens.*;
import TestBases.TestBase;
import Utilities.commonClasses.AppConstants;
import io.cucumber.java.en.And;
import org.testng.Assert;

import static TestBases.DriverManager.getAppiumDriver;


public class updateInfoSteps extends TestBase {
    UpdateInfoScreen updateInfoScreen = new UpdateInfoScreen(getAppiumDriver());

    @And("User Press on Financial Information Edit Button")
    public void userPressOnFinancialInformationEditButton() {
        logStep("User Press on Financial Information Edit Button");
        updateInfoScreen.clickOnProfileBtn();
        updateInfoScreen.clickOnFinancialInformationBtn();
        updateInfoScreen.clickOnFinancialInformationEditBtn();

    }

    @And("User updates the Financial Information")
    public void userUpdatesTheFinancialInformation() {
        logStep("User updates the Financial Information");
        updateInfoScreen.clickOnSelectMainIncomeType();
        updateInfoScreen.selectQuestionData("Salary");
        updateInfoScreen.clickOnSetDataBtn();
        updateInfoScreen.clickOnSelectMainIncomeAmount();
        updateInfoScreen.selectQuestionData("From 3001 to 6000");
        updateInfoScreen.clickOnSetDataBtn();
        updateInfoScreen.clickOnSelectMonthlyCreditDebitAmount();
        updateInfoScreen.selectQuestionData("2,501 - 5,000");
        updateInfoScreen.clickOnSetDataBtn();
        updateInfoScreen.clickOnIncomeDetailsUpdateBtn();
    }

    @And("User updates the occupational information")
    public void userUpdatesTheOccupationalInformation() {
        logStep("User updates the occupational information");
        updateInfoScreen.clickOnSelectProfession();
        updateInfoScreen.selectQuestionData("Not Employee");
        updateInfoScreen.clickOnSetDataBtn();
        updateInfoScreen.clickOnOccupationalInfoUpdateBtn();
    }

    @And("User updates the PEP Flag and Save the updates")
    public void userUpdatesThePEPFlag() {
        logStep("User updates the PEP Flag and Save the updates");
        updateInfoScreen.clickOnPepFlagDoneBtn();
    }

    @And("Verify That Financial Information are updated successfully")
    public void verifyThatFinancialInformationAreUpdatedSuccessfully() {
        logStep("Verify That Financial Information are updated successfully");
        if(platformName.equalsIgnoreCase("iOS")) {
            Assert.assertTrue(updateInfoScreen.mainSourceIncomeValue.getAttribute("value").equalsIgnoreCase("Salary"));
            Assert.assertTrue(updateInfoScreen.mainSourceIncomeAmountValue.getAttribute("value").equalsIgnoreCase("From 3001 to 6000"));
            Assert.assertTrue(updateInfoScreen.monthlyExpensesValue.getAttribute("value").equalsIgnoreCase("2,501 - 5,000"));
            Assert.assertTrue(updateInfoScreen.professionValue.getAttribute("value").equalsIgnoreCase("Not Employee"));
            Assert.assertTrue(updateInfoScreen.pepFlagValue.getAttribute("value").equalsIgnoreCase("No"));
        }
        else {
            Assert.assertTrue(updateInfoScreen.mainSourceIncomeValue.getText().equalsIgnoreCase("Salary"));
            Assert.assertTrue(updateInfoScreen.mainSourceIncomeAmountValue.getText().equalsIgnoreCase("From 3001 to 6000"));
            Assert.assertTrue(updateInfoScreen.monthlyExpensesValue.getText().equalsIgnoreCase("2,501 - 5,000"));
            Assert.assertTrue(updateInfoScreen.professionValue.getText().equalsIgnoreCase("Not Employee"));
//        updateInfoScreen.verticalScroll(updateInfoScreen.fullScreenContainer, 0.9, 0.1);
            Assert.assertTrue(updateInfoScreen.pepFlagValue.getText().equalsIgnoreCase("No"));
        }
    }

    @And("User updates the Financial Information with additional income")
    public void userUpdatesTheFinancialInformationWithAdditionalIncome() {
        logStep("User updates the Financial Information with additional income");
        updateInfoScreen.clickOnSelectMainIncomeType();
        updateInfoScreen.selectQuestionData("Salary");
        updateInfoScreen.clickOnSetDataBtn();
        updateInfoScreen.clickOnSelectMainIncomeAmount();
        updateInfoScreen.selectQuestionData("From 3001 to 6000");
        updateInfoScreen.clickOnSetDataBtn();
        updateInfoScreen.clickOnSelectMonthlyCreditDebitAmount();
        updateInfoScreen.selectQuestionData("2,501 - 5,000");
        updateInfoScreen.clickOnSetDataBtn();
        updateInfoScreen.clickOnAdditionalIncomeRadioBtn();
        updateInfoScreen.clickOnSelectAdditionalIncomeType();
        updateInfoScreen.selectQuestionData("Rent");
        updateInfoScreen.clickOnSetDataBtn();
        updateInfoScreen.clickOnSelectAdditionalIncomeAmount();
        updateInfoScreen.selectQuestionData("2,501 - 5,000");
        updateInfoScreen.clickOnSetDataBtn();
        updateInfoScreen.clickOnIncomeDetailsUpdateBtn();
    }

    @And("User Press on National Address Information Edit Button")
    public void userPressOnNationalAddressInformationEditButton() {
        logStep("User Press on National Address Information Edit Button");
        updateInfoScreen.clickOnProfileBtn();
        updateInfoScreen.clickOnProfileDetailsBtn();
        updateInfoScreen.clickOnNationalAddressInformationEditBtn();

    }

    @And("Verify that address information is disabled")
    public void verifyThatAddressInformationIsDisabled() {
        logStep("Verify that address information is disabled");
        Assert.assertFalse(updateInfoScreen.countryDropdownInput.isEnabled());
        Assert.assertFalse(updateInfoScreen.districtEditText.isEnabled());
    }

    @And("User updates the national address information")
    public void UserUpdatesTheNationalAddressInformation() {
        updateInfoScreen.clickOnUpdateBtn();
        AppConstants.Country = updateInfoScreen.getFieldsText(updateInfoScreen.countryDropdownInput);
        AppConstants.City = updateInfoScreen.getFieldsText(updateInfoScreen.cityEditText);
        AppConstants.District = updateInfoScreen.getFieldsText(updateInfoScreen.districtEditText);
        Assert.assertNotNull(AppConstants.Country);
        Assert.assertNotNull(AppConstants.District);
        Assert.assertNotNull(AppConstants.City );
        updateInfoScreen.clickOnSaveBtn();
//        Assert.assertTrue(updateInfoScreen.isDisplayed(updateInfoScreen.someThingHasGoneWrongMessage),"Sorry, something has gone wrong");
    }

    @And("User disables the additional income then saves the changes")
    public void UserDisablesTheAdditionalIncomeThenSavesTheChanges() {
        updateInfoScreen.clickOnFinancialInformationEditBtn();
//        updateInfoScreen.clickOnSelectMainIncomeType();
//        updateInfoScreen.selectQuestionData("Salary");
//        updateInfoScreen.clickOnSetDataBtn();
//        updateInfoScreen.clickOnSelectMainIncomeAmount();
//        updateInfoScreen.selectQuestionData("From 3001 to 6000");
//        updateInfoScreen.clickOnSetDataBtn();
//        updateInfoScreen.clickOnSelectMonthlyCreditDebitAmount();
//        updateInfoScreen.selectQuestionData("2,501 - 5,000");
//        updateInfoScreen.clickOnSetDataBtn();
        updateInfoScreen.clickOnAdditionalIncomeRadioBtn();
        updateInfoScreen.clickOnIncomeDetailsUpdateBtn();
        updateInfoScreen.clickOnOccupationalInfoUpdateBtn();
        updateInfoScreen.clickOnPepFlagDoneBtn();
    }

}
