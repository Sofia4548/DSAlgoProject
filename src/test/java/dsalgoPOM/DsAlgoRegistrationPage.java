package dsalgoPOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class DsAlgoRegistrationPage{
	private WebDriver driver;
	private By username=By.xpath("//input[contains(@id,'id_username')]");
	private By password=By.xpath("//input[contains(@id,'id_password1')]");
	private By passwordconfirm=By.xpath("//input[contains(@id,'id_password2')]");
	private By registerbtn=By.xpath("//input[@type='submit' and @value='Register']");
	private By pswrdmismatcherror=By.xpath(" //*[contains(@class,'alert alert-primary')]");
	private By successmsg=By.xpath("//div[@class='alert alert-primary']");
	private By registerlink=By.xpath("//ul//a[text()=' Register ']");
	public DsAlgoRegistrationPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void openRegistrationPage() {
	        driver.get("https://dsportalapp.herokuapp.com/register");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }
	
public void enterusrname(String uname) throws InterruptedException
	{
		driver.findElement(username).clear();
	    driver.findElement(username).sendKeys(uname);	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		
	}
	public void clickregisterbtn()
	{
		
		driver.findElement(registerbtn).click();
	}
	public void enterpassword(String pswrd)
	{
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pswrd);
	}
	public void enterpasswordconfirm(String pswrdconfirm)
	{
		driver.findElement(passwordconfirm).clear();
		driver.findElement(passwordconfirm).sendKeys(pswrdconfirm);
	}
	public String getMessageBelowPasswordTextbox()
	{
		WebElement activeElement = driver.switchTo().activeElement();
		String messageStr = activeElement.getAttribute("validationMessage");
		return(messageStr);
		
	}
		
	public String getMessageBelowUsername()
	{
		WebElement activeElement = driver.switchTo().activeElement();
		String messageStr = activeElement.getAttribute("validationMessage");
		return(messageStr);
	}
	
	
	public void enterinvalidusername(String invalidname)
	{
		driver.findElement(username).sendKeys(invalidname);	
		}
	
	public String getPageText() {
		WebElement activeElement = driver.switchTo().activeElement();
		String messageStr = activeElement.getAttribute("validationMessage");
		return(messageStr);
        
    }
	
	public void checkpasswordwithnumbers(String uname,String pswrd)
	{
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pswrd);
	}
	public void checkpswrdlength(String uname,String pswrd)
	{
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pswrd);
	}
	public void checkcommonpswrd(String uname,String pswrd)
	{
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pswrd);
	}
	
	public String getPswrdinvalidText() {
        

		WebElement activeElement = driver.switchTo().activeElement();
		String messageStr = activeElement.getAttribute("validationMessage");
		//System.out.println("Actual message appeared on screen: " + messageStr);
		return(messageStr);
	}
	public String getMessageBelowPasswordConfirmTextbox()
	{
		WebElement activeElement = driver.switchTo().activeElement();
		String messageStr = activeElement.getAttribute("validationMessage");
		//System.out.println("Actual message appeared on screen: " + messageStr);
		return(messageStr);
		
	}
	
	public void clickregisterLink()
	{
		driver.findElement(registerlink).click();
	}
	public void checkPasswordMismatch(String uname,String pswrd,String pswrdconfirm)
	{
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pswrd);
		driver.findElement(passwordconfirm).clear();
		driver.findElement(passwordconfirm).sendKeys(uname);
		}
	
	public String getpasswordmismatcherrormessage()
	{
		String mismatcherror=driver.findElement(pswrdmismatcherror).getText();
		return(mismatcherror);
	}

	public void ValidCredentials(String uname,String pswrd,String pswrdconfirm)
	{
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pswrd);
		driver.findElement(passwordconfirm).clear();
		driver.findElement(passwordconfirm).sendKeys(pswrdconfirm);
		
	}
	
	public String GetSuccessMessage()
	{
	String getsuccessmsg=driver.findElement(successmsg).getText();
	return(getsuccessmsg);
	}
	

}
