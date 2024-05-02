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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TreePage {
	private WebDriver driver;
	
//	@FindBy(xpath="//a[@href='/tryEditor']")
//	WebElement Tryherebtn;
//	//@FindBy(xpath="//form[@id='answer_form']/div/div/div[1]/textarea")
//	@FindBy(xpath="//div[@class='CodeMirror cm-s-default']//div//textarea")
//	WebElement TextEditor;
//	@FindBy(xpath="//button[text()='Run']")
//	WebElement Runbtn;
//	@FindBy(xpath="//div//pre[@id='output']")
//	WebElement result;
	private By result=By.xpath("//div//pre[@id='output']");
	private By Runbtn=By.xpath("//button[text()='Run']");
	private By TextEditor=By.xpath("//form[@id='answer_form']/div/div/div[1]/textarea");
	private By Tryherebtn=By.xpath("//a[@href='/tryEditor']");
	public TreePage(WebDriver driver)
	{
		this.driver=driver;
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	public void TreeHomePage() throws FileNotFoundException, IOException, InterruptedException
	{
		driver.get("https://dsportalapp.herokuapp.com/tree/");
		Thread.sleep(2000);
//		properties.load(new FileInputStream("dsalgo.properties"));
//		String url = properties.getProperty("dsalgologin");
//		driver.get(url);
	}
	public List<WebElement> getLinkByTopics(String topic)
	{
		List<WebElement>linksByTopic=new ArrayList<WebElement>();
		List<WebElement>AllLinks=driver.findElements(By.tagName("a"));
		 for(WebElement link:AllLinks)
		{
			String linkText = link.getText().trim(); // Trim whitespace

			//System.out.println("Links: " + linkText);
//	        System.out.println("Topics:"+topic);
	        if (linkText.equals(topic)) {
	            linksByTopic.add(link);
	        }

			//System.out.println(linksByTopic);
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
		//Tryherebtn.click();
	}
	
	public String geturltitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
	public void EnterCode(String code) throws InterruptedException
	{
		//
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		try {
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(TextEditor));
		//driver.findElement(TextEditor).clear();
		driver.findElement(TextEditor).sendKeys(code);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		TextEditor.clear();
//		TextEditor.sendKeys(code);
	}
	public void Submitcode() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(Runbtn).click();
		//Runbtn.click();
	}
	
	public String Getoutput()
	{
		
		return driver.findElement(result).getText();
		//String res=result.getText();
		//return res;
		
		
	}
//	public String invalidata() throws InterruptedException
//	{
////		WebElement syntaxerror=driver.findElement(By.t("SyntaxError"));
////		syntaxerror=new WebDriverWait(driver, Duration.ofSeconds(5)).
////		until(ExpectedConditions.elementToBeClickable()
////		syntaxerror.click();
//		try {
//	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		 alert = driver.switchTo().alert();
//		String alertmsg=alert.getText();
//		Thread.sleep(1000);
//		alert.accept(); 
//		return(alertmsg);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			return null;
//		}
//}
	
	
	

}
