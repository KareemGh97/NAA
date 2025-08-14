package Screens.travelInsuranceScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class PoliciesScreen extends ScreenBase {
    public PoliciesScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.MyPoliciesScreen:NavHeader-IconButton\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.MyPoliciesScreen:NavHeader-IconButton")
    public WebElement plusIconBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.MyPoliciesScreen:NavHeader-BackButton\")")
//    @iOSXCUITFindBy(accessibility = "")
    public WebElement backBtn;

    public void clickOnPlusIconBtn(){
        tapOn(plusIconBtn);
    }

}
