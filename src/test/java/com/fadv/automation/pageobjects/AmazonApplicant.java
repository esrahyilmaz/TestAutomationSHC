package com.fadv.automation.pageobjects;

import com.aventstack.extentreports.Status;
import com.fadv.automation.Constants;
import com.fadv.automation.api.BackendApi;
import com.fadv.automation.api.CreateOrderWrapper;
import com.fadv.automation.core.Environment;
import com.fadv.automation.core.SeleniumBaseClass;
import com.fadv.automation.core.SharedBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.logging.Logger;


public class AmazonApplicant extends SeleniumBaseClass {
    static final Logger logger = Logger.getLogger(AmazonApplicant.class.getName());
    public static String applicantUILink;
    private Environment environment = new Environment(System.getProperty("env"));


    //*****By Elements*****
    public final By getStartedButton = By.xpath("//button[contains(text(),'Get Started')]");
    public final By applicantLastName = By.xpath("//input[@id='lastName']");
    public final By applicantAlias=By.id("alias");
    public final By applicantBirthMonth = By.xpath("//*[@id='birthMonth']");
    public final By applicantBirthDay = By.xpath("//*[@id='birthDay']");
    public final By applicantBirthYear = By.xpath("//*[@id='birthYear']");
    public final By applicantBoothNumber = By.xpath("//input[@id='station']");
    public final By applicantBootNumberError=By.xpath ("//label[contains(text(),'Please provide booth number between 1 and 99')]");
    public final By applicantAllFieldsError=By.xpath("//*[contains(text(),'All fields are required to get started')]");
    public final By applicantAliasError=By.xpath("//*[contains(text(),'Please enter a valid Amazon Alias')]");
    public final By applicantSsNumber = By.xpath("//input[@id='ssn']");
    public final By clearButton = By.xpath("//button[text()='Clear']");
    public final By backButton = By.xpath("//button[contains(text(),'Back')]");
    public final By disclosuresBackButton = By.xpath("//span[contains(text(),'Back')]");
    public By openPouchVideo = By.xpath("//*[@id='player']");
    public By salivaScreen = By.xpath("//h1[contains(text(),'Pool saliva in your mouth')][1]");
    public final By nextButton = By.xpath("//button[contains(text(),'Next')]");
    public By indicatorImage = By.xpath("//img[contains(@src,'wait-indicator')]");
    public By insertSwabDeviceImage = By.xpath("//h1[contains(text(),'Insert swab')]");
    public By openPouchImage = By.xpath(("//img[contains(@src,'open_pouch')]"));
    public By pouchLotInfoImage = By.xpath(("//img[contains(@src,'test-kit-pouch')]"));
    public final By indicatorRedButton = By.xpath("//button[contains(text(),'Indicator is red')]");
    public final By indicatorNotRedButton = By.xpath("//button[contains(text(),'Indicator is not red')]");
    public final By iSeeResultsButton = By.xpath("//button[contains(text(),'I see the results')]");
    public final By iDontSeeResultsButton = By.xpath("//button[contains(text(),\"don't see any results\")]");
    public final By iStillDontSeeResultsButton = By.xpath("//button[contains(text(),'I still')]");
    public final By readyForPhotoButton = By.xpath("//button[contains(text(),'ready to take the photo')]");
    public final By takePhotoButton = By.xpath("//div/a[contains(@class,'camera-capture')]");
    public By reviewYourInformationScreen = By.xpath("//div/h1[contains(text(),'Review your information')]");
    public By consentToUseSignatureScreen = By.xpath("//div/p[contains(text(),'Consent to Use Electronic Signature')]");
    public By collectSampleScreen = By.xpath("//div/h1[contains(text(),'Collect the sample')]");
    public By swabResultsWaitImage = By.xpath("//h1[contains(text(),'Wait')]/following::img");
    public By photoRulesScreen = By.xpath("//div/*[contains(text(),'Photo Rules')]");
    public By dInitialsPhotoRulesScreen = By.xpath("//p[contains(text(),'Rotate the device to show the date and initials.')]");
    public By reviewYourPhotoScreen = By.xpath("//div/p[contains(text(),'Review your photo')]");
    public By reviewYourUploadedPhotoScreen = By.xpath("//div/h1[contains(text(),'Upload a photo of your results')]");
    public By enterBoothNumberScreen=By.xpath ("//h1[contains(text(),'Enter Booth Number')]");
    public By virtualDonorScreen = By.xpath("//div/p[contains(text(),'Virtual Donor Signature Consent')]");
    public final By retakePhotoButton = By.xpath("//button[contains(text(),'Retake Photo')]");
    public By waitSentTestMessage = By.xpath("//p[contains(text(),'Wait while we review your test')]");
    public final By helpSeeTheResultsButton = By.xpath("//button[contains(text(),'Request Help')]/preceding::button[contains(text(), 'see the results')][1]");
    public final By foundMyAnswerButton = By.xpath("//button[contains(text(),'Found My Answer')]");
    public final By cancelButton = By.xpath("//button[contains(text(), 'Next')]/following::button");
    public final By cancelPhoto = By.xpath("//a[contains(text(),'Cancel')]");
    public final By updatePhoneOrEmailButton = By.xpath("//button[contains(text(), 'Update Phone or Email')]");
    public final By editPhoneNumberTextBox = By.xpath("//input[@type='tel']");
    public final By editEmailTextBox = By.xpath("//input[@type='email']");
    public final By editEmailErrorMsg = By.xpath("//*[contains(text(),'Please enter a valid email address')]");
    public final By editPhoneErrorMsg = By.xpath("//*[contains(text(),'Please enter a valid 10 digit phone number')]");
    public final By sampleIdTextBox = By.xpath("//input[@id='sampleId']");
    public final By confirmSampleIdTextBox = By.xpath("//input[@id='confirmSampleId']");
    public final By lotNumberTextBox = By.xpath("//input[@id='lotNumber']");
    public final By confirmLotNumberTextBox = By.xpath("//input[@id='confirmlotNumber']");
    public final By expirationYearTextBox = By.xpath("//*[@id='expYear']");
    public final By expirationMonthTextBox = By.xpath("//*[@id='expMonth']");
    public final By expirationDayTextBox = By.xpath("//input[@id='expDate']");
    public By sampleIdImageOrScreen = By.xpath("//img[contains(@src, 'test-kit')]");
    public final By playButton = By.xpath("//img[contains(@src,'images/play')]");
    public final By specimenIDButton = By.xpath("//button[contains(text(), 'Enter the Device Information')]");
    public By waitWhileWeReviewTestScreen = By.xpath("//h1[contains(text(), 'Wait while we review your test')]");
    public By uploadPhotoScreen = By.xpath("//h1[contains(text(),'Upload a photo')]");
    public By uploadedPhoto = By.xpath("//canvas[@id='uploadSensor']");
    public By requestHelpButton = By.xpath("//button[contains(text(),'Request Help')]");
    public By packageForShippingScreen = By.xpath("//h1[contains(text(), 'test kit for shipping')]");
    public final By allDoneButton = By.xpath("//button[contains(text(),'All Done')]");
    public By thankYouScreen = By.xpath("//div[contains(@class,'thankyouContent')]");
    public By startOverScreen = By.xpath("//h1[contains(text(),'Start Over')]");
    public By retakePhotoScreen = By.xpath("//p[contains(text(),'Retake Photo')]");
    public By missingFieldsLabel = By.xpath("//label[contains(text(), 'All fields are required to get started')]");
    public By errorDobLnameMissing = By.xpath("//p[contains(text(),\"Oops! The last name or Date of Birth doesn't match our records\" )]");
    public final By errorDobLnameSsnMissing = By.xpath("//p[contains(text(),\"Oops! The last name, Date of Birth or last 4 digits of SSN doesn't match our records\" )]");
    public By errorSampleLotMissing = By.xpath("//label[contains(text(),\"Oops! Your entries doesn't match. Please try again\")]");
    public By alreadyCompletedMessage = By.xpath("//p[contains(text(), 'You have already completed the drug screen and results have been submitted. If you still have a question, please contact the on-site Administrator')]");
    public By oEzeOpenPouchScreen = By.xpath("//p[contains(text(),'collection wand')]");
    public By oEzeSampleCollect1Screen = By.xpath("//p[contains(text(),'wand turns blue')]");
    public By oEzeSampleCollect2Screen  = By.xpath("//p[contains(text(),'collection pad into the tube')]");
    public By oEzeCloseCapScreen = By.xpath("//p[contains(text(),'Close the cap')]");
    public By oEzeSealDeviceScreen = By.xpath("//p[contains(text(),'Package your test kit for shipping')]");
    public final By indicatorBlueButton = By.xpath("//button[contains(text(),'Indicator is blue')]");
    public final By barcodeLabelTextBox = By.xpath("//input[@id='specimenId']");
    public final By confirmBarcodeLabelTextBox = By.xpath("//input[@id='confirmSpecimenId']");
    public By barcodeInformationScreen = By.xpath("//div/p[contains(text(),'Enter ID')]");
    public By barcodeShippingScreen = By.xpath("//p[contains(text(), 'Package your test kit for shipping')]");
    public By photoRulesText = By.xpath("//div/p[contains(text()[2], ' Make sure the specimen ID is clearly visible when taking the photo.')]");
    public final By capSealedTightlyButton = By.xpath("//button[contains(text(),'The cap is sealed tightly')]");
    public By cleanYourStationScreen = By.xpath("//h1[contains(text(),'Clean your station')]");
    public By invalidDevice = By.xpath("//p[contains(text(),'Collection device is invalid. Please use a valid device.')]");
    public By expiredDevice = By.xpath("//p[contains(text(),'Collection device is expired. Please use a valid device.')]");
    public By duplicateDevice = By.xpath("//p[contains(text(),'Collection device has already been used. Please use a valid device.')]");
    public By specimenIDLengthMessage = By.xpath("//label[contains(text(),'The length for Sample ID is 8 characters')]");
    public final By muteVolumeButton = By.xpath("//img[contains(@src,'images/unmute')]");
    public final By unmuteVolumeButton = By.xpath("//img[contains(@src,'images/mute')]");
    public By audioOnScreen = By.xpath("//audio");
    public By audioReplayButton = By.xpath("//img[contains(@src, 'replay')]");
    public final By cancelHelpRequest = By.xpath("(//button[contains(text(),'Cancel request')])[2]");
    public By greenPhotoShutterButton = By.xpath("//a[contains(@class, 'green')]");
    public final By pbtStartScan = By.xpath("//button[contains(text(),'Start Scan')]");
    public By sortingUIScan = By.xpath("//button[contains(text(),'Scan QRCode')]");
    public final By capturingOverlay = By.xpath("//*[contains(text(), 'Capturing')]");
    public final By consentSignatureControl = By.xpath("//signature-pad[@id='sigPad']/canvas");
    public final By consentPreEmpPart1=By.xpath ("//h1[contains(text(),'By signing below')]");
    public final By consentPreEmpPart2=By.xpath ("//h1[contains(text(),'authorized provider.')]");
    public final By consentOtherReasons=By.xpath ("//div/h5[contains(text(),'AMAZON DRUG AND ALCOHOL POLICY - US WWOPS')]");
    public final By iSeeTheRedIndicatorButtonOnPopUpWindow = By.xpath("//button[contains(text(),'I see the Red Indicator')]");
    public By eSignatureConsentScreen = By.xpath("//h1[contains(text(),'E-Signature Consent')]");
    public final By declineButton = By.xpath("//button[contains(text(),'Decline')] ");
    public final By agreeButton = By.xpath("//button[contains(text(),'Agree')] ");
    public By confirmationPopUp= By.xpath("//div[contains(text(),'Are you sure you want to Decline?')] ");
    public final By noBackButton = By.xpath("//button[contains(text(),'No, Back')] ");
    public final By yesDeclineButton = By.xpath("//button[contains(text(),'Yes, Decline')] ");
    public final By welcomeScreen = By.xpath("//h1[contains(text(),'Tap anywhere to begin')] ");
    public By drugAndAlcoholPolicyScreen = By.xpath("//h1[contains(text(),'Amazon Drug Test Policy')]");
    public By fCRADisclosureANdAuthorizationScreen = By.xpath("//h1[contains(text(),'FAIR CREDIT REPORTING ACT')] ");
    public By additionalDisclosureScreen=By.xpath("//h1[contains(text(),'ADDITIONAL DISCLOSURES')]");
    public By acknowledgeDrugTestScreen=By.xpath("//h1[contains(text(),'Acknowledgments')]");
    public By caDisclosureScreen=By.xpath("//h1[contains(text(),'CALIFORNIA DISCLOSURE ')]");
    public By ncDisclosureScreen=By.xpath("//h1[contains(text(),'N.C. Examination')]");
    public By enterSampleIDPageNotMatchingErrorMsg=By.xpath("//label[text()='Oops! Your entries do not match. Please try again']");
    public By applicantEnterIDPageAllFieldsErrorMsg=By.xpath("//label[text()='All fields are required to go next']");
    public By applicantFormatNotCorrectErrorMsg=By.xpath("//label[contains(text(),'Sample ID is either 8 digits or two alpha + 9 digits')]");
    public By applicantWaitScreen=By.xpath("//h1[text()='Wait']");
    public By applicantProceedToAlcoholBtn=By.xpath("//button[contains(text(),'Proceed to')]");
    public By applicantAlcoholWaitScreen=By.xpath("//h1[text()='Alcohol Wait']");
    public By applicantAlcoholPouchScreen=By.xpath("//h1[text()='Open the Alcohol Pouch']");
    public By applicantPlaceStripOnNapkinScreen=By.xpath("//h1[text()='Place the strip on the napkin']");
    public By applicantWaitAnotherMinuteScreen=By.xpath("//strong[text()='another minute']");
    public By applicantPickUpOralToxScreen=By.xpath("//h1[text()='Pick up the OralTox device']");
	public By applicantNotValidLocationErrorMsg=By.xpath("//p[contains(text(),'not valid for your location')]");
    public By applicantIncorrectNumberOfPanelsErrorMsg=By.xpath("//p[contains(text(),'correct number of panels')]");
    public By applicantEmailCheckbox =By.xpath("//input[@id='email-checkbox']");
    public By applicantEmailCheckboxSelected = By.xpath("//amzn-dynamic-agreement[@ng-reflect-should-email-result='true']");
    public By applicantEmailCheckboxNoteSelected = By.xpath("//amzn-dynamic-agreement[@ng-reflect-should-email-result='false']");
    public By ReviewPackageBeforeOpeningScreen=By.xpath("//h1[contains(text(),'Review Package Before Opening')]");
    public By REFCodesList = By.xpath("//select[@id='reference-code']");
    public By applicantIncorrectTestKitErrorMsg=By.xpath("//p[@id='errorContent']");
    public final By applicantCloseButton = By.xpath("(//button[@class='btn button btnActive'])[4]");
    public final By barcodeTextBox = By.xpath("//input[@id='barcode']");
    public final By confirmBarcodeTextBox = By.xpath("//input[@id='confirmBarcode']");

    //*****WebElements******

    @FindBy(xpath = "//*[contains(text(), 'Make sure we have your phone number and email address correct.')]")
    public WebElement reviewInfoEditTextAboveNextBtnWE;

    @FindBy(xpath = "//*[@class='phoneNumberArea text-center']/h2")
    public WebElement applicantPhoneNumber;

    @FindBy(xpath = "//*[@class='emailArea text-center']/h2")
    public WebElement applicantEmail;

    @FindBy(xpath = "//signature-pad[@id='sigPad']/canvas")
    public WebElement signaturePad;

    @FindBy(xpath = "//signature-pad[@id='sigPad']")
    public WebElement signaturePadText;

    @FindBy(xpath = "//div[contains(@class,'addressDetails')]")
    public WebElement applicantAddressDetails;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    public WebElement nextButtonWebElement;

    @FindBy(xpath = "//button[contains(text(),'The cap is sealed tightly')]")
    public WebElement capSealedTightButtonWebElement;

    @FindBy(xpath = "//button[contains(text(),'Indicator is red')]")
    public WebElement indicatorRedButtonWebElement;

    @FindBy(xpath = "//button[contains(text(),'Indicator is not red')]")
    public WebElement indicatorNotRedButtonWebElement;

    @FindBy(xpath = "//button[contains(text(),'Indicator is blue')]")
    public WebElement indicatorBlueButtonWebElement;

    @FindBy(xpath = "//button[contains(text(),'Back')]")
    public WebElement backButtonWebElement;

    @FindBy(xpath = "//input[@type='tel']")
    public WebElement editPhoneNumberWebElement;


    @FindBy(xpath = "//input[@type='email']")
    public WebElement editEmailWebElement;

    @FindBy(xpath = "//button[contains(text(),'Get Help')]")
    public WebElement helpIconWebElement;

    @FindBy(xpath = "//button[contains(text(), 'Enter the Device Information')]")
    public WebElement specimenIDButtonWebElement;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement uploadPhotoAreaWebElement;

    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement applicantSsNumber_WebElement;

    @FindBy(xpath = "//div/a[contains(@class,'camera-capture')]")
    public WebElement takePhotoButton_WebElement;
	
	 @FindBy(xpath = "//input[@id='station']")
    public WebElement boothNumberWE;
    @FindBy(xpath = "//span[@class='progress-text']")
	
    public WebElement timerControl_WebElement;

    @FindBy(xpath = "//input[@id='station']")
    public WebElement applicantBoothNumberWebElement;

    @FindBy(id = "alias")
    public WebElement applicantAliasWE;

    @FindBy(xpath = "//option[contains(text(),'REF')]")
    public List<WebElement> REFCodesListWebElement;

    @FindBy(xpath = "//select[@id='reference-code']")
    public WebElement REFCodesListWESelector;


    private CreateOrderWrapper createOrderWrapper = null;

    public AmazonApplicant(WebDriver driver) {
        super(driver);
    }

    public CreateOrderWrapper getCreateOrderWrapper() {
        if (createOrderWrapper == null) {
            BackendApi api = (BackendApi) testObject.getRuntimeData(Constants.BACKEND_API);
            createOrderWrapper = new CreateOrderWrapper(testObject, api);
        }
        return createOrderWrapper;
    }

    public By ButtonText(String buttonText) throws Exception{
        String xpath = String.format("//*[contains(text(),'%s')]", buttonText);
        waitForElementClickable(By.xpath(xpath));
        return By.xpath(xpath);
    }

    public void clickApplicantButton(String buttonText) throws Exception{
        clickElement(ButtonText(buttonText));
    }

    public void clickNextButton() throws Exception
    {
        waitForElementClickable(nextButton,420);
        scrollTo(nextButtonWebElement);
        clickElement(nextButton);
        Thread.sleep(4000);
    }
    public void enterBarcode(String barcode, Boolean clearField){
        if(clearField.equals(true)){
            setElementValue(barcodeTextBox, barcode);
            setElementValue(confirmBarcodeTextBox, barcode);
        }
        else {
            setElementValueNoClear(barcodeTextBox, barcode);
            setElementValueNoClear(confirmBarcodeTextBox, barcode);
        }
        report(Status.PASS, "Entered Barcode Information");
    }

    public void clickCapIsSealedButton() throws Exception
    {
        waitForElementClickable(capSealedTightlyButton);
        scrollTo(capSealedTightButtonWebElement);
        clickElement(capSealedTightlyButton);
        Thread.sleep(4000);
    }

    public void clickIndicatorRedButton() throws Exception{
        waitForElementPresent(indicatorRedButtonWebElement);
        waitForElementClickable(indicatorRedButton);
        scrollTo(indicatorRedButtonWebElement);
        clickElement(indicatorRedButton);
    }

    public void clickIndicatorNotRedButton() throws Exception{
        waitForElementPresent(indicatorNotRedButtonWebElement);
        clickElement(indicatorNotRedButton);
    }

    public void clickIndicatorBlueButton() throws Exception{
        scrollTo(indicatorBlueButtonWebElement);
        clickElement(indicatorBlueButton);
    }

    public void clickISeeTheResultsButton() throws Exception{
        waitForElementClickable(iSeeResultsButton);
        clickElement(iSeeResultsButton);
    }

    public void clickIDontSeeTheResultsButton() throws Exception{
        waitForElementClickable(iDontSeeResultsButton);
        clickElement(iDontSeeResultsButton);
    }

    public void clickReadyForPhotoButton() throws Exception{
        waitForElementClickable(readyForPhotoButton);
        clickElement(readyForPhotoButton);
    }

    public void clickRetakePhotoButton() throws Exception{
        waitForElementClickable(retakePhotoButton);
        clickElement(retakePhotoButton);
    }

    public void clickGetStarted() throws Exception{
        waitForElementClickable(getStartedButton);
        clickElement(getStartedButton);
        Thread.sleep(3000);
    }

    /* This is a simulation of clicking the link in the email. This method constructs the link that is normally
    found in the email
     */
    public void clickEmailGetStarted() {
        //need method to get location information from order
        String location = "290253bc-b4e8-4de2-bb2f-30efc71099b9";
        String applicantURL = String.format("https://testnow-uat.fadv.com/?location=%s", location);
        driver.get(applicantURL);
    }

    public void clickHelpIcon() throws Exception{
        waitForElementPresent(helpIconWebElement);
        javaScriptClick(helpIconWebElement);
    }

    public void clickFoundAnswerButton() throws Exception{
        waitForElementClickable(foundMyAnswerButton);
        clickElement(foundMyAnswerButton);
    }

    public void clickSeeResultHelpButton() throws Exception{
        waitForElementClickable(helpSeeTheResultsButton);
        clickElement(helpSeeTheResultsButton);
    }

    public void clickCancelButton() throws Exception{
        waitForElementClickable(cancelButton);
        clickElement(cancelButton);
    }

    public void clickCancelPhotoButton() throws Exception{
        waitForElementClickable(cancelPhoto);
        clickElement(cancelPhoto);
    }

    public void clickUpdatePhoneOrEmailButton() throws Exception{
        waitForElementClickable(updatePhoneOrEmailButton);
        clickElement(updatePhoneOrEmailButton);
    }

    public void clickClearButton() throws Exception{
        waitForElementClickable(clearButton);
        clickElement(clearButton);
    }


    public void clickBackButton() throws Exception{
        waitForElementClickable(backButton);
        scrollTo(backButtonWebElement);
        clickElement(backButton);
        Thread.sleep(2000);
    }

    public void clickSpecimenIDButton() throws Exception{
        waitForSeconds(2);
        waitForElementClickable(specimenIDButton);
        scrollTo(specimenIDButtonWebElement);
        clickElement(specimenIDButton);
    }

    public String getApplicantPhoneNumberValue() throws Exception{
        waitForElementPresent(applicantPhoneNumber);
        return getText(applicantPhoneNumber);
    }

    public String getAddressDetails() throws Exception{
        waitForElementPresent(applicantAddressDetails);
        return getText(applicantAddressDetails);
    }

    public String getInviteURL()throws Exception{
        return getCreateOrderWrapper().getApplicantUILink();
    }

    public String getInviteUIUrl(String location) {
        if (applicantUILink == null) {
            //test environment location is using this configuration
            if (location.equalsIgnoreCase("amazon")){
                applicantUILink = environment.getEnvironmentBaseUrl() + "/?location=CLT4#/";
            }
            else {
                applicantUILink = environment.getEnvironmentBaseUrl() + "/?location=" + environment.getEnvironmentLocationUuid();
            }
            logger.info("applicant UI link:" + applicantUILink);
        }
        return applicantUILink;
    }

    public void  isTimerGreaterCorrect(long expectedTime) throws Exception {
        //need to manually subtract 2-3 seconds from expected time to allot for getText to return results
        long capturedTime = Long.parseLong(getText(timerControl_WebElement).replace(":", ""));
        logger.info("Time captured: " + capturedTime);
        Assert.assertTrue(capturedTime >= expectedTime, "Time captured should have been less than 5 seconds.");
    }

    public void  isTimerLessorCorrect(long expectedTime) throws Exception {
        long capturedTime = Long.parseLong(getText(timerControl_WebElement).replace(":", ""));
        logger.info("Time captured: " + capturedTime);
        Assert.assertTrue(expectedTime >= capturedTime, "Time captured should have been greater than " + expectedTime + " seconds.");
    }


    public void signSignaturePad() throws Exception{
        waitForElementPresent(signaturePad);
        clickElement(consentSignatureControl);
        Actions builder = new Actions(driver);
        Action drawAction = builder.moveToElement(signaturePad, 20, 30)
                //signatureWebElement is the element that holds the signature element you have in the DOM
                .clickAndHold()
                .moveByOffset(60, 50)
                .moveByOffset(65, 55)
                .release()
                .build();
        drawAction.perform();
    }
    public void signSignaturePad2() throws Exception{
        waitForElementPresent(signaturePad);
        clickElement(consentSignatureControl);
        Actions builder = new Actions(driver);
        Action drawAction = builder.moveToElement(signaturePad, 20, 30)
                //signatureWebElement is the element that holds the signature element you have in the DOM
                .clickAndHold()
                .moveByOffset(60, 50)
                .release()
                .build();
        drawAction.perform();
    }


    public void clickMuteVolumeButton() throws Exception{
        waitForElementClickable(muteVolumeButton);
        clickElement(muteVolumeButton);
    }

    public void clickUnmuteVolumeButton() throws Exception{
        waitForElementClickable(unmuteVolumeButton);
        clickElement(unmuteVolumeButton);
    }

    private int convertMonthToNumberString(Month month) {
        return month.get(ChronoField.MONTH_OF_YEAR);
    }

    public void enterApplicantInfoRetrievedFromEAUi(String boothNumber) throws Exception {
//        EA ea = new EA(driver);
        String lName = EA.lastNameInUi;
        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);

        String month = String.valueOf(convertMonthToNumberString(EA.birthMonthInUi));
        String day = EA.birthDayInUi;
        String year = EA.birthYearInUi;
        setElementValue(applicantLastName, lName);
        setElementValueNoClear(applicantBirthMonth, month);
        setElementValueNoClear(applicantBirthDay, day);
        setElementValueNoClear(applicantBirthYear, year);
        String lastFour = sharedBaseClass.getLast4SsNumber(EA.ssnInUi);
        setElementValueNoClear(applicantSsNumber, lastFour);
        clickMuteVolumeButton();
        clickGetStarted();

        if(boothNumber != null) {
            waitForElementPresent(applicantBoothNumberWebElement);
            setElementValueNoClear(applicantBoothNumber, boothNumber);
        }
        report(Status.PASS, "Entered Applicant Information:" + lName + "\n" + month  + "\n" + day + "\n" + year + "\n" + lastFour);

    }
    public void enterCandidateInfoRetrievedFromEAUi() throws Exception {

        String lName = EA.lastNameInUi;
        String month = String.valueOf(convertMonthToNumberString(EA.birthMonthInUi));
        String day = EA.birthDayInUi;
        String year = EA.birthYearInUi;
        setElementValue(applicantLastName, lName);
        setElementValueNoClear(applicantBirthMonth, month);
        setElementValueNoClear(applicantBirthDay, day);
        setElementValueNoClear(applicantBirthYear, year);
        setElementValueNoClear(applicantAlias, testObject.getTestData("alias"));
        clickMuteVolumeButton();
        clickGetStarted();

        report(Status.PASS, "Entered Candidate Information:" + lName + "\n" + month  + "\n" + day + "\n" + year + "\n" );
    }

    public void enterApplicantInfoRetrievedFromEAUiNoSSN(String boothNumber) throws Exception {
//        EA ea = new EA(driver);
        String lName = EA.lastNameInUi;

        String month = String.valueOf(convertMonthToNumberString(EA.birthMonthInUi));
        String day = EA.birthDayInUi;
        String year = EA.birthYearInUi;
        setElementValue(applicantLastName, lName);
        setElementValueNoClear(applicantBirthMonth, month);
        setElementValueNoClear(applicantBirthDay, day);
        setElementValueNoClear(applicantBirthYear, year);
        clickMuteVolumeButton();
        clickGetStarted();
        if(boothNumber != null) {
            waitForElementPresent(applicantBoothNumberWebElement);
            setElementValueNoClear(applicantBoothNumber, boothNumber);
        }
        report(Status.PASS, "Entered Applicant Information:" + lName + "\n" + month  + "\n" + day + "\n" + year);
    }

    public void enterApplicantInfo(String boothNumber, String socialSecurityNumber, Boolean useForRelaunch) throws Exception{
        CreateOrderWrapper order = this.getCreateOrderWrapper();
        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);
        String lName = null;
        String dateOfBirth;
        String[] dob;
        String month = null;
        String day = null;
        String year = null;
        String lastFour = null;

        if(!useForRelaunch){
            lName = order.getRequestField("lastName");
            dateOfBirth = order.getRequestField("dateOfBirth");
            dob = dateOfBirth.split("/");
            month = dob[0];
            day = dob[1];
            year = dob[2];
            testObject.setTestData("lName", lName);
            testObject.setTestData("month", month);
            testObject.setTestData("day", day);
            testObject.setTestData("year", year);
        }
        if(useForRelaunch){
            lName = testObject.getTestData("lName");
            month = testObject.getTestData("month");
            day = testObject.getTestData("day");
            year = testObject.getTestData("year");
            lastFour = testObject.getTestData("lastFour");
        }

        setElementValue(applicantLastName, lName);
        setElementValueNoClear(applicantBirthMonth, month);
        setElementValueNoClear(applicantBirthDay, day);
        setElementValueNoClear(applicantBirthYear, year);
        if (socialSecurityNumber == "invalid") {
            setElementValueNoClear(applicantSsNumber, "");
        }
        else if (socialSecurityNumber == null || socialSecurityNumber.isEmpty()) {
            if (!useForRelaunch) {
                lastFour = order.getRequestField("ssn");
                setElementValue(applicantSsNumber, lastFour);//ask confirmation
                testObject.setTestData("lastFour", lastFour);
            }
            if(useForRelaunch) {
                setElementValueNoClear(applicantSsNumber,lastFour);
            }
        }
        else{
            if (!useForRelaunch) {
                lastFour = sharedBaseClass.getLast4SsNumber(socialSecurityNumber);
                setElementValueNoClear(applicantSsNumber, lastFour);
                testObject.setTestData("lastFour", lastFour);
            }
            if(useForRelaunch) {
                setElementValueNoClear(applicantSsNumber,lastFour);
            }
        }
        clickMuteVolumeButton();
        clickGetStarted();
        if(boothNumber != null) {
            waitForElementPresent(applicantBoothNumberWebElement);
            setElementValue(applicantBoothNumber, boothNumber);//ask confirmation
            logger.info("booth number set: " + boothNumber);
        }
        report(Status.PASS, "Entered Applicant Information:" + lName + "\n" + month  + "\n" + day + "\n" + year + "\n" + lastFour);
    }




    public void manualEntryApplicantInfo(String lName, String birthday) {

        String[] dob = birthday.split("/");
        String month = dob[0];
        String day = dob[1];
        String year = dob[2];
        setElementValue(applicantLastName, lName);
        setElementValueNoClear(applicantBirthMonth, month);
        setElementValueNoClear(applicantBirthDay, day);
        setElementValueNoClear(applicantBirthYear, year);
        report(Status.PASS, "Entered Applicant Information:" + lName + "\n" + month + "\n" + day + "\n" + year);
    }

    public void enterLotExpirationInformation(String year, String month, String day){
        setElementValueNoClear(expirationYearTextBox, year);
        setElementValueNoClear(expirationMonthTextBox, month);
        setElementValueNoClear(expirationDayTextBox, day);
        report(Status.PASS, "Lot Expiration Information entered");
    }

    public void enterLotNumberInformation(String lotNumber, Boolean clearField){
        if(clearField.equals(true)){
            setElementValue(lotNumberTextBox, lotNumber);
            setElementValue(confirmLotNumberTextBox, lotNumber);
        }
        else {
            setElementValueNoClear(lotNumberTextBox, lotNumber);
            setElementValueNoClear(confirmLotNumberTextBox, lotNumber);
        }
        report(Status.PASS, "Entered Lot Information");
    }

    public void enterNonMatchingLotNumberInformation(String lotNumber){
        setElementValueNoClear(lotNumberTextBox, lotNumber);
        setElementValueNoClear(confirmLotNumberTextBox, "8976544lotNumber");
        report(Status.PASS, "Entered Non-Matching Lot Information");
    }

    public void enterSampleInformation(String sampleId, Boolean clearField){
        if(clearField.equals(true)){
            setElementValue(sampleIdTextBox, sampleId);
            setElementValue(confirmSampleIdTextBox, sampleId);
        }
        else {
            setElementValueNoClear(sampleIdTextBox, sampleId);
            setElementValueNoClear(confirmSampleIdTextBox, sampleId);
        }
        report(Status.PASS, "Entered Sample Information");
    }

    public void enterBarcodeLabelInformation(String sampleId, Boolean clearField){
        if(clearField.equals(true)){
            setElementValue(barcodeLabelTextBox, sampleId);
            setElementValue(confirmBarcodeLabelTextBox, sampleId);
        }
        else {
            setElementValueNoClear(barcodeLabelTextBox, sampleId);
            setElementValueNoClear(confirmBarcodeLabelTextBox, sampleId);
        }
        report(Status.PASS, "Entered Barcode Information");
    }

    public void enterNonMatchingBarcodeInformation(String barcodeId){
        setElementValueNoClear(barcodeLabelTextBox, barcodeId);
        setElementValueNoClear(confirmBarcodeLabelTextBox, "98453sample");
        report(Status.PASS, "Entered Non-Matching Barcode Label Information");
    }

    public void enterNonMatchingSampleInformation(String sampleId){
        setElementValueNoClear(sampleIdTextBox, sampleId);
        setElementValueNoClear(confirmSampleIdTextBox, "98873sample");
        report(Status.PASS, "Entered Non-Matching Sample Information");
    }

    public void enterPhoneNumber(String phoneNumber) throws Exception{
        waitForElementPresent(editPhoneNumberWebElement);
        clickElement(editPhoneNumberTextBox);
        setElementValue(editPhoneNumberTextBox, phoneNumber);
        report(Status.PASS, "Entered Phone Number");
    }
    public void enterEmail(String email) throws Exception{
        waitForElementPresent(editEmailWebElement);
        clickElement(editEmailTextBox);
        setElementValue(editEmailTextBox, email);
        report(Status.PASS, "Entered Email");
    }
    public void enterSSNnumber(String ssnNumber) throws Exception {
        waitForElementPresent (applicantSsNumber_WebElement);
        clickElement (applicantSsNumber);
        setElementValue (applicantSsNumber,ssnNumber);
        report (Status.PASS, "Entered SSN Number");
    }


    public void launcherURL(String url) throws Exception{
        driver.get(url);
        Thread.sleep(3000);
    }

    public void launchPBTBarcodeReader() throws Exception {
        String url = environment.getEnvironmentBaseUrl() + "/barcode/";
        launcherURL(url);
    }

    public void launchSortingUIReader() throws Exception {
        BackendApi backendApi = new BackendApi();
        String url = environment.getEnvironmentBaseUrl() + "/sorting/#/welcome";
        launcherURL(url);
    }


    public void takePhotoOnCamera() throws Exception{
        waitForElementPresent(takePhotoButton_WebElement);
        waitForElementClickable(takePhotoButton);
        clickElement(takePhotoButton);
        checkCapturingOverlay();
    }


    public void verifyAddressDetails() throws Exception{
        CreateOrderWrapper order= this.getCreateOrderWrapper();
        //***get address block***
        String address1= order.getRequest().path("Address").path("line1").textValue();
        String address2 = order.getRequest().path("Address").path("line2").textValue();
        String phoneNumber = order.getRequestField("phoneNumber");
        String emailAddress = order.getRequestField("emailAddress");
        SoftAssert softAssert = new SoftAssert();
        logger.info("Applicant Information verification");
        softAssert.assertTrue(getAddressDetails().contains(address1), "Expected Address Line1 was not found on the Phone Number Screen.");
        if(!address2.isEmpty()) {
            softAssert.assertTrue(getAddressDetails().contains(address2), "Expected Address Line2 was not found on the Phone Number Screen.");
        }
        softAssert.assertTrue(getAddressDetails().contains(order.getRequestField("firstName")), "Expected First Name was not found on the Phone Number Screen.");
        softAssert.assertTrue(getAddressDetails().contains(order.getRequestField("lastName")), "Expected Last Name was not found on the Phone Number Screen.");
        softAssert.assertTrue(getAddressDetails().contains(order.getRequest().path("Address").path("city").textValue()), "Expected City was not found on the Phone Number Screen.");
        softAssert.assertTrue(getAddressDetails().contains(order.getRequest().path("Address").path("state").textValue()), "Expected State was not found on the Phone Number Screen.");
        softAssert.assertTrue(getAddressDetails().contains(order.getRequest().path("Address").path("zip").textValue()), "Expected Zip was not found on the Phone Number Screen.");
        softAssert.assertTrue(getText(applicantEmail).replace(" ", "").equals(emailAddress), "Expected Email " + emailAddress + " was not found on the Phone Number Screen.");
        softAssert.assertTrue(getText(applicantPhoneNumber).replace(" ", "").equals(phoneNumber), "Expected Phone Number " + phoneNumber + " was not found on the Phone Number Screen.");

        softAssert.assertAll();
        report("Applicant information verified");
    }

    public void uploadPhoto(String file) {
        String directory = System.getProperty("user.dir") + file;
        logger.info("directory/folder path:  " + directory);
        uploadPhotoAreaWebElement.sendKeys(directory);
    }

    public void clickAllDoneButton() throws Exception{
        waitForElementClickable(allDoneButton);
        clickElement(allDoneButton);
    }

    public Boolean helpContentExists(String content) {
        String xpath = String.format("//*[contains(text(),'%s')]", content);
        return  driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    public boolean boothFieldExists() {
        return this.exists(applicantBoothNumber, 5);
    }

    public void clickSpeechPlayButton() throws Exception{
        waitForElementClickable(playButton);
        clickElement(playButton);
    }

    public void uploadCandidateFile(String file) {
        String directory = System.getProperty("user.dir") + file;
        uploadPhotoAreaWebElement.sendKeys(directory);
    }

    public boolean isTheCapIsSealedTightlyButtonPresent(String message){
        String xpath = String.format("//*[contains(text(),'%s')]", message);
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    public void clickCapIsSealedTightlyButton() throws Exception
    {
        waitForElementClickable(capSealedTightlyButton);
        scrollTo(capSealedTightButtonWebElement);
        clickElement(capSealedTightlyButton);
        Thread.sleep(4000);
    }


    public void clickCancelRequestButton()throws Exception{
        waitForElementClickable(cancelHelpRequest);
        clickElement(cancelHelpRequest);
    }

    public void clickPBTStartScanButton() throws Exception {
        waitForElementClickable(pbtStartScan);
        clickElement(pbtStartScan);
    }
    public void clickSortingUIStartScanButton() {
//        if (exists(sortingUIScan)) {
//            waitForElementClickable(sortingUIScan);
//            clickElement(sortingUIScan);
//        }
//        else {
        refreshPage();
//        }
    }

    private void refreshPage(){
        driver.navigate().refresh();
    }

    public Boolean qrcodeExists(String qrcode){
        String xpath = String.format("//h5[contains(text(),'QR')]/following::code[contains(text(),'%s')]", qrcode);
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    public Boolean barcodeExists(String barcode){
        String xpath = String.format("//h5[contains(text(),'Bar')]/following::code[contains(text(),'%s')]", barcode);
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    public Boolean sortingUiQrCodeExists(String qrcodeResult){
        String xpath = String.format("//h4[contains(text(),'%s')]", qrcodeResult);
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    public Boolean sortingUIMessageExists(String expecteMessage){
        String xpath = String.format("//h4[contains(text(),'%s')]", expecteMessage);
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    public void checkCapturingOverlay() throws InterruptedException {
        waitForDisappear(capturingOverlay, 45);
    }

    public void enterAdminUIGenerateApplicantInformation() throws Exception {
        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);
        String lastName = testObject.getTestData("adminUIOrderLName");
        String birthday = testObject.getTestData("adminUIOrderDob");
        String ssn = testObject.getTestData("adminUIOrderSsn");
        manualEntryApplicantInfo(lastName, birthday);
        enterSSNnumber(sharedBaseClass.getLast4SsNumber(ssn));
    }
    public void enterAdminUIGenerateApplicantInfoNoBoothNmbr() throws Exception {
        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);
        String lastName = testObject.getTestData("adminUIOrderLName");
        String birthday = testObject.getTestData("adminUIOrderDob");
        String ssn = testObject.getTestData("adminUIOrderSsn");
        manualEntryApplicantInfoNoBooth(lastName, birthday);
        enterSSNnumber(sharedBaseClass.getLast4SsNumber(ssn));
    }

    private void manualEntryApplicantInfoNoBooth(String lName, String birthday) {
                    String[] dob = birthday.split("/");
            String month = dob[0];
            String day = dob[1];
            String year = dob[2];
            setElementValue(applicantLastName, lName);
            setElementValueNoClear(applicantBirthMonth, month);
            setElementValueNoClear(applicantBirthDay, day);
            setElementValueNoClear(applicantBirthYear, year);
            report(Status.PASS, "Entered Applicant Information:" + lName + "\n" + month + "\n" + day + "\n" + year);
        }

    public void verifyConsentForOthers() {
        Assert.assertTrue (exists (consentOtherReasons) );
    }
	  public void verifyPreEmpConsent() {
        Assert.assertTrue (exists (consentPreEmpPart1) );
        Assert.assertTrue (exists (consentPreEmpPart2));
    }
	 public String randomBoothNumber() {
        int boothNum=(int)(Math.random ()*100);
        return ""+boothNum;
    }

    public void verifyInvalidBoothNum() {
        Assert.assertTrue (exists (applicantBootNumberError),"'Please provide booth number between 1 and 99' Booth number Error Message is not given");
    }

    public void clearBoothNumber() {
        setElementValue (applicantBoothNumber,"");
    }

    public void enterApplicantLnameDobSsn(String lastName, String doB, String ssn) {
        setElementValue (applicantLastName,lastName);
        setElementValue (applicantBirthMonth,doB.substring (0,2));
        setElementValue (applicantBirthDay,doB.substring (3,5));
        setElementValue (applicantBirthYear,doB.substring (6,10));
        setElementValue (applicantSsNumber,ssn);
    }
    public void enterApplicantLnameDobAlias(String lastName, String doB, String alias) {
        setElementValue (applicantLastName,lastName);
        setElementValue (applicantBirthMonth,doB.substring (0,2));
        setElementValue (applicantBirthDay,doB.substring (3,5));
        setElementValue (applicantBirthYear,doB.substring (6,10));
        setElementValue (applicantAlias,alias);
    }

    public void enterBooth(String boothNumber) {
        logger.info("setting booth number: " + boothNumber);
        setElementValue (applicantBoothNumber,boothNumber);
    }

    public void verifyNoBoothNumberError() {
        Assert.assertFalse (exists(errorDobLnameSsnMissing),"Booth Number error is thrown");
    }
	
    public void enterBoothNumber( String boothNumber) throws Exception {
        waitForElementPresent (boothNumberWE);
        setElementValue (applicantBoothNumber,boothNumber);
    }
	 public void verifyBoothNumberFieldAbsent() {
        Assert.assertFalse (boothFieldExists () );
    }

    public void verifyBoothNumberAbsentOnTheCard() {
        String xpath=("//div[@class='card-subpanel id-container']");
        Assert.assertFalse (exists (By.xpath (xpath)));

    }
    public void clickISeeTheResultIndicatorButton() throws Exception{
        waitForElementClickable(iSeeTheRedIndicatorButtonOnPopUpWindow);
        clickElement(iSeeTheRedIndicatorButtonOnPopUpWindow);
    }

    public void enterAlias(String alias) {
        waitForElementPresent (applicantAliasWE);
        setElementValue (applicantAlias,alias);
    }
	public void enterApplicantInfoWithAlias(Boolean useForRelaunch) throws Exception {
        CreateOrderWrapper order = this.getCreateOrderWrapper();
        String lName = null;
        String dateOfBirth;
        String[] dob;
        String month = null;
        String day = null;
        String year = null;
        String alias=null;

        if(!useForRelaunch){
            lName = order.getRequestField("lastName");
            dateOfBirth = order.getRequestField("dateOfBirth");
            alias=order.getRequestField("alias");
            dob = dateOfBirth.split("/");
            month = dob[0];
            day = dob[1];
            year = dob[2];
            testObject.setTestData("lName", lName);
            testObject.setTestData("month", month);
            testObject.setTestData("day", day);
            testObject.setTestData("year", year);
            testObject.setTestData("alias",alias);

        }
        if(useForRelaunch){
            lName = testObject.getTestData("lName");
            month = testObject.getTestData("month");
            day = testObject.getTestData("day");
            year = testObject.getTestData("year");
            alias=testObject.getTestData("alias");
        }

        setElementValue(applicantLastName, lName);
        setElementValueNoClear(applicantBirthMonth, month);
        setElementValueNoClear(applicantBirthDay, day);
        setElementValueNoClear(applicantBirthYear, year);
        setElementValueNoClear(applicantAlias, alias);


        clickMuteVolumeButton();
        clickGetStarted();

        report(Status.PASS, "Entered Applicant Information:" + lName + "\n" + month  + "\n" + day + "\n" + year + "\n" + alias);
    }
    public void clickDeclineButton() throws Exception{
        waitForElementClickable(declineButton);
        clickElement(declineButton);
        waitForSeconds(2);
    }
    public void clickAgreeButton() throws Exception{
        waitForElementClickable(agreeButton);
        clickElement(agreeButton);
        waitForSeconds(2);
    }
    public void clickNoBackButton() throws Exception{
        waitForElementClickable(noBackButton);
        clickElement(noBackButton);
        waitForSeconds(2);
    }
    public void clickYesDeclineButton() throws Exception{
        waitForElementClickable(yesDeclineButton);
        clickElement(yesDeclineButton);
        waitForSeconds(2);
    }
    public void enterSampleInformationOnFirstField(String sampleId, Boolean clearField) {
        if (clearField.equals(true)) {
            setElementValue(sampleIdTextBox, sampleId);
        } else {
            setElementValueNoClear(sampleIdTextBox, sampleId);
        }
        report(Status.PASS, "Entered Sample Information");
    }

    public void enterSampleInformationOnSecondField(String sampleId, Boolean clearField) {
        if (clearField.equals(true)) {
            setElementValue(confirmSampleIdTextBox, sampleId);
        } else {
            setElementValueNoClear(confirmSampleIdTextBox, sampleId);
        }
        report(Status.PASS, "Entered Sample Information");

    }
	public void clickDisclosureBackButton() {
        waitForElementClickable(disclosuresBackButton);
        clickElement(disclosuresBackButton);
    }

    public void clickProceedAlcoholBtn() {
        waitForElementClickable(applicantProceedToAlcoholBtn);
        clickElement(applicantProceedToAlcoholBtn);
    }

    public void clickIstillDontSeeButton() {
        waitForElementClickable(iStillDontSeeResultsButton);
        clickElement(iStillDontSeeResultsButton);
    }

        public void selectTheEmailCheckbox() {
           waitForElementClickable(applicantEmailCheckbox);
            clickElement(applicantEmailCheckbox);
        }

    public boolean isNextButtonEnabled() {
        return nextButtonWebElement.isEnabled();
    }

    public Boolean checkREFCodesList() throws Exception {
        boolean found = false;
        String[] list = new String[]{"REF: 80101AZ", "REF: 80603AZ", "REF: 80701AZ"};
        clickElement(REFCodesList);

        for (int i = 0; i < list.length; i++) {
            if ((!found) && (i != 0)) {
                return false;
            }
            if (found) {
                found = false;
            }
            for (WebElement REFCode : REFCodesListWebElement) {
                logger.info("checking REF codes... " + getText(REFCode) + " for " + i + " " + list[i]);
                if (getText(REFCode).trim().equalsIgnoreCase(list[i].trim())) {
                    found = true;
                    logger.info("REF codes was found: " + getText(REFCode));
                    break;
                }
            }
        }
        return found;
    }

    public void selectREFCode(String REFCode) throws Exception {
        waitForElementPresent(REFCodesListWESelector);
        selectElement(REFCodesList, REFCode);
    }

    public void clickCloseButton()throws Exception{
        waitForElementClickable(applicantCloseButton);
        clickElement(applicantCloseButton);
    }


}
