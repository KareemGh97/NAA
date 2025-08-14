package Screens.homeScreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class LockScreen extends ScreenBase{
    public LockScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(uiAutomator = "resourceId(\"SignIn.UserPermanentBlockScreen:Heading\")")
    @iOSXCUITFindBy(accessibility = "SignIn.UserPermanentBlockScreen:Heading")
    public WebElement headingTxt;
    @AndroidFindBy(uiAutomator = "resourceId(\"SignIn.UserPermanentBlockScreen:Message\")")
    @iOSXCUITFindBy(accessibility = "SignIn.UserPermanentBlockScreen:Message")
    public WebElement messageTxt;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Your account is locked We've locked your account to keep it secure. To unlock it, you can reset your passcode. Reset your passcode\"`][4]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    public WebElement backFromBlockScreenBt;
}
