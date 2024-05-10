package dsutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
//	private static String browserType=null;
	
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

	

	
	

}
