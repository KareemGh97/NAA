package Screens.travelInsuranceScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class AddFamilyDetailsScreen extends ScreenBase {
    public AddFamilyDetailsScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddFamilyDetailsScreen:PageMainTitle-HeaderText\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:PageMainTitle-HeaderText")
    public WebElement familyDetailsTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Individual details\")")
    @iOSXCUITFindBy(accessibility = "Individual details")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Individual details\"]")
    public WebElement individualDetailsTitle;
    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddFamilyDetailsScreen:RelationDropdown-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:RelationDropdown-Stack")
    public WebElement relationDDL;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddFamilyDetailsScreen:RelationDropdown-DropdownInput-Spouse\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:RelationDropdown-DropdownInput-Spouse")
    public WebElement spouseBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddFamilyDetailsScreen:RelationDropdown-DropdownInput-Child\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:RelationDropdown-DropdownInput-Child")
    public WebElement childBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddFamilyDetailsScreen:RelationDropdown-DropdownInput-ConfirmButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:RelationDropdown-DropdownInput-ConfirmButton-Pressable")
    public WebElement selectBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddFamilyDetailsScreen:NationalIdInput\").childSelector(className(\"android.widget.EditText\"))")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:NationalIdInput")
    public WebElement nationalIdText;

    // Rest of Birth elements are same as existed in travel insurance screen
    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddFamilyDetailsScreen:DateOfBirth-Input-Stack\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:DateOfBirth-Input-Stack")
    public WebElement dateOfBirth;

    // this birthStartDateBtn element is for IOS only
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:DateOfBirth-Input-DatePickerConfirmButton-Pressable")
    public WebElement birthStartDateBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddFamilyDetailsScreen:PassportNumberInput-TextInput\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravellerDetailsScreen:PassportNumberInput-Pressable")
    public WebElement passportNumText;
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:PassportNumberInput-Pressable")
    public WebElement addFamilyPassportNumText;
    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddFamilyDetailsScreen:EnglishFullName-TextInput\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:EnglishFullName-TextInput")
//    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:EnglishFullName-Pressable")
    public WebElement englishFullNameText;
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:EnglishFullName-Pressable")
    public WebElement addFamilyEnglishFullNameText;
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
    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddFamilyDetailsScreen:YesChip\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:YesChip")
    public WebElement covidVaccineYesBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddFamilyDetailsScreen:NoChip\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:NoChip")
    public WebElement covidVaccineNoBtn;


    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddFamilyDetailsScreen:SaveButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:SaveButton-Button-Pressable")
    public WebElement saveButton;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddFamilyDetailsScreen:MemberDetails-1-EditButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:MemberDetails-1-EditButton-Pressable")
    public WebElement editFamilyMemberBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddFamilyDetailsScreen:MemberDetails-1-DeleteButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:MemberDetails-1-DeleteButton-Pressable")
    public WebElement deleteFamilyMemberBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddFamilyDetailsScreen:AddIcon\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:AddIcon")
    public WebElement addMoreFamilyMemberIcon;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddFamilyDetailsScreen:NextButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddFamilyDetailsScreen:NextButton-Pressable")
    public WebElement nextBtn;
    @iOSXCUITFindBy(accessibility ="TravelInsurance.AddFamilyDetailsScreen:AddFamilyCountText")
    public WebElement familyMemeberLogo;

    public void selectRelation() {
        tapOn(relationDDL);
        tapOn(spouseBtn);
        tapOn(selectBtn);
    }

    public void setNationalID(String nationalID) {
        typingTextIn(nationalIdText, nationalID);
//        tapOn();
    }

    public void clickOnDateOfBirthBtn() {
        tapOn(dateOfBirth);
    }

    public void clickOnDateOfBirthStartDate() {

        tapOn(dateOfBirth);
    }

    public void setPassportNumText(String passportNum) {
        typingTextIn(passportNumText, passportNum);
    }
    public void setFamilyPassportNumText(String passportNum) {
        typingTextIn(addFamilyPassportNumText, passportNum);
    }
    public void setEnglishFullNameText(String fullName) {
        typingTextIn(englishFullNameText, fullName);
    }
    public void setAddFamilyEnglishFullNameText(String fullName) {
        typingTextIn(addFamilyEnglishFullNameText, fullName);
    }
    public void userSelectsYes() {
        waitUntilElementAppear(listScrollView, 10);
        verticalScroll(listScrollView, 0.8, 0.2);
        tapOn(covidVaccineYesBtn);
    }
    public void userTabOnFamilyMemeberLogo(){
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("ios")) {
            tapOn(familyMemeberLogo);
        }

    }
    public void clickOnSaveButton() {
        tapOn(saveButton);
    }

    public void clickOnAddFamilyDetailsNextBtn() {
        tapOn(nextBtn);
    }
}
