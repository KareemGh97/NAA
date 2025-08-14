package Screens.homeScreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomepageScreen extends ScreenBase {

    public HomepageScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"com.android.permissioncontroller:id/permission_allow_button\")")
    @iOSXCUITFindBy(accessibility = "Allow")
    public WebElement allowBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[1]")
    //@iOSXCUITFindBy()
    public WebElement integerBalanceTxt;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[2]")
    // @iOSXCUITFindBy()
    public WebElement afterDotBalanceText;
    @AndroidFindBy(uiAutomator = "resourceId(\"Home.DashboardScreen:HeaderHomePage-NavHeaderHome-BackButton\")")
    @iOSXCUITFindBy(accessibility = "Home.DashboardScreen:HeaderHomePage-NavHeaderHome-BackButton")
    public WebElement SettingsBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"com.horcrux.svg.SvgView\").instance(0)")
    @iOSXCUITFindBy(accessibility = "Home.DashboardScreen:HeaderHomePage-NavHeaderHome-BackButton")
    public WebElement ProfileBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").instance(1)")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Remind Me Later\"]")
    public WebElement RTPNotification;
    @AndroidFindBy(uiAutomator = "resourceId(\"Home.DashboardScreen:BalanceCard-AccountNumber\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Home.DashboardScreen:BalanceCard-AccountDetailsButton\"]")
    public WebElement accountNumber;

    @AndroidFindBy(uiAutomator = "resourceId(\"Home.DashboardScreen:QuickActionsSection:QuickAction\").childSelector(className(\"android.widget.TextView\"))")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Home.DashboardScreen:QuickActionsSection:QuickAction'")
    public List<WebElement> quickActions;

    @AndroidFindBy(uiAutomator = "resourceId(\"Home.HomeTabs\").childSelector(className(\"android.widget.TextView\"))")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Home.HomeTabs'")
    public List<WebElement> shortcutsTab;
    @AndroidFindBy(uiAutomator = "resourceId(\"Home.DashboardScreen:QuickActionsSection:OnEditPress\").childSelector(className(\"android.view.ViewGroup\"))")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Home.DashboardScreen:QuickActionsSection:OnEditPress'")
    public WebElement editQuickActions;

    @AndroidFindBy(uiAutomator = "resourceId(\"Home.DashboardScreen:QuickActionsReordererModal-QuickActionToggle}-QuickActionView}\").childSelector(className(\"android.widget.TextView\"))")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Home.DashboardScreen:QuickActionsReordererModal-QuickActionToggle}-QuickActionView}'")
    public List<WebElement> shortcutsElements;
    @AndroidFindBy(uiAutomator = "resourceId(\"Home.DashboardScreen:QuickActionsReordererModal-SaveButton\")")
    @iOSXCUITFindBy(accessibility = "Home.DashboardScreen:QuickActionsReordererModal-SaveButton")
    public WebElement saveButton;

    //*** account card ***//
    @AndroidFindBy(uiAutomator = "resourceId(\"Home.DashboardScreen:BalanceCard-AccountNumber\")")
//    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeOther' AND name == 'Home.DashboardScreen:BalanceCard-NavigateToAccountButton'")
    public WebElement AccountNumber;
    @AndroidFindBy(uiAutomator = "resourceId(\"Home.DashboardScreen:BalanceCard-AccountNumber\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Home.DashboardScreen:BalanceCard-AccountDetailsButton\"]")
    public WebElement NavigateToAccountBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Home.DashboardScreen:BalanceCard-ToggleAccountBalanceButton\")")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeOther' AND name == 'Home.DashboardScreen:BalanceCard-ToggleAccountBalanceButton'")
    public WebElement ToggleAccountBalanceBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Home.DashboardScreen:BalanceCard-NavigateToAccountButton\" and @label=\"********\"]")
    public WebElement BalanceAmount;
    @AndroidFindBy(uiAutomator = "resourceId(\"Home.DashboardScreen:BalanceCard-CopyNumberButton\")")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeOther' AND name == 'Home.DashboardScreen:BalanceCard-CopyNumberButton'")
    public WebElement CopyNumberBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Home.DashboardScreen:BulletinBoardSection-BulletinBoardStack\")")
    @iOSXCUITFindBy(accessibility = "Home.DashboardScreen:BulletinBoardSection-BulletinBoardStack")
    public WebElement BulletinBoardSection;
    @AndroidFindBy(uiAutomator = "resourceId(\"Home.DashboardScreen:BulletinBoardSection-ViewTasksButton\")")
    @iOSXCUITFindBy(accessibility = "Home.DashboardScreen:BulletinBoardSection-ViewTasksButton")
    public WebElement ViewTasksBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"Home.DashboardScreen:BulletinBoardSection:BulletBoardTaskItem-TaskItemMessage\" and @text=\"Add money to your account\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Home.DashboardScreen:BulletinBoardSection:BulletBoardTaskItem-TaskItemMessage\" and @label=\"Add money to your account\"]")
    public WebElement AddMoneyTaskTitle;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"Home.DashboardScreen:BulletinBoardSection:BulletBoardTaskItem-TaskItemDescription\" and @text=\"Add some money to your account to get started with Croatia.\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Home.DashboardScreen:BulletinBoardSection:BulletBoardTaskItem-TaskItemDescription\" and @label=\"Add some money to your account to get started with Croatia.\"]")
    public WebElement AddMoneyTaskDes;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Activate your card\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Home.DashboardScreen:BulletinBoardSection:BulletBoardTaskItem-TaskItemMessage\" and @label=\"Activate your card\"]")
    public WebElement ActivateCardTaskTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Choose your favorite card design for your Croatia card.\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Home.DashboardScreen:BulletinBoardSection:BulletBoardTaskItem-TaskItemDescription\" and @label=\"Choose your favorite card design for your Croatia card.\"]")
    public WebElement ActivateCardTaskDes;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Activate now\" AND name == \"Home.DashboardScreen:BulletinBoardSection:BulletBoardTaskItem-TaskActionButton\"")
    public WebElement activateBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Set your lifestyle preferences\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Home.DashboardScreen:BulletinBoardSection:BulletBoardTaskItem-TaskItemMessage\" and @label=\"Set your lifestyle preferences\"]")
    public WebElement lifestyleTaskTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Tell us what you’re into to tailor your experience.\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Home.DashboardScreen:BulletinBoardSection:BulletBoardTaskItem-TaskItemDescription\" and @label=\"Tell us what you’re into to tailor your experience.\"]")
    public WebElement lifestyleTaskDes;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Set now\"")
    public WebElement setNowBtn;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Dismiss\"")
    public WebElement dismissBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"Home.DashboardScreen:BulletinBoardSection:BulletBoardTaskItem-TaskActionButton\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'Home.DashboardScreen:BulletinBoardSection:BulletBoardTaskItem-TaskActionButton'")
    public List<WebElement> TaskActionButton;

    @AndroidFindBy(uiAutomator = "resourceId(\"android:id/parentPanel\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"You have been locked due to inactivity.\" AND name == \"You have been locked due to inactivity.\" AND value == \"You have been locked due to inactivity.\"")
    public WebElement LockedPopup;

    @AndroidFindBy(uiAutomator = "resourceId(\"android:id/button1\")")
    @iOSXCUITFindBy(accessibility = "OK")
    public WebElement LockedPopupButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.TextView[1]")
    @iOSXCUITFindBy(accessibility = "Time reminder")
    public WebElement timeReminderPopup;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.Button[1]")
    @iOSXCUITFindBy(accessibility = "Yes")
    public WebElement confirmTimeReminder;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.Button[2]")
    @iOSXCUITFindBy(accessibility = "No")
    public WebElement declineTimeReminder;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"Home.HomeTabs:HomeTab\")")
    @iOSXCUITFindBy(accessibility = "Home.HomeTabs:HomeTab")
    public WebElement homeTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"Home.HomeTabs:SpendingTab\")")
    @iOSXCUITFindBy(accessibility = "Home.HomeTabs:SpendingTab")
    public WebElement spendingTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"Home.HomeTabs:GoalGetterTab\")")
    @iOSXCUITFindBy(accessibility = "Home.HomeTabs:GoalGetterTab")
    public WebElement goalGetterTab;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"Home.DashboardScreen:QuickActionsSection:QuickAction\"])[2]")
//    @iOSXCUITFindBy(accessibility = "Home.HomeTabs:GoalGetterTab")
    public WebElement mutualFundShortCut;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"Home.HomeTabs:CardsTab\")")
    @iOSXCUITFindBy(accessibility = "Home.HomeTabs:CardsTab")
    public WebElement cardsTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"Home.HomeTabs:SupportTab\")")
    @iOSXCUITFindBy(accessibility = "Home.HomeTabs:SupportTab")
    public WebElement supportTab;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND (name CONTAINS 'Pay' OR label CONTAINS 'Pay')") //ToDo
    public WebElement pendingRequests;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").descriptionContains(\"Pay\")")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND (name CONTAINS 'Pay' OR label CONTAINS 'Pay')")
    public WebElement acceptRtpPopup;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").descriptionContains(\"Remind Me Later\")")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND (name CONTAINS 'Pay' OR label CONTAINS 'Remind Me Later')")
    public WebElement RemindMeLater;

    public void tapOnAcceptRtpPopup() {
        tapOn(pendingRequests);
        tapOn(acceptRtpPopup);
    }

    public void tapOnRemindMeLater() {
        tapOn(RemindMeLater);
    }

    public void clickOnViewTasksBtn() {
        tapOn(ViewTasksBtn);
    }

    public void clickOnSettingsBtn() {
        tapOn(SettingsBtn);
    }

    public void clickOnProfileBtn() {
        tapOn(ProfileBtn);
    }

    public void clickOnNavigateToAccountBtn() {
        tapOn(NavigateToAccountBtn);
    }

    public String getTextNavigateToAccountBtn() {
        return getText(BalanceAmount);

    }

    public void clickOnToggleAccountBalanceBtn() {
        tapOn(ToggleAccountBalanceBtn);
    }

    public void clickOnCopyNumberBtn() {
        tapOn(CopyNumberBtn);
    }

    public void clickOnLockedPopupOKButton() {
        tapOn(LockedPopupButton);
    }

    public void clickOngoalGetterTab() {
        tapOn(goalGetterTab);
    }

    public void clickOnHomeTab() {
        tapOn(homeTab);
    }

    public void clickOnMutualFundShortCut() {
        waitUntilElementAppear(mutualFundShortCut, 10);
        tapOn(mutualFundShortCut);
    }

    public void remindMeLaterRTPNotification() {
        try {
            waitUntilElementAppear(RTPNotification, 5);
            tapOn(RTPNotification);
        } catch (Exception ignored) {
        }
    }

    public void clickOnQuickActionByText(String quickActionName) {

        for (WebElement element : quickActions) {
            if (element.getText().toLowerCase().contains(quickActionName.toLowerCase())) {
                element.click();
                break;
            }
        }
    }


    public void clickOnSaveButton() {
        tapOn(saveButton);
    }

    public void clickOnShortcutsByText(String quickActionName) {

        for (WebElement element : shortcutsTab) {
            if (element.getText().equals(quickActionName)) {
                element.click();
                break;
            }
        }
    }

    public void clickOnShortcutElementByText(String quickActionName) {

        for (WebElement element : shortcutsElements) {
            if (element.getText().equals(quickActionName)) {
                element.click();
                break;
            }
        }
    }

    public void updateQuickActions() {
        tapOn(editQuickActions);

    }

    public String getAccountBalance() {
        return (integerBalanceTxt.getText() + afterDotBalanceText.getText()).replace(",", "");
    }

    public void acceptNotificationDialog() {
        try {
            waitUntilElementAppear(allowBtn, 5);
            tapOn(allowBtn);
        } catch (NoSuchElementException | TimeoutException ignored) {

        }
    }

    public void confirmTimeExtension() {
        waitUntilElementAppear(confirmTimeReminder, 10);
        tapOn(confirmTimeReminder);
    }

    public void declineTimeExtension() {
        tapOn(declineTimeReminder);
    }

    public void waitUntilSettingAppear() {
        waitUntilElementAppear(SettingsBtn, 10);
    }

    public void clickOnCardsTab() {
//        Thread.sleep(3000);
        tapOn(cardsTab);
    }


}
