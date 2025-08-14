package Screens.travelInsuranceScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class TravellerDetailsScreen extends ScreenBase {
    public TravellerDetailsScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:MainTravellerToggle\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravellerDetailsScreen:MainTravellerToggle")
    public WebElement mainTravellerToggleBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:RelationDropdown-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravellerDetailsScreen:RelationDropdown-Stack")
    public WebElement relationMenu;
    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:RelationDropdown-DropdownInput-Self\")")
//    @iOSXCUITFindBy(accessibility = "")
    public WebElement selfRelationRadioBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:RelationDropdown-DropdownInput-Spouse\")")
//    @iOSXCUITFindBy(accessibility = "")
    public WebElement spouseRelationRadioBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:RelationDropdown-DropdownInput-Child\")")
//    @iOSXCUITFindBy(accessibility = "")
    public WebElement childRelationRadioBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:RelationDropdown-DropdownInput-ConfirmButton-Pressable\")")
//    @iOSXCUITFindBy(accessibility = "")
    public WebElement confirmSelectedRelation;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").resourceId(\"TravelInsurance.TravellerDetailsScreen:NationalIdInput\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravellerDetailsScreen:NationalIdInput")
    public WebElement nationalId_iqamaIdEt;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:IDExpiryInput-Input-DatePickerButton\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravellerDetailsScreen:IDExpiryInput-Input-DatePickerButton")
    public WebElement expiryDateBtn;

    // this element is for Android only
    @AndroidFindBy(className = "android.view.View")
    public List<WebElement> monthView;

    // this element is for Android only
    @AndroidFindBy(uiAutomator = "resourceId(\"android:id/button1\")")
    public WebElement calendarOkBtn;
    // this element is for IOS only
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[@value=\"2026\"]")
    public WebElement certainDate;
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravellerDetailsScreen:IDExpiryInput-Input-DatePickerConfirmButton-Pressable")
    public WebElement calendarConfirmBtn;
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:DateOfBirth-Input-DatePickerConfirmButton-Pressable")
    public WebElement AddFamilyDetailsScreenCalendarConfirmBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*DatePickerConfirmButton-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*DatePickerConfirmButton-Pressable.*'")
    public WebElement calenderConfirmBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:DateOfBirthInput-Input-List-View\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravellerDetailsScreen:DateOfBirthInput-Input-List-View")
    public WebElement dateOfBirthPassportCalender;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:PassportNumberInput-TextInput\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravellerDetailsScreen:PassportNumberInput-Pressable")
    public WebElement passportNumText;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:PassportNumberInput-TextInput\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravellerDetailsScreen:PassportNumberInput-Pressable")
    public WebElement passportNumberET;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:PassportNumberInput-InputBox-ClearButton\")")
//    @iOSXCUITFindBy(accessibility = "")
    public WebElement passportNumberClearBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:FullNameInput-TextInput\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravellerDetailsScreen:FullNameInput-Pressable")
    public WebElement englishFullNameET;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:FullNameInput-InputBox-ClearButton\")")
//    @iOSXCUITFindBy(accessibility = "")
    public WebElement englishFullNameClearBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:PhoneNumberInput->InputBox\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravellerDetailsScreen:PhoneNumberInput->InputBox")
    public WebElement phoneNumberBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:PhoneNumberInput\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravellerDetailsScreen:PhoneNumberInput->InputBox")
    public WebElement phoneNumberEt;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:PhoneNumberInput-InputBox-ClearButton\")")
//    @iOSXCUITFindBy(accessibility = "")
    public WebElement phoneNumberClearBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:EmailInput-TextInput\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravellerDetailsScreen:EmailInput-Pressable")
    public WebElement emailET;
    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:EmailInput-InputBox-ClearButton\")")
//    @iOSXCUITFindBy(accessibility = "")
    public WebElement emailClearBtn;


    //    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravelInsuranceApplication:PageView\")")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"CroatiaMobileApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
//    public WebElement verticalScrollView;

    @AndroidFindBy(className = "android.widget.ScrollView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
    public WebElement listScrollView;

    //    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:ContentContainer-ScrollView\")")
    // id = TravelInsurance.TravellerDetailsScreen:MainStack
//    @iOSXCUITFindBy(accessibility = "Family Details You can add up to 7 family members Member 1 Relation National ID/Iqama National ID/Iqama Date of birth as in passport Passport number Passport number English full name English full name Did the traveller complete two Covid-19 Vaccinations?  Yes  No Save")
//    public WebElement verticalScrollView;
    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:YesChip\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravellerDetailsScreen:YesChip")
    public WebElement covidVaccineYesBtn;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Next month\"]")
    public WebElement nextMonth;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:NextButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravellerDetailsScreen:NextButton-Button-Pressable")
    public WebElement nextBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravellerDetailsScreen:AddTravellerButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravellerDetailsScreen:AddTravellerButton-Button-Pressable")
    public WebElement addTravellersBtn;
    @iOSXCUITFindBy(accessibility ="TravelInsurance.TravellerDetailsScreen:HeaderStack")
    public WebElement croatiaLogo;

    public void clickOnMainTravellerToggleBtn(){
        tapOn(mainTravellerToggleBtn);
    }
    public void clickOnExpiryDateBtn(){
        tapOn(expiryDateBtn);
    }

    public void navToNextMonth()
    {
        try {
            waitUntilElementAppear(nextMonth,5);
            tapOn(nextMonth);
        }catch (NoSuchElementException | TimeoutException ignored){

        }
    }

    public void selectDate(String dateDay) {
        navToNextMonth();
        for (WebElement element:monthView)
        {
            if (element.getText().equals(dateDay)){
                element.click();
                break;
            }
        }
        tapOn(calendarOkBtn);
    }

    public void clickOnCalendarOkBtn(){
        tapOn(calendarOkBtn);
    }

    public void SelectIOSDate(String month, String year, String day){

        selectDate(month, year, day);
    }
    public void tapOnCalendarConfirmBtn(){
        tapOn(calenderConfirmBtn);
    }
    public void tapOnAddFamilyDetailsScreenCalendarConfirmBtn(){
        tapOn(AddFamilyDetailsScreenCalendarConfirmBtn);
    }
    public void userEnterPassportNumber(String passportNum){
        typingTextIn(passportNumText,passportNum);
         if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("ios")) {
             tapOn(croatiaLogo);
        }

    }
    public void userTabOnTravellerDetailsScreen(){
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("ios")) {
            tapOn(croatiaLogo);
        }

    }

    public void Scroll(){
        waitUntilElementAppear(listScrollView,10);
        verticalScroll(listScrollView,0.9,0.1);
    }

    public void userSelectsYes(){
        waitUntilElementAppear(listScrollView,10);
        verticalScroll(listScrollView,0.8,0.2);
        tapOn(covidVaccineYesBtn);
    }

    public void clickOnAddTravellerButton(){
        tapOn(addTravellersBtn);
    }

    public void ClicksOnNextButton(){
        tapOn(nextBtn);
    }

}
