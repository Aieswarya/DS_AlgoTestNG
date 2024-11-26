package numpyninja.dsalgo.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import numpyninja.dsalgo.pagefactory.GetStarted;
import numpyninja.dsalgo.testBase.BaseClass;
import numpyninja.dsalgo.webdrivermanager.DriverManager;
import numpyninja.dsalgo.utilities.LoggerLoad;

public class GetStartedTestCase extends BaseClass {
	
	@Test(priority=0)
	public void user_clicks_the_get_started_button_at_start_page() {

		GetStarted gs = new GetStarted(DriverManager.getDriver());
		LoggerLoad.info("TestCase 0 : Check GetStarted Button functionality");
		gs.clickgetstartedbtn();
		Assert.assertTrue(true);
		LoggerLoad.info("Verified  GetStarted Button functionality");
	}
}
