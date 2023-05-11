package com.fadv.automation.pageobjects;

import com.fadv.automation.core.Environment;
import com.fadv.automation.core.SeleniumBaseClass;
import com.fadv.automation.core.SharedBaseClass;
import io.cucumber.datatable.DataTable;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

public class EACloudOrderDetails extends SeleniumBaseClass {
    static Logger logger = Logger.getLogger(EACloudOrderDetails.class.getName());

    public final By createOrderButton = By.xpath("//button[@data-test-id='createOrder']");
    public final By retrieveCaseButton = By.xpath("//button[contains(text(),'Retrieve Case')]");
    public final By caseIdTextBox = By.xpath("//input[@id='caseId']");
    public final By oneTimeLink = By.xpath("//span[contains(text(),'Link:')]/following::a");
    public final By oneTimeLinkButton = By.xpath("//button[@data-test-id='oneTimeLink']");
    public final By noticeAgreeButton = By.xpath("//fadv-button[@id='pp-agree']");
    public final By noticeAgreement = By.xpath("//fadv-card-body");
    public final By orderDetailsSummaryTab = By.xpath("//fadv-tab[@id='summary-tab']");
    public final By cancelCaseDropdown = By.xpath("//fadv-button[@id='cancelCaseButton']/following::fadv-dropdown[1]");
    public final By customerServiceInquiryPopup = By.xpath("//fadv-modal-header[contains(text(),'Send Support Inquiry')]");
    public final By customerServiceCommentsTextBox = By.xpath("//fadv-textarea[@id='inquiryMessageTextarea']");
    public final By customerServiceInquiryPhone = By.xpath("//fadv-input[@id='inquiryPhoneNumberInput']");
    public final By cancelButton = By.xpath("//fadv-button[@id='inquiryCancelButton']");
    public final By caseCommentsHeader = By.xpath ("//fadv-typography[contains(text(),'Case Comments')]");
    public final By caseCommentsInput = By.xpath("//fadv-box/fadv-message-box/fadv-message-input");
    public final By caseCommentEnterButton = By.xpath("//fadv-message-input//sl-input/sl-icon-button//button");
    public final By caseDocumentsTab = By.xpath("//fadv-tab[@id='case-documents-tab']");
    public final By caseDocumentsPage = By.xpath("//div[contains(text(),'Case Documents')]");
    public final By caseDocumentsUploadButton = By.xpath("//fadv-button[@id='caseDocumentsUploadButton']");
    public final By caseDocumentUploadModal = By.xpath("//fadv-modal[@id='uploadModal']");
    public final By caseDocumentsFileUploader = By.xpath("//fadv-uploader");
    public final By caseDocumentUploadCommentTextBox = By.xpath("//fadv-card//fadv-textarea[contains(@formcontrolname,'comment')]");
    public final By caseDocumentRemoveFileButton = By.xpath("//fadv-button[contains(text(),'Remove File')]");
    public final By caseDocumentCancelButton = By.xpath("//fadv-button[@id='uploadModalCancelButton']");
    public final By caseDocumentTableHeader = By.xpath("//div[contains(text(),'Case Documents')]/following::thead");
    public final By caseDocumentUploadingMessage = By.xpath("//fadv-loader[@ng-reflect-open='true']");
    public final By caseDocumentDownloadButton = By.xpath("//fadv-button[contains(text(),'Download')]");
    public final By caseDocumentDropdownButton = By.xpath("//fadv-button[@id='caseDocumentsTableDropdownTrigger']");
    public final By caseDocumentDeleteMessage = By.xpath("//fadv-typography[contains(text(),'This will delete the file(s).')]");
    public final By caseDocumentDeleteExitButton = By.xpath("//fadv-button[@id='exitButton']");
    public final By caseDocumentDeleteFilesButton = By.xpath("//fadv-button[@id='deleteFilesButton']");
    public final By caseDocumentSubmitButton = By.xpath("//fadv-button[@id='uploadModalSubmitButton']");
    public final By caseDocumentSelectAllCheckbox = By.xpath("//fadv-table[@id='caseDocumentsTable']//fadv-checkbox[1]");
    public final By correspondenceTab = By.xpath("//fadv-tab[@id='correspondence-tab']");
    public final By correspondencePage = By.xpath("//fadv-tab-panel[@ng-reflect-name='correspondence']");
    public final By preAdverseNewLetterButton = By.xpath("//fadv-button[@data-fadv-key='create_letter']");
    public final By preAdverseActionLetter = By.xpath("//fadv-typography[contains(text(),'Create New Letter')]");
    public final By adjudicationCaseButton = By.xpath("//fadv-button[@id='adjudicateCaseButton']");
    public final By adjudicationConductCaseModal = By.xpath("//fadv-typography[contains(text(), 'Conduct Case Adjudication')]");
    public final By cancelCase = By.xpath("//fadv-button[@id='cancelCaseButton']");
    public final By caseCancelExitButton = By.xpath("//fadv-button[@id='cancelOrderExitButton']");
    public final By caseSummaryofRights = By.xpath("//fadv-button[contains(@href,'summaryOfRights.pdf')]");
    public final By caseDocumentNameHeader = By.xpath("//th[contains(@id,'documentName')]/button");
    public final By adjudicationLetterTypeSelector = By.xpath("//fadv-select[@ng-reflect-name='letterType']");
    public final By adjudicationCommentsTextBox = By.xpath("//fadv-textarea[@id='adjudicationComment']");
    public final By adjudicationSubmitButton = By.xpath("//fadv-button[@id='caseAdjudicationButton']");
    public final By adjInternalCommentsTextBox = By.xpath("//fadv-textarea[@id='internalComment']");
    public final By testPageSpinner = By.xpath("//img[contains(@src,'spinner.gif')]");
    public final By testPageXmlWindow = By.xpath("//textarea[@name='custom-xml']");
    public final By caseAdditionalInfoTab = By.xpath("//fadv-tab[@id='additional-info-tab']");
    public final By preAAInternalCommentTextBox = By.xpath("//fadv-textarea[@data-fadv-key='new_letter_internal_comments']");
    public final By preAdverseUploadDocumentsPage = By.xpath("//fadv-typography[contains(text(),'Create New Letter')]");
    public final By preAdverseCancelButton = By.xpath("//fadv-button[contains(text(),'Cancel')]");
    public final By cancelCorrespondenceletter = By.xpath("//fadv-typography[contains(text(),'Create New Letter')]/following::fadv-button[contains(text(),'Cancel')]");
    public final By acceptCorrespondencelettercancel = By.xpath("//*[@id=\"sl-tab-panel-10\"]/app-correspondence/fadv-box/app-pre-adverse-action-letter-modal/fadv-modal[2]/fadv-button[2]");
    public final By rejectCorrespondencelettercancel = By.xpath("//*[@id=\"sl-tab-panel-10\"]/app-correspondence/fadv-box/app-pre-adverse-action-letter-modal/fadv-modal[2]/fadv-button[1]//button/span/fadv-typography");
    public final By clickoncorrespondencePage = By.xpath("//fadv-modal[@data-fadv-category='Pre_Adverse_Action_Letter']/fadv-modal-body");
    public final By noDocumentsMessage = By.xpath("//fadv-typography[contains(text(),'No Documents')]");
    public final By documentsLoadingMessage = By.xpath("//fadv-typography[contains(text(),'Loading')]");
    public final By documentsLoadedWidget = By.xpath("//div[@id='pageWidgetContainer1']");
    public final By noDocumentCommentSection = By.xpath("//div[contains(text(),'Case Documents')]/following::fadv-input");
    public final By caseDocument1stCheckbox = By.xpath("(//div[contains(text(),'Case Documents')]/following::fadv-checkbox)[2]");
    public final By eligibilityStatusDropDown = By.xpath("//fadv-select[@id='eligibilityStatus']");
    public final By invalidLoginToken = By.xpath("//fadv-toast[@message='Invalid login']");
    public final By noticeDisagreeButton = By.xpath("//fadv-button[@id='pp-disagree']");
    public final By declinePermissiblePurCertMessage = By.xpath("//fadv-typography[contains(text(),'You have declined the Permissible Purpose')]");
    public final By permissiblePurposeExitButton = By.xpath("//fadv-button[contains(text(),'Exit This Screen')]");
    public final By permissiblePurposeGoBackButton = By.xpath("//fadv-button[contains(text(),'Go Back')]");
    public final By customerServiceInquiryEmail = By.xpath("//fadv-input[@id='inquiryEmailInput']");
    public final By userDefinedMessageNoData = By.xpath("//*[@id=\"userDefinedFieldsTable\"]/div/div[2]/fadv-table-footer/div/fadv-typography[contains(text(),'No Data Available')]");
    public final By customerRefMessageNoData = By.xpath("//fadv-table[@id='customerReferenceFieldsTable']/following::fadv-typography[contains(text(),'No Data Available')][1]");
    public final By candidateInformationSection = By.xpath("//fadv-info-panel[@heading='CANDIDATE INFORMATION']");
    public final By supportInquiry = By.xpath("//fadv-button[@id='supportInquiry']");
    public final By caseHistoryTab = By.xpath("//fadv-tab[@id=\"case-history-tab\"]");
    public final By getCaseHistoryNoData = By.xpath("//*[@id=\"sl-tab-panel-8\"]/app-case-history/fadv-box/fadv-table/div/div/fadv-table-footer/fadv-box/fadv-typography/text()");
    public final By orderSummaryNameTag = By.xpath("//fadv-info-panel[@heading='CANDIDATE INFORMATION']/fadv-info-panel-item[@name='Name:']");
    public final By orderSummaryName = By.xpath("//*[@id=\"order-details-profile-details\"]/fadv-expansion-panel/fadv-info-panel[1]/fadv-info-panel-item[1]");
    public final By footerLegal = By.xpath("//fadv-footer/fadv-footer-item[1]");
    public final By footerPrivacyPolicy = By.xpath("//fadv-footer/fadv-footer-item[2]");
    public final By footerFact = By.xpath("//fadv-footer/fadv-footer-item[3]");
    public final By viewReportButton = By.xpath("//fadv-button[@id='viewReportButton']");
    public final By searchTypeStatusProRingBlue = By.xpath("//fadv-progress-ring[@variant='primary']");




    //*****FindBy WebElements******
    @FindBy(xpath = "//span[contains(text(),'Link:')]")
    public WebElement linkLabel_WebElement;

    @FindBy(xpath = "//span[contains(text(),'Link:')]")
    public WebElement oneTimeLinkLabel_WebElement;

    @FindBy(xpath = "//span[contains(text(),'Link:')]/following::a")
    public WebElement oneTimeLink_WebElement;

    @FindBy(xpath = "//fadv-card-body")
    public WebElement noticeAgreement_WebElement;

    @FindBy(xpath = "//fadv-button[@id='pp-disagree']")
    public WebElement noticeDisagreeButton_WebElement;

    @FindBy(xpath = "//fadv-application//fadv-button[@id='pp-agree']")
    public WebElement noticeAgreementButton_WebElement;

    @FindBy(xpath = "//*[contains(text(),'Create Order Response')]")
    public WebElement createOrderResponse_WebElement;

    @FindBy(xpath = "//*[contains(text(),'Search Types')]/following::tr")
    public List<WebElement> searchTypeRows_WebElement;

    @FindBy(xpath = "//*[contains(text(),'Search Types')]/following::td[4]")
    public WebElement searchTypeColumn_WebElement;

    @FindBy(xpath = "//fadv-button[@id='cancelCaseButton']/following::fadv-dropdown[1]")
    public WebElement cancelButtonDropdown_WebElement;

    @FindBy(xpath = "//fadv-menu-item[contains(text(),'Support Inquiry')]")
    public WebElement supportInquiryMenuItem_WebElement;

    @FindBy(xpath = "//fadv-button[@id='inquirySubmitButton']")
    public WebElement customerSupportSubmitButton_WebElement;

    @FindBy(xpath = "//fadv-input[@id='inquiryEmailInput']")
    public WebElement customerServiceInquiryEmail_WebElement;

    @FindBy(xpath = "//fadv-input[@id='inquiryPhoneNumberInput']")
    public WebElement customerServiceInquiryPhone_WebElement;

    @FindBy(xpath = "//fadv-typography[contains(text(),'Case Comments')]")
    public WebElement caseCommentsHeader_WebElement;

    @FindBy(xpath = "//fadv-message-input//sl-input/sl-icon-button//button")
    public WebElement caseCommentEnterButton_WebElement;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement caseDocumentUploadArea_WebElement;

    @FindBy(xpath = "//fadv-button[@id='uploadModalSubmitButton']")
    public WebElement caseDocumentSubmitButton_WebElement;

    @FindBy(xpath = "//fadv-uploader/div/div[1]")
    public WebElement caseDocumentDragNDropZone_WebElement;

    @FindBy(xpath = "//fadv-button[@id='caseDocumentsUploadButton']")
    public WebElement caseDocumentUploadButton_WebElement;

    @FindBy(xpath = "//fadv-input[@name='fullName']")
    public WebElement preAdverseFullName_WebElement;

    @FindBy(xpath = "//fadv-input[@name='mailingAddress']")
    public WebElement preAdverseAddress_WebElement;

    @FindBy(xpath = "//fadv-input[@name='cityStateZip']")
    public WebElement preAdverseCityStateZip_WebElement;

    @FindBy(xpath = "//fadv-input[@name='phoneNumber']")
    public WebElement preAdversePhone_WebElement;

    @FindBy(xpath = "//fadv-button[@id='caseAdjudicationButton']")
    public WebElement adjudicationSubmitButton_WebElement;

    @FindBy(xpath = "//fadv-toast")
    public WebElement cDocSuccessMessage_WebElement;

    @FindBy(xpath = "//div[contains(text(),'Customer Reference')]")
    public WebElement customerReferenceFieldsTitle;

    @FindBy(xpath = "//div[contains(text(),'User Defined')]")
    public WebElement userDefinedFieldsTitle;

    @FindBy(xpath= "//*[contains(text(),'UDF')]/following::td/fadv-typography")
    public List<WebElement> userDefinedNodes;

    @FindBy(xpath = "//div[contains(text(),'Case Documents')]/following::table[1]/tbody/tr")
    public List<WebElement>  caseDocumentRows;

    @FindBy(xpath = "//button[@data-test-id='createOrder']")
    public WebElement createOrderButton_WebElement;

    @FindBy(xpath = "//fadv-filter")
    public WebElement clickFilterButton_WebElement;

    @FindBy(xpath = "//fadv-menu-item-checkbox[contains(text(),'Pending')]")
    public WebElement filterPendingButton_WebElement;

    @FindBy(xpath = "//fadv-button[@id='cancelCaseAdjudicationButton']")
    public WebElement adjudicationCancelButton_WebElement;

    @FindBy(xpath = "//fadv-badge[1]")
    public WebElement getAdjudicationStatus_WebElement;

    @FindBy(xpath= "//fadv-button[contains(text(),'Next')]")
    public WebElement preAdverseNextButton_WebElement;

    @FindBy(xpath= "//fadv-button[contains(text(),'Cancel')]")
    public WebElement preAdverseCancelButton_WebElement;

    @FindBy(xpath = "//*[@id=\"sl-tab-panel-10\"]/app-correspondence/fadv-box/app-pre-adverse-action-letter-modal/fadv-modal[1]/fadv-button[1]")
    public WebElement cancelCorrespondenceletter_WebElement;

    @FindBy(xpath =  "//div[@class='webviewer']")
    public WebElement documentViewer;

    @FindBy(xpath = "//fadv-textarea[@id='inquiryMessageTextarea']")
    public WebElement customerServiceCommentsTextBox_WebElement;

    @FindBy(xpath = "fadv-message-input[@data-fadv-category='Case_Details_Summary']")
    public WebElement caseCommentsInput_WebElement;

    @FindBy(xpath = "//fadv-typography[contains(text(),'This will cancel the order')]")
    public WebElement cancelCaseModal_WebElement;

    @FindBy(xpath = "//fadv-menu-category")
    public WebElement caseFilterCategoryMenu;

    @FindBy(xpath =  "//*[@id=\"menu-category-item-1\"]")
    public WebElement filterResultButton_WebElement;

    @FindBy(xpath =  "//fadv-toast[@message='Invalid login']")
    public WebElement invalidLoginToken_WebElement;

    @FindBy(xpath = "//textarea[@name='custom-xml']")
    public WebElement testPageXmlWindow_WebElement;

    @FindBy(xpath = "//*[@id=\"sl-tab-panel-8\"]/app-case-history/fadv-box/fadv-table/div/div/fadv-table-footer/fadv-box/fadv-typography/text()")
    public WebElement getCaseHistoryNoData_WebElement;

    @FindBy(xpath = "//img[contains(@src,'spinner.gif')]")
    public WebElement testPageSpinner_WebElement;

    @FindBy(xpath = "//fadv-footer")
    public WebElement testPageFooter_WebElement;

    @FindBy(xpath = "//input[@id='providerIdCtrl']")
    public WebElement simulatorProviderRefId_WebElement;

    @FindBy(xpath = "//iframe[@id='webviewer-1']")
    public WebElement viewReportViewer_WebElement;


    //Web Methods

    public void navigateToOrderDetails() throws Exception {
        navigateToTestPage();
        clickCreateOrderButton();
        clickOneTimeLinkButton();
    }

    public void redirectToExistingOrderUrl(String orderId){
        String currUrl = driver.getCurrentUrl();
        String replacedUrl = currUrl.replaceAll("order-details/\\d+", "order-details/" + orderId);
        driver.get(replacedUrl);
        logger.info("current url: " + replacedUrl);
    }


    public void navigateToExistingOrderDetails(String caseId) throws Exception {
        driver.get(Environment.getCloudEnvironmentBaseUrl());
        waitForSeconds(2);
        clickCreateOrderButton();
        enterExistingCaseViaSimulator(caseId);
        clickRetrieveCaseButton();
        clickElement(oneTimeLink);
    }

    public void clickCreateOrderButton() throws Exception {
        waitForElementPresent(createOrderButton_WebElement);
        waitForElementClickable(createOrderButton);
        clickElement(createOrderButton);
        waitForDisappear(testPageSpinner_WebElement, 75);
        waitForElementPresent(createOrderResponse_WebElement);
        retrieveProviderRefId();
    }

    public void clickRetrieveCaseButton() throws InterruptedException {
        waitForElementClickable(retrieveCaseButton);
        clickElement(retrieveCaseButton);
        waitForDisappear(testPageSpinner_WebElement, 60);
        waitForElementPresent(oneTimeLinkLabel_WebElement);
    }

    public void clickOneTimeLinkButton(){
        waitForElementClickable(oneTimeLinkButton);
        clickElement(oneTimeLinkButton);
        waitForDisappear(testPageSpinner_WebElement, 5);
        waitForElementPresent(oneTimeLinkLabel_WebElement);
        String oneTimeLinkURL =  getAttribute(oneTimeLink_WebElement, "innerHTML");
        report("OneTimeLink is: " + oneTimeLinkURL);
        logger.info("OneTimeLink is: " + oneTimeLinkURL);
        waitForElementPresent(oneTimeLink_WebElement);
        clickElement(oneTimeLink);
        logger.info("OneTimeLink clicked and preparing to navigate...");
    }

    public void clickNoticeAgreeButton() throws Exception {
        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);
        sharedBaseClass.switchWindow();
        waitForElementPresent(noticeAgreement_WebElement);
        waitForElementPresent(noticeAgreementButton_WebElement);
        scrollTo(noticeAgreementButton_WebElement);
        waitForElementClickable(noticeAgreeButton);
        clickElement(noticeAgreeButton);
        waitForDisappear(noticeAgreeButton, 30);
    }

    public void clickNoticeDisagreeButton() throws Exception {
        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);
        sharedBaseClass.switchWindow();
        waitForElementPresent(noticeAgreement_WebElement);
        waitForElementPresent(noticeDisagreeButton_WebElement);
        scrollTo(noticeDisagreeButton_WebElement);
        waitForElementClickable(noticeDisagreeButton);
        clickElement(noticeDisagreeButton);
        waitForDisappear(noticeDisagreeButton, 30);
    }

    public void clickPermissiblePurposeExitButton() throws Exception {
        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);
        waitForElementClickable(permissiblePurposeExitButton);
        clickElement(permissiblePurposeExitButton);
        waitForDisappear(permissiblePurposeExitButton, 15);
        sharedBaseClass.switchWindow();
    }

    public void clickPermissiblePurposeGoBackButton() throws Exception {
        waitForElementClickable(permissiblePurposeGoBackButton);
        clickElement(permissiblePurposeGoBackButton);
        waitForDisappear(permissiblePurposeGoBackButton, 30);
    }

    public Boolean searchTypeExists(String searchTypeName){
        for(WebElement element: searchTypeRows_WebElement){
            logger.info("checking row: " + getText(element));
            if(getText(element).contains(searchTypeName)){
                return true;
            }
        }
        return false;
    }

    public Boolean searchTypeDetailsExists(String searchType, DataTable dataTable) {
//cycle through each search type row. if currentType is the correct type then check xpath following this row
        List<String> detailElements = dataTable.asList();
        for (WebElement element : searchTypeRows_WebElement.subList(1, searchTypeRows_WebElement.size()))
        {
            logger.info("checking row: " + getText(element));
            if (getText(element).contains(searchType))
            {
                for (String dElement : detailElements) {
                    logger.info("Checking detail element: " + dElement);
                    String xpath = String.format("//*[contains(text(),'Search Types')]/following::td[4]/following::fadv-box[contains(text(),'%s')]", dElement);
                    if (exists(By.xpath(xpath), 5)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String adjudicationSubmitButtonIsDisabled(){
        return getAttribute(adjudicationSubmitButton_WebElement, "ng-reflect-disabled");
    }

    public String PreAdverseNextButtonIsDisabled(){
        return getAttribute(preAdverseNextButton_WebElement, "ng-reflect-disabled");
    }

    public String PreAdverseCancelButtonIsDisabled(){
        return getAttribute(preAdverseCancelButton_WebElement, "ng-reflect-disabled");
    }

    public void expandSearchType(String searchType){
        String xpath = String.format("//fadv-typography[text()='\s%s\s']/following::button[1]", searchType);
        WebElement element = driver.findElement(By.xpath(xpath));
        //added extra wait and scrolling to element now that cs bubble seems to be an obstruction to the arrows
        waitForElementPresent(element);
        scrollTo(element);
        waitForElementClickable(By.xpath(xpath));
        clickElement(element);
        logger.info("Expanded Search Type " + searchType + xpath);
        waitForSeconds(5);
    }

    public void collapseSearchType(String searchType){
        String xpath = String.format("//fadv-typography[contains(text(),'%s')]/following::button[@aria-expanded='true'][1]", searchType);
        clickElement(By.xpath(xpath));
        waitForSeconds(2);
    }

    public void searchTypeDetailsExistsInExpanded(String searchType, DataTable dataTable){
        List<String> detailElements = dataTable.asList();
        SoftAssert softAssert = new SoftAssert();
        for (String dElement : detailElements) {
            logger.info("Checking detail element: " + dElement);
            String xpath = String.format("//fadv-typography[contains(text(),'%s')]/following::fadv-box/fadv-typography[contains(text(),'%s')]", searchType, dElement);
            boolean checkResults = exists(By.xpath(xpath));
            softAssert.assertTrue(checkResults, "Detail Element was not found: "  + dElement);
        }
        softAssert.assertAll();
    }


    public void searchTypeDetailsAndValuesExists(String searchType, DataTable dataTable){
        List<List<String>> tableValues = dataTable.asLists();
        SoftAssert softAssert = new SoftAssert();
        int tableSize = tableValues.size();
        logger.info("tablesize " + tableSize);

        for (int n =0; n < tableValues.size(); n++) {
            logger.info("N is: " + n);
            String tableHeader = tableValues.get(n).get(0);
            String tableHeaderValue = tableValues.get(n).get(1);
            String elementValueXpath2 = String.format("//fadv-typography[text()='\s%s\s']/following::fadv-typography[contains(text(),'%s')]/following::" +
                    "fadv-grid-col[1]", searchType, tableHeader);
            logger.info("elementValueXpath2 is: " + elementValueXpath2);
            WebElement elementValue = driver.findElement(By.xpath(elementValueXpath2));
            String currentElementValue = getText(elementValue);
            softAssert.assertTrue(tableHeaderValue.equalsIgnoreCase(currentElementValue), "Search Type " + searchType + " detail " +
                    tableHeaderValue + " not found for " + tableHeader + ". Captured " + currentElementValue + " instead.");
        }
    }


    public void clickCancelButtonDropdown(){
        waitForElementPresent(cancelButtonDropdown_WebElement);
        clickElement(cancelCaseDropdown);
    }

    public void selectSupportInquiry(){
        clickCancelButtonDropdown();
        javaScriptClick(supportInquiryMenuItem_WebElement);
    }

    public String retrieveEmailAddressValue(){
        clickElement(customerServiceInquiryEmail_WebElement);
        waitForSeconds(2);
        logger.info("email address retrieved: " + getAttribute(customerServiceInquiryEmail_WebElement, "value"));
        return getAttribute(customerServiceInquiryEmail_WebElement, "value");
    }


    public void clickCancelButton(){
        clickElement(cancelButton);
    }

    public void clickCustomerSupportSubmitButton(){
        scrollTo(customerSupportSubmitButton_WebElement);
        waitForElementPresent(customerSupportSubmitButton_WebElement);
        clickElement(customerSupportSubmitButton_WebElement);
    }

    public void enterCustomerServiceInquiryPhoneNumber(String phoneNumber, Boolean clearExistingNumber){
        clickElement(customerServiceInquiryPhone_WebElement);
        waitForSeconds(3);
        if (clearExistingNumber){
            logger.info("Clearing Phone Number field...");
            clearCustomerServicePhoneNumber();
            logger.info("Phone Number field cleared!");
        }
        setElementValueNoClear(customerServiceInquiryPhone, phoneNumber);
    }

    public void enterCaseComments(String comments){
        waitForElementPresent(caseCommentsHeader_WebElement);
        clickElement(caseCommentsInput);
        setElementValueNoClear(caseCommentsInput, comments);
        //key set
        testObject.setTestData("CaseComments", comments);
    }



    public void clickCaseCommentEnterButton(){
        SearchContext host = driver.findElement(By.xpath("//fadv-message-input"));
        SearchContext shadowContent1 = expandRootElement(host);
        SearchContext root2 = shadowContent1.findElement(By.cssSelector("sl-input > sl-icon-button"));
        SearchContext shadowContent2 = expandRootElement(root2);
        WebElement enterButton = shadowContent2.findElement(By.cssSelector("button"));
        clickElement(enterButton);
        waitForSeconds(3);
        testObject.setTestData("CaseEaDateTime", getCurrentDate());
    }


    public boolean isUserInCommentSection(String user){
        String xpath = String.format("//fadv-message[@heading='%s']", user);
        return exists(By.xpath(xpath));
    }

    public boolean isCommentSavedInCommentSection(String comment){
        String xpath = String.format("//fadv-message[contains(text(),'%s')]", comment);
        return exists(By.xpath(xpath));
    }

    public String getSaveDocumentUploadComment(String documentName){
        String xpath = String.format("//fadv-typography[contains(text(),'%s')]/following::fadv-input", documentName);
        return driver.findElement(By.xpath(xpath)).getAttribute("value");
    }

    public void enterExistingCaseViaSimulator(String caseNumber){
        setElementValueNoClear(caseIdTextBox, caseNumber);
    }

    public String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMMM d, yyyy", Locale.US);
        Date date = new Date();
        return formatter.format(date);
    }

    public void verifyCaseCommentEntries(){
        waitForSeconds(5);
        Assert.assertTrue(isUserInCommentSection("Enterprise User"), "User was not found in case comment section");
        Assert.assertFalse((getCurrentDate().compareTo(testObject.getTestData("CaseEaDateTime")) < 0),"Comment entry was not found before current day/time");
    }


    public void clickCaseDocumentsTab(){
        waitForElementClickable(caseDocumentsTab);
        clickElement(caseDocumentsTab);
        //comment this out since this is temporarily hidden until after 1st MVP Pilot Release
//        waitForElementClickable(caseDocumentsUploadButton);
    }

    public void clickCaseDocumentsUploadButton(){
        waitForElementClickable(caseDocumentsUploadButton);
        clickElement(caseDocumentsUploadButton);
    }

    public boolean caseDocumentsUploadButtonExists(){
        waitForSeconds(5);
        return exists(caseDocumentsUploadButton);
    }

    public void uploadDocument(String... files){
        for(String file: files) {
            String directory = System.getProperty("user.dir") + file;
            logger.info("directory/folder path:  " + directory);
            caseDocumentUploadArea_WebElement.sendKeys(directory);
            waitForSeconds(7);
        }
    }

    public Boolean uploadedDocumentNameExists(String... documentNameToSearch){
        for(String document: documentNameToSearch) {
            String xpath = String.format("//fadv-card//fadv-typography[contains(text(),'%s')]", document);
            return exists(By.xpath(xpath));
        }
        return false;
    }

    public Boolean documentDeleteModalConfirmationExists(String... documents){
        for (String document: documents){
            String xpath =  String.format("//fadv-grid[contains(comment(),'%s')]", document);
            return exists(By.xpath(xpath));
        }
        return false;
    }

    public void clickUploadDocumentRemoveFileButton(){
        waitForElementClickable(caseDocumentRemoveFileButton);
        clickElement(caseDocumentRemoveFileButton);
    }

    public void clickUploadDocumentSubmitButton(){
        waitForSeconds(1);
        scrollTo(caseDocumentSubmitButton_WebElement);
        clickElement(caseDocumentSubmitButton_WebElement);
    }

    public void dragNDropDocumentFile(String... files){
        String JS_DROP_FILE = "var k=arguments,d=k[0],g=k[1],c=k[2],m=d.ownerDocument||document;for(var e=0;;){var f=d.getBoundingClientRect(),b=f.left+(g||(f.width/2)),a=f.top+(c||(f.height/2)),h=m.elementFromPoint(b,a);if(h&&d.contains(h)){break}if(++e>1){var j=new Error('Element not interactable');j.code=15;throw j}d.scrollIntoView({behavior:'instant',block:'center',inline:'center'})}var l=m.createElement('INPUT');l.setAttribute('type','file');l.setAttribute('multiple','');l.setAttribute('style','position:fixed;z-index:2147483647;left:0;top:0;');l.onchange=function(q){l.parentElement.removeChild(l);q.stopPropagation();var r={constructor:DataTransfer,effectAllowed:'all',dropEffect:'none',types:['Files'],files:l.files,setData:function u(){},getData:function o(){},clearData:function s(){},setDragImage:function i(){}};if(window.DataTransferItemList){r.items=Object.setPrototypeOf(Array.prototype.map.call(l.files,function(x){return{constructor:DataTransferItem,kind:'file',type:x.type,getAsFile:function v(){return x},getAsString:function y(A){var z=new FileReader();z.onload=function(B){A(B.target.result)};z.readAsText(x)},webkitGetAsEntry:function w(){return{constructor:FileSystemFileEntry,name:x.name,fullPath:'/'+x.name,isFile:true,isDirectory:false,file:function z(A){A(x)}}}}}),{constructor:DataTransferItemList,add:function t(){},clear:function p(){},remove:function n(){}})}['dragenter','dragover','drop'].forEach(function(v){var w=m.createEvent('DragEvent');w.initMouseEvent(v,true,true,m.defaultView,0,0,0,b,a,false,false,false,false,0,null);Object.setPrototypeOf(w,null);w.dataTransfer=r;Object.setPrototypeOf(w,DragEvent.prototype);h.dispatchEvent(w)})};m.documentElement.appendChild(l);l.getBoundingClientRect();return l";
        for(String filePath: files) {
            String directory = System.getProperty("user.dir") + filePath;
            logger.info("directory/folder path:  " + directory);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement input = (WebElement) jse.executeScript(JS_DROP_FILE, caseDocumentDragNDropZone_WebElement, 0, 0);
            waitForElementPresent(caseDocumentDragNDropZone_WebElement);
            input.sendKeys(directory);
        }
    }

    public String isSubmitButtonDisabled(){
        return getAttribute(caseDocumentSubmitButton_WebElement, "ng-reflect-disabled");
    }

    public void clickUploadDocumentCancelButton(){
        waitForElementClickable(caseDocumentCancelButton);
        clickElement(caseDocumentCancelButton);
    }

    public void enterCommentsForUploadedDocument(String documentNameToSearch, String comments){
        String xpath = String.format("//fadv-card//fadv-typography[contains(text(),'%s')]/following::fadv-textarea", documentNameToSearch);
        SearchContext host = driver.findElement(By.xpath(xpath));
        SearchContext shadowContext1 =  expandRootElement(host);
        SearchContext root2 = shadowContext1.findElement(By.cssSelector("div"));
        SearchContext shadowContext2=  expandRootElement(root2);
        WebElement textArea = shadowContext1.findElement(By.cssSelector("textarea"));
        clickElement(textArea);
        waitForSeconds(2);
        textArea.sendKeys(comments);
        testObject.setTestData("DocumentComments", comments);
    }

    public void expandCaseDocumentType(String documentName){
        String xpath = String.format("//fadv-typography[contains(text(),'%s')]/following::button[@aria-expanded='false'][1]", documentName);
        clickElement(By.xpath(xpath));
    }

    public void clickCaseDocumentCheckbox(String documentName){
        String xpath = String.format("//fadv-typography[contains(text(),'%s')]/preceding::fadv-checkbox[1]", documentName);
        waitForElementClickable(By.xpath(xpath));
        clickElement(By.xpath(xpath));
        logger.info("clicked: " + xpath);
    }

    public void clickCaseDocumentDownloadButton(){
        waitForElementClickable(caseDocumentDownloadButton);
        clickElement(caseDocumentDownloadButton);
    }
    public void verifyCaseDocumentUploadMessage() throws InterruptedException {
        Assert.assertTrue(exists(caseDocumentUploadingMessage),
                "Case Document Uploading Message did not appear as expected.");
        waitForUploadMessageToDisappear();
        waitForElementClickable(caseDocumentsTab);
        waitForElementPresent(caseDocumentUploadButton_WebElement);
    }

    public void clickCaseDocumentDropdownMenuItem(String menuItem){
        clickElement(caseDocumentDropdownButton);
        waitForSeconds(1);
        String xpath = String.format("//fadv-menu-item[contains(text(),'%s')]", menuItem);
        clickElement(By.xpath(xpath));
        waitForSeconds(2);
    }

    public void verifyDeleteDocumentMessage(String documentName){
        String xpath = String.format("//app-delete-case-documents-modal//fadv-typography[contains(text(),'%s')]", documentName);
        Assert.assertTrue(exists(caseDocumentDeleteMessage), "Case Document Delete Message was not found.");
        Assert.assertTrue(exists(By.xpath(xpath)), "The delete message did not reference the expected selected document: " + documentName);
    }

    public void clickCaseDocumentExitButton(){
        waitForElementClickable(caseDocumentDeleteExitButton);
        clickElement(caseDocumentDeleteExitButton);
    }

    public void clickCaseDocumentDeleteButton(){
        waitForElementClickable(caseDocumentDeleteFilesButton);
        clickElement(caseDocumentDeleteFilesButton);
        waitForSeconds(7);
    }

    public Boolean caseDocumentExistsInTable(String documentName){
        String xpath = String.format("//div[contains(text(),'Case Documents')]/following::fadv-typography[contains(text(),'%s')][1]", documentName);
        return exists(By.xpath(xpath));
    }

    public void clickCaseDocumentSelectAllCheckBox(){
        clickElement(caseDocumentSelectAllCheckbox);
    }

    public void clickCorrespondenceTab(){
        waitForElementClickable(correspondenceTab);
        clickElement(correspondenceTab);
    }

    public void enterCommentsForCustomerSupport(String comments){
        clickElement(customerServiceCommentsTextBox);
        setElementValueNoClear(customerServiceCommentsTextBox, comments);
    }
    public Boolean searchTypesExists(DataTable dataTable){
        List<String> detailElements = dataTable.asList();
        for(WebElement element: searchTypeRows_WebElement){
            logger.info("element check from app Search Type table..." + getText(element));
            for(String dElement : detailElements){
                logger.info("Checking dataTable ... " + dElement);
                if(getText(element).contains(dElement)){
                    logger.info("found this : "+ dElement);
                    return true;
                }
            }
        }
        return false;
    }

    public void clickCancelCaseButton() {
        waitForElementClickable(cancelCase);
        clickElement(cancelCase);
    }

    public void clickEligibilityStatusDropdown(){
        waitForElementClickable(eligibilityStatusDropDown);
        clickElement(eligibilityStatusDropDown);
        waitForSeconds(3);
    }

    public void selectEligibilityStatus(String status){
        clickEligibilityStatusDropdown();
        String xpath = String.format("//fadv-menu-item[contains(text(),'%s')]", status);
        clickElement(By.xpath(xpath));
        logger.info("Selected status: " + status);
    }

    public Boolean isEligibilityStatusPresent(DataTable dataTable){
        List<String> statuses = dataTable.asList();
        waitForSeconds(3);
        for (String status : statuses) {
            logger.info("Checking for Status: " + status);
            String xpath = String.format("//fadv-dropdown/following::*[contains(text(),'%s')]", status);
            if (!exists(By.xpath(xpath), 5)) {
                logger.info(("Eligibility status was not found: " + status));
                return false;
            }
        }
        return true;
    }

    public Boolean getSelectedEligibilityStatus(String item){
        String xpath = String.format("//fadv-dropdown/following::*[contains(text(),'%s') and @checked]", item);
        return exists(By.xpath(xpath));
    }

    public void clickNewLetterButton(){
        waitForElementClickable(preAdverseNewLetterButton);
        clickElement(preAdverseNewLetterButton);
    }

    private void enterPreFullName(String fullName){
        String xpath =  "//fadv-input[@ng-reflect-name='fullName']";
        SearchContext host = driver.findElement(By.xpath(xpath));
        SearchContext shadowContext1 =  expandRootElement(host);
        WebElement preAdverseFullName = shadowContext1.findElement(By.cssSelector("div input"));
        waitForElementPresent(preAdverseFullName);
        clickElement(preAdverseFullName);
        preAdverseFullName.sendKeys(fullName);
    }

    private void enterPreMailingAddress(String address){
        String xpath =  "//fadv-input[@ng-reflect-name='mailingAddress']']";
        SearchContext host = driver.findElement(By.xpath(xpath));
        SearchContext shadowContext1 =  expandRootElement(host);
        WebElement preAdverseAddress = shadowContext1.findElement(By.cssSelector("div input"));
        clickElement(preAdverseAddress);
        setElementValueNoClear(preAdverseAddress, address);
    }

    private void enterPreCityStateZip(String cityStZip){
        String xpath =  "//fadv-input[@ng-reflect-name='cityStateZip']";
        SearchContext host = driver.findElement(By.xpath(xpath));
        SearchContext shadowContext1 =  expandRootElement(host);
        WebElement preAdverseCityStZip = shadowContext1.findElement(By.cssSelector("div input"));
        waitForElementPresent(preAdverseCityStZip);
        clickElement(preAdverseCityStZip);
        preAdverseCityStZip.sendKeys(cityStZip);
    }

    private void enterPrePhoneNumber(String phoneNumber){
        String xpath =  "//fadv-input[@ng-reflect-name='phoneNumber']";
        SearchContext host = driver.findElement(By.xpath(xpath));
        SearchContext shadowContext1 =  expandRootElement(host);
        WebElement preAdversePhone = shadowContext1.findElement(By.cssSelector("div input"));
        waitForElementPresent(preAdversePhone);
        clickElement(preAdversePhone);
        preAdversePhone.sendKeys(phoneNumber);
    }

    public void enterAdverseActionInformation(DataTable dataTable){
        List<Map<String, String>> nameAddressPhoneDetails = dataTable.asMaps();
        for (Map<String, String>  detail: nameAddressPhoneDetails) {
            logger.info("Checking detail: " + detail);
            enterPreFullName(detail.get("FullName"));
            enterPreMailingAddress(detail.get("Address"));
            enterPreCityStateZip(detail.get("CityStateZip"));
            enterPrePhoneNumber(detail.get("PhoneNumber"));
        }
    }

    public void checkAdverseActionInformation(DataTable dataTable){
        List<Map<String, String>> nameAddressPhoneDetails = dataTable.asMaps();
        SoftAssert softAssert = new SoftAssert();
        for (Map<String, String>  detail: nameAddressPhoneDetails) {
            logger.info("Checking detail: " + detail);
            softAssert.assertEquals(getPreAdverseFullName(),detail.get("FullName"), "Expected Full Name was not found.");
            softAssert.assertEquals(getPreAdverseAddress(),detail.get("Address"), "Expected Address was not found.");
            softAssert.assertEquals(getPreAdverseCityStateZip(),detail.get("CityStateZip"), "Expected CityStateZip was not found.");
            softAssert.assertEquals(getPreAdversePhone(),detail.get("PhoneNumber"), "Expected Phone Number was not found.");
            softAssert.assertAll();
        }
    }

    private String getPreAdverseFullName(){
        String xpath =  "//fadv-typography[contains(text(),'Create New')]/following::fadv-input[@ng-reflect-name='fullName']";

        SearchContext host = driver.findElement(By.xpath(xpath));
        SearchContext shadowContext1 =  expandRootElement(host);
        WebElement preAdverseFullName = shadowContext1.findElement(By.cssSelector("div"));
        waitForElementPresent(preAdverseFullName);
        clickElement(preAdverseFullName);
        waitForSeconds(3);
        return getAttribute(preAdverseFullName_WebElement, "value");
    }

    private String getPreAdverseAddress(){
        String xpath =  "//fadv-input[@ng-reflect-name='mailingAddress']";
        SearchContext host = driver.findElement(By.xpath(xpath));
        SearchContext shadowContext1 =  expandRootElement(host);
        WebElement preAdverseAddress = shadowContext1.findElement(By.cssSelector("div"));
        clickElement(preAdverseAddress);
        waitForSeconds(3);
        return getAttribute(preAdverseAddress_WebElement, "value");
    }

    private String getPreAdverseCityStateZip(){
        String xpath =  "//fadv-input[@ng-reflect-name='cityStateZip']";
        SearchContext host = driver.findElement(By.xpath(xpath));
        SearchContext shadowContext1 =  expandRootElement(host);
        WebElement preAdverseCityStateZip = shadowContext1.findElement(By.cssSelector("div"));
        clickElement(preAdverseCityStateZip);
        waitForSeconds(3);
        return getAttribute(preAdverseCityStateZip_WebElement, "value");
    }

    private String getPreAdversePhone() {
        String xpath = "//fadv-typography[contains(text(),'Create New')]/following::fadv-input[@ng-reflect-name='phoneNumber']";
        SearchContext host = driver.findElement(By.xpath(xpath));
        SearchContext shadowContext1 = expandRootElement(host);
        WebElement preAdversePhone = shadowContext1.findElement(By.cssSelector("div"));
        clickElement(preAdversePhone);
        waitForSeconds(3);
        return getAttribute(preAdversePhone_WebElement, "value");
    }

    public void clickAdjudicationCaseButton(){
        waitForElementClickable(adjudicationCaseButton);
        clickElement(adjudicationCaseButton);
    }

    public void clickCancelCaseExitButton() {
        waitForElementClickable(cancelCase);
        clickElement(caseCancelExitButton);
    }
    public void clickReasonAndCancelTheCaseButton() {
        waitForElementPresent(cancelCaseModal_WebElement);
        waitForElementClickable(cancelCase);
        SearchContext host = driver.findElement(By.xpath("//*[@id='orderCancellationReasonSelect']"));
        SearchContext shadowContent1 = expandRootElement(host);
        WebElement dropdown = shadowContent1.findElement(By.cssSelector("div"));
        clickElement(dropdown);
    }

    public void clickSummaryofRights() {
        clickElement(caseSummaryofRights);
        waitForSeconds(10);
    }

    public void expandRemarks(String searchType){
        String xpath = String.format("//fadv-typography[contains(text(),'%s')]/following::fadv-accordion-panel[@type='remarks'][1]", searchType);
        WebElement element = driver.findElement(By.xpath(xpath));
        scrollTo(element);
        clickElement(By.xpath(xpath));
        waitForSeconds(3);
    }


    public void clickVerifyNoRemarks(String searchType) {
        expandRemarks(searchType);
        String xpath = String.format("//fadv-typography[contains(text(),'%s')]/following::fadv-typography[@id='no-remarks-text']", searchType);
        Assert.assertTrue(exists(By.xpath(xpath)),"Remark found");
    }

    public void expandHistorySection(String searchType){
        String xpath = String.format("//fadv-typography[contains(text(),'%s')]/following::fadv-accordion-panel[@type='history'][1]", searchType);
        clickElement(By.xpath(xpath));
        waitForSeconds(2);
    }

    public Boolean isHistoryExpanded(String searchType){
        String xpath = String.format("//fadv-typography[contains(text(),'%s')]/following::fadv-accordion-panel[@open and @type='history'][1]", searchType);
        return (exists(By.xpath(xpath)));
    }

    public Boolean isCaseDocumentsExpanded(String documentName){
        String xpath = String.format("//fadv-typography[contains(text(),'%s')]/following::button[@aria-expanded='true'][1]", documentName);
        return exists(By.xpath(xpath));
    }


    public void clickDocumentNameColumnToSort(){
        clickElement(caseDocumentNameHeader);
    }

    public void waitForUploadMessageToDisappear(){
        SearchContext host = driver.findElement(By.cssSelector("fadv-loader"));
        SearchContext shadowContent1 = expandRootElement(host);
        WebElement alert = shadowContent1.findElement(By.cssSelector("div"));
        waitForDisappear(alert, 45);
    }

    public void selectAdjudicationLetterType(String letterType){
        String xpath = String.format("//fadv-menu-item[text()='%s']", letterType);
        waitForElementClickable(adjudicationLetterTypeSelector);
        clickElement(adjudicationLetterTypeSelector);
        clickElement(By.xpath(xpath));
    }


    public void clickOverrideReasonDropdown(){
        String xpath =  "//fadv-select[@id='reasonForOverride']";
        SearchContext host = driver.findElement(By.xpath(xpath));
        SearchContext shadowContext1 =  expandRootElement(host);
        WebElement dropdown = shadowContext1.findElement(By.cssSelector("div"));
        clickElement(dropdown);
        waitForSeconds(3);
    }

    public void selectOverrideReason(String reason){
        clickOverrideReasonDropdown();
        String xpath = String.format("//fadv-menu-item[contains(text(),'%s')]", reason);
        clickElement(By.xpath(xpath));
        logger.info("Selected status: " + reason);
    }

    public void enterAdjudicationComments(String comments){
        String xpath = String.format("//fadv-textarea[@id='adjudicationComment']", comments);

        SearchContext host = driver.findElement(By.xpath(xpath));
        SearchContext shadowContext1 =  expandRootElement(host);
        WebElement textArea = shadowContext1.findElement(By.cssSelector("div div"));
        clickElement(textArea);
        waitForSeconds(2);
        setElementValueNoClear(adjudicationCommentsTextBox, comments);
        testObject.setTestData("AdjudicationComments", comments);
    }

    public void clickAdjudicationSubmitButton(){
        scrollTo(adjudicationSubmitButton_WebElement);
        waitForElementClickable(adjudicationSubmitButton);
        clickElement(adjudicationSubmitButton);
        testObject.setTestData("CaseEaDateTime", getCurrentDate());
        waitForSeconds(2);
    }

    public void enterAdjudicationInternalComments(String comments){
        String xpath = String.format("//fadv-textarea[@id='internalComment']", comments);

        SearchContext host = driver.findElement(By.xpath(xpath));
        SearchContext shadowContext1 =  expandRootElement(host);
        WebElement textArea = shadowContext1.findElement(By.cssSelector("div"));
        scrollTo(textArea);
        clickElement(textArea);
        waitForSeconds(2);
        setElementValueNoClear(adjInternalCommentsTextBox, comments);
        testObject.setTestData("AdjInternalComments", comments);
    }
    public void enterSupportEmailAddress(String newEmailAddress){
        clickElement(customerServiceInquiryEmail_WebElement);
        customerServiceInquiryEmail_WebElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        customerServiceInquiryEmail_WebElement.sendKeys(Keys.chord(Keys.DELETE));
        customerServiceInquiryEmail_WebElement.sendKeys(newEmailAddress);
    }

    public void checkInvalidPhoneNumberExists(DataTable dataTable){
        List<String> invalidPhoneNumbers = dataTable.asList();
        SoftAssert softAssert = new SoftAssert();
        for(String invalidPhoneNumber: invalidPhoneNumbers){
            enterCustomerServiceInquiryPhoneNumber(invalidPhoneNumber, true);
            softAssert.assertEquals(invalidPhoneNumberMessageExists(), "true", invalidPhoneNumber + " was not validated as an " +
                    "improper formatted phone number.");
            softAssert.assertEquals(customerServiceSubmitButtonDisabled(), "true", "Submit button was not " +
                    "disabled as expected");
        }
        clearCustomerServicePhoneNumber();
    }

    public String invalidPhoneNumberMessageExists(){
        return  getAttribute(customerServiceInquiryPhone_WebElement, "ng-reflect-invalid");
    }

    public void clearCustomerServicePhoneNumber(){
        customerServiceInquiryPhone_WebElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        customerServiceInquiryPhone_WebElement.sendKeys(Keys.chord(Keys.DELETE));
    }

    public String customerServiceSubmitButtonDisabled(){
        return getAttribute(customerSupportSubmitButton_WebElement, "ng-reflect-disabled");
    }

    public int caseDocumentsPresentInTable(){
        waitForSeconds(3);
        return caseDocumentRows.size();
    }

    public void docUploadSuccessMessageExists(){
        //this appears and goes away quickly. Only verification is to wait until it's present
        waitForSeconds(3);
        waitForDisappear(caseDocumentUploadingMessage);
        clickElement(cDocSuccessMessage_WebElement);
        Assert.assertTrue(exists(caseDocumentsPage), "Case documents Page was not found.");
    }

    public void copyPasteNewXmlContent(String filepath) throws Exception {
        String file = System.getProperty("user.dir") + filepath;
        String contents = FileUtils.readFileToString(new File(file), "UTF-8");
        waitForElementPresent(testPageXmlWindow_WebElement);
        clickElement(testPageXmlWindow_WebElement);
        setElementValue(testPageXmlWindow, contents);
        waitForSeconds(15);
        for (int i = 0; i < 3; i++)
        {
            if(getAttribute(testPageXmlWindow_WebElement, "value")== null) {
                waitForSeconds(10);
            }
            else{
                i=99;
                break;
            }
        }
    }

    public void navigateToTestPage() {
        driver.get(Environment.getCloudEnvironmentBaseUrl());
        waitForSeconds(3);
    }


    public void createOrderAndNavigateToOneTimeLink() throws Exception {
        clickCreateOrderButton();
        clickOneTimeLinkButton();
    }

    public void clickAdditionalInfoTab(){
        waitForElementClickable(caseAdditionalInfoTab);
        clickElement(caseAdditionalInfoTab);
        waitForElementPresent(customerReferenceFieldsTitle);
        waitForElementPresent(userDefinedFieldsTitle);
    }

    public void verifyAdditionalInfoTab() {
        waitForElementClickable(caseAdditionalInfoTab);
        Assert.assertTrue(exists(caseAdditionalInfoTab), "Additional Information tab was not found.");
    }

    public void userDefinedFieldValueExists(DataTable dataTable){
        List<String> userDefinedElements = dataTable.asList();
        SoftAssert softAssert = new SoftAssert();
        waitForSeconds(3);
        for (String userDefinedElement: userDefinedElements) {
            String fieldValue = String.format("//fadv-table[@id='userDefinedFieldsTable']//td/fadv-typography[contains(text(),'%s')]",userDefinedElement);
            logger.info("Checking User Defined field: " + fieldValue);
            softAssert.assertTrue(exists(By.xpath(fieldValue)), "Field " + fieldValue + " was not found.");
        }
    }

    public void enterDelayedComments(String comment) {
        waitForElementPresent(caseCommentsHeader_WebElement);
        waitForSeconds(60);
        clickElement(caseCommentsInput);
        setElementValueNoClear(caseCommentsInput, comment);
        //key set
        testObject.setTestData("CaseComments", comment);
    }

    public void navigatetoPresetCommentOrder(String comment) throws Exception {
        navigateToTestPage();
        waitForSeconds(2);
        clickCreateOrderButton();
        openToEnterCommentAndReOpenSameLink(comment);
    }


    private void openToEnterCommentAndReOpenSameLink(String comment) throws Exception {
        clickElement(oneTimeLinkButton);
        waitForElementPresent(oneTimeLinkLabel_WebElement);
        report("OneTimeLink is: " + getAttribute(oneTimeLink_WebElement, "innerHTML"));
        logger.info("OneTimeLink is: " + getAttribute(oneTimeLink_WebElement, "innerHTML"));
        String CommentLink = getAttribute(oneTimeLink_WebElement, "innerHTML") ;
        clickElement(oneTimeLink);
        clickNoticeAgreeButton();
        enterCaseComments(comment);
        clickCaseCommentEnterButton();
        closeCurrentTab();
        driver.get(CommentLink);
        waitForSeconds(3);
    }
    public void clickFilterAndPendingButton(String header) {
        waitForElementPresent(clickFilterButton_WebElement);
        if(Objects.equals(header, "Pending")) {
            clickElement(clickFilterButton_WebElement);
            clickElement(filterPendingButton_WebElement);
            waitForSeconds(10);
        }
        else if(Objects.equals(header, "Result")) {
            clickElement(clickFilterButton_WebElement);
            clickElement(filterResultButton_WebElement);
            waitForSeconds(10);
        }
    }

    public void clickOvrAdjudicationCancelButton() {
        scrollTo(adjudicationCancelButton_WebElement);
        waitForElementPresent(adjudicationCancelButton_WebElement);
        clickElement(adjudicationCancelButton_WebElement);
    }

    public Boolean confirmAdjudication(String state) {
        waitForElementPresent(getAdjudicationStatus_WebElement);
        return getText(getAdjudicationStatus_WebElement).contains(state);
    }

    public Boolean caseDocumentTabExists(){
        waitForSeconds(5);
        return exists(caseDocumentsTab);
    }

    public Boolean orderDetailsSummaryTabExists(){
        waitForSeconds(5);
        return exists(orderDetailsSummaryTab);
    }

    public void selectPreAdverseReason(DataTable dataTable){
        List<String> reasons = dataTable.asList();
        for(String reason: reasons){
            String xpath = String.format("//fadv-menu[@id='reasons']/fadv-menu-item-checkbox[contains(text(),'%s')]", reason);
            waitForElementClickable(By.xpath(xpath));
            WebElement element = driver.findElement(By.xpath(xpath));
            waitForElementPresent(element);
            scrollTo(element);
            clickElement(By.xpath(xpath));
            logger.info("Selected reason: " + reason);
        }
    }


    public void enterPreAdverseInternalComment(String comments){
        //must use a combination of shadow searches and then back to regular element interaction
        String xpath = "//fadv-textarea[@data-fadv-key='new_letter_internal_comments']";
        SearchContext host = driver.findElement(By.xpath(xpath));
        SearchContext shadowContext1 =  expandRootElement(host);
        WebElement textArea = shadowContext1.findElement(By.cssSelector("div div"));
        scrollTo(textArea);
        clickElement(textArea);
        waitForSeconds(2);
        setElementValueNoClear(preAAInternalCommentTextBox, comments);
    }

    public void clickPreAdverseNextButton(){
        waitForElementPresent(preAdverseNextButton_WebElement);
        scrollTo(preAdverseNextButton_WebElement);
        clickElement(preAdverseNextButton_WebElement);
    }

    public Boolean isCheckboxChecked(DataTable dataTable) {
        List<String> reasons = dataTable.asList();
        for (String reason: reasons){
            String xpath = String.format("//fadv-menu[@id='reasons']/fadv-menu-item-checkbox[contains(text(),'%s') and @checked]", reason);
            Boolean value = exists(By.xpath(xpath));
            logger.info("Reason: " + reason + " value checked: " + value);
            return value;
        }
        return false;
    }
    public void cancelCorrespondenceLetter(){
        scrollTo(cancelCorrespondenceletter_WebElement);
        waitForElementClickable(cancelCorrespondenceletter);
        clickElement(cancelCorrespondenceletter);
    }
    public void acceptCancellationCorrespondenceLetter(){
        clickElement(acceptCorrespondencelettercancel);
    }

    public void rejectCancellationCorrespondenceLetter(){
        clickElement(rejectCorrespondencelettercancel);
        waitForDisappear(rejectCorrespondencelettercancel);
    }
    public void clickCorrespondencepage() {
        clickElement(clickoncorrespondencePage);
    }

    public void verifyNoDocuments(){
        waitForDisappear(documentsLoadingMessage);
        waitForSeconds(5);
        logger.info("Documents grid finished loading. Starting to check for no doc message...");
        Assert.assertTrue(exists(noDocumentsMessage), "'No Documents' Message " +
                "was not found as expected.");
    }

    public void clickDocumentViewButton(String documentName){
        String xpath = String.format("//fadv-typography[contains(text(),'%s')]/following::fadv-button[@data-test-id='viewButton']", documentName);
        waitForElementClickable(By.xpath(xpath));
        clickElement(By.xpath(xpath));
    }

    public void verifyDocumentLoaded(){
        switchToTopTab();
        waitForSeconds(10);
        waitForElementPresent(documentViewer);
        clickElement(documentViewer);
        driver.switchTo().frame("webviewer-1");
        waitForSeconds(10);
        Assert.assertTrue(exists(documentsLoadedWidget), "Document did not open " +
                "as expected.");
    }

    private void switchToTopTab(){
        waitForSeconds(10);
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(2));
        logger.info("document viewer url is: " + driver.getCurrentUrl());
    }

    public void selectCaseDocument1stCheckBox(){
        waitForSeconds(5);
        clickElement(caseDocument1stCheckbox);
        waitForSeconds(3);
    }


    public String textRandomizer(){
        int number = 2001;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < number; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public int enterRandomTextboxComment(String value) {
        String rtextbox = textRandomizer();
        if (Objects.equals(value, "Email")) {
            enterSupportEmailAddress(rtextbox);
            logger.info("******Test length****** "+getAttribute(customerServiceInquiryEmail_WebElement,"value").length());
            return getAttribute(customerServiceInquiryEmail_WebElement,"value").length();
        } else if (Objects.equals(value, "Phone Number")) {
            enterCustomerServiceInquiryPhoneNumber(rtextbox, true);
            return  getAttribute(customerServiceInquiryPhone_WebElement,"value").length();
        } else if (Objects.equals(value, "Comment Section")) {
            enterCommentsForCustomerSupport(rtextbox);
            return getAttribute(customerServiceCommentsTextBox_WebElement,"value").length();
        }
        return 0;
    }

    public boolean createFailedOrderAndNavigateToOneTimeLink() throws Exception {
        clickCreateOrderButton();
        isElementEnabled(invalidLoginToken_WebElement);
        return true;
    }

    public void clickSupportInquiry() throws InterruptedException {
        clickElement(supportInquiry);
        waitForSeconds(2);
    }

    public void clickCaseHistory() {
        clickElement(caseHistoryTab);
    }

    public void clickCaseHistoryNoData() {
        Assert.assertFalse(exists(getCaseHistoryNoData),"Case History present");
    }

    public void verifyOrderSummaryNameTag() {
        waitForSeconds(3);
        Assert.assertTrue(exists(orderSummaryNameTag),"NameTag is different");
    }

    public void expandOrderSummary() {

        SearchContext host = driver.findElement(By.xpath("//fadv-expansion[@id='order-details-profile-details']"));
        SearchContext shadowContent1 = expandRootElement(host);
        WebElement expansion = shadowContent1.findElement(By.cssSelector("div div button"));
        clickElement(expansion);
    }

    public void verifyOrderName(String noName) {
        String customerName = driver.findElement(orderSummaryName).getText();
        Assert.assertEquals(customerName,noName, "Expected Name was not found.");
    }

    public void verifyFooter() {
        scrollTo(testPageFooter_WebElement);
        String footerLegalLink = driver.findElement(footerLegal).getText();
        String footerPrivacyLink = driver.findElement(footerPrivacyPolicy).getText();
        String footerFACTLink = driver.findElement(footerFact).getText();
        Assert.assertEquals(footerLegalLink,"Legal", "Expected Link was not found.");
        Assert.assertEquals(footerPrivacyLink,"Privacy Policy", "Expected Link was not found.");
        Assert.assertEquals(footerFACTLink,"FACT Act Disclosure", "Expected Link was not found.");
    }
	
	   public void orderSummaryVerifyPackageID(String infoPanel) {
        String text = "N/A";
        String xpath = String.format("//fadv-info-panel-item[@name='%s:']/text()",infoPanel);
        Assert.assertNotEquals(text, xpath, "Expected ID was not found.");
    }

    public void refreshBrowserAndWait(int secondsToWait){
        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);
        sharedBaseClass.browserRefresh();
        for (int i=0; i < 3; i++) {
            waitForSeconds(3);
            if (!exists(searchTypeStatusProRingBlue)) {
                //giving the page time to refresh
                waitForSeconds(secondsToWait);
                sharedBaseClass.browserRefresh();
            }
                else{
                    break;
                }
            }
    }


  public void subHeaderVerify(String header, String subHeader) {
        expandSubHeader(header,subHeader);
        String xpath = String.format("//fadv-typography[contains(text(),'%s')]/following::fadv-typography[@id='no-%s-text']",header, subHeader);
        Assert.assertTrue(exists(By.xpath(xpath)),"Value found");
    }
    public void expandSubHeader(String header, String subHeader){
        String xpath = String.format("//fadv-typography[contains(text(),'%s')]/following::fadv-accordion-panel[@type='%s'][1]", header,subHeader);
        WebElement element = driver.findElement(By.xpath(xpath));
        scrollTo(element);
        clickElement(By.xpath(xpath));
        waitForSeconds(3);
    }

 



    public void retrieveProviderRefId(){
        waitForElementPresent(simulatorProviderRefId_WebElement);
        String currentOrderId =  getAttribute(simulatorProviderRefId_WebElement, "value").replaceAll("WPS-", "");
        report("***** Text Referenced Order Id captured: " + currentOrderId);
        logger.info("***** Text Referenced Order Id captured: " +  currentOrderId);
        testObject.setTestData("OrderIdByTxCloud", currentOrderId);
    }

    public void closeEACloudBrowserTab(){
        driver.close();
    }

    public void clickViewReportButton(){
        waitForElementClickable(viewReportButton);
        clickElement(viewReportButton);
    }

    public void verifyReportViewerLoaded(){
        switchToTopTab();
        waitForSeconds(10);
        waitForElementPresent(viewReportViewer_WebElement);
        clickElement(viewReportViewer_WebElement);
        driver.switchTo().frame("webviewer-1");
        waitForSeconds(10);
        Assert.assertTrue(exists(documentsLoadedWidget), "Report did not open " +
                "as expected.");
    }

    public void verifyNoDataAvailableInReferenceFields() {
        waitForSeconds(2);
        Assert.assertTrue(exists(customerRefMessageNoData), "No Data Available was not found for Customer Reference fields as expected.");
    }

    public void verifyUserDefinedMessageNoData() {
        waitForSeconds(2);
        Assert.assertTrue(exists(userDefinedMessageNoData), "No Data Available was not found for User Defined Fields as expected.");
    }
}