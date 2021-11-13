package StepDefinitions;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
// Commenting out imports - info.cukes moved to io.cucumber
//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/Features/scenario1.feature","src/test/resources/Features/scenario2.feature","src/test/resources/Features/scenario3.feature"},
glue={"StepDefinitions"}, 
monochrome=true,
plugin = "html:target/cucumber-report.html",
tags="@smoketest")

public class TestRunner {
 
}