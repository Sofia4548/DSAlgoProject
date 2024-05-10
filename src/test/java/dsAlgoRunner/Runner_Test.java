package dsAlgoRunner;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import dsutilities.ConfigurationReader;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)

@CucumberOptions(
		plugin= {"pretty","html:src/test/resources/Reports/TestReport.html"},
		features = "src/test/resources/Features/",
		glue = {"dsalgo_stepdefinition","dsalgoHooks"}, 
		tags = "",
		monochrome = true, 
		dryRun = false)

public class Runner_Test extends AbstractTestNGCucumberTests{
//	@BeforeTest
//	@Parameters({"Browser"})
//	public void defineBrowser(String browser) throws Throwable{
//		ConfigurationReader.setBrowserType(browser);
//		System.out.println(browser);
//	}
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
				
		return super.scenarios();	
    }
}
