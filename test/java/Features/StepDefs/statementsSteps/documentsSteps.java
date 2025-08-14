package StepDefs.statementsSteps;

import Screens.homeScreen.CurrentAccountScreen;
import Screens.statmentsScreen.DocumentPageScreen;
import TestBases.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static TestBases.DriverManager.getAppiumDriver;

public class documentsSteps extends TestBase {
    CurrentAccountScreen currentAccountScreen = new CurrentAccountScreen(getAppiumDriver());
    DocumentPageScreen documentPageScreen = new DocumentPageScreen(getAppiumDriver());

    @And("user request new document")
    public void userRequestNewDocument() {
        currentAccountScreen.assertElementIsDisplayed(currentAccountScreen.documentBtn,"documentButton");
        currentAccountScreen.clickOnDocumentBtn();
        documentPageScreen.assertElementIsDisplayed(documentPageScreen.documentsBt,"documentsBt");
        documentPageScreen.clickOnDocumentsBtn();
        documentPageScreen.clickOnRequestDocumentButton();
        documentPageScreen.clickOnIBANLetterCardBtn();
        documentPageScreen.clickOnConfirmRequestDocumentButton();
        documentPageScreen.clickOnBackButton();
    }

    @Then("verify that user can preview requested document and download it")
    public void verifyThatUserCanPreviewRequestedDocumentAndDownloadIt()  {
        documentPageScreen.assertElementIsDisplayed(documentPageScreen.requestedDocument,"requestedDocument");
        documentPageScreen.clickOnNavBarBackBtn();
        Screens.homeScreen.ScreenBase.ThreadSleep(5000);
        documentPageScreen.clickOnDocumentsBtn();
        documentPageScreen.clickOnNavBarBackBtn();
        Screens.homeScreen.ScreenBase.ThreadSleep(20000);
        documentPageScreen.clickOnDocumentsBtn();
        documentPageScreen.clickOnRequestedDocument();
        documentPageScreen.assertElementIsDisplayed(documentPageScreen.exportPDFButton,"exportPDFButton");
        documentPageScreen.clickOnExportDocument();

    }

    @And("user request new bank certificate document")
    public void userRequestNewBankCertificateDocument() {
        currentAccountScreen.assertElementIsDisplayed(currentAccountScreen.documentBtn,"documentButton");
        currentAccountScreen.clickOnDocumentBtn();
        documentPageScreen.assertElementIsDisplayed(documentPageScreen.documentsBt,"documentsBt");
        documentPageScreen.clickOnDocumentsBtn();
        documentPageScreen.clickOnRequestDocumentButton();
        documentPageScreen.clickOnBankCertificateCardBtn();
        documentPageScreen.clickOnSetDate();
        documentPageScreen.clickOnPickDateBtn();
        documentPageScreen.clickOnConfirmRequestDocumentButton();
        documentPageScreen.clickOnBackButton();
    }

    @And("user request new Tax Invoice Certificate document")
    public void userRequestNewTaxInvoiceCertificateDocument() {
        currentAccountScreen.assertElementIsDisplayed(currentAccountScreen.documentBtn,"documentButton");
        currentAccountScreen.clickOnDocumentBtn();
        documentPageScreen.assertElementIsDisplayed(documentPageScreen.documentsBt,"documentsBt");
        documentPageScreen.clickOnDocumentsBtn();
        documentPageScreen.clickOnRequestDocumentButton();
        documentPageScreen.clickOnTaxInvoiceCardBtn();
//        documentPageScreen.clickOnSetDate();
//        documentPageScreen.clickOnPickDateBtn();
        documentPageScreen.clickOnConfirmRequestDocumentButton();
        documentPageScreen.clickOnBackButton();
    }

    @Then("verify that user can download the requested document")
    public void verifyThatUserCanDownloadTheRequestedDocument() {
        documentPageScreen.assertElementIsDisplayed(documentPageScreen.downloadBtn,"downloadButton");
        documentPageScreen.clickOnDownloadBtn();
        documentPageScreen.assertElementIsDisplayed(documentPageScreen.viewFileBtn,"viewFileButton");
    }
}
