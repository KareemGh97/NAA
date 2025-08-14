package Screens.statmentsScreen;

import Screens.homeScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class DocumentPageScreen extends ScreenBase {

    public DocumentPageScreen(AppiumDriver appiumDriver){
        super(appiumDriver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"Documents.DocumentsEntryScreen:OnPressAdhoc\")")
    @iOSXCUITFindBy(accessibility = "Documents.DocumentsEntryScreen:OnPressAdhoc")
    public WebElement documentsBt;
    @AndroidFindBy(uiAutomator = "resourceId(\"Documents.DocumentsEntryScreen:OnPressStatments\")")
    @iOSXCUITFindBy(accessibility = "Documents.DocumentsEntryScreen:OnPressStatments")
    public WebElement statementBt;
    @AndroidFindBy(uiAutomator = "resourceId(\"Documents.DocumentsScreen:RequestDocumentButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Documents.DocumentsScreen:RequestDocumentButton-Pressable")
    public WebElement requestDocumentButton;

    @AndroidFindBy(uiAutomator = "resourceId(\"Documents.RequestDocumentScreen:SelectDocumentTypeSection-IBANLetterCard-View\")")
    @iOSXCUITFindBy(accessibility = "Documents.RequestDocumentScreen:SelectDocumentTypeSection-IBANLetterCard-View")
    public WebElement ibanLetterCardBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"Documents.RequestDocumentScreen:SelectDocumentTypeSection-BankCertificateCard-View\")")
    @iOSXCUITFindBy(accessibility = "Documents.RequestDocumentScreen:SelectDocumentTypeSection-BankCertificateCard-View")
    public WebElement bankCertificateCardBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"Documents.RequestDocumentScreen:SelectDocumentTypeSection-TaxInvoiceCard-View\")")
    @iOSXCUITFindBy(accessibility = "Documents.RequestDocumentScreen:SelectDocumentTypeSection-TaxInvoiceCard-View")
    public WebElement taxInvoiceCardBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"Documents.ConvertToYYMM:SelectDocumentDateSection-SetMonthRowCard-SelectMonthContainer\")")
    @iOSXCUITFindBy(accessibility = "Documents.ConvertToYYMM:SelectDocumentDateSection-SetMonthRowCard-SelectMonthContainer")
    public WebElement setDate;
    @AndroidFindBy(uiAutomator = "resourceId(\"GoalGetter.ShapeGoalScreen:TargetDateInput-Input-DatePickerButton\")")
    @iOSXCUITFindBy(accessibility = "GoalGetter.ShapeGoalScreen:TargetDateInput-Input-DatePickerButton")
    public WebElement UATSetDate;
    @AndroidFindBy(uiAutomator = "resourceId(\"Documents.ConvertToYYMM:SelectDateModal-TaxInvoiceMonthYearButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Documents.ConvertToYYMM:SelectDateModal-TaxInvoiceMonthYearButton-Pressable")
    public WebElement pickDateBtn;
    @AndroidFindBy(uiAutomator = "resourceId(\"Documents.ConvertToYYMM:RequestDocumentButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Documents.ConvertToYYMM:RequestDocumentButton-Pressable")
    public WebElement confirmRequestDocumentButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*ButtonsContainer.*\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name MATCHES '.*ButtonsContainer.*'")
    public WebElement backBtn;

//    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Go back\"]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Go back\"]")
//    public WebElement backBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"Documents.DocumentsScreen:DocumentsListComponent-DocumentCardView-GetSubTitle\")")
    @iOSXCUITFindBy(accessibility = "Documents.DocumentsScreen:DocumentsListComponent-DocumentCardView-GetSubTitle")
    public WebElement requestedDocument;
    @AndroidFindBy(uiAutomator = "resourceId(\"Documents.PreviewDocumentScreen:PreviewAndExportPDF-ExportPDFButton-Pressable\")")
    @iOSXCUITFindBy(accessibility = "Documents.PreviewDocumentScreen:PreviewAndExportPDF-ExportPDFButton-Pressable")
    public WebElement exportPDFButton;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Document Preview\"]")
    public WebElement previewDocument;
    @AndroidFindBy(uiAutomator = "resourceId(\"android:id/content_preview_filename\")")
    @iOSXCUITFindBy(accessibility = "android:id/content_preview_filename")
    public WebElement downloadedFilePath;
    @AndroidFindBy(uiAutomator = "resourceId(\"Documents.DocumentsScreen:NavHeader-BackButton\")")
    @iOSXCUITFindBy(accessibility = "Documents.DocumentsScreen:NavHeader-BackButton")
    public WebElement navBarBackBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"com.horcrux.svg.u\").instance(5)")
    @iOSXCUITFindBy(accessibility = "android:id/content_preview_filename")
    public WebElement downloadBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"Documents.DocumentsScreen:NotificationViewFileButton\")")
    @iOSXCUITFindBy(accessibility = "Documents.DocumentsScreen:NotificationViewFileButton")
    public WebElement viewFileBtn;
    public void clickOnDocumentsBtn(){
        tapOn(documentsBt);
    }
    public void clickOnStatementBtBtn(){
        tapOn(statementBt);
    }
    public void clickOnRequestDocumentButton(){
        tapOn(requestDocumentButton);
    }
    public void clickOnIBANLetterCardBtn(){
        tapOn(ibanLetterCardBtn);
    }

    public void clickOnBankCertificateCardBtn(){
        tapOn(bankCertificateCardBtn);
    }

    public void clickOnTaxInvoiceCardBtn(){
        tapOn(taxInvoiceCardBtn);
    }

    public void clickOnSetDate(){
        tapOn(setDate);
    }

    public void clickOnPickDateBtn(){
        tapOn(pickDateBtn);
    }
    public void clickOnConfirmRequestDocumentButton(){
        tapOn(confirmRequestDocumentButton);
    }
    public void clickOnBackButton(){
        tapOn(backBtn);
    }
    public void clickOnRequestedDocument(){
        tapOn(requestedDocument);
    }
    public void clickOnExportDocument(){
        tapOn(exportPDFButton);
    }
    public void clickOnNavBarBackBtn(){
        tapOn(navBarBackBtn);
    }

    public void clickOnDownloadBtn(){
        tapOn(downloadBtn);
    }
}
