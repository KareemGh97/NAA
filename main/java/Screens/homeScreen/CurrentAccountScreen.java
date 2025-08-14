package Screens.homeScreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class CurrentAccountScreen extends ScreenBase{

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Account No.\")")
    @iOSXCUITFindBy(accessibility = "Account No.")
    public WebElement AccountNumBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"IBAN\")")
    @iOSXCUITFindBy(accessibility = "IBAN")
    public WebElement IBANBtn;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"Home.AccountDetailsScreen:NavigationListIcon\"])[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Home.AccountDetailsScreen:NavigationListPressable\" and @label=\"Documents\"]")
    public WebElement documentBtn;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"Home.AccountDetailsScreen:NavigationListIcon\"])[1]")
//    @iOSXCUITFindBy(accessibility = "")
    public WebElement SADADpayBtn;


    public CurrentAccountScreen (AppiumDriver appiumDriver){
        super(appiumDriver);
    }
    public void clickOnDocumentBtn(){
        tapOn(documentBtn);
    }
    public void clickOnSADADpayBtn(){
        tapOn(SADADpayBtn);
    }
}
