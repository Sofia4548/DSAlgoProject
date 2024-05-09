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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TreePage {
	private WebDriver driver;
	private By result=By.xpath("//div//pre[@id='output']");
	private By Runbtn=By.xpath("//button[text()='Run']");
	private By TextEditor=By.xpath("//form[@id='answer_form']/div/div/div[1]/textarea");
	private By Tryherebtn=By.xpath("//a[@href='/tryEditor']");
	private By signoutbtn=By.xpath("//div[@class='navbar-nav']//a[@href='/logout']");
	private By logoutmsg=By.xpath("//*[contains(text(),'Logged out successfully')]");
	private By treelink=By.xpath("//a[@href='tree']");
	public TreePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void TreeHomePage() throws FileNotFoundException, IOException, InterruptedException
	{
		driver.findElement(treelink).click();
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
		driver.findElement(Tryherebtn).click();
	}
	
	public String geturltitle() {
		
		return driver.getTitle();
	}
	public void EnterCode(String code) throws InterruptedException
	{
		driver.findElement(TextEditor).sendKeys(code);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(Runbtn).click();
	}
	public String Getoutput()
	{
		String msg=driver.findElement(result).getText();
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
			
			driver.findElement(signoutbtn).click();
		}
		public String ReadLogoutmsg()
		{
			String msg=driver.findElement(logoutmsg).getText();
			return msg;
		}
		
}
