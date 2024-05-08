package dsalgoPOM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonPage {
	private WebDriver driver;
	private By tryHere = (By.xpath("//*[text()='Try here>>>']"));
	//private By editor=(By.xpath("//textarea[@id='editor']"));
	private By editor = (By.xpath("//*[@id='answer_form']/div/div/div[1]/textarea"));
	private By runBtn = (By.xpath("//button[text()='Run']"));
	private By output = (By.xpath("//*[@id='output']"));
	private By signOut=(By.linkText("Sign out"));
	public CommonPage(WebDriver driver) {
		this.driver = driver;
	}
	public List<WebElement> getlinksByTopic(String topic) {
		List<WebElement> linkByTopics = new ArrayList<WebElement>();
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for (WebElement link : allLinks) {
			String linkText = link.getText();
			String linkURL = link.getAttribute("href");
			System.out.println("Link Text is " + linkText + "URL is " + linkURL);
			System.out.println("Topics:" + topic);
			if (linkText.equals(topic)) {
				linkByTopics.add(link);
				System.out.println(link);
			}
		}
		return linkByTopics;
	}

	public String getCurrentTitle() {
		String currentTitle = driver.getTitle();
		return currentTitle;
	}

	public void tryHereClick() {
		driver.findElement(tryHere).click();
	}

	public void getEditorTitle() {
		String editorTitle = driver.getTitle();
		System.out.println("Editor title is " + editorTitle);
	}

	public void enterCode(String code) {
		driver.findElement(editor).sendKeys(code);
		driver.findElement(runBtn).click();
	}

	public String getOutput() {
		return driver.findElement(output).getText();

	}

	public String getAlertMsg() {
		//method 1
		String alertText = null;
		Alert alertWindow=driver.switchTo().alert();
		alertText = alertWindow.getText();
		
		alertWindow.accept();
		return alertText;
		
		//method 2	using explicit wait
//		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(50));
//		Alert alertWindow = myWait.until(ExpectedConditions.alertIsPresent());
		
//		alertText = alertWindow.getText();
//		System.out.println("Alert Text is " + alertText);
//		alertWindow.accept();

		//method 3 using fluent wait
//		Wait<WebDriver> wait = new FluentWait<>(driver)
//		        .withTimeout(Duration.ofSeconds(50))
//		        .pollingEvery(Duration.ofMillis(500))
//		        .ignoring( org.openqa.selenium.UnhandledAlertException.class);
//
//		Alert alertWindow = wait.until(ExpectedConditions.alertIsPresent());
//		System.out.println(alertWindow.getText());
//		alertWindow.accept();	

	}
	public void signOut()
	{
		driver.navigate().back();
		driver.findElement(signOut).click();
	}
}
