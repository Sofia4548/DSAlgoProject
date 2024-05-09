package dsalgoPOM;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PractisePage {
	private WebDriver driver;
	private By arraysInPythonlink=(By.xpath("//*[text()='Arrays in Python']"));
	private By practiseLink=(By.xpath("//*[text()='Practice Questions']"));
	//private By editor=(By.xpath("//*//form[@id='answer_form']/div//textarea"));
	//private By editor=(By.xpath("//textarea[@id='editor']"));
	private By editor=(By.xpath("//textarea[@autocorrect='off']"));
	private By runBtn = (By.xpath("//button[text()='Run']"));
	private By output = (By.xpath("//*[@id='output']"));
	private By logoutmsg=(By.xpath("//*[contains(text(),'Logged out successfully')] "));
	private By signoutbtn=(By.linkText("Sign out"));

	public PractisePage(WebDriver driver) {
		this.driver = driver;
	}
	public void arraysInPythonlinkClick()
	{
		driver.findElement(arraysInPythonlink).click();
	}
	public void practiseLinkClick()
	{
		driver.findElement(practiseLink).click();
	}
	public String practisePageTitle()
	{
		return driver.getTitle();
	}
	public List<WebElement> getlinksByTopic(String topic)
	{
		List<WebElement> linkByTopics=new ArrayList<WebElement>();
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		for(WebElement link:allLinks)
		{
			String linkText=link.getText();
			String linkURL=link.getAttribute("href");
			System.out.println("Link Text is "+linkText+"URL is "+linkURL);
			System.out.println("Topics:"+topic);
			if(linkText.equals(topic))
			{
				linkByTopics.add(link);
				System.out.println(link);
			}
			}
		return linkByTopics;
	}
	public void enterCode(String code)
	{
		System.out.println("Enter code function");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.findElement(editor).clear();
		driver.findElement(editor).sendKeys(Keys.CONTROL + "a");
		driver.findElement(editor).sendKeys(Keys.DELETE);
		driver.findElement(editor).sendKeys(code);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.findElement(runBtn).click();
	}
	
	public String getOutput() {
		return driver.findElement(output).getText();

	}
	public String getCurrentTitle() {
		String currentTitle = driver.getTitle();
		return currentTitle;
	}
	public String ReadLogoutmsg()
	{
		String msg=driver.findElement(logoutmsg).getText();
		return msg;
	}
	public String getAlertMsg() {
		//method 1
		String alertText = null;
		Alert alertWindow=driver.switchTo().alert();
		alertText = alertWindow.getText();
		
		alertWindow.accept();
		return alertText;
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
}
