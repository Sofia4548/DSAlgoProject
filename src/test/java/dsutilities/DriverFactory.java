package dsutilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	OptionManager optionManager=new OptionManager();
	public static  ThreadLocal<WebDriver>tldriver=new ThreadLocal<>();
	
	//This Method initialize the threadlocal driver based on the given browser name
	public WebDriver inint(String browser)
	{
		LoggerLoad.info(browser);		
		System.out.println(browser);
		
		if(browser.equals("google chrome"))
		{		
			driver=new ChromeDriver(optionManager.getChromeOptions());
			tldriver.set(driver);
		}
		else if(browser.equals("firefox"))
		{
			
			driver=new FirefoxDriver(optionManager.getFireFoxOptions());
			tldriver.set(driver);
		}
//		if(browser.equals("edgeBrowser"))
//		{
//			driver=new EdgeDriver(optionManager.getEdgeOptions());
//			tldriver.set(driver);
//		}
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
