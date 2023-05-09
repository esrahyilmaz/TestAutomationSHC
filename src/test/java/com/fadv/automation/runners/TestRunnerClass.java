package com.fadv.automation.runners;

import com.fadv.automation.core.SeleniumBaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"com.fadv.automation.stepdef"},
        plugin = {"pretty"
                , "json:target/cucumber-reports/cucumber.json"
                , "junit:target/cucumber-reports/cucumber.xml"}
        , monochrome = false
        , tags = "@Sanity_01"
)
public class TestRunnerClass extends AbstractTestNGCucumberTests {

    @AfterSuite
    public void afterSuite() {
        try {
            if (SeleniumBaseClass.driver != null) {
                SeleniumBaseClass.driver.quit();
                SeleniumBaseClass.eventFiringWebDriver.quit();
            }
        } catch (Exception e) {
            System.err.println("Unable to close webdriver");
        }
    }

}
