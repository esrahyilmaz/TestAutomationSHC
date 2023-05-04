package com.fadv.automation.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.util.logging.Logger;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReporter {
    static Logger logger = Logger.getLogger(ExtentReporter.class.getName());

    private String scenarioName = null;
    private String reportPath = null;
    public ExtentReports extent= null;
    public ExtentTest repLog;

    public ExtentReporter(String scenarioName) {
        initReportDir();
        extent=new ExtentReports();
        createScenario(scenarioName);
    }

    public ExtentTest getRepLog() {
        return repLog;
    }

    public void createScenario(String scenarioName) {
        this.scenarioName = scenarioName;
        extent.attachReporter();
        repLog=extent.createTest(scenarioName);
    }

    public void initReportDir() {
        try{
            String reportDir = System.getProperty("user.dir") + "\\extentreport-results";
            String reportDateDir = reportDir + "\\" + getDate();
            reportPath = reportDateDir + "\\Report_" + getTime();
            createFolder(reportDir);
            createFolder(reportDateDir);
            createFolder(reportPath);
        }
        catch(Exception e) {
            logger.info("Failed - Error in function initReportDir(): "+e.getMessage());
            logger.info("Failed to create report directory ");
        }
    }

    public String getDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = new Date();
        return formatter.format(date);
    }

    public String getTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("HH-mm-ss-SSS");
        Date date = new Date();
        return formatter.format(date);
    }

    public void createFolder(String path) {
        File file = new File(path);
        if (!file.exists()) {
            if (file.mkdir()) {
                logger.info("Folder is created -- " + path);
            } else {
                logger.info("Failed to create folder!");
            }
        }
    }

    public void endReporting() {
        extent.flush();
    }

    public static void main(String[] a) {
        ExtentReporter r = new ExtentReporter("Test1");
        r.getRepLog().log(Status.INFO, "Testing 123");
        r.getRepLog().log(Status.INFO, "more testing");
        r.endReporting();
    }
}
