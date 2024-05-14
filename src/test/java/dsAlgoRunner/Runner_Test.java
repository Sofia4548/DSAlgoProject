package dsAlgoRunner;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import dsalgoHooks.*;
import dsutilities.ConfigurationReader;
import dsutilities.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"pretty","html:src/test/resources/Reports/TestReport.html","json:src/test/resources/Reports/cucumber.json"},
		features = "src/test/resources/Features/DSStack.feature",
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
//	@BeforeTest
//	@Parameters("browser")
//	
//	public void defineBrowser( @Optional("chrome") String browser) throws Throwable{
//	//public void defineBrowser(String browser) throws Throwable {
//
//	ConfigurationReader.setBrowserType(browser);
//}

}