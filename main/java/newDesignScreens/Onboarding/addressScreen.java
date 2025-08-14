package newDesignScreens.Onboarding;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import java.util.List;

public class addressScreen extends ScreenBase {

    public addressScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.AddAddressScreen:CityInput-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.AddAddressScreen:CityInput-View")
    public WebElement cityBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.AddAddressScreen:CityList-View\").childSelector(new UiSelector().className(\"android.view.ViewGroup\"))")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, '')]")
    public List<WebElement> cities;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.AddAddressScreen:StreetNameInput\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.AddAddressScreen:StreetNameInput")
    public WebElement streetEt;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.AddAddressScreen:ConfirmButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.AddAddressScreen:ConfirmButton-Button-Pressable")
    public WebElement confirmBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.AddAddressScreen:AdditionalNumberInput\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.AddAddressScreen:AdditionalNumberInput")
    public WebElement additionalNumberInput;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Additional number (Optional)\"]")
    @iOSXCUITFindBy(accessibility = "Onboarding.AddAddressScreen:AdditionalNumberInput")
    public WebElement additionalNumberInputTB;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.AddAddressScreen:Title\")")
    @iOSXCUITFindBy(accessibility  = "Onboarding.AddAddressScreen:Title")
    public WebElement addAddressScreen;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"CroatiaMobileApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    public WebElement screenContainer;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.AddAddressScreen:DistrictInput\")")
    @iOSXCUITFindBy(accessibility  = "Onboarding.AddAddressScreen:DistrictInput")
    public WebElement DistrictInput;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.AddAddressScreen:StreetNameInput\")")
    @iOSXCUITFindBy(accessibility  = "Onboarding.AddAddressScreen:StreetNameInput")
    public WebElement StreetNameInput;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.AddAddressScreen:BuildingNumberInput\")")
    @iOSXCUITFindBy(accessibility  = "Onboarding.AddAddressScreen:BuildingNumberInput")
    public WebElement BuildingNumberInput;

    public void selectCity(){
        tapOn(cityBtn);
    }
    public void selectCityByText(String cityName) {
        for (WebElement city : cities) {
            if (city.getText().equalsIgnoreCase(cityName) || city.getAttribute("content-desc").equalsIgnoreCase(cityName)) {
                tapOn(city);
                break;
            }
        }
    }
    public void enterStreetName(String streetName){
        typingTextIn(streetEt,streetName);
    }
    public void confirmAddress(){
        tapOn(confirmBtn);
    }
    public void setAdditionalAddressNumber(String additionalNumber){
        verticalScroll(screenContainer,0.9,0.1);
        tapOn(additionalNumberInput);
        typingTextIn(additionalNumberInputTB,additionalNumber);
    }
}
