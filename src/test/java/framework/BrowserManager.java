package framework;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserManager {
// BrowserManager class is going to manage WebDriver Instance
	OptionManager optionManager=new OptionManager();
	public static WebDriver driver;
	public WebDriver startBrowser() throws FileNotFoundException, IOException
	{
		//String browserName="chrome";
//		String driverName = ConfigurationReader.getProperty("config", "chromeBrowser");
//        System.out.println(ConfigurationReader.getProperty("config", "chromeBrowser"));
		
		String browserName=ConfigurationReader.getProperty("config","chromeBrowser");
		System.out.println(ConfigurationReader.getProperty("config","chromeBrowser"));
		if(browserName.equalsIgnoreCase("google chrome"))
		{
			driver=new ChromeDriver(optionManager.getChromeOptions());
		}
		else if(browserName.equalsIgnoreCase("msedge"))
		{
			driver=new EdgeDriver(optionManager.getEdgeOptions());
		}
		System.out.println(browserName + "Browser Started");
		return driver;
	}
	public void quitBrowser()
	{
		driver.quit();
	}
}
