package com.fadv.automation.stepdef;

import com.aventstack.extentreports.Status;
import com.fadv.automation.core.BaseClass;
import com.fadv.automation.core.Environment;
import com.fadv.automation.core.SeleniumBaseClass;
import com.fadv.automation.core.TestObject;
import com.fadv.automation.pageobjects.AmazonApplicant;
import com.fadv.automation.utils.Util;
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

import java.io.IOException;
import java.util.logging.Logger;


public class ApplicantUIDef extends BaseClass {
    static final Logger logger = Logger.getLogger (ApplicantUIDef.class.getName ( ));
    private AmazonApplicant ui = null;
    private WebDriver driver = null;
    final static SeleniumBaseClass seleniumBaseClass = new SeleniumBaseClass(null);

    @Before
    public void before(Scenario scenario) throws IOException {
        testObject = TestObject.createWith(scenario);
    }

    @After
    public void after(Scenario scenario) throws Exception {
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

    public AmazonApplicant getApplicantUIPageObject() throws Exception {
        driver = seleniumBaseClass.setBrowserFromProperty (driver);
        ui = PageFactory.initElements (driver, AmazonApplicant.class);
        ui.setTestObject(testObject);
        return ui;
    }


    @Given("I navigate to the applicant welcome screen")
    public void  iNavigateToTheApplicantWelcomeScreen() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.launcherURL(amazonApplicant.getInviteURL());
    }

    @Then("I verify the Get Started button exists on the Welcome Screen")
    public void iVerifyTheGetStartedButtonExistsOnTheWelcomeScreen() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean result = amazonApplicant.exists(amazonApplicant.getStartedButton);
        report(result + " Get Started button Found?");
        Assert.assertTrue(result, "Get Started Button was not found.");
    }

    @And("I verify the phone number is correct on the Phone Number Screen")
    public void iVerifyThePhoneNumberIsCorrectOnThePhoneNumberScreen() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertEquals(amazonApplicant.getApplicantPhoneNumberValue(), "770-987-6543", "Expected Phone Number was not found on the Phone Number Screen.");
    }

    @And("I enter the consenting signature for the drug screen")
    public void iEnterTheConsentingSignatureForTheDrugScreen() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.signSignaturePad();
    }
    @And("I enter the consenting signature for NC Disclosure screen")
    public void iEntertheConsentingSignatureForNCdisclosureScreen() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.signSignaturePad2();
    }

    @And("I verify the address details on the Phone Number Screen")
    public void iVerifyTheAddressDetailsOnThePhoneNumberScreen() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.verifyAddressDetails();
    }

    @And("I enter the Applicant Last Name {string}, Birthday {string}, and booth number {string}")
    public void iEnterTheApplicantLastNameBirthdayAndBoothNumber(String lastName, String birthday, String boothNumber) throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.manualEntryApplicantInfo(lastName, birthday);
    }

    @And("I click the clear button")
    public void iClickTheClearButton() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickClearButton();
    }

    @And("I click the back button")
    public void iClickTheBackButton() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickBackButton();
    }


    @And("I verify the openPouch video exists")
    public void iVerifyTheOpenPouchVideoExists() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Thread.sleep(2000);
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.openPouchVideo), "Open Pouch video was not found as expected.");
    }


    @And("I verify the saliva image is present")
    public void iVerifyTheSalivaImageIsPresent() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.salivaScreen), "Saliva image was not found on the Sample collection screen.");
        Thread.sleep(4000);
    }

    @And("I click the button: {string}")
    public void iClickTheButton(String buttonText) throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickApplicantButton(buttonText);
    }

    @And("I wait for the photo results to be sent")
    public void iWaitForThePhotoResultsToBeSent() throws Exception{
        Thread.sleep(35000);
    }

    @And("I click on the get started button within the email invitation")
    public void iClickOnTheGetStartedButtonWithinTheEmailInvitation() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickEmailGetStarted();
    }

    @And("I verify the indicator image appears")
    public void iVerifyTheIndicatorImageAppears() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.indicatorImage), "Indicator image was not found on step 2.");
        Thread.sleep(2000);
    }

    @And("I click the indicator is red button")
    public void iClickTheIndicatorIsRedButton() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickIndicatorRedButton();
    }

    @And("I verify the Insert Swab image appears")
    public void iVerifyTheInsertSwabImageAppears() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Thread.sleep(1000);
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.insertSwabDeviceImage), "Insert swab into the device image was not found on step 2.");
    }

    @And("I click the Next button")
    public void iClickTheNextButton() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickNextButton();
    }

    @And("I click the I see the results button")
    public void iClickTheISeeTheResultsButton() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.waitForSeconds(2);
        amazonApplicant.clickISeeTheResultsButton();
    }

    @And("I click the button: I'm ready to take a photo")
    public void iClickTheButtonIMReadyToTakeAPhoto() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.waitForSeconds(2);
        amazonApplicant.clickReadyForPhotoButton();
    }

    @And("I take the photo on the camera")
    public void iTakeThePhotoOnTheCamera() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.takePhotoOnCamera();
    }

    @And("I wait for image to load")
    public void iWaitForImageToLoad() throws Exception{
        Thread.sleep(45000);
    }

    @Then("I can verify the Applicant Review Information screen appears")
    public void iCanVerifyTheApplicantReviewInformationScreenAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.reviewYourInformationScreen), "Review Your Information screen was not found as expected.");
    }

    @Then("I can verify the Grab test kit and open pouch screen appears")
    public void iCanVerifyTheGrabTestKitAndOpenPouchScreenAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.openPouchImage), "Open Pouch Screen was not found as expected.");
    }

    @Then("I can verify the Consenting Electronic Signature screen appears")
    public void iCanVerifyTheConsentingElectronicSignatureScreenAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.consentToUseSignatureScreen), "'Consent to Use Electronic Signature' screen was not found as expected.");
    }

    @And("I can verify the Sample Collection screen appears")
    public void iCanVerifyTheSampleCollectionScreenAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.collectSampleScreen), "'Collect the Sample' screen was not found as expected.");
    }

    @And("I can verify the swabbing results wait screen appears")
    public void iCanVerifyTheSwabbingResultsWaitScreenAppears() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Thread.sleep(2000);
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.swabResultsWaitImage), "'Wait' screen for swabbing result was not found as expected.");
    }

    @And("I verify the photo rules screen appears")
    public void iVerifyThePhotoRulesScreenAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.photoRulesScreen), "'Photo rules' screen was not found as expected.");
    }

    @Then("I verify the Applicant Review your Photo screen appears")
    public void iVerifyTheApplicantReviewYourPhotoScreenAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.reviewYourPhotoScreen), "'Review your Photo' screen was not found as expected.");
    }

    @And("I enter the consenting Virtual Donor signature for the drug screen")
    public void iEnterTheConsentingVirtualDonorSignatureForTheDrugScreen() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.signSignaturePad();
    }

    @And("I click the get started button on the Get Started screen")
    public void iClickTheGetStartedButtonOnTheGetStartedScreen() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickGetStarted();
    }

    @And("I verify the Virtual Donor screen appears")
    public void iVerifyTheVirtualDonorScreenAppears() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.setTestObject(testObject);
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.virtualDonorScreen), "Virtual Donor Consent Screen did not appear as expected.");
    }

    @And("I wait for {int} seconds")
    public void iWaitForSeconds(int secondsValue) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.waitForSeconds(secondsValue);
    }

    @And("I verify the Take Photo screen is available")
    public void iVerifyTheTakePhotoScreenIsAvailable() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.takePhotoButton), "Take Photo screen/button was not found.");
    }

    @And("I click the Retake Photo button")
    public void iClickTheRetakePhotoButton() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickRetakePhotoButton();
    }

    @And("I verify the sit tight review message appears")
    public void iVerifyTheSitTightReviewMessageAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.waitSentTestMessage), "The 'Sit Tight... results screen was not found as expected.");
    }

    @And("I verify the Clean your station screen appears")
    public void iVerifyTheCleanYourStationScreenAppears() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.cleanYourStationScreen), "Clean Your Station screen was not found as expected.");
    }

    @When("I click the Get Help icon")
    public void iClickTheGetHelpIcon() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickHelpIcon();
    }

    @And("I click the button: Found My Answer")
    public void iClickTheButtonFoundMyAnswer() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickFoundAnswerButton();
    }


    @When("I click the update phone or email button on the Applicant Review Information screen")
    public void iClickTheUpdatePhoneOrEmailButtonOnTheApplicantReviewInformationScreen() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickUpdatePhoneOrEmailButton();
    }

    @And("I click the Cancel button")
    public void iClickTheCancelButton() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickCancelButton();
    }

    @Then("I can enter the new phone number {string} on the Review your Information Screen")
    public void iCanEnterTheNewPhoneNumberOnTheEditPhoneNumberScreen(String newPhoneNumber) throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterPhoneNumber(newPhoneNumber);
    }

    @Then("I can verify the phone number is editable")
    public void iCanVerifyThePhoneNumberIsEditable() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean result = amazonApplicant.exists(amazonApplicant.editPhoneNumberTextBox);
        report("'Edit Phone Number textbox found? " + result);
        Assert.assertTrue(result, "Edit Phone Number textbox was not found.");
    }

    @And("I enter the lot expiration information for year {string}, month {string}, and day {string}")
    public void iEnterTheLotExpirationInformationForYearMonthAndDay(String year, String month, String day) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterLotExpirationInformation(year, month, day);
    }

    @And("I enter the lot number {string} on the Lot number screen")
    public void iEnterTheLotNumberOnTheLotNumberScreen(String lotNumber) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterLotNumberInformation(lotNumber, false);
        report(Status.PASS, "Lot Information was entered.");
    }

    @And("I enter the sample ID {string} on the Enter ID screen")
    public void iEnterTheSampleIDOnTheEnterIDScreen(String sampleId) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterSampleInformation(sampleId, false);
        report(Status.PASS, "Sample Information was entered.");
    }

    @And("I verify the Sample ID screen appears")
    public void iVerifyTheSampleIDScreenAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.waitForSeconds(2);
        boolean result = amazonApplicant.exists(amazonApplicant.sampleIdImageOrScreen);
        report("Sample ID screen found? " + result);
        Assert.assertTrue(result, "Sample ID screen was not found.");
    }

    @And("I click the button: Enter the specimen ID")
    public void iClickTheButtonEnterTheSpecimenID() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickSpecimenIDButton();
        report(Status.PASS, "Specimen ID button clicked.");
    }

    @And("I verify the Lot Information screen appears")
    public void iVerifyTheLotInformationScreenAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean result = amazonApplicant.exists(amazonApplicant.pouchLotInfoImage);
        report("Pouch lot information found? " + result);
        Assert.assertTrue(result, "The Pouch's Lot information was not found.");
    }

    @And("I enter the Applicant information and booth number {string}")
    public void iEnterTheApplicantInformationAndBoothNumber(String boothNumber) throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterApplicantInfo(boothNumber, null, false);
    }

    @And("I enter the Applicant information and a booth number  1 through 99")
    public void iEnterTheApplicantInformationAndaBoothNumber1Through99() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterApplicantInfo(amazonApplicant.randomBoothNumber(), null, false);
    }



    @And("I verify the screen appears: Please wait while we review your results")
    public void iVerifyTheScreenAppearsPleaseWaitWhileWeReviewYourResults() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.waitForSeconds(2);
        boolean result = amazonApplicant.exists(amazonApplicant.waitWhileWeReviewTestScreen);
        report("'Wait while we review your Results' screen appear? " + result);
        Assert.assertTrue(result, "Please wait while we review your Results screen did not appear as expected.");
    }

    @And("I cancel the screen for taking a photo")
    public void iCancelTheScreenForTakingAPhoto() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertFalse(amazonApplicant.exists(amazonApplicant.readyForPhotoButton), "ready for photo button found. Previous" +
                "screen is still present");
        amazonApplicant.clickCancelPhotoButton();
    }

    @And("I verify the Upload Photo screen is available")
    public void iVerifyTheUploadPhotoScreenIsAvailable() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean result = amazonApplicant.exists(amazonApplicant.uploadPhotoScreen);
        report("Upload Photo Screen appeared?: " + result);
        Assert.assertTrue(result, "Upload Photo screen did not appear as expected.");
    }

    @And("I upload the photo of the drugscreen results")
    public void iUploadThePhotoOfTheDrugscreenResults() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.waitForSeconds(1);
        amazonApplicant.uploadPhoto("/src/test/resources/testvideos/Agoodvideo.mjpeg");
    }

    @And("I verify the Request Help button exists on the Help Screen")
    public void iVerifyTheRequestHelpButtonExistsOnTheHelpScreen() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean results = amazonApplicant.exists(amazonApplicant.requestHelpButton);
        report("Request Help button found? " + results);
        Assert.assertTrue(results, "Request Help button was not found as expected.");
    }

    @And("I verify the photo is uploaded")
    public void iVerifyThePhotoIsUploaded() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean results = amazonApplicant.exists(amazonApplicant.uploadedPhoto);
        report("Photo Uploaded Successfully? " + results);
        Assert.assertTrue(results, "Photo did not successfully upload.");

    }

    @And("I verify the Package Your Test for Shipping screen is available")
    public void iVerifyThePackageYourTestForShippingScreenIsAvailable() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean results = amazonApplicant.exists(amazonApplicant.packageForShippingScreen);
        report("Package Results for Shipping screen appear? " + results);
        Assert.assertTrue(results, "Package Results for Shipping screen did not appear as expected.");
    }

    @And("I click the button: All Done - have a good day!")
    public void iClickTheButtonAllDoneHaveAGoodDay() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickAllDoneButton();
    }

    @And("I verify the Thank You screen appears")
    public void iVerifyTheThankYouScreenAppears() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean results = amazonApplicant.exists(amazonApplicant.thankYouScreen);
        report("Thank You screen appeared? " + results);
        Assert.assertTrue(results, "'Thank You' screen did not appear as expected.");
    }

    @Then("I verify retake Test screen appears")
    public void iVerifyRetakeTestScreenAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean results = amazonApplicant.exists(amazonApplicant.startOverScreen);
        report("Start Over/Retake Test Screen appear? " + results);
        Assert.assertTrue(results, "'Start Over/Retake Test' screen did not appear as expected.");
    }

    @Then("I verify the ReTake Photo screen is available")
    public void iVerifyTheReTakePhotoScreenIsAvailable() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean results = amazonApplicant.exists(amazonApplicant.photoRulesScreen);
        report("Photo Rules Screen appear? " + results);
        Assert.assertTrue(results, "'Photo Rules' screen did not appear as expected.");
    }

    @Then("I can verify the error message appears for non-matching last name or birthday")
    public void iCanVerifyTheErrorMessageAppearsForNonMatchingLastNameOrBirthday() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean results = amazonApplicant.exists(amazonApplicant.errorDobLnameMissing);
        report("Non-Matching birthday or last name error message appeared? " + results);
        Assert.assertTrue(results, "Non-Matching birthday or last name error message did not appear as expected.");
    }

    @And("I enter the sample ID {string} to trigger the error message")
    public void iEnterTheSampleIDToTriggerTheErrorMessage(String sampleInfo) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterNonMatchingSampleInformation(sampleInfo);
    }

    @Then("I can verify the error message appears for non-matching sample information")
    public void iCanVerifyTheErrorMessageAppearsForNonMatchingSampleInformation() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean results = amazonApplicant.exists(amazonApplicant.errorSampleLotMissing);
        report("Non-Matching Sample information error message appeared? " + results);
        Assert.assertTrue(results, "Non-Matching Sample information error message did not appear as expected.");
    }

    @And("I enter the lot number {string} to trigger the error message")
    public void iEnterTheLotNumberToTriggerTheErrorMessage(String lotInfo) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterNonMatchingLotNumberInformation(lotInfo);
    }

    @And("I can verify the error message appears for the non-matching lot information")
    public void iCanVerifyTheErrorMessageAppearsForTheNonMatchingLotInformation() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean results = amazonApplicant.exists(amazonApplicant.errorSampleLotMissing);
        report("Non-Matching Lot information error message appeared? " + results);
        Assert.assertTrue(results, "Non-Matching Lot information error message did not appear as expected.");
    }

    @And("I correctly enter the sample ID {string} on the Enter ID screen")
    public void iCorrectlyEnterTheSampleIDOnTheEnterIDScreen(String sampleId) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterSampleInformation(sampleId, true);
    }

    @And("I close the current browser")
    public void iCloseTheCurrentBrowser() throws Exception{
        SeleniumBaseClass seleniumBaseClass = getApplicantUIPageObject();
        seleniumBaseClass.closeBrowser();
    }

    @And("I can verify the message appears for candidates that have already taken the test")
    public void iCanVerifyTheMessageAppearsForCandidatesThatHaveAlreadyTakenTheTest() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean results = amazonApplicant.exists(amazonApplicant.alreadyCompletedMessage);
        report("'Test already Completed' message appeared? " + results);
        Assert.assertTrue(results, "The 'Test Already Completed' message did not appear as expected.");
    }

    @And("I close the current browser tab")
    public void iCloseTheCurrentBrowserTab() throws Exception {
        SeleniumBaseClass seleniumBaseClass = getApplicantUIPageObject();
        seleniumBaseClass.closeCurrentTab();
    }

    @And("I upload the photo of the barcode label for shipping")
    public void iUploadThePhotoOfTheBarcodeLabelForShipping() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.uploadPhoto("/src/test/resources/testvideos/OralToxwithEzeLabel.jpg");
    }

    @And("I upload the photo of bad barcode label for shipping")
    public void iUploadThePhotoOfBadBarcodeLabelForShipping() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.uploadPhoto("/src/test/resources/testvideos/pic2.jpg");
    }

    @Then("I can verify the Oral-Eze Open Pouch screen appears")
    public void iCanVerifyTheOralEzeOpenPouchScreenAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean results = amazonApplicant.exists(amazonApplicant.oEzeOpenPouchScreen);
        report("Oral-Eze Open Pouch Screen appeared? " + results);
        Assert.assertTrue(results, "The Oral-Eze Open Pouch screen did not appear as expected.");

    }

    @And("I verify the Oral-Eze Sample Collection Instructions Screen Part One appears")
    public void iVerifyTheOralEzeSampleCollectionInstructionsScreenPartOneAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean results = amazonApplicant.exists(amazonApplicant.oEzeSampleCollect1Screen);
        report("Oral-Eze Sample Collection Information Part 1 Screen appeared? " + results);
        Assert.assertTrue(results, "The Oral-Eze Sample Collection Information Part 1 Screen did not appear as expected.");
    }

    @Then("I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears")
    public void iVerifyTheOralEzeSampleCollectionInstructionsScreenPartTwoAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean results = amazonApplicant.exists(amazonApplicant.oEzeSampleCollect2Screen);
        report("Oral-Eze Sample Collection Information Part 2 Screen appeared? " + results);
        Assert.assertTrue(results, "The Oral-Eze Sample Collection Information Part 2 Screen did not appear as expected.");
    }

    @When("I click indicator is blue button")
    public void iClickIndicatorIsBlueButton() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickIndicatorBlueButton();
    }

    @And("I verify the Oal-Eze Close the Cap Screen appears")
    public void iVerifyTheOalEzeCloseTheCapScreenAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean results = amazonApplicant.exists(amazonApplicant.oEzeCloseCapScreen);
        report("Oral-Eze Close the Cap Screen appeared? " + results);
        Assert.assertTrue(results, "The Oral-Eze Close the Cap Screen did not appear as expected.");
    }

    @And("I enter the barcode label ID {string} to trigger the error message")
    public void iEnterTheBarcodeLabelIDToTriggerTheErrorMessage(String barcodeId) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterNonMatchingBarcodeInformation(barcodeId);
    }

    @And("I correctly enter the barcode ID {string} on the barcode Sample Screen")
    public void iCorrectlyEnterTheBarcodeIDOnTheBarcodeSampleScreen(String barcodeId) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterBarcodeLabelInformation(barcodeId, true);
    }

    @And("I verify the Barcode ID screen appears")
    public void iVerifyTheBarcodeIDScreenAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean result = amazonApplicant.exists(amazonApplicant.barcodeInformationScreen);
        report("Barcode ID screen found? " + result);
        Assert.assertTrue(result, "Barcode ID screen was not found.");
    }

    @And("I enter the barcode label ID {string} on the barcode Information Screen")
    public void iEnterTheBarcodeLabelIDOnTheBarcodeInformationScreen(String barcodeId) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterBarcodeLabelInformation(barcodeId, false);
    }

    @And("I enter the Applicant information without booth information")
    public void iEnterTheApplicantInformationWithoutBoothInformation() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterApplicantInfo(null, null, false);
    }

    @Then("I can verify the help content screen appears with content text {string}")
    public void iCanVerifyTheHelpContentScreenAppearsWithContentText(String content) throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.foundMyAnswerButton), "Help Content Screen/Answer Button was not found.");
        Assert.assertTrue(amazonApplicant.helpContentExists(content), "Expected Help text was not found: " + content);
    }

    @And("I can verify the help content screen appears with additional content text {string}")
    public void iCanVerifyTheHelpContentScreenAppearsWithAdditionalContentText(String content) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.helpContentExists(content), "Expected Help text was not found: " + content);
    }

    @And("I can verify the booth field is not showing")
    public void iCanVerifyTheBoothFieldIsNotShowing() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(!amazonApplicant.boothFieldExists(), "Expected Booth number not showing ");
    }

    @And("I verify the Oval-Eze Seal device Screen appears")
    public void iVerifyTheOvalEzeSealDeviceScreenAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean results = amazonApplicant.exists(amazonApplicant.oEzeSealDeviceScreen);
        report("Oral-Eze Seal Device / Package your test kit for shipping Screen appeared? " + results);
        Assert.assertTrue(results, "The Oral-Eze Seal Device Screen did not appear as expected.");
    }

    @And("I verify the photo size width {int} height {int}")
    public void iVerifyThePhotoSizeWidthHeight(int width, int height){
        By image = By.id("uploadOutput");
        WebElement element = driver.findElement(image);

        String naturalHeight = element.getAttribute("naturalHeight");
        String naturalWidth = element.getAttribute("naturalWidth");

        boolean results = false;
        results = Integer.parseInt(naturalHeight) == height;
        report("Photo height [" + naturalHeight + "] equals to expected " + height + " ? " + results);
        Assert.assertTrue(results, "Photo height [" + naturalHeight + "] is not equals to expected " + height + " ? " + results);

        results = Integer.parseInt(naturalWidth) == width;
        report("Photo width [" + naturalWidth + "] equals to expected " + width + " ? " + results);
        Assert.assertTrue(results, "Photo width [" + naturalWidth + "] is not equals to expected " + width + " ? " + results);
    }

    @And("I upload the big photo of the drugscreen results")
    public void iUploadTheBigPhotoOfTheDrugscreenResults() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.uploadPhoto("/src/test/resources/testvideos/Barcode_14MB.png");
    }

    @And("I verify the Barcode Seal and Shipping screen is available")
    public void iVerifyTheBarcodeSealAndShippingScreenIsAvailable() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean results = amazonApplicant.exists(amazonApplicant.barcodeShippingScreen);
        report("Oral-Eze Barcode Shipping Screen appeared? " + results);
        Assert.assertTrue(results, "The Oral-Eze Barcode Shipping Screen did not appear as expected.");
    }

    @And("I upload the photo of the OralEze barcode label for shipping")
    public void iUploadThePhotoOfTheOralEzeBarcodeLabelForShipping() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.uploadPhoto("/src/test/resources/testvideos/oralEzebarcode.jpg");
    }

    @And("I upload a bad photo")
    public void iUploadABadPhoto() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.uploadPhoto("/src/test/resources/testvideos/otoxqrAndbarcode.mjpeg");
    }

    @And("I verify the Applicant Review your Uploaded Photo screen appears")
    public void iVerifyTheApplicantReviewYourUploadedPhotoScreenAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.reviewYourUploadedPhotoScreen), "'Review your Uploaded Photo' screen was not found as expected.");

    }

    @And("I verify the donor initial's photo rules screen appears")
    public void iVerifyTheDonorInitialSPhotoRulesScreenAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.dInitialsPhotoRulesScreen), "'Donor's Initials Photo Rules' screen was not found as expected.");
    }

    @And("I verify the photo rules Specimen ID text appears")
    public void iVerifyThePhotoRulesSpecimenIDTextAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.photoRulesText), "Photo Rules text did not appear as expected.");
    }

    @And("I click the Cap is Sealed Tight button")
    public void iClickTheCapIsSealedTightButton() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickCapIsSealedButton();
    }

    @And("I click the I don't see any results button")
    public void iClickTheIDonTSeeAnyResultsButton() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickIDontSeeTheResultsButton();
    }

    @And("I click the button: I see the Results Help button")
    public void iClickTheButtonISeeTheResultsHelpButton() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickSeeResultHelpButton();
    }
    @And("I certify that the button is present with value {string}")
    public void ICertifyThatTheCapIsSealedTightlyButtonIsPresent(String message) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.isTheCapIsSealedTightlyButtonPresent(message));
    }

    @And("I click the Cap is Sealed Tightly button")
    public void iClickTheCapIsSealedTightlyButton() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickCapIsSealedButton();
    }
    @And("I upload the photo of the device photo")
    public void iUploadThePhotoOfTheDevicePhoto() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.waitForSeconds(2);
        amazonApplicant.uploadCandidateFile("/src/test/resources/testvideos/ValidQRCode.PNG");
    }
    @Then("I can verify the invalid device message displays")
    public void iCanVerifyTheInvalidDeviceMessageDisplays() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.invalidDevice), "Invalid Device message did not display as expected.");
    }

    @Then("I can verify that I see the message displays for maximum characters allowed")
    public void iCanVerifyThatISeeTheMessageDisplaysForMaximumCharactersAllowed() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.specimenIDLengthMessage), "Maximum digits allowed error was not found as expected.");
    }

    @And("I click the speech play button on the start screen")
    public void iClickTheSpeechPlayButtonOnTheStartScreen() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
         amazonApplicant.clickSpeechPlayButton();
    }

    @Then("I validate the audio is present on the {string} screen")
    public void iValidateTheAudioIsPresentOnTheScreen(String screenText) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.audioOnScreen), "Audio was not found on the " + screenText + " screen.");
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.audioReplayButton), "Audio replay button was not on the " + screenText + " screen.");
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.unmuteVolumeButton), "Audio Unmute button was not on the " + screenText + " screen.");
    }

    @And("I click to unmute the the audio on the screen")
    public void iClickToUnmuteTheTheAudioOnTheScreen() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickUnmuteVolumeButton();
    }

    @And("I validate the mute icon is available again")
    public void iValidateTheMuteIconIsAvailableAgain() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.muteVolumeButton), "Mute button was not found on the screen as expected.");
    }

    @And("I click to mute the audio on the screen")
    public void iClickToMuteTheAudioOnTheScreen() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickMuteVolumeButton();
    }

    @And("I validate the unmute icon is available")
    public void iValidateTheUnmuteIconIsAvailable() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.unmuteVolumeButton), "Unmute Button was not found as expected.");
    }

    @Then("I can verify the expired device message displays")
    public void iCanVerifyTheExpiredDeviceMessageDisplays() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.expiredDevice), "Expired Device message did not display as expected.");
    }

    @Then("I can verify the duplicate device message displays")
    public void iCanVerifyTheDuplicateDeviceMessageDisplays() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.duplicateDevice), "Duplicate Device message did not display as expected.");

    }

    @And("I click the Cancel Request button on the device message")
    public void iClickTheCancelRequestButtonOnTheDeviceMessage() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickCancelRequestButton();
    }

    @And("I click the indicator is not red button")
    public void iClickTheIndicatorIsNotRedButton() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickIndicatorNotRedButton();
    }

    @And("I verify the photo shutter is green")
    public void iVerifyThePhotoShutterIsGreen() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.greenPhotoShutterButton), "The green shutter button was not found when taking a photo.");
    }

    @And("I upload a drug screening photo for image checking")
    public void iUploadADrugScreeningPhotoForImageChecking() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.uploadPhoto("/src/test/resources/testvideos/goodIphonePhoto.jpg");

    }

    @And("I upload a photo of COC form")
    public void iUploadAPhotoOfCOCForm() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.uploadPhoto("/src/test/resources/testvideos/CoC.jpg");
    }

    @And("I enter the Applicant information with the correct social security digits and without booth information")
    public void iEnterTheApplicantInformationWithTheCorrectSocialSecurityDigitsAndWithoutBoothInformation() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterApplicantInfo(null, null, false);
    }

    @Then("I can verify the social security number text field is present")
    public void iCanVerifyTheSocialSecurityNumberTextFieldIsPresent() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.applicantSsNumber), "Social Security Number field was not found as expected.");
    }


    @And("I enter the Applicant information with the incorrect social security digits {string} and without booth information")
    public void iEnterTheApplicantInformationWithTheIncorrectSocialSecurityDigitsAndWithoutBoothInformation(String ssn) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterApplicantInfo(null, ssn, false);
    }

    @Then("I can verify the error message appears for non-matching last name or birthday or social security number")
    public void iCanVerifyTheErrorMessageAppearsForNonMatchingLastNameOrBirthdayOrSocialSecurityNumber() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean results = amazonApplicant.exists(amazonApplicant.errorDobLnameSsnMissing);
        report("Non-Matching birthday, last name, or social security number error message appeared? " + results);
        Assert.assertTrue(results, "Non-Matching birthday, last name, or social security number error message did not appear as expected.");
    }

    @Given("I launch the PBT user qrcode and barcode reader")
    public void iLaunchThePBTUserQrcodeAndBarcodeReader() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.launchPBTBarcodeReader();
    }

    @And("click the start scan button on the PBT barcode reader")
    public void clickTheStartScanButtonOnThePBTBarcodeReader() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickPBTStartScanButton();
    }

    @And("I can verify the barcode {string} is successfully read from the PBT scan")
    public void iCanVerifyTheBarcodeIsSuccessfullyReadFromThePBTScan(String barcode) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(amazonApplicant.barcodeExists(barcode), "Barcode was not successfully found.");
    }

    @Then("I can verify the qr code {string} is successfully read from the PBT scan")
    public void iCanVerifyTheQrCodeIsSuccessfullyReadFromThePBTScan(String qrcode) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(amazonApplicant.qrcodeExists(qrcode), "QR code was not successfully found.");
    }

    @When("I wait for {int} seconds to allow the barcode and qrcode reader to scan")
    public void iWaitForSecondsToAllowTheBarcodeAndQrcodeReaderToScan(int secondsValue) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.waitForSeconds(secondsValue);
    }

    @And("I navigate to the applicant welcome screen after retrieving newly create order via UI")
    public void iNavigateToTheApplicantWelcomeScreenAfterRetrievingNewlyCreateOrderViaUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
//       amazonApplicant.applicantUILink;

//        report(Status.INFO, relaunchURL);
        amazonApplicant.launcherURL(amazonApplicant.getInviteUIUrl("Amazon"));
    }

    @And("I enter the Applicant information retrieved from EA UI and set booth number to {string}")
    public void iEnterTheApplicantInformationRetrievedFromEAUIAndSetBoothNumberTo(String boothNumber) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterApplicantInfoRetrievedFromEAUi(boothNumber);
    }

    @Given("I launch the Sorting UI user qrcode and barcode reader")
    public void iLaunchTheSortingUIUserQrcodeAndBarcodeReader() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.launchSortingUIReader();
    }

    @And("click the start scan button on the Sorting UI qrcode reader")
    public void clickTheStartScanButtonOnTheSortingUIQrcodeReader() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickSortingUIStartScanButton();
    }

    @Then("I can verify the sorting UI qr code result is {string}")
    public void iCanVerifyTheSortingUIQrCodeResultIs(String readerResult) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(amazonApplicant.sortingUiQrCodeExists(readerResult), "Sorting UI result of 'Negative' was not successfully found when expected.");
    }

    @And("I enter last four digits of social security number {string}")
    public void iEnterLastFourDigitsOfSocialSecurityNumber(String SSNlast4) throws Exception {
        AmazonApplicant amazonApplicant=getApplicantUIPageObject();
        amazonApplicant.enterSSNnumber (SSNlast4);
    }

    @And("I enter the Applicant information retrieved from EA UI without SSN and set booth number to {string}")
    public void iEnterTheApplicantInformationRetrievedFromEAUIWithoutSSNAndSetBoothNumberTo(String BoothNumber) throws Exception {
        AmazonApplicant amazonApplicant=getApplicantUIPageObject();
        amazonApplicant.enterApplicantInfoRetrievedFromEAUiNoSSN (BoothNumber);
    }

    /*
    try ssn null as well
     */
    @And("I enter the Applicant information with social security digits {string} and booth number {string}")
    public void iEnterTheApplicantInformationWithSocialSecurityDigitsAndBoothNumber(String ssn, String boothNumber) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject ( );
        amazonApplicant.enterApplicantInfo ( boothNumber,ssn,false);
    }

    @And("I can verify the sorting UI qr code result message is {string}")
    public void iCanVerifyTheSortingUIQrCodeResultMessageIs(String expectedMessage) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.sortingUIMessageExists(expectedMessage), "Expected message was not found.");
    }

    @When("I enter the Applicant information with no social security number and without booth information")
    public void iEnterTheApplicantInformationWithNoSocialSecurityNumberAndWithoutBoothInformation() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterApplicantInfo(null, "invalid", false);
    }

    @Then("I can verify the message appears for missing fields on the applicant UI welcome screen")
    public void iCanVerifyTheMessageAppearsForMissingFieldsOnTheApplicantUIWelcomeScreen() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.missingFieldsLabel), "Missing field message did not appear as expected.");
    }

    @And("I upload the clear discrepancy photo of the drugscreen results")
    public void iUploadTheClearDiscrepancyPhotoOfTheDrugscreenResults() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.uploadPhoto("/src/test/resources/testvideos/clearDiscrepancy.png");
    }

    @When("I navigate back to the applicant welcome screen in the same session")
    public void iNavigateBackToTheApplicantWelcomeScreenInTheSameSession() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.launcherURL(amazonApplicant.getCreateOrderWrapper().getApplicantUIRelaunchLink());
    }

    @And("I navigate to applicant UI screen using the alias")
    public void iNavigateToApplicantUIScreenUsingTheAlias() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.launcherURL(Environment.getEnvironmentBaseUrl() + "/?location=" + Environment.getEnvironmentLocationAlias());
    }

    @And("I enter the Applicant information and re-launch")
    public void iEnterTheApplicantInformationAndReLaunch() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterApplicantInfo(null, null, true);
    }

    @And("I navigate to applicant UI screen using the alias {string} for orders created via Admin UI")
    public void iNavigateToApplicantUIScreenUsingTheAliasForOrdersCreatedViaAdminUI(String alias) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.launcherURL(Environment.getEnvironmentBaseUrl() + "/?location=" + alias);
    }

    @And("I navigate to Non-Preemployment applicant UI screen using the alias {string} for orders created via Admin UI")
    public void iNavigateToNonPreemploymentApplicantUIScreenUsingTheAliasForOrdersCreatedViaAdminUI(String aliasIn) throws Exception {
        String alias = Util.getNonAdjLocationAliasBasedOnEnvironment(aliasIn);
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.launcherURL(Environment.getEnvironmentBaseUrl() + "/?NONPRE&location=" + alias);
    }

    @And("I enter the Applicant information retrieved from the Admin UI order")
    public void iEnterTheApplicantInformationRetrievedFromTheAdminUIOrder() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterAdminUIGenerateApplicantInformation();
    }
    @And("I enter the Applicant information retrieved from the Admin UI order and  without booth number")
    public void iEnterTheApplicantInformationRetrievedFromTheAdminUIOrderAndWithoutBoothNumber() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterAdminUIGenerateApplicantInfoNoBoothNmbr ();

    }

    @Then("I can verify that the consent form is changed for the other reasons for test")
    public void iCanVerifyThatTheConsentFormIsChangedForTheOtherReasonsForTest() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.verifyConsentForOthers();
    }
    @Then("I can verify that the consent form is default for pre-employment reason for test")
    public void iCanVerifyThatTheConsentFormIsDefaultForPreEmploymentReasonForTest() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.verifyPreEmpConsent();
    }
    @Then("I verify that booth number validation error message is given in the Applicant UI Enter Booth Number Page")
    public void iVerifyThatBoothNumberValidationErrorMessageIsGivenInTheApplicantUIEnterBoothNumberPage() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.verifyInvalidBoothNum();
    }

    @And("I clear the booth number field in the Applicant UI Enter Booth Number Page")
    public void iClearTheBoothNumberFieldInTheApplicantUIEnterBoothNumberPage() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clearBoothNumber();
    }
    @And("I verify that booth number field is not on the Applicant UI Get Started Screen")
    public void iVerifyThatBoothNumberFieldIsNotOnTheApplicantUIGetStartedScreen() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.verifyBoothNumberFieldAbsent();
    }

    @And("^I enter the Applicant Last Name \"([^\"]*)\", Birthday \"([^\"]*)\", and SSN \"([^\"]*)\"$")
    public void i_enter_the_applicant_last_name_something_birthday_something_and_ssn_something(String lastName, String DoB, String ssn) throws Exception {
        AmazonApplicant amazonApplicant=getApplicantUIPageObject ();
        amazonApplicant.enterApplicantLnameDobSsn(lastName, DoB, ssn);
    }

    @Then("^I verify that the Applicant is navigated to Enter Booth Number Page$")
    public void i_verify_that_the_applicant_is_navigated_to_enter_booth_number_page() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue (amazonApplicant.exists (amazonApplicant.enterBoothNumberScreen),"Enter Booth Number screen is not found");

    }
    @And("^I enter the booth number \"([^\"]*)\" into get started screen in the Applicant UI$")
    public void i_enter_the_booth_number_something_into_get_started_screen_in_the_applicant_ui(String boothNumber) throws Exception {
        AmazonApplicant amazonApplicant=getApplicantUIPageObject ();
        amazonApplicant.enterBooth(boothNumber);
    }
    @And("I enter a random booth number 1 through 99 into get started screen in the Applicant")
    public void i_enter_the_booth_number_1_through_99_into_get_started_screen_in_the_applicant_ui() throws Exception {
        AmazonApplicant amazonApplicant=getApplicantUIPageObject ();
        amazonApplicant.enterBooth(amazonApplicant.randomBoothNumber ());
    }

    @And("^I can verify that no error message is thrown for booth number field in Applicant UI$")
    public void i_can_verify_that_no_error_message_is_thrown_for_booth_number_field_in_applicant_ui() throws Exception {
        AmazonApplicant amazonApplicant=getApplicantUIPageObject ();
        amazonApplicant.verifyNoBoothNumberError();
    }

    @And("^I enter booth number \"([^\"]*)\" into Enter Booth Number Page in Applicant UI$")
    public void i_enter_booth_number_something_into_enter_booth_number_page_in_applicant_ui(String boothNumber) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterBoothNumber(boothNumber);
    }

    @And("I click on I'm ready to take photo button in Applicant UI")
    public void iClickOnIMReadyToTakePhotoButtonInApplicantUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickElement (amazonApplicant.readyForPhotoButton);
    }
    @And("I verify that the candidate card does not have booth number")
    public void iVerifyThatTheCandidateCardDoesNotHaveBoothNumber() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.verifyBoothNumberAbsentOnTheCard();
    }

    @And("I verify the timer is less than or equal to {int} seconds")
    public void iVerifyTheTimerIsLessThanOrEqualToSeconds(int configuredTime) throws Exception {
        AmazonApplicant amazonApplicant=getApplicantUIPageObject ();
        amazonApplicant.isTimerLessorCorrect(configuredTime);
    }

    @And("I verify the timer is greater than or equal to {int} seconds")
    public void iVerifyTheTimerIsGreaterThanOrEqualToSeconds(int configuredTime) throws Exception {
        AmazonApplicant amazonApplicant=getApplicantUIPageObject ();
        amazonApplicant.isTimerGreaterCorrect(configuredTime);
    }

    @And("I click the button: I see the Red Indicator")
    public void iClickTheButtonISeeTheRedIndicator() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickISeeTheResultIndicatorButton();
    }

    @And("I enter the Applicant information retrieved from EA UI without SSN and booth number")
    public void iEnterTheApplicantInformationRetrievedFromEAUIWithoutSSNAndBoothNumber() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterApplicantInfoRetrievedFromEAUiNoSSN (null);
    }

    @And("I enter the Applicant Last Name with a Space at the beginning {string}, Birthday {string}, and SSN {string}")
    public void iEnterTheApplicantLastNameWithASpaceAtTheBeginningBirthdayAndSSN(String lastName, String DoB, String ssn) throws Exception {
        AmazonApplicant amazonApplicant=getApplicantUIPageObject ();
        amazonApplicant.enterApplicantLnameDobSsn(lastName, DoB, ssn);
    }

    @And("I can verify the email is editable")
    public void iCanVerifyTheEmailIsEditable() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean result = amazonApplicant.exists(amazonApplicant.editEmailTextBox);
        report("'Edit Email textbox found? " + result);
        Assert.assertTrue(result, "Edit Email textbox was not found.");

    }

    @And("I can enter the new email {string} on the Review your Information Screen")
    public void iCanEnterTheNewEmailOnTheReviewYourInformationScreen(String newEmail) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterEmail(newEmail);
    }

    @And("I can verify the error message for Phone Number edit is given in the Review your Information Screen")
    public void iCanVerifyTheErrorMessageForPhoneNumberEditIsGivenInTheReviewYourInformationScreen() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean result = amazonApplicant.exists(amazonApplicant.editPhoneErrorMsg);
        report("'Edit Phone Number error message found? " + result);
        Assert.assertTrue(result, "Edit Phone Number error message was not found.");
    }
    @And("I can verify the error message for Email edit is given in the Review your Information Screen")
    public void iCanVerifyTheErrorMessageForEmailEditIsGivenInTheReviewYourInformationScreen() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean result = amazonApplicant.exists(amazonApplicant.editEmailErrorMsg);
        report("'Edit Email error message found? " + result);
        Assert.assertTrue(result, "Edit Email error message was not found.");
    }

    @And("^I verify the text \"([^\"]*)\" in the Review your Information Page$")
    public void i_verify_the_text_something_in_the_review_your_information_page(String editText) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertEquals(amazonApplicant.reviewInfoEditTextAboveNextBtnWE.getText(),editText," Edit Text is not found" );
    }




    @And("I verify Please enter a valid Amazon alias message appears on the Get Started screen")
    public void iVerifyPleaseEnterAValidAmazonAliasMessageAppearsOnTheGetStartedScreen() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.applicantAliasError)," Please enter a valid Amazon alias message id not displayed ");
    }
    @And("I enter the Applicant Last Name {string}, Birthday {string}, and alias {string}")
    public void iEnterTheApplicantLastNameBirthdayAndAlias(String lastName, String doB, String alias) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterApplicantLnameDobAlias( lastName,doB, alias);

    }
    @And("I enter the alias {string} into the Get Started Screen in the Applicant UI")
    public void iEnterTheAliasIntoTheGetStartedScreenInTheApplicantUI(String alias) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterAlias(alias);
    }
    @And("^I verify All fields are required to get started message appears on the Get Started screen$")
    public void i_verify_all_fields_are_required_to_get_started_message_appears_on_the_get_started_screen() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.applicantAllFieldsError), " All Fields required message is not displayed");

    }
    @And("I enter Applicant information for non-preemployment order with Alias")
    public void iEnterApplicantInformationForNonPreemploymentOrderWithAlias() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterApplicantInfoWithAlias(false);
    }
    @And("I can verify the E-signature Consent screen appears on Applicant UI")
    public void iVerifyTheESignatureConsentScreenAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.eSignatureConsentScreen), "'E-Signature Consent' screen was not found as expected");
    }
    @And("I can verify that Decline button is available on Disclosure page for Applicant UI")
    public void iVerifyTheDeclineButtonExists() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean result = amazonApplicant.exists(amazonApplicant.declineButton);
        report(" Decline button Found? " + result);
        Assert.assertTrue(result, "Decline Button was not found.");
    }
    @And("I can verify that Agree button is available on Disclosure page for Applicant UI")
    public void iVerifyTheAgreeButtonExists() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean result = amazonApplicant.exists(amazonApplicant.agreeButton);
        report(" Agree button Found? " + result);
        Assert.assertTrue(result, "Agree Button was not found.");
    }
    @And("I click on Decline button on Disclosure page for Applicant UI")
    public void iClickOnDeclineButton() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickDeclineButton();
    }
    @And("I click on Agree button on Disclosure page for Applicant UI")
    public void iClickOnAgreeButton() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickAgreeButton();
    }
    @And("I can verify that a confirmation Popup appears on Disclosure page for Applicant UI")
    public void iVerifyTheConfirmationPopUpAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject ( );
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.confirmationPopUp),"The Confirmation Pop Up window is not found");
    }
    @And("I click on No, Back button on the Confirmation Popup on Disclosure page for Applicant UI")
    public void iClickOnNoBackButton() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickNoBackButton();
    }
    @And("I click on Yes, Decline button on the Confirmation Popup on Disclosure page for Applicant UI")
    public void iClickYesDeclineButton() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickYesDeclineButton();
    }
    @Then("I verify that I'm on the Applicant UI Welcome screen")
    public void iVerifyThatIamOnTheApplicantUIWelcomeScreen() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject ( );
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.welcomeScreen),"You are not on the Applicant UI Welcome screen");

    }
    @And("I can verify that Drug and Alcohol policy screen appears on Applicant UI")
    public void iVerifyTheDrugAndAlcoholPolicyScreenAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.drugAndAlcoholPolicyScreen), "'Drug and Alcohol policy' screen was not found as expected");
    }
    @And("I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI")
    public void iVerifyTheFCRADisclosureAndAuthorizationScreenAppears() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.fCRADisclosureANdAuthorizationScreen), "'FCRA Drud and Authorization' screen was not found as expected");
    }
    @Then("I verify that I am on the Additional Disclosures Screen in Applicant UI")
    public void iVerifyThatIAmOnTheAdditionalDisclosuresScreenInApplicantUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.additionalDisclosureScreen), "'Additional Disclosures & Acknowledgments' screen was not found as expected");

    }

    @And("I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen")
    public void iVerifyThatIamNavigatedToTheAcknowledgementsAuthorizationForDrugTestScreen() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.acknowledgeDrugTestScreen), "'Acknowledgements & Authorization for Drug Test' screen was not found as expected");
    }

    @And("I can verify that Back button is available on Disclosure page for Applicant UI")
    public void iVerifyTheBackButtonExists() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean result = amazonApplicant.exists(amazonApplicant.backButton);
        report(" Back button Found? " + result);
        Assert.assertTrue(result, "Back Button was not found.");
    }

    @And("I can verify that Next button is available on Disclosure page for Applicant UI")
    public void iVerifyTheNextButtonExists() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean result = amazonApplicant.exists(amazonApplicant.nextButton);
        report( " Next button Found? " + result);
        Assert.assertTrue(result, "Next Button was not found.");
    }

    @And("I can verify that Signature pad is available on Disclosure page for Applicant UI")
    public void iVerifyTheSignaturePadButtonExists() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        boolean result = amazonApplicant.exists(amazonApplicant.consentSignatureControl);
        report( " Signature pad button Found? " + result);
        Assert.assertTrue(result, "Signature pad Button was not found.");
    }


    @And("I verify that I am on CA Disclosure Screen of the Applicant UI")
    public void iVerifyThatIAmOnCADisclosureScreenOfTheApplicantUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.caDisclosureScreen), "CA Disclosure Screen was not found");

    }
    @And("I can verify that NC Disclosure Screen appears on the Applicant UI")
    public void iCanVerifyThatNCDisclosureScreenAppearsOnTheApplicantUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.ncDisclosureScreen), "NC Disclosure Screen was not found");
    }
    @And("I enter the sample ID {string} on the first field on Enter ID screen")
    public void iEnterTheSampleIDOnTheFirstFeildOnEnterIDScreen(String sampleId) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterSampleInformationOnFirstField(sampleId, false);
        report(Status.PASS, "Sample Information was entered.");
    }
    @And("I enter the sample ID {string} on the second field on Enter ID screen")
    public void iEnterTheSampleIDOnTheSecondFieldOnEnterIDScreen(String sampleId) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterSampleInformationOnSecondField(sampleId, false);
        report(Status.PASS, "Sample Information was entered.");
    }
    @And("^I can verify that all fields required error message is given on Enter ID page$")
    public void i_can_verify_that_all_fields_required_message_is_given() throws Exception {
        AmazonApplicant amazonApplicant=getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.applicantEnterIDPageAllFieldsErrorMsg),"All fields required error message is not given.");

    }
    @And("^I can verify that entries do not match error message is given on Enter ID page$")
    public void i_can_verify_that_entries_do_not_match_message_is_given() throws Exception {
        AmazonApplicant amazonApplicant=getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.enterSampleIDPageNotMatchingErrorMsg),"Entries do not match error message is not given.");

    }
    @And("^I can verify that format not correct error message is given on Enter ID page on Enter ID page$")
    public void i_can_verify_that_format_not_correct_message_is_given() throws Exception {
        AmazonApplicant amazonApplicant=getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.applicantFormatNotCorrectErrorMsg),"Format not correct error message is not given.");

    }
    @And("I upload the photo of the device with new sample ID format")
    public void iUploadThePhotoOfTheDeviceWithNewSampleIDFormat() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.waitForSeconds(2);
        amazonApplicant.uploadCandidateFile("/src/test/resources/testvideos/NewFormatQRCode.PNG");
    }


    @And("I can verify that Disclosures Page Back Button is available in the Applicant UI")
    public void iCanVerifyThatDisclosuresPageBackButtonIsAvailableInTheApplicantUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.disclosuresBackButton), "Disclosures Back Button was not found");
    }

    @And("I click the disclosures back button in the Applicant UI")
    public void iClickTheDisclosuresBackButtonInTheApplicantUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickDisclosureBackButton();

    }
    @And("I upload an expired device photo of the drugscreen results")
    public void iUploadAnExpiredDevicePhotoOfTheDrugscreenResults() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.waitForSeconds(1);
        amazonApplicant.uploadPhoto("/src/test/resources/testvideos/expiredOralTox.png");
    }

    @Then("I verify that I am on the Wait Screen in the Applicant UI")
    public void iVerifyThatIAmOnTheWaitScreenInTheApplicantUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.applicantWaitScreen),"Applicant UI Wait screen is not displayed");
    }

    @And("I click the Proceed to Alcohol Test button on the Wait Screen of Applicant UI")
    public void iClickTheProceedToAlcoholTestButtonOnTheWaitScreenOfApplicantUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickProceedAlcoholBtn();
    }

    @And("I verify that I am on the Alcohol Wait Screen of the Applicant UI")
    public void iVerifyThatIAmOnTheAlcoholWaitScreenOfTheApplicantUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.applicantAlcoholWaitScreen),"Alcohol Wait Screen is not found");
    }
    @And("I verify that I am on the Open the Alcohol Pouch Screen of the Applicant UI")
    public void iVerifyThatIAmOnTheOpenTheAlcoholPouchScreenOfTheApplicantUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.applicantAlcoholPouchScreen),"Open the Alcohol Pouch Screen is not found");
    }

    @And("I verify that the Next button is enabled on the Applicant UI")
    public void iVerifyThatTheNextButtonIsEnabledOnTheApplicantUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.nextButtonWebElement.isEnabled(), "Next Button is not enabled");
    }
    @And("I verify that I am on the Wait another minute page of the Applicant UI")
    public void iVerifyThatIAmOnTheWaitAnotherMinutePageOfTheApplicantUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.applicantWaitAnotherMinuteScreen),"Wait another minute Screen is not found");
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.iSeeResultsButton),"I see the results button is not found");
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.iStillDontSeeResultsButton),"I still don't see the results button is not found");

    }

    @And("I verify that I am on the Place the strip on the napkin screen")
    public void iVerifyThatIAmOnThePlaceTheStripOnTheNapkinScreen() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.applicantPlaceStripOnNapkinScreen), "Place the strip on the napkin screen is not found");

    }
    @And("I click the I still don't see any results button of the Applicant UI")
    public void iClickTheIStillDonTSeeAnyResultsButtonOfTheApplicantUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickIstillDontSeeButton();
    }

    @And("I verify that I am on the Pick up OralTox device screen of the Applicant UI")
    public void iVerifyThatIAmOnThePickUpOralToxDeviceScreenOfTheApplicantUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.applicantPickUpOralToxScreen),"Pick up the OralTox device page is not found");
    }

    @And("I verify that Need a Hand? screen appears on the Applicant UI")
    public void iVerifyThatNeedAHandScreenAppearsOnTheApplicantUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.helpSeeTheResultsButton),"Help page is not displayed");
    }

    @And("I click the I see the results button on the help modal of the Applicant UI")
    public void iClickTheISeeTheResultsButtonOnTheHelpModalOfTheApplicantUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickSeeResultHelpButton();
    }

    @And("^I can verify that this device is not valid for your location error message appears$")
    public void i_can_verify_that_this_device_is_not_valid_for_your_location_error_message_appears() throws Exception {
        AmazonApplicant amazonApplicant=getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.applicantNotValidLocationErrorMsg),"Device is not valid for your location error message is not given.");
    }

    @And("^I can verify that this device does not have the correct number of panels error message appears$")
    public void i_can_verify_that_this_device_does_not_have_correct_number_of_panels_error_message_appears() throws Exception {
        AmazonApplicant amazonApplicant=getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.applicantIncorrectNumberOfPanelsErrorMsg),"Incorrect number of panels error message is not given.");
    }

    @And("I upload a readable photo of the 6 panel 1 strip device")
    public void iUploadAReadablePhotoOfThe6Panel1StripDevice() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.waitForSeconds(1);
        amazonApplicant.uploadPhoto("/src/test/resources/testvideos/1 strip new format - QC000000120 VALID.png");
    }

    @And("I upload a readable photo of the 6 panel 6 strip device")
    public void iUploadAReadablePhotoOfThe6Panel6StripDevice() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.waitForSeconds(1);
        amazonApplicant.uploadPhoto("/src/test/resources/testvideos/6 strip new format - QB000000620 VALID.png");
    }

    @And("I upload a readable photo of the 7 panel 1 strip device")
    public void iUploadAReadablePhotoOfThe7Panel1StripDevice() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.waitForSeconds(1);
        amazonApplicant.uploadPhoto("/src/test/resources/testvideos/1 strip new 7-Panel - QD000000160 VALID.png");
    }

    @And("I upload a readable photo of the 7 panel 7 strip device")
    public void iUploadAReadablePhotoOfThe7Panel7StripDevice() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.waitForSeconds(1);
        amazonApplicant.uploadPhoto("/src/test/resources/testvideos/7 strip new format - QA000000720 VALID.png");
    }
    @And("I enter the Candidate information retrieved from the EA UI")
    public void iEnterTheCandidateInformationRetrievedFromTheEAUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterCandidateInfoRetrievedFromEAUi();
    }

    @And("I navigate to Applicant UI for location {string}")
    public void iNavigateToApplicantUIForLocation(String locationAlias) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.launcherURL(Environment.getEnvironmentBaseUrl() + "/?location=" + locationAlias);
    }

    @And("^I verify that the Email Checkbox is available on the Additional Disclosure page$")
    public void i_verify_that_the_Email_Checkbox_is_available_on_the_Additional_Disclosure_page() throws Exception {
        AmazonApplicant amazonApplicant=getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.applicantEmailCheckbox),"The Email Checkbox is not available");
    }

    @Then("I click the Email-Checkbox on Additional Disclosure page in Applicant UI")
    public void iCheckTheEmaiCheckboxOnAdditionalDisclosurePageInApplicantUI() throws Exception {
        AmazonApplicant app = getApplicantUIPageObject ( );
        app.selectTheEmailCheckbox();

    }

    @And("^I verify that the Email-Checkbox is selected on Additional Disclosure page$")
    public void i_verify_that_the_Email_Checkbox_is_selected_on_Additional_Disclosure_page() throws Exception {
        AmazonApplicant amazonApplicant=getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.applicantEmailCheckboxSelected),"The Email Checkbox is not selected");
    }

    @And("^I verify that the Email-Checkbox is Not selected on Additional Disclosure page$")
    public void i_verify_that_the_Email_Checkbox_is_Note_selected_on_Additional_Disclosure_page() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.applicantEmailCheckboxNoteSelected), "The Email Checkbox is not selected");
    }

    @And("I verify that I am navigated to the Review Package Before Opening screen")
    public void iVerifyThatIamNavigatedToTheReviewPackageBeforeOpeningScreen() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.ReviewPackageBeforeOpeningScreen), "'Review Package Before Opening' screen was not found as expected");
    }

    @And("I can verify the next button is disabled in the Applicant UI")
    public void iCanVerifyTheNextButtonIsDisabledInApplicantUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.waitForSeconds (1);
        Assert.assertFalse (amazonApplicant.isNextButtonEnabled ( ), "Next button was not disabled as expected.");
    }

    @And("I can verify all REF Codes exist in the Drop-down List in the Applicant UI")
    public void iCanVerifyAllREFCodesExistsInTheDropDownListInTheApplicantUI() throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        Assert.assertTrue (amazonApplicant.checkREFCodesList ( ), "Expected REF Codes were not found.");
    }

    @And("I select the REF Code {string} from the Drop-down list in Applicant UI")
    public void iSelectTheREFCodeFromDropDownInApplicantUI(String REFCode) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.selectREFCode(REFCode);
    }

    @And("^I can verify that incorrect test kit for this testing reason error message appears$")
    public void i_can_verify_that_incorrect_test_kit_for_this_for_testing_reason_error_message_appears() throws Exception {
        AmazonApplicant amazonApplicant=getApplicantUIPageObject();
        Assert.assertTrue(amazonApplicant.exists(amazonApplicant.applicantIncorrectTestKitErrorMsg),"Oops! That is the incorrect test kit for this testing reason.");
    }

    @And("I click the close button on the error message popup")
    public void iClickTheCloseButtonOnTheErrorMessagePopup() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickCloseButton();
    }
    @And("I click the button: Enter Device Information")
    public void iClickTheButtonEnterDeviceInformation() throws Exception{
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.clickSpecimenIDButton();
        report(Status.PASS, "Specimen ID button clicked.");
    }
    @And("I enter the sample ID {string} on the Enter Device Information screen")
    public void iEnterTheSampleIDOnTheEnterDeviceInformationScreen(String sampleId) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterSampleInformation(sampleId, false);
        report(Status.PASS, "Sample Information was entered.");
    }
    @And("I enter the Barcode {string} on the Enter Device Information screen in the Applicant UI")
    public void iEnterTheBarcodeOnTheEnterDeviceInformationScreenInTheApplicantUI(String barcode) throws Exception {
        AmazonApplicant amazonApplicant = getApplicantUIPageObject();
        amazonApplicant.enterBarcode(barcode, false);
        report(Status.PASS, "Barcode was entered.");
    }

}



/*    @And("I verify the text {string} on the candidate {string} card")
    public void iVerifyTheTextOnTheCandidateCard(String text, String name) {
        AmazonAdminUI app = getAdminUIPageObject();
        String cardText = app.getCardTextByName(name);

        report("Card text = " + cardText);
        Assert.assertTrue(cardText.contains(text), "Card contains text [" + text + "]");
    }*/


