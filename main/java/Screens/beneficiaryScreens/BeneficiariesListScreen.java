package Screens.beneficiaryScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class BeneficiariesListScreen extends ScreenBase {
    public BeneficiariesListScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.TransfersLandingScreen:FrequentBeneficiaries-Text\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.TransfersLandingScreen:FrequentBeneficiaries-Text")
    public WebElement viewAll;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Croatia Bank\"]")
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeOther[@name=\"AutomationUser AlRajhi Bank SA0980000204608015166873\"])[2]")
    public WebElement inactiveBeneficiary;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"AlRajhi Bank\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"mobile AlRajhi Bank SA4780000204608017897806\"])[2]")
    public WebElement inactiveArabBeneficiary;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.TransfersLandingScreen:Beneficiaries\").instance(0)")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"mobile AlRajhi Bank SA4780000204608017897806\"])[2]")
    public WebElement activeBeneficiary;

    public void tapOnBeneficiaries(String transferType){
        waitUntilElementAppear(viewAll,30);
        tapOn(viewAll);
        if(transferType.equalsIgnoreCase("croToArb"))
        {
            tapOn(inactiveArabBeneficiary);
        }
        else  if(transferType.equalsIgnoreCase("croToCro"))
        {
            tapOn(inactiveBeneficiary);
        }

    }
    public void tapOnActiveBeneficiary(){
        tapOn(activeBeneficiary);
    }

}
