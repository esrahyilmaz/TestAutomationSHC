package com.fadv.automation.pageobjects;

import com.aventstack.extentreports.Status;
import com.fadv.automation.Constants;
import com.fadv.automation.api.BackendApi;
import com.fadv.automation.api.CreateOrderWrapper;
import com.fadv.automation.core.Environment;
import com.fadv.automation.core.SeleniumBaseClass;
import com.fadv.automation.core.SharedBaseClass;
import com.fadv.automation.utils.CommonMethods;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.logging.Logger;


public class AmazonAdminUI extends SeleniumBaseClass {
    static final Logger logger = Logger.getLogger(AmazonAdminUI.class.getName());
    private Environment environment = new Environment(System.getProperty("env"));

    public AmazonAdminUI(WebDriver driver) {
        super(driver);
    }

    //By Element
    public final By cardName = By.xpath("//amzn-candidate-card//div[@class='candidate-container']");
    public By inProgressTab = By.xpath("//*/a[@id='inProgress']");
    public final By concludedTab = By.xpath("//a[@id='complete']");
    public By amphetimine = By.xpath("//input[@id='AMP']");
    public By benzodiazepine = By.xpath("//input[@id='BZD']");
    public By adjInconclusiveConfirmation = By.xpath("//amzn-confirm-modal//p/b[contains(text(),'inconclusive')]");
    public By adjClearConfirmation = By.xpath("//amzn-confirm-modal//p/b[contains(text(),'clear')]");
    public By adjInvalidConfirmation = By.xpath("//amzn-confirm-modal//p/b[contains(text(),'invalid')] ");
    public By adjAbandonedConfirmation = By.xpath("//amzn-confirm-modal//p/b[contains(text(),'abandon')]");
    public final By adjConfirmButton = By.xpath("//button[@class='btn confirmBtn']");
    public final By adjCancelButton = By.xpath("//button[@class='btn cancelBtn']");
    public final By drugCollectionCheckbox = By.xpath("//div[@class='check-box']");
    public final By restartTestCheckbox = By.xpath("//div/input[@id='restartTest']");
    public final By helpDoneButton = By.xpath("//button[@id='done-button']");
    //must use this icon reference now since devs have made this element the clickable element
    public final By mainMenu = By.xpath("//fa-icon");
    public final By logoutMenu = By.xpath("//a[contains(text(),'Logout')]");
    public final By helpText = By.id("help-comment");
    public final By startDateRange = By.xpath("(//*[contains(@data-icon,'calendar')])[1]");
    public final By endDateRange = By.xpath("(//*[contains(@data-icon,'calendar')])[2]");
    public final By candidateSearchTextBox = By.xpath("//input[@type='text']");
    public final By weMenu = By.id("header-menu");
    public By adjudicatedDeviceImage = By.id("testing-pic");
    public By adjudicatorSignatureImage = By.xpath("//img[contains(@src, 'adjudicatorSignature')]");
    public final By adjudicatedBackButton = By.id("back-container");
    public final By reasonComment = By.xpath("//textarea");
    public final By invalidButton = By.xpath("//button[@id='invalid-btn']");
    public final By retestButton = By.xpath("//button[@id='retest-btn']");
    public final By certifySubmitButton = By.xpath("//button[contains(text(), 'Sign and Submit')]");
    public final By signAndSubmitButton = By.xpath("//button[@id='sign-btn']");
    public final By adjudicateInconclusivebutton = By.xpath("//button[@id='incon-btn']");
    public final By adjudicateClearButton = By.id("clear-btn");
    public final By adjudicateRetestButton = By.id("retest-btn");
    public final By adjudicateAbandonedButton = By.id("refuse-btn");
    public By noCandidateMessage = By.xpath("//div[contains(text(),'There are currently no candidates being screened') and @id='no-candidate']");
    public final By invertedSwitch = By.xpath("//label[contains(@class,'custom-control-label')]");
    public final By abandonedProcessButton = By.xpath("//button[@id='refuse-btn']");
    public final By adminSpecimenYesButton = By.xpath("//button[contains(text(),'Yes')]");
    public final By adminSpecimenNoButton = By.xpath("//button[contains(text(),'No')]");
    public By adjudicatingScreen = By.xpath("//span[contains(text(),'Adjudicating')]");
    public By adminUIHeader = By.xpath("//*[contains(text(),' Admin UI ')]");
    public By adminUIsignInPage = By.xpath("//button[text()='Sign in']");
    public By amznRoomAdmin = By.id("AMZNRoomAdmin");
    public By amznSuperUser = By.id("AMZNSuperUser");
    public final By btnLogin = By.id("login-button");
    public final By manageOrdersMenu = By.xpath("//a[contains(text(),'Manage Orders')]");
    public final By chooseAnotherLocationMenu = By.xpath("//a[contains(text(),'Choose Another Location')]");
    public final By orderNextButton = By.id("submit-button");
    public final By orderPreviousButton = By.id("previous-button");
    public final By orderCity = By.xpath("//input[@id='city']");
    public By orderLocationScreen = By.xpath("//h2[contains(text(), 'Location Information')]");
    public final By orderStateSelector = By.xpath("//select[@id='state']");
    public By orderCountrySelector = By.xpath("//select[@id='country']");
    public final By orderPackageSelector = By.xpath("//select[@id='orderPackageId']");
    public final By orderPackageReasonSelector = By.xpath("//select[@id='reasonForTest']");
    public By orderContactScreen = By.xpath("//h2[contains(text(), 'Contact Information')]");
    public By orderPackageScreen = By.xpath("//h2[contains(text(), 'Package Information')]");
    public By orderResidenceScreen = By.xpath("//h2[contains(text(), 'Residence Information')]");
    public By orderIdentificationInvalidCID = By.xpath("//div[@class='invalid-feedback']");
    public By orderIdentificationScreen = By.xpath("//h2[contains(text(), 'Identification Information')]");
    public By sideAlleyCoCPhotoRulesScreen = By.xpath("//*[contains(text(),'Photo Rules')]");
    public By getSideAlleyCoCuploadPhotoScreen = By.xpath("//span[contains(text(),'Upload a photo of your COC form')]");
    public By locationInformationPageTitle = By.xpath("//h2[contains(text(),'Location Information')]");
    public final By orderAddressLine1 = By.xpath("//input[@id='line1']");
    public final By orderAddressLine2 = By.xpath("//input[@id='line2']");
    public final By orderPostalCode = By.xpath("//input[@id='zip']");
    public final By orderPhoneNumber = By.xpath("//input[@id='phoneNumber']");
    public final By orderEmailAddress = By.xpath("//input[@id='emailAddress']");
    public By orderPhoneNumberFeedback = By.id("phoneNumber-feedback");
    public By orderEmailAddressFeedback = By.id("emailAddress-feedback");
    public By orderCreateAnotherMsg = By.xpath("//p[contains(text(),'Would you like to look up another candidate?')]");
    public final By orderCreateAnotherButton = By.xpath("//button[contains(text(),'Start new candidate look up')]");
    public By getStartedPage = By.xpath("//*[contains(text(), 'get started')]");
    public By placeOrdersPage = By.xpath("//div[contains(text(), 'Place Orders')]");
    public By bulkOrdersPage = By.xpath("//h1[contains(text(), 'Bulk Orders')]");
    public final By orderExitButton = By.xpath("//button[contains(text(),'Exit')]");
    public final By cocConversionMenu = By.xpath("//a[contains(text(),'CoC Conversion')]");
    public final By orderLookupLastName = By.id("lastNameId");
    public final By orderLookupBirthMonth = By.id("monthId");
    public final By orderLookupBirthDay = By.id("dayId");
    public final By orderLookupBirthYear = By.id("yearId");
    public final By orderLookupSsn = By.id("ssnId");
    public final By orderGetStartedButton = By.name("submitButton");
    public final By orderUseIdButton = By.xpath("//button[contains(text(),'Use this ID')]");
    public By orderTryAnotherButton = By.xpath("//button[contains(text(),'Try another ID')]");
    public By orderPhotoRulesPage = By.xpath("//*[contains(text(),'Photo Rules')]");
    public By sideAlleyPhotoRulesScreen = By.xpath("//*[contains(text(),'Photo Rules')]");
    public By sideAlleyCandidateResultsScreen = By.xpath("//*[contains(text(),'Candidate Result')]");
    public By orderCandidateNotFound = By.xpath("//*[contains(text(),'Candidate not found')]");
    public final By createNewOrderButton = By.xpath("//button[contains(text(),'Create new order')]");
    public By orderCompleted = By.xpath("//h1[contains(text(),'Order Submitted')]");
    public final By orderIdentificationCID = By.id("candidateId");
    public final By orderIdentificationFName = By.id("firstName");
    public final By orderIdentificationLName = By.id("lastName");
    public final By orderIdentificationSSN = By.xpath("//input[@id='ssn']");
    public final By orderIdentificationDoB = By.id("dateOfBirth");
    public final By orderIdentificationEmpIDLabel = By.xpath("//label[text()='Employee ID Number']");
    public final By orderIdentificationCIDLabel = By.xpath("//label[text()='Candidate ID Number']");
    public final By orderIdentificationEmpID = By.id("employeeId");
    public final By orderIdentificationEmpIDErrorMsg = By.id("employeeId-feedback");
    public final By sideAlleyUploadSubmitButton = By.xpath("//button[contains(text(), 'Submit Photo')]");
    public By cocPhotoRulesScreen = By.xpath("//header[contains(text(),'Chain of Custody Photo Rules')]");
    public By cocReviewPhotoScreen = By.xpath("//*[contains(text(),'Review your photo')]");
    public By cocBackButton = By.xpath("//button[contains(text(),'Back')]");
    public final By switchToThisButton = By.id("switch-to-recommendation-btn");
    public final By keepThisButton = By.id("keep-my-results-btn");
    public By adminUIplacedOrders = By.xpath("//a[contains(text(),'Placed Orders')]");
    public final By adminUIcreateNewOrders = By.xpath("//a[contains(text(),'Create New Order')]");
    //this is the create new order button on the Candidate Order Not Found Page
    public By createNewOrderButtonOnNotFound = By.xpath("//button[contains(text(),'Create new order')]");
    public By adminUIbulkOrders = By.xpath("//a[contains(text(),'Bulk Orders')]");
    public By adminPlacedOrdersHeader = By.xpath("//h1[contains(text(),'Placed Orders')]");
    public By orderIdentificationInvalidDoBMessage = By.xpath("//div[contains(text(),'Please enter a valid Date of Birth in the form mm/dd/yyyy.')]");
    public By orderIdentificationInvalidSSNmessage = By.id("ssn-feedback");
    public final By adminUIchatWindow = By.xpath("//span[contains(text(),'Chat with an Expert')]");
    public final By adminUIViewOrderButton = By.xpath("//a[contains(text(),'View This Order')]");
    public final By orderDoneButton = By.xpath("//a[@id='done-button']");
    public By orderInvalidSubmitConfirmationScreen = By.xpath("//h1[contains(text(),'Looks like there was a problem')]");
    public final By submitInvalidOrderConfCreateNewOrderButton = By.xpath("//a[@id='error-new-order-button']");
    public final By submitInvalidOrderConfRetrySubmittingButton = By.xpath("//a[@id='error-retry-button']");
    public final By sideAlleyTakePhotoButton = By.xpath("//button[@class='btn button btnActive']");
    public final By sideAlleyCoCTakePhotoButton = By.xpath("//button[contains(text(),'ready to take the photo')]");
    public final By submitOrderConfDoneButton = By.xpath("//a[@id='done-button']");
    public final By submitOrderConfCreateNewButton = By.xpath("//a[@id='new-order-button']");
    public final By sideAlleyTestLocationSelector = By.xpath("//select[@id='testLocation']");
    public final By sideAlleyInconclusiveOption = By.xpath("//input[@value='Inconclusive']");
    public final By sideAlleyNegativeOption = By.xpath("//input[@value='Negative']");
    public final By sideAlleyInvalidOption = By.xpath("//input[@value='Invalid']");
    public By sideAlleyUploadSuccessfulOrderSubmitted = By.xpath("//p[contains(text(),'Upload Successful')]");
    public final By orderNameFilterTextbox = By.xpath("//input[@placeholder='Name']");
    public final By orderIdFilterTextbox = By.xpath("//input[@placeholder='Order ID']");
    public final By orderSsnFilterTextbox = By.xpath("//input[@placeholder='SSN']");
    public final By clearNewStatusFilterX = By.xpath("//span[contains(text(),'New')]/preceding::span[1]");
    public final By placedOrdersDatePicker = By.xpath("//input[@placeholder='Daterangepicker']");
    public final By placedOrderStatusFilter = By.xpath("//ng-select[@placeholder='Statuses']");
    public final By sideAlleyBackButton = By.xpath("//button[@name='backButton'] | //button[contains(text(),'Back')]");
    public By sideAlleyEnrollmentCompleteMsg = By.xpath("//p[contains(text(),'You have already completed the manual enrollment')]");
    public final By sideAlleyNextButton = By.xpath("//button[contains(text(),'Next')]");
    public final By sideAlleySelectLocationScreen = By.xpath("//*[contains(text(),'Select the testing')]");
    public final By sideAlleyNextButtonSelectLocationScreen = By.xpath("//button[contains(text(),'Next')]");
    public By SideAlleyPhotoRulesPage = By.xpath("//*[contains(text(),'Photo Rules')]");
    public final By sideAlleyGetStartedButton = By.xpath("//button[@name='submitButton']");
    public final By sideAlleyIamHappyWithMyPhotoButton = By.xpath("//button[@class='button btnActive']");
    public final By sideAlleyIamHappyWithMyCoCPhotoButton = By.xpath("//button[@class='btn button btnActive']");
    public By sideAlleyReviewScreen = By.xpath("//*[contains(text(),'Review')]");
    public final By sideAlleyAdjudicationSubmitButton = By.xpath("//button[contains(text(),' Submit ')]");
    public By sideAlleyOrderSubmittedScreen = By.xpath("//*[contains(text(),'Order Submitted')]");
    //this element is for uploading the photo screen
    public By sideAlleyUploadPhotoScreen = By.xpath("//*[contains(text(),'Upload photo')]");
    public By sideAlleyGetStartedScreen = By.xpath("//*[contains(text(),'get started')]");
    public By sideAlleyinvalidDeviceErrorMsg = By.xpath("//p[contains(text(),'Collection device is invalid. Please use a valid device.')]");
    public By sideAlleyDuplicateErrorMessage = By.xpath("//p[contains(text(),'SubmitImage - Collection device has already been used. Please use a valid device.')]");
    public By sideAlleyReviewYourPhotoPage = By.xpath("//*[contains(text(),'Review your photo')]");
    public final By sideAlleyRetakePhotoButton = By.xpath("(//button[@class='btn button'])[2]");
    public final By sideAlleyUploadPhotoButton = By.xpath("//span[contains(text(),'Upload Photo')]");
    public final By sideAlleyEnterSpecimenIDButton = By.xpath("//button[@class='btn button']");
    public By sideAlleySampleIdScreen = By.xpath("//img[contains(@src, 'test-kit')]");
    public final By sideAlleySampleIdTextBox = By.xpath("//input[@id='sampleIdId']");
    public final By sideAlleyConfirmSampleIdTextBox = By.xpath("//input[@id='confirmSampleId']");
    public final By sideAlleyNextButtonOnEnterIDScreen = By.xpath("//button[@class='btn button btnActive']");
    public By adminIncompleteOrder = By.xpath("//td[contains(text(),'Incomplete')]");
    private CreateOrderWrapper createOrderWrapper = null;
    public By sideAlleyResultsBackButton = By.xpath("//button[@name='backButton']");
    public By sideAlleyResultsNextButton = By.xpath("//button[@name='submitButton']");
    public By sideAlleyGetStartedAllFieldsError = By.xpath("//*[contains(text(),'All fields are required to get started')]");
    public By sideAlleyGetStartedBDateError = By.xpath("//*[contains(text(),'Date of Birth not valid')]");
    public By sideAlleyGetStartedSSNError = By.xpath("//*[contains(text(),' Please provide the last 4 digits of your Social Security Number')]");
    public final By adminUIRetakeButton = By.xpath("//button[contains(text(), 'Re-take')]");
    public final By adminPlacedOrderSSNsortingArrow = By.xpath("//span[contains(text(),'SSN')]");
    public final By adminPlacedOrderCreatedSortingArrow = By.xpath("//span[contains(text(),'Created')]");
    public By AdminUINewPageTitle = By.xpath("//*[contains(text(),'Drug Testing Center')]");
    public By adminPlacedOrdersPage = By.xpath("//a[contains(text(), 'Placed Orders')]");
    public final By adminBulkUploadButton = By.xpath("//a[contains(text(), 'Bulk Upload')]");
    public final By adminBulkUploadSubmitButton = By.xpath("//button[@name='submitButton']");
    public final By adminBulkReasonForTestSelector = By.xpath("//select[@id='selectReasonForTest']");
    public final By adminBulkPackageSelector = By.xpath("//select[@id='selectPackage']");
    public final By bulkUploadPackageSelector = By.xpath("//ng-Select[@placeholder='Packages']");
    public final By bulkUploadStatusSelector = By.xpath("//ng-Select[@placeholder='Bulk Upload Status']");
    public final By bulkUploadDateRangeSelector = By.xpath("//input[contains(@placeholder, 'mm/dd/yyyy')]");
    public By bulkSpreadsheetUploadScreen = By.xpath("//div[contains(text(),'Bulk Spreadsheet Upload')]");
    public By bulkUploadInvalidFileFormatMsg = By.xpath("//p[contains(text(),' Unsupported file format. Please select a .csv ')]");
    public final By bulkUploadDetailsIcon = By.xpath("//table/tbody/tr/td[3]/following::i");
    public By bulkUploadItemDetailsScreen = By.xpath("//h2[contains(text(),'Item Details')]");
    public final By bulkUploadItemDetailsBackButton = By.xpath("//button[@type='button']");
    public final By bulkUploadGetErrorFileLink = By.xpath("//div[@class='error-file-link']");
    public By adminClearSignaturePage = By.xpath("//*[contains(text(),'Certify ')]");
    public By adminRetestSignaturePage = By.xpath("//*[contains(text(),'Select a reason and certify')]");
    public By adminSalariedLeaderPopUp = By.xpath("//*[contains(text(),'Contact your salaried leader ')]");
    public final By adminSLeaderPopUpProceedBtn = By.xpath("//*[contains(text(),'Proceed')]");
    public final By adminSLeaderName = By.id("leader-name-input");
    public final By adminSLeaderComment = By.id("comment");
    public By adminFinalResultSelectPage = By.xpath("//*[contains(text(),'Final Test Result Selection')]");
    public By adminFinalResultSelectAlcPage = By.xpath("//*[contains(text(),' Selection - Alcohol')]");
    public By adminCertifyTestResultsPage = By.xpath("//div[contains(text(),'Certify Inconclusive')]");
    public By adminFourEyesCheckPage = By.xpath("//*[contains(text(),'Four Eyes Check')]");
    public By adminViewExampleClearBtn = By.xpath("//*[@id='view-negative-example-btn'] ");
    public By adminViewExampleInconclusiveBtn = By.xpath("//*[@id='view-inconclusive-example-btn']");
    public By adminViewExampleRetestBtn = By.xpath("//*[@id='view-invalid-example-btn']");
    public By adminClearExamplesPage = By.id("negative");
    public By adminInconclusiveExamplesPage = By.id("inconclusive");
    public By adminRetestExamplesPage = By.id("invalid");
    public By adminExampleCloseBtn = By.id("close-example-modal-button");
    public By adminAmazonAlias = By.id("alias");
    public By adminAmazonAliasErrorMsg = By.id("alias-feedback");
    public By adminLandingPageLocationFilter = By.id("searchAlias");
    public By adminLandingPageStateFilter = By.id("searchState");
    public By adminLandingPageLocationField = By.xpath("//amzn-location//b[text()='Location ']");
    public By adminLandingPageStateField = By.xpath("//amzn-location//b[text()='State ']");
    public By adminLocationsLandingPage = By.xpath("//amzn-location//b[contains(text(),'Recent Locations:')]");
    public By adminTrackingInformationPage = By.xpath("//*[contains(text(),'Tracking Information')]");
    public By adminCarrierSelector = By.id("shipper");
    public By adminTrackingNumber = By.id("trackingNumber");
    public final By adminUIUserGuide = By.xpath("//span[@id='user-guide']");
    public final By adminUIVersionNumber = By.xpath("//div[@class='mr-5 float-right d-none d-lg-block']");
    public By adminLandingPageErrorMsg = By.xpath("//i[text()='No Matching Locations Found']");
    public By adminInvalidOrder = By.xpath("(//td[contains(text(),'Invalid')])[1]");
    public By adminInProgressOrder = By.xpath("(//td[contains(text(),'In Progress')])[1]");
    public By sideAlleyAllFieldsAreRequiredError = By.xpath("//*[contains(text(),'All fields are required to go next')]");
    public By sideAlleySpecimenIDFormatError = By.xpath("//*[contains(text(),' Sample ID is either 8 digits or two alpha + 9 digits')]");
    public By sideAlleySpecimenIDsNotMatchingError = By.xpath("//*[contains(text(),'Oops! Your entries do not match. Please try again')]");
    public By adminModifiedAdjudicationRetestBtn = By.xpath("//button[@id='retest-btn']");
    public By adminModifiedAdjudicationValidBtn = By.id("valid-btn");
    public By adminModifiedAdjudicationCertifyBtn = By.id("sign-btn");
    public By adminModifiedAdjudicationPageTitle = By.xpath("//span[contains(text(),'Validating')]");
    public By adminModifiedAdjudicationModalConfirmBtn = By.xpath("//h4[contains(text(),'Confirm')]");
    public By adminModifiedAdjudicationCertifySignPage = By.xpath("//h2[contains(text(),'Please certify')]");
    public By adminDashboardButton = By.xpath("//div[@id='go-to-dashboard-container']");
    public By adminAlcoholAdjudicationPage = By.xpath("//div[contains(text(),'Alcohol Test')]");
    public By adminAlcoholCertifyClearPage = By.xpath("//div[contains(text(),'Certify Clear Test Results')]");
    public By alcoholFlowNextBtn = By.id("next-button");
    public By applicantStartOverPage = By.xpath("//p[contains(text(),'Start Over')]");
    public By certifyClearDeviceImage = By.id("testing-pic");
    public By certifyClearAlcoholResults = By.xpath("//form[@class='form-container ng-untouched ng-pristine ng-valid']");
    public By certifyClearText = By.xpath("//p[@class='text-left']");
    public final By supportToolsMenu = By.xpath("//a[contains(text(),'Support Tool')]");
    public By adminSupportToolsPage = By.xpath("//span[contains(text(),'Support Tool')]");
    public By adminSupportToolsPageSearchByName = By.id("nameSearch");
    public By adminSupportToolsPageSearchByDeviceID = By.xpath("//input[@placeholder='Search by Device ID']");
    public By adminSupportToolsPageZeroResultFoundErrorMsg = By.xpath("//th[contains(text(),' 0 results for')]");
    public final By adminNameFieldSupportTools = By.xpath("//table[@class='table table-striped']/tbody/tr/td[1]");
    public final By WAIdSupportTool = By.xpath("//input[@id='Wellnessid']");
    public final By adminSaveChangesSupportTool = By.xpath("//button[@id='save-button']");
    public By adminSaveChangesSuccessfullyMessage = By.xpath("//div[contains(text(),'Changes Saved Successfully!')]");
    public By adminSupportToolsResultsPageLastUpdated = By.xpath("//div[@class='flex-column']/p[2]");
    public By adminSupportToolsResultsPageDeviceID = By.xpath("//p[contains(text(),'Device ID')]/following-sibling::p");
    public By adminSupportToolsResultsPageCurrentStatus = By.xpath("//div[@class='row-sm-4'][2]/label[1]");
    public By adminSupportToolsResultsPageCurrentStep = By.xpath("//div[@class='row-sm-4'][2]/label[2]");
    public By adminSupportToolsResultsPageCurrentStepDropDown = By.xpath("//div[@class='row-sm-4'][2]/select");
    public final By currentStepSelector = By.xpath("//select[@id='new-status-step']");
    public final By backToResultsButton = By.xpath("//div[@class='offset-1 col-sm-4']/div/p");
    public By adminSupportToolsSearchPageCurrentStep = By.xpath("//table[@class='table table-striped']/tbody/tr/td/span[contains(text(),'Retake Photo')]");
    public By businessLine = By.xpath("//select[@id='businessLine']");
    public By numberOfTestUsedPage = By.xpath("//div[contains(text(),'Total Number of Devices Used')]");
    public By numberOfDrugTestKitsUsed = By.xpath("//div/form/div/select");
    public By adminUINxtBtn=By.id("next-button");
    public By adminNumberOfAlcStripsUsed = By.xpath("(//div/form/div/select)[2]");

    //Web Elements

    @FindBy(id = "next-button")
    public WebElement alcoholFlowNextButtonWebElement;

    @FindBy(xpath = "//signature-pad[@id='sigPad']/canvas")
    public WebElement signaturePad;

    @FindBy(id = "header-menu")
    public WebElement weMenu_WebElement;

    @FindBy(xpath = "(//div/span)[1]")
    public WebElement locationTitleWE;

    @FindBy(xpath = "//select/option")
    public List<WebElement> invalidOptions;

    @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> sideAlleyResultsScreenHeader;

    @FindBy(xpath = "//table//td[2]")
    public List<WebElement> sideAlleyResultsLNameList;

    @FindBy(xpath = "//table//td[5]")
    public WebElement sideAlleyResultsOrderLocation;

    @FindBy(xpath = "//tbody/tr/td")
    public List<WebElement> getSideAlleyCandidateResultRow;

    @FindBy(xpath = "//div[@class='col']/a")
    public List<WebElement> adminLandingPageLocationSearchResults;

    @FindBy(xpath = "//div[@class='row row-striped odd']/div[2]")
    public List<WebElement> adminLandingPageStateSearchResults1;

    @FindBy(xpath = "//div[@class='row row-striped even']/div[2]")
    public List<WebElement> adminLandingPageStateSearchResults2;

    @FindBy(xpath = "//button[@id='incon-btn']")
    public WebElement adjInconclusiveWebElementButton;

    @FindBy(id = "clear-btn")
    public WebElement adjClearButtonWebElement;

    @FindBy(id = "retest-btn")
    public WebElement adjRetestButtonWebElement;

    @FindBy(id = "testing-pic")
    public WebElement adjudicateDeviceImage_WebElement;

    @FindBy(xpath = "//label[contains(@class,'custom-control-label')]")
    public WebElement invertedSwitchWebElement;

    @FindBy(xpath = "//h3[contains(text(),'Order has been successfully submitted.')]")
    public WebElement submitValidOrderConfirmationMessage;

    @FindBy(xpath = "//select/option")
    public List<WebElement> abandonOptions;

    @FindBy(xpath = "//div[contains(text(), 'might be')]/following::div[@class='drug-rect white-color']")
    public List<WebElement> whiteNegativeRecStrips;

    @FindBy(xpath = "//p[contains(text(),'Specimen ID')]/following::h1")
    public WebElement specimenId_WebElement;

    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    public WebElement adminSpecimenYesButton_WebElement;

    @FindBy(xpath = "//button[contains(text(),'No')]")
    public WebElement adminSpecimenNoButton_WebElement;

    @FindBy(xpath = "//select[@id='orderPackageId']")
    public WebElement orderPackageWElementSelector;

    @FindBy(xpath = "//select[@id='businessLine']")
    public WebElement orderBusinessLineWE;

    @FindBy(xpath = "//select[@id='reasonForTest']")
    public WebElement orderPackageReasonWESelector;

    @FindBy(xpath = "//option[contains(text(),'Pre-employment')]")
    public WebElement orderPackageReasonPreWE;

    @FindBy(id = "submit-button")
    public WebElement orderNextWebElementButton;

    @FindBy(id = "firstName")
    public WebElement orderFirstNameWebElement;

    @FindBy(id = "lastName")
    public WebElement orderLastNameWebElement;

    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement orderSsnWebElement;

    @FindBy(xpath = "//input[@id='dateOfBirth']")
    public WebElement orderDobWebElement;

    @FindBy(id = "candidateId")
    public WebElement orderCandidateIdWebElement;

    @FindBy(id = "employeeId")
    public WebElement orderIdentificationEmpIDWE;

    @FindBy(id = "phoneNumber")
    public WebElement orderPhoneNumberWebElement;

    @FindBy(xpath = "//input[@id='line1']")
    public WebElement orderAddressLine1WebElement;

    @FindBy(id = "emailAddress")
    public WebElement orderEmailAddressWebElement;

    @FindBy(xpath = "//*[@id='scan-information']")
    public WebElement lastScannedDetailsWebElement;

    @FindBy(xpath = "//div[@class='drug-rect orange-color']")
    public List<WebElement> postiveTestStripsOnResult;

    @FindBy(xpath = "//table/tbody/tr[1]")
    public List<WebElement> firstRowTableData;

    @FindBy(xpath = "//button[@id='refuse-btn']")
    public WebElement abandonedButtonWebElement;

    @FindBy(xpath = "//span/preceding::span[@class='ng-value-icon left'][1]")
    public List<WebElement> selectedStatuses;

    @FindBy(xpath = "//span[@class='ng-option-label']")
    public List<WebElement> placeOrderStatusesWebElement;

    @FindBy(xpath = "//table//tr")
    public List<WebElement> placeOrderTableRows;

    @FindBy(xpath = "//table//tr/td[1]")
    public List<WebElement> placedOrderNames;

    @FindBy(xpath = "//table//tr/td[4]")
    public List<WebElement> placedOrderDateTimes;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    public WebElement sideAlleyNextButtonWebElement;

    @FindBy(xpath = "//button[@class='btn button btnActive']")
    public WebElement sideAlleyIamHappyCoCPhotoBtnWE;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement uploadCOCPhotoAreaWebElement;

    @FindBy(xpath = "//input[@class='form-control uploadbutton']")
    public WebElement uploadPhotoSideAlleyAreaWebElement;

    @FindBy(xpath = "//input[@id='lastNameId']")
    public WebElement candidateLookupLastNameWebElement;

    @FindBy(xpath = "//input[@id='monthId']")
    public WebElement candidateLookupMonthWebElement;

    @FindBy(xpath = "//input[@id='dayId']")
    public WebElement candidateLookupDayWebElement;

    @FindBy(xpath = "//input[@id='yearId']")
    public WebElement candidateLookupYearWebElement;

    @FindBy(xpath = "//input[@id='ssnId']")
    public WebElement candidateLookupSsnWebElement;

    @FindBy(xpath = "//table[@class='table table-striped']/thead/tr/th")
    public List<WebElement> adminPlacedOrdersTableTitles;

    @FindBy(xpath = "//a[contains(text(),'Create New Order')]")
    public WebElement createNewOrderOnSubmitWebElement;

    @FindBy(xpath = "//button[@name='submitButton']")
    public WebElement sideAlleyGetStartedButtonWE;

    @FindBy(xpath = "//table/tbody/tr/td[2]")
    public List<WebElement> placedOrdersSSNcolumn;

    @FindBy(xpath = "//table/tbody/tr/td[4]")
    public List<WebElement> adminPlacedOrderChronologicalOrder;

    @FindBy(xpath = "//table/tbody/tr/td[4]")
    public List<WebElement> adminBulkOrderChronologicalOrder;

    @FindBy(xpath = "//table//tbody/tr")
    public List<WebElement> bulkOrdersListRows;

    @FindBy(xpath = "//table/tbody/tr/td[1]")
    public List<WebElement> bulkOrderUploadStatusColumnRows;

    @FindBy(xpath = "//select[@id='selectPackage']/option[contains(text(),'Choose a Package')]")
    public WebElement bulkUploadPackageDefaultTextWebElement;

    @FindBy(xpath = "//select[@id='selectReasonForTest']/option[contains(text(),'Choose a Reason For Test')]")
    public WebElement bulkUploadChooseReasonDefaultTextWebElement;

    @FindBy(xpath = "//button[@name='submitButton']")
    public WebElement bulkUploadAdminUISubmitButtonWebElement;

    @FindBy(xpath = "//div/h3[contains(text(),'Error Orders')]/following::div[1]")
    public WebElement bulkUploadItemDetailsStatusWebElement;

    @FindBy(xpath = "//div[@class='error-summary']")
    public WebElement bulkUploadItemDetailErrSumWebElement;

    @FindBy(xpath = "//div[@class='order-detail']")
    public WebElement bulkUploadItemOrderDetailsWebElement;

    @FindBy(xpath = "//button[contains(text(),'Sign and Submit')]")
    public WebElement adminFourEyesCheckCertifyBtnWE;

    @FindBy(xpath = "//*[@id='view-negative-example-btn']")
    public WebElement adminViewExampleClearWE;

    @FindBy(xpath = "//*[@id='view-inconclusive-example-btn']")
    public WebElement adminViewExampleInconclusiveWE;

    @FindBy(xpath = "//*[@id='view-invalid-example-btn']")
    public WebElement adminViewExampleRetestWE;

    @FindBy(id = "alias")
    public WebElement adminAmazonAliasWE;

    @FindBy(id = "trackingNumber")
    public WebElement adminTrackingNumberWE;

    @FindBy(id = "searchAlias")
    public WebElement adminLandingPageLocationFilterWE;

    @FindBy(id = "searchState")
    public WebElement adminLandingPageStateFilterWE;

    @FindBy(xpath = "//b[contains(text(),'Recent Locations:')]/following::div[@class='col-md-2']/a")
    public List<WebElement> adminRecentLocations;

    @FindBy(xpath = "//button[@id='view-valid-example-btn']")
    public WebElement adminModifiedViewExampleValidWE;

    @FindBy(xpath = "//button[@id='view-retest-example-btn']")
    public WebElement adminModifiedViewExampleRetestWE;

    @FindBy(xpath = "//button[@id='retest-btn']")
    public WebElement adminModifiedAdjudicationRetestWE;

    @FindBy(id = "valid-btn")
    public WebElement adminModifiedAdjudicationValidWE;

    @FindBy(xpath = "//button[@id='sign-btn']")
    public WebElement adminModifiedAdjudicationCertifyBtnWE;

    @FindBy(xpath = "//h4/following-sibling::p")
    public WebElement adminFinalTestResult4EyesSelection;

    @FindBy(id = "nameSearch")
    public WebElement adminSupportToolsPageSearchByNameWE;

    @FindBy(xpath = "//td[@class='a']/a")
    public List<WebElement> adminSupportToolsPageCandidateNameSearchResults;

    @FindBy(xpath = "//table[@class='table table-striped']/thead/tr/th")
    public List<WebElement> adminSupportToolsTableTitles;

    @FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[3]")
    public List<WebElement> adminSupportToolsPageDeviceIDSearchResults;

    @FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[1]")
    public WebElement adminNameFieldSupportTools_WebElement;

    @FindBy(xpath = "//button[@id='save-button']")
    public WebElement adminSaveChangesSupportTool_WebElement;

    @FindBy(xpath = "//div[@class='flex-column']/h2")
    public List<WebElement> adminCandidateResultsPageCandidateNameWE;

    @FindBy(xpath = "//select[@id='new-status-step']")
    public WebElement currentStepWESelector;

    @FindBy(xpath = "//textarea[@id='json']")
    public List<WebElement> adminSupportToolsCandidateNameOnTheJSON;

    //    Return Methods
    public By pastHourButton(String text) {
        String button = String.format("//button[contains(text(),'%s')]", text);
        return By.xpath(button);
    }

    public int getAbandonReasonOptionsCount() {
        return abandonOptions.size();
    }

    private By getCandidateCard(String name) {
        String[] fullName = name.split(" ");
        String lName = fullName[1];
        logger.info("Candidate's full Name: " + name);
        logger.info("Candidate Card: " + lName);
        return By.xpath("//amzn-candidate-card//*[contains(text(),'" + lName + "')]/following::div[@class='action-flag'][1]");
    }

    private By getEACandidateCard(String name) {

        return By.xpath("//amzn-candidate-card//*[contains(text(),'" + name + "')]/following::div[@class='action-flag'][1]");
    }

    public Boolean isCandidateCardPresent(String name) {
        logger.info("last name to find:" + name);
        return exists(getCandidateCard(name));
    }

    private WebElement getCandidateCardByWebElement(String name) {
        String xpath = "//amzn-candidate-card//*[contains(text(),'" + name + "')]";
        return driver.findElement(By.xpath(xpath));
    }

    public By reasonOption(String reason) {
        String xpath = String.format("//select/option[contains(text(),'%s')]", reason);
        return By.xpath(xpath);
    }

    public By businessLineOption(String businessLine) {
        String xpath = String.format("//select/option[contains(text(),'%s')]", businessLine);
        return By.xpath(xpath);
    }

    public By randomReasonOption() {
        int num = (int) (Math.random() * 2 + 1);
        String number = "" + num;
        String xpath = String.format("//select/option['%s']", number);
        return By.xpath(xpath);
    }

    public String getApplicantStepByName(String name) {
        By card = By.xpath("(//div[@class='candidate-card']/div[text()='" + name + "']/../div[@class='subpanel-container']/div[@class='card-subpanel'])[1]");
        WebElement we = driver.findElement(card);
        return we.getText();
    }

    public String getApplicantBoothByName(String name) {
        By card = By.xpath("//div[@class='candidate-card']/div[text()='" + name + "']/../div[@class='subpanel-container']/div[@class='card-subpanel id-container']");
        WebElement we = driver.findElement(card);
        return we.getText();
    }

    private String calculatePreviousDays(int daysPrior) {
        Calendar cal = Calendar.getInstance();
        //subtracting days
        cal.add(Calendar.DATE, daysPrior);

        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMMM d, yyyy", Locale.US);
        Date date = cal.getTime();
        return formatter.format(date);
    }

    private String getCurrentDateforFilter() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMMM d, yyyy", Locale.US);
        Date date = new Date();
        return formatter.format(date);
    }

    public By testResultReturned(String numberCount) {
        return By.xpath("//p[contains(text(),'" + numberCount + " Tests Returned in Past 24 Hours')]");
    }

    public By resultsPagination(String pageNumber) {
        String xpath = String.format("//a/span[contains(text(),'%s')]", pageNumber);
        return By.xpath(xpath);
    }

    public int getInvalidReasonOptionsCount() {
        return invalidOptions.size();
    }

    public boolean isCertifySubmitButtonEnabled() {
        String xpath = "//button[contains(text(), 'Sign and Submit')]";
        return driver.findElement(By.xpath(xpath)).isEnabled();
    }

    private By getDateRangeLabel(String dateLabel) {
        String formatDateLabel = String.format("//div[@aria-label='%s']", dateLabel);
        return By.xpath(formatDateLabel);
    }

    public By candidateCardElementFNameOnly() {
        String currentCandidate = getCandidateName();
        List<String> fullName = Arrays.asList(currentCandidate.split(" "));
        String fName = fullName.get(0);
        report("Current Candidate: " + currentCandidate);
        return By.xpath("//amzn-candidate-card//*[contains(text(),'" + fName + "')]");
    }

    public By candidateGreenCardByFirstName(String candidateFirstName) {
        String xpath = String.format("//div[@class='bg-green candidate-card']/div[contains(text(),'%s')]", candidateFirstName);
        return By.xpath(xpath);
    }

    public int countDrugCollection() {
        return driver.findElements(drugCollectionCheckbox).size();
    }


    public boolean isOrderNextButtonEnabled() {
        return orderNextWebElementButton.isEnabled();
    }

    public boolean isAdminUIBulkOrderSubmitButtonEnabled() {
        return bulkUploadAdminUISubmitButtonWebElement.isEnabled();
    }


    public String getLastScannedDetails() throws Exception {
        return getText(lastScannedDetailsWebElement);
    }


    public int adminUITabCount() {
        return driver.findElements(By.xpath("//amzn-dashboard//*/a")).size();
    }


    public boolean textExists(String text) {
        String xpath = String.format("//*[contains(text(),'%s')]", text);
        return exists(By.xpath(xpath));
    }

    public int verifyAllNegativeTestStrips() {
        return whiteNegativeRecStrips.size();
    }

    public int howManyPositiveStripsOnResult() {
        return postiveTestStripsOnResult.size();
    }


    public Boolean isValueInTableRow(String... valueToFind) throws Exception {
        for (WebElement element : firstRowTableData) {
            logger.info("Looking for value.... " + getText(element));
            if (getText(element).contains(valueToFind[0])) {
                logger.info(valueToFind[0] + " was found.");
                return true;
            }
        }
        return false;
    }


    public Boolean isBulkUploadColumnHeaderPresent(String... values) {
        for (String value : values) {
            String xpath = String.format("//table//th//span[contains(text(),'%s')]", value);
            logger.info("checking value: " + value);
            return exists(By.xpath(xpath));
        }
        return false;
    }

    public String getBulkUploadStatusText(String fileNameUploaded) throws Exception {
        String xpath = String.format("//td[contains(text(),'%s')]/preceding::td", fileNameUploaded);
        WebElement element = driver.findElement(By.xpath(xpath));
        return getText(element);
    }


    public String getBulkUploadItemDetailsStatus() throws Exception {
        return getText(bulkUploadItemDetailsStatusWebElement);
    }

    public String getBulkUploadItemDetailsErrorSummary() throws Exception {
        return getText(bulkUploadItemDetailErrSumWebElement);
    }

    public String getBulkUploadItemOrderDetails() throws Exception {
        return getText(bulkUploadItemOrderDetailsWebElement);
    }

    public String verifyBatchUploadErrorsInXlsCsvFile() throws Exception {
        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);
        return sharedBaseClass.verifyMessageInXls();
    }

    public Boolean bulkUploadPackageSelectionDisplayed() throws Exception {
        waitForElementPresent(bulkUploadPackageDefaultTextWebElement);
        return bulkUploadPackageDefaultTextWebElement.isDisplayed();
    }

    public Boolean bulkUploadReasonSelectionDisplayed() throws Exception {
        waitForElementPresent(bulkUploadChooseReasonDefaultTextWebElement);
        return bulkUploadChooseReasonDefaultTextWebElement.isDisplayed();
    }


//    *** void methods************************

    public void enterIdentificationFName(String fName) throws Exception {
        waitForElementPresent(orderFirstNameWebElement);
        setElementValue(orderIdentificationFName, fName);
        testObject.setTestData("orderAdminUIFirstName", fName);
    }

    public void enterIdentificationLName(String lName) throws Exception {
        waitForElementPresent(orderLastNameWebElement);
        setElementValue(orderIdentificationLName, lName);
        testObject.setTestData("orderAdminUILastName", lName);
    }

    public void enterIdentificationDoB(String DoB) throws Exception {
        waitForElementPresent(orderDobWebElement);
        setElementValue(orderIdentificationDoB, DoB);
        testObject.setTestData("orderAdminUIDob", DoB);
    }

    public void enterIdentificationSSN(String ssn) throws Exception {
        waitForElementPresent(orderSsnWebElement);
        clickElement(orderIdentificationSSN);
        setElementValue(orderIdentificationSSN, ssn);
        testObject.setTestData("orderAdminUISsn", ssn);

    }

    public void launchAdminUI() {
        String url = environment.getEnvironmentBaseUrl() + "/admin";
        eventFiringWebDriver.get(url);
        report("launching url : " + url);
    }

    public void login(String username, String password) throws InterruptedException, IOException {

        By fUser = By.name("Sign in name");
        By fPass = By.name("Password");
        By btnSignIn = By.xpath("//button[@id='next']");
        By btnMenu = By.id("menu-btn");

        username = testObject.processString(username);
        password = testObject.processString(password);


        this.waitFor(btnLogin);
        this.clickElement(btnLogin);

        if (waitFor(fUser)) {
            waitFor(fUser);
           // setAttribute(eventFiringWebDriver, fUser, "name", "sign in name");
//            if (isExistAndDisplayed(eventFiringWebDriver, fUser, 1))
            setElementValue(fUser, username);
//            else
//                WebElementHelper.enterText(eventFiringWebDriver, fUser, username);
            waitFor(fPass);
            setElementValue(fPass, password);
//            if (isExistAndDisplayed(driver, btnSignIn, 1)) {
            clickElement(btnSignIn);
//            } else {
//                WebElementHelper.clickElement(setEventDriver(), btnSignIn);
//            }

            this.waitFor(btnMenu);
        } else {
            throw new RuntimeException("Login pass is not showing");
        }

        Set<Cookie> webCookies = this.getDriver().manage().getCookies();
        Map<String, Object> cookies = new HashMap<>();
        for (Cookie c : webCookies) {
            cookies.put(c.getName(), c.getValue());
        }
        if (!cookies.isEmpty()) {
            String file = System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\cookies.json";
            CommonMethods.object2JsonFile(cookies, file);
        }
    }

    public void loginAndCloseBrowser(String username, String password) throws InterruptedException, IOException {

        By btnLogin = By.id("login-button");
        By fUser = By.id("signInName");
        By fPass = By.id("password");
        By btnSignIn = By.xpath("//button[@id='next']");
        By btnMenu = By.id("menu-btn");

        if (username.startsWith("data.")) {
            username = testObject.getProperty(username); // load from config file
        }
        if (password.startsWith("data.")) {
            password = testObject.getProperty(password); // load from config file
        }

        logger.info("user = " + username + ", pass = *hidden*");

        this.waitFor(btnLogin);
        this.clickElement(btnLogin);

        if (this.waitFor(fUser)) {
            this.setElementValue(fUser, username);
            this.setElementValue(fPass, password);
            this.clickElement(btnSignIn);
            this.waitFor(btnMenu);
        } else {
            throw new RuntimeException("Login pass is not showing");
        }

        Set<Cookie> webCookies = this.getDriver().manage().getCookies();
        Map<String, Object> cookies = new HashMap<>();
        for (Cookie c : webCookies) {
            cookies.put(c.getName(), c.getValue());
        }
        if (!cookies.isEmpty()) {
            String file = System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\cookies.json";
            CommonMethods.object2JsonFile(cookies, file);
        }
        driver.close();
    }

    public void verifyLogin() throws InterruptedException {
        By btnMenu = By.id("menu-btn");
        if (!this.waitFor(btnMenu)) {
            throw new RuntimeException("This is not a logged in page.");
        }

        Set<Cookie> cookies = this.driver.manage().getCookies();
        System.out.println("cookies = " + cookies.toString());

        for (Cookie c : cookies) {
            System.out.println("c name : " + c.getName() + " | value : " + c.getValue());
        }

    }

    public void signSignaturePad() {
        Actions builder = new Actions(getDriver());
        Action drawAction = builder.moveToElement(signaturePad, 50, 50)
                //signatureWebElement is the element that holds the signature element you have in the DOM
                .clickAndHold()
                .moveByOffset(60, 40)
                .moveByOffset(62, 55)
                .release()
                .build();
        drawAction.perform();
    }

    public void signSignaturePadAbandoned() {
        Actions builder = new Actions(getDriver());
        Action drawAction = builder.moveToElement(signaturePad, 50, 50)
                //signatureWebElement is the element that holds the signature element you have in the DOM
                .clickAndHold()
                .moveByOffset(30, 20)
                .moveByOffset(32, 25)
                .release()
                .build();
        drawAction.perform();
    }

    public void signSignaturePadFinalAlcPage() {
        Actions builder = new Actions(getDriver());
        Action drawAction = builder.moveToElement(signaturePad, 50, 50)
                //signatureWebElement is the element that holds the signature element you have in the DOM
                .clickAndHold()
                .moveByOffset(30, 20)
                .moveByOffset(32, 25)
                .release()
                .build();
        drawAction.perform();
    }

    public void validateNeedHelpDashboard() {
        By cardName = By.xpath("//amzn-candidate-card//div[@class='candidate-container']");

        boolean found = false;
        String expectedCard = "Auto";

        List<WebElement> cards = driver.findElements(cardName);
        for (WebElement c : cards) {
            if (c.getText().contains(expectedCard)) {
                found = true;
                report("found candidate name: " + expectedCard);
            }
        }

        Assert.assertTrue(found);
    }

    public void enterHelpComment(String helpComment) {
        By helpDone = By.id("done-button");
        this.setElementValue(helpText, helpComment);
        this.clickElement(helpDone);

        try {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
            report("alert text = " + driver.switchTo().alert().getText());
            this.getDriver().switchTo().alert().accept();
        } catch (Exception e) {
            logger.info("Error: " + e);
        }
    }

    public void clickHelpLink() {
        By weLink = By.xpath("//li/a[text()='Need Help']");
        this.clickElement(weLink);
    }

    public void clickManageOrdersTab(String tabText) throws Exception {
        String xpath = String.format("//a[contains(text(), '%s')]", tabText);
        By tab = By.xpath(xpath);
        waitForElementClickable(tab);
        clickElement(tab);
    }

    public void clickAllStripsInAdminReviewPage() {
        for (int i = 0; i < 7; i++) {
            String xpath = "(//div[@class='check-box'])[" + i + "]";
            clickElement(By.xpath(xpath));
        }
    }

    public void clickAdjudicateRetake() {
        By button = By.xpath("//button[contains(text(),'Re-take')]");
        if (this.exists(button)) {
            this.clickElement(button);
        } else {
            throw new RuntimeException("Re-take button is not visible");
        }
    }

    public void clickAdjudicateInconclusive() throws Exception {
        waitForElementPresent(adjInconclusiveWebElementButton);
        clickElement(adjudicateInconclusivebutton);
        testObject.setTestData("Adjudication", " Inconclusive");
        logger.info("adjudication is " + testObject.getTestData("Adjudication"));

    }

    public void clickReadyToAdjudicate() {
        By weLink = By.xpath("//li/a[text()='Ready to Adjudicate']");
        if (this.exists(weLink)) {
            this.clickElement(weLink);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                logger.info("Error: " + e);
            }
        }
    }


    public void clickOnCandidateCard(String name) throws Exception {
        By applicantCard = getCandidateCard(name);
        logger.info("!!!!! applicant card information " + applicantCard);
        logger.info("***** candidate card clicked: " + name);
        waitForElementClickable(applicantCard);
        clickElement(applicantCard);
    }

    public void clickOnEACandidateCard(String name) throws Exception {
        By applicantCard = getEACandidateCard(name);

        waitForElementClickable(applicantCard);
        clickElement(applicantCard);
    }

    public void javaClickOnCandidateCard() throws Exception {
        javaScriptClick(getCandidateCardByWebElement(getCandidateName()));
    }

    public String getCandidateName() {
        return testObject.processString("data.runtime.invite-name");
    }

    public By candidateCardElement() {
        String currentCandidate = getCandidateName();
        report("Current Candidate: " + currentCandidate);
        return By.xpath("//amzn-candidate-card//*[text()='" + currentCandidate + "']");
    }


    public void clickLocationNameCard(String locationName) throws Exception {
        By locationNameCard = By.xpath("//amzn-building-card//div[text()='" + locationName + "']");
        if (exists(locationNameCard)) {
            waitForElementClickable(locationNameCard);
            clickElement(locationNameCard);
        } else {
            throw new RuntimeException("Location Name [" + locationName + "] is not visible");
        }
    }

    public void clickAdjudicateRetest() {
        By button = By.xpath("//button[@id='retest-btn']");
        if (this.exists(button)) {
            this.clickElement(button);
        } else {
            throw new RuntimeException("Retest button is not visible");
        }
    }

    public void clickAdjudicateClear() {
        By buttonClear = By.xpath("//button[@id='clear-btn']");
        if (this.exists(buttonClear)) {
            this.clickElement(buttonClear);
        } else {
            throw new RuntimeException("Clear button is not visible");
        }
    }

    public void selectAdjudicationStripsByIndex(List<Integer> indexes) {
        for (Integer index : indexes) {
            By checkbox = By.xpath("(//div[@class='check-box'])[" + index + "]");
            this.clickElement(checkbox);
        }
    }

    public void clickAdjudicateCertifySubmit() throws Exception {
        waitForElementClickable(certifySubmitButton);
        clickElement(certifySubmitButton);
        report("Certify and Submit Button clicked.");
    }

    public void clickAdjudicateSignSubmit() throws Exception {
        waitForElementClickable(signAndSubmitButton);
        clickElement(signAndSubmitButton);
        report("Sign and Submit Button clicked.");
    }


    public void validateReadyToAdjudicateDashboard() {
        String currentCandidate = getCandidateName();
        List<String> fullName = Arrays.asList(currentCandidate.split(" "));
        String fName = fullName.get(0);
        Assert.assertTrue(exists(candidateGreenCardByFirstName(fName)), "Adjudicated Green card for " + currentCandidate + " was not found as expected.");
    }

    public void validateTestsInProgressDashboard() {
        boolean found = false;
        String expectedCard = testObject.getTestData("lName");

        List<WebElement> cards = getDriver().findElements(cardName);
        for (WebElement c : cards) {
            if (c.getText().contains(expectedCard)) {
                found = true;
                report("found candidate name: " + expectedCard);
            }
        }
        Assert.assertTrue(found);
    }

    public void validateNotInTestsInProgressDashboard() throws Exception {
        String currentCandidate = getCandidateName();
        boolean found = false;
        List<WebElement> cards = getDriver().findElements(cardName);
        for (WebElement c : cards) {
            if (getText(c).contains(currentCandidate)) {
                found = true;
                report("found candidate name: " + currentCandidate);
            }
        }

        Assert.assertFalse(found);
    }

    public void validateConcludedTestsDashboard() throws Exception {
        String currentCandidate = getCandidateName();
        boolean found = false;
        List<WebElement> cards = getDriver().findElements(cardName);
        for (WebElement c : cards) {
            if (getText(c).contains(currentCandidate)) {
                found = true;
                report("found candidate name: " + currentCandidate);
            }
        }
        Assert.assertTrue(found);
    }

    public void clickTestsInProgressLink() {
        By weLink = By.xpath("//li/a[text()='Tests in Progress']");
        this.clickElement(weLink);
    }

    public void clickConcludedTestsLink() {
        By ctLink = By.xpath("//a[text()='Concluded Tests']");
        this.clickElement(ctLink);
    }

    public void validateCorrectLocationShowing() throws Exception {
        String location = environment.getEnvironmentLocationName();
        if (!this.exists(weMenu)) {
            throw new RuntimeException("Header menu does not exist");
        }
        String capturedLocation = getText(locationTitleWE);
        report("Location: " + capturedLocation);
        Assert.assertTrue(capturedLocation.contains(location), "Location was not found as expected Found: " + capturedLocation + " instead of: " + location);
    }

    public void selectLocation() throws Exception {
        String locName = environment.getEnvironmentLocationName();
        String stateName = environment.getEnvironmentLocationState();
        logger.info("State to click: " + stateName);
        By btnState = By.xpath("//div/*[text()='" + stateName + "']");
        waitForElementClickable(btnState);
        Thread.sleep(500);
        By divLocation = By.xpath("//div[contains(text(), '" + locName + "')]");

        if (this.exists(divLocation)) {
            this.clickElement(divLocation);
        } else {
            throw new RuntimeException("Location tile does not exist or visible.");
        }
    }


    public void clickDefaultLocationCard() throws Exception {
        String locationName = environment.getEnvironmentLocationName();
        clickLocationNameCard(locationName);
    }

    public void clickAutomationLocationCard() throws Exception {
        String locationName = testObject.getProperty("automation.location.name");
        logger.info("location Name card to click: " + locationName);
        clickLocationNameCard(locationName);
    }


    public void selectInconclusiveDrug(By... drugOption) {
        for (By drug : drugOption) {
            checkbox(drug, true);
        }
    }

    public void clickCancel() throws Exception {
        waitForElementClickable(adjCancelButton);
        clickElement(adjCancelButton);
    }

    public void clickConfirm() throws Exception {
        waitForElementClickable(adjConfirmButton);
        clickElement(adjConfirmButton);
    }

    public void clickCompletedTestsTab() throws Exception {
        waitForElementClickable(concludedTab);
        clickElement(concludedTab);
    }


    public void verifyCardListedUnderFilter(String filterOption) {
        Assert.assertTrue(exists(candidateCardElement()), "Candidate Card was not found under filter: " + filterOption);
    }


    public void clickRestartTestCheckbox() {
        checkbox(restartTestCheckbox, true);
    }

    public void clickHelpDoneButton() throws Exception {
        waitForElementClickable(helpDoneButton);
        clickElement(helpDoneButton);
    }

    public void clickLogout() throws Exception {
        waitForElementClickable(mainMenu);
        clickElement(mainMenu);
        waitForElementClickable(logoutMenu);
        clickElement(logoutMenu);
    }

    public void clickChooseAnotherLocation() throws Exception {
        waitForElementClickable(mainMenu);
        clickElement(mainMenu);
        waitForElementClickable(chooseAnotherLocationMenu);
        clickElement(chooseAnotherLocationMenu);
    }

    public void clickManageOrders() throws Exception {
        waitForElementClickable(mainMenu);
        clickElement(mainMenu);
        logger.info("main menu clicked");
        waitForElementClickable(manageOrdersMenu);
        clickElement(manageOrdersMenu);
    }

    public void clickCocConversion() throws Exception {
        waitForElementClickable(mainMenu);
        clickElement(mainMenu);
        waitForElementClickable(cocConversionMenu);
        clickElement(cocConversionMenu);
    }


    public void enterHelpCommentOnly(String text) {
        setElementValueNoClear(helpText, text);
    }

    public void enterTextToSearch(String searchText, boolean clearValue) {
        if (clearValue) {
            setElementValue(candidateSearchTextBox, searchText);
        } else {
            setElementValueNoClear(candidateSearchTextBox, searchText);
        }
    }


    public void clickStartDateRange(String dateLabel) throws Exception {
        waitForElementClickable(startDateRange);
        clickElement(startDateRange);
        wait(1);
        clickElement(getDateRangeLabel(dateLabel));
    }

    public void clickEndDateRange(String dateLabel) throws Exception {
        waitForElementClickable(endDateRange);
        clickElement(endDateRange);
        clickElement(getDateRangeLabel(dateLabel));
    }

    public void setCurrentDayAsEndDateToSearch() throws Exception {
        waitForElementClickable(endDateRange);
        clickElement(endDateRange);
        String currentDate = getCurrentDateforFilter();
        logger.info("setting end date: " + currentDate);
        clickElement(getDateRangeLabel(currentDate));
    }

    public void setRandomStartDateToSearch(int daysPriorCurrentDay) throws Exception {
        waitForElementClickable(startDateRange);
        clickElement(startDateRange);
        String currentDate = calculatePreviousDays(daysPriorCurrentDay);
        logger.info("setting start date: " + currentDate);
        clickElement(getDateRangeLabel(currentDate));
        waitForSeconds(1);
    }


    public void goToPageNumber(String pageNumber) throws Exception {
        waitForElementClickable(resultsPagination(pageNumber));
        clickElement(resultsPagination(pageNumber));
    }

    public void clickAdjudicatedBackButton() throws Exception {
        waitForElementClickable(adjudicatedBackButton);
        clickElement(adjudicatedBackButton);
    }

    public void clickPastHoursButton(String buttonText) throws Exception {
        waitForElementClickable(pastHourButton(buttonText));
        clickElement(pastHourButton(buttonText));
    }

    public void clickStartDateRangeCalendar() throws Exception {
        waitForElementClickable(startDateRange);
        clickElement(startDateRange);
    }

    public void verifyPastHoursButtonExists(String buttonText) throws Exception {
        clickStartDateRangeCalendar();
        Assert.assertTrue(exists(pastHourButton(buttonText)), buttonText + " Button was not found as expected.");
        clickPastHoursButton(buttonText);
        waitForDisappear(pastHourButton(buttonText));
    }

    public void selectAreasonForAbandoned() throws Exception {
        By element = randomReasonOption();
        waitForElementClickable(element);
        clickElement(element);
        if (element.toString().contains("Other")) {
            addAbandonedReasonComments("Test");
        }
    }

    public void selectReasonForCertification(String reason) throws Exception {
        By element = reasonOption(reason);
        waitForElementClickable(element);
        clickElement(element);
    }

    public void addInvalidReasonComments(String reasonDetailsComment) {
        setElementValueNoClear(reasonComment, reasonDetailsComment);
    }

    public void clickInvalidButton() throws Exception {
        waitForElementClickable(invalidButton);
        clickElement(invalidButton);
    }


    public void clickInvertedSwitch() throws Exception {
        waitForElementPresent(invertedSwitchWebElement);
        scrollTo(invertedSwitchWebElement);
        clickElement(invertedSwitch);
    }

    public void isImageInverted() {
        String className = adjudicateDeviceImage_WebElement.getAttribute("class");
        Assert.assertEquals(className, "inverted", "Inverted Image was not found as expected.");
    }

    public String getAdminSpecimenIdDisplayed() throws Exception {
        return getText(specimenId_WebElement).replace(" ", "");
    }

    public void clickSpecimenYesButton() throws Exception {
        waitForElementPresent(adminSpecimenYesButton_WebElement);
        clickElement(adminSpecimenYesButton);
    }

    public void clickSpecimenNoButton() throws Exception {
        waitForElementPresent(adminSpecimenNoButton_WebElement);
        clickElement(adminSpecimenNoButton);
    }

    public void addAbandonedReasonComments(String reasonDetailsComment) {
        setElementValueNoClear(reasonComment, reasonDetailsComment);
    }

    public void clickAbandonedProcess() throws Exception {
        scrollTo(abandonedButtonWebElement);
        waitForElementClickable(abandonedProcessButton);
        clickElement(abandonedProcessButton);
    }

    public void selectPackage(String packageText) throws Exception {
        waitForElementPresent(orderPackageWElementSelector);
        clickElement(orderPackageSelector);
        waitForSeconds(1);
        String xpath = String.format("//select[@id='orderPackageId']/option[contains(text(),'%s')]", packageText);
        clickElement(By.xpath(xpath));
    }

    public Boolean packageInfoDisplayed(String optionText) throws Exception {
        waitForElementPresent(orderPackageWElementSelector);
        String xpath = String.format("//select[@id='orderPackageId']/option[contains(text(),'%s')]", optionText);
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }


    public void selectPackageReason(String reason) throws Exception {
        waitForElementPresent(orderPackageReasonWESelector);
        selectElement(orderPackageReasonSelector, reason);
    }

    public String packageInfoReasonDisplayed() throws Exception {
        waitForElementPresent(orderPackageReasonWESelector);
        Select select = new Select(driver.findElement(By.id("reasonForTest")));
        WebElement element = select.getFirstSelectedOption();
        return getText(element);
    }

    public void selectHiringCountry(String country) {
        String xpath = String.format("//select[@id='country']/option[contains(text(), '%s')]", country);
        clickElement(By.xpath(xpath));
    }


    public void selectHiringState(String state) {
        clickElement(orderStateSelector);
        String xpath = String.format("//select[@id='state']/option[contains(text(),'%s')]", state);
        clickElement(By.xpath(xpath));
        //using this line to redirect focus off of the state element
        clickElement(orderCity);
    }

    public void enterOrderCity(String city) {
        setElementValue(orderCity, city);
    }

    public void enterOrderZipCode(String zipCode) {
        setElementValueNoClear(orderPostalCode, zipCode);
    }

    public void enterOrderAddress1(String address) throws Exception {
        waitForElementPresent(orderAddressLine1WebElement);
        setElementValueNoClear(orderAddressLine1, address);
    }

    public void enterOrderPhoneNumber(String phone, Boolean clearValue) throws Exception {
        waitForElementPresent(orderPhoneNumberWebElement);
        waitForElementPresent(orderEmailAddressWebElement);
        if (clearValue) {
            orderPhoneNumberWebElement.sendKeys(Keys.DELETE);
            setElementValue(orderPhoneNumber, phone);
        } else {
            setElementValueNoClear(orderPhoneNumber, phone);
        }
    }

    public void enterOrderEmailAddress(String email, Boolean clearValue) throws Exception {
        waitForSeconds(2);
        waitForElementPresent(orderEmailAddressWebElement);
        if (clearValue) {
            setElementValue(orderEmailAddress, email);
        } else {
            setElementValueNoClear(orderEmailAddress, email);
        }

    }

    public void clickOrderNextButton() throws Exception {
        waitForElementClickable(orderNextButton);
        clickElement(orderNextButton);
    }

    public void clickAlcoholFlowNextButton() throws Exception {
        waitForElementClickable(alcoholFlowNextBtn);
        clickElement(alcoholFlowNextBtn);
    }

    public void clickOrderPreviousButton() throws Exception {
        waitForElementClickable(orderPreviousButton);
        clickElement(orderPreviousButton);
        waitForSeconds(5);
    }

    public void clickCoCtakePhotoButton() throws Exception {
        waitForElementClickable(sideAlleyCoCTakePhotoButton);
        clickElement(sideAlleyCoCTakePhotoButton);
    }

    public void clickStartNewCandidateButton() throws Exception {
        waitForElementClickable(orderCreateAnotherButton);
        clickElement(orderCreateAnotherButton);
    }

    public void clickBrowserBackButton() {
        browserBackButton();
    }

    public void clickOrderExitButton() throws Exception {
        waitForElementClickable(orderExitButton);
        clickElement(orderExitButton);
    }

    public void clickGetStartedButton() throws Exception {
        waitForElementClickable(orderGetStartedButton);
        clickElement(orderGetStartedButton);
    }

    public void clickUseThisIdButton() throws Exception {
        waitForElementClickable(orderUseIdButton);
        clickElement(orderUseIdButton);
    }

    public void clickNewOrderButton() throws Exception {
        waitForElementClickable(createNewOrderButton);
        clickElement(createNewOrderButton);
    }

    public void clickCreateNewOrderButtonSubmitPage() throws Exception {
        waitForElementPresent(createNewOrderOnSubmitWebElement);
        clickElement(adminUIcreateNewOrders);
    }

    public void enterCandidateLastName(String candidateLastName) throws Exception {
        waitForElementPresent(candidateLookupLastNameWebElement);
        logger.info("entering last name: " + candidateLastName);
        setElementValue(orderLookupLastName, candidateLastName);
    }

    public void enterCandidateDobMonth(String candidateDobMonth) throws Exception {
        waitForElementPresent(candidateLookupMonthWebElement);
        setElementValue(orderLookupBirthMonth, candidateDobMonth);
    }

    public void enterCandidateDobDay(String candidateDobDay) throws Exception {
        waitForElementPresent(candidateLookupDayWebElement);
        setElementValue(orderLookupBirthDay, candidateDobDay);
    }

    public void enterCandidateDobYear(String candidateDobYear) throws Exception {
        waitForElementPresent(candidateLookupYearWebElement);
        setElementValue(orderLookupBirthYear, candidateDobYear);
    }

    public void enterCandidateSsn(String candidateSsn) throws Exception {
        waitForElementPresent(candidateLookupSsnWebElement);
        setElementValue(orderLookupSsn, candidateSsn);
    }


    public void clickSideAlleySubmitButton() throws Exception {
        waitForElementClickable(sideAlleyUploadSubmitButton);
        clickElement(sideAlleyUploadSubmitButton);
    }


    public void clickKeepThisButton() throws Exception {
        waitForElementClickable(keepThisButton);
        clickElement(keepThisButton);
    }

    public void clickSwitchToThisButton() throws Exception {
        waitForElementClickable(switchToThisButton);
        clickElement(switchToThisButton);
    }

    public void clickViewThisOrderButton() throws Exception {
        waitForElementClickable(adminUIViewOrderButton);
        clickElement(adminUIViewOrderButton);
    }

    public void clickOrderDoneButton() throws Exception {
        waitForElementClickable(orderDoneButton);
        clickElement(orderDoneButton);
    }

    public void clickInvalidOrderSubmitConfRetryButton() throws Exception {
        waitForElementClickable(submitInvalidOrderConfRetrySubmittingButton);
        clickElement(submitInvalidOrderConfRetrySubmittingButton);
    }

    public void clickInvalidOrderSubmitConfCreateNewButton() throws Exception {
        waitForElementClickable(submitInvalidOrderConfCreateNewOrderButton);
        clickElement(submitInvalidOrderConfCreateNewOrderButton);
    }

    public void clickSubmitConfDoneButton() throws Exception {
        waitForElementClickable(submitOrderConfDoneButton);
        clickElement(submitOrderConfDoneButton);
    }

    public void clickSubmitConfCreateNewButton() throws Exception {
        waitForElementClickable(submitOrderConfCreateNewButton);
        clickElement(submitOrderConfCreateNewButton);
    }

    public void setSideAlleyTestLocation(String location) {
        clickElement(sideAlleyTestLocationSelector);
        waitForSeconds(1);
        String xpath = String.format("//select[@id='testLocation']/option[text()='%s']", location);
        clickElement(By.xpath(xpath));
        clickElement(sideAlleySelectLocationScreen);
        waitForSeconds(2);
    }

    public void enterCandidateInformation() throws IOException {
        CreateOrderWrapper order = this.getCreateOrderWrapper();

        String lName = order.getRequestField("lastName");
        String socialSecurityNumber = order.getRequestField("ssn");
        String dateOfBirth = order.getRequestField("dateOfBirth");
        String[] dob = dateOfBirth.split("/");
        String month = dob[0];
        String day = dob[1];
        String year = dob[2];
        setElementValue(orderLookupLastName, lName);
        setElementValueNoClear(orderLookupBirthMonth, month);
        setElementValueNoClear(orderLookupBirthDay, day);
        setElementValueNoClear(orderLookupBirthYear, year);
        setElementValueNoClear(orderLookupSsn, socialSecurityNumber);
        report(Status.PASS, "Entered Candidate's Information:" + lName + "\n" + month + "\n" + day + "\n" + year + "\n" + socialSecurityNumber);
    }

    public Object getCandidateInfoFromOrderWrapper(String jsonPathName) throws Exception {
        CreateOrderWrapper order = this.getCreateOrderWrapper();
        return order.getRequestField(jsonPathName);
    }


    public void clickCandidateRowByLastName(String lastNameToFind) {
        By result = getCandidateRowByLastName(lastNameToFind);
        clickElement(result);
    }

    public void refreshTheBrowser() {
        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);
        sharedBaseClass.browserRefresh();
    }

    public void switchToAdminUIWindow() {
        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);
        sharedBaseClass.switchWindow();
    }

    public void clickInconclusiveRecommendation() throws Exception {
        waitForElementClickable(sideAlleyInconclusiveOption);
        clickElement(sideAlleyInconclusiveOption);
    }

    public void clearNameFilterInOrderList() {
        setElementValue(orderNameFilterTextbox, "");
        report("Order Name Filter textbox cleared");
        logger.info("Order Name Filter textbox cleared");
    }

    public void clearSsnFilterInOrderList() {
        setElementValue(orderSsnFilterTextbox, "");
        report("Order Ssn Filter textbox cleared");
        logger.info("Order Ssn Filter textbox cleared");
    }

    public void enterOrderNameInFilterTextbox(String nameToFind) {
        setElementValue(orderNameFilterTextbox, nameToFind);
    }

    public void enterOrderIdInFilterTextbox(String idToFind) {
        setElementValue(orderIdFilterTextbox, idToFind);
    }

    public void enterOrderSsnInFilterTextbox(String last4Ssn) {
        setElementValue(orderSsnFilterTextbox, last4Ssn);
    }

    public void clearStatusDefaultSelection() {
        clickElement(clearNewStatusFilterX);
    }

    public void selectOrderStatusFilter(String... statuses) throws Exception {
        clearStatusDefaultSelection();
        //default to return search results in app is 3 sec. giving time to reset
        waitForSeconds(7);
        clickElement(placedOrderStatusFilter);
        //to reset dropdown...
        clickElement(orderIdFilterTextbox);
        clickElement(placedOrderStatusFilter);
        for (String status : statuses) {
            String xpath = String.format("//ng-select[@placeholder='Statuses']//div/span[contains(text(),'%s')]", status);
            waitForElementClickable(By.xpath(xpath));
            clickElement(By.xpath(xpath));
        }
    }

    public void selectBulkPackagesFilter(String orderPackage) {
        clickElement(bulkUploadPackageSelector);
        String xpath = String.format("//ng-Select[@placeholder='Packages']//div[@role='option']/span[contains(text(),'%s')]", orderPackage);
        clickElement(By.xpath(xpath));
    }

    public void selectBulkUploadStatusFilter(String status) {
        clickElement(bulkUploadStatusSelector);
        String xpath = String.format("//ng-Select[@placeholder='Bulk Upload Status']//div[@role='option']/span[contains(text(),'%s')]", status);
        clickElement(By.xpath(xpath));
    }

    public void verifyBulkUploadStatus(String... statuses) {
        clickElement(bulkUploadStatusSelector);
        for (String status : statuses) {
            String xpath = String.format("//ng-Select[@placeholder='Bulk Upload Status']//div[@role='option']/span[contains(text(),'%s')]", status);
            logger.info("checking bulk upload status: " + status);
            Assert.assertTrue(exists(By.xpath(xpath)));
        }
    }

    public boolean isFileInBulkOrderList(String fileName) throws Exception {
        for (WebElement dataRow : bulkOrdersListRows) {
            if (getText(dataRow).contains(fileName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isBulkStatusInAllRows(String status) throws Exception {
        for (WebElement dataRow : bulkOrderUploadStatusColumnRows) {
            if (!getText(dataRow).equalsIgnoreCase(status)) {
                return false;
            }
        }
        return true;
    }

    public void clearOrderStatusFilter() throws Exception {

        for (WebElement removeStatus : selectedStatuses) {
            logger.info("cleared " + getText(removeStatus));
            clickElement(By.xpath("//span/preceding::span[@class='ng-value-icon left'][1]"));
        }
    }

    public void setBulkUploadStartDate(String month, String day) {
        clickElement(bulkUploadDateRangeSelector);
        String xpath = String.format("//button/span[text()='%s']/following::span[text()='%s'][1]", month, day);
        clickElement(By.xpath(xpath));
    }

    public void setPlacedOrdersStartDate(String month, String day) {
        clickElement(placedOrdersDatePicker);
        String xpath = String.format("//button/span[text()='%s']/following::span[text()='%s'][1]", month, day);
        clickElement(By.xpath(xpath));
    }

    public void setPlacedOrdersEndDate(String month, String day) {
        String xpath = String.format("//button/span[text()='%s']/following::span[text()='%s'][1]", month, day);
        logger.info("xpath for end date clicked " + xpath);
        clickElement(By.xpath(xpath));
    }

    public void setCurrentMMDDForPOEndDate() {
        String currentDate = getCurrentDateforFilter();
        String[] holdDateElement = currentDate.split(",");
        String[] reformatMmDd = holdDateElement[1].split(" ");
        logger.info("current month and day to set: " + reformatMmDd[1] + " day " + reformatMmDd[2]);
        setPlacedOrdersEndDate(reformatMmDd[1], reformatMmDd[2]);
    }

    public void clickSideAlleyBackButton() throws Exception {
        waitForElementClickable(sideAlleyBackButton);
        clickElement(sideAlleyBackButton);
    }

    public Boolean checkPlacedOrderStatuses() throws Exception {
        boolean found = false;
        String[] list = new String[]{"New", "In Progress", "Adjudicate", "Invalid", "Retake Picture", "Inconclusive", "Negative",
                "Expired", "Abandoned", "Incomplete"};
        clickElement(placedOrderStatusFilter);

        for (int i = 0; i < list.length; i++) {
            if ((!found) && (i != 0)) {
                return false;
            }
            if (found) {
                found = false;
            }
            for (WebElement status : placeOrderStatusesWebElement) {
                logger.info("checking status... " + getText(status) + " for " + i + " " + list[i]);
                if (getText(status).trim().equalsIgnoreCase(list[i].trim())) {
                    found = true;
                    logger.info("status was found: " + getText(status));
                    break;
                }
            }
        }
        return found;
    }


    public void verifyAdminPlacedOrdersListedChronological() throws Exception {
        List<Date> expected = new ArrayList<>();
        for (WebElement day : adminPlacedOrderChronologicalOrder) {

            SimpleDateFormat str = new SimpleDateFormat("MM/dd/yy, hh:mm a");
            str.setTimeZone(TimeZone.getTimeZone("America/New_York"));
            Date date1 = str.parse(getText(day));
            expected.add(date1);
        }

        List<Date> actual = new ArrayList<>();
        for (WebElement day : adminPlacedOrderChronologicalOrder) {
            SimpleDateFormat str = new SimpleDateFormat("MM/dd/yy, hh:mm a");
            str.setTimeZone(TimeZone.getTimeZone("America/New_York"));
            Date date1 = str.parse(getText(day));
            actual.add(date1);
        }
        Collections.sort(expected);
        Collections.reverse(expected);
        Assert.assertEquals(actual, expected, "Items were not found in chronological order.");
    }

    public void verifyAdminBulkOrdersListedChronological() throws Exception {
        List<Date> expected = new ArrayList<>();
        for (WebElement day : adminBulkOrderChronologicalOrder) {

            SimpleDateFormat str = new SimpleDateFormat("MM/dd/yy, hh:mm a");
            str.setTimeZone(TimeZone.getTimeZone("America/New_York"));
            Date date1 = str.parse(getText(day));
            expected.add(date1);
        }

        List<Date> actual = new ArrayList<>();
        for (WebElement day : adminBulkOrderChronologicalOrder) {
            SimpleDateFormat str = new SimpleDateFormat("MM/dd/yy, hh:mm a");
            str.setTimeZone(TimeZone.getTimeZone("America/New_York"));
            Date date1 = str.parse(getText(day));
            actual.add(date1);
        }
        Collections.sort(expected);
        Collections.reverse(expected);
        Assert.assertEquals(actual, expected, "Items were not found in chronological order.");
    }

    public void verifyAdminPlacedOrdersListedReverseChronological() throws Exception {
        List<Date> expected = new ArrayList<>();
        for (WebElement day : adminPlacedOrderChronologicalOrder) {
            SimpleDateFormat str = new SimpleDateFormat("MM/dd/yy, hh:mm a");
            str.setTimeZone(TimeZone.getTimeZone("America/New_York"));
            Date date1 = str.parse(getText(day));
            expected.add(date1);
        }


        List<Date> actual = new ArrayList<>();
        for (WebElement day : adminPlacedOrderChronologicalOrder) {
            SimpleDateFormat str = new SimpleDateFormat("MM/dd/yy, hh:mm a");
            str.setTimeZone(TimeZone.getTimeZone("America/New_York"));
            Date date1 = str.parse(getText(day));
            actual.add(date1);
        }
        Collections.sort(expected);
        Assert.assertEquals(expected, actual);
    }

    public void clickSideAlleyNextButton() throws Exception {
        waitForElementPresent(sideAlleyNextButtonWebElement);
        waitForElementClickable(sideAlleyNextButton);
        clickElement(sideAlleyNextButton);
    }

    public void clickSideAlleyNextButtonSelectLocationScreen() throws Exception {
        waitForElementPresent(sideAlleyNextButtonWebElement);
        clickElement(sideAlleyNextButtonSelectLocationScreen);
    }

    public void isCandidateInFirstRowOfResultsList(String lastName) {
        Assert.assertTrue(exists(getCandidateRowByLastName(lastName)), "Candidate was not found in first row of candidate results list.");
    }

    private By getCandidateRowByLastName(String lastNameToSearch) {
        String xpath = String.format("//th[contains(text(),'Name')]/following::td[contains(text(),'%s')][1]", lastNameToSearch);
        return By.xpath(xpath);
    }


    private CreateOrderWrapper getCreateOrderWrapper() {
        if (createOrderWrapper == null) {
            BackendApi api = (BackendApi) testObject.getRuntimeData(Constants.BACKEND_API);
            createOrderWrapper = new CreateOrderWrapper(testObject, api);
        }
        return createOrderWrapper;
    }

    public void clickGetStartedOnSideAlley() throws Exception {
        waitForElementClickable(sideAlleyGetStartedButton);
        clickElement(sideAlleyGetStartedButton);

    }

    public void clickIamHappyButtonAdminUI() throws Exception {
        waitForElementClickable(sideAlleyIamHappyWithMyPhotoButton);
        clickElement(sideAlleyIamHappyWithMyPhotoButton);
    }

    public void clickTakePhotoButtonSA() throws Exception {
        waitForElementClickable(sideAlleyTakePhotoButton);
        clickElement(sideAlleyTakePhotoButton);
    }

    public void uploadCOCPhoto(String file) {
        String directory = System.getProperty("user.dir") + file;
        logger.info("directory/folder path:  " + directory);
        uploadCOCPhotoAreaWebElement.sendKeys(directory);
    }

    public void verifyAdminPlacedOrdersColumnTitles() {
        List<String> expected = new ArrayList<>(Arrays.asList("Name", "SSN", "DOB", "Created", "Status", "Location", "Order Id", "Package", "One Strip"));
        List<String> titles = new ArrayList<>();
        for (WebElement title : adminPlacedOrdersTableTitles
        ) {
            titles.add(title.getText());
        }
        Assert.assertEquals(expected, titles);
    }

    public void uploadPhotoSA(String file) {
        String directory = System.getProperty("user.dir") + file;
        logger.info("directory/folder path:  " + directory);
        uploadPhotoSideAlleyAreaWebElement.sendKeys(directory);
    }


    public void clickNegativeInSideAlley() throws Exception {
        waitForElementClickable(sideAlleyNegativeOption);
        clickElement(sideAlleyNegativeOption);
    }

    public void clickSubmitOnSideAlleyReview() throws Exception {
        waitForElementClickable(sideAlleyAdjudicationSubmitButton);
        clickElement(sideAlleyAdjudicationSubmitButton);
    }

    public void uploadDuplicatePhotoSA(String file) {
        String directory = System.getProperty("user.dir") + file;
        logger.info("directory/folder path:  " + directory);
        uploadPhotoSideAlleyAreaWebElement.sendKeys(directory);
    }

    public void enterGeneratedCandidateInfoOnInfoScreen() throws Exception {
        //generate the candidate information and store to retrieval
        autoGenerateCandidateInformation();
        enterIdentificationFName(testObject.getTestData("adminUIOrderFName"));
        enterIdentificationLName(testObject.getTestData("adminUIOrderLName"));
        enterIdentificationDoB(testObject.getTestData("adminUIOrderDob"));
        waitForSeconds(2);
        String ssn = testObject.getTestData("adminUIOrderSsn");
        logger.info("Entering candidate ssn: " + ssn);
        enterIdentificationSSN(ssn);
    }

    private void autoGenerateCandidateInformation() {
        Random r = new Random();
        String firstName = "F-" + r.nextInt(99999);
        testObject.setTestData("adminUIOrderFName", firstName);
        String lastName = "L-" + r.nextInt(99999);
        testObject.setTestData("adminUIOrderLName", lastName);
        int temp = r.nextInt(99);
        logger.info("temp random last 2 digits for ssn assigned:" + temp);
        String ssn = "5094510" + temp;
        testObject.setTestData("adminUIOrderSsn", ssn);
        String dob = "05/1" + r.nextInt(9) + "/195" + r.nextInt(9);
        testObject.setTestData("adminUIOrderDob", dob);
        String phoneNumber = String.valueOf((long) (Math.random() * 100000 + 3333000000L));
        testObject.setTestData("adminUIOrderPhone", phoneNumber);
        String email = "email" + r.nextInt() + "@gmail.com";
        testObject.setTestData("adminUIOrderEmail", email);
    }


    public void clickReTakePhotoButtonSA() throws Exception {
        waitForElementClickable(sideAlleyRetakePhotoButton);
        clickElement(sideAlleyRetakePhotoButton);
    }

    public void clickUploadPhotoButtonSA() throws Exception {
        waitForElementClickable(sideAlleyUploadPhotoButton);
        clickElement(sideAlleyUploadPhotoButton);
    }

    public void clickEnterSpecimenIDButtonSA() throws Exception {
        waitForElementClickable(sideAlleyEnterSpecimenIDButton);
        clickElement(sideAlleyEnterSpecimenIDButton);
    }

    public void enterSampleInformationSA(String sampleId, Boolean clearField) {
        if (clearField.equals(true)) {
            setElementValue(sideAlleySampleIdTextBox, sampleId);
            setElementValue(sideAlleyConfirmSampleIdTextBox, sampleId);
        } else {
            setElementValueNoClear(sideAlleySampleIdTextBox, sampleId);
            setElementValueNoClear(sideAlleyConfirmSampleIdTextBox, sampleId);
        }
        report(Status.PASS, "Entered Sample Information");
    }

    public void enterGeneratedCandidateInfoToLookup() throws Exception {
        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);
        String lastName = testObject.getTestData("adminUIOrderLName");
        String ssn = testObject.getTestData("adminUIOrderSsn");
        String birthday = testObject.getTestData("adminUIOrderDob");
        logger.info("candidate's dob to lookup: " + birthday);
        String[] dob = birthday.split("/");
        String month = dob[0];
        String day = dob[1];
        String year = dob[2];
        enterCandidateLastName(lastName);
        enterCandidateDobMonth(month);
        enterCandidateDobDay(day);
        enterCandidateDobYear(year);
        enterCandidateSsn(sharedBaseClass.getLast4SsNumber(ssn));
    }


    public void clickNextButtonOnEnterIDpageSA() throws Exception {
        waitForElementClickable(sideAlleyNextButtonOnEnterIDScreen);
        clickElement(sideAlleyNextButtonOnEnterIDScreen);
    }

    public void clickAdminUIRetakeButton() throws Exception {
        waitForElementClickable(adminUIRetakeButton);
        clickElement(adminUIRetakeButton);
    }

    public boolean isSideAlleyGetStartedButtonEnabled() {
        return sideAlleyGetStartedButtonWE.isEnabled();
    }

    public String isLocationSelected(String locationName) {
        String xpath = String.format("//select[@id='testLocation']/option[text()='%s']", locationName);
        WebElement locationElement = driver.findElement(By.xpath(xpath));
        return getAttribute(locationElement, "selected");
    }

    public void verifyOrderHasLocationInAdminUI() throws Exception {
        Assert.assertFalse(getText(getSideAlleyCandidateResultRow.get(3)).isEmpty(), "Location is not assigned for the order");
        logger.info("Assigned Location: " + getText(getSideAlleyCandidateResultRow.get(3)));
    }

    public void verifyOrderHasNoLocationInAdminUI() throws Exception {
        Assert.assertTrue(getText(getSideAlleyCandidateResultRow.get(3)).isEmpty(), "Location is assigned for the order");
        logger.info("Assigned Location: " + getText(getSideAlleyCandidateResultRow.get(3)));
    }

    public void verifySideAlleyResultsPageTableColumns() throws Exception {
        List<String> expectedColumns = new ArrayList<>(Arrays.asList("Name", "DOB", "SSN", "Location"));
        List<String> tableColumns = new ArrayList<>();
        for (WebElement column : sideAlleyResultsScreenHeader
        ) {
            tableColumns.add(getText(column));
        }
        Assert.assertEquals(tableColumns, expectedColumns, "Candidate Results columns are not found as expected");
    }

    public void searchForlastNameInSideAlleyResults(String lName) throws Exception {
        for (WebElement candidate : sideAlleyResultsLNameList) {
            if (getText(candidate).equals(lName)) {
                Assert.assertEquals(lName, getText(candidate));
            }
        }
    }

    public void clickPlacedOrdersSSNsortingArrow() throws Exception {
        waitForElementClickable(adminPlacedOrderSSNsortingArrow);
        clickElement(adminPlacedOrderSSNsortingArrow);
    }

    public void clickPlacedOrdersCreatedSortingArrow() throws Exception {
        waitForElementClickable(adminPlacedOrderCreatedSortingArrow);
        clickElement(adminPlacedOrderCreatedSortingArrow);
    }

    public void verifyPlacedOrdersSortedAscendingBySSN() throws Exception {
        List<Integer> ssnActual = new ArrayList<>();
        for (WebElement num : placedOrdersSSNcolumn) {
            String temp = getText(num);
            if (!temp.isEmpty()) {
                ssnActual.add(Integer.parseInt(getText(num)));
            }
        }

        List<Integer> ssnExpected = new ArrayList<>();
        for (WebElement num : placedOrdersSSNcolumn) {
            String temp = getText(num);
            if (!temp.isEmpty()) {
                ssnExpected.add(Integer.parseInt(getText(num)));
            }
        }
        Collections.sort(ssnExpected);
        Assert.assertEquals(ssnExpected, ssnActual);
    }

    public void verifyPlacedOrdersSortedDescendingBySSN() throws Exception {
        List<Integer> ssnActual = new ArrayList<>();
        for (WebElement num : placedOrdersSSNcolumn) {
            ssnActual.add(Integer.parseInt(getText(num)));
        }

        List<Integer> ssnExpected = new ArrayList<>();
        for (WebElement num : placedOrdersSSNcolumn) {
            ssnExpected.add(Integer.parseInt(getText(num)));
        }
        Collections.sort(ssnExpected);
        Collections.reverse(ssnExpected);
        Assert.assertEquals(ssnExpected, ssnActual);
    }

    public void enterCandidateID(String candidateID) throws Exception {
        waitForElementPresent(orderCandidateIdWebElement);
        setElementValue(orderIdentificationCID, candidateID);
    }


    public void verifyOrdersLocationInSideAlleyResults(String location) throws Exception {
        Assert.assertEquals("Location is not equal to " + location, getText(sideAlleyResultsOrderLocation), location);
    }

    public void clickInvalidInSideAlley() throws Exception {
        waitForElementClickable(sideAlleyInvalidOption);
        clickElement(sideAlleyInvalidOption);
    }

    public void clickIamHappyCOCPhotoButtonAdminUI() throws Exception {
        waitForElementClickable(sideAlleyIamHappyWithMyCoCPhotoButton);
        clickElement(sideAlleyIamHappyWithMyCoCPhotoButton);
    }

    public void clickInconclusiveInSideAlley() throws Exception {
        waitForElementClickable(sideAlleyInconclusiveOption);
        clickElement(sideAlleyInconclusiveOption);
    }

    public void verifyConcludedTestsTab() {
        Assert.assertTrue(exists(concludedTab));
    }

    public void clearBrowserCookies() {
        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);
        sharedBaseClass.clearAllCookies();
    }

    public void verifyBoothNumberOnTheCard(String boothNumber) {
        String xpath1 = ("//div[@class='card-subpanel id-container' and contains(text(),'" + boothNumber + "')]");
        Assert.assertTrue(exists(By.xpath(xpath1)));
        logger.info("booth number found " + boothNumber);
    }

    public void clickBulkUploadButton() throws Exception {
        waitForElementClickable(adminBulkUploadButton);
        clickElement(adminBulkUploadButton);
    }

    public void clickBulkUploadSubmitButton() throws Exception {
        waitForElementClickable(adminBulkUploadSubmitButton);
        clickElement(adminBulkUploadSubmitButton);
    }

    public void selectBulkUploadReasonForTest(String reason) throws Exception {
        waitForElementClickable(adminBulkReasonForTestSelector);
        clickElement(adminBulkReasonForTestSelector);
        String xpath = String.format("//select[@id='selectReasonForTest']/option[contains(text(),'%s')]", reason);
        clickElement(By.xpath(xpath));
    }

    public void selectBulkUploadPackage(String packageName) throws Exception {
        waitForElementClickable(adminBulkPackageSelector);
        clickElement(adminBulkPackageSelector);
        String xpath = String.format("//select[@id='selectPackage']/option[contains(text(),'%s')]", packageName);
        clickElement(By.xpath(xpath));
    }

    public void verifyImHappyBtnCOCPage() {
        Assert.assertTrue(sideAlleyIamHappyCoCPhotoBtnWE.isEnabled());
    }

    public void enterPhoneData(DataTable dataTable) {
        List<List<String>> values = dataTable.asLists();
        for (List<String> value : values) {
            for (String s : value) {
                setElementValue(orderPhoneNumber, s);

                Assert.assertTrue(isOrderNextButtonEnabled(), "Next button was disabled.");

                for (int k = 0; k < 15; k++) {
                    orderPhoneNumberWebElement.sendKeys(Keys.BACK_SPACE);
                }
            }
        }
    }

    public void useBlankSpreadSheetAndUpload(String fileName) throws Exception {
        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);
        sharedBaseClass.getFileToUpload(fileName);
    }


    public void clickBulkUploadDetailsIcon(String fileName) throws Exception {
        for (WebElement dataRow : bulkOrdersListRows) {
            if (getText(dataRow).contains(fileName)) {
                clickElement(bulkUploadDetailsIcon);
            }
        }
    }

    public void clickBulkUploadItemDetailsButton() throws Exception {
        waitForElementClickable(bulkUploadItemDetailsBackButton);
        clickElement(bulkUploadItemDetailsBackButton);
    }

    public void clickBulkUploadGetErrorFileLink() throws Exception {
        waitForElementClickable(bulkUploadGetErrorFileLink);
        clickElement(bulkUploadGetErrorFileLink);
    }

    public void openNewBrowserTabWindow() {
        SeleniumBaseClass seleniumBaseClass = new SeleniumBaseClass(driver);
        seleniumBaseClass.openNewBrowserTab();
    }

    public void switchToParentWindow() {
        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);
        sharedBaseClass.switchToParentWindow();
    }

    public void isLocationExist(String locationAlias) throws Exception {
        String xpath = "//table//td[6]";
        WebElement element = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(getText(element), locationAlias, "Location alias is not found");
    }

    public void enterSalariedLeaderName(String salariedLeaderName) {
        setElementValue(adminSLeaderName, salariedLeaderName);
    }

    public void enterSalariedLeaderComment(String salariedLeaderComment) {
        setElementValue(adminSLeaderComment, salariedLeaderComment);
    }

    public void signSignaturePad4EyesCheck() {
        Actions builder = new Actions(getDriver());
        Action drawAction = builder.moveToElement(signaturePad, 50, 50)
                //signatureWebElement is the element that holds the signature element you have in the DOM
                .clickAndHold()
                .moveByOffset(15, 20)
                .moveByOffset(17, 23)
                .release()
                .build();
        drawAction.perform();

    }

    /*
    This method did not work in current pdf browser, should be deleted after check
     */
    public void verifyFAQpdfOpens() {
        Assert.assertEquals("FAQ PDF browser tab is not found", "AmazonTrainingDocJan2022.pdf", "getDriver().getTitle()");

    }

    public void clickProceedBtnOn4EyePopUp() throws Exception {
        waitForElementClickable(adminSLeaderPopUpProceedBtn);
        clickElement(adminSLeaderPopUpProceedBtn);

    }

    public void enterAlias(String amazonAlias) {
        waitForElementPresent(adminAmazonAliasWE);
        setElementValue(adminAmazonAlias, amazonAlias);
    }

    public void clickLocationLink(String locationName) {
        By locationNameLink = By.xpath("//a[contains(text(),'" + locationName + "')]");
        if (exists(locationNameLink)) {
            waitForElementClickable(locationNameLink);
            clickElement(locationNameLink);
        } else {
            throw new RuntimeException("Location Name [" + locationName + "] is not visible");
        }
    }

    public void adminSelectCarrier(String carrier) {
        waitForElementClickable(adminCarrierSelector);
        clickElement(adminCarrierSelector);
        String xpath = String.format("//select[@id='shipper']/option[contains(text(),'%s')]", carrier);
        clickElement(By.xpath(xpath));
    }

    public void enterTrackingNumber(String trackingNumber) {
        waitForElementPresent(adminTrackingNumberWE);
        setElementValue(adminTrackingNumber, trackingNumber);
    }

    public void clickTrackingCertifyBtn() {
        waitForElementClickable(orderNextButton);
        clickElement(orderNextButton);
    }

    public void enterEmployeeID(String employeeID) {
        waitForElementPresent(orderIdentificationEmpIDWE);
        setElementValue(orderIdentificationEmpID, employeeID);
    }

    public void searchForLocation(String locationName) {
        waitForElementPresent(adminLandingPageLocationFilterWE);
        setElementValue(adminLandingPageLocationFilter, locationName);
    }

    public void searchForState(String state) {
        waitForElementPresent(adminLandingPageStateFilterWE);
        setElementValue(adminLandingPageStateFilter, state);
    }

    public void verifyLocationSearchResults(String searchLocation) {
        List<WebElement> locations = new ArrayList<>();
        locations.addAll(adminLandingPageLocationSearchResults);
        for (WebElement location : locations
        ) {
            logger.info("name " + getText(location));
            Assert.assertTrue(getText(location).contains(searchLocation));

        }
    }

    public void verifyLocationStateSearchResults(String searchState) {
        List<WebElement> states = new ArrayList<>();
        states.addAll(adminLandingPageStateSearchResults1);
        states.addAll(adminLandingPageStateSearchResults2);
        for (WebElement state : states
        ) {
            logger.info("name " + getText(state));
            Assert.assertTrue(getText(state).contains(searchState));

        }
    }


    public void verifyRecentLocations(String location1, String location2, String location3) {

        String xpathLoc1 = String.format("(//a[contains(text(),' %s ')])[1]", location1);
        String xpathLoc2 = String.format("(//a[contains(text(),' %s ')])[1]", location2);
        String xpathLoc3 = String.format("(//a[contains(text(),' %s ')])[1]", location3);
        WebElement location1WE = driver.findElement(By.xpath(xpathLoc1));
        WebElement location2WE = driver.findElement(By.xpath(xpathLoc2));
        WebElement location3WE = driver.findElement(By.xpath(xpathLoc3));
        Assert.assertTrue(location1WE.isDisplayed());
        Assert.assertTrue(location2WE.isDisplayed());
        Assert.assertTrue(location3WE.isDisplayed());


    }

    public void enterSampleIDInFirstField(String sampleId, Boolean clearField) {
        if (clearField.equals(true)) {
            setElementValue(sideAlleySampleIdTextBox, sampleId);
        } else {
            setElementValueNoClear(sideAlleySampleIdTextBox, sampleId);
        }
        report(Status.PASS, "Entered Sample Information");

    }

    public void enterSampleIDInSecondField(String sampleId, Boolean clearField) {
        if (clearField.equals(true)) {
            setElementValue(sideAlleyConfirmSampleIdTextBox, sampleId);
        } else {
            setElementValueNoClear(sideAlleyConfirmSampleIdTextBox, sampleId);
        }
        report(Status.PASS, "Entered Sample Information");
    }

    public void clickModifiedAdjudicationCertifyBtn() {
        waitForElementClickable(adminModifiedAdjudicationCertifyBtn);
        clickElement(adminModifiedAdjudicationCertifyBtnWE);
    }

    public void clickValidForModifiedAdminPage() {
        waitForElementClickable(adminModifiedAdjudicationValidBtn);
        clickElement(adminModifiedAdjudicationValidWE);
    }

    public void clickRetestForModifiedAdminPage() {
        waitForElementClickable(adminModifiedAdjudicationRetestBtn);
        clickElement(adminModifiedAdjudicationRetestWE);
    }

    public void verifyLocationPageFields() {

        waitForSeconds(2);
        List<By> elements = new ArrayList<>(Arrays.asList(orderCity, orderStateSelector, orderPackageReasonSelector, orderCountrySelector));
        for (By element : elements) {
            Assert.assertTrue(exists(element), element + " does not exist on the Location Information page");
        }

    }

    public void verifyReasonPre(String reasonForTest) {
        Select select = new Select(orderPackageReasonWESelector);
        String defaultOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(defaultOption, reasonForTest, "Pre-employment is not the default reason for test option");
    }

    public void verifyDefaultPackage(String packageOption) {
        Select select = new Select(orderPackageWElementSelector);
        String defaultOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(defaultOption, packageOption, "OralTox 6 Panel is not the default package option");
    }

    public void verifyBusinessLineDropDownList() {
        Select select = new Select(orderBusinessLineWE);
        List<WebElement> options = select.getOptions();
        List<String> optionsText = new ArrayList<>();
        for (WebElement option : options
        ) {
            optionsText.add(option.getText());
        }
        List<String> expectedOptions = new ArrayList<>(Arrays.asList("North American Fulfillment Center"));
        Assert.assertEquals(optionsText, expectedOptions, "Business Line drop down options are not found as expected");

    }

    public void verifyPackageDropDownList() {
        Select select = new Select(orderPackageWElementSelector);
        clickElement(orderPackageWElementSelector);
        List<WebElement> options = select.getOptions();
        List<String> optionsText = new ArrayList<>();
        for (WebElement option : options
        ) {
            optionsText.add(option.getText());
        }
        List<String> expectedOptions = new ArrayList<>(Arrays.asList("OralTox 6 Panel"));
        Assert.assertEquals(optionsText, expectedOptions, "Package drop down options are not found as expected");

    }

    public void selectBusinessLine(String businessLine) {
        By element = businessLineOption(businessLine);
        waitForElementClickable(element);
        clickElement(element);
    }

    public void verifyStepOnCard(String stepOnTheCard) {
        By stepCard = By.xpath("//div[contains(text(),'" + stepOnTheCard + "')]");
        Assert.assertTrue(exists(stepCard), "Card does not show" + stepOnTheCard + "step");
    }

    public void clickDashboardBtn() {
        waitForElementClickable(adminDashboardButton);
        clickElement(adminDashboardButton);
    }

    public void verify4EyesCheckPageDrugOptions() {
        waitForElementClickable(adjudicateInconclusivebutton);
        List<WebElement> options = new ArrayList<>(Arrays.asList(adjInconclusiveWebElementButton, adjClearButtonWebElement, adjRetestButtonWebElement));

        for (WebElement option : options) {
            Assert.assertTrue(option.isEnabled());
        }
    }

    public void verify4EyesCheckCertificationForAlcoholLevels() {
        String[] alcoholCheckBox = {"0.0", "20", "40", "80", "300"};
        WebElement text = getDriver().findElement(By.xpath("(//strong)[3]"));
        for (String box : alcoholCheckBox
        ) {
            By alcoholBox = By.xpath("//span[contains(text(),'" + box + "')]");
            clickElement(alcoholBox);
            waitForSeconds(1);
            if (box.equalsIgnoreCase("0.0")) {
                Assert.assertEquals(text.getText(), "Clear", "Certification Language is not Clear");
            } else {
                Assert.assertEquals(text.getText(), "Inconclusive", "Certification Language is not Inconclusive");
            }
        }
    }


    public void drugHas7Strips() {
        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);
        List<WebElement> xpaths = getDriver().findElements(By.xpath("//div[@class='check-box']"));
        for (WebElement xpath : xpaths) {
            Assert.assertTrue(sharedBaseClass.checkIsEnabled(xpath), "CheckBox is disabled");
            logger.info("strip" + xpath + " is enabled");

        }
    }

    public void verifyAlcBoxesDisabled() {

        SharedBaseClass sharedBaseClass = new SharedBaseClass(driver);
        for (int i = 1; i < 6; i++) {
            WebElement alcoholBox = getDriver().findElement(By.xpath("//div[@class='square alch-" + i + " disabledSquare']"));
            Assert.assertTrue(sharedBaseClass.checkIsEnabled(alcoholBox), "AlcoholBox is enabled");
        }

    }

    public void checkConcludedTabAlcCheckBoxes(String alcBox) {

        String xpath = "//div[@id='alch-" + alcBox + "']/following-sibling::div[@class='checkmark disabledCheckmark']";
        By element = By.xpath(xpath);
        Assert.assertTrue(exists(element), "Alcohol Check Box is not showing as selected by the Admin");

    }

    public void verifyFinalTestResultHas4EyesSelection() {
        String result[] = getText(adminFinalTestResult4EyesSelection).split(":");
        Assert.assertEquals(result[1], testObject.getTestData("Adjudication"), "Final Test Result Selection Page does not have 4 eyes check result");

    }

    public void verifyCertifyClearPage() {
        Assert.assertTrue(exists(certifyClearDeviceImage), "Device image is missing");
        Assert.assertTrue(exists(certifyClearAlcoholResults), "Alcohol results are missing");
        Assert.assertTrue(exists(certifyClearText), "Certification text is missing");
    }

    public void clickSupportTools() throws Exception {
        waitForElementClickable(mainMenu);
        clickElement(mainMenu);
        logger.info("main menu clicked");
        waitForElementClickable(supportToolsMenu);
        clickElement(supportToolsMenu);
    }

    public void searchByName(String state) {
        waitForElementPresent(adminSupportToolsPageSearchByNameWE);
        setElementValue(adminSupportToolsPageSearchByName, state);
    }

    public void searchForCandidate(String CandidateName) {
        waitForElementPresent(adminSupportToolsPageSearchByNameWE);
        setElementValue(adminSupportToolsPageSearchByName, CandidateName);
    }

    public void verifyCandidateSearchResults(String searchCandidate) {
        List<WebElement> candiates = new ArrayList<>();
        candiates.addAll(adminSupportToolsPageCandidateNameSearchResults);
        for (WebElement candiate : candiates
        ) {
            logger.info("name " + getText(candiate));
            Assert.assertTrue(getText(candiate).contains(searchCandidate));
        }

    }

    public void verifyAdminSupportToolsColumnTitles() {
        List<String> expected = new ArrayList<>(Arrays.asList("Name", "Last Update", "Device ID", "Wellness ID", "Status", "Step"));
        List<String> titles = new ArrayList<>();
        for (WebElement title : adminSupportToolsTableTitles
        ) {
            titles.add(title.getText());
        }
        Assert.assertEquals(expected, titles);
    }

    public void searchForDeviceID(String DeviceID) {
        waitForElementPresent(adminSupportToolsPageSearchByNameWE);
        setElementValue(adminSupportToolsPageSearchByDeviceID, DeviceID);
    }

    public void verifyDeviceIDSearchResults(String searchDeviceID) {
        List<WebElement> devices = new ArrayList<>();
        devices.addAll(adminSupportToolsPageDeviceIDSearchResults);
        for (WebElement device : devices
        ) {
            logger.info("Device ID " + getText(device));
            Assert.assertTrue(getText(device).contains(searchDeviceID));
        }

    }

    public void clickNameFieldOnSupportTools() throws Exception {
        waitForElementPresent(adminNameFieldSupportTools_WebElement);
        clickElement(adminNameFieldSupportTools);
    }

    public void WellnessAdvantageID(String WellnessAdvandtageID) {
        setElementValue(WAIdSupportTool, WellnessAdvandtageID);
    }

    public void clickSaveChangesOnSupportTools() throws Exception {
        waitForElementPresent(adminSaveChangesSupportTool_WebElement);
        clickElement(adminSaveChangesSupportTool);
    }

    public void verifyCandidateName(String candidateName) {
        List<WebElement> candiates = new ArrayList<>();
        candiates.addAll(adminCandidateResultsPageCandidateNameWE);
        for (WebElement candiate : candiates
        ) {
            logger.info("name " + getText(candiate));
            Assert.assertTrue(getText(candiate).contains(candidateName));
        }

    }

    public void selectCurrentStep(String step) throws Exception {
        waitForElementPresent(currentStepWESelector);
        selectElement(currentStepSelector, step);
    }

    public void verifyCandidateInTheJSON(String searchCandidateInTheJSON) {
        List<WebElement> candiates = new ArrayList<>();
        candiates.addAll(adminSupportToolsCandidateNameOnTheJSON);
        for (WebElement candiate : candiates
        ) {
            logger.info("name " + getText(candiate));
            Assert.assertTrue(getText(candiate).contains(searchCandidateInTheJSON));
        }
    }

    public void clickBackToResultsButtonSupportTools() throws Exception {
        waitForElementClickable(backToResultsButton);
        clickElement(backToResultsButton);
    }

    public void isOneStrip(String isOneStrip, String candidate) throws Exception {
        String actualOneStrip = driver.findElement(By.xpath("(//td[.='" + candidate + "']/..//td)[last()]")).getText();
        String expected = isOneStrip;
        logger.info("is OneStrip= " + actualOneStrip);
        Assert.assertEquals(actualOneStrip, expected, "The onestrip status is not found as expected");
    }

    public void clickReasonForTest() throws Exception {
        waitForElementClickable(orderPackageReasonSelector);
        clickElement(orderPackageReasonSelector);
    }

    public void verifyOrderReasonDropDownList() {
        Select select = new Select(orderPackageReasonWESelector);
        List<WebElement> options = select.getOptions();
        List<String> actualOptions = new ArrayList<>();
        for (WebElement option : options
        ) {
            actualOptions.add(getText(option));
        }
        List<String> expectedOptions = new ArrayList<>(Arrays.asList("Pre-employment", "Random",
                "Reasonable Suspicion", "Post Accident"));
        Assert.assertEquals(actualOptions, expectedOptions, "Order Reason drop down options are not found as expected");
    }

    public void clickBusinessLineList() throws Exception {
        waitForElementClickable(businessLine);
        clickElement(businessLine);
    }
    public void selectNumberOfTestKitsForDrug(String numberOfDevices) {
        selectElement(numberOfDrugTestKitsUsed, numberOfDevices);
    }
    public void clickCertifyBtn() {
        waitForElementClickable(adminUINxtBtn);
        clickElement(adminUINxtBtn);
    }
    public void selectNumberOfStripsForAlcohol(String numberOfStrips) {
        selectElement(adminNumberOfAlcStripsUsed, numberOfStrips);
    }
}
