package hooks;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import framework.BrowserManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	BrowserManager browserManager = new BrowserManager();

	WebDriver driver = null;

	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		System.out.println("Setup gets executed");
		browserManager.startBrowser();

	}
	@After
	public void afterScenario()
	{
		browserManager.quitBrowser();
		System.out.println("Teardown gets executed");
	}

}
