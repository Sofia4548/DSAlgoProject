package dsutilities;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
//import WebDriver.edge. service import Service;


public class OptionManager {
// to control browser options in much better way	
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
	options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	options.addArguments("--headless");
	return options;
}
//public EdgeOptions getEdgeOptions()
//{
//	EdgeOptions options = new EdgeOptions();
//	options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//	options.addArguments("--headless");
//	//options = WebDriver.Edge(executable_path = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",options = edge_options )
//	return options;
//}
}
