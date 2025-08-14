package Screens.goalGetterScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class ProductsScreen extends ScreenBase {

    public ProductsScreen(AppiumDriver appiumDriver){
        super(appiumDriver);
    }
    @AndroidFindBy(uiAutomator = "resourceId(\"GoalGetter.GoalDashboardScreen:MutalFund:ProducyExploreText\")")
    @iOSXCUITFindBy(accessibility = "GoalGetter.GoalDashboardScreen:MutalFund:ProducyExploreText")
    public WebElement mutualFundIcon;
    @AndroidFindBy(uiAutomator = "resourceId(\"GoalGetter.GoalDashboardScreen:GoldWallet:ProducyExploreText\")")
    @iOSXCUITFindBy(accessibility = "GoalGetter.GoalDashboardScreen:GoldWallet:ProducyExploreText")
    public WebElement goldWalletIcon;
    @AndroidFindBy(uiAutomator = "resourceId(\"MutualFund.EntryPoint-TermsAndConditions:HeroSlider-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "MutualFund.EntryPoint-TermsAndConditions:HeroSlider-Button-Pressable")
    public WebElement mutualFundStartBtn;
    public void clickOnMutualFundIcon(){
        waitUntilElementAppear(mutualFundIcon,10);
        tapOn(mutualFundIcon);
    }

    public void clickOnGoldIcon(){
        waitUntilElementAppear(goldWalletIcon,10);
        tapOn(goldWalletIcon);
    }

    public void clickOnMutualFundStartBtn(){
        waitUntilElementAppear(mutualFundStartBtn,10);
        tapOn(mutualFundStartBtn);
    }


}
