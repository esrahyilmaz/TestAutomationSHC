package com.fadv.automation.core;

import com.aventstack.extentreports.Status;

import java.util.logging.Logger;

public class BaseClass {
    public static final Logger logger = Logger.getLogger(BaseClass.class.getName());
    protected static TestObject testObject;
    protected ExtentReporter reporter = null;
    public static String env = "";

    public BaseClass() {
    }

    public BaseClass(TestObject to) {
        this.setTestObject(to);
    }

    public void setTestObject(TestObject testObject) {
        BaseClass.testObject = testObject;
        this.reporter = testObject.getReporter();
    }

    public void report(Object message) {
        logger.info(message.toString());
        logger.info("testObject.getScenario() is " + testObject.getScenario());

        if (reporter != null) {
            reporter.getRepLog().log(Status.INFO, message.toString());
        }
        if (testObject.getScenario() != null) {
            testObject.getScenario().log(message.toString());
        }
    }

    public void report(Status status, Object message) {
        logger.info(message.toString());

        if (reporter != null) {
            reporter.getRepLog().log(status, message.toString());
        }
        if (testObject.getScenario() != null) {
            testObject.getScenario().log(message.toString());
        }
    }


}
