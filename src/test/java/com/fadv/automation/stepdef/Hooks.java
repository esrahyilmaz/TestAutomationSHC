package com.fadv.automation.stepdef;

import com.fadv.automation.core.BaseClass;
import com.fadv.automation.core.SeleniumBaseClass;
import com.fadv.automation.core.TestObject;
import com.fadv.automation.core.WebElementHelper;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.sridharbandi.HtmlCsRunner;
import org.openqa.selenium.WebDriver;

public class Hooks extends BaseClass {
    final static SeleniumBaseClass seleniumBaseClass = new SeleniumBaseClass(null);
    private WebDriver driver = null;

    @Before
    public void before(Scenario scenario) throws Exception {
        WebElementHelper.setRecordMode();
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
