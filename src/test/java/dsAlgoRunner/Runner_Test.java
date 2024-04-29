package dsAlgoRunner;


import org.testng.annotations.DataProvider;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"pretty","html:src/test/resources/Reports/TestReport.html"},
		features = "src/test/resources/Features/Stack.feature",
		glue = {"dsalgo_stepdefinition","dsalgoHooks"}, 
		tags = "",
		monochrome = true, 
		dryRun = false)
public class Runner_Test extends AbstractTestNGCucumberTests{
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
				
		return super.scenarios();	
    }
}
