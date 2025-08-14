package Screens.goalGetterScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class GoalGetterScreen extends ScreenBase {
    public GoalGetterScreen(AppiumDriver appiumDriver){
        super(appiumDriver);
    }
    @AndroidFindBy(uiAutomator = "resourceId(\"GoalGetter.GoalGetterScreen:ExploreProductsButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "GoalGetter.GoalGetterScreen:ExploreProductsButton-Pressable")
    public WebElement ExploreProductBtn;
    //@AndroidFindBy()
    public void clickOnExploreProductBtn(){
        waitUntilElementAppear(ExploreProductBtn,10);
        tapOn(ExploreProductBtn);
    }

}
