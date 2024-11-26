package numpyninja.dsalgo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import numpyninja.dsalgo.constants.Constants;
import numpyninja.dsalgo.pagefactory.DataStructurePage;
import numpyninja.dsalgo.pagefactory.HomePage;
import numpyninja.dsalgo.pagefactory.PythonEditorPage;
import numpyninja.dsalgo.pagefactory.SignInPage;
import numpyninja.dsalgo.pagefactory.StackPage;
import numpyninja.dsalgo.testBase.BaseClass;
import numpyninja.dsalgo.utilities.LoggerLoad;
import numpyninja.dsalgo.utilities.RetryAnalyzer;
import numpyninja.dsalgo.webdrivermanager.DriverManager;

public class StackPageTestCase extends BaseClass {

	@BeforeMethod
	public static void beforemethod() {
		HomePage hp = new HomePage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		StackPage stp = new StackPage(DriverManager.getDriver());
		DriverManager.getDriver().get(Constants.APP_URL);
		hp.clickgetstartedbtn();
		System.out.println("going to signin again");
		si.clickSignIn();
		si.ValidCredentials();
		si.clickLogin();
		stp.clickStackGetStarted();

	}

	@Test(dataProvider = "Stacktypes")
	public void verify_pagenavigation_for_Stacktypes(String type) {

		LoggerLoad.info("TestCase : Check Stack Page Navigation from Stack Home Page");
		StackPage stp = new StackPage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		DataStructurePage ds = new DataStructurePage(DriverManager.getDriver());
		boolean result;

		switch (type) {
		case ("Operationsinstack"):
			stp.clickOperationsinStack();
			result = ds.ValidateURL("https://dsportalapp.herokuapp.com/stack/operations-in-stack/");
			si.signout();
			Assert.assertTrue(result);
			break;

		case ("Implementation"):
			stp.clickImplementation();
			result = ds.ValidateURL("https://dsportalapp.herokuapp.com/stack/implementation/");
			Assert.assertTrue(result);
			break;

		case ("Applications"):
			stp.clickApplications();
			result = ds.ValidateURL("https://dsportalapp.herokuapp.com/stack/stack-applications/");
			Assert.assertTrue(result);
			break;

		}

		LoggerLoad.info("The user is redirected to Stack " + type + " page");

	}

	@Test(dataProvider = "Stacktypes")
	public void verify_pythonEditorPageNavigation_for_Stacktypes(String type) {
		LoggerLoad.info("TestCase : Check Stack Python Editor Page Navigation from Stack Home Page");
		StackPage stp = new StackPage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		DataStructurePage ds = new DataStructurePage(DriverManager.getDriver());
		PythonEditorPage py = new PythonEditorPage(DriverManager.getDriver());
		boolean result;

		switch (type) {
		case ("Operationsinstack"):
			stp.clickOperationsinStack();
			break;
		case ("Implementation"):
			stp.clickImplementation();
			break;
		case ("Applications"):
			stp.clickApplications();
			break;

		}

		py.clickTryHere();
		result = py.editorPgIsDisplayed();
		Assert.assertTrue(result);
		LoggerLoad.info("The user is redirected to Stack " + type + " Editor page");

	}

	@Test(dataProvider = "Stacktypes")
	public void verify_pythonEditor_for_noCodeSubmission(String type) {
		LoggerLoad.info("TestCase : Check Stack Python Editor for No Code Submission");
		StackPage stp = new StackPage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		PythonEditorPage py = new PythonEditorPage(DriverManager.getDriver());
		boolean result;

		switch (type) {
		case ("Operationsinstack"):
			stp.clickOperationsinStack();
			break;
		case ("Implementation"):
			stp.clickImplementation();
			break;
		case ("Applications"):
			stp.clickApplications();
			break;

		}
		py.clickTryHere();
		py.noCodeEntered();
		py.clickRun();
		result = py.alertMsgIsDisplayed();
		Assert.assertTrue(result);
		LoggerLoad.info("The user should see alert message for No code ");

	}

	@Test(dataProvider = "Stacktypes")
	public void verify_pythonEditor_for_InvalidCodeSubmission(String type) {
		LoggerLoad.info("TestCase : Check Stack Python Editor for Invalid Code Submission");
		StackPage stp = new StackPage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		PythonEditorPage py = new PythonEditorPage(DriverManager.getDriver());

		switch (type) {
		case ("Operationsinstack"):
			stp.clickOperationsinStack();
			py.clickTryHere();
			break;
		case ("Implementation"):
			stp.clickImplementation();
			py.clickTryHere();
			break;
		case ("Applications"):
			stp.clickApplications();
			py.clickTryHere();
			break;

		}

		py.enterInValidCode();
		py.clickRun();
		boolean result = py.alertMsgIsDisplayed();
		Assert.assertTrue(result);
		LoggerLoad.info("The user should see alert message for Invalid code ");
	}

	@Test(dataProvider = "Stacktypes")
	public void verify_pythonEditor_for_ValidCodeSubmission(String type) {
		LoggerLoad.info("TestCase : Check Stack Python Editor for Valid Code submission");
		StackPage stp = new StackPage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		PythonEditorPage py = new PythonEditorPage(DriverManager.getDriver());

		switch (type) {
		case ("Operationsinstack"):
			stp.clickOperationsinStack();
			py.clickTryHere();
			break;
		case ("Implementation"):
			stp.clickImplementation();
			py.clickTryHere();
			break;
		case ("Applications"):
			stp.clickApplications();
			py.clickTryHere();
			break;

		}

		py.enterValidCode();
		py.clickRun();
		boolean result = py.ValidateOutput();
		Assert.assertTrue(result);
		LoggerLoad.info("The user should see valid output ");

	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verify_practiseQuestionsLink_StackModule() {
		LoggerLoad.info("TestCase: Check Practise Question link navigates to page with content");
		StackPage stp = new StackPage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		stp.clickOperationsinStack();
		stp.clickPracticeQuestions();
		Assert.assertTrue(false);
		LoggerLoad.info("The user clicks Practise Questions link");
	}

	@DataProvider(name = "Stacktypes")
	public String[] StackTypes() {
		String[] Stacktypes = { "Operationsinstack", "Implementation", "Applications" };
		return Stacktypes;
	}

	@AfterMethod
	public void Signout() {
		SignInPage si = new SignInPage(DriverManager.getDriver());
		DriverManager.getDriver().navigate().back();
		si.signout();
	}

}
