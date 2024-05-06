package dsalgoPOM;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PractisePage {
	private WebDriver driver;
	private By arraysInPythonlink=(By.xpath("//*[text()='Arrays in Python']"));
	private By practiseLink=(By.xpath("//*[text()='Practice Questions']"));
	//private By editor=(By.xpath("//*//form[@id='answer_form']/div//textarea"));
	//private By editor=(By.xpath("//textarea[@id='editor']"));
	private By editor=(By.xpath("//textarea[@autocorrect='off']"));
	private By runBtn = (By.xpath("//button[text()='Run']"));
	private By output = (By.xpath("//*[@id='output']"));

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
	
		driver.findElement(editor).sendKeys(code);
		
//		WebElement element = driver.findElement(By.className("CodeMirror-code"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].style.paddingLeft = '50px'", element);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.findElement(runBtn).click();
		
	}

public static void TextIndentation(WebDriver driver, WebElement pythonElement, int row, int space,boolean flag) {
		Actions action = new Actions(driver);
	       // Keys cmdCtrl = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;
		for(int i=1;i<=row;i++) {
		      action.sendKeys(Keys.ARROW_UP).keyUp(Keys.SHIFT).perform();
		       for(int j=1;j<=space;j++) {
	            if(i==1 && flag) action.sendKeys(Keys.BACK_SPACE).perform();
	            else action.sendKeys(Keys.DELETE).perform();
			   }
		}
	}
	public String getOutput() {
		return driver.findElement(output).getText();

	}

}
