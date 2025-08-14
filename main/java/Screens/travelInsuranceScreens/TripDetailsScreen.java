package Screens.travelInsuranceScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class TripDetailsScreen extends ScreenBase {

    public TripDetailsScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TripDetailsScreen:TitleText\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TripDetailsScreen:TitleText")
    public WebElement tripDetailsTitle;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TripDetailsScreen:StartDateInput-Input-DatePickerButton\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TripDetailsScreen:StartDateInput-Input-DatePickerButton")
    public WebElement startDateBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TripDetailsScreen:EndDateInput-Input-DatePickerButton\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TripDetailsScreen:EndDateInput-Input-DatePickerButton")
    public WebElement endDateBtn;

    // this element is for IOS only
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TripDetailsScreen:StartDateInput-Input-DatePickerConfirmButton-Pressable")
    public WebElement calendarStartDateConfirmBtn;

    // this element is for IOS only
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TripDetailsScreen:EndDateInput-Input-DatePickerConfirmButton-Pressable")
    public WebElement calendarEndDateConfirmBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TripDetailsScreen:TripTypePill-611000-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TripDetailsScreen:TripTypePill-611000-Pressable")
    public WebElement oneTripBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TripDetailsScreen:TripTypePill-611001-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TripDetailsScreen:TripTypePill-611001-Pressable")
    public WebElement oneYearTripBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TripDetailsScreen:RadioButton-99901\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TripDetailsScreen:RadioButton-99901")
    public WebElement oneYearUnlimitedOptionWorldWideRadioBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TripDetailsScreen:RadioButton-99902\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TripDetailsScreen:RadioButton-99902")
    public WebElement oneYearUnlimitedOptionWorldwideExcludingUSACanadaRadioBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TripDetailsScreen:RadioButton-99903\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TripDetailsScreen:RadioButton-99903")
    public WebElement oneYearUnlimitedGCCEuStatesOfTheGulfCooperationCouncilEuropeRadioBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TripDetailsScreen:NextButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TripDetailsScreen:NextButton-Pressable")
    public WebElement nextBtn;
    public void clickOnStartDateBtn() {
        tapOn(startDateBtn);
    }

    public void clickOnStartDateConfirmBtn(){
        tapOn(calendarStartDateConfirmBtn);
    }
    public void clickOnEndDateBtn() {
        tapOn(endDateBtn);
    }

    public void clickOnEndDateConfirmBtn(){
        tapOn(calendarEndDateConfirmBtn);
    }
    public void clickOnNextButton(){
        tapOn(nextBtn);
    }

    public void clickOnOneYearTrip(){ tapOn(oneYearTripBtn);}

    public void clickOnWWBtn(){
        tapOn(oneYearUnlimitedOptionWorldWideRadioBtn);
    }

    public void clickOnWW2Btn(){
        tapOn(oneYearUnlimitedOptionWorldwideExcludingUSACanadaRadioBtn);
    }

    public void clickOnGCCBtn(){
        tapOn(oneYearUnlimitedGCCEuStatesOfTheGulfCooperationCouncilEuropeRadioBtn);
    }
}
