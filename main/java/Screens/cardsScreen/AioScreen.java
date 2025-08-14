package Screens.cardsScreen;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AioScreen extends ScreenBase {
    public AioScreen(AppiumDriver appiumDriver){
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.EntryPointScreen:ExploreButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "AllInOneCard.EntryPointScreen:ExploreButton-Pressable")
    public WebElement exploreBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"AllInOneCard.DashboardScreen:NavHeader-View\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'AllInOneCard.DashboardScreen:NavHeader-View'")
    public WebElement aioScreenTitle;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Activated\"]")
    @iOSXCUITFindBy(accessibility = "Activated")
    public WebElement neraCardActivatedMsg;
    @AndroidFindBy(uiAutomator = "resourceId(\"AllInOneCard.DashboardScreen:CardActivationButton\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'AllInOneCard.DashboardScreen:CardActivationButton'")
    public WebElement cardActivationButton;
    @iOSXCUITFindBy(accessibility = "Done")
    public WebElement PressDone;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Available Balance\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"6533 Add Money Refund Freeze Available Balance ****  SAR Add to Apple Wallet\"]")
    public WebElement cardAvailableBalance;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.SelectCardScreen:button-Pressable\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"AllInOneCard.SelectCardScreen:button-Pressable\" and @label=\"Apply for nera Plus\"]")
    public WebElement applyForAIOPlusBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.SelectCardScreen:button\").childSelector(new UiSelector().className(\"android.widget.TextView\").text(\"Apply for nera card\"))")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"AllInOneCard.SelectCardScreen:button\" and @label=\"Apply for nera card\"]")
    public WebElement applyForAIOBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.ChooseRedemptionScreen:OptionsList-Pressable\").instance(1)")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"AllInOneCard.ChooseRedemptionScreen:OptionsList-Stack\" and @label=\"Cashback Get 1% on each transaction and 2% on preferred partners. The money will be directly transferred to your All-in-one card SAR wallet.\"]\n")
    public WebElement chooseRewardsMethodBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"AllInOneCard.ChooseRedemptionScreen:ContinueButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "AllInOneCard.ChooseRedemptionScreen:ContinueButton-Pressable")
    public WebElement ContinueBtn;
    @AndroidFindBy(xpath = "//android.widget.Button[android.widget.TextView[@text='Continue']]")
    @iOSXCUITFindBy(accessibility = "AllInOneCard.SelectPaymentOptionScreen:ContinueButton-Pressable")
    public WebElement selectPaymentOptionScreenContinueBtn;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"AllInOneCard.WelcomeScreen:ViewActivatedCardButton-Pressable\"]")
    @iOSXCUITFindBy(accessibility = "AllInOneCard.WelcomeScreen:ViewActivatedCardButton-Pressable")
    public WebElement viewCard;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout//android.widget.ScrollView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
    public WebElement scrollView;
    @AndroidFindBy(className = "android.widget.HorizontalScrollView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
    public WebElement horizontalScrollView;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.CardReviewScreen:AgreeCheckbox\").instance(2)")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"AllInOneCard.CardReviewScreen:AgreeCheckbox\"])[3]")
    public WebElement agreeCheckBox;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"AllInOneCard.CardReviewScreen:ConfirmButton-Pressable\"]\n")
    @iOSXCUITFindBy(accessibility = "AllInOneCard.CardReviewScreen:ConfirmButton-Pressable")
    public WebElement ConfirmBtn;
    @AndroidFindBy(xpath = "//android.widget.Button[android.widget.TextView[@text='Activate card ']]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate card \"]")
    public WebElement activateCardBtn;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Card Stolen Immediately cancel the card and arrange for a new one to prevent unauthorized access to your funds\"]")
    public WebElement cardStolen;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*NumberPad-.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*NumberPad-.*'")
    public List<WebElement> cardsPinPad;
    @AndroidFindBy(xpath = "//android.widget.Button[android.widget.TextView[@text='View Card']]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"View Card\"]")
    public WebElement viewCardBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"AllInOneCard.DashboardScreen:CardPlaceholder-CardControlPressable\")")
    @iOSXCUITFindBy(accessibility = "AllInOneCard.DashboardScreen:CardPlaceholder-CardControlPressable")//todo
    public WebElement viewCardDetailsBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.DashboardScreen:NavHeader\")")
    @iOSXCUITFindBy(xpath= "//XCUIElementTypeOther[@name=\"AllInOneCard.DashboardScreen:NavHeader\"]")
    public WebElement settingsBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.SettingsScreen:changeCardPIN\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'AllInOneCard.SettingsScreen:changeCardPIN'")
    public WebElement changeCardPINBtn;
    //
    @AndroidFindBy(uiAutomator = "resourceId(\"AllInOneCard.SettingsScreen:orderPhysicalCard\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'AllInOneCard.SettingsScreen:orderPhysicalCard'")
    public WebElement orderPhysicalCardBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"AllInOneCard.CardControlScreen:NavHeader-BackButton\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'AllInOneCard.CardControlScreen:NavHeader-BackButton'")
    public WebElement cardControlScreen;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.DeliveryAddressScreen:confirmButton-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'AllInOneCard.DeliveryAddressScreen:confirmButton-Pressable'")
    public WebElement deliveryAddressScreenConfirmBtn;
    //
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.SettingsScreen:statements\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'AllInOneCard.SettingsScreen:statements'")
    public WebElement statementsBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Year\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Year\"]")
    public WebElement requestNewStatementYear;
    //
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.SettingsScreen:cardClose\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'AllInOneCard.SettingsScreen:cardClose'")
    public WebElement cardCloseBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.ReplacementCardScreen:Button-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'AllInOneCard.ReplacementCardScreen:Button-Pressable'")
    public WebElement replacementCardScreenBtn;
    //
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.SettingsScreen:addToWallet\")")
    @iOSXCUITFindBy(accessibility ="AllInOneCard.SettingsScreen:addToWallet")
    public WebElement addToWalletBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.CardToWalletScreen:ButtonContinue\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"AllInOneCard.CardToWalletScreen:SubTitle\"]")
    public WebElement cardToWalletScreenBtn;
    //
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.SettingsScreen:permanentCardClosure\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'AllInOneCard.SettingsScreen:permanentCardClosure'")
    public WebElement permanentCardClosureBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.PermanentCardClosureScreen:Button-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'AllInOneCard.PermanentCardClosureScreen:Button-Pressable'")
    public WebElement permanentCardClosureScreenBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.SettingsScreen:NavHeader-BackButton\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name ENDSWITH 'BackButton'")
    public WebElement BackBtn;
    @AndroidFindBy(uiAutomator = "className(\"android.view.ViewGroup\").childSelector(className(\"android.widget.TextView\"))")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeScrollView/**/XCUIElementTypeOther/**/XCUIElementTypeOther/**/XCUIElementTypeOther")
    public List<WebElement> questionList;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.PermanentCardClosureScreen:WarningModal-ButtonsContainer\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'AllInOneCard.PermanentCardClosureScreen:WarningModal-ButtonsContainer'")
    public WebElement CancelAndReplaceCardBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.CardReplacementFeesScreen:ConfirmButton-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'AllInOneCard.CardReplacementFeesScreen:ConfirmButton-Pressable'")
    public WebElement CardReplacementFeesScreenBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.RequestSuccessfullyScreen:button\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'AllInOneCard.RequestSuccessfullyScreen:button'")
    public WebElement RequestSuccessfullyScreenBtn;
    // ----------------------------------Benefits-------------------------------------- //
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"Benefits\"`][1]/XCUIElementTypeOther[2]")
    public WebElement chooseYourSubscriptionBtn;
    @AndroidFindBy(xpath = "//android.widget.Button[android.widget.TextView[@text='Unlock Free benefits']]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Unlock Free benefits\"]")
    public WebElement unlockFreeBenefitsBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Search\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Search\"]")
    public WebElement SearchBar;
    //    public WebElement listOfBenefits;//todo assert is displayed, ID needed
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Activate\"])[2]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Activate\"`][2]")
    public WebElement AnghamiActiveBenefitsBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Choose up to 2 benefits for free, additional benefits will come with extra charges.\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Choose up to 2 benefits for free, additional benefits will come with extra charges.\"]")
    public WebElement ChooseTwoBenefitsTxt;
    @AndroidFindBy(xpath = "new UiSelector().className(\"android.view.ViewGroup\").instance(17)")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Benefits\"])[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    public WebElement BenefitsBackBtn;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"I confirm that my details are correct\"]")
    public WebElement confirmCheckBox;
    @AndroidFindBy(xpath = "//android.widget.Button[android.widget.TextView[@text='Active']]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Active\"]")
    public WebElement activeBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'request received successfully')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@label, 'request received successfully')]")
    public WebElement successMessage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"//android.widget.TextView[@text=\"Active Benefits\"]\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Active Benefits\"]")
    public WebElement activeBenefitsTap;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Active\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Active\"]")
    public WebElement activeTxt;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"View All\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"AllInOneCard.DashboardScreen:TransactionSection-ViewAll-Text\"]")
    public WebElement historyViewAllBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Filter by\")")
    @iOSXCUITFindBy(accessibility = "AllInOneCard.AllTransactionsScreen:FilterText")
    public WebElement filterByTxt;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"AllInOneCard.AllTransactionScreen:PressableSectionItem\").instance(0)")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"AllInOneCard.AllTransactionScreen:PressableSectionItem\"`][1]")
    public WebElement transactionList;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*CardActionFreezeDefrost.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*CardActionFreezeDefrost.*'")
    public WebElement freezeBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"AllInOneCard.RequestSuccessfullyScreen:button-Pressable\")")
    @iOSXCUITFindBy(accessibility = "AllInOneCard.RequestSuccessfullyScreen:button-Pressable")
    public WebElement activateCardAfterReplacementBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*FreezeButton-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*FreezeButton-Pressable.*'")
    public WebElement freezeMyCardBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*CardActionFreezeDefrost.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*CardActionFreezeDefrost.*'")
    public WebElement defrostBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*DefrostButton-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*DefrostButton-Pressable.*'")
    public WebElement defrostMyCardBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*CardActionAddMoney.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*CardActionAddMoney.*'")
    public WebElement addMoneyBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*AmountInput.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*AmountInput.*'")
    public WebElement enterAmountTxt;
    @AndroidFindBy(uiAutomator = "resourceId(\"AllInOneCard.TopUpAndRefundScreen:confirmButton-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'AllInOneCard.TopUpAndRefundScreen:confirmButton-Pressable'")
    public WebElement topUpAndRefundConfirmBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"AllInOneCard.TopUpAndRefundSummaryScreen:ContinueButton-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'AllInOneCard.TopUpAndRefundSummaryScreen:ContinueButton-Pressable'")
    public WebElement topUpAndRefundContinueBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"AllInOneCard.SuccessMoneyAdditionScreen:DoneButton-Pressable\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'AllInOneCard.SuccessMoneyAdditionScreen:DoneButton-Pressable'")
    public WebElement successMoneyAdditionDoneBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"You have insufficient funds.\")")
    @iOSXCUITFindBy(accessibility = "You have insufficient funds.")
    public WebElement InsufficientFundsErrorMessage;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*CardActionRefund.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*CardActionRefund.*'")
    public WebElement refundBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*confirmButton-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*confirmButton-Pressable.*'")
    public WebElement refundConfirmBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*ContinueButton-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*ContinueButton-Pressable.*'")
    public WebElement refundContinueBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*DoneButton-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*DoneButton-Pressable.*'")
    public WebElement refundDoneBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*TransferTag-1-Pressable.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*TransferTag-1-Pressable.*'")
    public WebElement refundPartiallyBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"SignIn.IqamaInputScreen:ProceedButton-Title\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'SignIn.IqamaInputScreen:ProceedButton-Title'")
    public WebElement cardReplacementIVRConfirmContinueBtn;
    //
    public void tapOnSettingsBtn (){waitUntilElementAppear(settingsBtn,30);
        tapOn(settingsBtn);}

    public void tapOnBackBtn (){
        Point location = BackBtn.getLocation();
        int centerX = location.getX() + (BackBtn.getSize().getWidth() / 2);
        int centerY = location.getY() + (BackBtn.getSize().getHeight() / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);

        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(tap));
    }
    public void tapOnCardActivationButton()
    {
        tapOn(cardActivationButton);
    }
    public void tapOnActivateCardAfterReplacementBtn (){
        waitUntilElementAppear(activateCardAfterReplacementBtn,50);
        tapOn(activateCardAfterReplacementBtn);}
    public void tapOnChooseYourSubscriptionBtn (){tapOn(chooseYourSubscriptionBtn);}
    public void tapOnUnlockFreeBenefitsBtn (){tapOn(unlockFreeBenefitsBtn);}
    public void tapOnAnghamiActiveBenefitsBtn (){tapOn(AnghamiActiveBenefitsBtn);}
    public void tapOnConfirmCheckBox (){tapOn(confirmCheckBox);}
    public void tapOnActiveBtn (){tapOn(activeBtn);}
    public void tapOnActiveBenefitsTap (){tapOn(activeBenefitsTap);}

    public void tapOnViewCard()
    {
        waitUntilElementAppear(viewCard,10);
        tapOn(viewCard);
    }
    public void tapOnChangeCardPINBtn (){
        tapOn(changeCardPINBtn);
    }

    public void tapOnOrderPhysicalCardBtn (){
        tapOn(orderPhysicalCardBtn);
    }

    public void tapOnStatementsBtn (){
        tapOn(statementsBtn);
    }

    public void tapOnCardCloseBtn (){
        tapOn(cardCloseBtn);
    }

    public void tapOnAddToWalletBtn (){
        tapOn(addToWalletBtn);
    }

    public void tapOnPermanentCardClosureBtn (){
        tapOn(permanentCardClosureBtn);
    }


    public boolean isExploreBtnDisplayed (){
        try {
            return exploreBtn.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void tapOnExploreBtn ()  {
        tapOn(exploreBtn);
        ScreenBase.ThreadSleep(10000);
    }

    public void tapOnApplyForAIOBtn (){
        tapOn(applyForAIOPlusBtn);
    }

    public void activateCreditCard (){
        horizontalScroll(horizontalScrollView,0.9,0.1);
        tapOn(applyForAIOBtn);
    }

    public void tapOnChooseRewardsMethodBtn (){
        tapOn(chooseRewardsMethodBtn);
    }

    public void tapOnContinueBtn (){
        tapOn(ContinueBtn);
    }
    public void tapOnSelectPaymentOptionScreenContinueBtn (){
        tapOn(selectPaymentOptionScreenContinueBtn);
    }
    public void tapOnAgreeCheckBox (){
        verticalScroll(scrollView,0.9,0.1);
        tapOn(agreeCheckBox);
    }

    public void tapOnConfirmBtn (){
        tapOn(ConfirmBtn);
    }

    public void tapOnActivateCardBtn (){
        tapOn(activateCardBtn);
    }
    public void tapOnCardStolen (){
        tapOn(cardStolen);
    }
    public void tapOnViewCardBtn (){
        waitUntilElementAppear(viewCardBtn,30);
        tapOn(viewCardBtn);
    }

    public void tapOnViewCardDetailsBtn (){
        String platformName = String.valueOf(driver.getCapabilities().getPlatformName());
        switch (platformName.toLowerCase()) {
            case "android" -> tapOn(viewCardDetailsBtn);
            case "ios" -> {
                //tapOn(driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"6533 Add Money Refund Freeze Available Balance ****  SAR Add to Apple Wallet\"]")));
                tapOn(viewCardDetailsBtn);
            }
        }
    }

    public void selectQuestionList (String Item){
        for (WebElement element : questionList) {
            try {
                if(element.getText().equalsIgnoreCase(Item)) {
                    element.click();
                    break;
                }

            } catch (org.openqa.selenium.StaleElementReferenceException ignored) {
            }
        }
    }

    public void clickOnReplacementCardBtn (){
        waitUntilElementAppear(replacementCardScreenBtn,10);
        tapOn(replacementCardScreenBtn);
    }

    public void clickOnCancelAndReplaceCardBtn (){
        waitUntilElementAppear(CancelAndReplaceCardBtn,10);
        tapOn(CancelAndReplaceCardBtn);
    }

    public void clickOnCardReplacementFeesBtn (){
        waitUntilElementAppear(CardReplacementFeesScreenBtn,10);
        CardReplacementFeesScreenBtn.getAttribute("enabled");
        long timeoutInSeconds = 30; // Timeout duration
        long startTime = System.currentTimeMillis();
        while (CardReplacementFeesScreenBtn.getAttribute("enabled").equalsIgnoreCase("false")) {
            if((System.currentTimeMillis() - startTime) / 1000 > timeoutInSeconds) {
                break;
            }
        }
        tapOn(CardReplacementFeesScreenBtn);
    }

    public void clickOnRequestSuccessfullyBtn (){
        waitUntilElementAppear(RequestSuccessfullyScreenBtn,10);
        tapOn(RequestSuccessfullyScreenBtn);
    }

    public void clickOnHistoryViewAllBtn(){
        verticalScroll(scrollView,0.9,0.1);
        waitUntilElementAppear(historyViewAllBtn,10);
        tapOn(historyViewAllBtn);
    }

    public void clickOnTransactionListItem(){
        waitUntilElementAppear(transactionList,50);
        tapOn(transactionList);
    }

    public void clickOnFreezeBtn(){
        waitUntilElementAppear(freezeBtn,10);
        tapOn(freezeBtn);
    }

    public void clickOnFreezeMyCardBtn(){
        waitUntilElementAppear(freezeMyCardBtn,10);
        tapOn(freezeMyCardBtn);
    }

    public void clickOnDefrostBtn(){
        waitUntilElementAppear(defrostBtn,10);
        tapOn(defrostBtn);
    }

    public void clickOnDefrostMyCardBtn(){
        waitUntilElementAppear(defrostMyCardBtn,10);
        tapOn(defrostMyCardBtn);
    }

    public void clickOnAddMoneyBtn(){
        waitUntilElementAppear(addMoneyBtn,10);
        tapOn(addMoneyBtn);
    }

    public void clickOnAndEnterValueInEnterAmountTxt(String value){
        waitUntilElementAppear(enterAmountTxt,10);
        tapOn(enterAmountTxt);
        useNativeKeyboard(value);
        if(driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("Android"))
        {
            pressEnter();
        }

    }

    public void clickOnTopUpAndRefundConfirmBtn(){
        if(driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("ios"))
        {
            tapOn(PressDone);
        }

        waitUntilElementAppear(topUpAndRefundConfirmBtn,10);
        tapOn(topUpAndRefundConfirmBtn);
    }

    public void clickOnTopUpAndRefundContinueBtn(){
        waitUntilElementAppear(topUpAndRefundContinueBtn,10);
        tapOn(topUpAndRefundContinueBtn);
    }

    public void clickOnSuccessMoneyAdditionDoneBtn(){
        waitUntilElementAppear(successMoneyAdditionDoneBtn,10);
        tapOn(successMoneyAdditionDoneBtn);
    }

    public void clickOnRefundBtn(){
        waitUntilElementAppear(refundBtn,10);
        tapOn(refundBtn);
    }
    public void clickOnRefundConfirmBtn(){
        waitUntilElementAppear(refundConfirmBtn,10);
        tapOn(refundConfirmBtn);
    }
    public void clickOnRefundContinueBtn(){
        waitUntilElementAppear(refundContinueBtn,10);
        tapOn(refundContinueBtn);
    }
    public void clickOnRefundDoneBtn(){
        waitUntilElementAppear(refundDoneBtn,10);
        tapOn(refundDoneBtn);
    }


    public void clickOnCardReplacementIVRConfirmContinueBtn(){
        waitUntilElementAppear(cardReplacementIVRConfirmContinueBtn,10);
        tapOn(cardReplacementIVRConfirmContinueBtn);
    }

    public void clickOnRefundPartiallyBtn(){
        waitUntilElementAppear(refundPartiallyBtn,10);
        tapOn(refundPartiallyBtn);
    }

}
