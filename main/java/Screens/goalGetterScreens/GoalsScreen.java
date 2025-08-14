package Screens.goalGetterScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class GoalsScreen extends ScreenBase {
    public GoalsScreen(AppiumDriver appiumDriver){
        super(appiumDriver);
    }
    @AndroidFindBy(uiAutomator = "resourceId(\"GoalGetter.GoalDashboardScreen:ProductSegmentedItem-Text\")")
    @iOSXCUITFindBy(accessibility = "GoalGetter.GoalDashboardScreen:ProductSegmentedItem-Text")
    public WebElement ProductsBtn;
    //@AndroidFindBy()
    public void clickOnProductsBtn(){
        waitUntilElementAppear(ProductsBtn,10);
        tapOn(ProductsBtn);
    }

}
