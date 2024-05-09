package dsalgoPOM;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSStack_Page {

	private WebDriver driver;
	
	@FindBy(xpath="//div//pre[@id='output']")
	WebElement result;
	@FindBy(xpath="//button[text()='Run']")
	WebElement Runbtn;
	@FindBy(xpath="//form[@id='answer_form']/div/div/div[1]/textarea")
	WebElement TextEditor;
	@FindBy(xpath="//a[@href='/tryEditor']")
	WebElement Tryherebtn;
	@FindBy(xpath="//div[@class='navbar-nav']//a[@href='/logout']")
	WebElement signoutbtn;
	@FindBy(xpath="//*[contains(text(),'Logged out successfully')]")
	WebElement logoutmsg;
	@FindBy(xpath="//a[@href='stack']")
	WebElement Stacklink;
	
	public DSStack_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	public void StackHomePage() throws FileNotFoundException, IOException, InterruptedException
	{
		Stacklink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	public List<WebElement> getLinkByTopics(String topic)
	{
		List<WebElement>linksByTopic=new ArrayList<WebElement>();
		List<WebElement>AllLinks=driver.findElements(By.tagName("a"));
		 for(WebElement link:AllLinks)
		{
		
			 String linkText=link.getText();
			 String linkURL=link.getAttribute("href");
			if (linkText.equalsIgnoreCase(topic))
			{
	            linksByTopic.add(link);
			}
}
		 return linksByTopic;
		}
	public String GetCurrentlinkurl()
	{
		 return driver.getTitle();
	}
	
	public void clicktryherebutton()
	{
		//driver.findElement(Tryherebtn).click();
		Tryherebtn.click();
	}
	
	public String geturltitle() {
		
		return driver.getTitle();
	}
	public void EnterCode(String code) throws InterruptedException
	{
		
		
		TextEditor.sendKeys(code);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Runbtn.click();
	}
	public String Getoutput()
	{
		//String msg=driver.findElement(result).getText();
		String msg=result.getText();
		return msg;
	}

	
		public String getAlertMsg()
		{
			String alerttext=null;
			
				
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)) ; 
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert();
		alerttext=alert.getText();
		alert.accept();
	   return alerttext;
		}
		public String NavigateBack()
		{
			driver.navigate().back();
			return driver.getTitle();
			
		}
		public void LogOut()
		{
			signoutbtn.click();
			
		}
		public String ReadLogoutmsg()
		{
			//String msg=driver.findElement(logoutmsg).getText();
			String msg=logoutmsg.getText();
			return msg;
		}
}
