package Screens.travelInsuranceScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class AccountsScreen extends ScreenBase {
    public AccountsScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.ChooseAccountScreen:TitleText\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.ChooseAccountScreen:TitleText")
    public WebElement accountTitle;
    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.ChooseAccountScreen:NextButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.ChooseAccountScreen:NextButton-Pressable")
    public WebElement nextBtn;

    public void clickOnAccountNextBtn(){
        tapOn(nextBtn);
    }
}
