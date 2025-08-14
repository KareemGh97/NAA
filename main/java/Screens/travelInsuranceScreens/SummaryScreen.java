package Screens.travelInsuranceScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class SummaryScreen extends ScreenBase {
    public SummaryScreen (AppiumDriver appiumDriver){
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddOptionalPackScreen:TitleText\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddOptionalPackScreen:TitleText")
    public WebElement summaryTitle;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddOptionalPackScreen:Title\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddOptionalPackScreen:Title")
    public WebElement insuranceSubTitle;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddOptionalPackScreen:MainTravellerTitle\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddOptionalPackScreen:MainTravellerTitle")
    public WebElement mainTravellerSubTitle;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddOptionalPackScreen:FamilyOrIndividualTitle\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddOptionalPackScreen:FamilyOrIndividualTitle")
    public WebElement individualTravellerSubTitle;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddOptionalPackScreen:FamilyOrIndividualTitle\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddOptionalPackScreen:FamilyOrIndividualTitle")
    public WebElement familyTravellerSubTitle;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravelInsuranceSummaryScreen:ContentContainer-ScrollView\")")
    @iOSXCUITFindBy(accessibility = "Summary Insurance Type Domestic Category Domestic Amount per traveller 86.25  SAR Total no. travellers 2 Total add-ons 0 Total 172.50  SAR View more Main traveller National ID/Iqama 1005307325 Date of birth 28-10-1992 Passport number S51251 English full name Abdullah Almontaserbellah Mobile number +966529761504 Email 1RKVQ_passcodeIs_135792_@account.sa View more Family traveller National ID/Iqama 1252522525 Date of birth 05-11-2024 Passport number D58484848 English full name ffrg View more Confirm")
    public WebElement summaryScrollView;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddOptionalPackScreen:FamilyMember0:Collapsible-CollapsedTitle\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddOptionalPackScreen:FamilyMember0:Collapsible-CollapsedTitle")
    public WebElement familyViewMoreButton;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravelInsuranceSummaryScreen:confirmButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravelInsuranceSummaryScreen:confirmButton-Pressable")
    public WebElement confirmButton;

    public void clickOnConfirmBtn(){
        tapOn(confirmButton);
    }

}
