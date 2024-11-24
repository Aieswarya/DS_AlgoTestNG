package numpyninja.dsalgo.testBase;


import java.time.Duration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import numpyninja.dsalgo.constants.Constants;
import numpyninja.dsalgo.utilities.ExcelUtils;
import numpyninja.dsalgo.utilities.LoggerLoad;
import numpyninja.dsalgo.utilities.PropertiesConfig;
import numpyninja.dsalgo.webdrivermanager.DriverManager;

public class BaseClass {

	//@BeforeClass
	public void beforeScenario() {
		LoggerLoad.info("DS Algo TestNG test started ");

		try {

			PropertiesConfig propertiesConfig = new PropertiesConfig();
			propertiesConfig.loadProperties();
			ExcelUtils excelutils = new ExcelUtils();
			ExcelUtils.getLogin();
			DriverManager.launchBrowser();
			DriverManager.getDriver().manage().deleteAllCookies();
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			DriverManager.getDriver().get(Constants.APP_URL);


		} catch (Exception exception) {
			exception.printStackTrace();

		}

	}

	@AfterClass
	public void teardown() {

		DriverManager.getDriver().quit();
		LoggerLoad.info("Driver is shutdown");

	}

	@Parameters("browser")
	@BeforeClass
	public void beforecrossbrowserScenario(String browser) {
		LoggerLoad.info("DS Algo TestNG test started ");

		try {

			PropertiesConfig propertiesConfig = new PropertiesConfig();
			propertiesConfig.loadProperties();
			ExcelUtils excelutils = new ExcelUtils();
			ExcelUtils.getLogin();
			DriverManager.setcrossbrowser(browser);
			DriverManager.getDriver().manage().deleteAllCookies();
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			DriverManager.getDriver().get(Constants.APP_URL);


		} catch (Exception exception) {
			exception.printStackTrace();

		}
}
}






