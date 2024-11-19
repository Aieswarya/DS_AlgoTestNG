package numpyninja.dsalgo.webdrivermanager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ThreadGuard;

import io.github.bonigarcia.wdm.WebDriverManager;
import numpyninja.dsalgo.constants.Constants;

public class DriverManager {
	
	private static  ThreadLocal<WebDriver> driver = new ThreadLocal();
	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);
	
	public static void launchBrowser()
	{
		
		try {
			switch(Constants.BROWSER) {
			case"chrome":
				
				LOGGER.info("Launching "+ Constants.BROWSER);
				driver.set(ThreadGuard.protect(new ChromeDriver()));
				break;
			case"firefox":
				
				LOGGER.info("Launching "+ Constants.BROWSER);
				driver.set(ThreadGuard.protect(new FirefoxDriver()));
				break;
			case"edge":
				
				LOGGER.info("Launching "+ Constants.BROWSER);
				driver.set(ThreadGuard.protect(new EdgeDriver()));
				break;
			case"ie":
				
				LOGGER.info("Launching "+ Constants.BROWSER);
				driver.set(ThreadGuard.protect(new InternetExplorerDriver()));
				break;
			default:
				
				LOGGER.info("Launching "+ Constants.BROWSER);
				driver.set(ThreadGuard.protect(new ChromeDriver()));
				break;
				}
			
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		return driver.get();
	}
	
	
}
