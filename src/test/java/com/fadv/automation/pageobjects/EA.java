package com.fadv.automation.pageobjects;

import com.fadv.automation.core.Environment;
import com.fadv.automation.core.SeleniumBaseClass;
import com.fadv.automation.core.SharedBaseClass;
import io.cucumber.datatable.DataTable;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;


public class EA extends SeleniumBaseClass {
    static final Logger logger = Logger.getLogger(EA.class.getName());
    public static String firstNameInUi;
    public static String lastNameInUi;
    public static String middleNameInUi;
    public static String phoneNumberInUi;
    public static String emailInUi;
    public static Month birthMonthInUi;
    public static String birthDayInUi;
    public static String birthYearInUi;
    public static String addressInUi;
    public static String cityInUi;
    public static String stateInUi;
    public static String zipInUi;
    public static String ssnInUi;
    private static String uploadName;
    private static String fileToUse;
    public static int employeeID;
    public static String orderAlias;
    public static String cid;
    public static String customPackage;
    public static String alias;
    //*****By Elements***********
    public static final By progressSpinner = By.xpath("//img[contains(@src, 'progress_spinner')]");
    public static final By loadingWait = By.xpath("//div[contains(text(), 'Loading....')]");
    public final By downloadTemplateButton = By.xpath("//td[contains(text(), 'Download')]");
    public final By uploadBrowseLocation = By.xpath("//input[@type='file']");
    public final By menuViewBatch = By.xpath("//td/span[text()='View Batches']");
    public final By menuCasesInQueue = By.xpath("//td/span[text()='Cases in Queue']");
    public final By batchTableHeader = By.xpath("//tr/th[contains(text(),'Batch Name')]");
    public final By casesInQueueHeader = By.xpath("//td/p[text()='Cases in Queue']");
    public final By menuEmploymentScreening = By.xpath("//td/span[text()='Employment Screening']");
    public final By menuCaseManagementScreening = By.xpath("//td/span[text()='Case Management']");
    public final By menuProcessBatch = By.xpath("//td/span[text()='Process Batch']");
    public final By btnProcessBatch = By.xpath("//td[@class = 'html-face' and text()='Process Batch']");
    public final By generalInformationTab = By.xpath("//a[contains(@data-target,'generalInfo')]");
    public final By homepageCaseManagementWidget = By.xpath("//div/span[contains(text(), 'Case Management')]");
    public By missingZipPostalCodeMessage =  By.xpath("//span[contains(text(),'ZIP/Post Code is required')]");
    public final By eaGlobalSearchTextBox = By.xpath("//input[contains(@placeholder, 'Search by Name')]");
    public final By eaGlobalSearchButton = By.xpath("//button[contains(text(),'Search')]");
    public final By overallProgressTab = By.xpath("//div[contains(text(),'Overall Progress')]");
    public final By subjectTab =By.xpath("//p[contains(text(),'Subject')]");
    public final By additionalSearchesTab =By.xpath("//div[contains(text(),'Additional')]");
    public final By reviewOrderTab=By.xpath("//div[@title='Review Order']");
    public final By selectBoxForReason = By.id("Other..ReasonForTest");
    public static By next = By.xpath("//td[contains(text(), 'Next')]");


    //*****WebElements******
    @FindBy(xpath = "//div/span[contains(text(), 'Case Management')]")
    public WebElement hpCaseManagementWidget_WebElement;

    @FindBy(xpath = "(//div[contains(text(),'Order ID')])[2]/following::div[2]")
    public WebElement orderIdOnGeneralInfoTab_WebElement;

    @FindBy(xpath = "//div[contains(text(),'Search Results')]")
    public WebElement eaSearchResultsTab_WebElement;

    @FindBy(xpath = "//td[@class='GO-GOE2LMC']")
    public List<WebElement> eaAllSearchResultTabs_WebElement;

    public EA(WebDriver driver) {
        super(driver);
    }

    private By getDownloadRejectsButton(String batchName){
        String xpath = String.format("//div[contains(text(), '%s')]/following::div[contains(text(), 'Download Rejects')]", batchName);
        return By.xpath(xpath);
    }

    private WebElement downloadRejectsButtonWElement(String batchName){
        String xpath = String.format("//div[contains(text(), '%s')]/following::div[contains(text(), 'Download Rejects')]", batchName);
        return driver.findElement(By.xpath(xpath));
    }

    public void launchEA() {
        String url = Environment.getEaEnvironmentBaseUrl();
        driver.get(url);
        report("launching url : " + url);
    }

    public void login(String account, String user, String pass) throws InterruptedException {
        By clientId = By.name("accountnumber");
        By username = By.name("username");
        By password = By.name("password");
        By submit = By.id("signOn");

        By secretAnswer= By.name("answer");

        By proceedBtn = By.xpath("//td[text()='Proceed']");
        By iAgreeBtn = By.id("agreeBtn");
        By submitBtn = (By.id("submitBtn"));
        By logout = By.xpath("//a[text()='Logout']");

        if (waitFor(clientId)) {
            this.setElementValue(clientId, account);
            setAttribute(eventFiringWebDriver,username,"name","Username");
            this.setElementValue(username, user);
            this.setElementValue(password, pass);

            this.clickElement(submit);
            report("EA login with " + account + "/" + user + "/**[hidden**]");

            //handle secret question popup
            if (exists(secretAnswer, 1)) {
                String answer = Environment.getEaEnvironmentSecret();
                this.setElementValue(secretAnswer, answer);
                this.clickElement(By.id("submitBtn"));
            }

            //handle override session popup
            if (exists(proceedBtn, 1)){
                this.clickElement(proceedBtn);
            }
            if (exists(submitBtn, 1)){
                this.clickElement(submitBtn);
            }

            this.clickElement(iAgreeBtn);
            this.waitFor(logout);
            //this.reportScreenshot("EA Launched and logged in");
        } else {
            throw new RuntimeException("Login form is not showing");
        }
    }

    public void clickProcessBatchMenuLink() throws InterruptedException {
        if (waitFor(menuEmploymentScreening)) {
            this.clickElement(menuEmploymentScreening);
            this.clickElement(menuProcessBatch);
            this.waitFor(btnProcessBatch);
            report("EA clicked on Process Batch link");
        } else {
            throw new RuntimeException("Employment Screening is not showing");
        }
    }

    public void clickNewOrderLink() throws InterruptedException {
        By employmentScreening = By.xpath("//td/span[text()='Employment Screening']");
        By newOrder = By.xpath("//td/span[text()='New Order']");
        By orderTitle = By.xpath("//td/div[@title='Order']");

        if (waitFor(employmentScreening)) {
            this.clickElement(employmentScreening);
            this.clickElement(newOrder);

            this.waitFor(orderTitle);
            report("EA clicked on New Order link");
        } else {
            throw new RuntimeException("Employment Screening is not showing");
        }
    }

    public void clickProcessBatchButton() throws InterruptedException {
        By btn = By.xpath("//td[@class = 'html-face' and text()='Process Batch']");
        eaClickButton(btn);
    }

    public void clickNextButton() throws InterruptedException {
        clickInLoop(eventFiringWebDriver, next, "Next button");
    }

    public void clickLogoutButton() throws Exception {
        By btn = By.xpath("//a[text()='Logout']");
        waitForElementClickable(btn);
        this.clickElement(btn);
    }

    public void clickSubmitButton() throws InterruptedException {
        By btn = By.xpath("//td[@class = 'html-face' and text()='Submit Order']");
        this.eaClickButton(btn);
    }

    private void eaClickButton(By btn) throws InterruptedException {
        this.waitFor(btn);
        for(int i=0; i < 15; i++){
            this.waitForDisappear(progressSpinner);
            if(this.exists(btn, 30)){
                try{
                    this.clickElement(btn);
                    this.wait(2);
                } catch (Exception e){
                    break;
                }
            } else {
                break;
            }
        }
    }

        public void newBatchProcessForm(String field, String value) throws Exception {
        By weField;
        switch (field.toLowerCase()) {
            case "custom package" -> {
                weField = By.id("Order.Info.Custom");
                this.selectElement(weField, value);
                this.waitForDisappear(progressSpinner);
            }
            case "upload name" -> {
                uploadName = value;
                weField = By.id("OE_NEW_ORDER_NO_BATCH_NAME_DESC_LBL");
                this.setElementValue(weField, value);
            }
            case "upload file" -> {
                //file must be renamed each time in order to successfully upload
                String[] extensions = new String[]{"xls", "xlsx"};
                Random random = new Random();
                int randomNumber = random.nextInt(10000);
                String folder = System.getProperty("user.dir") + "/src/test/resources/templates/ea/batch/";
                String file;
                List<File> files = (List<File>) FileUtils.listFiles(new File(folder), extensions, true);
                File newFileName = new File(folder + "AutoUpload" + randomNumber + ".xls");
                file = Files.move(files.get(0).toPath(), newFileName.toPath()).toString();
                driver.findElement(uploadBrowseLocation).sendKeys(file);
            }
            case "use download location" -> driver.findElement(uploadBrowseLocation).sendKeys(SharedBaseClass.fileToUse);
            default -> throw new RuntimeException("non support field: " + field);
        }
    }

    public void newOrderFillFormOrder(String field, String value){
        By weField;
        switch (field.toLowerCase()) {
            case "cid" -> {
                weField = By.xpath("(//input[contains(@id,'Order.Info.RefID')])[1]");
                waitForSeconds(1);
                setElementValue(weField, value);
                cid = value;
            }
            case "custom package" -> {
                weField = By.id("Order.Info.Custom");
                isExistAndDisplayed(eventFiringWebDriver, weField, 30);
                selectElement(weField, value);
                customPackage = value;
            }
            case "alias" -> {
                weField = By.id("Order.Info.RefID2");
                this.setElementValue(weField, value);
                alias = value;
            }
            default -> throw new RuntimeException("non support field: " + field);
        }
        waitForSeconds(3);
    }


    public void newOrderFillFormSubject(String field, String value){
        By weField;
        switch (field.toLowerCase()) {
            case "first name (given name)" -> {
                weField = By.id("Sub.Info.FirstName");
                waitForSeconds(1);
                this.setElementValue(weField, value);
                firstNameInUi = value;
            }
            case "middle name" -> {
                weField = By.id("Sub.Info.MidName");
                this.setElementValue(weField, value);
                middleNameInUi = value;
            }
            case "last name" -> {
                weField = By.id("Sub.Info.LastName");
                this.setElementValue(weField, value);
                lastNameInUi = value;
            }
            case "phone number" -> {
                weField = By.xpath("//td/div[contains(text(), 'Phone Number')]/../following-sibling::td/input");
                this.setElementValue(weField, value);
                phoneNumberInUi = value;
            }
            case "email address" -> {
                weField = By.id("Sub.Info.CandidateEmailAddress");
                this.setElementValue(weField, value);
                emailInUi = value;
            }
            case "birth month" -> {
                weField = By.id("Sub.Info.Bday_mmm");
                this.selectElement(weField, value);
                birthMonthInUi = Month.valueOf(value.toUpperCase());
                logger.info("birth month:" + birthMonthInUi);
            }
            case "birth day" -> {
                weField = By.id("Sub.Info.Bday_dd");
                this.selectElement(weField, value);
                birthDayInUi = value;
                logger.info("birth day:" + birthDayInUi);
            }
            case "birth year" -> {
                weField = By.id("Sub.Info.Bday_yyyy");
                this.setElementValue(weField, value);
                birthYearInUi = value;
                logger.info("birth year:" + birthYearInUi);
            }
            case "address 1" -> {
                weField = By.id("Sub.Info.Addr1");
                this.setElementValue(weField, value);
                addressInUi = value;
            }
            case "city" -> {
                weField = By.id("Sub.Info.City");
                this.setElementValue(weField, value);
                cityInUi = value;
            }
            case "state" -> {
                weField = By.id("Sub.Info.State");
                this.selectElement(weField, value);
                stateInUi = value;
            }
            case "zip" -> {
                weField = By.id("Sub.Info.PostalCode");
                this.setElementValue(weField, value);
                zipInUi = value;
            }
            case "have ssn" -> {
                if (value.equalsIgnoreCase("yes")) {
                    weField = By.xpath("(//input[@name='ssnKnockout'])[1]");
                } else {
                    weField = By.xpath("(//input[@name='ssnKnockout'])[2]");
                }
                this.clickElement(weField);
            }
            case "social security number" -> {
                weField = By.id("Sub.Info.Ssn");
                Random random = new Random();
                int randomNumber = random.nextInt(9999);
                if (value.equalsIgnoreCase("null")) {
                    value = "411-67-" + randomNumber;
                    logger.info("ssn value is set to:" + value);
                }
                this.setElementValue(weField, value);
                weField = By.id("Sub.Info.CondSsn");
                this.setElementValue(weField, value);
                ssnInUi = value;
            }
            default -> throw new RuntimeException("non support field: " + field);
        }
    }

    public String verifyAndGetNewOrderCreated() {
        By btnViewThisOrder = By.xpath("//td[@class = 'html-face' and text()='View This Order']");
        By byMsgBlock = By.xpath("//tr/td/div[text()='Thank you for your request.']/../../following-sibling::tr/td/span/div");
        By byOrderNumber = By.xpath("//tr/td/div[text()='Thank you for your request.']/../../following-sibling::tr/td/span//span");
        String orderId;
        WebElement we;
        if (exists(btnViewThisOrder)) {
            we = driver.findElement(byMsgBlock);
            String msg = we.getText();
            report(msg);

            we = driver.findElement(byOrderNumber);
            orderId = we.getText().trim();
        } else {
            throw new RuntimeException("Order was not created successfully.");
        }
        return orderId;
    }

    /**
     * verify Batch Upload Result
     * @param row -- zero-based row number
     */
    public boolean verifyBatchResult(int row, String expectedString) {
        By weRow = By.xpath("//th[text()='Batch ID']/../../..//tr[@__gwt_row='" + row + "']");
        WebElement element = driver.findElement(weRow);
        if (element != null) {
            return element.getText().contains(expectedString);
        }
        return false;
    }

//    public Boolean verifyHeadersExistsInExcelSheet(String headerName) throws Exception{
//        if (headerName.isEmpty()){
//            return false;
//        }
//        Path downloadFile = getDownloadedFile(false);
//        File file = new File(downloadFile.toString());
//        //Create an object of FileInputStream class to read Excel file
//        FileInputStream inputStream = new FileInputStream(file);
//        //Creating a workbook using POI library
//        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
//        HSSFSheet sheet = workbook.getSheetAt(1);
//        Row row = sheet.getRow(0);
//
//        for(int i=0; i < row.getLastCellNum(); i++)
//        {
//            if(row.getCell(i).getStringCellValue().trim().equals(headerName))
//                return true;
//        }
//        return false;
//    }

//    public void insertDataInWorksheetCell(DataTable dataTable) throws Exception{
//        logger.info("....Preparing to access the excel file....");
//        Path downloadFile = getDownloadedFile(true);
//        fileToUse = downloadFile.toString();
//        File file = new File(fileToUse);
//
//        //Create an object of FileInputStream class to read Excel file and FileOutputStream to write to Excel file
//        FileInputStream inputStream = new FileInputStream(file);
//
//
//        //getting data from the dataTable to cycle through
//        List<List<String>> table = dataTable.asLists();
//        int numRowsToCheck = table.size();
//
//        //Creating a workbook using POI library
//        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
//        HSSFSheet sheet = workbook.getSheetAt(1);
//        Row header = sheet.getRow(0);
//        int rowNumCounter = 1;
//
//        //dataTable row counter
//        for (int dataTableRowCount =1; dataTableRowCount < numRowsToCheck; dataTableRowCount++) {
//            //dataTable column counter
//            Row dataRow = sheet.createRow(rowNumCounter);
//            logger.info("current spreadsheet row (starts at 1 to leave out header): " + rowNumCounter);
//            //getting datable row
//            for (List<String> currentTableRow : table) {
//                for (int x = 0; x < currentTableRow.size(); x++) {
//                    String columnName = currentTableRow.get(x);
//                    logger.info("checking Column Name: " + columnName);
//                    String columnValue = table.get(rowNumCounter).get(x);
//                    logger.info("checking Column Value: " + columnValue +"\n");
//                    //goes through spreadsheet to the last header column
//                    for (int i = 0; i < header.getLastCellNum(); i++) {
//                        if (header.getCell(i).getStringCellValue().trim().equals(columnName)) {
//                            Cell cell = dataRow.createCell(i);
//                            //need to pass in table column value
//                            cell.setCellValue(columnValue);
//                            //write data in the Excel file
//                            FileOutputStream outputStream = new FileOutputStream(file);
//                            workbook.write(outputStream);
//                            outputStream.close();
//                            logger.info("Found a matching header in the spreadsheet.");
//                            break;
//                        }
//                    }
//                }
//            }
//            //increments spreadsheet row number counter so that it can start adding to the next row in the spreadsheet
//            rowNumCounter++;
//        }
//    }

    public String verifyMessageInXls() throws Exception{
        Path downloadFile = getDownloadedFile(false);
        File file = new File(downloadFile.toString());

        //Create an object of FileInputStream class to read Excel file
        FileInputStream inputStream = new FileInputStream(file);
        //Creating a workbook using POI library
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = workbook.getSheetAt(1);
        Row dataRow = sheet.getRow(1);
        String cellValue = dataRow.getCell(0).getStringCellValue();
        logger.info("checking row cell value " + cellValue);
        return cellValue;
    }


    public void clickDownloadTemplateButton() throws Exception{
        waitForElementClickable(downloadTemplateButton);
        clickElement(downloadTemplateButton);
    }

    public void cleanupExistingDownloadsFolders() throws Exception{
        waitForSeconds(10);
        String directory = System.getProperty("user.dir") + "/src/test/resources/downloads/";
        FileUtils.cleanDirectory(new File(directory));
    }

    public Path getDownloadedFile(Boolean renameFile) throws Exception{
        String directory = System.getProperty("user.dir") + "/src/test/resources/downloads/";
        String[] extensions = new String[] { "xls", "xlsx", "csv" };
        List<File> files = (List<File>) FileUtils.listFiles(new File(directory), extensions, true);
        Random random = new Random();
        if (files.size() == 0){
            Assert.fail("No files where found in the directory: " + directory);
        }
        if(files.size() > 1)
        {
            Assert.fail("There's more than 1 file that exists in the downloads folder. Please clean the downloads folder.");
        }
        else {
            if (renameFile) {
                int randomNumber = random.nextInt(10000);

                File newFileName = new File(files.get(0).getParent(), "Automation" + randomNumber + ".xls");
                return Files.move(files.get(0).toPath(), newFileName.toPath());
            }
            else{
                return files.get(0).toPath();
            }
        }
        return null;
    }

    public void clickViewBatchesMenuLink() throws Exception {
        waitFor(menuEmploymentScreening, 15);
        clickElement(menuEmploymentScreening);
        waitFor(menuViewBatch);
        clickElement(menuViewBatch);
        waitFor(batchTableHeader);
    }

    public void clickDownloadsBatchButton() throws Exception{
        waitForElementPresent(downloadRejectsButtonWElement(uploadName));
        clickElement(getDownloadRejectsButton(uploadName));
        logger.info("click download rejects button for " + uploadName);
    }

    public void clickCaseInQueueMenuLink() throws Exception{
        if (waitFor(menuCaseManagementScreening)) {
            this.clickElement(menuCaseManagementScreening);
            this.clickElement(menuCasesInQueue);
            waitForDisappear(progressSpinner);
            waitForDisappear(loadingWait,30);
            this.waitFor(casesInQueueHeader);
            report("EA clicked on Case Management - Cases in Queue link");
        } else {
            throw new RuntimeException("Case Management Screening is not showing");
        }
    }

    public WebElement actionsSelectorByWebElement() throws Exception {
        String xpath = "//div[contains(text(),'Actions')]/following::select[1]";
        WebElement element = driver.findElement(By.xpath(xpath));
        scrollTo(element);
        waitForDisappear(loadingWait);
        waitForElementClickable(By.xpath(xpath));
        clickElement(By.xpath(xpath));
        return element;
    }

    public void selectCaseSubject() {
        String subject = "THCMTESTMM, t".toUpperCase();
        String xpath = String.format("//div[contains(text(),'%s')]/preceding::input[@type='checkbox'][1]", subject);
        By subjectXpath = By.xpath(xpath);
        clickElement(subjectXpath);
        report("Selected " + subject);
    }

    public void actionsToSelect(String option) throws Exception{
        actionsSelectorByWebElement().sendKeys(option);
        By element = By.xpath("//*[contains(text(),'" + option + "')]");
        clickElement(element);
    }

    public void verifyActionsItemExist(String option) throws Exception{
        actionsSelectorByWebElement();
        By element = By.xpath("//*[contains(text(),'" + option + "')]");
        Assert.assertTrue(exists(element), "Action Item was not found in the list.");
    }

    public void gotoCaseAction(String actionOption) throws Exception {
        actionsToSelect(actionOption);
    }

    public void gotoCaseDetails(String actionOption) throws Exception{
        actionsToSelect(actionOption);
        waitForDisappear(loadingWait);
        waitFor(generalInformationTab, 15);
    }

    public Boolean caseStatusOnTabAssigned(String caseStatus) {
        String xpath = String.format("//div[contains(text(),'Case Status')]/following::div[contains(text(),'%s')]", caseStatus);
        By result = By.xpath(xpath);
        return exists(result);
    }

    public void availableReviewersOptionsExists(String... options){
        for(String option: options){
            By availableReviewersList = By.xpath("//div[contains(text(), 'Available Reviewers')]/following::table[1]//td/div[contains(text(),'" + option.toUpperCase() + "')]");
            Assert.assertTrue(exists(availableReviewersList), "Option " + option + " was not found in Available Reviewer's list.");
        }
    }

    public void availableProcessorsOptionsExists(String... options) {
        for(String option: options) {
            logger.info("Checking for Processor... " + option);
            By availableProcessorsList = By.xpath("//div[contains(text(), 'Available Peer Processors')]/following::table[1]//td/div[contains(text(),'" + option.toUpperCase() + "')]");
            Assert.assertTrue(exists(availableProcessorsList), "Option " + option + " was not found in Available Processor's list.");
        }
    }

    public void cmWidgetAvailable() throws Exception{
        waitForElementPresent(hpCaseManagementWidget_WebElement);
        Assert.assertTrue(exists(homepageCaseManagementWidget), "Case Management Widget was not found.");
        scrollTo(hpCaseManagementWidget_WebElement);
    }

    public void enterInformationToSearch(String searchContent){
        setElementValue(eaGlobalSearchTextBox, searchContent);
    }

    public void clickGlobalSearchButton(){
        clickElement(eaGlobalSearchButton);
        waitForDisappear(loadingWait);
    }

    public void eaSearchResultsTabsExist(){
        waitForElementPresent(eaSearchResultsTab_WebElement);
        waitForSeconds(5);
        for (int i =0; i < eaAllSearchResultTabs_WebElement.size(); i++){
                Assert.assertFalse(getText(eaAllSearchResultTabs_WebElement.get(i)) == null, "All EA Tabs for the " +
                        "Order were not found.");
        }
    }

    public void setEAOrderId() throws Exception {
        testObject.setTestData("orderID", getText(orderIdOnGeneralInfoTab_WebElement));
    }

    public void enterOrderCRFinfo(DataTable dataTable) {
        List<Map<String, String>> values = dataTable.asMaps();
        for (Map<String, String> data : values) {
            String field = testObject.processString(data.get("field"));
            String value = testObject.processString(data.get("value"));
            By weField;
            switch (field.toLowerCase()) {
                case "employee id" -> {
                    weField = By.id("Order.Info.RefID1");
                    this.setElementValue(weField, value);
                    employeeID = Integer.parseInt(value);
                    logger.info("empID" + employeeID);
                }
                case "alias" -> {
                    weField = By.id("Order.Info.RefID2");
                    this.setElementValue(weField, value);
                    orderAlias = value;
                    logger.info("alias" + orderAlias);
                }
                default -> throw new RuntimeException("non support field: " + field);
            }
        }
    }

    public void clickAdditionalSearchesTab() {
        waitForSeconds(1);
        this.clickElement(additionalSearchesTab);
    }

    public void clickReviewTab() {
        waitForSeconds(1);
        this.clickElement(reviewOrderTab);
    }

    public void selectReason(String reason) {
        waitForSeconds(5);
     selectElement(selectBoxForReason,reason);
    }
}