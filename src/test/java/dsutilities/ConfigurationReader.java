package dsutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ConfigurationReader {
public static Properties config;
	public static String getProperty(String moduleName,String propertyKey) throws FileNotFoundException, IOException
	{
		Properties config=new Properties();
		String path="src/test/resources/Properties/";
		config.load(new FileInputStream(path+moduleName+".properties") );
		for(String key:config.stringPropertyNames())
		{
			if(key.equals(propertyKey))
			{
				return config.getProperty(propertyKey);
			}
		}
		
		
		return "Invaild PropertyKey";
	}

	
	private static String browserType = null;

	public static void setBrowserType(String browser) {

		browserType = browser;

	}

	public static String getBrowserType() throws Throwable {

		if (browserType != null)

			return browserType;

		else

			throw new RuntimeException("browser not specified in the testng.xml");

	}


	
}
		