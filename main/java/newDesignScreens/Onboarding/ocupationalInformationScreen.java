package newDesignScreens.Onboarding;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ocupationalInformationScreen extends ScreenBase {
    public ocupationalInformationScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.OccupationalInfoScreen:ContinueButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.OccupationalInfoScreen:ContinueButton-Pressable")
    public WebElement occupationalInfoContinueButton;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.OccupationalInfoScreen:Occupation-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.OccupationalInfoScreen:Occupation-DropdownInput-Stack")
    public WebElement selectYourOccupationBt;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.OccupationalInfoScreen:SelectASector-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.OccupationalInfoScreen:SelectASector-DropdownInput-Stack")
    public WebElement selectYourSectorBt;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.OccupationalInfoScreen:selectAProfessionText-DropdownInput-InputText-View\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.OccupationalInfoScreen:selectAProfessionText-DropdownInput-Stack")
    public WebElement selectYourProfessionBt;

    @AndroidFindBy(uiAutomator = "className(\"android.view.ViewGroup\").childSelector(className(\"android.widget.TextView\"))")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeScrollView/**/XCUIElementTypeOther[`name != null`]")
    public List<WebElement> itemList;

    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.OccupationalInfoScreen:CompanyName\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.OccupationalInfoScreen:CompanyName")
    public WebElement addYourCompanyName;
    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Search\"])[5]")
    public WebElement occupationSearchEt;
    @AndroidFindBy(uiAutomator = "resourceId(\"Onboarding.IncomeDetailsScreen:SetButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Onboarding.IncomeDetailsScreen:SetButton-Pressable")
    public WebElement setBt;
    @AndroidFindBy(className = "android.widget.ScrollView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
    public WebElement listScrollView;



    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Company Name\"]")
    @iOSXCUITFindBy(accessibility = "Onboarding.OccupationalInfoScreen:CompanyName")
    public WebElement addYourCompanyNameEt;

    public void clickOnSelectYourProfession (){
        tapOn(selectYourProfessionBt);
    }
    public void selectProfession (String occupation){
        scrollThenTapOnElementByText(itemList,"الاسم بالعربي",occupation,listScrollView);
    }
    public void clickOnSetButton (){
        tapOn(setBt);
    }
    public void clickOnOccupationalInfoContinueButton (){
        tapOn(occupationalInfoContinueButton);
    }
    public void clickOnSelectYourSectorBt (){
        tapOn(selectYourSectorBt);
    }

    public void clickOnSelectYourOccupationBt (){
        tapOn(selectYourOccupationBt);
    }
    public void clickOnsSelectYourProfessionBt(){
        tapOn(selectYourProfessionBt);
    }
    public void selectOccupationBySearch(String occupation){
        typingTextIn(occupationSearchEt,occupation);
        scrollThenTapOnElementByText(itemList,"الاسم بالعربي",occupation,listScrollView);
    }
    public void addCompanyName(String companyName)  {
        ScreenBase.ThreadSleep(2000);
        verticalScroll(listScrollView,0.8,0.2);
        tapOn(addYourCompanyName);
        typingTextIn(addYourCompanyNameEt,companyName);
    }

    public void userSelectProfession(String occupation)  {
        clickOnsSelectYourProfessionBt();
        selectProfession(occupation);
        clickOnSetButton();
    }

    public void userSelectSector(String occupation) {
        clickOnSelectYourSectorBt();
        selectProfession(occupation);
        clickOnSetButton();
    }

    public void userSelectOccupation(String profession){
        clickOnSelectYourOccupationBt();
        selectOccupationBySearch(profession);
        clickOnSetButton();
    }
}
