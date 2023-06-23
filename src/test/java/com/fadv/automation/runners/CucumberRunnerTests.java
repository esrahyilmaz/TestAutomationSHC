package com.fadv.automation.runners;


//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;


//@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"
                , "junit:target/cucumber-reports/cucumber.xml"
        },
        features = {"src/test/resources/features"},
        glue = {"com.fadv.automation.stepdef"},
        snippets = CAMELCASE,
        //dryRun = true,
        //strict = true,
        tags = "@amazonab",
        monochrome = true
)

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This is CucumberRunnerTests");
    }
}
