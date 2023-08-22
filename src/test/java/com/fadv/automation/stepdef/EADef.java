package com.fadv.automation.stepdef;

import com.fadv.automation.core.*;
import com.fadv.automation.environment.EspEnv;
import com.fadv.automation.pageobjects.AmazonApplicant;
import com.fadv.automation.pageobjects.EA;
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

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class EADef extends BaseClass {
    static final Logger logger = Logger.getLogger(EADef.class.getName());
    final static SeleniumBaseClass seleniumBaseClass = new SeleniumBaseClass(null);
    private WebDriver driver = Hooks.driver;
    private EA ui = null;

    @After
    public void after(Scenario scenario) throws Exception {
        if (this.driver != null) {
            if (scenario.isFailed() && ui != null) {
                ui.reportScreenshot(scenario.getName());
            }
            if (testObject != null) {
                testObject.testComplete();
            }
            try {
                seleniumBaseClass.htmlCsRunner = new HtmlCsRunner(this.driver);
                seleniumBaseClass.htmlCsRunner.execute();
                if (driver != null) {
                    driver.quit();
                }

            } catch (Exception e) {
            }
        }
    }


    public EA getEAPageObject() throws Exception {

        driver = seleniumBaseClass.setBrowserFromProperty(driver);
        ui = PageFactory.initElements(driver, EA.class);
        ui.setTestObject(testObject);
        return ui;
    }

    @Given("I navigate to EA application and login")
    public void iNavigateToEAApplicationAndLogin(io.cucumber.datatable.DataTable dataTable) throws Exception {
        EA app = getEAPageObject();
        app.launchEA();

        List<Map<String, String>> values = dataTable.asMaps();
        Map<String, String> loginInfo = values.get(0);
        String account = testObject.processString(loginInfo.get("account"));
        String user = testObject.processString(loginInfo.get("user"));
        String pass = testObject.processString(loginInfo.get("password"));

        app.login(account, user, pass);
    }

    @Then("I click on New Order link")
    public void iClickOnNewOrderLink() throws Exception {
        EA app = getEAPageObject();
        app.clickNewOrderLink();
    }

    @And("I provide data on Order tab")
    public void iProvideDataOnOrderTab(io.cucumber.datatable.DataTable dataTable) throws Exception {
        EA app = getEAPageObject();

        List<Map<String, String>> values = dataTable.asMaps();
        for (Map<String, String> data : values){
            String field = testObject.processString(data.get("field"));
            String value = testObject.processString(data.get("value"));
            testObject.setTestData(field,value);
            app.newOrderFillFormOrder(field, value);
        }
    }

    @And("I click on Next button")
    public void iClickOnNextButton() throws Exception {
        EA app = getEAPageObject();
        app.clickNextButton();
    }

    @And("I provide data on Subject tab")
    public void iProvideDataOnSubjectTab(io.cucumber.datatable.DataTable dataTable) throws Exception {
        EA app = getEAPageObject();

        List<Map<String, String>> values = dataTable.asMaps();
        for (Map<String, String> data : values){
            String field = testObject.processString(data.get("field"));
            String value = testObject.processString(data.get("value"));
            app.newOrderFillFormSubject(field, value);
            testObject.setTestData(field, value);
        }
    }

    @And("I click on Submit Order button")
    public void iClickOnSubmitOrderButton() throws Exception {
        EA app = getEAPageObject();
        app.clickSubmitButton();
    }

    @And("I verify the order created successfully")
    public void iVerifyTheOrderCreatedSuccessfully() throws Exception {
        EA app = getEAPageObject();
        String cid = app.verifyAndGetNewOrderCreated();
        testObject.setRuntimeData("invite-uuid", cid);
    }

    @And("I logout of EA")
    public void iLogoutOfEA() throws Exception {
        EA app = getEAPageObject();
        app.clickLogoutButton();
    }

    @Then("I click on Process Batch link")
    public void iClickOnProcessBatchLink() throws Exception {
        EA app = getEAPageObject();
        app.clickProcessBatchMenuLink();
    }

    @And("I provide data on Batch Processing page")
    public void iProvideDataOnBatchProcessingPage(io.cucumber.datatable.DataTable dataTable) throws Exception {
        EA app = getEAPageObject();

        List<Map<String, String>> values = dataTable.asMaps();
        for (Map<String, String> data : values){
            String field = testObject.processString(data.get("field"));
            String value = testObject.processString(data.get("value"));
            app.newBatchProcessForm(field, value);
        }
    }

    @And("I click on Process Batch button")
    public void iClickOnProcessBatchButton() throws Exception {
        EA app = getEAPageObject();
        app.clickProcessBatchButton();
    }

    @And("I verify the batch order created successfully")
    public void iVerifyTheBatchOrderCreatedSuccessfully() throws Exception {
        EA app = getEAPageObject();

        String expectedString = "Submitted:1";
        boolean status = app.verifyBatchResult(0, expectedString);
        report("Batch Upload expected String " + expectedString + " | " + status);
        Assert.assertTrue(status, "Batch Upload expected String " + expectedString);
    }

    @Given("I verify the Header {string} is present in the Excel Type xls spreadsheet")
    public void iVerifyTheHeaderIsPresentInTheExcelTypeXlsSpreadsheet(String headerName) throws Exception{
//        EA app = getEAPageObject();
        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);
        Assert.assertTrue(sharedBaseClass.verifyHeadersExistsInExcelSheet(headerName), "Header "  + headerName +  " was not found in the xls are expected.");
    }

    @When("I click the Download Template button in the batch upload section")
    public void iClickTheDownloadTemplateButtonInTheBatchUploadSection() throws Exception{
        EA app = getEAPageObject();
        app.clickDownloadTemplateButton();
    }

    @And("I verify the required message appears for the missing Reason For Test field or value")
    public void iVerifyTheRequiredMessageAppearsForTheMissingReasonForTestFieldOrValue() throws Exception {
        EA app = getEAPageObject();
        Assert.assertEquals(app.verifyMessageInXls(), "Component Errors: Drug Screening Reason for Test is required; End;", "Expected error message was not found.");
    }


    @Given("I insert the data into the downloaded blank batch spreadsheet")
    public void iInsertTheDataIntoTheDownloadedBlankBatchSpreadsheet(DataTable dataTable) throws Exception {
//        EA app = getEAPageObject();
        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);
        sharedBaseClass.insertDataInWorksheetCell(dataTable, false);
    }

    @Given("I cleanup existing files in the downloads folder")
    public void iCleanupExistingFilesInTheDownloadsFolder() throws Exception{
        EA app = getEAPageObject();
        app.cleanupExistingDownloadsFolders();
        logger.info("finished cleanup");
    }

    @And("I click on the View Batches page")
    public void iClickOnTheViewBatchesPage() throws Exception{
        EA app = getEAPageObject();
        app.clickViewBatchesMenuLink();
    }

    @And("I click the Download Rejects button for batch")
    public void iClickTheDownloadRejectsButtonForBatch() throws Exception{
        EA app = getEAPageObject();
        app.clickDownloadsBatchButton();
    }

    @Then("I verify {string} batch orders created successfully")
    public void iVerifyBatchOrdersCreatedSuccessfully(String recordsStatus) throws Exception {
        EA app = getEAPageObject();
        boolean status = app.verifyBatchResult(0, recordsStatus);
        report("Batch Upload expected String " + recordsStatus + " | " + status);
        Assert.assertTrue(status, "Batch Upload expected String " + recordsStatus);
    }

    @When("I click on Cases In Queue link")
    public void iClickOnCasesInQueueLink() throws Exception{
        EA app = getEAPageObject();
        app.clickCaseInQueueMenuLink();
    }

    @And("I select the user {string} in the case queue table")
    public void iSelectTheUserInTheCaseQueueTable(String caseSubject) throws Exception{
        EA app = getEAPageObject();
        // need to use this after fully implemented in framework caseSubject
        app.selectCaseSubject();
    }

    @And("I click to case action {string}")
    public void iClickToCaseAction(String actionOption) throws Exception{
        EA app = getEAPageObject();
        app.gotoCaseAction(actionOption);
    }

    @Then("I can verify Case Status is {string}")
    public void iCanVerifyCaseStatusIs(String caseStatus) throws Exception{
        EA app = getEAPageObject();
        Assert.assertTrue(app.caseStatusOnTabAssigned(caseStatus), "Case Status: " + caseStatus + " on the General Information Tab is not found.");
    }

    @And("I click on the Case Details case action")
    public void iClickOnTheCaseDetailsCaseAction() throws Exception{
        EA app = getEAPageObject();
        app.gotoCaseDetails("Case Details");
    }

    @Then("I click on the order actions to verify {string} exists in the list")
    public void iClickOnTheOrderActionsToVerifyExistsInTheList(String orderItem) throws Exception{
        EA app = getEAPageObject();
        app.verifyActionsItemExist(orderItem);
    }

    @When("I view the case management widget on the homepage")
    public void iViewTheCaseManagementWidgetOnTheHomepage() throws Exception {
        EA app = getEAPageObject();
        app.cmWidgetAvailable();
    }

    @Then("I can verify the user {string} is in the available Secondary Processor dropdown of the Case Management widget")
    public void iCanVerifyTheUserIsInTheAvailableSecondaryProcessorDropdownOfTheCaseManagementWidget(String options) throws Exception {
        EA app = getEAPageObject();
        app.waitForSeconds(2);
        app.availableProcessorsOptionsExists(options.split(","));
    }

    @And("I can verify the user {string} is in the available Reviewer dropdown of the Case Management widget")
    public void iCanVerifyTheUserIsInTheAvailableReviewerDropdownOfTheCaseManagementWidget(String options) throws Exception {
        EA app = getEAPageObject();
        app.waitForSeconds(2);
        app.availableReviewersOptionsExists(options.split(","));
    }

    @And("I verify the required message appears for the missing Zip Code field or value")
    public void iVerifyTheRequiredMessageAppearsForTheMissingZipCodeFieldOrValue() throws Exception {
        EA app = getEAPageObject();
        Assert.assertEquals(app.verifyMessageInXls(), "Zip Code/Postal is required;", "Expected error message was not found.");
    }

    @Then("I verify the zip required message appears when creating an EA order")
    public void iVerifyTheZipRequiredMessageAppearsWhenCreatingAnEAOrder() throws Exception {
        EA app = getEAPageObject();
        Assert.assertTrue(app.exists(app.missingZipPostalCodeMessage), "Expected error message for Missing Zip Code was not found.");
    }

    @Given("I navigate to the EA application and login to the set environment")
    public void iNavigateToTheEAApplicationAndLoginToTheSetEnvironment() throws Exception {
        EA app = getEAPageObject();
        app.launchEA();
        app.login(Environment.getEaEnvironmentAccount(), Environment.getEaEnvironmentUser(), Environment.getEaEnvironmentPassword());
    }
    @And("I navigate to the EA application and login to the environment for random test account")
    public void iNavigateToTheEAApplicationAndLoginToTheEnvironmentForRandomTestAccount() throws Exception {
        EA app = getEAPageObject();
        app.launchEA();
        app.login(Environment.getEaRndEnvironmentAccount(), Environment.getEaRndEnvironmentUser(), Environment.getEaRndEnvironmentPassword());
    }
    @Given("I navigate to the EA application and login to use the Case Management system")
    public void iNavigateToTheEAApplicationAndLoginToUseTheCaseManagementSystem() throws Exception {
        EA app = getEAPageObject();
        app.launchEA();
        app.login(Environment.getEaCMEnvironmentAccount(), Environment.getEaCMEnvironmentUser(), Environment.getEaCMEnvironmentPassword());
    }

    @Given("I navigate to the EA application and login as Case Management system user")
    public void iNavigateToTheEAApplicationAndLoginAsCaseManagementSystemUser() throws Exception {
        EA app = getEAPageObject();
        app.launchEA();
        String account = TestObject.getProperty("data.cm.uat.login.account");
        String user = testObject.processString("data.cm.uat.login.user");
        String pass = testObject.processString("data.cm.uat.login.password");
        app.login(account, user, pass );
    }

    @And("I search by candidate name {string} for the order in EA")
    public void iSearchByCandidateNameForTheOrderInEA(String candidateName) throws Exception {
        EA app = getEAPageObject();
        app.enterInformationToSearch(candidateName);
        app.clickGlobalSearchButton();
    }

    @Then("I verify the order existence and retrieve the order id for the candidate")
    public void iVerifyTheOrderExistenceAndRetrieveTheOrderIdForTheCandidate() throws Exception {
        EA app = getEAPageObject();
        Assert.assertTrue(app.exists(app.overallProgressTab), "Order was not found.");
        app.setEAOrderId();
    }

    @And("I search by auto-generated candidate created in Admin UI for the order in EA")
    public void iSearchByAutoGeneratedCandidateCreatedInAdminUIForTheOrderInEA() throws Exception {
        EA app = getEAPageObject();
        String candidateName = testObject.getTestData("adminUIOrderFName") + " " + testObject.getTestData("adminUIOrderLName");
        app.enterInformationToSearch(candidateName);
        app.clickGlobalSearchButton();
    }


    @And("I verify the required message appears for the missing Client Reference for Alias field or value")
    public void iVerifyTheRequiredMessageAppearsForTheMissingClientReferenceForAliasFieldOrValue() throws Exception {
        EA app = getEAPageObject();
        Assert.assertEquals(app.verifyMessageInXls(), "Missing Client Reference 2;", "Expected error message was not found.");
    }

    @And("I verify the required message appears for the missing Client Reference field or value")
    public void iVerifyTheRequiredMessageAppearsForTheMissingClientReferenceFieldOrValue() throws Exception {
        EA app = getEAPageObject();
        Assert.assertEquals(app.verifyMessageInXls(), "Missing Client Reference 1;", "Expected error message was not found.");

    }
    @And("I enter Order Information on Order tab")
    public void iEnterOrderInformationOnOrderTab(io.cucumber.datatable.DataTable dataTable) throws Exception {
        EA app = getEAPageObject();
        app.enterOrderCRFinfo(dataTable);

    }

    @Then("I verify that I am on Subject tab")
    public void iVerifyThatIAmOnSubjectTab() throws Exception {
        EA app = getEAPageObject();
        Assert.assertTrue(app.exists(app.subjectTab),"Subject tab is not displayed");
    }

    @And("I wait for {int} seconds in EA")
    public void iWaitForIntSecondsInEA(int seconds) throws Exception {
        EA app = getEAPageObject();
        app.waitForSeconds(seconds);
    }

    @And("I search EA for the order ID generated through EA Cloud Order")
    public void iSearchEAForTheOrderIDGeneratedThroughEACloudOrder() throws Exception{
        EA app = getEAPageObject();

        String currentOrderId = testObject.getTestData("OrderIdByTxCloud");
        app.enterInformationToSearch(currentOrderId);
        app.clickGlobalSearchButton();
    }

    @And("I verify the search results Tab appears for the order in EA")
    public void iVerifyTheSearchResultsTabAppearsForTheOrderInEA() throws Exception {
        EA app = getEAPageObject();
        app.eaSearchResultsTabsExist();
    }

    @And("I verify the order existence in EA")
    public void iVerifyTheOrderExistenceInEA() throws Exception {
        EA app = getEAPageObject();
        Assert.assertTrue(app.exists(app.overallProgressTab), "Order was not found.");
    }

    @Given("I navigate to the EA application and login to the set environment for AIR RANDOM")
    public void iNavigateToTheEAApplicationAndLoginToTheSetEnvironmentForAIRRANDOM() throws Exception {
        EA app = getEAPageObject();
        app.launchEA();
        app.login(Environment.getEaAirEnvironmentAccount(), Environment.getEaAirEnvironmentUser(), Environment.getEaAirEnvironmentPassword());
    }

    @Given("I navigate to the EA application and login to the set environment for AIR RANDOM SkipAdjudication")
    public void iNavigateToTheEAApplicationAndLoginToTheSetEnvironmentForAIRRANDOMSkipAdjudication() throws Exception {
        EA app = getEAPageObject();
        app.launchEA();
        app.login(Environment.getEaAirSkpEnvironmentAccount(), Environment.getEaAirSkpEnvironmentUser(), Environment.getEaAirSkpEnvironmentPassword());
    }

    @And("I click on Additional Searches tab")
    public void iClickOnAdditionalSearchesTab() throws Exception {
        EA app = getEAPageObject();
        app.clickAdditionalSearchesTab();
    }

    @And("I click on Review Order tab")
    public void iClickOnReviewOrderTab() throws Exception {
        EA app = getEAPageObject();
        app.clickReviewTab() ;
    }

    @And("I select the reason for test as {string} for EA Order")
    public void iSelectTheReasonForTestAsForEAOrder(String reasonForTest) throws Exception {
        EA app = getEAPageObject();
        app.selectReason(reasonForTest);
    }

    @Given("I navigate to the EA application and login to the environment for USFC Random SkipAdjudication Flow")
    public void iNavigateToTheEAApplicationAndLoginToTheEnvironmentForUSFCRandomSkipAdjudicationFlow() throws Exception {
        EA app = getEAPageObject();
        app.launchEA();
        app.login(Environment.getEaUsfcSkpEnvironmentAccount(), Environment.getEaUsfcSkpEnvironmentUser(), Environment.getEaUsfcSkpEnvironmentPassword());

    }
}

