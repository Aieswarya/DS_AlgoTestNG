package numpyninja.dsalgo.utilities;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import numpyninja.dsalgo.constants.Constants;

public class PropertiesConfig {


	public  void loadProperties()
	{
		System.out.println("I am inside load properties of Propertiesconfig");
		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/Config.properties"));
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		// read values from config.properties file and set it to constants variable
		Constants.APP_URL=properties.getProperty("appURL");
		Constants.BROWSER=properties.getProperty("browser");
		Constants.EXECUTION_ENVIRONMENT=properties.getProperty("execution_env");
		Constants.OS_TYPE=properties.getProperty("os");

	}

	public void setPropertiesforCrossbrowsertesting(String browser) {
		
		System.out.println("I am inside cross browser testing load properties of Propertiesconfig");
		Properties properties = new Properties();

		try {

			properties.load(getClass().getResourceAsStream("/Config.properties"));

		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		Constants.BROWSER=browser; // set values of browser from cross browser test runner
		Constants.APP_URL=properties.getProperty("appURL");	
		Constants.EXECUTION_ENVIRONMENT=properties.getProperty("execution_env");
		Constants.OS_TYPE=properties.getProperty("os");
	}


}
