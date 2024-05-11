package dsutilities;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	// WebDriver driver;
	private WebDriver driver;
	//new
//	public static ChromeOptions co=new ChromeOptions();
//	public static EdgeOptions ed=new EdgeOptions();
//	
	
	OptionManager optionManager=new OptionManager();
	public static  ThreadLocal<WebDriver>tldriver=new ThreadLocal<WebDriver>();
	
	
	/*
	 * This Method initialize the threadlocal driver based on the given browser name
	 */
	
	public WebDriver inint(String browser)
	{
		System.out.println(browser);
		if(browser.equals("google chrome"))
		{			
			driver=new ChromeDriver(optionManager.getChromeOptions());
			tldriver.set(driver);
			
		}
		if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver(optionManager.getFireFoxOptions());
			tldriver.set(driver);
		}
		if(browser.equals("msedge"))
		{
			driver=new EdgeDriver(optionManager.getEdgeOptions());
			tldriver.set(driver);
		}
		else
		{
			System.out.println("Enter the correct browser name"+browser);
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		return getDriver();
			
	}
	//This method gets the webdriver with threadlocal
	public static  WebDriver getDriver()
	{
		return tldriver.get();
	}

	
	
}
