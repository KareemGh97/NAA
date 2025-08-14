package Screens.beneficiaryScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.WebElement;




public class ActivateBeneficiaryScreen extends ScreenBase {
    public ActivateBeneficiaryScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.ActivateNewBeneficiaryScreen:ConfirmButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ActivateNewBeneficiaryScreen:ConfirmButton-Pressable")
    public WebElement confirmBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.BeneficiaryProfileScreen:ConfirmButton-Pressable\").childSelector(className(\"android.widget.TextView\"))")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.BeneficiaryProfileScreen:ConfirmButton-Pressable")
    public WebElement activateBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.ActivateNewBeneficiaryScreen:buttonYes-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ActivateNewBeneficiaryScreen:buttonYes-Pressable")
    public WebElement confirmCancelBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.ActivateNewBeneficiaryScreen:NavHeader-CloseButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ActivateNewBeneficiaryScreen:NavHeader-CloseButton")
    public WebElement closeConfirmBeneficiaryScreen;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.BeneficiaryProfileScreen:NavHeader-BackButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.BeneficiaryProfileScreen:NavHeader-BackButton")
    public WebElement beneficiaryProfileScreenBackButton;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EnterBeneficiaryDetailsScreen:NavHeader-CloseButton\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EnterBeneficiaryDetailsScreen:NavHeader-CloseButton")
    public WebElement closeBeneficiaryDetailsScreen;
    public void tapOnConfirmBtn() {
        ScreenBase.ThreadSleep(8000);
        waitUntilElementAppear(confirmBtn,30);
        tapOn(confirmBtn);
    }

    public void tapOnCloseBeneficiaryDetailsScreen()  {
        tapOn(closeBeneficiaryDetailsScreen);
    }

    public void activateExistingBeneficiary()  {
        ScreenBase.ThreadSleep(8000);
        tapOn(activateBtn);
        ScreenBase.ThreadSleep(10000);
    }
    public void deactivateBeneficiary()  {
        waitUntilElementAppear(closeConfirmBeneficiaryScreen,30);
        ScreenBase.ThreadSleep(3000);
        tapOn(closeConfirmBeneficiaryScreen);
        ScreenBase.ThreadSleep(2000);
        waitUntilElementAppear(confirmCancelBtn,40);
        tapOn(confirmCancelBtn);
        waitUntilElementAppear(closeBeneficiaryDetailsScreen,30);
        tapOn(closeBeneficiaryDetailsScreen);

    }
    public void tapOnBeneficiaryProfileScreenBackButton()  {
        tapOn(beneficiaryProfileScreenBackButton);
    }
}
