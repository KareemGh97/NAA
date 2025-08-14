package Screens.goalGetterScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SavingGoalScreen extends ScreenBase {
    public SavingGoalScreen (AppiumDriver appiumDriver){
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.SavingsGoalsScreen:CreateButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SavingsGoals.SavingsGoalsScreen:CreateButton-Pressable")
    public WebElement CreateGoalBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.CreateGoalScreen:GoalNameInput\")")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name == 'SavingsGoals.CreateGoalScreen:GoalNameInput'")
    public WebElement SavingsGoalsField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Goal name\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name == 'SavingsGoals.CreateGoalScreen:GoalNameInput'")
    public WebElement SavingsGoalsTxt;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.CreateGoalScreen:TargetAmountInput\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Goal amount\"]")
    public WebElement GoalAmountField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"SavingsGoals.CreateGoalScreen:TargetAmountInput\"]")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeOther[@name=\"Goal amount 0.00 SAR\"]")
    public WebElement GoalAmountTxt;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.EditGoalModal:GoalNameInput-TextInput\")")
    @iOSXCUITFindBy(accessibility = "SavingsGoals.EditGoalModal:GoalNameInput-Pressable")
    public WebElement editGoalNameBtnTxt;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(21)")
    @iOSXCUITFindBy(accessibility ="SavingsGoals.EditGoalModal:GoalNameInput-Pressable")
    public WebElement editGoalNameField;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(23)")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Amount SAR\"]")
    public WebElement editGoalBtnField;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.EditGoalScreen:TargetAmountInput\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Amount SAR\"]")
    public WebElement editGoalBtnTxt;
    @AndroidFindBy(uiAutomator = "resourceId(\"SavingsGoals.CreateGoalScreen:TargetDateInput-Input-DatePickerButton\")")
    @iOSXCUITFindBy(accessibility = "SavingsGoals.CreateGoalScreen:TargetDateInput-Input-DatePickerButton")
    public WebElement CompleteByDatBtn;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"SavingsGoals.CreateGoalScreen:TargetDateInput-Input-DatePicker-DurationItemPill-Pressable\" and @label=\"6 months\"]")
    public WebElement sixMonthsBtn;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"SavingsGoals.CreateGoalScreen:TargetDateInput-Input-DatePicker-DurationItemPill-Pressable\" and @label=\"12 months\"]")
    public WebElement twelveMonthsBtn;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"SavingsGoals.CreateGoalScreen:TargetDateInput-Input-DatePicker-DurationItemPill-Pressable\" and @label=\"24 months\"]")
    public WebElement twentyFourMonthsBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SavingsGoals.CreateGoalScreen:TargetDateInput-Input-DatePickerConfirmButton-Pressable\"]")
    public WebElement PickDateBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.FundGoalModal:CancelButton-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'SavingsGoals.FundGoalModal:CancelButton-Pressable'")
    public WebElement NotNowBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.FundGoalModal:SubmitButton-Button-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'SavingsGoals.FundGoalModal:SubmitButton-Button-Pressable'")
    public WebElement RecurringPaymentSubmitBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.GoalDetailsScreen:AvailableBalanceAmount\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'SavingsGoals.GoalDetailsScreen:AvailableBalanceAmount'")
    public WebElement SavingsGoalsAvailableBalanceAmount;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup")
    @iOSXCUITFindBy(iOSNsPredicate = "(//XCUIElementTypeOther[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther")
    public WebElement youHaveWithdrawnMsg;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.CreateGoalScreen:SubmitButton-Button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SavingsGoals.CreateGoalScreen:SubmitButton-Button-Pressable")
    public WebElement CreateGoalScreenSubmitBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.GoalDetailsScreen:NavHeader-IconButton\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'SavingsGoals.GoalDetailsScreen:NavHeader-IconButton'")
    public WebElement editGoalBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"SavingsGoals.EditGoalModal:CloseButton\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'SavingsGoals.EditGoalModal:CloseButton'")
    public WebElement closeBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.FundGoalModal:ConfirmModal-ParentModal-CloseButton\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'SavingsGoals.FundGoalModal:ConfirmModal-ParentModal-CloseButton'")
    public WebElement ConfirmModalCloseBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.EditGoalModal:ConfirmButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "SavingsGoals.EditGoalModal:ConfirmButton-Pressable")
    public WebElement ConfirmBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*Title*$\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*Title.*'")
    public List<WebElement> GoalsList;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*SavingsGoals.SavingsGoalsScreen:GoalCard->goal.*$\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*SavingsGoals.SavingsGoalsScreen:GoalCard->goal.*'")
    public List<WebElement> createdGoalsList;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*SaveButton-Button-Pressable$\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'SaveButton-Button-Pressable'")
    public WebElement saveEditBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.SavingsGoalsScreen:NavHeader-BackButton\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Your saving pots\"]")
    public WebElement GoalsPage;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.SavingsGoalsScreen:NavHeader-BackButton\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Your goals\"]")
    public WebElement yourGoalsPage;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.FundGoalModal:RecurringPaymentsButton\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'SavingsGoals.FundGoalModal:RecurringPaymentsButton'")
    public WebElement RecurringPaymentsBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.FundGoalModal:CurrencyInput-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'SavingsGoals.FundGoalModal:CurrencyInput-Pressable'")
    public WebElement amountBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.WithdrawGoalModal:PaymentAmountInput-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'SavingsGoals.WithdrawGoalModal:PaymentAmountInput-Pressable'")
    public WebElement paymentAmountInputBtn;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"CroatiaMobileApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    public WebElement screenContainer;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.GoalDetailsScreen:AddMoneyButton-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'SavingsGoals.GoalDetailsScreen:AddMoneyButton-Pressable'")
    public WebElement AddMoneyBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.GoalDetailsScreen:WithdrawButton-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'SavingsGoals.GoalDetailsScreen:WithdrawButton-Pressable'")
    public WebElement WithdrawBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.WithdrawGoalModal:WithdrawButton-Button-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'SavingsGoals.WithdrawGoalModal:WithdrawButton-Button-Pressable'")
    public WebElement confirmWithdrawBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SavingsGoals.FundGoalModal:ConfirmSkipButton-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'SavingsGoals.FundGoalModal:ConfirmSkipButton-Pressable'")
    public WebElement ConfirmSkipBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(21)")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"SavingsGoals.SavingsGoalsScreen:GoalCard->goal1\"]")
    public WebElement relatedGoal;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*GoalInformationText.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*GoalInformationText.*'")
    public WebElement GoalPhotoText;
    @iOSXCUITFindBy(accessibility = "GoalGetter.EditGoalScreen:SetUpContributionText")
    public WebElement SetUpContributionText;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Return\"]")
    public WebElement returnTap;
    private static ThreadLocal<List<WebElement>> threadLocalGoalsList = ThreadLocal.withInitial(ArrayList::new);
    public void setCreatedGoalsList() {
        threadLocalGoalsList.set(createdGoalsList);
    }
    public List<WebElement> getCreatedGoalsList() {
        return threadLocalGoalsList.get();
    }
    public void tabOnRecurringPaymentsBtn (){
        tapOn(RecurringPaymentsBtn);
    }

    public void tabOnAmountBtn (){
        tapOn(amountBtn);
    }

    public void tabOnPaymentAmountInputBtn (){
        tapOn(paymentAmountInputBtn);
    }

    public void tabOnConfirmWithdrawBtn (){
        tapOn(confirmWithdrawBtn);
//        tapOn(confirmWithdrawBtn);
    }

    public void tabOnConfirmModalCloseBtn (){
        tapOn(ConfirmModalCloseBtn);
    }

    public void tabOnWithdrawBtn (){
        tapOn(WithdrawBtn);
    }

    public void tabOnAddMoneyBtn (){
        tapOn(AddMoneyBtn);
    }

    public void tabOnYouHaveWithdrawnMsg (){
        tapOn(youHaveWithdrawnMsg);
    }

    public void tabOnSaveEditBtn (){
        tapOn(saveEditBtn);
    }
    public void tapOnReturnTap (){
        if(driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("ios"))
        {
            tapOn(returnTap);

        }
    }
    public void userEnterGoalDetails (String GoalsTxt,String AmountTxt,String months){
        tapOn(SavingsGoalsField);
        typingTextIn(SavingsGoalsTxt,GoalsTxt);
        tapOn(GoalAmountField);
        typingTextIn(GoalAmountTxt,AmountTxt);
        tapOn(CompleteByDatBtn);
        try {
            tapOn(CompleteByDatBtn);
            switch (months.charAt(0) + months.charAt(1) + "") {
                case "24" -> tapOn(twentyFourMonthsBtn);
                case "12" -> tapOn(twelveMonthsBtn);
                default -> tapOn(sixMonthsBtn);
            }
        } catch (Exception ignored) {
        }
        tapOn(PickDateBtn);
    }

    public void tabOnCreateGoalBtn (){
        tapOn(CreateGoalBtn);
    }

    public void tabOnCreateGoalScreenSubmitBtn (){
        waitUntilElementAppear(screenContainer,15);
        verticalScroll(screenContainer,0.8,0.2);
        tapOn(CreateGoalScreenSubmitBtn);
    }

    public void tabOnSubmitBtn (){
        tapOn(RecurringPaymentSubmitBtn);
//        tapOn(RecurringPaymentSubmitBtn);
    }

    public void tabOnNotNowBtn (){
        tapOn(NotNowBtn);
    }

    public void deleteGoal (String goalName){
        tapOn(relatedGoal);
        tapOn(editGoalBtn);
        ScreenBase.ThreadSleep(9000);
        tapOn(closeBtn);
        tapOn(ConfirmBtn);
    }

    public void editAmount (String amount){
        tapOn(editGoalBtnField);
        typingTextIn(editGoalBtnTxt,amount);
    }
    public void editGoalName (String name){
        tapOn(editGoalNameField);
        typingTextIn(editGoalNameBtnTxt,name);
    }

    public void tabOnEditGoalBtn (){
        tapOn(relatedGoal);
        tapOn(editGoalBtn);
    }
    public void tabOnEditIcon (){
        tapOn(editGoalBtn);
    }
    public void tapOnCloseBtn(){tapOn(closeBtn);}
    public void tapOnConfirmBtn(){tapOn(ConfirmBtn);}
    public void tabOnAnyOfTheFourthGoals (int goalNumber){
        tapOn(threadLocalGoalsList.get().get(goalNumber));
    }
    public void tapOnScreen()
    {
        if(driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("ios"))
        {
            tapOn(GoalPhotoText);
        }
    }
    public void tapOnSetUpContributionText()
    {
        if(driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("ios"))
        {
            tapOn(SetUpContributionText);
        }

    }
    public void RecurringPaymentsAmount (String amount){
        switch (driver.getCapabilities().getPlatformName()) {
            case ANDROID -> {

                AndroidDriver androidDriver = (AndroidDriver) driver;
                if(amount.equalsIgnoreCase("delete")){
                    for (int i = 0; i <4; i++) {
                        androidDriver.pressKey(new KeyEvent(AndroidKey.DEL));
                    }
                    break;
                }

                for (int i = 0; i < amount.length(); i++) {
                    char digit = amount.charAt(i);
                    if(digit >= '0' && digit <= '9') {
                        int offset = digit - '0';
                        AndroidKey androidKey = AndroidKey.valueOf("DIGIT_" + offset);
                        androidDriver.pressKey(new KeyEvent(androidKey));
                    } else if(digit == '.') {
                        androidDriver.pressKey(new KeyEvent(AndroidKey.PERIOD));
                    }
                }
                androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
            }
            case IOS -> {

                IOSDriver iosDriver = (IOSDriver) driver;
//                iosDriver.findElement(By.id("Done")).click();

                if(amount.equalsIgnoreCase("delete")){
                    for (int i = 0; i <4; i++) {
                        iosDriver.findElement(By.xpath("//XCUIElementTypeKey[@name=\"Delete\"]")).click();
                    }
                    break;
                }
                for (int i = 0; i < amount.length(); i++) {
                    char digit = amount.charAt(i);
                    if(Character.isDigit(digit)) {
                        iosDriver.findElement(By.id(Character.toString(digit))).click();
                    } else if(digit == '.') {
                        iosDriver.findElement(By.xpath("//XCUIElementTypeKey[@name=\".\"]")).click();
                    }
                }
                try {
                    iosDriver.findElement(By.id("Done")).click();
                } catch (NoSuchElementException ignored) {
                    System.out.println("No Done option available on the key pad of iOS");
                }
            }
            default -> System.out.println("Invalid platform");
        }
    }

    public void tabOnConfirmSkipBtn (){
        tapOn(ConfirmSkipBtn);
    }
}
