package Screens.travelInsuranceScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class AddTravellerTypeScreen  extends ScreenBase {
    public AddTravellerTypeScreen (AppiumDriver appiumDriver){
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddTravelerTypeScreen:Title-HeaderText\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddTravelerTypeScreen:Title-HeaderText")
    public WebElement addTravellersTitle;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddTravelerTypeScreen:TravelerType-FamilyRadioButton-Radio\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddTravelerTypeScreen:TravelerType-FamilyRadioButton-Radio")
    public WebElement familyType;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddTravelerTypeScreen:TravelerType-Individual-Radio\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddTravelerTypeScreen:TravelerType-Individual-Radio")
    public WebElement individualType;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddTravelerTypeScreen:NextButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddTravelerTypeScreen:NextButton-Pressable")
    public WebElement nextBtn;

    public void clickOnFamilyButton(){
        tapOn(familyType);
    }

    public void clickOnIndividualButton(){
        tapOn(individualType);
    }
    public void clickOnAddTypeNextButton(){
        tapOn(nextBtn);
    }
}
