package com.fadv.automation.stepdef;

import com.fadv.automation.core.BaseClass;
import com.fadv.automation.core.SeleniumBaseClass;
import com.fadv.automation.core.TestObject;
import com.fadv.automation.core.WebElementHelper;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

public class Hooks extends BaseClass {
    final static SeleniumBaseClass seleniumBaseClass = new SeleniumBaseClass(null);
    public static WebDriver driver = null;

    @BeforeAll
    public static void beforeAll() {
        getEnv();
    }

    /**
     * @return env info from system variable, property file or excel
     */
    public static String getEnv() {
        if (System.getProperty("env") != null) {
            env = System.getProperty("env");
            logger.info("Environment " + env + " selected from command line");
        }
        return env;
    }

    @Before
    public void before(Scenario scenario) throws Exception {
        driver = seleniumBaseClass.setBrowserFromProperty(driver);
        driver = seleniumBaseClass.setEventDriver();
        testObject = TestObject.createWith(scenario);
        WebElementHelper.setRecordMode();

    }

    @After
    public void after(Scenario scenario) throws Exception {
        WebElementHelper.writeMap();

    }

    @AfterAll
    public static void after_all() throws Exception {

        if (seleniumBaseClass.htmlCsRunner != null) {
            try {
                seleniumBaseClass.htmlCsRunner.generateHtmlReport();
            } catch (Exception e) {

            }

        }
    }
}
