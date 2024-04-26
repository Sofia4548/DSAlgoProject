package dsalgoHooks;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import dsutilities.ConfigurationReader;
import dsutilities.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class DsHooks {
	private WebDriver driver;
	private DriverFactory driverfactory;
	private Properties prop;
	@Before(order=0)
	public void launchbrowser() throws FileNotFoundException, IOException
	{
		driverfactory=new DriverFactory();
		String browserName=ConfigurationReader.getProperty("config","chromeBrowser");
		driver=driverfactory.inint(browserName);
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
