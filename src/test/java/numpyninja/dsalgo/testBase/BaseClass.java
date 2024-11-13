package numpyninja.dsalgo.testBase;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import io.cucumber.java.AfterStep;

import io.cucumber.java.Scenario;
import numpyninja.dsalgo.constants.Constants;
import numpyninja.dsalgo.utilities.ExcelUtils;
import numpyninja.dsalgo.utilities.PropertiesConfig;
import numpyninja.dsalgo.webdrivermanager.DriverManager;



public class BaseClass {

	public static final Logger LOGGER = LogManager.getLogger(BaseClass.class);

	
	@BeforeClass
	public void beforeScenario() {
		LOGGER.info("Execution started..");
		
		try {

			PropertiesConfig propertiesConfig = new PropertiesConfig();
			propertiesConfig.loadProperties();
			ExcelUtils excelutils = new ExcelUtils();
			ExcelUtils.getLogin();
			DriverManager.launchBrowser();			
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			DriverManager.getDriver().get(Constants.APP_URL);

			LOGGER.info("DS Algo website launched");
			

		} catch (Exception exception) {
			exception.printStackTrace();

		}

	}

	@AfterClass
	public void teardown() {
		
		DriverManager.getDriver().quit();
		LOGGER.info("Driver is shutdown");
		
	}

	//@AfterStep
	public void attachScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshotTaken = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotTaken, "image/png", "error screen");
		}
		

}
}


	
	


