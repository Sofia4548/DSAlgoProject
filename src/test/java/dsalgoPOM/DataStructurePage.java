package dsalgoPOM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DataStructurePage {
	private WebDriver driver;
//	@FindBy(xpath = "//a[@href='data-structures-introduction']")
//	private WebElement dSIntro;
	private By DSHomePage=(By.xpath("//a[@href='data-structures-introduction']"));
	private By tryHere=(By.xpath("//*[text()='Try here>>>']"));
	//private By editor=(By.xpath("//textarea[@id='editor']"));
	private By editor=(By.xpath("//*[@id='answer_form']/div/div/div[1]/textarea"));
	private By runBtn=(By.xpath("//button[text()='Run']"));
	private By output=(By.xpath("//*[@id='output']"));

	public DataStructurePage(WebDriver driver) {
		this.driver = driver;
	}

	public void dsHomePage() {
		driver.findElement(DSHomePage).click();
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
	public String getCurrentTitle() {
		String currentTitle=driver.getTitle();
		return currentTitle;
	}
	public void tryHereClick()
	{
		driver.findElement(tryHere).click();
	}
	public void getEditorTitle()
	{
		String editorTitle=driver.getTitle();
		System.out.println("Editor title is "+editorTitle);
	}
	public void enterCode(String code)
	{
		driver.findElement(editor).sendKeys(code);
		driver.findElement(runBtn).click();
	}
	public String getOutput() {
		return driver.findElement(output).getText();
		
	}
}