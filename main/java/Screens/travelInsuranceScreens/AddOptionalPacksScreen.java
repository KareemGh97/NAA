package Screens.travelInsuranceScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class AddOptionalPacksScreen extends ScreenBase {
    public AddOptionalPacksScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddOptionalPackScreen:TitleText\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TravelInsurance.AddOptionalPackScreen:TitleText\" and @label=\"Add optional packs\"]")
    public WebElement addOptionalPacksTitle;
    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddOptionalPackScreen:NextButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddOptionalPackScreen:NextButton-Pressable")
    public WebElement nextBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddOptionalPackScreen:OptionalPackCard-611325-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddOptionalPackScreen:OptionalPackCard-611325-Pressable")
    public WebElement terrorismAndHijackCheckBox;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.AddOptionalPackScreen:OptionalPackCard-610693-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.AddOptionalPackScreen:OptionalPackCard-610693-Pressable")
    public WebElement excessWaiverCheckBox;

    public void clickOnOptionalPacksNextBtn(){
        tapOn(nextBtn);
    }

}
