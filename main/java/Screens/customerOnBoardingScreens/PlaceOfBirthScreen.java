package Screens.customerOnBoardingScreens;

import Screens.homeScreen.ScreenBase;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PlaceOfBirthScreen extends ScreenBase {
    public PlaceOfBirthScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.AddBirthScreen:CityInput-DropdownInput-Stack\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.AddBirthScreen:CityInput-DropdownInput-Stack")
    public WebElement birthCountry;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Afganistan\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Afganistan\"])[2]")
    public WebElement countries;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IncomeDetailsScreen:SetButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IncomeDetailsScreen:SetButton-Pressable")
    public WebElement setCountrybtn;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"City\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Onboarding.AddBirthScreen:CityInput\"]")
    public WebElement cityOfBirthday;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.AddBirthScreen:ConfirmButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.AddBirthScreen:ConfirmButton-Button-Pressable")
    public WebElement confirmdetailsContinueBtn;



    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Search\"])[5]")
    public WebElement countrySearchEt;
    @AndroidFindBy(uiAutomator = "className(\"android.view.ViewGroup\").childSelector(className(\"android.widget.TextView\"))")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeScrollView/**/XCUIElementTypeOther[`name != null`]")
    public List<WebElement> itemList;

    @AndroidFindBy(className = "android.widget.ScrollView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
    public WebElement listScrollView;






    public void setBirthDetailsOutSideSaudiArabia()  {

        tapOn(birthCountry);
        ScreenBase.ThreadSleep(1000);
        selectCountry("Egypt");
        tapOn(setCountrybtn);
        typingTextIn(cityOfBirthday,"cairo");
        waitUntilElementAppear(confirmdetailsContinueBtn,10);
        Assert.isTrue(confirmdetailsContinueBtn.isDisplayed(),"Details Pages is not appeared");
        confirmBirthPlace();
    }

    public void confirmBirthPlace(){
        tapOn(confirmdetailsContinueBtn);
    }

    public void setBirthCountry()  {
        tapOn(birthCountry);
        ScreenBase.ThreadSleep(1000);
        selectCountry("Egypt");
        tapOn(setCountrybtn);
    }

    public void selectCountry (String country){
        typingTextIn(countrySearchEt,country);
        scrollThenTapOnElementByText(itemList,"الاسم بالعربي",country,listScrollView);
    }
}
