package numpyninja.dsalgo.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import numpyninja.dsalgo.constants.Constants;
import numpyninja.dsalgo.pagefactory.HomePage;
import numpyninja.dsalgo.pagefactory.RegisterPage;
import numpyninja.dsalgo.testBase.BaseClass;
import numpyninja.dsalgo.webdrivermanager.DriverManager;

public class RegisterTestCase extends BaseClass {

	Constants constants = new Constants();

	@BeforeMethod
	public void beforemethod() {
		HomePage homePage = new HomePage(DriverManager.getDriver());
		DriverManager.getDriver().get(Constants.APP_URL);
		homePage.clickgetstartedbtn();

	}

	@Test
	public void verify_register_using_existingUserName() {
		RegisterPage register = new RegisterPage(DriverManager.getDriver());
		register.clickRegisterLink();

		register.SetUserName(constants.USERNAME);
		register.SetPassword(constants.REGISTER_TEST_PSWD);
		register.SetPassword2(constants.REGISTER_TEST_PSWD);
		register.ClickBtnRegister();
		boolean RESULT = register.alertMsgIsDisplayed(constants.REGISTER_ALERT_MSG);
		Assert.assertTrue(RESULT);

	}

	@Test
	public void verify_register_using_mismatchPasswords()

	{
		RegisterPage register = new RegisterPage(DriverManager.getDriver());
		register.clickRegisterLink();
		register.SetUserName(constants.REGISTER_TEST_USERNAME);
		register.SetPassword(constants.REGISTER_TEST_PSWD);
		register.SetPassword2(constants.REGISTER_TEST_PSWD2);
		register.ClickBtnRegister();
		boolean RESULT = register.alertMsgIsDisplayed(constants.REGISTER_ALERT_MSG);
		Assert.assertTrue(RESULT);

	}

	@Test
	public void verify_register_using_numericPassword() {
		RegisterPage register = new RegisterPage(DriverManager.getDriver());
		register.clickRegisterLink();
		register.SetUserName(constants.REGISTER_TEST_USERNAME);
		register.SetPassword(constants.REGISTER_TEST_PSWD);
		register.SetPassword2(constants.REGISTER_TEST_PSWD + "123");
		register.ClickBtnRegister();
		boolean RESULT = register.alertMsgIsDisplayed(constants.REGISTER_ALERT_MSG);
		Assert.assertTrue(RESULT);

	}

	@Test
	public void verify_register_using_missingfields() {
		RegisterPage register = new RegisterPage(DriverManager.getDriver());
		register.clickRegisterLink();
		register.SetUserName(constants.REGISTER_TEST_USERNAME);
		register.SetPassword2(constants.REGISTER_TEST_PSWD);
		register.ClickBtnRegister();
		boolean RESULT = register.ValidationMessageIsDisplayed();
		Assert.assertTrue(RESULT);

	}
}
