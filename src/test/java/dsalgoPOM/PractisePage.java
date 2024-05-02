package dsalgoPOM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PractisePage {
	private WebDriver driver;
	private By arraysInPythonlink=(By.xpath("//*[text()='Arrays in Python']"));
	private By practiseLink=(By.xpath("//*[text()='Practice Questions']"));
	private By editor=(By.xpath("//textarea[@id='editor']"));
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
		driver.findElement(editor).sendKeys(code);
		//driver.findElement(runBtn).click();
	}
}
