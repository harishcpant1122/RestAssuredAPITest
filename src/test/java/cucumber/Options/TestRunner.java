package cucumber.Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/features",
		glue= {"stepDefinitions"},
		plugin = { "pretty", "html:target/cucumber-reports", "json:target/cucumber.json" }
		)
public class TestRunner extends AbstractTestNGCucumberTests 
{

}
