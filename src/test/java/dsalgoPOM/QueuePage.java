package dsalgoPOM;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QueuePage {

	private WebDriver driver;
	private WebDriverWait wait;
	private By Queuelink=By.xpath("//a[@href='queue']");
	private By Tryherebtn=By.xpath("//a[text()='Try here>>>']");
	private By Runbtn=By.xpath("//button[text()='Run']");
	private By TextEditor=By.xpath("//*[@id=\"answer_form\"]/div/div/div[1]/textarea");
	private By result=By.xpath("//div//pre[@id='output']");
    private By signoutbtn=(By.xpath("//a[text()='Sign out']"));
    private By logoutMsg =(By.xpath("//div[@class='alert alert-primary']"));	

public QueuePage(WebDriver driver) {
	
		this.driver=driver;
			
}
	
public void QueuehomePage()throws FileNotFoundException, IOException, InterruptedException {
	driver.findElement(Queuelink).click();
	Thread.sleep(2000);
	
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
public void EnterCode(String code) throws InterruptedException{

	driver.findElement(TextEditor).sendKeys(code);
	
	driver.findElement(Runbtn).click();
	Thread.sleep(2000);
}
public String Getoutput() {
	
	String msg=driver.findElement(result).getText();
    return msg;

}

public String getAlertMsg() {
	
		String alerttext=null;
		
			
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)) ; 
	Alert alert=wait.until(ExpectedConditions.alertIsPresent());
	driver.switchTo().alert();
	alerttext=alert.getText();
	alert.accept();
   return alerttext;
	}


public String NavigateBack() {
	
		driver.navigate().back();
		return driver.getTitle();
		
}

public void LogOut() throws InterruptedException {
	
	
	driver.findElement(signoutbtn).click();
	
	Thread.sleep(2000);
		
}
public String Logoutmsg() {
	
		String LogoutMsg=driver.findElement(logoutMsg).getText();
		return LogoutMsg;
			
		
	}
	
}
	 
	