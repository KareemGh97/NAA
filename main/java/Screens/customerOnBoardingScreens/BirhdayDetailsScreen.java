package Screens.customerOnBoardingScreens;

import Screens.homeScreen.ScreenBase;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class BirhdayDetailsScreen extends ScreenBase {
    public BirhdayDetailsScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"Onboarding.AddBirthScreen:CityInput-Stack\"])[1]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeOther[@name=\"Onboarding.AddBirthScreen:CityInput-Stack\" and @label=\"Country Select city\"]")
    public WebElement birthCountry;

    @iOSXCUITFindBy(accessibility = "Onboarding.AddBirthScreen:CityInput-DropdownInput-ConfirmButton-Pressable")
    public WebElement setBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(31)")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Onboarding.AddBirthScreen:CityInput-Stack\" and @label=\"Region Select city\"]")
    public WebElement cityOfBirthday;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.AddBirthScreen:ConfirmButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.AddBirthScreen:ConfirmButton-Button-Pressable")
    public WebElement confirmdetailsContinueBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Saudi Arabia\")")
    public WebElement countryNameSA;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"AL BAHA\")")
    public WebElement regionName;

    // Region DDL id, City DDL id and Country DDL id are all same
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.AddBirthScreen:CityInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.AddBirthScreen:CityInput-InputText-View")
    public WebElement countryCityRegionDDL;
    @AndroidFindBy(uiAutomator = "resourceId(\"com.croatia.consumerapp.sit:id/select_dialog_listview\")")
    @iOSXCUITFindBy(accessibility = "com.croatia.consumerapp.sit:id/select_dialog_listvieww")
    public WebElement dialogList;

    // Select by text for Country"Saudi Arabia" , for City "ALHDAR" and for Region "Central Region"
    @AndroidFindBy(className = "android.widget.CheckedTextView")
//    @iOSXCUITFindBy(accessibility = "com.croatia.consumerapp.sit:id/select_dialog_listvieww")
    public WebElement dialogList2;




    public void setCountry(String platform)  {
//        tapOn(birthCountry);
//        if(platform.equalsIgnoreCase("android"))
//        {
//            tapOn(countryName);
//        }
//        else
//        {
//            tapOn(setBtn);
//        }
//        tapOn(cityOfBirthday);
//        if(platform.equalsIgnoreCase("android"))
//        {
//            tapOn(regionName);
//        }
//        else
//        {
//            tapOn(setBtn);
//        }
        waitUntilElementAppear(confirmdetailsContinueBtn,10);
        Assert.isTrue(confirmdetailsContinueBtn.isDisplayed(),"Details Pages is not appeared");
        tapOn(confirmdetailsContinueBtn);

    }
}
