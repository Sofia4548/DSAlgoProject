package dsutilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private WebDriver driver;
	
	
	OptionManager optionManager=new OptionManager();
	public static  ThreadLocal<WebDriver>tldriver=new ThreadLocal<WebDriver>();
	

	
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
			System.out.println("Inside Edge Browser");
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
	
	public static  WebDriver getDriver()
	{
		return tldriver.get();
	}

	
	
}