package dsalgoPOM;


import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Properties;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public void usernameEnter(String Usrname)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(Usrname);
		
	}
	public void passwordEnter(String Pswd)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		driver.findElement(password).clear();
		 driver.findElement(password).sendKeys(Pswd);
	}
	public void clicklogin()
	{
		driver.findElement(loginbtn).click();
	}
	

	public String numpaNinjaText() {
		return driver.findElement(heading).getText();
	}

	
	}
	
	
	
