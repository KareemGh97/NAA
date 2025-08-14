package Screens.goalGetterScreens;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.*;

import java.util.List;

public class SavingPotsScreen extends ScreenBase {

    public SavingPotsScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(className = "android.widget.ScrollView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
    public WebElement listScrollView;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"Home.HomeTabs:GoalGetterTab\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Home.HomeTabs:GoalGetterTab'")
    public WebElement goalGetterTabBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*ConfirmButton-Pressable*$\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*ConfirmButton-Pressable.*'")
    public WebElement savingPotConfirmBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.GoalGetterScreen:CreateGoalButton-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.GoalGetterScreen:CreateGoalButton-Pressable'")
    public WebElement firstCreateGoalBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.GoalDashboardScreen:NavHeader-IconButton\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.GoalDashboardScreen:NavHeader-IconButton'")
    public WebElement createGoalBtn;


    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Unknown\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.ShapeGoalScreen:GoalDurationOptionsPill-Text' AND label == 'Unknown'")
    public WebElement UnknownBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*ContinueButton-Pressable*$\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*ContinueButton-Pressable.*'")
    public WebElement continueBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*RiskType-0.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*RiskType-0.*'")
    public WebElement noRiskBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.ShapeYourGoalScreen:ProductList-ProductItem-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.ShapeYourGoalScreen:ProductList-ProductItem-Pressable'")
    public WebElement savingPotBtn;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout//android.widget.ScrollView")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Vertical scroll bar, 2 pages'")
    public WebElement scrollView;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"^.*SkipNowButton-Pressable*$\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*SkipNowButton-Pressable.*'")
    public WebElement skipForNowBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"^.*CalendarButton*$\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*CalendarButton.*'")
    public WebElement calendarBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*ContributionSavingPotScreen:CalenderDayModal-Calendar\\.day_.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*CalenderDayModal-Calendar\\.day_.*'")
    public WebElement calendarDay;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*Button-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*Button-Pressable.*'")
    public WebElement selectDateButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*SubmitButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*SubmitButton.*'")
    public WebElement submitButton;

    //page two where the user select a name and a pic for his goal
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"^.*PhotoInput-MainView.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*PhotoInput-MainView.*'")
    public WebElement PhotoInputButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"^.*PredefinedPressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*PredefinedPressable.*'")
    public WebElement PredefinedOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"^.*GalleryImage-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*GalleryImage-Pressable.*'")
    public WebElement Image;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"^.*SelectImageButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*SelectImageButton.*'")
    public WebElement selectImageButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.GoalReviewScreen:GoalName-Value\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.GoalReviewScreen:GoalName-Value'")
    public WebElement SavingPotNameTxt;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.GoalReviewScreen:TermsAndConditions-CheckboxInput\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.GoalReviewScreen:TermsAndConditions-CheckboxInput'")
    public WebElement savingPotCheckBox;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*ConfirmButton-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*ConfirmButton-Pressable.*'")
    public WebElement ConfirmBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.GoalCreatedSuccessfullyScreen:Button-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.GoalCreatedSuccessfullyScreen:Button-Pressable'")
    public WebElement CheckItOutBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"^.*GoalGetter.GoalDashboardScreen:GoalCard-Name*$\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'GoalGetter.GoalDashboardScreen:GoalCard-Name'")
    public List<WebElement> goalGetterGoalsList;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.GoalsHubScreen:AddMoneyPressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.GoalsHubScreen:AddMoneyPressable'")
    public WebElement addMoney;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*CurrencyInput-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*CurrencyInput-Pressable.*'")
    public WebElement amountBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.GoalsHubScreen:NavHeader-IconButton\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.GoalsHubScreen:NavHeader-IconButton'")
    public WebElement goalOptionsBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.GoalManagementDetails:EndAndKeepProducts-Item\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.GoalManagementDetails:EndAndKeepProducts-Item'")
    public WebElement endAndKeepProductBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.GoalManagementDetails:List-Stack\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.GoalManagementDetails:Item-Label'")
    public WebElement editGoalBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.EditGoalScreen:SmallTextInput\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.EditGoalScreen:SmallTextInput'")
    public WebElement editGoalNameTxt;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*CurrencyInput.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*CurrencyInput.*'")
    public WebElement editGoalAmountTxt;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.EditGoalScreen:ContributionMethodDropDown-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.EditGoalScreen:ContributionMethodDropDown-Pressable'")
    public WebElement contributionMethodDropDown;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.EditGoalScreen:ContributionMethodModal-RecurringSection-CheckBoxView\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.EditGoalScreen:ContributionMethodModal-RecurringSection-CheckBoxView'")
    public WebElement recurringSectionCheckBoxView;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.EditGoalScreen:ContributionAmountInput\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"GoalGetter.EditGoalScreen:ContributionAmountView\"]/XCUIElementTypeOther\n")
    public WebElement contributionAmountInputTxt;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.EditGoalScreen:RecurringFrequencyDropDown-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.EditGoalScreen:RecurringFrequencyDropDown-Pressable'")
    public WebElement recurringFrequencyDropDown;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.EditGoalScreen:RecurringFrequencyModal-RadioButton\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.EditGoalScreen:RecurringFrequencyModal-RadioButton'")
    public WebElement RecurringFrequencyBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.EditGoalScreen:BottomSheetModal-View\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.EditGoalScreen:BottomSheetModal-View'")
    public WebElement selectRecurringDayBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.EditGoalScreen:BottomSheetModal-LablePressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.EditGoalScreen:BottomSheetModal-LablePressable'")
    public WebElement selectDayOfRecurringBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*ContinueButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*ContinueButton.*'")
    public WebElement editGoalContinueBtn;

    //    ---------------------------- Goal summary ----------------------------      //

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*ProceedButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*ProceedButton.*'")
    public WebElement proceedWithoutChangesBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*EditGoalSummaryModal.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*EditGoalSummaryModal.*'")
    public WebElement goalSummaryTxt;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*TargetAmount-IntegerPart-IntegerPart.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*TargetAmount-IntegerPart-IntegerPart.*'")
    public WebElement summaryTargetAmountTxt;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*ContributionAmount-IntegerPart.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*ContributionAmount-IntegerPart.*'")
    public WebElement summaryContributionAmountTxt;

    //    ---------------------------- end of goal summary ----------------------------      //

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*DoneButton-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*DoneButton-Pressable.*'")
    public WebElement endGoalBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.CollectSummaryScreen:EndGoalText\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.CollectSummaryScreen:EndGoalText'")
    public WebElement endGoalTxt;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*Pressable.*'")
    public WebElement viewProductBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.GoalDashboardScreen:ProductSegmentedItem-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.GoalDashboardScreen:ProductSegmentedItem-Pressable'")
    public WebElement productsTap;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.GoalManagementSuccessfulScreen:ViewGoalOrProductButton-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.GoalManagementSuccessfulScreen:ViewGoalOrProductButton-Pressable'")
    public WebElement ViewGoalBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.GoalSummaryScreen:CollectButton-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.GoalSummaryScreen:CollectButton-Pressable'")
    public WebElement collectBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.GoalsHubScreen:CollectButton\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.GoalsHubScreen:CollectButton'")
    public WebElement collectPotBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.GoalsHubScreen:ExtendPressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.GoalsHubScreen:ExtendPressable'")
    public WebElement extendYourGoalBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*CalenderButton.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*CalenderButton.*'")
    public WebElement selectDateBtn;

    @AndroidFindBy(className = "android.widget.Button")
    @iOSXCUITFindBy(className = "XCUIElementTypeButton")
    public WebElement setDateBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.ExtendGoalScreen:UpdateDateButton-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.ExtendGoalScreen:UpdateDateButton-Pressable'")
    public WebElement updateDateBtn;


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.GoalDashboardScreen:SavingPot:ProductCardPressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.GoalDashboardScreen:SavingPot:ProductCardPressable'")
    public WebElement savingPotProductsTapBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.ExtendGoalScreen:DropDownFieldContainer-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.ExtendGoalScreen:DropDownFieldContainer-Pressable'")
    public WebElement selectContributionMethodBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.ExtendGoalScreen:ContributionMethodModal-RecurringSection-CheckBoxView\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.ExtendGoalScreen:ContributionMethodModal-RecurringSection-CheckBoxView'")
    public WebElement recurringBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.ExtendGoalScreen:ContributionAmountView\").childSelector(className(\"android.view.ViewGroup\"))")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"GoalGetter.ExtendGoalScreen:ContributionAmountView\"`]/XCUIElementTypeOther")
    public WebElement contributionAmountView;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.ExtendGoalScreen:ContributionAmountButton-Recurring\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.ExtendGoalScreen:ContributionAmountButton-Recurring'")
    public WebElement selectRecurringFrequency;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.ExtendGoalScreen:RecurringFrequencyModal-RadioButton\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.ExtendGoalScreen:RecurringFrequencyModal-RadioButton'")
    public WebElement monthlyRadio;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.ExtendGoalScreen:UpdateGoalButton-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.ExtendGoalScreen:UpdateGoalButton-Pressable'")
    public WebElement UpdateBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.ExtendGoalScreen:RecurringFrequency-SelectDay-View\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.ExtendGoalScreen:RecurringFrequency-SelectDay-View'")
    public WebElement selectDayBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.ExtendGoalScreen:RecurringFrequency-SelectDay-LablePressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.ExtendGoalScreen:RecurringFrequency-SelectDay-LablePressable'")
    public WebElement DayBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"^.*SelectButton-Pressable*$\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*SelectButton-Pressable.*'")
    public WebElement selectBtn;

//    -------------------- Goal summary extend confirm --------------------      //

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*ContributionAmount-IntegerPart-IntegerPart.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*ContributionAmount-IntegerPart-IntegerPart.*'")
    public WebElement contributionAmountTxt;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*RecurringType-ValueText.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*RecurringType-ValueText.*'")
    public WebElement recurringTypeValueText;


    //    ---------------------------- Goal page ----------------------------      //
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.GoalsHubScreen:ProductAvailableBalance\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.GoalsHubScreen:ProductAvailableBalance'")
    public WebElement goalCurrentValue;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*CurrencyText-IntegerPart.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*CurrencyText-IntegerPart.*'")
    public WebElement goalTargetAmount;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"GoalGetter.GoalDashboardScreen:GoalCard-InfoStack\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GoalGetter.GoalDashboardScreen:GoalCard-InfoStack'")
    public WebElement targetGoal;

    public void tapOnGoalGetterTabBtn() {
        tapOn(goalGetterTabBtn);
    }

    public boolean isFirstCreateGoalBtnDisplayed() {
        try {
            return firstCreateGoalBtn.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @iOSXCUITFindBy(accessibility = "GoalGetter.EditGoalScreen:GoalPhotoText")
    public WebElement GoalPhotoText;

    @AndroidFindBy(className = "android.widget.ScrollView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
    public WebElement fullScreenContainer;

    public void tapOnFirstCreateGoalBtn() {
        tapOn(firstCreateGoalBtn);
    }

    public void tapOnCreateGoalBtn() {
        tapOn(createGoalBtn);
    }

    public void tapOnUnknownBtn() {
        tapOn(UnknownBtn);
    }

    public void tapOnNoRiskBtn() {
        tapOn(noRiskBtn);
    }

    public void tapOnSavingPotBtn() {
        verticalScroll(scrollView, 0.9, 0.1);
        tapOn(savingPotBtn);
    }

    public void tapOnSkipForNowBtn() {
        tapOn(skipForNowBtn);
    }

    public void tapOnCalendarBtn() {
        tapOn(calendarBtn);
    }

    public void tapOnCalendarDay() {
        tapOn(calendarDay);
    }

    public void tapOnSelectDateButton() {
        tapOn(selectDateButton);
    }

    public void tapOnSubmitButton() {
        tapOn(submitButton);
    }

    public void tapOnPhotoButton() {
        tapOn(PhotoInputButton);
    }

    public void tapOnPredefinedOption() {
        tapOn(PredefinedOption);
    }

    public void tapOnImage() {
        tapOn(Image);
    }

    public void tapOnSelectImageButton() {
        tapOn(selectImageButton);
    }

    public void tapOnSavingPotCheckBox() {
        tapOn(savingPotCheckBox);
    }

    public void tapOnConfirmBtn() {
        tapOn(ConfirmBtn);
    }

    public void tapOnCheckItOutBtn() {
        tapOn(CheckItOutBtn);
    }

    public void tapOnAddMoney() {
        tapOn(addMoney);
        tapOn(amountBtn);// as the keypad not shown will press the screen
    }


    public void deleteSavingPot(String goalName) {
        for (WebElement element : goalGetterGoalsList) {
            if (element.getText().equalsIgnoreCase(goalName)) {
                tapOn(element);
                break;
            }
        }
        tapOn(goalOptionsBtn);
        tapOn(endAndKeepProductBtn);
        tapOn(endGoalBtn);
        tapOn(ConfirmBtn);

    }

    public void tapOnGoalGetterGoalsList(String goalName) {
        tapOn(targetGoal);
//        for (WebElement element : goalGetterGoalsList) {
//            if(element.getText().equalsIgnoreCase(goalName)) {
//                tapOn(element);
//                break;
//            }
//        }
    }

    public void tapOnViewGoalBtn() {
        tapOn(ViewGoalBtn);
    }

    public void tapOnGoalOptionsBtn() {
        tapOn(goalOptionsBtn);
    }

    public void tapOnEndAndKeepProductBtn() {
        tapOn(endAndKeepProductBtn);
    }

    public void tapOnEditGoalBtn() {
        tapOn(editGoalBtn);
    }

    public void tapOnEditGoalAmountTxt() {
        tapOn(editGoalAmountTxt);
    }

    public void tapOnContributionMethodDropDown() {
        verticalScroll(listScrollView, 0.9, 0.1);
        tapOn(contributionMethodDropDown);
    }

    public void tapOnRecurringFrequencyDropDown() {
        tapOn(recurringFrequencyDropDown);
    }

    public void tapOnRecurringFrequencyBtn() {
        tapOn(RecurringFrequencyBtn);
    }

    public void tapOnSelectRecurringDayBtn() {
        tapOn(selectRecurringDayBtn);
    }

    public void tapOnSelectDayOfRecurringBtn() {
        tapOn(selectDayOfRecurringBtn);
    }

    public void tapOnEditGoalContinueBtn() {
        verticalScroll(listScrollView, 0.9, 0.1);
        tapOn(editGoalContinueBtn);
    }

    public void tapOnRecurringSectionCheckBoxView() {
        tapOn(recurringSectionCheckBoxView);
    }

    public void tapOnContributionAmountInputTxt() {
        verticalScroll(listScrollView, 0.9, 0.1);
        tapOn(contributionAmountInputTxt);
    }

    public void tapOnEndGoalBtn() {
        tapOn(endGoalBtn);
    }

    public void tapOnViewProductBtn() {
        tapOn(viewProductBtn);
    }

    public boolean isProductsTapDisplayed() {
        return productsTap.isDisplayed();
    }

    public void tapOnSavingPotProductsTapBtn() {
        tapOn(savingPotProductsTapBtn);
    }

    public void tapOnExtendYourGoalBtn() {
        tapOn(extendYourGoalBtn);
    }

    public void tapOnSelectDateBtn() {
        tapOn(selectDateBtn);
    }

    public void tapOnSetDateBtn() {
        tapOn(setDateBtn);
    }

    public void tapOnUpdateDateBtn() {
        tapOn(updateDateBtn);
    }

    public void tapOnCollectPotBtn() {
        tapOn(collectPotBtn);
    }

    public void tapOnCollectBtn() {
        verticalScroll(fullScreenContainer, 0.9, 0.1);
        tapOn(collectBtn);
    }

    public void tapOnSelectContributionMethod() {
        tapOn(selectContributionMethodBtn);
    }

    public void tapOnRecurring() {
        tapOn(recurringBtn);
    }

    public void tapOnContinue() {
        tapOn(continueBtn);
    }

    public void tapOnContributionAmount() {
        tapOn(contributionAmountView);
    }

    public void tapOnSelectRecurringFrequency() {
        tapOn(selectRecurringFrequency);
    }

    public void tapOnMonthly() {
        tapOn(monthlyRadio);
    }

    public void tapOnSelect() {
        tapOn(selectBtn);
    }

    public void tapOnUpdate() {
        tapOn(UpdateBtn);
    }

    public void tapOnConfirm() {
        tapOn(savingPotConfirmBtn);
    }

    public void tapOnSelectDayBtn() {
        tapOn(selectDayBtn);
    }

    public void tapOnDayBtn() {
        tapOn(DayBtn);
    }

    public void tapOnProceedWithoutChangesBtn() {
        tapOn(proceedWithoutChangesBtn);
    }

    public void editGoal(String name) {
        typingTextIn(editGoalNameTxt, name);
    }
}
