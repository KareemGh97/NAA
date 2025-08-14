package Screens.transferScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TransferDetailsScreen extends ScreenBase {
    public TransferDetailsScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
//    @AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"CroatiaMobileApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
//    public WebElement ipsScreenContainer;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"CroatiaMobileApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    public WebElement screenContainer;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*Button-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*Button-Pressable.*'")
    public WebElement sendMoneyBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.BeneficiaryProfileScreen:ConfirmButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.BeneficiaryProfileScreen:ConfirmButton-Pressable")
    public WebElement activeBeneficiaryConfirmBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.BeneficiaryProfileScreen:ConfirmButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.BeneficiaryProfileScreen:ConfirmButton-Pressable")
    public WebElement InactiveBeneficiarySendMoneyBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.RequestDetailsScreen:ConfirmRequestHeader\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.RequestDetailsScreen:ConfirmRequestHeader")
    public WebElement confirmRequestScreenTitle;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.RequestDetailsScreen:DaysButtonStack\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.RequestDetailsScreen:DaysButtonStack")
    public WebElement RequestExpiryIntervalList;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.RequestDetailsScreen:PrimaryButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.RequestDetailsScreen:PrimaryButton-Pressable")
    public WebElement confirmRequestMoneyBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.RequestDetailsScreen:DaysModal-SelectButtonView-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.RequestDetailsScreen:DaysModal-SelectButtonView-Pressable")
    public WebElement selectDayBtn;
    @AndroidFindBy(uiAutomator = "className(\"android.view.ViewGroup\").childSelector(className(\"android.widget.TextView\"))")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeScrollView/**/XCUIElementTypeOther/**/XCUIElementTypeOther/**/XCUIElementTypeOther")
    public List<WebElement> RequestDays;
    @AndroidFindBy(className = "android.widget.ScrollView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
    public WebElement listScrollView;

    public void selectItem(String item) {
        scrollThenTapOnElementByText(RequestDays,"الاسم بالعربي",item,listScrollView);
    }
    public void confirmSendMoney()  {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        verticalScroll(listScrollView,0.8,0.2);
        tapOn(sendMoneyBtn);
    }
    public void inactiveBeneficiaryConfirmSendMoney(){
        tapOn(InactiveBeneficiarySendMoneyBtn);
    }

    public void activeBeneficiaryConfirmBtn(){
        tapOn(activeBeneficiaryConfirmBtn);
    }

    public void confirmRequestMoney(String days) {
        waitUntilElementAppear(confirmRequestScreenTitle,15);
        ScreenBase.ThreadSleep(3000);
        verticalScroll(listScrollView,0.8,0.2);
        tapOn(RequestExpiryIntervalList);
        selectItem(days);
        tapOn(selectDayBtn);
        tapOn(confirmRequestMoneyBtn);
    }
}
