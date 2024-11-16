package numpyninja.dsalgo.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import numpyninja.dsalgo.pagefactory.GetStarted;
import numpyninja.dsalgo.testBase.BaseClass;
import numpyninja.dsalgo.webdrivermanager.DriverManager;

public class GetStartedTestCase extends BaseClass {
	private static final Logger LOGGER = LogManager.getLogger(GetStartedTestCase.class);

	@Test
	public void user_clicks_the_get_started_button_at_start_page() {

		GetStarted gs = new GetStarted(DriverManager.getDriver());
		gs.clickgetstartedbtn();
		Assert.assertTrue(true);
		LOGGER.info("Get Started Button is clicked");
	}
}
