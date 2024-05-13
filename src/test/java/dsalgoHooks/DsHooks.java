package dsalgoHooks;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

import dsutilities.ConfigurationReader;
import dsutilities.ConfigurationReader;
import dsutilities.DriverFactory;
import dsutilities.LoggerLoad;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class DsHooks {
	private WebDriver driver;
	private DriverFactory driverfactory;

	@Before(order=0)
	
	public void launchbrowser() throws Throwable
	{
		String browser=ConfigurationReader.getBrowserType();
		driverfactory=new DriverFactory();
		//String browser=ConfigurationReader.getProperty("config","chromeBrowser");
		driver=driverfactory.inint(browser);
		
	}
	
	@After(order=0)
	public void quitbrowser()
	{
		driver.quit();
	}
	
	@After(order=1)
	public void teardown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String screenShotName=scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath,"image/png", screenShotName);
		}
	}

}
