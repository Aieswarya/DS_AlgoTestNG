package numpyninja.dsalgo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import numpyninja.dsalgo.constants.Constants;
import numpyninja.dsalgo.pagefactory.ArrayPage;
import numpyninja.dsalgo.pagefactory.HomePage;
import numpyninja.dsalgo.pagefactory.PythonEditorPage;
import numpyninja.dsalgo.pagefactory.SignInPage;
import numpyninja.dsalgo.testBase.BaseClass;
import numpyninja.dsalgo.utilities.LoggerLoad;
import numpyninja.dsalgo.webdrivermanager.DriverManager;

public class ArrayTestCase extends BaseClass {

	@BeforeMethod
	public static void beforemethod() {
		HomePage hp = new HomePage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		DriverManager.getDriver().get(Constants.APP_URL);
		hp.clickgetstartedbtn();
		si.clickSignIn();
		si.ValidCredentials();
		si.clickLogin();
		hp.arraygsbtn();

	}

	@Test(dataProvider = "ATYPES")
	public void verify_pagenavigation_for_Arraytypes(String type) {
		LoggerLoad.info("TestCase : Check Array "+type+" Page Navigation from Array Home Page");
		ArrayPage array = new ArrayPage(DriverManager.getDriver());
		SignInPage signIn = new SignInPage(DriverManager.getDriver());
		boolean result;

		switch (type) {
		case ("Arrays In Python"):
			array.click_ArraysInPython();
			result = array.Validate_ArrayInPython_URL();
			//signIn.signout();
			Assert.assertTrue(result);
			break;
		case ("Arrays Using List"):
			array.click_ArraysUsingList();
			result = array.Validate_ArraysUsingList_URL();
			//signIn.signout();
			Assert.assertTrue(result);
			break;
		case ("Basic Operations in Lists"):
			array.click_BasicOpsInList();
			result = array.Validate_BasicOpsInList_URL();
			//signIn.signout();
			Assert.assertTrue(result);
			break;
		case ("Applications of Array"):
			array.click_ApplicationsOfArray();
			result = array.Validate_ApplicationsOfArray_URL();
			//signIn.signout();
			Assert.assertTrue(result);
			break;
		}

		LoggerLoad.info("The user is redirected to Array " + type + " page");
	}

	@Test(dataProvider = "ATYPES")
	public void verify_pythonEditorPageNavigation_for_Arraytypes(String type) {
		LoggerLoad.info("TestCase : Check " + type + "Python Editor Page Navigation");
		ArrayPage array = new ArrayPage(DriverManager.getDriver());
		SignInPage signIn = new SignInPage(DriverManager.getDriver());
		PythonEditorPage py = new PythonEditorPage(DriverManager.getDriver());
		boolean result;

		switch (type) {
		case ("Arrays In Python"):
			array.click_ArraysInPython();

			break;
		case ("Arrays Using List"):
			array.click_ArraysUsingList();

			break;
		case ("Basic Operations in Lists"):
			array.click_BasicOpsInList();

			break;
		case ("Applications of Array"):
			array.click_ApplicationsOfArray();

			break;
		}

		py.clickTryHere();
		result = py.editorPgIsDisplayed();
		//DriverManager.getDriver().navigate().back();
		//signIn.signout();
		Assert.assertTrue(result);
		LoggerLoad.info("The user is redirected to Array " + type + " Editor page");

	}

	@Test(dataProvider = "ATYPES")
	public void verify_ArraypythonEditor_for_noCodeSubmission(String type) {
		LoggerLoad.info("TestCase : Check " + type + "Python Editor No Code Submission");
		ArrayPage array = new ArrayPage(DriverManager.getDriver());
		SignInPage signIn = new SignInPage(DriverManager.getDriver());
		PythonEditorPage py = new PythonEditorPage(DriverManager.getDriver());
		boolean result;

		switch (type) {
		case ("Arrays In Python"):
			array.click_ArraysInPython();

			break;
		case ("Arrays Using List"):
			array.click_ArraysUsingList();

			break;
		case ("Basic Operations in Lists"):
			array.click_BasicOpsInList();

			break;
		case ("Applications of Array"):
			array.click_ApplicationsOfArray();

			break;
		}

		py.clickTryHere();
		py.noCodeEntered();
		py.clickRun();
		result = py.alertMsgIsDisplayed();
		//DriverManager.getDriver().navigate().back();
		//signIn.signout();
		Assert.assertTrue(result);

		LoggerLoad.info("The user should see alert message for No code ");

	}

	@Test(dataProvider = "ATYPES")
	public void verify_ArraypythonEditor_for_InvalidCodeSubmission(String type) {
		LoggerLoad.info("TestCase : Check " + type + " Python Editor Page for Invalid Code Submission");
		ArrayPage array = new ArrayPage(DriverManager.getDriver());
		SignInPage signIn = new SignInPage(DriverManager.getDriver());
		PythonEditorPage py = new PythonEditorPage(DriverManager.getDriver());
		boolean result;

		switch (type) {
		case ("Arrays In Python"):
			array.click_ArraysInPython();

			break;
		case ("Arrays Using List"):
			array.click_ArraysUsingList();

			break;
		case ("Basic Operations in Lists"):
			array.click_BasicOpsInList();

			break;
		case ("Applications of Array"):
			array.click_ApplicationsOfArray();

			break;
		}

		
		py.clickTryHere();
		py.enterInValidCode();
		py.clickRun();
		result = py.alertMsgIsDisplayed();
		//DriverManager.getDriver().navigate().back();
		//signIn.signout();
		Assert.assertTrue(result);
		LoggerLoad.info("The user should see alert message for Invalid code ");
	}

	@Test(dataProvider = "ATYPES")
	public void verify_ArraypythonEditor_for_ValidCodeSubmission(String type) {

		LoggerLoad.info("TestCase : Check " + type + "Python Editor Page for Valid Code Submission");
		ArrayPage array = new ArrayPage(DriverManager.getDriver());
		SignInPage signIn = new SignInPage(DriverManager.getDriver());
		PythonEditorPage py = new PythonEditorPage(DriverManager.getDriver());
		boolean result;

		switch (type) {
		case ("Arrays In Python"):
			array.click_ArraysInPython();

			break;
		case ("Arrays Using List"):
			array.click_ArraysUsingList();

			break;
		case ("Basic Operations in Lists"):
			array.click_BasicOpsInList();

			break;
		case ("Applications of Array"):
			array.click_ApplicationsOfArray();

			break;
		}

		py.clickTryHere();
		py.enterValidCode();
		py.clickRun();
		result = py.ValidateOutput();
		//DriverManager.getDriver().navigate().back();
		//signIn.signout();
		Assert.assertTrue(result);
		LoggerLoad.info("The user should see valid output ");

	}

	@Test
	public void verify_practiseQuestionsLink_ArrayModule() {
		LoggerLoad.info("TestCase 19: Check Practise Question link navigates to page with content");
		ArrayPage array = new ArrayPage(DriverManager.getDriver());
		SignInPage signIn = new SignInPage(DriverManager.getDriver());
		array.click_ArraysUsingList();
		array.click_PractiseQuestions();
		//DriverManager.getDriver().navigate().back();
		//signIn.signout();
		Assert.assertTrue(false);
		LoggerLoad.info("The user clicks Practise Questions link");
	}

	@DataProvider(name = "ATYPES")
	public String[] ArrayTypes() {
		String[] ATYPES = { "Arrays In Python", "Arrays Using List", "Basic Operations in Lists",
				"Applications of Array" };
		return ATYPES;
	}
	
	@AfterMethod
	public void afterMethod()
	{
		SignInPage signIn = new SignInPage(DriverManager.getDriver());
		DriverManager.getDriver().navigate().back();
		signIn.signout();
	}

}
