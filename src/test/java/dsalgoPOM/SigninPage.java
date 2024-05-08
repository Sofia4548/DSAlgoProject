package dsalgoPOM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SigninPage {
	
	public WebDriver driver;
	private By username=By.xpath("//input[@name='username']");
	private By password=By.xpath("//input[@id='id_password']");
	private By loginbtn=By.xpath("//input[@value='Login']");
	private By heading=(By.linkText("NumpyNinja"));

	public SigninPage(WebDriver driver)
	{
		this.driver=driver;
		//wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
	}
	
	public void  dsalgohomepage() throws IOException
	{
		driver.get("https://dsportalapp.herokuapp.com/login");

	}
	
	public void LoginProcess(String uname,String pswrd)
	{	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(uname);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pswrd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}
	public String numpaNinjaText()
	{
		return driver.findElement(heading).getText();
	}
	public void clicklogin()
	{
		driver.findElement(loginbtn).click();
	}

}
