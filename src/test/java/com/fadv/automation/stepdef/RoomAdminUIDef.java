package com.fadv.automation.stepdef;

import com.aventstack.extentreports.Status;
import com.fadv.automation.core.*;
import com.fadv.automation.pageobjects.AmazonAdminUI;
import com.fadv.automation.utils.Util;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class RoomAdminUIDef extends BaseClass {
    static final Logger logger = Logger.getLogger (RoomAdminUIDef.class.getName ( ));
    private AmazonAdminUI ui = null;
    private WebDriver driver = null;
    final static SeleniumBaseClass seleniumBaseClass = new SeleniumBaseClass (null);

    @Before
    public void before(Scenario scenario) throws Exception {
        WebElementHelper.setRecordMode();
        testObject = TestObject.createWith (scenario);
    }

    @After
    public void after(Scenario scenario) throws Exception {
        WebElementHelper.writeMap();
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

    public AmazonAdminUI getAdminUIPageObject() throws Exception {
        driver = seleniumBaseClass.setBrowserFromProperty (driver);
        ui = PageFactory.initElements (driver, AmazonAdminUI.class);
        ui.setTestObject (testObject);
        return ui;
    }


    @Given("the login page for Room Admin UI is showing in the browser")
    public void the_login_page_for_Room_Admin_UI_is_showing_in_the_browser() throws Exception {
        getAdminUIPageObject ( ).launchAdminUI ( );
    }


    @When("user login with {string} and {string}")
    public void user_login_with_and(String username, String password) throws Exception {
        getAdminUIPageObject ( ).login (username, password);
    }


    @When("user login successfully")
    public void user_login_successfully() throws Exception {
        getAdminUIPageObject ( ).verifyLogin ( );
    }


    @When("user login failed")
    public void user_login_failed() throws Exception {
        AmazonAdminUI app = getAdminUIPageObject ( );

        By error = By.xpath ("//div[@class='error pageLevel']");
        WebElement we = app.getDriver ( ).findElement (error);
        Assert.assertTrue (we.getText ( ).contains ("The username or password provided in the request are invalid."));
    }

    @Then("validate the correct location is showing")
    public void validate_the_correct_location_is_showing() throws Exception {
        getAdminUIPageObject ( ).validateCorrectLocationShowing ( );

    }

    @Then("click on the tests in progress link")
    public void click_on_the_tests_in_progress_link() throws Exception {
        getAdminUIPageObject ( ).clickTestsInProgressLink ( );

    }

    @Then("validate the tests in progress dashboard")
    public void validate_the_tests_in_progress_dashboard() throws Exception {
        getAdminUIPageObject ( ).validateTestsInProgressDashboard ( );

    }

    @Then("validate candidate info")
    public void validate_candidate_info(io.cucumber.datatable.DataTable dataTable) throws Exception {
        AmazonAdminUI admin = getAdminUIPageObject ( );

        List<Map<String, String>> values = dataTable.asMaps ( );
        for (Map<String, String> m : values) {
            String name = m.get ("name");
            name = testObject.processString (name);

            By card = By.xpath ("//div[@class='candidate-card']/div[text()='" + name + "']/../div[@class='subpanel-container']");
            if (admin.exists (card)) {
                String step = m.get ("step");
                if (step != null && !step.isEmpty ( )) {
                    String foundStep = admin.getApplicantStepByName (name);
                    report ("foundStep: " + foundStep + ", expected Step: " + step);
                    Assert.assertTrue (foundStep.contains (step), "Expected step [" + step + "] was not found");
                }

                String booth = m.get ("booth");
                if (booth != null && !booth.isEmpty ( )) {
                    if (booth.equalsIgnoreCase ("no")) {
                        By byBooth = By.xpath ("//div[@class='candidate-card']/div[text()='" + name + "']/../div[@class='subpanel-container']/div[@class='card-subpanel id-container']");
                        boolean foundBooth = admin.exists (byBooth, 2);
                        report ("foundBooth number ? " + foundBooth);
                        Assert.assertFalse(foundBooth, "Booth number was not found");
                    } else {
                        String foundBooth = admin.getApplicantBoothByName (name);
                        report ("foundBooth: " + foundBooth + ", expected booth: " + booth);
                        Assert.assertTrue (foundBooth.contains (booth), "Expected booth [" + booth + "] was not found");
                    }
                }
            }
        }
    }

    @Then("validate the ready to adjudicate dashboard")
    public void validate_the_ready_to_adjudicate_dashboard() throws Exception {
        getAdminUIPageObject ( ).validateReadyToAdjudicateDashboard ( );
    }


    @Then("adjudicate with Retest option")
    public void adjudicate_with_Retest_option() throws Exception {
        AmazonAdminUI app = getAdminUIPageObject ( );
        app.clickAdjudicateRetest ( );
        app.selectReasonForCertification ("Did not follow instructions");
        app.signSignaturePadFinalAlcPage ( );
        app.clickAdjudicateCertifySubmit ( );
    }

    @Then("adjudicate with Inconclusive option")
    public void adjudicate_with_Inconclusive_option() throws Exception {
        AmazonAdminUI app = getAdminUIPageObject ( );
        app.clickAdjudicateInconclusive ( );
        app.waitForSeconds(2);
        app.selectAdjudicationStripsByIndex (Arrays.asList (1));
        app.signSignaturePadFinalAlcPage ( );
        app.clickAdjudicateSignSubmit ( );
    }

    @Then("adjudicate with Clear option")
    public void adjudicate_with_Clear_option() throws Exception {
        AmazonAdminUI app = getAdminUIPageObject ( );
        app.clickAdjudicateClear ( );
        app.signSignaturePadFinalAlcPage ( );
    }

    @Then("adjudicate with Re-take option")
    public void adjudicate_with_Re_take_option() throws Exception {
        getAdminUIPageObject ( ).clickAdjudicateRetake ( );
    }

    @Then("click on the need help link")
    public void click_on_the_need_help_link() throws Exception {
        getAdminUIPageObject ( ).clickHelpLink ( );

    }

    @Then("click on the candidate {string}")
    public void click_on_the_candidate() throws Exception {
        String env = System.getProperty ("env");
        String name = TestObject.getProperty ("data." + env + ".invite.uuid");
        String value = testObject.processString (name);
        getAdminUIPageObject ( ).clickOnCandidateCard (value);
    }

    @Then("enter help info {string}")
    public void enter_help_info(String helpComment) throws Exception {
        getAdminUIPageObject ( ).enterHelpComment (helpComment);

    }

    @Then("validate the need help dashboard")
    public void validate_the_need_help_dashboard() throws Exception {
        getAdminUIPageObject ( ).validateNeedHelpDashboard ( );

    }

    @Then("click on the ready to adjudicate link")
    public void click_on_the_ready_to_adjudicate_link() throws Exception {

        getAdminUIPageObject ( ).clickReadyToAdjudicate ( );

    }


    @And("user login with {string} and {string} and close browser")
    public void userLoginWithAndAndCloseBrowser(String username, String password) throws Exception {
        getAdminUIPageObject ( ).loginAndCloseBrowser (username, password);
    }


    @And("I verify the photo size width {int} height {int} on the adjudication screen")
    public void iVerifyThePhotoSizeWidthHeightOnTheAdjudicationScreen(int width, int height) throws Exception {
        AmazonAdminUI app = getAdminUIPageObject ( );

        By image = By.id ("testing-pic");
        WebElement element = driver.findElement (image);
        app.waitForElementPresent (element);
        String naturalHeight = element.getAttribute ("naturalHeight");
        String naturalWidth = element.getAttribute ("naturalWidth");

        boolean results;
        results = Integer.parseInt (naturalHeight) == height;
        report ("Is Photo height of [" + naturalHeight + "] equals to expected " + height + " ? " + results);
        Assert.assertTrue (results, "Is Photo height of [" + naturalHeight + "] equals to expected " + height + " ? " + results);

        results = Integer.parseInt (naturalWidth) == width;
        report ("Photo width [" + naturalWidth + "] equals to expected " + width + " ? " + results);
        Assert.assertTrue (results, "Photo width [" + naturalWidth + "] equals to expected " + width + " ? " + results);


    }

    @And("I select the location and state to begin in the Admin UI")
    public void iSelectTheLocationAndStateToBeginInTheAdminUI() throws Exception {
        getAdminUIPageObject ( ).selectLocation ( );
    }

    @And("I click on the candidate in the Admin UI")
    public void iClickOnTheCandidateInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        report ("Candidate picked to adjudicate: " + amazonAdminUI.getCandidateName ( ));
        amazonAdminUI.clickOnCandidateCard (amazonAdminUI.getCandidateName ( ));
    }

    @And("I click the default region card")
    public void iClickTheDefaultRegionCard() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickDefaultLocationCard ( );
    }

    @Then("I can verify the concluded and in progress tabs are the only displayed tabs")
    public void iCanVerifyTheConcludedAndInProgressTabsAreTheOnlyDisplayedTabs() throws Exception {
        SoftAssert softAssert = new SoftAssert ( );
        softAssert.assertTrue (ui.exists (getAdminUIPageObject ( ).concludedTab), "Concluded Tests Tab was not found as expected.");
        softAssert.assertTrue (ui.exists (getAdminUIPageObject ( ).inProgressTab), "Tests In Progress Tab was not found as expected.");
        int found = getAdminUIPageObject ( ).adminUITabCount ( );
        softAssert.assertEquals (found, 2, "Number of expected tabs in the Admin UI were not found. Found: " + found);
        softAssert.assertAll ( );
    }

    @And("I click the automation region card")
    public void iClickTheAutomationRegionCard() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickAutomationLocationCard ( );
    }

    @And("I choose default inconclusive drugs in the Admin UI")
    public void iChooseDefaultInconclusiveDrugsInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.selectInconclusiveDrug (amazonAdminUI.benzodiazepine, amazonAdminUI.amphetimine);
    }

    @And("I enter the consent signature for the Admin adjudication")
    public void iEnterTheConsentSignatureForTheAdminAdjudication() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.signSignaturePadFinalAlcPage();
    }

    @Then("I can verify message appears for inconclusive confirmation")
    public void iCanVerifyMessageAppearsForInconclusiveConfirmation() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adjInconclusiveConfirmation), "Inconclusive confirmation message was not found as expected.");
    }

    @And("I click the cancel button on the adjudication message modal")
    public void iClickTheCancelButtonOnTheAdjudicationMessageModal() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickCancel ( );
    }

    @And("I click certify and sign button for the adjudication")
    public void iClickCertifyAndSignButtonForTheAdjudication() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickAdjudicateCertifySubmit ( );
    }

    @Then("I can verify the message appears for clear confirmation")
    public void iCanVerifyTheMessageAppearsForClearConfirmation() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adjClearConfirmation), "Adjudicate Clear message did not appear as expected.");
    }

    @And("I click the confirm button on the adjudication message modal")
    public void iClickTheConfirmButtonOnTheAdjudicationMessageModal() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickConfirm ( );
        amazonAdminUI.waitForSeconds(2);
    }

    @And("I verify the candidate card is displaying again in the Admin UI")
    public void iVerifyTheCandidateCardIsDisplayingAgainInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.candidateCardElement ( )), "Candidate card was not found on the 'In Progress' tab.");
    }

    @Then("I can verify the message appears for invalid confirmation")
    public void iCanVerifyTheMessageAppearsForInvalidConfirmation() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adjInvalidConfirmation), "Invalid confirmation card was not found on the 'In Progress' tab.");
    }

    @And("I click on the Completed Tests Tab in the Admin UI")
    public void iClickOnTheCompletedTestsTabInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickCompletedTestsTab ( );
    }


    @Then("I verify the filter displays for the Completed Tests")
    public void iVerifyTheFilterDisplaysForTheCompletedTests() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.startDateRange), "The start date range was not found.");
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.endDateRange), "The end date range was not found.");
    }

    @When("I click the inconclusive button for adjudication")
    public void iClickTheInconclusiveButtonForAdjudication() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickAdjudicateInconclusive ( );
    }


    @Then("I can verify the {int} test strips appear on the page")
    public void iCanVerifyTheTestStripsAppearOnThePage(int count) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertEquals (amazonAdminUI.countDrugCollection ( ), count, "Drug Collection Test Strip expected count " + count + " was not found.");
    }

    @And("I Click the Restart Test checkbox on the Admin help")
    public void iClickTheRestartTestCheckboxOnTheAdminHelp() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickRestartTestCheckbox ( );
    }

    @And("I click the Done button on the Admin help")
    public void iClickTheDoneButtonOnTheAdminHelp() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickHelpDoneButton ( );
    }

    @And("I logout of the Admin UI")
    public void iLogoutOfTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickLogout ( );
    }

    @And("I enter the help comment {string} information only")
    public void iEnterTheHelpCommentInformationOnly(String comment) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterHelpCommentOnly (comment);
    }

    @When("I set the start date range to {string} for completed tests")
    public void iSetTheStartDateRangeToForCompletedTests(String dateLabel) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickStartDateRange (dateLabel);
    }

    @And("I set the end date range to {string} for completed tests")
    public void iSetTheEndDateRangeToForCompletedTests(String dateLabel) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickEndDateRange (dateLabel);
    }

    @And("I can verify the current user card is listed in the results")
    public void iCanVerifyTheCurrentUserCardIsListedInTheResults() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.candidateCardElementFNameOnly ( )), "Current User was not found in the search results.");
    }

    @When("I type in the current candidate to search for the completed test")
    public void iTypeInTheCurrentCandidateToSearchForTheCompletedTest() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterTextToSearch (amazonAdminUI.getCandidateName ( ), false);
    }

    @And("I can verify One tests returns count displays for results in Past Twenty-Four Hours")
    public void iCanVerifyOneTestsReturnsCountDisplaysForResultsInPastTwentyFourHours() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.testResultReturned ("1")), "The expected result count of 1 was not found.");
    }

    @When("I set the start date range to {int} days prior current date for completed tests")
    public void iSetTheStartDateRangeToDaysPriorCurrentDateForCompletedTests(int daysPriorCurrentDate) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.setRandomStartDateToSearch (daysPriorCurrentDate);
    }

    @And("I set the end date range to current day for completed tests")
    public void iSetTheEndDateRangeToCurrentDayForCompletedTests() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.setCurrentDayAsEndDateToSearch ( );
    }

    @And("I click on the current user's adjudicated card")
    public void iClickOnTheCurrentUserSAdjudicatedCard() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        String currentUser = amazonAdminUI.getCandidateName();
        report ("Checking Adjudicated Candidate card for: " + currentUser);
        amazonAdminUI.javaClickOnCandidateCard();
    }

    @And("I can verify the adjudicated result card contains the image and signature")
    public void iCanVerifyTheAdjudicatedResultCardContainsTheImageAndSignature() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adjudicatorSignatureImage), "Adjudicator's Signature image was not found as expected.");
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adjudicatedDeviceImage), "Adjudicator's Device image was not found as expected.");
    }

    @Then("I can verify that I can go to page {string}")
    public void iCanVerifyThatICanGoToPage(String page) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.resultsPagination (page)), "Page " + page + " was not found.");
        amazonAdminUI.goToPageNumber (page);
    }

    @And("I click the back on the adjudicated applicant's card")
    public void iClickTheBackOnTheAdjudicatedApplicantSCard() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickAdjudicatedBackButton ( );
    }

    @And("I can verify the current user card is listed in the {string}")
    public void iCanVerifyTheCurrentUserCardIsListedInThe(String hoursButtonText) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.verifyPastHoursButtonExists (hoursButtonText);
        amazonAdminUI.verifyCardListedUnderFilter (hoursButtonText);
    }

    @And("I click the invalid button")
    public void iClickTheInvalidButton() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickInvalidButton ( );
    }

    @Then("I verify the invalid Reason Options are present")
    public void iVerifyTheInvalidReasonOptionsArePresent() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.getInvalidReasonOptionsCount ( ) > 0, "Invalid Reason Options were not found.");
    }

    @And("I select the reason for Invalid option {string}")
    public void iSelectTheReasonForInvalidOption(String reason) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.selectReasonForCertification (reason);
    }

    @And("I enter a comment {string} for the invalid reason")
    public void iEnterACommentForTheInvalidReason(String reasonComment) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.addInvalidReasonComments (reasonComment);
    }

    @And("I verify the Sign and submit button is disabled")
    public void iVerifyTheSignAndSubmitButtonIsDisabled() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertFalse (amazonAdminUI.isCertifySubmitButtonEnabled ( ), "Sign and Submit button was enabled when it was not expected.");
    }

    @And("I click sign and submit button for inconclusive adjudication")
    public void iClickSignAndSubmitButtonForInconclusiveAdjudication() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickAdjudicateSignSubmit( );
    }

    @Then("I can verify the message appears for no active candidates")
    public void iCanVerifyTheMessageAppearsForNoActiveCandidates() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.noCandidateMessage), "The message for no active candidate did not appear as expected.");
    }

    @Then("I can verify the image was successfully inverted on the Admin UI")
    public void iCanVerifyTheImageWasSuccessfullyInvertedOnTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.isImageInverted ( );
    }

    @And("I enabled inverted image on the Admin UI")
    public void iEnabledInvertedImageOnTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickInvertedSwitch ( );
    }

    @Then("I verify the Retest option is present")
    public void iVerifyTheRetestOptionIsPresent() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        boolean actual = amazonAdminUI.exists (amazonAdminUI.retestButton);
        Assert.assertTrue (actual);
    }

    @Then("the card should be removed from Tests in progress dashboard")
    public void theCardShouldBeRemovedFromTestsInProgressDashboard() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.validateNotInTestsInProgressDashboard ( );
    }

    @And("I select a reason for Abandoned Process")
    public void iSelectAReasonForAbandonedProcess() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.selectAreasonForAbandoned ( );
    }

    @When("I click on the Concluded Tests Tab in the Admin UI")
    public void iClickOnTheConcludedTestsTabInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickConcludedTestsLink ( );
    }

    @Then("the card should be displayed in concluded tests dashboard")
    public void theCardShouldBeDisplayedInConcludedTestsDashboard() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.validateConcludedTestsDashboard ( );
    }

    @And("I click on Abandoned Process button")
    public void iClickOnAbandonedProcessButton() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickAbandonedProcess ( );
    }

    @Then("I can verify the message appears for Abandoned Process confirmation")
    public void iCanVerifyTheMessageAppearsForAbandonedProcessConfirmation() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adjAbandonedConfirmation), "Abandoned confirmation message was not found as expected. ");
    }

    @And("I enter comment {string} for Abandon reason")
    public void iEnterCommentForAbandonReason(String reasonComment) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.addAbandonedReasonComments (reasonComment);
    }

    @And("I verify the Abandon Reason Options are present")
    public void iVerifyTheAbandonReasonOptionsArePresent() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.getAbandonReasonOptionsCount ( ) > 0, "Abandoned Reason Options were not found.");
    }

    @And("I select the reason for Abandoned Process option {string}")
    public void iSelectTheReasonForAbandonedProcessOption(String reason) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.selectReasonForCertification (reason);
    }


    @Then("I verify Concluded Tests label is displayed")
    public void iVerifyConcludedTestsLabelIsDisplayed() throws Exception {
        AmazonAdminUI amazonAdminUI= getAdminUIPageObject();
        amazonAdminUI.verifyConcludedTestsTab();
    }



    @Then("I can verify the specimen ID {string} is present on the admin adjudication screen")
    public void iCanVerifyTheSpecimenIDIsPresentOnTheAdminAdjudicationScreen(String specimenId) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        String foundSpecimenId = amazonAdminUI.getAdminSpecimenIdDisplayed ( );
        Assert.assertEquals (foundSpecimenId, specimenId, "Matching specimen id was not found as expected. Found: " + foundSpecimenId);
    }

    @And("I verify the No button exists on the admin specimen id screen")
    public void iVerifyTheNoButtonExistsOnTheAdminSpecimenIdScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adminSpecimenNoButton), "No button was not found on the Admin specimen id screen.");
    }

    @And("I click the No button on the Admin specimen id screen")
    public void iClickTheNoButtonOnTheAdminSpecimenIdScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickSpecimenNoButton ( );
    }

    @And("I verify the Yes button exists on the admin specimen id screen")
    public void iVerifyTheYesButtonExistsOnTheAdminSpecimenIdScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adminSpecimenYesButton), "Yes button was not found on the Admin specimen id screen.");
    }

    @And("I click the Yes button on the Admin specimen id screen")
    public void iClickTheYesButtonOnTheAdminSpecimenIdScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickSpecimenYesButton ( );
    }

    @And("I verify the adjudicating screen appears")
    public void iVerifyTheAdjudicatingScreenAppears() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adjudicatingScreen), "Adjudicating Screen was not found.");
    }

    @And("I verify that I am not able to log in")
    public void iVerifyThatIAmNotAbleToLogIn() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        boolean isSuccess = amazonAdminUI.exists (amazonAdminUI.adminUIHeader);
        Assert.assertFalse (isSuccess, "Log in is successful");
    }

    @When("I navigate back")
    public void iNavigateBack() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.getDriver ( ).navigate ( ).back ( );
    }

    @And("I verify the sign in page")
    public void iVerifyTheSignInPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        boolean isAdminSignInOpen = amazonAdminUI.exists (amazonAdminUI.adminUIsignInPage);
        Assert.assertTrue (isAdminSignInOpen);

    }

    @When("I click the Log in button for Admin UI")
    public void iClickTheLogInButtonForAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickElement (amazonAdminUI.btnLogin);
    }

    @And("I click Amazon SuperUser button")
    public void iClickAmazonSuperUserButton() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickElement (amazonAdminUI.amznSuperUser);
    }

    @And("I click Amazon RoomAdmin button")
    public void iClickAmazonRoomAdminButton() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickElement (amazonAdminUI.amznRoomAdmin);
    }

    @And("I click on the Region Card {string} in the Admin UI")
    public void iClickOnTheRegionCardInTheAdminUI(String locationName) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickLocationNameCard (locationName);
    }

    @And("I click on the candidate's abandoned card in the Admin UI")
    public void iClickOnTheCandidateSAbandonedCardInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.javaClickOnCandidateCard ( );
    }

    @When("I click on the menu and choose Manage Orders")
    public void iClickOnTheMenuAndChooseManageOrders() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickManageOrders ( );
    }

    @And("I choose the Package Reason {string}")
    public void iChooseThePackageReason(String reason) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.selectPackageReason (reason);
    }

    @And("I choose the Order Package {string}")
    public void iChooseTheOrderPackage(String orderPackage) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.selectPackage (orderPackage);
    }

    @And("I click the next button for the order in the Admin UI")
    public void iClickTheNextButtonForTheOrderInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickOrderNextButton ( );
        amazonAdminUI.waitForSeconds(1);
    }
    @And("I click the next button for the Alcohol Flow in the Admin UI")
    public void iClickTheNextButtonForTheAlcoholFlowInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI. clickAlcoholFlowNextButton();
        amazonAdminUI.waitForSeconds(1);
    }


    @And("I can verify the State is present for the order in the Admin UI")
    public void iCanVerifyTheStateIsPresentForTheOrderInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderStateSelector), "State was not found on the Hiring Information Screen.");
    }

    @Then("I can verify the Location Information screen is displayed")
    public void iCanVerifyTheLocationInformationScreenIsDisplayed() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderLocationScreen), "Location Information Screen was not found as expected.");
    }

    @And("I can verify the Country is present for the order in the Admin UI")
    public void iCanVerifyTheCountryIsPresentForTheOrderInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderCountrySelector), "Country was not found on the Hiring Information Screen.");
    }

    @And("I can verify the Contact Information screen is displayed")
    public void iCanVerifyTheContactInformationScreenIsDisplayed() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.waitForSeconds (1);
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderContactScreen), "Contact Information Screen was not found as expected.");
    }

    @When("I can click the previous button for the order in the Admin UI")
    public void iCanClickThePreviousButtonForTheOrderInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickOrderPreviousButton ( );
    }

    @Then("I can verify the Package Information screen is displayed")
    public void iCanVerifyThePackageInformationScreenIsDisplayed() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderPackageScreen), "Package Information Screen was not found as expected.");
    }

    @Then("I can verify the Placed Order screen is displayed")
    public void iCanVerifyThePlacedOrderScreenIsDisplayed() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adminUIplacedOrders), "Placed Order Screen was not found as expected.");
    }

    @And("I can verify the Order Package {string} is retained on the Package Information Screen")
    public void iCanVerifyTheOrderPackageIsRetainedOnThePackageInformationScreen(String orderPackage) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.packageInfoDisplayed (orderPackage), "Order Package was not retained.");
    }

    @And("I can verify the Package Reason {string} is retained on the Package Information Screen")
    public void iCanVerifyThePackageReasonIsRetainedOnThePackageInformationScreen(String reason) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertEquals (amazonAdminUI.packageInfoReasonDisplayed ( ), reason, "Order Package Reason was not retained.");
    }

    @And("I enter the city {string} for the order")
    public void iEnterTheCityForTheOrder(String city) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterOrderCity (city);
    }

    @And("I choose the state {string} on the Location Information Screen")
    public void iChooseTheStateOnTheLocationInformationScreen(String state) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.selectHiringState (state);
    }

    @And("I can verify the next button is disabled for the order in the Admin UI")
    public void iCanVerifyTheNextButtonIsDisabledForTheOrderInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.waitForSeconds (1);
        Assert.assertFalse (amazonAdminUI.isOrderNextButtonEnabled ( ), "Next button was not disabled as expected.");
    }
    @And("I can verify the next button is enabled for the order in the Admin UI")
    public void iCanVerifyTheNextButtonIsEnabledForTheOrderInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.isOrderNextButtonEnabled (), "Next button was not enabled as expected.");
    }

    @And("I choose the country {string} for the order within the Admin UI")
    public void iChooseTheCountryForTheOrderWithinTheAdminUI(String country) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.selectHiringCountry (country);
    }

    @Then("I can verify the Residence Information screen is displayed")
    public void iCanVerifyTheResidenceInformationScreenIsDisplayed() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderResidenceScreen), "Residence Information Screen was not found as expected.");
    }

    @And("I can verify the City is present for the order within the Admin UI")
    public void iCanVerifyTheCityIsPresentForTheOrderWithinTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderCity), "City was not found on the Admin UI Screen.");
    }

    @And("I verify the address second line is present on the Residence Screen")
    public void iVerifyTheAddressSecondLineIsPresentOnTheResidenceScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderAddressLine2), "Address Line 2 was not found on the Admin UI Screen.");
    }

    @And("I verify the address first line is present on the Residence Screen")
    public void iVerifyTheAddressFirstLineIsPresentOnTheResidenceScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderAddressLine1), "Address Line 1 was not found on the Admin UI Screen.");
    }

    @And("I can verify Zip Code is present for the order in the Admin UI")
    public void iCanVerifyZipCodeIsPresentForTheOrderInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderPostalCode), "Zip Code was not found on the Admin UI Screen.");
    }

    @And("I enter the zip code {string} for the order")
    public void iEnterTheZipCodeForTheOrder(String orderZipCode) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterOrderZipCode (orderZipCode);
    }

    @And("I enter {string} in the second line of the address for the order")
    public void iEnterInTheSecondLineOfTheAddressForTheOrder(String address) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterOrderAddress1 (address);
    }

    @And("I enter {string} in the first line of the address for the order")
    public void iEnterInTheFirstLineOfTheAddressForTheOrder(String address) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterOrderAddress1 (address);
    }

    @And("I click on the submit button for the order in the Admin UI")
    public void iClickOnTheSubmitButtonForTheOrderInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickOrderNextButton ( );
    }

    @Then("I can verify the Identification Information screen is displayed")
    public void iCanVerifyTheIdentificationInformationScreenIsDisplayed() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderIdentificationScreen), "Identification Information Screen was not found as expected.");
    }

    @And("I verify the first name {string} is retained on the identification screen")
    public void iVerifyTheFirstNameIsRetainedOnTheIdentificationScreen(String firstName) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        String fName = amazonAdminUI.orderFirstNameWebElement.getAttribute ("value");
        Assert.assertEquals (fName, firstName, "Expected First Name was not retained in the order.");
    }

    @And("I verify the last name {string} is retained on the identification screen")
    public void iVerifyTheLastNameIsRetainedOnTheIdentificationScreen(String lastName) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        String lName = amazonAdminUI.orderLastNameWebElement.getAttribute ("value");
        Assert.assertEquals (lName, lastName, "Expected Last Name was not retained in the order.");
    }

    @And("I verify the social security number {string} is retained on the identification screen")
    public void iVerifyTheSocialSecurityNumberIsRetainedOnTheIdentificationScreen(String ssn) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        String orderSsn = amazonAdminUI.orderSsnWebElement.getAttribute ("value");
        Assert.assertEquals (orderSsn, ssn, "Expected Social Security Number was not retained in the order.");
    }

    @And("I verify the date of birth {string} is retained on the identification screen")
    public void iVerifyTheDateOfBirthIsRetainedOnTheIdentificationScreen(String dob) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        String dateOfBirth = amazonAdminUI.orderDobWebElement.getAttribute ("value");
        Assert.assertEquals (dateOfBirth, dob, "Expected Date of Birth was not retained in the order.");

    }

    @And("I enter the phone number {string} for the order in the Admin UI")
    public void iEnterThePhoneNumberForTheOrderInTheAdminUI(String phone) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterOrderPhoneNumber (phone, false);
        amazonAdminUI.waitForSeconds (1);
    }

    @And("I enter the email address {string} for the order in the Admin UI")
    public void iEnterTheEmailAddressForTheOrderInTheAdminUI(String email) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterOrderEmailAddress (email, false);
        amazonAdminUI.waitForSeconds (2);
    }

    @And("I verify the Candidate Id Number {string} is retained on the identification screen")
    public void iVerifyTheCandidateIdNumberIsRetainedOnTheIdentificationScreen(String idNumber) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        String candidateId = amazonAdminUI.orderCandidateIdWebElement.getAttribute ("value");
        Assert.assertEquals (candidateId, idNumber, "Expected Candidate Id was not retained in the order.");
    }

    @And("I click the browser back button")
    public void iClickTheBrowserBackButton() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickBrowserBackButton ( );
    }

    @And("I verify the phone number {string} is retained on the Contact Info Screen for the order in the Admin UI")
    public void iVerifyThePhoneNumberIsRetainedOnTheContactInfoScreenForTheOrderInTheAdminUI(String phone) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.waitForSeconds (1);
        String phoneNumber = amazonAdminUI.orderPhoneNumberWebElement.getAttribute ("value");
        Assert.assertEquals (phoneNumber, phone, "Expected Phone Number was not retained in the order.");
    }

    @And("I verify the email address {string} is retained on the Contact Info Screen for the order in the Admin UI")
    public void iVerifyTheEmailAddressIsRetainedOnTheContactInfoScreenForTheOrderInTheAdminUI(String email) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        String emailAddress = amazonAdminUI.orderEmailAddressWebElement.getAttribute ("value");
        Assert.assertEquals (emailAddress, email, "Expected Email Address was not retained in the order.");
    }

    @And("I can verify the invalid email address message displays for the order in the Admin UI")
    public void iCanVerifyTheInvalidEmailAddressMessageDisplaysForTheOrderInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderEmailAddressFeedback), "Expected invalid email address message was not found.");
    }

    @And("I can verify the invalid phone number message displays for the order in the Admin UI")
    public void iCanVerifyTheInvalidPhoneNumberMessageDisplaysForTheOrderInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderPhoneNumberFeedback), "Expected invalid phone number message was not found.");
    }

    @And("I re-enter the email address {string} for the order in the Admin UI")
    public void iReEnterTheEmailAddressForTheOrderInTheAdminUI(String email) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterOrderEmailAddress (email, true);
    }

    @And("I re-enter the phone number {string} for the order in the Admin UI")
    public void iReEnterThePhoneNumberForTheOrderInTheAdminUI(String phone) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.waitForSeconds (1);
        amazonAdminUI.enterOrderPhoneNumber (phone, true);
    }

    @And("I verify the Order completed message in the Admin UI")
    public void iVerifyTheOrderCompletedMessageInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
//        element will need to change when backend is wired for new order submitted screen
        amazonAdminUI.waitForSeconds (1);
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderCompleted), "Order completed did not appear as expected.");
//        uncomment this assertion when backend is wired up
//        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.orderCreateAnotherMsg), "Order Upload Successful message did not appear as expected.");
    }

    @And("I can verify the adjudicated result card contains the date last scanned location is {string}")
    public void iCanVerifyTheAdjudicatedResultCardContainsTheDateLastScannedLocationIs(String locationText) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.getLastScannedDetails ( ).contains (locationText), "Expected location was not found.");
    }

    @And("I click on the Start a new candidate lookup button in the Admin UI")
    public void iClickOnTheStartANewCandidateLookupButtonInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickStartNewCandidateButton ( );
    }
    @And("I verify the invalid CID message appear under the CID field")
    public void iVerifyTheInvalidCIDMessageAppearUnderTheCIDField() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderIdentificationInvalidCID)," Candidate ID was entered correctly");
    }

    @Then("I verify the Identification Form screen is displayed")
    public void iVerifyTheIdentificationFormScreenIsDisplayed() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderIdentificationScreen), "Identification Information Form screen was not found as expected");
    }

    @And("I verify the Get Started page is displayed in the Admin UI")
    public void iVerifyTheGetStartedPageIsDisplayedInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.getStartedPage), "The 'Get Started' Page was not found as expected.");
    }

    @And("I click on the order Exit button in the Admin UI")
    public void iClickOnTheOrderExitButtonInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickOrderExitButton ( );
    }

    @And("I can verify the Social Security Number is present on the Identification Information Screen")
    public void iCanVerifyTheSocialSecurityNumberIsPresentOnTheIdentificationInformationScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderIdentificationSSN), "SSN was not found on the Identification Information Screen");
    }

    @And("I verify the Place Order page is displayed in the Admin UI")
    public void iVerifyThePlaceOrderPageIsDisplayedInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.placeOrdersPage), "Place Order page was not found as expected.");
    }

    @And("I verify the New Candidate Lookup button exists on the order completed page in the Admin UI")
    public void iVerifyTheNewCandidateLookupButtonExistsOnTheOrderCompletedPageInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderCreateAnotherButton), "New candidate lookup/start new order button was not found as expected.");
    }

    @And("I verify the Exit button exists on the order completed page in the Admin UI")
    public void iVerifyTheExitButtonExistsOnTheOrderCompletedPageInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderExitButton), "Order's exit button was found as expected.");
    }

    @And("I click on the menu and choose COC Conversion")
    public void iClickOnTheMenuAndChooseCocConversion() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickCocConversion();
    }

    @And("I enter the last name {string} to lookup the candidate order in the Admin UI")
    public void iEnterTheLastNameToLookupTheCandidateOrderInTheAdminUI(String lastName) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterCandidateLastName (lastName);
    }

    @And("I enter the month {string} day {string} year {string} for date of birth to lookup the candidate order in the Admin UI")
    public void iEnterTheMonthDayYearForDateOfBirthToLookupTheCandidateOrderInTheAdminUI(String month, String day, String year) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterCandidateDobMonth (month);
        amazonAdminUI.enterCandidateDobDay (day);
        amazonAdminUI.enterCandidateDobYear (year);
        amazonAdminUI.waitForSeconds (1);
    }

    @And("I enter the last four digits for social security number {string} to lookup the candidate order in the Admin UI")
    public void iEnterTheLastFourDigitsForSocialSecurityNumberToLookupTheCandidateOrderInTheAdminUI(String last4Ssn) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterCandidateSsn (last4Ssn);
    }
    @And("I click the get started button on Admin UI")
    public void iClickTheGetStartedButtonOnAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.clickGetStartedButton();
    }


    @And("I click on Use This ID button for the order in the Admin UI")
    public void iClickOnUseThisIDButtonForTheOrderInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.clickUseThisIdButton();
    }

    @And("I verify the Order Photo Rules Page appears in the Admin UI")
    public void iVerifyTheOrderPhotoRulesPageAppearsInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderPhotoRulesPage), "Photo Rules page did not appear as expected.");
    }

    @And("I verify the candidate not found page appears in the Admin UI")
    public void iVerifyTheCandidateNotFoundPageAppearsInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderCandidateNotFound), "'Order Not Found' page was expected.");
    }

    @And("I verify the Create New Order button displays in the Admin UI")
    public void iVerifyTheCreateNewOrderButtonDisplaysInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adminUIcreateNewOrders), "Create New Order button was not found.");
    }

    @And("I verify Try Another Id button displays in the Admin UI")
    public void iVerifyTryAnotherIdButtonDisplaysInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderTryAnotherButton), "Try Another Id button was not found.");
    }

    @And("I can verify the Candidate ID Number is present on the Identification Information Screen")
    public void iCanVerifyTheCandidateIDNumberIsPresentOnTheIdentificationInformationScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderIdentificationCID), "Candidate ID was not found on the Identification Information Screen");
    }

    @And("I can verify the First Name is present on the Identification Information Screen")
    public void iCanVerifyTheFirstNameIsPresentOnTheIdentificationInformationScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderIdentificationFName), "First Name was not found on the Identification Information Screen");
    }

    @And("I can verify the Last Name is present on the Identification Information Screen")
    public void iCanVerifyTheLastNameIsPresentOnTheIdentificationInformationScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderIdentificationLName), "Last Name was not found on the Identification Information Screen");
    }

    @And("I can verify the Date of Birth is present on the Identification Information Screen")
    public void iCanVerifyTheDateOfBirthIsPresentOnTheIdentificationInformationScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderIdentificationDoB), "Date of Birth was not found on the Identification Information Screen");
    }

    @And("I enter First Name {string} on the Identification Information Screen")
    public void iEnterFirstNameOnTheIdentificationInformationScreen(String fName) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterIdentificationFName (fName);
    }

    @And("I enter Last Name {string} on the Identification Information Screen")
    public void iEnterLastNameOnTheIdentificationInformationScreen(String lName) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterIdentificationLName (lName);
    }

    @And("I enter Social Security Number {string} on the Identification Information Screen")
    public void iEnterSocialSecurityNumberOnTheIdentificationInformationScreen(String ssn) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterIdentificationSSN (ssn);
    }

    @And("I enter Date of Birth  {string} on the Identification Information Screen")
    public void iEnterDateOfBirthOnTheIdentificationInformationScreen(String DoB) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterIdentificationDoB (DoB);


    }

    @And("I click the submit button for the sideAlley uploaded photo")
    public void iClickTheSubmitButtonForTheSideAlleyUploadedPhoto() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickSideAlleySubmitButton ( );
    }

    @And("I verify that I'm on the COC photo rules page")
    public void iVerifyThatIMOnTheCOCPhotoRulesPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyCoCPhotoRulesScreen), "Side-Alley COC photo rules page not found");
    }

    @When("I click on I'm ready to take the photo button COC")
    public void iClickOnIMReadyToTakeThePhotoButtonCOC() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickCoCtakePhotoButton ( );
    }

    @When("I click on I'm ready to take the photo button")
    public void iClickOnIMReadyToTakeThePhotoButton() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickTakePhotoButtonSA ( );
    }

    @Then("I verify that I'm on the upload a photo of your COC form")
    public void iVerifyThatIMOnTheUploadAPhotoOfYourCOCForm() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.getSideAlleyCoCuploadPhotoScreen), "Side-Alley COC upload photo page not found");
    }
    @And("I verify Date Of Birth error message is given")
    public void iVerifyDateOfBirthErrorMessageIsGiven() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject ();
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderIdentificationInvalidDoBMessage), "Please enter a valid Date of Birth message does not appear");
    }




    @Then("I verify Date Of Birth {string} is auto-formatted")
    public void iVerifyDateOfBirthIsAutoFormatted(String DoB) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        String mm = DoB.substring (0, 2);
        String dd = DoB.substring (2, 4);
        String yyyy = DoB.substring (4, 8);

        Assert.assertEquals (amazonAdminUI.getText (amazonAdminUI.orderDobWebElement), mm + "/" + dd + "/" + yyyy, "Date of Birth is not formatted");

    }

    @And("I wait for {int} seconds in AdminUI")
    public void iWaitForSecondsInAdminUI(int seconds) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject ();
        amazonAdminUI.waitForSeconds (seconds);

    }

    @And("I verify the COC Photo Rules Screen is displayed in the Admin UI")
    public void iVerifyTheCOCPhotoRulesScreenIsDisplayedInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.cocPhotoRulesScreen), "COC Photo Rules Screen was not found as expected.");
    }

    @And("I verify the COC Photo Rules text {string} appears on the page")
    public void iVerifyTheCOCPhotoRulesTextAppearsOnThePage(String text) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.textExists (text), "text, " + text + " was not found as expected.");
    }

    @And("I verify the back button appears on the screen")
    public void iVerifyTheBackButtonAppearsOnTheScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.cocBackButton), "Back button was not found as expected.");
    }

    @Then("I verify that chatbot is visible")
    public void iVerifyThatChatbotIsVisible() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.waitForSeconds (2);
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adminUIchatWindow), "Chatbot does not exist");
    }

    @And("I verify the COC Review your Photo screen appears in the Admin UI")
    public void iVerifyTheCOCReviewYourPhotoScreenAppearsInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.cocReviewPhotoScreen), "'Review Your Photo' screen was not found as expected.");
    }

    @Then("I verify the adjudication recommendation text {string} appears on the page")
    public void iVerifyTheAdjudicationRecommendationTextAppearsOnThePage(String text) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.textExists (text), "Expected Text, " + text + " was not found as expected.");
    }

    @And("I verify the button: Switch to this is displayed")
    public void iVerifyTheButtonSwitchToThisIsDisplayed() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.switchToThisButton), "The 'Switch to This' button was not found as expected.");
    }

    @And("I verify all of the recommended six test strips are negative in the Admin UI")
    public void iVerifyAllOfTheRecommendedSixTestStripsAreNegativeInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertEquals (amazonAdminUI.verifyAllNegativeTestStrips ( ), 6, "6 Negative Test Strips were not found as expected.");
    }

    @And("I verify the button: Keep this is displayed")
    public void iVerifyTheButtonKeepThisIsDisplayed() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.keepThisButton), "The 'Keep This' button was not found as expected.");
    }

    @And("I click the button: Keep this")
    public void iClickTheButtonKeepThis() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickKeepThisButton ( );
    }

    @And("I click the button: Switch to this")
    public void iClickTheButtonSwitchToThis() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickSwitchToThisButton ( );
    }

    @And("I verify the test strips image contains ONE selected positive test strip")
    public void iVerifyTheTestStripsImageContainsONESelectedPositiveTestStrip() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertEquals (amazonAdminUI.howManyPositiveStripsOnResult ( ), 1, "Expected ONLY 1 positive test strip.");
    }

    @And("I verify the test strips image contains ZERO selected positive test strip")
    public void iVerifyTheTestStripsImageContainsZEROSelectedPositiveTestStrip() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertEquals (amazonAdminUI.howManyPositiveStripsOnResult ( ), 0, "Expected NO positive test strips.");
    }

    @Then("I verify header has Placed Orders, Create New Order and Bulk orders")
    public void iVerifyHeaderHasPlacedOrdersCreateNewOrderAndBulkOrders() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adminUIplacedOrders), "Placed orders is not displayed");
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adminUIcreateNewOrders), "Create new order is not displayed");
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adminUIbulkOrders), "Bulk orders is not displayed");

    }

    @And("I verify Placed Orders page opening as a default")
    public void iVerifyPlacedOrdersPageOpeningAsADefault() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adminPlacedOrdersHeader), "Placed orders is not displayed as a default");
    }

    @And("I click the Manage Orders Tab {string}")
    public void iClickTheManageOrdersTab(String tab) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickManageOrdersTab (tab);
    }

    @And("I verify the next button is enabled for the order in the Admin UI")
    public void iVerifyTheNextButtonIsEnabledForTheOrderInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.waitForSeconds (2);
        Assert.assertTrue (amazonAdminUI.isOrderNextButtonEnabled ( ), "Next button was disabled.");
    }

    @And("I verify the Done button displays in the Admin UI")
    public void iVerifyTheDoneButtonDisplaysInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderDoneButton), "Done button was not found.");
    }
    @When("I click Create New Order button on the Order Submit Confirmation page")
    public void iClickCreateNewOrderButtonOnTheOrderSubmitConfirmationPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickSubmitConfCreateNewButton ( );
    }
    @And("I click the Create New Order button on the submitted Order Page of the Admin UI")
    public void iClickTheCreateNewOrderButtonOnTheSubmittedOrderPageOfTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.clickCreateNewOrderButtonSubmitPage();
    }

    @And("I click the View This Order button in the Admin UI")
    public void iClickTheViewThisOrderButtonInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickViewThisOrderButton ( );
    }

    @And("I click the Done button for the order in the Admin UI")
    public void iClickTheDoneButtonForTheOrderInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickOrderDoneButton ( );
    }


    @And("I verify the candidate {string} is placed at the top of the Placed Orders list in the Admin UI")
    public void iVerifyTheCandidateIsPlacedAtTheTopOfThePlacedOrdersListInTheAdminUI(String values) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        String[] valueToFind = values.split (",");
        amazonAdminUI.waitForSeconds(3);
        Assert.assertTrue (amazonAdminUI.isValueInTableRow (valueToFind), "Value was not found in first row of the Table.");
    }

    @Then("I can verify that the invalid order submission message appears")
    public void iCanVerifyThatTheInvalidOrderSubmissionMessageAppears() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderInvalidSubmitConfirmationScreen));
    }

    @And("I click on Retry Submit button on the Invalid Confirmation Page")
    public void iClickOnRetrySubmitButtonOnTheInvalidConfirmationPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickInvalidOrderSubmitConfRetryButton ( );
    }

    @And("I click Done button on the Order Submit Confirmation page")
    public void iClickDoneButtonOnTheOrderSubmitConfirmationPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.waitForSeconds (3);
        amazonAdminUI.clickSubmitConfDoneButton ( );

    }

    @And("I click on Create New Order button on the Invalid Confirmation Page")
    public void iClickOnCreateNewOrderButtonOnTheInvalidConfirmationPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickInvalidOrderSubmitConfCreateNewButton ( );
    }

    @And("I verify that I navigate to Placed Orders page")
    public void iVerifyThatINavigateToPlacedOrdersPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adminPlacedOrdersHeader));
    }

    @And("I verify that I navigate to Create New Order widget")
    public void iVerifyThatINavigateToCreateNewOrderWidget() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderLocationScreen),"Location Information page is not found");

    }

    @And("I set the Testing Location {string} for the offline order to begin")
    public void iSetTheTestingLocationForTheOfflineOrderToBegin(String location) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.setSideAlleyTestLocation (location);
    }

    @And("I click the begin button on the Testing Location screen")
    public void iClickTheBeginButtonOnTheTestingLocationScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickGetStartedButton ( );
    }

    @And("I enter auto-created candidate's information to lookup on the get Started screen")
    public void iEnterAutoCreatedCandidateSInformationToLookupOnTheGetStartedScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterCandidateInformation ( );
    }

    @And("I verify column headers in Placed Orders Page are Name, SSN, DOB, Created, Status,Location, Order Id, Package, One Strip")
    public void iVerifyColumnHeadersInPlacedOrdersPageAreNameSSNDOBCreatedStatusLocationOrderIdPackage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.verifyAdminPlacedOrdersColumnTitles ( );
    }


    @When("I click the browser refresh button")
    public void iClickTheBrowserRefreshButton() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.refreshTheBrowser ( );
    }

    @Then("I can verify the Candidate Results screen displays")
    public void iCanVerifyTheCandidateResultsScreenDisplays() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.waitForSeconds (2);
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyCandidateResultsScreen), "Candidate Results screen was not found as expected.");

    }
    @When("I click on the arrow next to SSN column in Placed Orders List")
    public void iClickOnTheArrowNextToSSNColumnInPlacedOrdersList() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickPlacedOrdersSSNsortingArrow ( );
        amazonAdminUI.waitForSeconds (2);
    }
    @And("I click the auto-generated candidate on the candidate results screen")
    public void iClickTheAutoGeneratedCandidateOnTheCandidateResultsScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        String retrieveLastName = amazonAdminUI.getCandidateInfoFromOrderWrapper ("lastName").toString ( );
        amazonAdminUI.clickCandidateRowByLastName (retrieveLastName);
    }

    @And("I click the Inconclusive option on the sideAlley recommendation screen")
    public void iClickTheInconclusiveOptionOnTheSideAlleyRecommendationScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickInconclusiveRecommendation ( );
    }

    @And("I select test strips {string} as inconclusive on the sideAlley recommendation screen")
    public void iSelectTestStripsAsInconclusiveOnTheSideAlleyRecommendationScreen(Integer... testStripNumber) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.selectAdjudicationStripsByIndex (Arrays.asList (testStripNumber));
    }

    @And("I enter a signature for the sideAlley recommendation results")
    public void iEnterASignatureForTheSideAlleyRecommendationResults() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.signSignaturePad ( );
    }

    @And("I verify the sideAlley Order Submit Conformation and Upload Successful page displays")
    public void iVerifyTheSideAlleyOrderSubmitConformationAndUploadSuccessfulPageDisplays() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyUploadSuccessfulOrderSubmitted), "Side Alley - Order Confirmation page was not found as expected.");
    }

    @Then("I verify the Order Submit Conformation Message displayed as {string}")
    public void iVerifyTheOrderSubmitConformationMessageDisplayedAs(String message) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertEquals (amazonAdminUI.submitValidOrderConfirmationMessage.getText ( ), message, " Confirmation message is not as expected");

    }

    @And("I clear the name filter of the Placed Orders List in the Admin UI")
    public void iClearTheNameFilterOfThePlacedOrdersListInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clearNameFilterInOrderList ( );
    }

    @And("I filter by the name {string} in the Placed Orders List in the Admin UI")
    public void iFilterByTheNameInThePlacedOrdersListInTheAdminUI(String value) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterOrderNameInFilterTextbox (value);
        amazonAdminUI.waitForSeconds (5);
    }
    @And("I click on the arrow next to Created column in Placed Orders List")
    public void iClickOnTheArrowNextToCreatedColumnInPlacedOrdersList() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.clickPlacedOrdersCreatedSortingArrow ();
    }


    @And("I filter by the last four social security number {string} in the Placed Orders List in the Admin UI")
    public void iFilterByTheLastFourSocialSecurityNumberInThePlacedOrdersListInTheAdminUI(String value) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterOrderSsnInFilterTextbox (value);
        amazonAdminUI.waitForSeconds(3);
        Assert.assertTrue (amazonAdminUI.isValueInTableRow (value), "value was not found.");
    }

    @And("I clear the social security number filter of the Placed Orders List in the Admin UI")
    public void iClearTheSocialSecurityNumberFilterOfThePlacedOrdersListInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clearSsnFilterInOrderList ( );
    }

    @And("I filter by Status {string} in the Placed Orders List in the Admin UI")
    public void iFilterByStatusInThePlacedOrdersListInTheAdminUI(String statuses) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        String[] valueToSelect = statuses.split (",");
        amazonAdminUI.selectOrderStatusFilter (valueToSelect);
    }

    @And("I clear the order statuses filter of the Placed Orders List in the Admin UI")
    public void iClearTheOrderStatusesFilterOfThePlacedOrdersListInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clearOrderStatusFilter ( );
    }



    @And("I set the start date range for month {string} and day {string} of the current year for Placed Orders")
    public void iSetTheStartDateRangeForMonthAndDayOfTheCurrentYearForPlacedOrders(String startMonth, String startDay) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.setPlacedOrdersStartDate (startMonth, startDay);
    }

    @And("I set the end date range for the month {string} and day {string} of the current year for Placed Orders")
    public void iSetTheEndDateRangeForTheMonthAndDayOfTheCurrentYearForPlacedOrders(String endMonth, String endDay) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.setPlacedOrdersEndDate (endMonth, endDay);
    }

    @And("I verify orders are sorted in descending order according to SSN column in Placed Orders List")
    public void iVerifyOrdersAreSortedInDescendingOrderAccordingToSSNColumnInPlacedOrdersList() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.verifyPlacedOrdersSortedDescendingBySSN ();
    }
    @And("I set the end date range to current day Placed Orders")
    public void iSetTheEndDateRangeToCurrentDayPlacedOrders() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.setCurrentMMDDForPOEndDate ( );
    }

    @And("I click ok on confirmation popup window in Admin UI")
    public void iClickOkOnConfirmationPopupWindowInAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.getDriver ( ).switchTo ( ).alert ( ).accept ( );
        amazonAdminUI.waitForSeconds (2);
    }

    @And("^I verify incomplete orders are listed with Incomplete Status$")
    public void i_verify_incomplete_orders_are_listed_with_incomplete_status() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.exists (amazonAdminUI.adminIncompleteOrder);
    }



    @When("I click the side Alley back button in the Admin UI")
    public void iClickTheSideAlleyBackButtonInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickSideAlleyBackButton ( );
    }

    @And("I select the Candidate by last name {string} on the Candidate Results screen for the offline order")
    public void iSelectTheCandidateByLastNameOnTheCandidateResultsScreenForTheOfflineOrder(String lastName) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickCandidateRowByLastName (lastName);
    }

    @And("I filter by Order Id retrieved from the EA order")
    public void iFilterByOrderIdRetrievedFromTheEAOrder() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterOrderIdInFilterTextbox (testObject.getTestData ("orderID"));
    }
    @And("I verify orders are sorted in ascending order according to Created Column in Placed Orders List")
    public void iVerifyOrdersAreSortedInAscendingOrderAccordingToCreatedColumnInPlacedOrdersList() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.verifyAdminPlacedOrdersListedReverseChronological();
    }

    @And("I can verify all statuses exist in the Placed Orders List in the Admin UI")
    public void iCanVerifyAllStatusesExistInThePlacedOrdersListInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.checkPlacedOrderStatuses ( ), "An expected status was not found.");
    }

    @And("I verify chronological order exists for items in the Placed Order List in the Admin UI")
    public void iVerifyChronologicalOrderExistsForItemsInThePlacedOrderListInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.verifyAdminPlacedOrdersListedChronological();
    }

    @And("I can verify the message appears for enrollment completed")
    public void iCanVerifyTheMessageAppearsForEnrollmentCompleted() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyEnrollmentCompleteMsg), "Enrollment Complete message was not found as expected.");
    }



    @And("I click on the menu and choose Another Location")
    public void iClickOnTheMenuAndChooseAnotherLocation() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickChooseAnotherLocation ( );
    }


    @And("I switch to another window")
    public void iSwitchToAnotherWindow() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.switchToAdminUIWindow();
    }


    @And("I click the Next button for the offline order")
    public void iClickTheNextButtonForTheOfflineOrder() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickSideAlleyNextButton ( );
    }

    @And("I verify the Photo Rules Page appears in the Admin UI")
    public void iVerifyThePhotoRulesPageAppearsInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyPhotoRulesScreen), " Photo Rules page did not appear as expected.");

    }

    @And("I click on the get started button for Side Alley")
    public void iClickOnTheGetStartedButtonForSideAlley() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.waitForSeconds (2);
        amazonAdminUI.clickGetStartedOnSideAlley ( );


    }

    @And("I click on I'm happy with my photo button in the Admin UI")
    public void iClickOnIMHappyWithMyPhotoButtonInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickIamHappyButtonAdminUI ( );
    }

    @And("I upload the photo of my COC form in Side Alley")
    public void iUploadThePhotoOfMyCOCFormInSideAlley() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.uploadCOCPhoto ("/src/test/resources/testvideos/cocPhoto.jpg");

    }

    @And("I upload the photo of my device in Side Alley")
    public void iUploadThePhotoOfMyDeviceInSideAlley() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.uploadPhotoSA ("/src/test/resources/testvideos/ValidQRCode.png");
    }

    @And("I verify that I'm on the Side Alley Review Page")
    public void iVerifyThatIMOnTheSideAlleyReviewPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyReviewScreen), "Review Screen is not found");


    }

    @And("I click negative in Side Alley Review Page")
    public void iClickNegativeInSideAlleyReviewPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickNegativeInSideAlley ( );
    }

    @And("I click submit button for the order in Side Alley Review Page")
    public void iClickSubmitButtonForTheOrderInSideAlleyReviewPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickSubmitOnSideAlleyReview ( );
    }

    @And("I verify that I'm navigated to Order Submitted Page of the Side Alley")
    public void iVerifyThatIMNavigatedToOrderSubmittedPageOfTheSideAlley() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyOrderSubmittedScreen), " Order Submitted Page is not found.");
    }
    @And("I can verify the Next and Back buttons are available on the Candidate Results page")
    public void iCanVerifyTheNextAndBackButtonsAreAvailableOnTheCandidateResultsPage() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject ();
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyResultsBackButton));
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyResultsNextButton));
    }

    @Then("I verify that I'm on the photo upload page")
    public void iVerifyThatIMOnThePhotoUploadPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyUploadPhotoScreen), "Upload photo screen is not found");
    }

    @And("I verify that I'm on the Side Alley Get Started Page")
    public void iVerifyThatIMOnTheSideAlleyGetStartedPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyGetStartedScreen), "Side Alley Get Started Screen is not found");
    }


    @And("I verify that the error message is given for duplicate device")
    public void iVerifyThatTheErrorMessageIsGivenForDuplicateDevice() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyDuplicateErrorMessage));
    }

    @And("I upload a QR readable duplicate device picture")
    public void iUploadAQRReadableDuplicateDevicePicture() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.uploadDuplicatePhotoSA ("/src/test/resources/testvideos/Duplicate-OralToxPhoto.png");

    }

    @And("I enter the auto-generated Admin UI candidate's information on the Identification Information Screen")
    public void iEnterTheAutoGeneratedAdminUICandidateSInformationOnTheIdentificationInformationScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterGeneratedCandidateInfoOnInfoScreen ( );
    }
    @And("I click the back button on Candidate Results page")
    public void iClickTheBackButtonOnCandidateResultsPage() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject ();
        amazonAdminUI.clickElement (amazonAdminUI.sideAlleyResultsBackButton);
    }

    @And("I click on Next button on Select Location page")
    public void iClickOnNextButtonOnSelectLocationPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickSideAlleyNextButtonSelectLocationScreen ( );
    }

    @And("I enter the Candidates information retrieved from the Admin UI order to lookup the candidates order")
    public void iEnterTheCandidatesInformationRetrievedFromTheAdminUIOrderToLookupTheCandidatesOrder() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterGeneratedCandidateInfoToLookup ( );
    }
    @And("^I verify orders are sorted in descending order according to Created Column in Placed Orders List$")
    public void i_verify_orders_are_sorted_in_descending_order_according_to_created_column_in_placed_orders_list() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.verifyAdminPlacedOrdersListedChronological();
    }


    @And("I verify the Order Photo Rules Page appears in the Side Alley")
    public void iVerifyTheOrderPhotoRulesPageAppearsInTheSideAlley() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.SideAlleyPhotoRulesPage), "Photo Rules page did not appear on Side Alley as expected.");
    }

    @And("I verify that I'm on the Review your photo page")
    public void iVerifyThatIMOnTheReviewYourPhotoPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyReviewYourPhotoPage), "Review your photo page does not appeared");

    }
    @Then("I verify orders are sorted in ascending order according to SSN column in Placed Orders List")
    public void iVerifyOrdersAreSortedInAscendingOrderAccordingToSSNColumnInPlacedOrdersList() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.verifyPlacedOrdersSortedAscendingBySSN ( );
    }
    @And("I click on Retake photo button on Review you photo page")
    public void iClickOnRetakePhotoButtonOnReviewYouPhotoPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickReTakePhotoButtonSA ( );
    }

    @And("I click on Upload photo button on Review you photo page SA")
    public void iClickOnUploadPhotoButtonOnReviewYouPhotoPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickUploadPhotoButtonSA ( );
    }

    @And("I upload the photo of my device which QR code is not readable in Side Alley")
    public void iUploadThePhotoOfMyDeviceWhichQRCodeIsNotReadableInSideAlley() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.uploadPhotoSA ("/src/test/resources/testvideos/clearDiscrepancy.png");
    }


    @And("I verify that Enter Specimen ID Button is available in Review your photo screen SA")
    public void iVerifyThatEnterSpecimenIDButtonIsAvailableInReviewYourPhotoScreenSA() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyEnterSpecimenIDButton), "Enter Specimen ID button is not available");
    }

    @And("I verify that Upload photo Button is available in Review your photo screen SA")
    public void iVerifyThatUploadPhotoButtonIsAvailableInReviewYourPhotoScreenSA() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyUploadPhotoButton), "Upload photo button is not available");


    }

    @And("I click on Enter Specimen ID Button in SA")
    public void iClickOnEnterSpecimenIDButtonInSA() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickEnterSpecimenIDButtonSA ( );
    }

    @And("I enter the sample ID {string} on the Enter ID screen in SA")
    public void iEnterTheSampleIDOnTheEnterIDScreenInSA(String sampleId) throws Exception {
        AmazonAdminUI amazonApplicant = getAdminUIPageObject ( );
        amazonApplicant.enterSampleInformationSA (sampleId, false);
        report (Status.PASS, "Sample Information was entered.");
    }

    @And("I click the auto-generated candidate created via Admin UI")
    public void iClickTheAutoGeneratedCandidateCreatedViaAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        String candidateName = testObject.getTestData ("adminUIOrderFName") + " " + testObject.getTestData ("adminUIOrderLName");
        report ("Candidate picked to adjudicate: " + candidateName);
        amazonAdminUI.clickOnCandidateCard (candidateName);
    }

    @And("I click the auto-generated candidate created via EA UI")
    public void iClickTheAutoGeneratedCandidateCreatedViaEAUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        String candidateName = testObject.getTestData("first name (given name)")+ " "+testObject.getTestData ("last name") ;
        report ("Candidate picked to adjudicate: " + candidateName);
        amazonAdminUI.clickOnEACandidateCard (candidateName);
    }

    @Then("I verify that I am on COC photo rules page")
    public void iVerifyThatIAmOnCOCPhotoRulesPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyCoCPhotoRulesScreen), "COC photo rules page had not appeared");
    }

    @When("I click on Next button on Enter ID page in SA")
    public void iClickOnNextButtonOnEnterIDPageInSA() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickNextButtonOnEnterIDpageSA ( );

    }

    @Then("I verify All fields are required to get started message appears on Side Alley Get Started screen")
    public void iVerifyAllFieldsAreRequiredToGetStartedMessageAppears() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyGetStartedAllFieldsError), "All fields are required to get started message is not visible");

    }

    @And("I verify Date of Birth not valid message appears on Side Alley Get Started screen")
    public void iVerifyDateOfBirthNotValidMessageAppears() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyGetStartedBDateError), "All fields are required to get started message is not visible");

    }

    @And("I verify SSN error message appears on Side Alley Get Started screen")
    public void iVerifySSNErrorMessageAppearsOnSideAlleyGetStartedScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyGetStartedSSNError), "All fields are required to get started message is not visible");
    }

    @And("I verify that Get Started button is clickable without an error")
    public void iVerifyThatGetStartedButtonIsClickableWithoutAnError() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue (amazonAdminUI.isSideAlleyGetStartedButtonEnabled(),"Get Started Button is not enabled");
    }

    @And("I verify that I'm happy with my photo Button is available in Review your photo screen SA")
    public void iVerifyThatIMHappyWithMyPhotoButtonIsAvailableInReviewYourPhotoScreenSA() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject ();
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyIamHappyWithMyPhotoButton), "I'm happy with my photo button is not available");
    }

    @And("I can verify that the offline order has a location assigned")
    public void iCanVerifyThatTheOfflineOrderHasALocationAssigned() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject ();
        amazonAdminUI.verifyOrderHasLocationInAdminUI();

    }



    @And("I click the auto-generated Admin UI candidate on the candidate results screen")
    public void iClickTheAutoGeneratedAdminUICandidateOnTheCandidateResultsScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        String retrieveLastName = testObject.getTestData("orderAdminUILastName");
        amazonAdminUI.clickCandidateRowByLastName(retrieveLastName);
    }


    @And("I click the Retake Photo button on the Admin UI adjudication screen")
    public void iClickTheRetakePhotoButtonOnTheAdminUIAdjudicationScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.clickAdminUIRetakeButton();
    }

    @And("I verify the generated candidate is placed at the top of the Placed Orders list in the Admin UI")
    public void iVerifyTheGeneratedCandidateIsPlacedAtTheTopOfThePlacedOrdersListInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.waitForSeconds(4);
        String[] valueToFind = {testObject.getTestData("adminUIOrderFName"), testObject.getTestData("adminUIOrderLName")};
        Assert.assertTrue(amazonAdminUI.isValueInTableRow(valueToFind), "Value was not found in first row of the Table.");

    }


    @And("I verify that I am on the Select Location Page for Offline Orders")
    public void iVerifyThatIAmOnTheSelectLocationPageForOfflineOrders() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleySelectLocationScreen)," Select Location Screen is not displayed");
    }

    @Then("I can verify Side Alley Let's get started page is displayed")
    public void iCanVerifyLetSGetStartedPageIsDisplayed() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyGetStartedScreen), "Side Alley Get Started Screen was not found as expected.");
    }



    @And("I can verify Candidate Results page displayed")
    public void iCanVerifyCandidateResultsPageDisplayed() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyCandidateResultsScreen), "Side Alley Candidate Results Screen was not found as expected.");
    }

    @And("I can verify the order has no location assigned in Side Alley Results")
    public void iCanVerifyTheOrderHasNoLocationAssignedInSideAlleyResults() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject ();
        amazonAdminUI.verifyOrderHasNoLocationInAdminUI();
    }


    @And("I can verify Photo Rules page is displayed")
    public void iCanVerifyPhotoRulesPageIsDisplayed() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyPhotoRulesScreen), "Side Alley Photo Rules Screen was not found as expected.");
    }

    @And("I can verify the Candidate Results page has Name, DOB, Last Digits of SSN and Location columns")
    public void iCanVerifyTheCandidateResultsPageHasNameDOBLastDigitsOfSSNAndLocationColumns() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject ();
        amazonAdminUI.verifySideAlleyResultsPageTableColumns ();

    }

    @And("I can verify the candidate Last Name {string} listed in Candidate Results page")
    public void iCanVerifyTheCandidateLastNameListedInCandidateResultsPage(String lName) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject ();
        amazonAdminUI.searchForlastNameInSideAlleyResults(lName);
    }

    @And("I can verify that the order is assigned to {string} location in Side Alley Results")
    public void iCanVerifyThatTheOrderIsAssignedToLocationInSideAlleyResults(String locationName) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject ();
        amazonAdminUI.verifyOrdersLocationInSideAlleyResults(locationName);
    }
    @When("I enter the Candidate ID Number {string} on the Identification Information Screen")
    public void iEnterTheCandidateIDNumberOnTheInformationScreen(String candidateID) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterCandidateID(candidateID);
    }

    @And("I click invalid option on the Side alley Review Page")
    public void iClickInvalidOptionOnTheSideAlleyReviewPage() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject ();
        amazonAdminUI.clickInvalidInSideAlley();
    }

    @When("I click on I'm happy with my photo button on COC review your photo page in the Admin UI")
    public void iClickOnIMHappyWithMyPhotoButtonOnCOCReviewYourPhotoPageInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject ();
        amazonAdminUI.clickIamHappyCOCPhotoButtonAdminUI ();
    }

    @And("I click the Inconclusive option on the sideAlley Review Page")
    public void iClickTheInconclusiveOptionOnTheSideAlleyReviewPage() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject ();
        amazonAdminUI.clickInconclusiveInSideAlley();
    }

    @And("I select the strips in the Side Alley Review Page")
    public void iSelectTheStripsInTheSideAlleyReviewPage() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject ();
        amazonAdminUI.clickAllStripsInAdminReviewPage();
    }
    @Then("I verify the {string} is available on Admin UI")
    public void iVerifyTheIsAvailableOnAdminUI(String arg0) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.AdminUINewPageTitle), "Drug Testing Center was not found.");
    }


    @Then("I verify Bulk Orders page displays in the Admin UI")
    public void iVerifyBulkOrdersPageDisplaysInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.bulkOrdersPage), "Bulk Orders page was not found as expected.");
    }

    @And("I verify all column headers {string} exists for Bulk Upload Table in the Admin UI")
    public void iVerifyAllColumnHeadersExistsForBulkUploadTableInTheAdminUI(String columns) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        String[] headers = columns.split(",");
        Assert.assertTrue(amazonAdminUI.isBulkUploadColumnHeaderPresent(headers), "");
    }


    @Then("I verify the auto-generated Admin UI candidate displays on the candidate results screen")
    public void iVerifyTheAutoGeneratedAdminUICandidateDisplaysOnTheCandidateResultsScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        String retrieveLastName = testObject.getTestData("orderAdminUILastName");
        amazonAdminUI.isCandidateInFirstRowOfResultsList(retrieveLastName);
    }

    @And("I can verify social Security Number is valid")
    public void iCanVerifySocialSecurityNumberIsValid() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue (amazonAdminUI.isOrderNextButtonEnabled (),"SSN is invalid");
    }

    @And("I can verify that Social Security Number error message appears")
    public void iCanVerifyThatSocialSecurityNumberErrorMessageAppears() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.orderIdentificationInvalidSSNmessage),"SSN is valid");
    }

    @Then("I verify the location is set by default to the previously selected Location {string}")
    public void iVerifyTheLocationIsSetByDefaultToThePreviouslySelectedLocation(String locationName) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.isLocationSelected(locationName).equalsIgnoreCase("true"), "Location " + locationName + " was not selected by default was expected.");
    }

    @Given("I clear the browser cookies")
    public void iClearTheBrowserCookies() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.clearBrowserCookies();
    }
    @And("^I verify the candidate card has booth number \"([^\"]*)\" in the Admin UI$")
    public void i_verify_the_candidate_card_has_booth_number_something_in_the_admin_ui(String boothNumber) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.verifyBoothNumberOnTheCard(boothNumber);


    }


    @And("I verify chronological order exists for items in the Bulk Order List in the Admin UI")
    public void iVerifyChronologicalOrderExistsForItemsInTheBulkOrderListInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.verifyAdminBulkOrdersListedChronological();
    }

    @And("I upload a bad photo for Side Alley in the Admin UI")
    public void iUploadABadPhotoForSideAlleyInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.uploadPhotoSA ("/src/test/resources/testvideos/otoxqrAndbarcode.mjpeg");
    }

    @And("I verify the Sample ID screen appears for Side Alley in the Admin UI")
    public void iVerifyTheSampleIDScreenAppearsForSideAlleyInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        boolean result = amazonAdminUI.exists(amazonAdminUI.sideAlleySampleIdScreen);
        report("Sample ID screen found? " + result);
        Assert.assertTrue(result, "Sample ID screen was not found.");
    }

    @Then("I can verify the invalid device message displays for Side Alley in the Admin UI")
    public void iCanVerifyTheInvalidDeviceMessageDisplaysForSideAlleyInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.sideAlleyinvalidDeviceErrorMsg), "Invalid device message did not appear as expected.");
    }

    @And("I click on the bulk upload button in the Admin UI")
    public void iClickOnTheBulkUploadButtonInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.clickBulkUploadButton();
    }


    @And("I click the submit button on the bulk upload screen in the Admin UI")
    public void iClickTheSubmitButtonOnTheBulkUploadScreenInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.clickBulkUploadSubmitButton();
    }

    @And("I insert the data into the blank batch spreadsheet for the bulk upload in the Admin UI")
    public void iInsertTheDataIntoTheBlankBatchSpreadsheetForTheBulkUploadInTheAdminUI(DataTable dataTable) throws Exception {
        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);
        sharedBaseClass.insertDataInWorksheetCell2(dataTable, true);
    }

    @And("I select a Reason for Test {string} for the bulk upload in the Admin UI")
    public void iSelectAReasonForTestForTheBulkUploadInTheAdminUI(String reason) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.selectBulkUploadReasonForTest(reason);
    }

    @And("I select a package {string} for the bulk upload in the Admin UI")
    public void iSelectAPackageForTheBulkUploadInTheAdminUI(String packageName) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.selectBulkUploadPackage(packageName);
    }
    @And("I verify that I'm happy with my photo button is enabled in the Side Alley COC photo review page")
    public void iVerifyThatIMHappyWithMyPhotoButtonIsEnabledInTheSideAlleyCOCPhotoReviewPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.verifyImHappyBtnCOCPage();
    }

    @And("I verify the batch upload completed Successfully for the Admin UI")
    public void iVerifyTheBatchUploadCompletedSuccessfullyForTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertEquals(amazonAdminUI.getBulkUploadStatusText("AutoBulkUploadFile"), "Completed Successfully",
                "Batch Upload did not successfully upload.");
    }

    @And("I filter by the package name {string} in the Bulk Orders List in the Admin UI")
    public void iFilterByThePackageNameInTheBulkOrdersListInTheAdminUI(String orderPackageName) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.selectBulkPackagesFilter(orderPackageName);
    }

    @And("I verify the Batch File {string} is placed at the top of the Bulk Orders list in the Admin UI")
    public void iVerifyTheBatchFileIsPlacedAtTheTopOfTheBulkOrdersListInTheAdminUI(String values) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        String[] valueToFind = values.split (",");
        Assert.assertTrue (amazonAdminUI.isValueInTableRow (valueToFind), "Value was not found in first row of the Table.");
    }

    @And("I filter by the Bulk Upload Status {string} in the Bulk Orders List in the Admin UI")
    public void iFilterByTheBulkUploadStatusInTheBulkOrdersListInTheAdminUI(String status) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.selectBulkUploadStatusFilter(status);
    }

    @And("I verify that only {string} status appear in the Bulk Orders list of the Admin UI")
    public void iVerifyThatOnlyStatusAppearInTheBulkOrdersListOfTheAdminUI(String status) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.isBulkStatusInAllRows(status), "Status " + status + " was not found in all rows.");
    }

    @And("I verify the Batch File {string} is in the Bulk Orders list of the Admin UI")
    public void iVerifyTheBatchFileIsInTheBulkOrdersListOfTheAdminUI(String filename) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.isFileInBulkOrderList(filename), "Batch Filename " + filename + " was not found in the list.");
    }

    @And("I set the start date range for month {string} and day {string} of the current year for Bulk Upload Orders")
    public void iSetTheStartDateRangeForMonthAndDayOfTheCurrentYearForBulkUploadOrders(String month, String day) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.setBulkUploadStartDate(month, day);
    }

    @And("I set the end data range to current day for Bulk Upload Orders in the Admin UI")
    public void iSetTheEndDataRangeToCurrentDayForBulkUploadOrdersInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.setCurrentMMDDForPOEndDate ( );
    }

    @Then("I provide data on the phone number field in the Admin UI Contact Information Page and verify that the numbers are valid")
    public void iProvideDataOnThePhoneNumberFieldInTheAdminUIContactInformationPageAndVerifyThatTheNumbersAreValid(io.cucumber.datatable.DataTable dataTable) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject( );
        amazonAdminUI.enterPhoneData(dataTable);

    }


    @And("I add a blank batch spreadsheet to use for bulk upload in the Admin UI")
    public void iAddABlankBatchSpreadsheetToUseForBulkUploadInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.useBlankSpreadSheetAndUpload("KeepBlankBulkUploadFile.csv");
    }

    @And("I verify the Bulk Upload Status should be {string} in the Admin UI")
    public void iVerifyTheBulkUploadStatusShouldBeInTheAdminUI(String statuses) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        String[] status = statuses.split (",");
        amazonAdminUI.verifyBulkUploadStatus(status);
    }

    @And("I verify the bulk upload button displays in the Admin UI")
    public void iVerifyTheBulkUploadButtonDisplaysInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminBulkUploadButton), "Bulk Upload button was nof found.");
    }

    @And("I verify the Bulk Spreadsheet Upload Screen appears in the Admin UI")
    public void iVerifyTheBulkSpreadsheetUploadScreenAppearsInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.bulkSpreadsheetUploadScreen), "Bulk Spreadsheet Upload screen was not found.");
    }

    @And("I verify the unsupported file format error message appears on the Bulk Spreadsheet Upload screen in the Admin UI")
    public void iVerifyTheUnsupportedFileFormatErrorMessageAppearsOnTheBulkSpreadsheetUploadScreenInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.bulkUploadInvalidFileFormatMsg), "Invalid file format message was not found.");
    }

    @And("I use an invalid file format for bulk upload in the Admin UI")
    public void iUseAnInvalidFileFormatForBulkUploadInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.useBlankSpreadSheetAndUpload("Invalid.xls");
    }

    @And("I verify the Bulk Spreadsheet Upload package selection dropdown in the Admin UI displays text: Choose a Package")
    public void iVerifyTheBulkSpreadsheetUploadPackageSelectionDropdownInTheAdminUIDisplaysTextChooseAPackage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.bulkUploadPackageSelectionDisplayed(), "Bulk Upload Default Text for Package selection is not displaying.");
    }

    @And("I verify the Bulk Spreadsheet Upload reason selection dropdown in the Admin UI displays text: Choose a Reason For Test")
    public void iVerifyTheBulkSpreadsheetUploadReasonSelectionDropdownInTheAdminUIDisplaysTextChooseAReasonForTest() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.bulkUploadReasonSelectionDisplayed(), "Bulk Upload Default Text  for Reason for Test is not displayed.");
    }

    @And("I verify the submit button on the bulk upload screen is disabled in the Admin UI")
    public void iVerifyTheSubmitButtonOnTheBulkUploadScreenIsDisabledInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertFalse(amazonAdminUI.isAdminUIBulkOrderSubmitButtonEnabled(), "Submit Button for Bulk Upload was enabled when expected to be disabled.");
    }

    @And("I click the detail icon for the batch upload file {string} in the Admin UI")
    public void iClickTheDetailIconForTheBatchUploadFileInTheAdminUI(String fileName) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.clickBulkUploadDetailsIcon(fileName);
    }

    @And("I verify the Bulk Upload Item Details Screen appears in the Admin UI")
    public void iVerifyTheBulkUploadItemDetailsScreenAppearsInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.bulkUploadItemDetailsScreen), "The Bulk Upload Item Details screen did not appear as expected.");
    }
    @And("I filter the generated candidate in Placed Orders List")
    public void iFilterTheGeneratedCandidateInPlacedOrdersList() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject ();
        amazonAdminUI.enterOrderNameInFilterTextbox (testObject.getTestData ( "adminUIOrderLName" ));
        amazonAdminUI.waitForSeconds (5);
    }


    @And("I verify the Bulk Upload Item Details Error Orders Status is {string}")
    public void iVerifyTheBulkUploadItemDetailsErrorOrdersStatusIs(String status) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertEquals(amazonAdminUI.getBulkUploadItemDetailsStatus().toUpperCase(), status.toLowerCase(), "Item Details expected : " + status + " status was not found. ");
    }

    @And("I click the back button on the Bulk Upload Item Details screen of the Admin UI")
    public void iClickTheBackButtonOnTheBulkUploadItemDetailsScreenOfTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.clickBulkUploadItemDetailsButton();
    }

    @And("I verify the Bulk Upload Item Details Error Orders Summary is {string} in the Admin UI")
    public void iVerifyTheBulkUploadItemDetailsErrorOrdersSummaryIsInTheAdminUI(String errorSummary) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertEquals(amazonAdminUI.getBulkUploadItemDetailsErrorSummary(), errorSummary, "Expected Error Orders summary " + errorSummary + " did not match.");
    }

    @And("I verify the Bulk Upload Item Order Details is {string} in the Admin UI")
    public void iVerifyTheBulkUploadItemOrderDetailsIsInTheAdminUI(String orderDetails) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertEquals(amazonAdminUI.getBulkUploadItemOrderDetails(), orderDetails, "Expected Error Order Details " + orderDetails + " did not match.");

    }

    @And("I click on the Bulk Upload Item Details Get Error File link in the Admin UI")
    public void iClickOnTheBulkUploadItemDetailsGetErrorFileLinkInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.clickBulkUploadGetErrorFileLink();
    }

    @And("I verify the required message appears for the missing or invalid social security number field or value")
    public void iVerifyTheRequiredMessageAppearsForTheMissingOrInvalidSocialSecurityNumberFieldOrValue() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertEquals(amazonAdminUI.verifyBatchUploadErrorsInXlsCsvFile(), "Valid 'National ID Number' xxx-xx-xxxx is required;", "Expected error message was not found.");

    }

    @And("I can verify the non active candidate card is not appearing on the Test In Progress Tab")
    public void iCanVerifyTheNonActiveCandidateCardIsNotAppearingOnTheTestInProgressTab() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        //retrieving auto-generated candidate's last name by key
        String candidateFullName = testObject.getTestData("adminUIOrderFName") + " " + testObject.getTestData("adminUIOrderLName");
        Assert.assertFalse (amazonAdminUI.isCandidateCardPresent(candidateFullName), "Current User was found in the search results.");
    }
    @And("I verify the location {string} is assigned for the candidate in the Admin UI")
    public void iVerifyTheLocationIsAssignedForTheCandidateInTheAdminUI(String locationAlias) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject ();
        amazonAdminUI.isLocationExist(locationAlias);
    }

    @And("I open a new browser window")
    public void iOpenANewBrowserWindow() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.openNewBrowserTabWindow();
    }

    @And("I switch to parent window")
    public void iSwitchToParentWindow() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.switchToParentWindow();
    }

    @And("I verify the Create New Order button on the Candidate Not Found page displays in the Admin UI")
    public void iVerifyTheCreateNewOrderButtonOnTheCandidateNotFoundPageDisplaysInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.createNewOrderButtonOnNotFound), "Create New Order button was not found.");

    }

    @Then("I verify that I am on the Admin UI Dashboard")
    public void iVerifyThatIAmOnTheAdminUIDashboard() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.inProgressTab),"Admin UI Dashboard is not visible");
    }
    @When("^I click the clear button on the Admin UI$")
    public void i_click_the_clear_button_on_the_admin_ui() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.clickAdjudicateClear();
    }
    @When("^I click the back on the Adjudicating Page in Admin UI$")
    public void i_click_the_back_on_the_adjudicating_page_in_admin_ui() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickAdjudicatedBackButton ( );
    }
    @And("^I verify that I am navigated to the Electronic Signature page for Admin UI Clear option$")
    public void i_verify_that_i_am_navigated_to_the_electronic_signature_page_for_admin_ui_clear_option() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adminClearSignaturePage),"Signature page is not found");
    }
    @Then("I verify that I am navigated to the Electronic Signature page for Admin UI Retest option")
    public void iVerifyThatIAmNavigatedToTheElectronicSignaturePageForAdminUIRetestOption() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adminRetestSignaturePage),"Signature page is not found");

    }

    @When("I click the Retest button on the Admin UI")
    public void iClickTheRetestButtonOnTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.clickAdjudicateRetest();
    }
    @Then("^I verify the Salaried Leader Pop-Up window appears on the screen$")
    public void i_verify_the_salaried_leader_popup_window_appears_on_the_screen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminSalariedLeaderPopUp),"The Salaried Leader Pop Up window is not found");

    }

    @And("I click the Proceed Button on the Salaried Leader Pop-up window")
    public void iClickTheProceedButtonOnTheSalariedLeaderPopUpWindow() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickElement(amazonAdminUI.adminSLeaderPopUpProceedBtn);
    }

    @And("I enter Salaried Leader Name {string} on the Four Eyes Check page in the Admin UI")
    public void iEnterSalariedLeaderNameOnTheFourEyesCheckPageInTheAdminUI(String SalariedLeaderName) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterSalariedLeaderName(SalariedLeaderName);

    }

    @And("I enter Additional Comments {string} on the Four Eyes Check page in the Admin UI")
    public void iEnterAdditionalCommentsOnTheFourEyesCheckPageInTheAdminUI(String SalariedLeaderComment) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterSalariedLeaderComment(SalariedLeaderComment);
    }

    @And("I click on the Certify button on the Four Eyes Check Page in Admin UI")
    public void iClickOnTheCertifyButtonOnTheFourEyesCheckPageInAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickElement(amazonAdminUI.signAndSubmitButton);
    }

    @And("I adjudicate with Inconclusive option for Four Eyes Check")
    public void iAdjudicateWithInconclusiveOptionForFourEyesCheck() throws Exception {
        AmazonAdminUI app = getAdminUIPageObject ( );
        app.waitForSeconds(1);
        app.selectAdjudicationStripsByIndex (Arrays.asList (1));
        app.signSignaturePadFinalAlcPage ( );
        app.clickAdjudicateSignSubmit ( );
    }

    @And("I can verify a new browser tab opens")
    public void iCanVerifyAnewBrowserTabOpens() {
        Set<String> handlesSet = driver.getWindowHandles();
        int setSize=handlesSet.size();
        Assert.assertEquals(setSize,2,"New browser did not open");
    }
    @Then("^I can verify that I am on the Final Test Result Selection page in the Admin UI$")
    public void i_can_verify_that_i_am_on_the_final_test_result_selection_page_in_the_admin_ui() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminFinalResultSelectPage),"Final Result Selection Page is not found");
    }



    @And("I verify that I am on the Four Eyes Check page in Admin UI")
    public void iVerifyThatIAmOnTheFourEyesCheckPageInAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adminFourEyesCheckPage),"Four Eyes Check page is not found");
    }

    @And("I verify that there is no back button on the Four Eyes Check page under the signature pad")
    public void iVerifyThatThereIsNoBackButtonOnTheFourEyesCheckPageUnderTheSignaturePad() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        By fourEyesCheckBackBtn=By.xpath("//button[contains(text(),'Back')]");
        Assert.assertFalse (amazonAdminUI.exists(fourEyesCheckBackBtn),"There is Back button under the signature pad");

    }

    @And("I verify that the Certify button on the Four Eyes Check page is disabled")
    public void iVerifyThatTheCertifyButtonOnTheFourEyesCheckPageIsDisabled() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.waitForSeconds(3);
        Assert.assertFalse (amazonAdminUI.adminFourEyesCheckCertifyBtnWE.isEnabled(),"Certify Button is enabled");

    }
    @And("I verify that the Certify button on the Four Eyes Check page is enabled")
    public void iVerifyThatTheCertifyButtonOnTheFourEyesCheckpageIsEnabled() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue (amazonAdminUI.adminFourEyesCheckCertifyBtnWE.isEnabled(),"Certify Button is disabled");

    }


    @And("I enter a signature for the Four Eyes Check page")
    public void iEnterASignatureForTheFourEyesCheckPage() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        amazonAdminUI.signSignaturePad4EyesCheck();

    }
    @And("^I click on the Final Test Result Page in the Admin UI$")
    public void i_click_on_the_final_test_result_page_in_the_admin_ui() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        amazonAdminUI.clickElement(amazonAdminUI.adminFinalResultSelectPage);
    }

    @And("I verify that the view example button is enabled for Clear Option in Admin UI")
    public void iVerifyThatTheViewExampleButtonIsEnabledForClearOptionInAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue (amazonAdminUI.adminViewExampleClearWE.isEnabled()," Clear Examples Button is disabled");
    }

    @And("I click the view example button for Clear Option in Admin UI")
    public void iClickTheViewExampleButtonForClearOptionInAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.clickElement(amazonAdminUI.adminViewExampleClearBtn);
    }

    @And("I verify that the Clear pictures example page is shown in Admin UI")
    public void iVerifyThatTheClearPicturesExamplePageIsShownInAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue (amazonAdminUI.exists(amazonAdminUI.adminClearExamplesPage), "Clear Examples page is not found");
    }


    @And("I verify that the view example button is enabled for Inconclusive Option in Admin UI")
    public void iVerifyThatTheViewExampleButtonIsEnabledForInconclusiveOptionInAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue (amazonAdminUI.adminViewExampleInconclusiveWE.isEnabled()," Inconclusive Examples Button is disabled");
    }

    @And("I click the view example button for Inconclusive Option in Admin UI")
    public void iClickTheViewExampleButtonForInconclusiveOptionInAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.clickElement(amazonAdminUI.adminViewExampleInconclusiveBtn);
    }

    @And("I verify that the Inconclusive pictures example page is shown in Admin UI")
    public void iVerifyThatTheInconclusivePicturesExamplePageIsShownInAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue (amazonAdminUI.exists(amazonAdminUI.adminInconclusiveExamplesPage), "Inconclusive Examples page is not found");
    }


    @And("I verify that the view example button is enabled for Retest Option in Admin UI")
    public void iVerifyThatTheViewExampleButtonIsEnabledForRetestOptionInAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue (amazonAdminUI.adminViewExampleRetestWE.isEnabled()," Retest Examples Button is disabled");
    }

    @And("I click the view example button for Retest Option in Admin UI")
    public void iClickTheViewExampleButtonForRetestOptionInAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.clickElement(amazonAdminUI.adminViewExampleRetestBtn);
    }

    @And("I verify that the Retest pictures example page is shown in Admin UI")
    public void iVerifyThatTheRetestPicturesExamplePageIsShownInAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue (amazonAdminUI.exists(amazonAdminUI.adminRetestExamplesPage), "Retest Examples page is not found");
    }

    @And("I click on the Four Eyes Check Page in the Admin UI")
    public void iClickOnTheFourEyesCheckPageInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.clickElement(amazonAdminUI.adminFourEyesCheckPage);
    }

    @And("I can verify the Retest picture example page is closed in Admin UI")
    public void iCanVerifyTheRetestPictureExamplePageIsClosedInAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertFalse (amazonAdminUI.exists(amazonAdminUI.adminRetestExamplesPage), "Retest Examples page  not found");
    }
    @And("I click on the adjudication screen on the Admin UI")
    public void iClickOnTheAdjudicationScreenOnTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        amazonAdminUI.clickElement(amazonAdminUI.adjudicatingScreen);
    }


    @And("I click the close button on the picture example page in the Admin UI")
    public void iClickTheCloseButtonOnThePictureExamplePageInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        amazonAdminUI.clickElement(amazonAdminUI.adminExampleCloseBtn);

    }


    @And("I enter Amazon Alias {string}")
    public void iEnterAmazonAlias(String amazonAlias) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        amazonAdminUI.enterAlias(amazonAlias);
    }

    @And("^I verify the error message for Alias is given in Identification Page of Admin UI$")
    public void i_verify_the_error_message_for_alias_is_given_in_identification_page_of_admin_ui() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminAmazonAliasErrorMsg),"Amazon Alias error message is not given");
    }

    @Then("I verify Location Name and State search filters are displayed in the Landing Page of the Admin UI")
    public void iVerifyLocationNameAndStateSearchFiltersAreDisplayedInTheLandingPageOfTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminLandingPageLocationFilter),"Location Name filter is not found");
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminLandingPageStateFilter),"State filter is not found");
    }

    @And("I verify Location Name and State fields are displayed in the Search Results Grid of the Landing Page")
    public void iVerifyLocationNameAndStateFieldsAreDisplayedInTheSearchResultsGridOfTheLandingPage() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminLandingPageLocationField),"Location Name field is not found");
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminLandingPageStateField),"State field is not found");

    }
    @And("^I verify that I am on the Locations Landing page of the Admin UI$")
    public void i_verify_that_i_am_on_the_locations_landing_page_of_the_admin_ui() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminLocationsLandingPage),"Locations Landing Page  is not found");

    }
    @And("I click on the location link for {string} in the Admin UI")
    public void iClickOnTheLocationLinkForInTheAdminUI(String locationNameIn) throws Exception {
        String locationName = Util.getNonAdjLocationAliasBasedOnEnvironment(locationNameIn);
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.waitForSeconds(2);
        amazonAdminUI.clickLocationLink(locationName);
    }
    @Then("I verify that I am navigated to Tracking Information page in the Admin UI")
    public void iVerifyThatIAmNavigatedToTrackingInformationPageInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        amazonAdminUI.waitForSeconds(2);
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adminTrackingInformationPage), "Tracking Information Page was not found.");
    }

    @And("I select the carrier {string} in the Tracking Information page of the Admin UI")
    public void iSelectTheCarrierInTheTrackingInformationPageOfTheAdminUI(String carrier) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.adminSelectCarrier (carrier);
    }

    @And("I enter the Tracking Number {string} for Tracking Information page of the Admin UI")
    public void iEnterTheTrackingNumberForTrackingInformationPageOfTheAdminUI(String trackingNumber) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        amazonAdminUI.enterTrackingNumber(trackingNumber);
    }


    @And("I click on the Certify button in the Tracking Information page of the Admin UI")
    public void iClickOnTheCertifyButtonInTheTrackingInformationPageOfTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickTrackingCertifyBtn();
    }

    @And("I verify the Certify Button is disabled in the Tracking Information page of the Admin UI")
    public void iVerifyTheCertifyButtonIsDisabledInTheTrackingInformationPageOfTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertFalse(amazonAdminUI.orderNextWebElementButton.isEnabled(),"Tracking certify button is enabled");
    }


    @And("I verify the Certify Button is enabled in the Tracking Information page of the Admin UI")
    public void iVerifyTheCertifyButtonIsEnabledInTheTrackingInformationPageOfTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.orderNextWebElementButton.isEnabled(),"Tracking certify button is disabled");
    }

    @When("I verify that User Guide is visible")
    public void iVerifyThatUserGuideIsVisible() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.waitForSeconds (2);
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adminUIUserGuide), "User Guide does not exist");
    }

    @Then("I verify that version number is not visible on the Admin UI")
    public void iVerifyThatVersionNumberIsNotVisible() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.waitForSeconds (2);
        Assert.assertFalse(amazonAdminUI.exists(amazonAdminUI.adminUIVersionNumber), "Version Number is visible in Admin UI");
    }

    @Then("I verify Employee ID field is displayed in the Identification Information Screen")
    public void iVerifyEmployeeIDFieldIsDisplayedInTheIdentificationInformationScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.orderIdentificationEmpIDLabel),"Employee ID field is missing");
    }

    @And("I verify Candidate ID field is not displayed in the Identification Information Screen")
    public void iVerifyCandidateIDFieldIsNotDisplayedInTheIdentificationInformationScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertFalse(amazonAdminUI.exists(amazonAdminUI.orderIdentificationCIDLabel),"Employee ID field is missing");
    }

    @And("I enter the Employee ID Number {string} on the Identification Information Screen")
    public void iEnterTheEmployeeIDNumberOnTheIdentificationInformationScreen(String employeeID) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        amazonAdminUI.enterEmployeeID(employeeID);
    }

    @And("I verify Employee ID Error message is given in the Admin UI")
    public void iVerifyEmployeeIDErrorMessageIsGivenInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.waitForSeconds(1);
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.orderIdentificationEmpIDErrorMsg),"Employee ID error message is missing");

    }
    @And("^I enter \"([^\"]*)\" into the Location search filter of Landing Page in Admin UI$")
    public void i_enter_something_into_the_location_search_filter_of_landing_page_in_admin_ui(String locationName) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        amazonAdminUI.searchForLocation(locationName);

    }
    @And("^I can verify that No Matching Locations Found error message is given$")
    public void i_can_verify_that_no_matching_locations_found_error_message_is_given() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminLandingPageErrorMsg),"No Matching Locations Found error message is not given.");

    }

    @And("I enter {string} into the State search filter of Landing Page in Admin UI")
    public void iEnterIntoTheStateSearchFilterOfLandingPageInAdminUI(String state) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        amazonAdminUI.searchForState(state);
    }

    @And("^I can verify that the search results are showing \"([^\"]*)\" locations in the Admin UI$")
    public void i_can_verify_that_the_search_results_are_showing_something_locations_in_the_admin_ui(String searchLocation) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        amazonAdminUI.verifyLocationSearchResults(searchLocation);
    }

    @And("I can verify that the search results are showing {string} state locations in the Admin UI")
    public void iCanVerifyThatTheSearchResultsAreShowingStateLocationsInTheAdminUI(String searchState) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        amazonAdminUI.verifyLocationStateSearchResults(searchState);
    }
    @Then("^I verify that Tracking Information Page was not displayed in the Admin UI$")
    public void i_verify_that_tracking_information_page_was_not_displayed_in_the_admin_ui() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        Assert.assertFalse (amazonAdminUI.exists (amazonAdminUI.adminTrackingInformationPage), "Tracking Information Page was found.");
    }


    @Then("I can verify the Recent Locations are {string}, {string} and {string} in the Admin UI")
    public void iCanVerifyTheRecentLocationsAreAndInTheAdminUI(String location1, String location2, String location3) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.waitForSeconds(2);
        amazonAdminUI.verifyRecentLocations(location1,location2,location3);

    }

    @And("I can verify that I am on the Tests in Progress page of the Admin UI")
    public void iCanVerifyThatIAmOnTheTestsInProgressPageOfTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.waitForSeconds(2);
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.inProgressTab),"Tests in Progress Page is not navigated");

    }
    @And("I click certify and submit button for the adjudication")
    public void iClickCertifyAndSubmitButtonForTheAdjudication() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickAdjudicateCertifySubmit ( );
    }
    @And("^I verify that the status of the order is invalid$")
    public void iVerifyThatTheStatusOfTheOrderIsInvalid() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminInvalidOrder), "The status of the order is not invalid");
    }
    @And("^I verify that the status of the order is in progress$")
    public void iVerifyThatTheStatusOfTheOrderIsInProgress() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminInProgressOrder), "The status of the order is not in progress");
    }
    @And("I upload the photo of my device with new QR code format in Side Alley")
    public void iUploadThePhotoOfMyDeviceWithNewCRCodeFormatInSideAlley() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.uploadPhotoSA ("/src/test/resources/testvideos/NewFormatQRCode.png");
    }
    @And("I enter the sample ID {string} on the first field on Side-Alley")
    public void iEnterTheSampleIDOnTheFirstFieldOnSideAlley(String sampleId) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterSampleIDInFirstField(sampleId, true);
        report(Status.PASS, "Sample Information was entered.");
    }
    @And("I enter the sample ID {string} on the second field on Side-Alley")
    public void iEnterTheSampleIDOnTheSecondFieldOnSideAlley(String sampleId) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.enterSampleIDInSecondField(sampleId, true);
        report(Status.PASS, "Sample Information was entered.");
    }
    @And("I verify All fields are required to go next message appears on Side Alley Enter ID screen")
    public void iVerifyAllFieldsAreRequiredToGoNextMessageAppears() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleyAllFieldsAreRequiredError), "All fields are required error message is not visible");

    }
    @And("I verify that sample ID format error message appears on Side Alley Enter ID screen")
    public void iVerifySampleIDFormatErrorMessageAppears() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleySpecimenIDFormatError), "Specimen ID format error message is not visible");
    }
    @And("I verify that sample ID not matching error message appears on Side Alley Enter ID screen")
    public void iVerifySampleIDNOtMatchingErrorMessageAppears() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.sideAlleySpecimenIDsNotMatchingError ), "Sample ID Not matching error message is not visible");
    }
    @And("I click certify button for the adjudication in the Modified Adjudication Page")
    public void iClickCertifyButtonForTheAdjudicationInTheModifiedAdjudicationPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickModifiedAdjudicationCertifyBtn ( );
    }

    @And("I can verify {string} button is disabled on the Modified Adjudication Page")
    public void iCanVerifyButtonIsDisabledOnTheModifiedAdjudicationPage(String buttonName) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertFalse (amazonAdminUI.abandonedButtonWebElement.isEnabled() ,"Abandoned Process Button is enabled");
    }
    @And("I can verify {string} and {string} buttons are enabled on the Modified Adjudication Page")
    public void iCanVerifyAndButtonsAreEnabledOnTheModifiedAdjudicationPage(String buttonName1, String buttonName2) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.adminModifiedAdjudicationRetestWE.isEnabled() ,"Retest Button is not enabled");
        Assert.assertTrue (amazonAdminUI.adminModifiedAdjudicationValidWE.isEnabled() ,"Valid Button is not enabled");
    }

    @And("I click on the candidate card for {string} in the Admin UI")
    public void iClickOnTheCandidateCardForInTheAdminUI(String candidateName) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        By card= By.xpath("//div[contains(text(),"+candidateName+")]");
        report ("Candidate picked to adjudicate: " + card.toString());
        amazonAdminUI.clickElement(card);
    }

    @And("I click Valid Button in the Modified Adjudication Page of the Admin UI")
    public void iClickValidButtonInTheModifiedAdjudicationPageOfTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickValidForModifiedAdminPage();
    }

    @And("I verify that the view examples button is enabled for Valid Option in Admin UI")
    public void iVerifyThatTheViewExamplesButtonIsEnabledForValidOptionInAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.adminModifiedViewExampleValidWE.isEnabled(),"View Examples button is not enabled for Valid option");

    }

    @And("I verify that the view examples button is enabled for Retest Option in Admin UI")
    public void iVerifyThatTheViewExamplesButtonIsEnabledForRetestOptionInAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.adminModifiedViewExampleRetestWE.isEnabled(),"View Examples button is not enabled for Retest option");

    }

    @And("I click Retest button in the Modified Adjudication Page of Admin UI")
    public void iClickRetestButtonInTheModifiedAdjudicationPageOfAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickRetestForModifiedAdminPage();
    }

    @And("I verify Select a reason and certify page is displayed in the Admin UI")
    public void iVerifySelectAReasonAndCertifyPageIsDisplayedInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminRetestSignaturePage),"Select a reason and certify page is not displayed");
    }

    @And("I verify the page title is showing as Validating for Modified Adjudication page")
    public void iVerifyThePageTitleIsShowingAsValidatingForModifiedAdjudicationPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminModifiedAdjudicationPageTitle)," Page Title is not showing as Validating");
    }

    @And("I verify the confirm button is displayed on the Modified Adjudication Confirmation modal")
    public void iVerifyTheConfirmButtonIsDisplayedOnTheModifiedAdjudicationConfirmationModal() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminModifiedAdjudicationModalConfirmBtn),"Confirm Button is not displayed");
    }

    @And("I verify that I am navigated to Sign and Submit Page in the Admin UI")
    public void iVerifyThatIAmNavigatedToSignAndSubmitPageInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminModifiedAdjudicationCertifySignPage), "Certify and Sign page was not displayed");
    }

    @And("I verify that I am on the Select Reason Page of Modified Adjudication Flow")
    public void iVerifyThatIAmOnTheSelectReasonPageOfModifiedAdjudicationFlow() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminRetestSignaturePage), "Select a reason page is not found ");
    }

    @Then("I verify that Reason, Country, City and State fields are displayed in the Location Page")
    public void iVerifyThatReasonCountryCityAndStateFieldsAreDisplayedInTheLocationPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.verifyLocationPageFields();
    }
    @And("I verify the Reason {string} is the default option in the Location Page")
    public void iVerifyTheReasonIsTheDefaultOptionInTheLocationPage(String reasonForTest) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.verifyReasonPre(reasonForTest);
    }

    @Then("I can verify Business Line field is disabled in Package Information Screen")
    public void iCanVerifyBusinessLineFieldIsDisabledInPackageInformationScreen() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertFalse(amazonAdminUI.orderBusinessLineWE.isEnabled(),"Business Line field is enabled");
    }

    @And("I can verify {string} is the default Package option on the Package Information Screen")
    public void iCanVerifyIsTheDefaultPackageOptionOnThePackageInformationScreen(String packageOption) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.verifyDefaultPackage(packageOption);
    }

    @And("I verify Business Line drop down options are listed as expected on the Package Information Page")
    public void iVerifyBusinessLineDropDownOptionsAreListedAsExpectedOnThePackageInformationPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.verifyBusinessLineDropDownList();
    }

    @And("I verify Package drop down options are listed as expected on the Package Information Page")
    public void iVerifyPackageDropDownOptionsAreListedAsExpectedOnThePackageInformationPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.verifyPackageDropDownList();
    }

    @And("I select the Business Line {string} on the Package Information Page")
    public void iSelectTheBusinessLineOnThePackageInformationPage(String businessLine) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.selectBusinessLine(businessLine);
    }

    @And("I verify that the candidate card is showing {string} step in the Admin UI")
    public void iVerifyThatTheCandidateCardIsShowingStepInTheAdminUI(String stepOnTheCard) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.verifyStepOnCard(stepOnTheCard);

    }

    @Then("I verify Dashboard Button is displayed in the Admin UI")
    public void iVerifyDashboardButtonIsDisplayedInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminDashboardButton),"Dashboard Button is not displayed");

    }

    @And("I click Dashboard Button in the Admin UI")
    public void iClickDashboardButtonInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickDashboardBtn();

    }

    @And("I verify the Adjudication Page displays with Clear,Inconclusive, Retest and Abandoned Options in the Admin UI")
    public void iVerifyTheAdjudicationPageDisplaysWithClearInconclusiveRetestAndAbandonedOptionsInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adjudicateClearButton), "The clear button is not found");
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adjudicateInconclusivebutton), "The Inconclusive button is not found");
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adjudicateRetestButton), "The Retest button is not found");
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adjudicateAbandonedButton), "The Abandoned button is not found");


    }

    @And("I verify that I am in the Alcohol Adjudication Page of the Admin UI")
    public void iVerifyThatIAmInTheAlcoholAdjudicationPageOfTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminAlcoholAdjudicationPage), "The clear button is not found");
    }

    @And("I click the alcohol result box {string} on the Admin UI")
    public void iClickTheAlcoholResultBoxOnTheAdminUI(String alcoholResult) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        By alcoholBox=By.xpath("//span[contains(text(),'"+alcoholResult+"')]");
        amazonAdminUI.clickElement(alcoholBox);
    }

    @And("I verify that I am on the Certify Clear Test Results page for Drug and Alcohol Test of Admin UI")
    public void iVerifyThatIAmOnTheCertifyClearTestResultsPageForDrugAndAlcoholTestOfAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminAlcoholCertifyClearPage), "The Certify Clear Page is not found");

    }
    @And("I verify that I am able to select Clear, Inconclusive or Retest for Drug results in the Four Eyes Check Page")
    public void iVerifyThatIAmAbleToSelectClearInconclusiveOrRetestForDrugResultsInTheFourEyesCheckPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.verify4EyesCheckPageDrugOptions();
    }

      @And("I verify that I am able to select any of the Alcohol checkboxes and the language changes accordingly in the Four Eyes Check Page")
    public void iVerifyThatIAmAbleToSelectAnyOfTheAlcoholCheckboxesAndTheLanguageChangesAccordinglyInTheFourEyesCheckPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.verify4EyesCheckCertificationForAlcoholLevels();
    }

    @And("I verify that the Sign and Submit button is disabled in the Four eyes Check Page")
    public void iVerifyThatTheSignAndSubmitButtonIsDisabledInTheFourEyesCheckPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertFalse(amazonAdminUI.adminModifiedAdjudicationCertifyBtnWE.isEnabled(),"Sign and Submit button is enabled");
    }

    @And("I click the Sign and Submit button in the Four eyes Check Page")
    public void iClickTheSignAndSubmitButtonInTheFourEyesCheckPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickElement(amazonAdminUI.signAndSubmitButton);
    }

    @And("I verify that the Next button is disabled on the Alcohol Adjudication Page of the Admin UI")
    public void iVerifyThatTheNextButtonIsDisabledOnTheAlcoholAdjudicationPageOfTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertFalse(amazonAdminUI.alcoholFlowNextButtonWebElement.isEnabled(), "Next Button is enabled");
    }

    @And("I verify that I am on the Final Test Result Selection - Alcohol page of the Admin UI")
    public void iVerifyThatIAmOnTheFinalTestResultSelectionAlcoholPageOfTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminFinalResultSelectAlcPage),"Final Test Result Selection - Alcohol Page is not found");

    }

    @And("I verify that I am on the Certify Test Results page of the Admin UI")
    public void iVerifyThatIAmOnTheCertifyTestResultsPageOfTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminCertifyTestResultsPage),"Final Test Result Selection - Alcohol Page is not found");

    }

    @And("I verify that Seven Drug Strips are enabled for selection on the Certify Test Results Page")
    public void iVerifyThatSevenDrugStripsAreEnabledForSelectionOnTheCertifyTestResultsPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
       amazonAdminUI.drugHas7Strips();
    }

    @And("I verify that Alcohol checkboxes are disabled on the Certify Test Results Page")
    public void iVerifyThatAlcoholCheckboxesAreDisabledOnTheCertifyTestResultsPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.verifyAlcBoxesDisabled();
    }

    @And("I select test strips {string} as inconclusive on the Certify Test Results Page")
    public void iSelectTestStripsAsInconclusiveOnTheCertifyTestResultsPage(String strips) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.waitForSeconds(1);
        String members[]=strips.split(",");
        for (String member:members
             ) {
            amazonAdminUI.selectAdjudicationStripsByIndex (Arrays.asList (Integer.parseInt(member)));
        }

    }

    @And("I enter a signature for the Certify Test Results page of the Admin UI")
    public void iEnterASignatureForTheCertifyTestResultsPageOfTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.signSignaturePadFinalAlcPage();
    }

    @And("I verify that Alcohol Checkboxes are showing {string} in the Concluded Tests Tab")
    public void iVerifyThatAlcoholCheckboxesAreShowingInTheConcludedTestsTab(String alcBox) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject( );
        amazonAdminUI.checkConcludedTabAlcCheckBoxes(alcBox);
    }
    @And("I verify that Final Test Result Selection Page displays the Four Eyes Check Result in the Admin UI")
    public void iVerifyThatFinalTestResultSelectionPageDisplaysTheFourEyesCheckResultInTheAdminUi() throws Exception{
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.verifyFinalTestResultHas4EyesSelection();
    }

    @And("I click sign and submit button in the Admin UI")
    public void iClickSignAndSubmitButtonInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickAdjudicateSignSubmit();
    }

    @And("I enter the consent signature for retest option in the Admin UI")
    public void iEnterTheConsentSignatureForRetestOptionInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.signSignaturePadFinalAlcPage();
    }

    @And("I verify that I am on the Start Over Page of the Applicant UI")
    public void iVerifyThatIAmOnTheStartOverPageOfTheApplicantUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.applicantStartOverPage), "Start Over Page is not found");
    }

    @And("I verify that the Certify Clear Test Results page has the device picture and the Alcohol selection boxes")
    public void iVerifyThatTheCertifyClearTestResultsPageHasTheDevicePictureAndTheAlcoholSelectionBoxes() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject( );
        amazonAdminUI.verifyCertifyClearPage();
    }

    @And("I verify Confirm and Cancel buttons are displayed on the confirmation popup window")
    public void iVerifyConfirmAndCancelButtonsAreDisplayedOnTheConfirmationPopupWindow() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject( );
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adjConfirmButton), "Confirm button is not shown");
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adjCancelButton), "Cancel button is not shown");
    }

    @When("I click on the menu and choose Support Tools")
    public void iClickOnTheMenuAndChooseSupportTools() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.waitForSeconds(3);
        amazonAdminUI.clickSupportTools ( );
    }

    @And("^I verify that I am on the Support Tools page of the Admin UI$")
    public void i_verify_that_i_am_on_the_Support_Tools_page_of_the_admin_ui() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminSupportToolsPage),"Support Tools Page  is not found");

    }

    @And("I verify Search by Name and Search by Device ID search boxes are displayed in the Support Tools Page of the Admin UI")
    public void iVerifySearchByNameAndSearchByDeviceIDSearchBoxesAreDisplayedInTheSupportToolsPageOfTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminSupportToolsPageSearchByName),"Search by Name field is not found");
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminSupportToolsPageSearchByDeviceID),"Search by Device ID field is not found");
    }

    @And("I enter {string} into the Search by Name search box of Support Tools Page in Admin UI")
    public void iEnterIntoTheSearchByNameSearchBoxFieldOfSupportToolsPageInAdminUI(String name) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        amazonAdminUI.searchByName(name);
    }

    @And("^I can verify that system display zero result found$")
    public void i_can_verify_that_system_dispaly_zero_result_found() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminSupportToolsPageZeroResultFoundErrorMsg),"Zero result Found error message is not given.");

    }

    @And("^I enter \"([^\"]*)\" into the Search by Name field on Support Tools Page in Admin UI$")
    public void i_enter_something_into_the_Search_by_Name_on_Support_Tools_page_in_admin_ui(String CandidateName) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        amazonAdminUI.searchForCandidate(CandidateName);

    }

    @And("^I can verify that the search results are showing for \"([^\"]*)\" candidate on the Support Tools in the Admin UI$")
    public void i_can_verify_that_the_search_results_are_showing_for_something_candidate_on_the_support_tool_in_the_admin_ui(String searchCandidate) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        amazonAdminUI.verifyCandidateSearchResults(searchCandidate);
    }

    @And("I verify column headers in Support Tools Page are Name, Last Update, Device ID, Wellness ID, Status,Step")
    public void iVerifyColumnHeadersInSupportToolsPageAreNameLastUpdateDeviceIDWellnessIDStatusStep() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.verifyAdminSupportToolsColumnTitles ( );
    }

    @And("^I enter \"([^\"]*)\" into the Search by Device ID field on Support Tools Page in Admin UI$")
    public void i_enter_something_into_the_Search_by_Device_ID_on_Support_Tools_page_in_admin_ui(String DeviceID) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        amazonAdminUI.searchForDeviceID(DeviceID);

    }

    @And("^I can verify that the search results are showing for \"([^\"]*)\" Device ID on the Support Tools in the Admin UI$")
    public void i_can_verify_that_the_search_results_are_showing_for_something_Device_ID_on_the_suppot_tools_in_the_admin_ui(String searchDeviceID) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.verifyDeviceIDSearchResults(searchDeviceID);
    }

    @And("I enter consent signature for Abandoned Process in the Admin UI")
    public void iEnterConsentSignatureForAbandonedProcessInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        amazonAdminUI.signSignaturePadAbandoned();
    }

    @When("I click on the name field of results on the Support Tools")
    public void iClickOnTheNameFieldResultsOnTheSupportTools() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickNameFieldOnSupportTools ( );
    }

    @And("I enter {string} for Wellness Advantage ID in Support Tool in Admin UI")
    public void iEnterWAIdSupportTool(String WellnessAdvantageID) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.WellnessAdvantageID (WellnessAdvantageID);
    }

    @When("I click on the Save Changes button on the Support Tool")
    public void iClickOnTheSaveChangesButtonOnTheSupportTools() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickSaveChangesOnSupportTools ( );
    }

    @And("I verify the Changes Saved Successfully message appears on the Support Tools")
    public void iVerifyChangesSavedSuccessfullyMessageAppearsSupportTool() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertTrue (amazonAdminUI.exists (amazonAdminUI.adminSaveChangesSuccessfullyMessage), "Changes Saved Successfully message was not appeared.");
        amazonAdminUI.waitForSeconds(2);
    }

    @And("^I can verify that I can see the candidate \"([^\"]*)\" on the results page of Support Tool in the Admin UI$")
    public void i_can_verify_that_I_can_see_the_candidate_showing_for_something_on_the_support_tool_in_the_admin_ui(String candidateName) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        amazonAdminUI.verifyCandidateSearchResults(candidateName);
    }

    @And("^I can verify that I can see the candidate name \"([^\"]*)\" on the Support Tool in Admin UI$")
    public void i_can_verify_that_I_can_see_the_candidate_name_showing_for_something_on_the_support_tool_in_the_admin_ui(String candidateName) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        amazonAdminUI.verifyCandidateName(candidateName);
    }

    @And("^I verify that I can see last Updated on the Support Tool in Admin UI$")
    public void i_verify_that_I_can_see_last_Updated_on_the_Support_Tool_in_Admin_UI() throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminSupportToolsResultsPageLastUpdated),"last Updated is not given.");
    }

    @And("^I verify that I can see Device ID on the Support Tool in Admin UI$")
    public void i_verify_that_I_can_see_Device_ID_on_the_Support_Tool_in_Admin_UI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminSupportToolsResultsPageDeviceID), "Device ID is not given.");
    }

    @And("^I verify that I can see Current Status on the Support Tool in Admin UI$")
    public void i_verify_that_I_can_see_Current_Status_on_the_Support_Tool_in_Admin_UI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminSupportToolsResultsPageCurrentStatus), "Current Status is not given.");
    }

    @And("^I verify that I can see Current Step on the Support Tool in Admin UI$")
    public void i_verify_that_I_can_see_Current_Step_on_the_Support_Tool_in_Admin_UI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminSupportToolsResultsPageCurrentStep), "Current Step is not given.");
    }

    @And("^I verify that I can see Current Step Drop-down on the Support Tool in Admin UI$")
    public void i_verify_that_I_can_see_Current_Step_Drop_Down_on_the_Support_Tool_in_Admin_UI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminSupportToolsResultsPageCurrentStepDropDown), "Current Step Drop-down is not given.");
    }

    @And("I choose the Current Step {string} on the Search results page on the Support Tool")
    public void iChooseTheCurrentStepOnTheSearchResultsPageOnTheSupportTool(String step) throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.selectCurrentStep (step);
    }

    @And("^I can verify that I can see the candidate \"([^\"]*)\" on the JSON on the results page of Support Tool in the Admin UI$")
    public void i_can_verify_that_I_can_see_the_candidate_showing_for_something_on_the_JSON_on_the_support_tool_in_the_admin_ui(String candidateNameInTheJSON) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject();
        amazonAdminUI.verifyCandidateInTheJSON(candidateNameInTheJSON);
    }

    @And("I click the Back to Results button on the Support Tools in the Admin UI")
    public void iClickTheBakcToResultsButtonOnTheSupportToolsInTheAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickBackToResultsButtonSupportTools ( );
        amazonAdminUI.waitForSeconds(2);
    }

    @And("^I verify that the Current Step is RETAKE PHOTO on the candidate search results page on Support Tool in Admin UI$")
    public void i_verify_that_the_current_step_is_retake_photo_on_the_candidate__search_results_page_on_Support_Tool_in_Admin_UI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.adminSupportToolsSearchPageCurrentStep), "The Current Step is Not Retake Photo.");
        amazonAdminUI.waitForSeconds(2);
    }

    @And("I verify the Sign and Submit button is disabled in Admin UI")
    public void iVerifyThatTheSignAndSubmitButtonIsDisabledInAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertFalse(amazonAdminUI.adminModifiedAdjudicationCertifyBtnWE.isEnabled(),"Sign and Submit button is enabled");
    }


    @And("I verify the one strip column is showing {string} for candidate {string} in the Admin UI Placed Order Page")
    public void iVerifyTheOneStripColumnIsShowingForCandidateInTheAdminUIPlacedOrderPage(String isOneStrip, String candidate) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject ();
        amazonAdminUI.isOneStrip(isOneStrip,candidate);
    }

    @And("I verify the page title is showing as Location Information page")
    public void iVerifyThePageTitleIsShowingAsLocationInformationPage()  throws Exception {
        AmazonAdminUI amazonAdminUI =getAdminUIPageObject ( );
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.locationInformationPageTitle)," Page Title is not showing as Location Information");
    }

    @And("I enter a signature in the last Adjudication page of the Admin UI")
    public void iEnterASignatureInTheLastAdjudicationPageOfTheAdminUI() throws Exception {
        AmazonAdminUI app = getAdminUIPageObject ( );
        app.waitForSeconds(1);
        app.signSignaturePadFinalAlcPage ( );
    } 

    @And("I select the Inconclusive strips for the order in Admin UI")
    public void iSelectTheInconclusiveStripsForTheOrderInAdminUI() throws Exception {
        AmazonAdminUI app = getAdminUIPageObject ( );
        app.waitForSeconds(1);
        app.selectAdjudicationStripsByIndex (Arrays.asList (1));
    }

 @And("I verify that I can see the business Line as {string} on the Package Information page of Admin UI")
    public void iVerifyThatICanSeeTheBusinessLineAs(String BusinessLine) throws Exception {
        AmazonAdminUI amazonAdminUI=getAdminUIPageObject ();
        Assert.assertTrue(amazonAdminUI.exists(amazonAdminUI.businessLine)," The "+ BusinessLine + " business line was not found");
    }

    @And("I click on the Business Line list on the Package Information Page")
    public void iClickOnTheBusinessLineListOnThePackageInformationPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickBusinessLineList ( );
    }

    @And("I verify that the Business Line is disabled on the Package Information page of Admin UI")
    public void iVerifyThatTheBusinessLineIsDisabledOnThePackageInformationPageOfAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        Assert.assertFalse(amazonAdminUI.orderBusinessLineWE.isEnabled(),"Sign and Submit button is enabled");
    }

    @And("I click on the Reason for test drop-down menu in Admin UI")
    public void iClickOnTheReasonForTestDropDownMenuInAdminUI() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.clickReasonForTest ( );
    }

    @And("I verify Order Reasons drop down options are listed as expected on the Location Information Page")
    public void iVerifyOrderReasonsDropDownOptionsAreListedAsExpectedOnTheLocationInformationPage() throws Exception {
        AmazonAdminUI amazonAdminUI = getAdminUIPageObject ( );
        amazonAdminUI.verifyOrderReasonDropDownList();
    }


    @Given("Set Page")
    public void setPage(DataTable dataTable) {
             WebElementHelper.setPage(dataTable.values().get(0));
        if (!WebElementHelper.getRecordMode()) {
            WebElementHelper.retrieveExistingMapFromFile();
        }
    }
}






      




















      













