package StepDefs.travelInsuranceSteps;

import Screens.homeScreen.HomepageScreen;
import Screens.travelInsuranceScreens.*;
import TestBases.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import static TestBases.DriverManager.getAppiumDriver;

public class TravelInsuranceSteps extends TestBase {
    HomepageScreen homepageScreen = new HomepageScreen(getAppiumDriver());
    PoliciesScreen policiesScreen = new PoliciesScreen(getAppiumDriver());
    TravelInsuranceOptionsScreen travelInsuranceOptionsScreen = new TravelInsuranceOptionsScreen(getAppiumDriver());
    TravellerDetailsScreen travellerDetailsScreen = new TravellerDetailsScreen(getAppiumDriver());
    AddTravellerTypeScreen addTravellerTypeScreen = new AddTravellerTypeScreen(getAppiumDriver());
    AddFamilyDetailsScreen addFamilyDetailsScreen = new AddFamilyDetailsScreen(getAppiumDriver());
    TripDetailsScreen tripDetailsScreen = new TripDetailsScreen(getAppiumDriver());
    SelectCategoryScreen selectCategoryScreen = new SelectCategoryScreen(getAppiumDriver());
    AddOptionalPacksScreen addOptionalPacksScreen = new AddOptionalPacksScreen(getAppiumDriver());
    AccountsScreen accountsScreen = new AccountsScreen(getAppiumDriver());
    SummaryScreen summaryScreen = new SummaryScreen(getAppiumDriver());
    TravelInsuranceSuccessScreen travelInsuranceSuccessScreen = new TravelInsuranceSuccessScreen(getAppiumDriver());

    @And("user navigates to Travel Insurance feature")
    public void userNavigatesToTravelInsurance() {
        logStep("And user navigates to Travel Insurance feature");
        try {
            homepageScreen.updateQuickActions();
            homepageScreen.clickOnShortcutElementByText("Saving Pot");
            homepageScreen.clickOnShortcutElementByText("Travel Insurance");
            homepageScreen.clickOnSaveButton();
        } catch (Exception ignored) {
        }
        homepageScreen.clickOnQuickActionByText("Travel Insurance");
    }

    @And("user clicks on + button to add policy")
    public void userClicksOnButtonToAddPolicy() {
        logStep("And user clicks on + button to add policy");
        policiesScreen.clickOnPlusIconBtn();
    }

    @And("user selects Domestic then Apply")
    public void userSelectsDomesticThenApply() {
        logStep("And user selects Domestic then Apply");
        travelInsuranceOptionsScreen.clickOnDomesticTap();
        travelInsuranceOptionsScreen.clickOnApplyBtn();
    }

    @And("user selects to be the main traveler and fill all required fields")
    public void userSelectsToBeTheMainTravelerAndFillAllRequiredFields() {
        logStep("And user selects to be the main traveler and fill all required fields");
        travellerDetailsScreen.clickOnMainTravellerToggleBtn();
        travellerDetailsScreen.clickOnExpiryDateBtn();
        if(platformName.equalsIgnoreCase("ios")) {
            LocalDate currentDate = LocalDate.now();
            String monthName = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
            travellerDetailsScreen.SelectIOSDate(monthName, String.valueOf(currentDate.getDayOfMonth()+1), String.valueOf(currentDate.getYear()));
            travellerDetailsScreen.tapOnCalendarConfirmBtn();
        }else {
            travellerDetailsScreen.selectDate("30");
        }
        travellerDetailsScreen.userEnterPassportNumber("S123456789");
        travellerDetailsScreen.userTabOnTravellerDetailsScreen();
        travellerDetailsScreen.userSelectsYes();
        travellerDetailsScreen.assertElementIsDisplayed(travellerDetailsScreen.addTravellersBtn,"addTravellersButton");
        travellerDetailsScreen.assertElementIsDisplayed(travellerDetailsScreen.nextBtn,"nextButton");
        Assert.assertTrue(travellerDetailsScreen.addTravellersBtn.isEnabled(),"Add Traveller is not enabled");
        Assert.assertTrue(travellerDetailsScreen.nextBtn.isEnabled(),"Next Button is not enabled");
    }

    @And("user clicks on Add Travellers")
    public void userClicksOnAddTravellers() {
        logStep("And user clicks on Add Travellers");
        travellerDetailsScreen.clickOnAddTravellerButton();
        addTravellerTypeScreen.assertElementIsDisplayed(addTravellerTypeScreen.addTravellersTitle,"addTravellersTitle");

    }

    @And("user selects Family type")
    public void userSelectsFamilyType() {
        logStep("And user selects Family type");
        addTravellerTypeScreen.clickOnFamilyButton();
        addTravellerTypeScreen.clickOnAddTypeNextButton();
    }

    @And("user enters all family details")
    public void userEntersAllFamilyDetails() {
        logStep("And user enters all family details");
        addFamilyDetailsScreen.assertElementIsDisplayed(addFamilyDetailsScreen.familyDetailsTitle,"familyDetailsTitle");
        addFamilyDetailsScreen.selectRelation();
        addFamilyDetailsScreen.setNationalID("1234567891");
        addFamilyDetailsScreen.clickOnDateOfBirthBtn();
        if(platformName.equalsIgnoreCase("ios")) {
            addFamilyDetailsScreen.clickOnDateOfBirthStartDate();
            LocalDate currentDate = LocalDate.now();
            String monthName = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
            travellerDetailsScreen.SelectIOSDate(monthName, String.valueOf(currentDate.getDayOfMonth()+1), String.valueOf(currentDate.getYear()));
            travellerDetailsScreen.tapOnAddFamilyDetailsScreenCalendarConfirmBtn();
            addFamilyDetailsScreen.setFamilyPassportNumText("A158742369");
            addFamilyDetailsScreen.userTabOnFamilyMemeberLogo();
            addFamilyDetailsScreen.setAddFamilyEnglishFullNameText("Samar Metwaly");
            addFamilyDetailsScreen.userTabOnFamilyMemeberLogo();


        }else {
            travellerDetailsScreen.selectDate("1");
            addFamilyDetailsScreen.setPassportNumText("A158742369");
            addFamilyDetailsScreen.setEnglishFullNameText("Samar Metwaly");
        }


        addFamilyDetailsScreen.userSelectsYes();
        addFamilyDetailsScreen.clickOnSaveButton();
        addFamilyDetailsScreen.clickOnAddFamilyDetailsNextBtn();
    }

    @And("user enters trip details")
    public void userEntersTripDetails() {
        logStep("And user enters trip details");
        tripDetailsScreen.assertElementIsDisplayed(tripDetailsScreen.tripDetailsTitle,"tripDetailsTitle");
        tripDetailsScreen.clickOnStartDateBtn();
        if(platformName.equalsIgnoreCase("ios")) {
            LocalDate currentDate = LocalDate.now();
            String monthName = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
//            travellerDetailsScreen.SelectIOSDate(monthName, String.valueOf(currentDate.getDayOfMonth()), String.valueOf(currentDate.getYear()));
            travellerDetailsScreen.tapOnCalendarConfirmBtn();
            tripDetailsScreen.clickOnEndDateBtn();
            travellerDetailsScreen.SelectIOSDate(monthName, String.valueOf(currentDate.getDayOfMonth()+5), String.valueOf(currentDate.getYear()));
            travellerDetailsScreen.tapOnCalendarConfirmBtn();
        }else {
            travellerDetailsScreen.selectDate("1");
            tripDetailsScreen.clickOnEndDateBtn();
            travellerDetailsScreen.selectDate("10");
            tripDetailsScreen.clickOnNextButton();        }
    }

    @And("user proceeds to the summary page")
    public void userProceedsToTheSummaryPage() {
        logStep("And user proceeds to the summary page");
        selectCategoryScreen.assertElementIsDisplayed(selectCategoryScreen.selectCategoryTitle,"selectCategoryTitle");
        selectCategoryScreen.clickOnDomesticCheckbox();
        selectCategoryScreen.clickOnSelectCategoryNextBtn();
        addOptionalPacksScreen.assertElementIsDisplayed(addOptionalPacksScreen.addOptionalPacksTitle,"addOptionalPacksTitle");
        addOptionalPacksScreen.clickOnOptionalPacksNextBtn();
        accountsScreen.assertElementIsDisplayed(accountsScreen.accountTitle,"accountTitle");
        accountsScreen.clickOnAccountNextBtn();
    }

    @And("verify all details are existed and clicks on Confirm button")
    public void verifyAllDetailsAreExistedAndClicksOnConfirmButton() {
        logStep("And verify all details are existed and clicks on Confirm button");
        summaryScreen.assertElementIsDisplayed(summaryScreen.summaryTitle,"summaryTitle");
        summaryScreen.assertElementIsDisplayed(summaryScreen.insuranceSubTitle,"insuranceSubTitle");
        summaryScreen.assertElementIsDisplayed(summaryScreen.mainTravellerSubTitle,"mainTravellerSubTitle");
        summaryScreen.assertElementIsDisplayed(summaryScreen.familyTravellerSubTitle,"familyTravellerSubTitle");
        travellerDetailsScreen.Scroll();
        summaryScreen.clickOnConfirmBtn();
    }

    @Then("verify that success message Policy issued successfully appears")
    public void verifyThatSuccessMessagePolicyIssuedSuccessfullyAppears() {
        logStep("And verify that success message Policy issued successfully appears");
        travelInsuranceSuccessScreen.assertElementIsDisplayed(travelInsuranceSuccessScreen.policyIssuedSucc,"policyIssuedSucc");
        travelInsuranceSuccessScreen.assertElementIsDisplayed(travelInsuranceSuccessScreen.detailsSection,"detailsSection");
        travelInsuranceSuccessScreen.assertElementIsDisplayed(travelInsuranceSuccessScreen.totalAmount,"totalAmount");
        travelInsuranceSuccessScreen.assertElementIsDisplayed(travelInsuranceSuccessScreen.cover,"cover");
        travelInsuranceSuccessScreen.assertElementIsDisplayed(travelInsuranceSuccessScreen.destination,"destination");
        travelInsuranceSuccessScreen.clickOnGoToDashboardBtn();
    }

    @And("user selects Outbound then Apply")
    public void userSelectsOutboundThenApply() {
        logStep("And user selects Outbound then Apply");
        travelInsuranceOptionsScreen.clickOnOutboundTap();
        travelInsuranceOptionsScreen.clickOnApplyBtn();
    }

    @And("user selects Student then Apply")
    public void userSelectsStudentThenApply() {
        logStep("And user selects Student then Apply");
        travelInsuranceOptionsScreen.clickOnStudentTap();
        travelInsuranceOptionsScreen.clickOnApplyBtn();
    }

    @And("user proceeds to the summary page for outbound journey")
    public void userProceedsToTheSummaryPageForOutboundJourney() {
        logStep("And user proceeds to the summary page for outbound journey");
        selectCategoryScreen.assertElementIsDisplayed(selectCategoryScreen.selectCategoryTitle,"selectCategoryTitle");
        selectCategoryScreen.clickOnSilverCheckbox();
        selectCategoryScreen.clickOnSelectCategoryNextBtn();
        addOptionalPacksScreen.assertElementIsDisplayed(addOptionalPacksScreen.addOptionalPacksTitle,"addOptionalPacksTitle");
        addOptionalPacksScreen.clickOnOptionalPacksNextBtn();
        accountsScreen.assertElementIsDisplayed(accountsScreen.accountTitle,"accountTitle");
        accountsScreen.clickOnAccountNextBtn();
    }

    @And("user proceeds to the summary page for student journey")
    public void userProceedsToTheSummaryPageForStudentJourney() {
        logStep("And user proceeds to the summary page for Student journey");
        selectCategoryScreen.assertElementIsDisplayed(selectCategoryScreen.selectCategoryTitle,"selectCategoryTitle");
        selectCategoryScreen.clickOnHonorsCheckbox();
        selectCategoryScreen.clickOnSelectCategoryNextBtn();
//        Assert.assertTrue(addOptionalPacksScreen.isDisplayed(addOptionalPacksScreen.addOptionalPacksTitle),"Add Optional Packs title is not displayed");
//        addOptionalPacksScreen.clickOnOptionalPacksNextBtn();
        accountsScreen.assertElementIsDisplayed(accountsScreen.accountTitle,"accountTitle");
        accountsScreen.clickOnAccountNextBtn();
    }

    @And("user enters trip details for outbound or Student journey")
    public void userEntersTripDetailsForOutboundOrStudentJourney() {
        logStep("And user enters trip details for outbound/Student journey");
        tripDetailsScreen.assertElementIsDisplayed(tripDetailsScreen.tripDetailsTitle,"tripDetailsTitle");
        tripDetailsScreen.assertElementIsDisplayed(tripDetailsScreen.oneTripBtn,"oneTripButton");
        tripDetailsScreen.assertElementIsDisplayed(tripDetailsScreen.oneYearTripBtn,"oneYearTripButton");
        // Here's we can create another travel policy (Student) with the same trip dates of another created travel policy (Outbound)
        tripDetailsScreen.clickOnOneYearTrip();
        tripDetailsScreen.clickOnStartDateBtn();
        if(platformName.equalsIgnoreCase("ios")) {
            LocalDate currentDate = LocalDate.now();
            String monthName = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
            travellerDetailsScreen.SelectIOSDate(monthName, String.valueOf(currentDate.getDayOfMonth()), String.valueOf(currentDate.getYear()));
            travellerDetailsScreen.tapOnCalendarConfirmBtn();
//            tripDetailsScreen.clickOnEndDateBtn();
//            travellerDetailsScreen.SelectIOSDate(monthName, String.valueOf(currentDate.getDayOfMonth()+5), String.valueOf(currentDate.getYear()));
//            travellerDetailsScreen.tapOnCalendarConfirmBtn();
        }else {
            travellerDetailsScreen.clickOnCalendarOkBtn();
        }
        tripDetailsScreen.clickOnWWBtn();
        tripDetailsScreen.clickOnNextButton();
    }

    @And("user selects to be the main traveler and fill all required fields then clicks on next")
    public void userSelectsToBeTheMainTravelerAndFillAllRequiredFieldsThenClicksOnNext() {
        logStep("And user selects to be the main traveler and fill all required fields then clicks on next");
        travellerDetailsScreen.clickOnMainTravellerToggleBtn();
        travellerDetailsScreen.clickOnExpiryDateBtn();
        if(platformName.equalsIgnoreCase("ios")) {
            LocalDate currentDate = LocalDate.now();
            String monthName = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
            travellerDetailsScreen.SelectIOSDate(monthName, String.valueOf(currentDate.getDayOfMonth()+1), String.valueOf(currentDate.getYear()));
            travellerDetailsScreen.tapOnCalendarConfirmBtn();
        }else {
            travellerDetailsScreen.selectDate("30");
        }
        travellerDetailsScreen.userEnterPassportNumber("S123456789");
        travellerDetailsScreen.userSelectsYes();
        travellerDetailsScreen.assertElementIsDisplayed(travellerDetailsScreen.nextBtn,"nextButton");
        Assert.assertTrue(travellerDetailsScreen.nextBtn.isEnabled(),"Next Button is not enabled");
        travellerDetailsScreen.ClicksOnNextButton();
    }

    @And("verify all details are existed and clicks on Confirm button for student journey")
    public void verifyAllDetailsAreExistedAndClicksOnConfirmButtonForStudentJourney() {
        logStep("And verify all details are existed and clicks on Confirm button for student journey");
        summaryScreen.assertElementIsDisplayed(summaryScreen.summaryTitle,"summaryTitle");
        summaryScreen.assertElementIsDisplayed(summaryScreen.insuranceSubTitle,"insuranceSubTitle");
        summaryScreen.assertElementIsDisplayed(summaryScreen.mainTravellerSubTitle,"mainTravellerSubTitle");
        travellerDetailsScreen.Scroll();
        summaryScreen.clickOnConfirmBtn();
    }
}
