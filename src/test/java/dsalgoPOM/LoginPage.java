package dsalgoPOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class LoginPage{
	
	private WebDriver driver;
	private By getstarted=(By.linkText("Get Started"));
	private By signIn=(By.linkText("Sign in"));
	private By username=(By.xpath("//input[@name='username']"));
	private By submit=(By.xpath("//input[@value='Login']"));
	private By password=(By.xpath("//input[@id='id_password']"));
	private By invaildMsg=(By.xpath("//*[@class='alert alert-primary']"));
	private By heading=(By.linkText("NumpyNinja"));
	
	WebElement getStartedLink;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void homePage() {
		driver.get("https://dsportalapp.herokuapp.com/");
		 driver.findElement(getstarted).click();
	}
	public void signInLink()
	{
		driver.findElement(signIn).click();;
	}
	
//	public void usernameEnterBlank()
//	{
//		driver.findElement(username).sendKeys(Keys.TAB);
//		
//	}
//	public void passwordEnterBlank()
	
	public void usernameEnter(String usr)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(usr);
		
	}
	public void submitClick()
	{
		 driver.findElement(submit).click();
	}
	public String  validationMsgForPassword()
	{
		WebElement activeElement=  driver.switchTo().activeElement();
		String messageStr = activeElement.getAttribute("validationMessage");
		return messageStr;
	}
	public void passwordEnter(String pwd)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		driver.findElement(password).clear();
		 driver.findElement(password).sendKeys(pwd);
	}
	public String invalidErrorMessag()
	{
		return driver.findElement(invaildMsg).getText();
	}
	public String numpaNinjaText()
	{
		return driver.findElement(heading).getText();
	}
}
