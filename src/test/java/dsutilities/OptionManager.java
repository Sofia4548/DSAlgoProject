package dsutilities;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {
	
public ChromeOptions getChromeOptions()
{
	ChromeOptions options = new ChromeOptions();
   options.addArguments("--headless");
	options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	
	return options;
}
public FirefoxOptions getFireFoxOptions()
{
	FirefoxOptions options = new FirefoxOptions();
	options.addArguments("--headless");
	options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	
	return options;
}
public EdgeOptions getEdgeOptions()
{
	EdgeOptions options = new EdgeOptions();
	options.addArguments("--headless");
	options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	return options;
}
}