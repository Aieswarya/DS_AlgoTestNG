
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
import numpyninja.dsalgo.pagefactory.QueuePage;
import numpyninja.dsalgo.pagefactory.SignInPage;
import numpyninja.dsalgo.testBase.BaseClass;
import numpyninja.dsalgo.utilities.LoggerLoad;
import numpyninja.dsalgo.utilities.RetryAnalyzer;
import numpyninja.dsalgo.webdrivermanager.DriverManager;

public class QueueTestCase extends BaseClass {

	@BeforeMethod
	public  void beforemethod() {
		HomePage hp = new HomePage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		QueuePage qp = new QueuePage(DriverManager.getDriver());
		DriverManager.getDriver().get(Constants.APP_URL);
		hp.clickgetstartedbtn();
		si.clickSignIn();
		si.ValidCredentials();
		si.clickLogin();
		qp.ClickgetstartedQueue();
	}

	@Test(dataProvider = "Queuetypes")
	public void verify_pagenavigation_for_Queuetypes(String type) {

		LoggerLoad.info("TestCase : Check Stack Page Navigation from Queue Home Page");
		QueuePage qp = new QueuePage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		DataStructurePage ds = new DataStructurePage(DriverManager.getDriver());
		boolean result;

		switch (type) {

		case ("ImplementationofQueueInpython"):
			qp.ClickImplementationofQueuePython();
			result = ds.ValidateURL("https://dsportalapp.herokuapp.com/queue/implementation-lists/");
			Assert.assertTrue(result);
			break;

		case ("Implementationusingcollectionsdeque"):
			qp.ClickImplementationusingCollections();
			result = ds.ValidateURL("https://dsportalapp.herokuapp.com/queue/implementation-collections/");
			Assert.assertTrue(result);
			break;

		case ("Implementationusingarray"):
			qp.ClickimplementationusingArrays();
			result = ds.ValidateURL("https://dsportalapp.herokuapp.com/queue/Implementation-array/");
			Assert.assertTrue(result);
			break;

		case ("QueueOperations"):
			qp.ClickQueueOperations();
			result = ds.ValidateURL("https://dsportalapp.herokuapp.com/queue/QueueOp/");
			Assert.assertTrue(result);
			break;

		}

		LoggerLoad.info("The user is redirected to Queue " + type + " page");

	}

	@Test(dataProvider = "Queuetypes")
	public void verify_pythonEditorPageNavigation_for_Queuetypes(String type) {
		LoggerLoad.info("TestCase : Check Queue Python Editor Page Navigation from Queue Home Page");
		QueuePage qp = new QueuePage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		DataStructurePage ds = new DataStructurePage(DriverManager.getDriver());
		PythonEditorPage py = new PythonEditorPage(DriverManager.getDriver());
		boolean result;

		switch (type) {

		case ("ImplementationofQueueInpython"):
			qp.ClickImplementationofQueuePython();
			break;

		case ("Implementationusingcollectionsdeque"):
			qp.ClickImplementationusingCollections();
			break;

		case ("Implementationusingarray"):
			qp.ClickimplementationusingArrays();
			break;

		case ("QueueOperations"):
			qp.ClickQueueOperations();
			break;
		}

		py.clickTryHere();
		result = py.editorPgIsDisplayed();
		Assert.assertTrue(result);
		LoggerLoad.info("The user is redirected to Queue " + type + " Editor page");

	}

	@Test(dataProvider = "Queuetypes")
	public void verify_pythonEditor_for_noCodeSubmission(String type) {
		LoggerLoad.info("TestCase : Check Queue Python Editor for No Code Submission");
		QueuePage qp = new QueuePage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		PythonEditorPage py = new PythonEditorPage(DriverManager.getDriver());
		boolean result;

		switch (type) {
		case ("ImplementationofQueueInpython"):
			qp.ClickImplementationofQueuePython();
			break;

		case ("Implementationusingcollectionsdeque"):
			qp.ClickImplementationusingCollections();
			break;

		case ("Implementationusingarray"):
			qp.ClickimplementationusingArrays();
			break;

		case ("QueueOperations"):
			qp.ClickQueueOperations();
			break;

		}
		py.clickTryHere();
		py.noCodeEntered();
		py.clickRun();
		result = py.alertMsgIsDisplayed();
		Assert.assertTrue(result);
		LoggerLoad.info("The user should see alert message for No code ");

	}

	@Test(dataProvider = "Queuetypes")
	public void verify_pythonEditor_for_InvalidCodeSubmission(String type) {
		LoggerLoad.info("TestCase : Check Stack Python Editor for Invalid Code Submission");
		QueuePage qp = new QueuePage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		PythonEditorPage py = new PythonEditorPage(DriverManager.getDriver());

		switch (type) {
		case ("ImplementationofQueueInpython"):
			qp.ClickImplementationofQueuePython();
			py.clickTryHere();
			break;

		case ("Implementationusingcollectionsdeque"):
			qp.ClickImplementationusingCollections();
			py.clickTryHere();
			break;

		case ("Implementationusingarray"):
			qp.ClickimplementationusingArrays();
			py.clickTryHere();
			break;

		case ("QueueOperations"):
			qp.ClickQueueOperations();
			py.clickTryHere();
			break;
		}

		py.enterInValidCode();
		py.clickRun();
		boolean result = py.alertMsgIsDisplayed();
		Assert.assertTrue(result);
		LoggerLoad.info("The user should see alert message for Invalid code ");
	}

	@Test(dataProvider = "Queuetypes")
	public void verify_pythonEditor_for_ValidCodeSubmission(String type) {
		LoggerLoad.info("TestCase : Check Stack Python Editor for Valid Code submission");
		QueuePage qp = new QueuePage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		PythonEditorPage py = new PythonEditorPage(DriverManager.getDriver());

		switch (type) {
		case ("ImplementationofQueueInpython"):
			qp.ClickImplementationofQueuePython();
			py.clickTryHere();
			break;

		case ("Implementationusingcollectionsdeque"):
			qp.ClickImplementationusingCollections();
			py.clickTryHere();
			break;

		case ("Implementationusingarray"):
			qp.ClickimplementationusingArrays();
			py.clickTryHere();
			break;

		case ("QueueOperations"):
			qp.ClickQueueOperations();
			py.clickTryHere();
			break;

		}

		py.enterValidCode();
		py.clickRun();
		boolean result = py.ValidateOutput();
		Assert.assertTrue(result);
		LoggerLoad.info("The user should see valid output ");

	}

	@Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
	public void verify_practiseQuestionsLink_QueueModule() {
		LoggerLoad.info("TestCase: Check Practise Question link navigates to page with content");
		QueuePage qp = new QueuePage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		qp.ClickImplementationofQueuePython();
		qp.ClickPracticeQuestion();
		Assert.assertTrue(false);
		LoggerLoad.info("The user clicks Practise Questions link");
	}

	@AfterMethod
	public void Signout() {
		SignInPage si = new SignInPage(DriverManager.getDriver());
		DriverManager.getDriver().navigate().back();
		si.signout();
	}

	@DataProvider(name = "Queuetypes")
	public String[] QueueTypes() {
		String[] Queuetypes = { "ImplementationofQueueInpython", "Implementationusingcollectionsdeque",
				"Implementationusingarray", "QueueOperations" };
		return Queuetypes;
	}

}
