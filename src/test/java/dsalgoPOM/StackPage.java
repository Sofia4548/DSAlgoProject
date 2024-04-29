package dsalgoPOM;

import java.io.IOException;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class StackPage {
	
	private WebDriver driver;
	 private WebDriverWait wait;
	 private Properties properties = new Properties();
	private By Stacklink=By.xpath("//a[@href='stack']");
	private By Datastructureclick=By.xpath("//div[@class='nav-item dropdown']");
	private By selectStack=By.xpath("//a[@class='dropdown-item' and @href='/stack']");
	private By CheckLogin=By.xpath("//a[text()=' Testscripters ']");
	private By username=By.xpath("//input[@name='username']");
	private By password=By.xpath("//input[@id='id_password']");
	private By loginbtn=By.xpath("//input[@value='Login']");
	private By pageheader=By.xpath("//h4[text()='Stack']");
	private By Tryherebtn=By.xpath("//a[@href='/tryEditor']");
	
	private By Runbtn=By.xpath("//button[text()='Run']");
	private By TextEditor=By.xpath("//*[@id=\"answer_form\"]/div/div/div[1]/textarea");
	//private By TextEditor=By.xpath("//div[@class='CodeMirror cm-s-default']//textarea");
	private By result=By.xpath("//div//pre[@id='output']");
	private By heading=(By.linkText("NumpyNinja"));
	
	
			
	
	
	public StackPage(WebDriver driver)
	{
		this.driver=driver;
	//	wait = new WebDriverWait(driver, 10);
		
	}
	
	public void  dsalgohomepage() throws IOException
	{
		driver.get("https://dsportalapp.herokuapp.com/login");
////		properties.load(new FileInputStream("dsalgo.properties"));
////		String url = properties.getProperty("dsalgologin");
////		driver.get(url);
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
		driver.findElement(loginbtn).click();
		
		
	}
	public String numpaNinjaText()
	{
		return driver.findElement(heading).getText();
	}
	
	public void ClickStackGetStartedBtn()
	{
		driver.findElement(Stacklink).click();
		driver.findElement(Datastructureclick).click();
		driver.findElement(selectStack).click();
		
	}
	
	public void StackHomePage() throws FileNotFoundException, IOException, InterruptedException
	{
		driver.get("https://dsportalapp.herokuapp.com/stack/");
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
//	        System.out.println("Link Text: " + linkText);
//	        System.out.println("Topics:"+topic);
	        if (linkText.equals(topic)) {
	            linksByTopic.add(link);
	        }

			System.out.println(linksByTopic);
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
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
	public void EnterCode(String code) throws InterruptedException
	{
		//driver.findElement(TextEditor).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(TextEditor).sendKeys(code);
	}
	public void Submitcode() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(Runbtn).click();
	}
	
	public String Getoutput()
	{
		
		return driver.findElement(result).getText();
		
	}
//	public String invalidata() throws InterruptedException
//	{
//		driver.findElement(By.linkText("SyntaxError"));
//		//WebDriverWait wait = new WebDriverWait(driver, 10);
//	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		 alert = driver.switchTo().alert();
//		
//String alertmsg=alert.getText();
////		Thread.sleep(1000);
////		alert.accept(); 
//////		WebElement activeelement= driver.findElement(By.linkText("SyntaxError"));	
//////		((JavascriptExecutor)driver).executeScript("arguments[0].click();", activeelement);
//////		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//////		//Alert alert = driver.switchTo().alert();
//////		String alertmsg=alert.getText();
//////		Thread.sleep(2000);
//////		alert.accept();
//return(alertmsg);
////		
//	}
//	
}
