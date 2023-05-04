package com.fadv.automation.stepdef;

import com.fadv.automation.core.BaseClass;
import com.fadv.automation.core.SeleniumBaseClass;
import com.fadv.automation.core.TestObject;
import com.fadv.automation.pageobjects.EACloudOrderDetails;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.sridharbandi.HtmlCsRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.logging.Logger;


public class EaCloudDef extends BaseClass {
    static final Logger logger = Logger.getLogger (EaCloudDef.class.getName ( ));
    final static SeleniumBaseClass seleniumBaseClass = new SeleniumBaseClass(null);
    private WebDriver driver = null;
    private EACloudOrderDetails ui = null;


    @Before
    public void before(Scenario scenario) throws Exception {
        testObject = TestObject.createWith(scenario);
    }

    @After
    public void after(Scenario scenario) throws Exception{
        if (this.driver != null) {

            if (scenario.isFailed() && ui != null) {
                ui.reportScreenshot(scenario.getName());
            }
            if (testObject != null) {
                testObject.testComplete();
            }

            seleniumBaseClass.htmlCsRunner = new HtmlCsRunner(this.driver);
            seleniumBaseClass.htmlCsRunner.execute();
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    @AfterAll
    public static void after_all() throws Exception {

        if(seleniumBaseClass.htmlCsRunner!=null){
            seleniumBaseClass.htmlCsRunner.generateHtmlReport();
        }

    }


    public EACloudOrderDetails getEaCloudPageObject() throws Exception {
        driver = seleniumBaseClass.setBrowserFromProperty (driver);
        ui = PageFactory.initElements (driver, EACloudOrderDetails.class);
        ui.setTestObject(testObject);
        return ui;
    }


    @When("I click the Notice Agreement button for the EA Cloud Order")
    public void iClickTheNoticeAgreementButtonForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickNoticeAgreeButton();
    }

    @Given("I create an order through the test page and launch the url")
    public void iCreateAnOrderThroughTheTestPageAndLaunchTheUrl() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.navigateToOrderDetails();
    }

    @Then("I can verify the EA Cloud Order Details page displays")
    public void iCanVerifyTheEACloudOrderDetailsPageDisplays() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.orderDetailsSummaryTabExists(), "Order Detail Summary Tab was not found as expected.");
    }

    @Then("I can verify the Search Type {string} displays on the EA Cloud Order Details Page")
    public void iCanVerifyTheSearchTypeDisplaysOnTheEACloudOrderDetailsPage(String searchType) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.searchTypeExists(searchType), "Search Type was not found as expected.");
    }


    @And("I verify the {string} fields are not displaying on the EA Cloud Order Details Page")
    public void iVerifyTheFieldsAreNotDisplayingOnTheEACloudOrderDetailsPage(String searchType, DataTable dataTable) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertFalse(eaCloudOrderDetails.searchTypeDetailsExists(searchType, dataTable), "Search Detail was found while collapsed and was expected.");
    }

    @And("I check the {string} Search Type Details and verify the fields are displaying on the EA Cloud Order Details Page")
    public void iCheckTheSearchTypeDetailsAndVerifyTheFieldsAreDisplayingOnTheEACloudOrderDetailsPage(String searchType, DataTable dataTable) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.searchTypeDetailsExistsInExpanded(searchType, dataTable);
    }

    @When("I click the cancel case button and select the Customer Support Inquiry for the EA Cloud Order")
    public void iClickTheCancelCaseButtonAndSelectTheCustomerSupportInquiryForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.selectSupportInquiry();
    }

    @Then("I can verify the Customer Support Inquiry modal appears")
    public void iCanVerifyTheCustomerSupportInquiryModalAppears() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.customerServiceInquiryPopup), "Customer Support Inquiry Modal did not appear as expected.");
    }

    @And("I can verify the auto-filled email address field appears on the Customer Support Inquiry modal of the EA Cloud Order")
    public void iCanVerifyTheAutoFilledEmailAddressFieldAppearsOnTheCustomerSupportInquiryModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertEquals( eaCloudOrderDetails.retrieveEmailAddressValue(), "sumitra.hebbar@fadv.com", "Email address is not auto-populated as expected.");
    }

    @And("I click the cancel button on the Customer Support Inquiry modal of the EA Cloud Order")
    public void iClickTheCancelButtonOnTheCustomerSupportInquiryModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickCancelButton();
    }

    @And("I click the submit button on the Customer Support Inquiry modal of the EA Cloud Order")
    public void iClickTheSubmitButtonOnTheCustomerSupportInquiryModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickCustomerSupportSubmitButton();
    }

    @And("I enter the phone number {string} into the customer support inquiry modal of the EA Cloud Order")
    public void iEnterThePhoneNumberIntoTheCustomerSupportInquiryModalOfTheEACloudOrder(String phoneNumber) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.enterCustomerServiceInquiryPhoneNumber(phoneNumber, false);
    }

    @And("I can verify the case comments section displays on the Order Details Tab of the EA Cloud Order")
    public void iCanVerifyTheCaseCommentsSectionDisplaysOnTheOrderDetailsTabOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.caseCommentsHeader), "Case Comments section was not found.");
    }

    @And("I enter case comments {string} on the order details tab of the EA Cloud Order")
    public void iEnterCaseCommentsOnTheOrderDetailsTabOfTheEACloudOrder(String comments) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.enterCaseComments(comments);
    }

    @And("I click the enter button for the case comments on the Order Details tab of the EA Cloud Order")
    public void iClickTheEnterButtonForTheCaseCommentsOnTheOrderDetailsTabOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickCaseCommentEnterButton();
    }

    @Given("I retrieve the existing EA cloud order {string} via the simulator")
    public void iRetrieveTheExistingEACloudOrderViaTheSimulator(String caseId) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.navigateToExistingOrderDetails(caseId);
    }

    @And("I can verify date, time, and current user display in the case comment section of the Order Details tab of the EA Cloud Order")
    public void iCanVerifyDateTimeAndCurrentUserDisplayInTheCaseCommentSectionOfTheOrderDetailsTabOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.verifyCaseCommentEntries();
    }

    @And("I can verify the original comments were saved and displays in the case comment section of the Order Details tab of the EA Cloud Order")
    public void iCanVerifyTheOriginalCommentsWereSavedAndDisplaysInTheCaseCommentSectionOfTheOrderDetailsTabOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.isCommentSavedInCommentSection(testObject.getTestData("CaseComments")));
    }

    @And("I can verify the EA Cloud Case Documents Tab displays")
    public void iCanVerifyTheEACloudCaseDocumentsTabDisplays() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.caseDocumentTabExists(), "Case Document Tab was not found.");
    }

    @And("I click the Case Documents Tab on the EA Cloud Order Details page")
    public void iClickTheCaseDocumentsTabOnTheEACloudOrderDetailsPage() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickCaseDocumentsTab();
    }

    @And("I can verify the EA Cloud Case Documents page displays")
    public void iCanVerifyTheEACloudCaseDocumentsPageDisplays() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.caseDocumentsPage), "Case documents Page was not found.");
    }

    @And("I can verify the Upload button displays on the Case Documents page for the EA Cloud Order")
    public void iCanVerifyTheUploadButtonDisplaysOnTheCaseDocumentsPageForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.caseDocumentsUploadButtonExists(), "Case Documents Upload button was not found as expected.");
    }

    @And("I click the Upload button on the Case Documents page for the EA Cloud Order")
    public void iClickTheUploadButtonOnTheCaseDocumentsPageForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickCaseDocumentsUploadButton();
    }

    @And("I can verify the Upload Documents modal appears for the EA Cloud Order")
    public void iCanVerifyTheUploadDocumentsModalAppearsForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.caseDocumentUploadModal), "Case Upload Documents modal was not found as expected.");
    }

    @And("I can verify the File Upload section displays on the Upload Documents page of the EA Cloud Order")
    public void iCanVerifyTheFileUploadSectionDisplaysOnTheUploadDocumentsPageOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.caseDocumentsFileUploader));
    }

    @And("I upload a document on the Upload Documents modal of the EA Cloud Order")
    public void iUploadADocumentOnTheUploadDocumentsModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.uploadDocument("/src/test/resources/testvideos/clearDiscrepancy.png");
    }

    @And("I verify the default uploaded document appears on the Upload Documents modal of the EA Cloud Order")
    public void iVerifyTheDefaultUploadedDocumentAppearsOnTheUploadDocumentsModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.uploadedDocumentNameExists("clearDiscrepancy.png"),
                "The uploaded document (default document) was not found as expected.");
    }

    @And("I verify the Uploads Documents modal displays the comment section for the Case of the EA Cloud Order")
    public void iVerifyTheUploadsDocumentsModalDisplaysTheCommentSectionForTheCaseOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.caseDocumentUploadCommentTextBox),
                "Comments section was not found for the uploaded document");
    }

    @Then("I can verify the Remove File button displays on the Upload Documents modal of the EA Cloud Order")
    public void iCanVerifyTheRemoveFileButtonDisplaysOnTheUploadDocumentsModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.caseDocumentRemoveFileButton),
                "Remove File button was not found as expected.");
    }

    @And("I click on the Remove File button for the uploaded default document on the Upload Document modal of the EA Cloud Order")
    public void iClickOnTheRemoveFileButtonForTheUploadedDefaultDocumentOnTheUploadDocumentModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickUploadDocumentRemoveFileButton();
    }

    @And("I verify the default uploaded document no longer appears on the Upload Documents modal of the EA Cloud Order")
    public void iVerifyTheDefaultUploadedDocumentNoLongerAppearsOnTheUploadDocumentsModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertFalse(eaCloudOrderDetails.uploadedDocumentNameExists("goodIphonePhoto.jpg"),
                "The uploaded document (default document) was found when it was not expected.");
    }

    @And("I verify the submit button is disabled on the Case Documents Upload Page of the EA Cloud Order")
    public void iVerifyTheSubmitButtonIsDisabledOnTheCaseDocumentsUploadPageOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertEquals( eaCloudOrderDetails.isSubmitButtonDisabled().toUpperCase(), "TRUE",
                "Submit Button was not disabled as expected");
    }

    @And("I verify the submit button is enabled on the Case Documents Upload Page of the EA Cloud Order")
    public void iVerifyTheSubmitButtonIsEnabledOnTheCaseDocumentsUploadPageOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.isElementEnabled(eaCloudOrderDetails.caseDocumentSubmitButton_WebElement),
                "Submit Button was not enabled as expected.");
    }

    @Then("I can verify the Cancel button appears on the Upload Documents page of the EA Cloud Order")
    public void iCanVerifyTheCancelButtonAppearsOnTheUploadDocumentsPageOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.caseDocumentCancelButton));
    }

    @And("I click the Cancel button on the Upload Documents modal of the EA Cloud Order")
    public void iClickTheCancelButtonOnTheUploadDocumentsModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickUploadDocumentCancelButton();
    }

    @And("I can verify the documents did not save in the case documents table of the EA Cloud Order")
    public void iCanVerifyTheDocumentsDidNotSaveInTheCaseDocumentsTableOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.caseDocumentsPresentInTable() == 0,
                "A document was saved or appears in the table when no documents were expected.");
    }

    @And("I click the Submit button on the Case Documents Upload Page of the EA Cloud Order")
    public void iClickTheSubmitButtonOnTheCaseDocumentsUploadPageOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickUploadDocumentSubmitButton();
    }
    @Then("I can verify the Uploading File message appears for the EA Cloud Order")
    public void iCanVerifyTheUploadingFileMessageAppearsForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.verifyCaseDocumentUploadMessage();

    }

    @When("I drag and drop a document on the Upload Documents modal of the EA Cloud Order")
    public void iDragAndDropADocumentOnTheUploadDocumentsModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.dragNDropDocumentFile("/src/test/resources/testvideos/clearDiscrepancy.png");
    }

    @When("I drag and drop a non supported file on the Upload Documents modal of the EA Cloud Order")
    public void iDragAndDropANonSupportedFileOnTheUploadDocumentsModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.dragNDropDocumentFile("/src/test/resources/testvideos/Agoodvideo.mjpeg");
    }

    @Then("I verify the non supported file does not appear on the Upload Documents modal of the EA Cloud Order")
    public void iVerifyTheNonSupportedFileDoesNotAppearOnTheUploadDocumentsModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertFalse(eaCloudOrderDetails.uploadedDocumentNameExists("Agoodvideo.mjpeg"),
                "The uploaded document was found when it was not expected.");
    }

    @When("I can enter the comments {string} for the default document on Upload Documents modal of the EA Cloud Order")
    public void iCanEnterTheCommentsForTheDefaultDocumentOnUploadDocumentsModalOfTheEACloudOrder(String comments) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.enterCommentsForUploadedDocument("clearDiscrepancy.png", comments);
    }

    @And("I expand the {string} Case Document and verify the comments are displaying for the document of the EA Cloud Order")
    public void iExpandTheCaseDocumentAndVerifyTheCommentsAreDisplayingForTheDocumentOfTheEACloudOrder(String documentName) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.expandCaseDocumentType(documentName);
        String comment = testObject.getTestData("DocumentComments");
        Assert.assertEquals(eaCloudOrderDetails.getSaveDocumentUploadComment(documentName), comment,"Saved Comment " + comment + " was not found.");
    }

    @When("I click the checkbox next to the Case Document {string} on the Case Documents page of the EA Cloud Order")
    public void iClickTheCheckboxNextToTheCaseDocumentOnTheCaseDocumentsPageOfTheEACloudOrder(String documentName) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickCaseDocumentCheckbox(documentName);
    }

    @Then("I can verify the Download button is enabled on the Case Documents page of the EA Cloud Order")
    public void iCanVerifyTheDownloadButtonIsEnabledOnTheCaseDocumentsPageOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.caseDocumentDownloadButton),
                "Download button was not found as expected.");
    }

    @And("I click the dropdown to Remove File on the Case Document page of the EA Cloud Order")
    public void iClickTheDropdownToRemoveFileOnTheCaseDocumentPageOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickCaseDocumentDropdownMenuItem("Remove File");
    }

    @And("I can verify the Delete File modal appears for the Case Document {string} on the Case Documents page")
    public void iCanVerifyTheDeleteFileModalAppearsForTheCaseDocumentOnTheCaseDocumentsPage(String documentName) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.verifyDeleteDocumentMessage(documentName);
    }

    @And("I click the Case Document Exit button on the Delete File modal of the EA Cloud Order")
    public void iClickTheCaseDocumentExitButtonOnTheDeleteFileModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickCaseDocumentExitButton();
    }

    @And("I click the Case Document Delete File\\(s) button on the Delete File modal of the EA Cloud Order")
    public void iClickTheCaseDocumentDeleteFileSButtonOnTheDeleteFileModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickCaseDocumentDeleteButton();
    }

    @And("I can verify the document {string} displays in the case documents table of the EA Cloud Order")
    public void iCanVerifyTheDocumentDisplaysInTheCaseDocumentsTableOfTheEACloudOrder(String documentName) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.caseDocumentExistsInTable(documentName), "Case Document '" + documentName + "' was not found in the table as expected.");

    }

    @And("I redirect to order id {string}")
    public void iRedirectToOrderId(String orderId) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.redirectToExistingOrderUrl(orderId);
    }

    @And("I upload two documents on the Upload Documents modal of the EA Cloud Order")
    public void iUploadTwoDocumentsOnTheUploadDocumentsModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        String[] files = {"\\src\\test\\resources\\testvideos\\clearDiscrepancy.png", "\\src\\test\\resources\\testvideos\\txtUploadDocSample.txt"};
        eaCloudOrderDetails.uploadDocument(files);
    }

    @And("I verify the two default uploaded documents appear on the Upload Documents modal of the EA Cloud Order")
    public void iVerifyTheTwoDefaultUploadedDocumentsAppearOnTheUploadDocumentsModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        String[] uploadedDocuments = {"clearDiscrepancy.png", "txtUploadDocSample.txt "};
        Assert.assertTrue(eaCloudOrderDetails.uploadedDocumentNameExists(uploadedDocuments),
                "The uploaded document (default document) was not found as expected.");
    }

    @When("I click the Select All checkbox on the Case Documents page for the EA Cloud Order")
    public void iClickTheSelectAllCheckboxOnTheCaseDocumentsPageForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickCaseDocumentSelectAllCheckBox();
    }

    @And("I verify the selected documents {string} appear on the delete confirmation modal of the EA Cloud Order")
    public void iVerifyTheSelectedDocumentsAppearOnTheDeleteConfirmationModalOfTheEACloudOrder(String documents) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        String[] documentList = documents.split(",");
        Assert.assertTrue(eaCloudOrderDetails.documentDeleteModalConfirmationExists(documentList), "Document was not found in the deleted list on the modal.");
    }

    @And("I can verify no documents appear in case documents table of the EA Cloud Order")
    public void iCanVerifyNoDocumentsAppearInCaseDocumentsTableOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertFalse(eaCloudOrderDetails.exists(eaCloudOrderDetails.caseDocumentSelectAllCheckbox),"Expected no Header or rows to be found.");
    }

    @And("I enter comments {string} as a message on the Customer Support Inquiry modal of the EA Cloud Order")
    public void iEnterCommentsAsAMessageOnTheCustomerSupportInquiryModalOfTheEACloudOrder(String comments) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.enterCommentsForCustomerSupport(comments);
    }

    @When("I click the checkbox for one of the default documents on the Case Documents page for the EA Cloud Order")
    public void iClickTheCheckboxForOneOfTheDefaultDocumentsOnTheCaseDocumentsPageForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickCaseDocumentCheckbox("txtUploadDocSample.txt");
    }

    @And("I click to uncheck the default document on the Case Documents page for the EA Cloud Order")
    public void iClickToUncheckTheDefaultDocumentOnTheCaseDocumentsPageForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickCaseDocumentCheckbox("txtUploadDocSample.txt");
    }

    @And("I can verify the Download button is disabled on the Case Documents page of the EA Cloud Order")
    public void iCanVerifyTheDownloadButtonIsDisabledOnTheCaseDocumentsPageOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertFalse(eaCloudOrderDetails.exists(eaCloudOrderDetails.caseDocumentDownloadButton),
                "Download button was found when it was not expected.");
    }

    @And("I can verify the EA Cloud Correspondence page displays for the EA Cloud Order")
    public void iCanVerifyTheEACloudCorrespondencePageDisplaysForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.correspondencePage), "Correspondence Page was not found.");
    }

    @And("I can verify the EA Cloud Correspondence Tab displays")
    public void iCanVerifyTheEACloudCorrespondenceTabDisplays() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.correspondenceTab), "Correspondence Tab was not found.");
    }

    @And("I click the Correspondence Tab on the EA Cloud Order Details page")
    public void iClickTheCorrespondenceTabOnTheEACloudOrderDetailsPage() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickCorrespondenceTab();
    }
    @Then("I can verify that the Search Type and following displays on the EA Cloud Order Details Page")
    public void iCanVerifyThatTheSearchTypeAndTheFollowingDisplaysOnTheEACloudOrderDetailsPage( DataTable dataTable) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.searchTypesExists(dataTable), "Search Type Information was not found as expected.");
    }

    @Then("I click the Cancel Case button")
    public void iclicktheCancelCasebutton() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickCancelCaseButton();
    }

    @Then("I click the Exit Case button")
    public void iClickTheExitCaseButton() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickCancelCaseExitButton();
    }


    @Then("I click the reason for cancelling and cancel the case")
    public void iclickthereasonforcancellingandcancelthecase() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickReasonAndCancelTheCaseButton();
    }

    @Then("I Click the Summary of Rights button")
    public void iClickTheSummaryOfRightsButton() throws Exception{
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickSummaryofRights();
    }

    @Then("I expand and verify the Remarks section of {string} Search Type for the EA Cloud Order")
    public void iExpandAndVerifyTheRemarksSectionForTheEACloudOrder(String searchType) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickVerifyNoRemarks(searchType);
    }

    @Then("I expand the {string} Search Type Details")
    public void iExpandTheSearchTypeDetails(String searchType) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.expandSearchType(searchType);
    }
    @And("I click the Adjudication Case button on the EA Cloud Order Details page")
    public void iClickTheAdjudicationCaseButtonOnTheEACloudOrderDetailsPage() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickAdjudicationCaseButton();
    }

    @And("I can verify the Conduct Case Adjudication modal displays for the EA Cloud Order")
    public void iCanVerifyTheConductCaseAdjudicationModalDisplaysForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.adjudicationConductCaseModal), "Adjudication " +
                "modal was found as expected.");
    }
    @And("I click the Adjudication Eligibility Status dropdown for the EA Cloud Order")
    public void iClickTheAdjudicationEligibilityStatusDropdownForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickEligibilityStatusDropdown();
    }

    @And("I can verify the Eligibility Status on the Adjudication modal displays for the EA Cloud Order")
    public void iCanVerifyTheEligibilityStatusOnTheAdjudicationModalDisplaysForTheEACloudOrder(DataTable dataTable) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.isEligibilityStatusPresent(dataTable), "Eligibility Status was not found.");
    }

    @And("I select Adjudication Reason {string} on the Conduct Case modal of the EA Cloud Order")
    public void iSelectAdjudicationReasonOnTheConductCaseModalOfTheEACloudOrder(String status) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.selectEligibilityStatus(status);
    }

    @Then("I can verify the Adjudication Reason {string} displays as selected on the Conduct Case modal")
    public void iCanVerifyTheAdjudicationReasonDisplaysAsSelectedOnTheConductCaseModal(String status) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.getSelectedEligibilityStatus(status), "Eligibility '" + status + "' status was not displayed.");
    }

    @And("I click the New Letter Pre-Adverse button on the Correspondence Tab of the EA Cloud Order")
    public void iClickTheNewLetterPreAdverseButtonOnTheCorrespondenceTabOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickNewLetterButton();
    }

    @And("I can verify the New Letter Pre-Adverse button is available on the Correspondence Tab of the EA Cloud Order")
    public void iCanVerifyTheNewLetterPreAdverseButtonIsAvailableOnTheCorrespondenceTabOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.preAdverseNewLetterButton), "New Letter Button was not found.");
    }

    @And("I can verify the Pre-Adverse Letter displays for the EA Cloud Order")
    public void iCanVerifyThePreAdverseLetterDisplaysForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.preAdverseActionLetter), "The Pre-Adverse Action Letter " +
                "Page was not found.");
    }

    @And("I can verify the fields are pre-populated with data on the Pre-Adverse Letter for the EA Cloud Order")
    public void iCanVerifyTheFieldsArePrePopulatedWithDataOnThePreAdverseLetterForTheEACloudOrder(DataTable dataTable) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.checkAdverseActionInformation(dataTable);
    }

    @Then("I expand the {string} Search Type Details for the EA Cloud Order")
    public void iExpandTheSearchTypeDetailsForTheEACloudOrder(String searchType) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.expandSearchType(searchType);
    }

    @And("I expand the history section of the {string} Search Type for the EA Cloud Order")
    public void iExpandTheHistorySectionOfTheSearchTypeForTheEACloudOrder(String searchType) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.expandHistorySection(searchType);
    }

    @And("I verify the history section of the {string} Search Type is expanded for the EA Cloud Order")
    public void iVerifyTheHistorySectionOfTheSearchTypeIsExpandedForTheEACloudOrder(String searchType) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.isHistoryExpanded(searchType), "History was not found expanded as expected for " +
                "searchType: " + searchType);
    }

    @And("I collapse the {string} Search Type Details for the EA Cloud Order")
    public void iCollapseTheSearchTypeDetailsForTheEACloudOrder(String searchType) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.collapseSearchType(searchType);
    }

    @And("I verify the history section of the {string} Search Type is collapsed for the EA Cloud Order")
    public void iVerifyTheHistorySectionOfTheSearchTypeIsCollapsedForTheEACloudOrder(String searchType) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertFalse(eaCloudOrderDetails.isHistoryExpanded(searchType), "History was not found collapsed as expected for " +
                "searchType: " + searchType);
    }

    @And("I verify the Case Document {string} is collapsed on the EA Cloud Order")
    public void iVerifyTheCaseDocumentIsCollapsedOnTheEACloudOrder(String documentName) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertFalse(eaCloudOrderDetails.isCaseDocumentsExpanded(documentName), "Case Document was found expanded when it " +
                "was not expected.");

    }

    @And("I click the icon to sort by Case Document Name Header on the EA Cloud Order")
    public void iClickTheIconToSortByCaseDocumentNameHeaderOnTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickDocumentNameColumnToSort();
    }

    @And("I select the Pre-Adverse Letter Type {string} for the EA Cloud Order")
    public void iSelectThePreAdverseLetterTypeForTheEACloudOrder(String letterType) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.selectAdjudicationLetterType(letterType);
    }

    @When("I select Override Reason {string} on the Conduct Case modal of the EA Cloud Order")
    public void iSelectOverrideReasonOnTheConductCaseModalOfTheEACloudOrder(String reason) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.selectOverrideReason(reason);
    }

    @When("I enter Adjudication comments {string} on the Conduct Case modal of the EA Cloud Order")
    public void iEnterAdjudicationCommentsOnTheConductCaseModalOfTheEACloudOrder(String comments) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.enterAdjudicationComments(comments);
    }

    @And("I verify the Pre-Adverse Letter Type selector displays for the EA Cloud Order")
    public void iVerifyThePreAdverseLetterTypeSelectorDisplaysForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.adjudicationLetterTypeSelector),
                "Adjudication Letter Type selector was not found as expected.");
    }


    @Then("I can verify the Internal comments were saved and displays in the case comment section of the Order Details tab of the EA Cloud Order")
    public void iCanVerifyTheInternalCommentsWereSavedAndDisplaysInTheCaseCommentSectionOfTheOrderDetailsTabOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.isCommentSavedInCommentSection(testObject.getTestData("AdjInternalComments")), "Adjudication" +
                " Internal comments were not found in the Case Comments section.");
    }

    @And("I click the Submit button on the Conduct Case modal of the EA Cloud Order")
    public void iClickTheSubmitButtonOnTheConductCaseModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickAdjudicationSubmitButton();
    }

    @And("I enter Internal comments {string} on the Conduct Case modal of the EA Cloud Order")
    public void iEnterInternalCommentsOnTheConductCaseModalOfTheEACloudOrder(String comments) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.enterAdjudicationInternalComments(comments);
    }

    @And("I can verify the submit button is disabled on the Conduct Case modal of the EA Cloud Order")
    public void iCanVerifyTheSubmitButtonIsDisabledOnTheConductCaseModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertEquals(eaCloudOrderDetails.adjudicationSubmitButtonIsDisabled(), "true", "Adjudication Submit button was not disabled" +
                " as expected");
    }

    @And("I can verify the submit button is enabled on the Conduct Case modal of the EA Cloud Order")
    public void iCanVerifyTheSubmitButtonIsEnabledOnTheConductCaseModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertEquals(eaCloudOrderDetails.adjudicationSubmitButtonIsDisabled(), "false", "Adjudication Submit button disabled" +
                " when it was not expected.");
    }

    @And("I upload all of the supported files on the Upload Documents modal of the EA Cloud Order")
    public void iUploadAllOfTheSupportedFilesOnTheUploadDocumentsModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        String[] files = {"/src/test/resources/testvideos/clearDiscrepancy.png", "/src/test/resources/testvideos/txtUploadDocSample.txt",
                "/src/test/resources/testvideos/testdoc.doc","/src/test/resources/testvideos/testdocx.docx", "/src/test/resources/testvideos/testbmp.bmp",
                "/src/test/resources/testvideos/testgif.gif", "/src/test/resources/testvideos/testjpeg.jpg", "/src/test/resources/testvideos/testpdf.pdf",
                "/src/test/resources/testvideos/testtif.tif", "/src/test/resources/testvideos/testtiff.tif", "/src/test/resources/testvideos/testxls.xls",
                "/src/test/resources/testvideos/testxlsx.xlsx", "/src/test/resources/testvideos/testcsv.csv"};
        eaCloudOrderDetails.uploadDocument(files);
    }

    @And("I verify all of the uploaded and supported documents appear on the Upload Documents modal of the EA Cloud Order")
    public void iVerifyAllOfTheUploadedAndSupportedDocumentsAppearOnTheUploadDocumentsModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        String[] uploadedDocuments = {"clearDiscrepancy.png", "txtUploadDocSample.txt", "testdoc.doc", "testdocx.docx","testbmp.bmp", "testgif.gif", "testjpeg.jpg",
                "testpdf.pdf", "testtif.tif", "testtiff.tif", "testxls.xls", "testxlsx.xlsx", "testcsv.csv"};
        Assert.assertTrue(eaCloudOrderDetails.uploadedDocumentNameExists(uploadedDocuments),
                "The uploaded document (default document) was not found as expected.");
    }

    @And("I drag and drop all supported documents on the Upload Documents modal of the EA Cloud Order")
    public void iDragAndDropAllSupportedDocumentsOnTheUploadDocumentsModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        String[] uploadedDocuments = {"\\src\\test\\resources\\testvideos\\clearDiscrepancy.png",
                "\\src\\test\\resources\\testvideos\\txtUploadDocSample.txt", "\\src\\test\\resources\\testvideos\\testdoc.doc",
                "\\src\\test\\resources\\testvideos\\testdocx.docx","\\src\\test\\resources\\testvideos\\testbmp.bmp",
                "\\src\\test\\resources\\testvideos\\testgif.gif", "\\src\\test\\resources\\testvideos\\testjpeg.jpg",
                "\\src\\test\\resources\\testvideos\\testpdf.pdf", "\\src\\test\\resources\\testvideos\\testtif.tif",
                "\\src\\test\\resources\\testvideos\\testtiff.tif", "\\src\\test\\resources\\testvideos\\testxls.xls",
                "\\src\\test\\resources\\testvideos\\testxlsx.xlsx", "\\src\\test\\resources\\testvideos\\testcsv.csv"};
        eaCloudOrderDetails.dragNDropDocumentFile(uploadedDocuments);
    }

    @Then("I can verify the successful upload message appears for the case documents of the EA Cloud order")
    public void iCanVerifyTheSuccessfulUploadMessageAppearsForTheCaseDocumentsOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.docUploadSuccessMessageExists();
    }

    @And("I enter a new email address {string} on the Customer Support Inquiry modal of the EA Cloud Order")
    public void iEnterANewEmailAddressOnTheCustomerSupportInquiryModalOfTheEACloudOrder(String email) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.enterSupportEmailAddress(email);
    }

    @Given("I navigate to the EA Cloud test page")
    public void iNavigateToTheEACloudTestPage() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.navigateToTestPage();
    }

    @And("I create a new EA Cloud Order from {string} and launch the OneTimeLink")
    public void iCreateANewEACloudOrderFromAndLaunchTheOneTimeLink(String filepath) throws Exception {
        filepath ="/src/test/resources/templates/ea.cloud/" + filepath ;
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.copyPasteNewXmlContent(filepath);
        eaCloudOrderDetails.createOrderAndNavigateToOneTimeLink();
    }
    @And("I verify the invalid phone number formatting message no longer displays")
    public void iVerifyTheInvalidPhoneNumberFormattingMessageNoLongerDisplays() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertEquals(eaCloudOrderDetails.invalidPhoneNumberMessageExists(), "false", "Invalid " +
                "Phone Number message appears when it was not expected.");
    }

    @And("I verify the submit button is enabled on the Customer Support Inquiry modal of the EA Cloud Order")
    public void iVerifyTheSubmitButtonIsEnabledOnTheCustomerSupportInquiryModalOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(eaCloudOrderDetails.customerServiceSubmitButtonDisabled(), "false",
                "Submit button was not disabled as expected");
    }


    @And("I enter invalid phone numbers, verify formatting message displays, and submit button is disabled on the Inquiry modal")
    public void iEnterInvalidPhoneNumbersVerifyFormattingMessageDisplaysAndSubmitButtonIsDisabledOnTheInquiryModal(DataTable dataTable) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.checkInvalidPhoneNumberExists(dataTable);
    }

    @And("I click the Additional Information Tab on the EA Cloud Orders Details page")
    public void iClickTheAdditionalInformationTabOnTheEACloudOrdersDetailsPage() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickAdditionalInfoTab();
    }

    @And("I can verify the EA Cloud Additional Information Tab displays")
    public void iCanVerifyTheEACloudAdditionalInformationTabDisplays() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.verifyAdditionalInfoTab();
    }

    @And("I can verify the UserDefined Fields and Values exists on the Additional Information page of the EA Cloud Order")
    public void iCanVerifyTheUserDefinedFieldsAndValuesExistsOnTheAdditionalInformationPageOfTheEACloudOrder(DataTable dataTable) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.userDefinedFieldValueExists(dataTable);
    }

    @And("I enter case comments after waiting {string} on the order details tab of the EA Cloud Order")
    public void iEnterCaseCommentsAfterWaitingOnTheOrderDetailsTabOfTheEACloudOrder(String comment) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.enterDelayedComments(comment);
    }

    @Given("I navigate to an order with preset Case Comments as {string}")
    public void iNavigateToAnOrderWithPresetCaseCommentsAs(String comment) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.navigatetoPresetCommentOrder(comment);
    }


    @And("I click on the Filter Button and select {string} from the dropdown list")
    public void iClickOnTheFilterButtonAndSelectFromTheDropdownList(String header) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickFilterAndPendingButton(header);
    }

    @And("I click on cancel Adjudication button")
    public void iClickOnCancelAdjudicationButton() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickOvrAdjudicationCancelButton();
    }

    @Then("I can verify the {string} State of Adjudication on the EA Cloud Order Details page")
    public void iCanVerifyTheStateOfAdjudicationOnTheEACloudOrderDetailsPage(String state) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.confirmAdjudication(state), "Adjudication Status did not match.");
    }

    @And("I select a reason for the Pre-Adverse Letter on the EA Cloud Order")
    public void iSelectAReasonForThePreAdverseLetterOnTheEACloudOrder(DataTable dataTable) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.selectPreAdverseReason(dataTable);
    }

    @When("I enter the Internal Comment {string} for the Pre-Adverse Letter of the EA Cloud Order")
    public void iEnterTheInternalCommentForThePreAdverseLetterOfTheEACloudOrder(String comments) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.enterPreAdverseInternalComment(comments);
    }

    @And("I click Next button on the Pre-Adverse Modal Wizard of the EA Cloud Order")
    public void iClickNextButtonOnThePreAdverseModalWizardOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickPreAdverseNextButton();
    }

    @Then("I can verify the Next button is enabled for the Pre-Adverse Letter of the EA Cloud Order")
    public void iCanVerifyTheNextButtonIsEnabledForThePreAdverseLetterOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertEquals(eaCloudOrderDetails.PreAdverseNextButtonIsDisabled(), "false", "Next button was " +
                "disabled when it was not expected.");
    }

    @And("I can verify the Pre-Adverse Upload Documents Step Page appears in the Wizard of the EA Cloud Order")
    public void iCanVerifyThePreAdverseUploadDocumentsStepPageAppearsInTheWizardOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.preAdverseUploadDocumentsPage), "Pre-Adverse " +
                "Upload Documents Wizard Page did not appear as expected.");
    }

    @And("I can verify the Cancel button is enabled for the Pre-Adverse Letter of the EA Cloud Order")
    public void iCanVerifyTheCancelButtonIsEnabledForThePreAdverseLetterOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertEquals(eaCloudOrderDetails.PreAdverseCancelButtonIsDisabled(), "false", "Cancel button was " +
                "disabled when it was not expected.");
    }

    @Then("I can verify the Next button is disable for the Pre-Adverse Letter of the EA Cloud Order")
    public void iCanVerifyTheNextButtonIsDisableForThePreAdverseLetterOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertEquals(eaCloudOrderDetails.PreAdverseNextButtonIsDisabled(), "true", "Next button was " +
                "enabled when it was not expected.");
    }

    @And("I verify the reason for the Pre-Adverse Letter is checked on the EA Cloud Order")
    public void iVerifyTheReasonForThePreAdverseLetterIsCheckedOnTheEACloudOrder(DataTable dataTable) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(eaCloudOrderDetails.isCheckboxChecked(dataTable), "A value was not checked as expected.");
        softAssert.assertAll();
    }

    @And("I can verify the Cancel button exists for the Pre-Adverse Letter of the EA Cloud Order")
    public void iCanVerifyTheCancelButtonExistsForThePreAdverseLetterOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.preAdverseCancelButton), "Cancel " +
                "button was not found.");
    }

    @And("I click the cancel button on the Correspondence letter of the EA Cloud Order")
    public void iClickTheCancelButtonOnTheCorrespondenceLetterOfTheEACloudOrder() throws Exception{
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.cancelCorrespondenceLetter();
    }

    @And("I click on No button to reject the cancellation of Correspondence letter of the EA Cloud Order")
    public void iClickOnNoButtonToRejectTheCancellationOfCorrespondenceLetterOfTheEACloudOrder() throws Exception{
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.rejectCancellationCorrespondenceLetter();
    }

    @And("I click on Yes button to accept the cancellation of Correspondence letter of the EA Cloud Order")
    public void iClickOnYesButtonToAcceptTheCancellationOfCorrespondenceLetterOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.acceptCancellationCorrespondenceLetter();
    }

    @And("I click on the Correspondence letter page.")
    public void iClickOnTheCorrespondenceLetterPage() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickCorrespondencepage();
    }

    @Then("I can verify the No Documents Message appears on the Case Documents Tab of the EA Cloud Order")
    public void iCanVerifyTheNoDocumentsMessageAppearsOnTheCaseDocumentsTabOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.verifyNoDocuments();
    }

    @And("I can click on the view button for the document {string} on the Case Documents Tab of the EA Cloud Order")
    public void iCanClickOnTheViewButtonForTheDocumentOnTheCaseDocumentsTabOfTheEACloudOrder(String documentName) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickDocumentViewButton(documentName);
    }

    @And("I can verify the document opens within the viewer of the EA Cloud Order")
    public void iCanVerifyTheDocumentOpensWithinTheViewerOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.verifyDocumentLoaded();
    }

    @Then("I can verify comments cannot be added to the document from the Case Documents Tab of the EA Cloud Order")
    public void iCanVerifyCommentsCannotBeAddedToTheDocumentFromTheCaseDocumentsTabOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertFalse(eaCloudOrderDetails.exists(eaCloudOrderDetails.noDocumentCommentSection), "Comments were " +
                "found when not expected.");
    }

    @When("I click the checkbox for one of the existing documents on the Case Documents page for the EA Cloud Order")
    public void iClickTheCheckboxForOneOfTheExistingDocumentsOnTheCaseDocumentsPageForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.selectCaseDocument1stCheckBox();
    }

    @And("I click to uncheck the existing document on the Case Documents page for the EA Cloud Order")
    public void iClickToUncheckTheExistingDocumentOnTheCaseDocumentsPageForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.selectCaseDocument1stCheckBox();
    }

    @Then("I enter random text on the {string} textbox in Customer Support Inquiry for the EA Cloud Order")
    public void iEnterRandomTextOnTheEmailTextboxInCustomerSupportInquiryForTheEACloudOrder(String value) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertEquals(eaCloudOrderDetails.enterRandomTextboxComment(value),2000);
    }

    @And("I create a general EA Cloud Order and launch the OneTimeLink")
    public void iCreateAGeneralEACloudOrderAndLaunchTheOneTimeLink() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.copyPasteNewXmlContent("/src/test/resources/templates/ea.cloud/GeneralOrder_xchange.xml");
        eaCloudOrderDetails.createOrderAndNavigateToOneTimeLink();
    }

    @And("I verify that the EA Cloud Order XML from {string} loads and it fails to create a new Order")
    public void iVerifyThatTheEACloudOrderXMLFromLoadsAndItFailsToCreateANewOrder(String filepath) throws Exception {
        filepath ="/src/test/resources/templates/ea.cloud/" +filepath;
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.copyPasteNewXmlContent(filepath);
        Assert.assertTrue(eaCloudOrderDetails.createFailedOrderAndNavigateToOneTimeLink(),"Order creation was successful when it was not expected.");
    }

    @And("I expand the {string} Search Type Details and verify the following fields with values")
    public void iExpandTheSearchTypeDetailsAndVerifyTheFollowingFieldsWithValues(String searchType, DataTable dataTable) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.expandSearchType(searchType);
        eaCloudOrderDetails.searchTypeDetailsAndValuesExists(searchType, dataTable);
    }

    @And("I click the Disagree button on the Notice Agreement page for the EA Cloud Order")
    public void iClickTheDisagreeButtonOnTheNoticeAgreementPageForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickNoticeDisagreeButton();
    }

    @Then("I can verify the decline message appears for the permissible purpose certification for the EA Cloud Order")
    public void iCanVerifyTheDeclineMessageAppearsForThePermissiblePurposeCertificationForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.declinePermissiblePurCertMessage), "Permissible Purpose" +
                "decline message did not appear as expected.");
    }

    @And("I click the Exit button on permissible purpose certification decline message for the EA Cloud Order")
    public void iClickTheExitButtonOnPermissiblePurposeCertificationDeclineMessageForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickPermissiblePurposeExitButton();
    }

    @And("I can verify the Exit This Screen button appears on the permissible purpose certification for the EA Cloud Order")
    public void iCanVerifyTheExitThisScreenButtonAppearsOnThePermissiblePurposeCertificationForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.permissiblePurposeExitButton), "Exit button did not " +
                "appear as expected.");
    }

    @And("I can verify the control has returned to the xml window for the EA Cloud Simulator")
    public void iCanVerifyTheControlHasReturnedToTheXmlWindowForTheEACloudSimulator() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.testPageXmlWindow), "Control was not returned to " +
                "the xml window as expected.");
    }

    @And("I can verify the Go Back button appears on the permissible purpose certification for the EA Cloud Order")
    public void iCanVerifyTheGoBackButtonAppearsOnThePermissiblePurposeCertificationForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.permissiblePurposeGoBackButton), "Go Back button did not " +
                "appear as expected.");
    }

    @And("I click the Go Back button on permissible purpose certification decline message for the EA Cloud Order")
    public void iClickTheGoBackButtonOnPermissiblePurposeCertificationDeclineMessageForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickPermissiblePurposeGoBackButton();
    }

    @And("I can verify the notice agreement page appears for the EA Cloud Order")
    public void iCanVerifyTheNoticeAgreementPageAppearsForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.noticeAgreement), "Notice Agreement page did" +
                "not appear as expected.");
    }

    @Then("I can verify the No Data Available message appears for the Customer Reference Fields table for the EA Cloud Order")
    public void iCanVerifyTheNoDataAvailableMessageAppearsForTheCustomerReferenceFieldsTableForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.verifyNoDataAvailableInReferenceFields();
    }

    @And("I can verify the No Data Available message appears for the User Defined Fields table for the EA Cloud Order")
    public void iCanVerifyTheNoDataAvailableMessageAppearsForTheUserDefinedFieldsTableForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.verifyUserDefinedMessageNoData();
    }

    @And("I click the Support Inquiry button for the EA Cloud Order")
    public void iClickTheNewSupportInquiryButtonfortheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickSupportInquiry();
    }

    @And("I can click the Case History Tab")
    public void iCanClickTheCaseHistoryTab()throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickCaseHistory();
    }

    @Then("I can verify that the Case History Tab has no Data")
    public void iCanVerifyThatTheCaseHistoryTabHasNoData()throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickCaseHistoryNoData();
    }

    @Then("I verify that the Name tag displays properly in the Order Summary")
    public void iVerifyThatTheNameTagDisplaysProperlyInTheOrderSummary() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.verifyOrderSummaryNameTag();

    }

    @And("I expand the Order Summary")
    public void iExpandTheOrderSummary() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.expandOrderSummary();
    }


    @Then("I can verify Candidate Name for the EA Cloud Order")
    public void iCanVerifyCandidateNameForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        Assert.assertTrue(eaCloudOrderDetails.exists(eaCloudOrderDetails.candidateInformationSection));
    }

    @And("I verify that the Name displays properly as {string} in the Order Summary")
    public void iVerifyThatTheNameDisplaysProperlyAsInTheOrderSummary(String noName) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.verifyOrderName(noName);
    }

    @Then("I scroll down to verify the Footer")
    public void iScrollDownToVerifyTheFooter()throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.verifyFooter();
    }

    @And("I check the Search Type Details under the subheader {string} and verify the fields are displaying on the EA Cloud Order Details Page")
    public void iCheckTheSearchTypeDetailsUnderTheSubheaderAndVerifyTheFieldsAreDisplayingOnTheEACloudOrderDetailsPage(String subHeader, DataTable dataTable) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.searchTypeDetailsAndValuesExists(subHeader, dataTable);
    }
	
	 @Then("I verify that the {string} displays properly in the Order Summary")
    public void iVerifyThatTheDisplaysProperlyInTheOrderSummary(String infoPanel) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.orderSummaryVerifyPackageID(infoPanel);
    }

    @And("I close current browser for EA Cloud")
    public void iCloseCurrentBrowserForEACloud() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.closeEACloudBrowserTab();
    }

    @When("I click the View Report button on the order summary page for the EA Cloud Order")
    public void iClickTheViewReportButtonOnTheOrderSummaryPageForTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.clickViewReportButton();
    }

    @Then("I can verify the report opens within the viewer of the EA Cloud Order")
    public void iCanVerifyTheReportOpensWithinTheViewerOfTheEACloudOrder() throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.verifyReportViewerLoaded();
    }

    @And("I wait for {int} seconds after refreshing the browser of the EA Cloud Order")
    public void iWaitForSecondsAfterRefreshingTheBrowserOfTheEACloudOrder(int secondsToWait) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.refreshBrowserAndWait(secondsToWait);
    }

    @Then("I verify that {string} in {string} has data")
    public void iVerifyThatInHasData(String subHeader, String header) throws Exception {
        EACloudOrderDetails eaCloudOrderDetails = getEaCloudPageObject();
        eaCloudOrderDetails.subHeaderVerify(header,subHeader);
    }

}
