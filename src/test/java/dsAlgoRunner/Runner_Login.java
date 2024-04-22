package dsAlgoRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"pretty","html:src/test/resources/Reports/login.html"},
		features = "src/test/resources/Features",
		glue = "dsAlgoStepDefinition", 
		tags = "",
		monochrome = true, 
		dryRun = false)
public class Runner_Login extends AbstractTestNGCucumberTests{

}
