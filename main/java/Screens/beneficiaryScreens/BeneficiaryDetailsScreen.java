package Screens.beneficiaryScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class BeneficiaryDetailsScreen extends ScreenBase {
    public BeneficiaryDetailsScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.BeneficiaryProfileScreen:NavHeader-BackButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.BeneficiaryProfileScreen:NavHeader-BackButton-Pressable")
    public WebElement backBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.BeneficiaryProfileScreen:ConfirmButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.BeneficiaryProfileScreen:ConfirmButton-Pressable")
    public WebElement sendMoneyBeneficiaryBtn;
    // return ios keyboard
    @iOSXCUITFindBy(accessibility = "Return")
    public WebElement iosKeyboardReturnBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.BeneficiaryProfileScreen:DeleteButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.BeneficiaryProfileScreen:DeleteButton-Pressable")
    public WebElement deleteBeneficiaryBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.BeneficiaryProfileScreen:NicknameCard-LabelText\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.BeneficiaryProfileScreen:NicknameCard-LabelText")
    public WebElement nickNameTxt;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.BeneficiaryProfileScreen:DeleteBeneficiaryModalConfirmButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.BeneficiaryProfileScreen:DeleteBeneficiaryModalConfirmButton-Pressable")
    public WebElement confirmDeleteBeneficiaryBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.BeneficiaryProfileScreen:NicknameCard-RightIconPressable\")")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.BeneficiaryProfileScreen:NicknameCard-RightIconPressable")
    public WebElement editNickNameBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"InternalTransfers.EditNickNameModalScreen:NicknameInput-Stack\").childSelector(className(\"android.widget.EditText\"))")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EditNickNameModalScreen:NicknameInput")
    public WebElement editNickNameEt;
    @AndroidFindBy(className = "android.widget.Button")
    @iOSXCUITFindBy(accessibility = "InternalTransfers.EditNickNameModalScreen:SaveButton-Pressable")
    public WebElement saveBtn;
    @AndroidFindBy(className = "android.widget.ScrollView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
    public WebElement listScrollView;

    public void deleteBeneficiary(){
        tapOn(deleteBeneficiaryBtn);
        tapOn(confirmDeleteBeneficiaryBtn);
    }
    public void backToTransferScreen(){
        tapOn(backBtn);
    }

    public void editNickname(String nickname){
        tapOn(editNickNameBtn);
        typingTextIn(editNickNameEt,nickname);
        String platformName = String.valueOf(driver.getCapabilities().getPlatformName());

        if (platformName.equals("IOS")) {
            tapOn(iosKeyboardReturnBtn);
        }
        tapOn(saveBtn);
    }

    public void sendMoneyBeneficiaryBtn(){
        ScreenBase.ThreadSleep(10000);
        waitUntilElementAppear(listScrollView,15);
        ScreenBase.ThreadSleep(2000);
        verticalScroll(listScrollView,0.8,0.2);
        waitUntilElementAppear(sendMoneyBeneficiaryBtn,15);
        System.out.println("Enabled: " + sendMoneyBeneficiaryBtn.isEnabled());
        System.out.println("Displayed: " + sendMoneyBeneficiaryBtn.isDisplayed());

        System.out.println("Content-desc: " + sendMoneyBeneficiaryBtn.getAttribute("content-desc"));
        //callTest1();
        ScreenBase.ThreadSleep(5000);
        if (sendMoneyBeneficiaryBtn.isDisplayed() && sendMoneyBeneficiaryBtn.isEnabled()) {
            sendMoneyBeneficiaryBtn.click(); // Or your tapOn equivalent
            System.out.println(" **** It clicked the Send Money Button :" );
        } else {
            System.out.println("Element is not displayed or enabled.");
        }


        tapOn(sendMoneyBeneficiaryBtn);

        System.out.println("Content-desc: " + sendMoneyBeneficiaryBtn.getAttribute("content-desc"));
        System.out.println(" control 3 is coming!");
    }

    //public void call1
}
