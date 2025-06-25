package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = { "src/test/resources/feature" },
    glue = { "stepdef" }
)
public class ApiTestRunner extends AbstractTestNGCucumberTests { }