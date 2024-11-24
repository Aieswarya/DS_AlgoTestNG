package numpyninja.dsalgo.webdrivermanager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ThreadGuard;

import numpyninja.dsalgo.constants.Constants;
import numpyninja.dsalgo.utilities.LoggerLoad;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal();
	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);

	public static void launchBrowser() {

		try {
			switch (Constants.BROWSER) {
			case "chrome":
				LoggerLoad.info("Launching " + Constants.BROWSER);
				driver.set(ThreadGuard.protect(new ChromeDriver()));
				break;
			case "firefox":
				LoggerLoad.info("Launching " + Constants.BROWSER);
				driver.set(ThreadGuard.protect(new FirefoxDriver()));
				break;
			case "edge":
				LoggerLoad.info("Launching " + Constants.BROWSER);
				driver.set(ThreadGuard.protect(new EdgeDriver()));
				break;
			case "ie":
				LoggerLoad.info("Launching " + Constants.BROWSER);
				driver.set(ThreadGuard.protect(new InternetExplorerDriver()));
				break;
			default:
				LoggerLoad.info("Launching " + Constants.BROWSER);
				driver.set(ThreadGuard.protect(new ChromeDriver()));
				break;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static void setcrossbrowser(String browser) {
		try {
			switch (browser) {
			case "chrome":
				driver.set(ThreadGuard.protect(new ChromeDriver()));
				break;
			case "firefox":
				driver.set(ThreadGuard.protect(new FirefoxDriver()));
				break;
			case "edge":
				driver.set(ThreadGuard.protect(new EdgeDriver()));
				break;
			case "ie":
				driver.set(ThreadGuard.protect(new InternetExplorerDriver()));
				break;
			default:
				driver.set(ThreadGuard.protect(new ChromeDriver()));
				break;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

}
