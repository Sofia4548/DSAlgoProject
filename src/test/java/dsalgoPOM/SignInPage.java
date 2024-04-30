package dsalgoPOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

	private WebDriver driver;
	private By username=(By.xpath("//input[@name='username']"));
	private By password=(By.xpath("//input[@id='id_password']"));
	private By submit=(By.xpath("//input[@value='Login']"));
	private By heading=(By.linkText("NumpyNinja"));

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	public void signInURL() {
		driver.get("https://dsportalapp.herokuapp.com/login");
	}
	public void usernameEnter(String usr)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(usr);
		
	}
	public void passwordEnter(String pwd)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		driver.findElement(password).clear();
		 driver.findElement(password).sendKeys(pwd);
	}
	public void submitClick()
	{
		 driver.findElement(submit).click();
	}
	public String numpaNinjaText()
	{
		return driver.findElement(heading).getText();
	}
}
