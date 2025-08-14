package Screens.travelInsuranceScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class TravelInsuranceOptionsScreen extends ScreenBase {
    public TravelInsuranceOptionsScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravelInsuranceScreen:NavHeader-BackButton\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravelInsuranceApplication:NavHeader-BackButton")
    public WebElement backBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravelInsuranceScreen:TravelInsuranceTypePill-Domestic-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravelInsuranceScreen:TravelInsuranceTypePill-Domestic-Pressable")
    public WebElement domesticTab;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravelInsuranceScreen:TravelInsuranceTypePill-Outbound-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravelInsuranceScreen:TravelInsuranceTypePill-Outbound-Pressable")
    public WebElement outBoundTab;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravelInsuranceScreen:TravelInsuranceTypePill-Student-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravelInsuranceScreen:TravelInsuranceTypePill-Student-Pressable")
    public WebElement studentTab;


    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravelInsuranceScreen:ProductBrochure\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravelInsuranceScreen:ProductBrochure")
    public WebElement ProductBrochureBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravelInsuranceScreen:ApplyButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravelInsuranceScreen:ApplyButton-Pressable")
    public WebElement applyBtn;

    public void clickOnDomesticTap(){
        tapOn(domesticTab);
    }

    public void clickOnOutboundTap(){
        tapOn(outBoundTab);
    }

    public void clickOnStudentTap(){
        tapOn(studentTab);
    }

    public void clickOnApplyBtn(){
        tapOn(applyBtn);
    }

}
