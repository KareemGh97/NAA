package Screens.transferScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class AccountFinderScreen extends ScreenBase {
    public AccountFinderScreen (AppiumDriver appiumDriver){
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"InternalTransfers.TransfersLandingScreen:TransferServices-AccountFinderButton\").instance(1)")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"InternalTransfers.TransfersLandingScreen:TransferServices-AccountFinderButton\" and @label=\"Account Finder\"]")
    public WebElement accountFinderBtn;
    @AndroidFindBy(xpath = "//android.widget.Button[android.widget.TextView[@text='Activate']]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement activateBtn;
    @AndroidFindBy(xpath = "//android.widget.Button[android.widget.TextView[@text='Confirm']]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirm\"]")
    public WebElement confirmBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*IVRSuccessModal.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*IVRSuccessModal.*'")
    public WebElement successfullyTxt;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*CloseButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*CloseButton.*'")
    public WebElement CloseButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*InquireButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*InquireButton.*'")
    public WebElement inquiryBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Account finder is disabled\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Account finder is disabled\"]")
    public WebElement accountFinderIsDisabledTxt;


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*BankParticipantCard.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*BankParticipantCard.*'")
    public WebElement bankParticipantCardTxt;

    public boolean isAccountFinderIsDisabledTxtDisplayed (){
        try {
            return accountFinderIsDisabledTxt.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isConfirmBtnDisplayed (){
        try {
            return confirmBtn.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isSuccessfullyTxtDisplayed (){
        try {
            return successfullyTxt.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void tapOnCloseButton (){
        tapOn(CloseButton);
    }

    public boolean isBankParticipantCardTxtDisplayed (){
        try {
            return bankParticipantCardTxt.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void tapOnAccountFinderBtn (){
        tapOn(accountFinderBtn);
    }

    public void tapOnActivateBtn (){
        tapOn(activateBtn);
    }
    public void tapOnConfirmBtn (){
        tapOn(confirmBtn);
    }
    public void tapOnInquiryBtn (){tapOn(inquiryBtn);}
}
