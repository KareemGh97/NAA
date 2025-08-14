package Screens.customerOnBoardingScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class AddressScreen extends ScreenBase {
    public AddressScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.AddAddressScreen:CityInput-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.AddAddressScreen:CityInput-View")
    public WebElement cityBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"MAKKAH\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"MAKKAH\"])[2]")
    public WebElement city;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IncomeDetailsScreen:SetButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IncomeDetailsScreen:SetButton-Pressable")
    public WebElement setCitySelection;


    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.AddAddressScreen:StreetNameInput\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.AddAddressScreen:StreetNameInput")
    public WebElement streetEt;



    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.AddAddressScreen:ConfirmButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.AddAddressScreen:ConfirmButton-Button-Pressable")
    public WebElement confirmBtn;

    public void selectCity(){
        tapOn(cityBtn);
        tapOn(city);
        tapOn(setCitySelection);
    }
    public void enterStreetName(String streetName){
        typingTextIn(streetEt,streetName);
    }
    public void confirmAddress(){
        tapOn(confirmBtn);
    }



}
