package Screens.transferScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class TransferConfirmationScreen extends ScreenBase {
    public TransferConfirmationScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*Button-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*Button-Pressable.*'")
    public WebElement doneBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.SuccessfulRequestScreen:DoneButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.SuccessfulRequestScreen:DoneButton-Pressable")
    public WebElement requestToPayDoneBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Ips.LocalTransferSuccessScreen:DoneTransactionButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Ips.LocalTransferSuccessScreen:DoneTransactionButton-Pressable")
    public WebElement confirmRTPDoneBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.ViewTransactionsScreen:CloseTransactionButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.ViewTransactionsScreen:CloseTransactionButton-Pressable")
    public WebElement closeBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*BackButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*BackButton.*'")
    public WebElement backBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.RequestDetailsScreen:FieldValue-Status\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.RequestDetailsScreen:FieldValue-Status")
    public WebElement RequestDetailsScreenStatus;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*ValueText-IntegerPart*$\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*ValueText-IntegerPart.*'")
    public WebElement RTPAmount;
    @AndroidFindBy(xpath= "//android.view.ViewGroup[@resource-id=\"InternalTransfers.RequestDetailsScreen:NavHeader-BackButton\"]")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.RequestDetailsScreen:NavHeader-BackButton")
    public WebElement detaileScreenBackBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*StatusText*$\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*StatusText.*'")
    public List<WebElement> pendingRequest;
    public void clickOnRTPDone(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        tapOn(requestToPayDoneBtn);
    }
    public void clickOncConfirmRTPDoneBtn(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        tapOn(confirmRTPDoneBtn);
    }
    public void clickOncBackBtn(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        tapOn(detaileScreenBackBtn);
    }
    public void clickOnDone(){
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        tapOn(doneBtn);
    }
    public void clickBackBtn(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        tapOn(backBtn);
    }
    public void clickRTPBackBtn(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        tapOn(backBtn);
    }
    public String getRTPAmount(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return getText(RTPAmount);
    }
    public boolean isPendingRequest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        for (WebElement element : pendingRequest) {
            if (element.getText().equals("Pending")) {
                return true;
            }
        }
      return false;
    }
    public boolean getRequestStatus()
    {
        return getText(RequestDetailsScreenStatus).toLowerCase().contains("paid");
    }

}
