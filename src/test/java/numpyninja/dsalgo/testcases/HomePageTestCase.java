package numpyninja.dsalgo.testcases;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import numpyninja.dsalgo.constants.Constants;
import numpyninja.dsalgo.pagefactory.GetStarted;
import numpyninja.dsalgo.pagefactory.HomePage;
import numpyninja.dsalgo.pagefactory.SignInPage;
import numpyninja.dsalgo.testBase.BaseClass;
import numpyninja.dsalgo.webdrivermanager.DriverManager;
import numpyninja.dsalgo.utilities.LoggerLoad;

public class HomePageTestCase extends BaseClass {
	
	
	
	@BeforeMethod
	public  void beforemethod()
	{
		HomePage hp = new HomePage(DriverManager.getDriver());
		DriverManager.getDriver().get(Constants.APP_URL);
		 hp.clickgetstartedbtn();
	}
	
	
	
	@Test(dataProvider="ddoptions",priority=1)
	public void verify_WarningMsg_for_ddselect_withoutsignin(String type) {
		
		HomePage hp = new HomePage(DriverManager.getDriver());
		
		LoggerLoad.info("TestCase 1 : Check if a Warning Message is displayed for dropdown options click without SignIn");
		
		switch (type) {

		case "Array":
			hp.ddarraybtn();
			break;
		case "Linked List":
			hp.ddlinkedListbtn();
			break;
		case "Stack":
			hp.ddstackbtn();
			break;
		case "Queue":
			hp.ddqueuebtn();
			break;
		case "Tree":
			hp.ddtreebtn();
			break;
		case "Graph":
			hp.ddgraphbtn();
			break;
		default:
			System.out.println("Unable to find this topic....");
			break;
		}
		
		boolean result = hp.VerifyWarningMsg();
	    Assert.assertTrue(result);
	    LoggerLoad.info("Verified Warning message is displayed");
		 }
    
	@Test(dataProvider="ddoptions",priority=2)
	public void verify_WarningMsg_for_gsBtnClick_withoutSignIn(String type)
	{
        HomePage hp = new HomePage(DriverManager.getDriver());
		
		LoggerLoad.info("TestCase 2 : Check if a Warning Message is displayed for GS button click without SignIn");
		
		switch (type) {

		case "Array":
			hp.arraygsbtn();
			break;
		case "Linked List":
			hp.linkedlistgs();
			break;
		case "Stack":
			hp.stackgsbtn();
			break;
		case "Queue":
			hp.queuegs();
			break;
		case "Tree":
			hp.treegsbtn();
			break;
		case "Graph":
			hp.graphgsbtn();
			break;
		default:
			System.out.println("Unable to find this topic....");
			break;
		}
		
		boolean result = hp.VerifyWarningMsg();
	    Assert.assertTrue(result);
	    LoggerLoad.info("Verified Warning message is displayed");
			
	}
	

	@DataProvider(name="ddoptions")
	public static String[] ddoptions()
	{
		String[] ddoptions = {"Array","Linked List","Stack","Queue","Tree","Graph"};
		return ddoptions;
	}
	
	@Test(dataProvider="ddoptions",priority=3)
	public void verify_correctPageNavigation_for_gsBtnClick_withSignIn(String type)
	{
       HomePage hp = new HomePage(DriverManager.getDriver());
       SignInPage si = new SignInPage(DriverManager.getDriver());
	   LoggerLoad.info("TestCase 3 : Check if  correct page is navigated for GetStarted button click with SignIn");
	   boolean result;
	   
	    si.clickSignIn();
		si.ValidCredentials();
		si.clickLogin();
		
		switch (type) {

		case "Array":
			hp.arraygsbtn();
			result=hp.ArrayPageIsDisplayed();
			si.signout();
			Assert.assertTrue(result);
			break;
		case "Linked List":
			hp.linkedlistgs();
			result=hp.LLPageIsDisplayed();
			si.signout();
			Assert.assertTrue(result);
			break;
		case "Stack":
			hp.stackgsbtn();
			result=hp.StackPageIsDisplayed();
			si.signout();
			Assert.assertTrue(result);
			break;
		case "Queue":
			hp.queuegs();
			result=hp.QueuePageIsDisplayed();
			si.signout();
			Assert.assertTrue(result);
			break;
		case "Tree":
			hp.treegsbtn();
			result=hp.TreePageIsDisplayed();
			si.signout();
			Assert.assertTrue(result);
			break;
		case "Graph":
			hp.graphgsbtn();
			result=hp.GraphPageIsDisplayed();
			si.signout();
			Assert.assertTrue(result);
			break;
		default:
			System.out.println("Unable to find this topic....");
			break;
		}
		
		LoggerLoad.info("Verified correct Page Navigation");
		
	}

	@Test(dataProvider="ddoptions",priority=4)
	public void verify_correctPageNavigation_for_ddoptionsClick_with_SignIn(String type)
	{
        HomePage hp = new HomePage(DriverManager.getDriver());
        SignInPage si = new SignInPage(DriverManager.getDriver());
        LoggerLoad.info("TestCase 4 : Check if  correct page is navigated for ddoptions click with SignIn");
		boolean result;

	    si.clickSignIn();
		si.ValidCredentials();
		si.clickLogin();
		
		switch (type) {

		case "Array":
			hp.ddarraybtn();
			result = hp.ArrayPageIsDisplayed();
			si.signout();
			Assert.assertTrue(result);
			break;		
		case "Linked List":
			hp.ddlinkedListbtn();
			result=hp.LLPageIsDisplayed();
			si.signout();
			Assert.assertTrue(result);
			break;
		case "Stack":
			hp.ddstackbtn();
			result=hp.StackPageIsDisplayed();
			si.signout();
			Assert.assertTrue(result);
			break;
		case "Queue":
			hp.ddqueuebtn();
			result=hp.QueuePageIsDisplayed();
			si.signout();
			Assert.assertTrue(result);
			break;
		case "Tree":
			hp.ddtreebtn();
			result=hp.TreePageIsDisplayed();
			si.signout();
			Assert.assertTrue(result);
			break;
		case "Graph":
			hp.ddgraphbtn();
			result=hp.GraphPageIsDisplayed();
			si.signout();
			Assert.assertTrue(result);
			break;
		default:
			System.out.println("Unable to find this topic....");
			break;
		}
		LoggerLoad.info("Verified correct Page Navigation");
	}
	

    @Test(dataProvider="ddoptions",priority=5)
	public void verify_NumpyNinjaBtnClick(String type)
	{
    	HomePage hp = new HomePage(DriverManager.getDriver());
    	SignInPage si = new SignInPage(DriverManager.getDriver());
    	
		
		LoggerLoad.info("TestCase 5 : Check if NumpyNinja button click works in any DsAlgo module page");
    	switch (type) {

		case "Array":
			si.clickSignIn();
			si.ValidCredentials();
			si.clickLogin();
			hp.arraygsbtn();
			hp.clickNumpyNinja();
			break;
		case "Linked List":
			hp.linkedlistgs();
			hp.clickNumpyNinja();
			break;
		case "Stack":
			hp.stackgsbtn();
			hp.clickNumpyNinja();
			break;
		case "Queue":
			hp.queuegs();
			hp.clickNumpyNinja();
			break;
		case "Tree":
			hp.treegsbtn();
			hp.clickNumpyNinja();
			break;
		case "Graph":
			hp.graphgsbtn();
			hp.clickNumpyNinja();
			break;
		default:
			System.out.println("Unable to find this type....");
			break;
		}
    	
    	boolean result = hp.GetStartedPageIsDisplayed();
		Assert.assertTrue(result);
		LoggerLoad.info("The user is redirected to Get Started page");
		
		LoggerLoad.info("Verified NumpyNinja Button click");
	}

    
}
