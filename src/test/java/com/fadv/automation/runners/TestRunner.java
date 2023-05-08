package com.fadv.automation.runners;

import com.fadv.automation.core.SeleniumBaseClass;
import com.fadv.automation.core.WebElementHelper;
import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"com.fadv.automation.stepdef"},
        plugin = {"pretty"
                , "json:target/cucumber-reports/cucumber.json"
                , "junit:target/cucumber-reports/cucumber.xml"}
        , monochrome = false
        , tags = "@Sanity_01"
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @After()
    public void afterScenario() {
        try {
            if (SeleniumBaseClass.driver != null) {
                SeleniumBaseClass.driver.quit();
                SeleniumBaseClass.eventFiringWebDriver.quit();
            }
            WebElementHelper.writeMap();
        } catch (Exception e) {
            System.err.println("Unable to close webdriver");
        }
    }
}
