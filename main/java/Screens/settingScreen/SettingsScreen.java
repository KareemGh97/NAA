package Screens.settingScreen;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SettingsScreen extends ScreenBase {
    public SettingsScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(className = "android.widget.ScrollView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
    public WebElement settingScrollView;
    @AndroidFindBy(uiAutomator = "resourceId(\"Home.DashboardScreen:HeaderHomePage-BackButton\")")
    @iOSXCUITFindBy(accessibility = "Home.DashboardScreen:HeaderHomePage-BackButton")
    public WebElement homepageSettingsBackBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"^.*SettingSection-Title*$\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'SettingSection-Title'")
    public List<WebElement> settingsItems;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.CustomerAccountManagement:SignOutModal-UnRegisterDeviceButton-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Settings.CustomerAccountManagement:SignOutModal-UnRegisterDeviceButton-Pressable'")
    public WebElement unRegisterDeviceBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.CustomerAccountManagement:SignOutModal-ConfirmButton-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Settings.CustomerAccountManagement:SignOutModal-ConfirmButton-Pressable'")
    public WebElement confirmSignOutBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Passcode\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Settings.CustomerAccountManagement:SettingSection-NextIcon\"])[5]/XCUIElementTypeOther")
    public WebElement passcodeBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.CustomerAccountManagement:SettingSection-DetailStack\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Settings.CustomerAccountManagement:SettingSection-DetailStack'")
    public WebElement customizeHomeBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"Settings.CustomerAccountManagement:EditHomeConfiguration-DraggableItem-ReOrderSection-Title\" and @text=\"Invite a friend\"]")
//    @iOSXCUITFindBy(iOSNsPredicate = "")
    public WebElement inviteFriend;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"Settings.CustomerAccountManagement:EditHomeConfiguration-DraggableItem-ReOrderSection-Title\" and @text=\"Money Spend\"]")
//    @iOSXCUITFindBy(iOSNsPredicate = "")
    public WebElement moneySpend;

    public void unRegisterDevice() {
        scrollThenTapOnElementByText(settingsItems, "تسجيل الخروج", "Sign out", settingScrollView);
        tapOn(unRegisterDeviceBtn);
    }

    public void TapOncCustomizeHome() {
        scrollThenTapOnElementByText(settingsItems, "Home Section Customization", "Home Section Customization", settingScrollView);
    }

    public void changeHomeOrder() {
        dragAndDrop(inviteFriend, moneySpend);

    }

    public void signOut() {
        scrollThenTapOnElementByText(settingsItems, "تسجيل الخروج", "Sign out", settingScrollView);
        tapOn(confirmSignOutBtn);
    }

    public void clickOnBackToHomeScreen() {
        tapOn(homepageSettingsBackBtn);

    }

    public void clickOnPasscodeBtn() {
        scrollThenTapOnElementByText(settingsItems, "الرقم السري", "Passcode", settingScrollView);
    }

    public void clickOnDeviceManagementBtn() {
        if (String.valueOf(driver.getCapabilities().getPlatformName()).equalsIgnoreCase("IOS")) {
            scrollThenTapOnElementByText(settingsItems, "إدارة الجهاز", "Device Management", settingScrollView);

        } else {
            scrollThenTapOnElementByText(settingsItems, "إدارة الجهاز", "Device Management", settingScrollView);
        }
    }


}
