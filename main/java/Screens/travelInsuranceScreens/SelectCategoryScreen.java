package Screens.travelInsuranceScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class SelectCategoryScreen extends ScreenBase {
    public SelectCategoryScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.CategorySelectionView:TitleText\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.CategorySelectionView:TitleText")
    public WebElement selectCategoryTitle;
    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.CategoryList:Icon-Domestic\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.CategoryList:Icon-Domestic")
    public WebElement domesticCheckBox;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.CategoryList:Icon-SILVER\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.CategoryList:Icon-SILVER")
    public WebElement silverCheckBox;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.CategoryList:Icon-GOLD\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.CategoryList:Icon-GOLD")
    public WebElement goldCheckBox;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.CategoryList:Icon-HONORS\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.CategoryList:Icon-HONORS")
    public WebElement honorsCheckBox;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.CategoryList:Icon-STANDARD\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.CategoryList:Icon-STANDARD")
    public WebElement standardCheckBox;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.CategoryList:Icon-PLATINUM\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.CategoryList:Icon-PLATINUM")
    public WebElement platinumCheckBox;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.CategorySelectionView:ProductBrochure-Stack\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.CategorySelectionView:ProductBrochure-Stack")
    public WebElement productBrochure;

    @AndroidFindBy(uiAutomator = "resourceId(\"TravelInsurance.CategorySelectionView:NextButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "TravelInsurance.CategorySelectionView:NextButton-Pressable")
    public WebElement nextBtn;

    public void clickOnDomesticCheckbox(){
        tapOn(domesticCheckBox);
    }

    public void clickOnSilverCheckbox(){
        tapOn(silverCheckBox);
    }

    public void clickOnHonorsCheckbox(){
        tapOn(honorsCheckBox);
    }

    public void clickOnSelectCategoryNextBtn(){
        tapOn(nextBtn);
    }
}
