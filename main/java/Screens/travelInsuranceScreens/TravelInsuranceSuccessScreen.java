package Screens.travelInsuranceScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class TravelInsuranceSuccessScreen extends ScreenBase {
    public TravelInsuranceSuccessScreen (AppiumDriver appiumDriver){
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravelInsuranceSuccessScreen:title-HeaderText\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravelInsuranceSuccessScreen:title-HeaderText")
    public WebElement policyIssuedSucc;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravelInsuranceSuccessScreen:details\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravelInsuranceSuccessScreen:details")
    public WebElement detailsSection;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravelInsuranceSuccessScreen:TotalAmountValue\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravelInsuranceSuccessScreen:TotalAmountValue")
    public WebElement totalAmount;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravelInsuranceSuccessScreen:coverLabel\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravelInsuranceSuccessScreen:coverLabel")
    public WebElement cover;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravelInsuranceSuccessScreen:destinationLabel\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravelInsuranceSuccessScreen:destinationLabel")
    public WebElement destination;

    // there is a need for scrolling here while IOS

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravelInsuranceSuccessScreen:ContentContainer-ScrollView\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravelInsuranceSuccessScreen:ContentContainer-ScrollView")
    public WebElement scrollView;
    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.TravelInsuranceSuccessScreen:GoToDashboardButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.TravelInsuranceSuccessScreen:GoToDashboardButton-Pressable")
    public WebElement goToDashboardBtn;

    public void clickOnGoToDashboardBtn(){
        waitUntilElementAppear(scrollView,10);
        verticalScroll(scrollView,0.8,0.2);
        tapOn(goToDashboardBtn);
    }


}
