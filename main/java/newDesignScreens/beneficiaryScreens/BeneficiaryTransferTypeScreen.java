package newDesignScreens.beneficiaryScreens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class BeneficiaryTransferTypeScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.TransfersLandingScreen:SelectTransferTypeModal-View-CloseButton\")")
    @iOSXCUITFindBy()
    public WebElement closeBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.TransfersLandingScreen:SelectTransferTypeModal-CroatiaTransferButton\")")
    @iOSXCUITFindBy()
    public WebElement neraAccountType;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.TransfersLandingScreen:SelectTransferTypeModal-AlRajhiTransferButton\")")
    @iOSXCUITFindBy()
    public WebElement alRajhiBankAccountType;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.TransfersLandingScreen:SelectTransferTypeModal-LocalTransferButton\")")
    @iOSXCUITFindBy()
    public WebElement localBankAccountType;

}
