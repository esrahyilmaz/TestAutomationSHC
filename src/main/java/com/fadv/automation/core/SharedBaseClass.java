package com.fadv.automation.core;


import io.cucumber.datatable.DataTable;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SharedBaseClass extends BaseClass {

    //private WebDriverWait wait;
    public static String fileToUse;
    protected final WebDriver driver;

    public SharedBaseClass(WebDriver driver) {
        this.driver = driver;
    }

    public String getLast4SsNumber(String wholeSsN) {
        return wholeSsN.substring(wholeSsN.length() - 4);
    }

    public String getAlias(String alias) {
        return alias;
    }

    public void browserRefresh() {
        driver.navigate().refresh();
    }

    public void switchWindow() {
        //Switch to new window opened
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public void clearAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public void switchToParentWindow() {
        logger.info("switching to main window");
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }


    public void insertDataInWorksheetCell(DataTable dataTable, boolean useForUploadToAdminUI) throws Exception {
        Path downloadFile;
        logger.info("....Preparing to access the excel file....");
        if (useForUploadToAdminUI) {
            downloadFile = getFileToUpload("AutoBulkUploadFile.csv");
        } else {
            downloadFile = getDownloadedFile(true);
        }
        fileToUse = downloadFile.toString();
        File file = new File(fileToUse);

        //Create an object of FileInputStream class to read Excel file and FileOutputStream to write to Excel file
        FileInputStream inputStream = new FileInputStream(file);


        //getting data from the dataTable to cycle through
        List<List<String>> table = dataTable.asLists();
        int numRowsToCheck = table.size();

        //Creating a workbook using POI library
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = workbook.getSheetAt(1);
        Row header = sheet.getRow(0);
        int rowNumCounter = 1;

        //dataTable row counter
        for (int dataTableRowCount = 1; dataTableRowCount < numRowsToCheck; dataTableRowCount++) {
            //dataTable column counter
            Row dataRow = sheet.createRow(rowNumCounter);
            logger.info("current spreadsheet row (starts at 1 to leave out header): " + rowNumCounter);
            //getting datable row
            for (List<String> currentTableRow : table) {
                for (int x = 0; x < currentTableRow.size(); x++) {
                    String columnName = currentTableRow.get(x);
                    logger.info("checking Column Name: " + columnName);
                    String columnValue = table.get(rowNumCounter).get(x);
                    logger.info("checking Column Value: " + columnValue + "\n");
                    //goes through spreadsheet to the last header column
                    for (int i = 0; i < header.getLastCellNum(); i++) {
                        if (header.getCell(i).getStringCellValue().trim().equals(columnName)) {
                            Cell cell = dataRow.createCell(i);
                            //need to pass in table column value
                            cell.setCellValue(columnValue);
                            //write data in the Excel file
                            FileOutputStream outputStream = new FileOutputStream(file);
                            workbook.write(outputStream);
                            outputStream.close();
                            logger.info("Found a matching header in the spreadsheet.");
                            break;
                        }
                    }
                }
            }
            //increments spreadsheet row number counter so that it can start adding to the next row in the spreadsheet
            rowNumCounter++;
        }
    }

    public void insertDataInWorksheetCell2(DataTable dataTable, boolean useForUploadToAdminUI) throws Exception {
        Path downloadFile;
        logger.info("....Preparing to access the excel file....");
        if (useForUploadToAdminUI) {
            downloadFile = getFileToUpload2();
        } else {
            downloadFile = getDownloadedFile(true);
        }
        fileToUse = downloadFile.toString();
        File file = new File(fileToUse);

        //Create an object of FileInputStream class to read excel file and FileOutputStream to write to excel file
        FileInputStream inputStream = new FileInputStream(file);


        //getting data from the dataTable to cycle through
        List<List<String>> table = dataTable.asLists();
        int numRowsToCheck = table.size();

        //Creating a workbook using POI library
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = workbook.getSheetAt(0);
        Row header = sheet.getRow(0);
        int rowNumCounter = 1;

        //dataTable row counter
        for (int dataTableRowCount = 1; dataTableRowCount < numRowsToCheck; dataTableRowCount++) {
            //dataTable column counter
            Row dataRow = sheet.createRow(rowNumCounter);
            logger.info("current spreadsheet row (starts at 1 to leave out header): " + rowNumCounter);
            //getting datable row
            for (List<String> currentTableRow : table) {
                for (int x = 0; x < currentTableRow.size(); x++) {
                    String columnName = currentTableRow.get(x);
                    logger.info("checking Column Name: " + columnName);
                    String columnValue = table.get(rowNumCounter).get(x);
                    logger.info("checking Column Value: " + columnValue + "\n");
                    //goes through spreadsheet to the last header column
                    for (int i = 0; i < header.getLastCellNum(); i++) {
                        if (header.getCell(i).getStringCellValue().trim().equals(columnName)) {
                            Cell cell = dataRow.createCell(i);
                            //need to pass in table column value
                            cell.setCellValue(columnValue);
                            //write data in the excel file
                            FileOutputStream outputStream = new FileOutputStream(file);
                            workbook.write(outputStream);
                            outputStream.close();
                            logger.info("Found a matching header in the spreadsheet.");
                            break;
                        }
                    }
                }
            }
            //increments spreadsheet row number counter so that it can start adding to the next row in the spreadsheet
            rowNumCounter++;
        }
    }

    public Path getDownloadedFile(Boolean renameFile) throws Exception {
        String directory = System.getProperty("user.dir") + "/src/test/resources/downloads/";
        String[] extensions = new String[]{"xls", "xlsx", "csv"};
        List<File> files = (List<File>) FileUtils.listFiles(new File(directory), extensions, true);
        Random random = new Random();
        if (files.size() == 0) {
            Assert.fail("No files where found in the directory: " + directory);
        }
        if (files.size() > 1) {
            Assert.fail("There's more than 1 file that exists in the downloads folder. Please clean the downloads folder.");
        } else {
            if (renameFile) {
                int randomNumber = random.nextInt(10000);

                File newFileName = new File(files.get(0).getParent(), "Automation" + randomNumber + ".xls");
                return Files.move(files.get(0).toPath(), newFileName.toPath());
            } else {
                return files.get(0).toPath();
            }
        }
        return null;
    }

    public Path getFileToUpload(String fileName) {
        String directory = System.getProperty("user.dir") + "/src/test/resources/uploads/" + fileName;
        String[] extensions = new String[]{"xls", "xlsx", "csv"};
        List<File> files = (List<File>) FileUtils.listFiles(new File(directory), extensions, true);
        if (files.size() == 0) {
            Assert.fail("No files where found in the directory: " + directory);
        }
        if (files.size() > 1) {
            Assert.fail("There's more than 1 file that exists in the downloads folder. Please clean the downloads folder.");
        } else {
            return files.get(0).toPath();
        }
        return null;
    }

    public Path getFileToUpload2() throws Exception {
        String directory = System.getProperty("user.dir") + "/src/test/resources/uploads/";
        String[] extensions = new String[]{"xls", "xlsx", "csv"};
        List<File> files = (List<File>) FileUtils.listFiles(new File(directory), extensions, true);

        for (File file : files) {
            if (file.getName().equals("AutoBulkUploadFile.csv")) {
                logger.info("file= " + file.getName());
                return file.toPath();

            }
        }
        return null;
    }

    public Boolean verifyHeadersExistsInExcelSheet(String headerName) throws Exception {
        if (headerName.isEmpty()) {
            return false;
        }
        Path downloadFile = getDownloadedFile(false);
        File file = new File(downloadFile.toString());
        //Create an object of FileInputStream class to read Excel file
        FileInputStream inputStream = new FileInputStream(file);
        //Creating a workbook using POI library
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = workbook.getSheetAt(1);
        Row row = sheet.getRow(0);

        for (int i = 0; i < row.getLastCellNum(); i++) {
            if (row.getCell(i).getStringCellValue().trim().equals(headerName))
                return true;
        }
        return false;
    }

    public String verifyMessageInXls() throws Exception {
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

    public Boolean checkIsEnabled(WebElement element) {
        return element.isEnabled();
    }

}
