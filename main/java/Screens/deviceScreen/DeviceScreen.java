package Screens.deviceScreen;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DeviceScreen extends ScreenBase {
    public DeviceScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.DeviceManagementScreen:Text-0-0\")")
    @iOSXCUITFindBy(accessibility = "Settings.DeviceManagementScreen:RigisterModal")
    public WebElement RegisterDeviceBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.DeviceManagementScreen:RigisterDeviceConfirmButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Settings.DeviceManagementScreen:RigisterDeviceConfirmButton-Pressable")
    public WebElement confirmRegisterDeviceBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.DeviceManagementScreen:SectionHeaderTitle\")")
    @iOSXCUITFindBy(accessibility = "Settings.DeviceManagementScreen:SectionHeaderTitle")
    public WebElement deviceSectionHeaderTitle;
    @AndroidFindBy(uiAutomator = "resourceId(\"Settings.DeviceManagementScreen:LoginDetailsText\")")
    @iOSXCUITFindBy(accessibility = "Settings.DeviceManagementScreen:LoginDetailsText")
    public WebElement deviceLoginDetailsText;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"Settings.DeviceManagementScreen:NavHeader-BackButton\"]/com.horcrux.svg.SvgView")
    @iOSXCUITFindBy(accessibility = "Settings.DeviceManagementScreen:RigisterModal") // ToDo
    public WebElement navHeaderBackButton;

    public void RegisterDevice() {
        tapOn(RegisterDeviceBtn);
        tapOn(confirmRegisterDeviceBtn);
    }
    public void clickOnBackButton(){
        tapOn(navHeaderBackButton);

    }
}
