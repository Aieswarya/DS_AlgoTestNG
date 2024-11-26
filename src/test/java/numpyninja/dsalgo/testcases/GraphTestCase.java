package numpyninja.dsalgo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import numpyninja.dsalgo.constants.Constants;
import numpyninja.dsalgo.pagefactory.Graph;
import numpyninja.dsalgo.pagefactory.HomePage;
import numpyninja.dsalgo.pagefactory.PythonEditorPage;
import numpyninja.dsalgo.pagefactory.SignInPage;
import numpyninja.dsalgo.testBase.BaseClass;
import numpyninja.dsalgo.utilities.LoggerLoad;
import numpyninja.dsalgo.webdrivermanager.DriverManager;

public class GraphTestCase extends BaseClass {
	
	@BeforeMethod
	public  void beforemethod()
	{
		HomePage hp = new HomePage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		DriverManager.getDriver().get(Constants.APP_URL);
		 hp.clickgetstartedbtn();
		 si.clickSignIn();
		 si.ValidCredentials();
	     si.clickLogin();
	     hp.graphgsbtn();
			
	}
	
	

	@Test(priority=9)
	public void verify_graphPg_Nav_from_graphHome() {
		
		LoggerLoad.info("TestCase 9: Check Graph Page Navigation from Graph Home Page");
		Graph gp = new Graph(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		gp.clickGraphLk();
		boolean result = gp.graphPgIsDisplayed();
		si.signout();
		Assert.assertTrue(result);
		LoggerLoad.info("The user is redirected to Graph page");
		
	}

	@Test(priority=10)
	public void verify_Nav_to_graphEditorPage()
	{
		LoggerLoad.info("TestCase 10: Check Graph Page Navigation from Graph Home Page");
		Graph gp = new Graph(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		gp.clickGraphLk();
		gp.clickTryHere();
		boolean result=gp.editorPgIsDisplayed();
		DriverManager.getDriver().navigate().back();
		si.signout();
		Assert.assertTrue(result);
		LoggerLoad.info("The user is redirected to Graph Editor page from Graph Home Page ");
	}
	
	
	@Test(priority=11)
	public void verify_graph_pythonEditor_withoutcode() {
		LoggerLoad.info("TestCase 11: Check alert message when no code entered in Graph Editor page");
		Graph gp = new Graph(DriverManager.getDriver());
		PythonEditorPage py=new PythonEditorPage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		gp.clickGraphLk();
		gp.clickTryHere();
		py.noCodeEntered();
		py.clickRun();
		boolean result=py.alertMsgIsDisplayed();
		DriverManager.getDriver().navigate().back();
		si.signout();
		Assert.assertTrue(result);
		LoggerLoad.info("The user should see alert message");
		
	}
	
	@Test(priority=12)
   public void verify_graph_pythonEditor_withcode() {
		
	    LoggerLoad.info("TestCase 12: Check output validated when code entered in graph editor page");
		Graph gp = new Graph(DriverManager.getDriver());
		PythonEditorPage py=new PythonEditorPage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		gp.clickGraphLk();
		gp.clickTryHere();
		py.enterValidCode();
		py.clickRun();
		boolean result=py.ValidateOutput();
		DriverManager.getDriver().navigate().back();
		si.signout();
		Assert.assertTrue(result);
		LoggerLoad.info("The user should valid output ");
	}
   
   @Test(priority=13)
   public void verify_graph_pythonEditor_invalidcode() {
	    LoggerLoad.info("TestCase 13: Check output validated when invalid code entered in graph editor page");
		Graph gp = new Graph(DriverManager.getDriver());
		PythonEditorPage py=new PythonEditorPage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		gp.clickGraphLk();
		gp.clickTryHere();
		py.enterInValidCode();
		py.clickRun();
		boolean result=py.alertMsgIsDisplayed();
		DriverManager.getDriver().navigate().back();
		si.signout();
		Assert.assertTrue(result);
		LoggerLoad.info("The user should see alert message");
	
    }
   
   @Test(priority=14)
   public void verify_graphRepPg_Nav_from_graphHome() {
	    LoggerLoad.info("TestCase 14: Check Graph Rep Page Navigation ");
		Graph gp = new Graph(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		gp.clickGrapRepLk();
		boolean result=gp.graphRepPgIsDisplayed();
		si.signout();
		Assert.assertTrue(result);
		LoggerLoad.info("The user is redirected ");
	   
	}
   
   @Test(priority=15)
   public void verify_Nav_to_graphRepEditorPage()
	{
	   LoggerLoad.info("TestCase 15: Check Graph Rep Editor Page Navigation");
		Graph gp = new Graph(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		gp.clickGrapRepLk();
		gp.clickTryHere();
		boolean result=gp.editorPgIsDisplayed();
		DriverManager.getDriver().navigate().back();
		si.signout();
		Assert.assertTrue(result);
		LoggerLoad.info("The user is redirected");
	}
   
   @Test(priority=16)
   public void verify_graphRep_pythonEditor_withoutcode() {
	    LoggerLoad.info("TestCase 16: Check alert message when no code entered in GraphRep Editor page");
		Graph gp = new Graph(DriverManager.getDriver());
		PythonEditorPage py=new PythonEditorPage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		gp.clickGrapRepLk();
		gp.clickTryHere();
		py.noCodeEntered();
		py.clickRun();
		boolean result=py.alertMsgIsDisplayed();
		DriverManager.getDriver().navigate().back();
		si.signout();
		Assert.assertTrue(result);
		LoggerLoad.info("The user should see alert message when no code is entered ");
	}
   
   @Test(priority=17)
  public void verify_graphRep_pythonEditor_withcode() {
	   LoggerLoad.info("TestCase 17: Check output validated when code entered in graphRep editor page");
		Graph gp = new Graph(DriverManager.getDriver());
		PythonEditorPage py=new PythonEditorPage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		gp.clickGrapRepLk();
		gp.clickTryHere();
		py.enterValidCode();
		py.clickRun();
		boolean result=py.ValidateOutput();
		DriverManager.getDriver().navigate().back();
		si.signout();
		Assert.assertTrue(result);
		LoggerLoad.info("The user should valid output ");
		
	}
  @Test(priority=18)
  public void verify_graphRep_pythonEditor_invalidcode() {
	   
	  LoggerLoad.info("TestCase 18: Check output validated when invalid code entered in graphRep editor page");
		Graph gp = new Graph(DriverManager.getDriver());
		PythonEditorPage py=new PythonEditorPage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		gp.clickGrapRepLk();
		gp.clickTryHere();
		py.enterInValidCode();
		py.clickRun();
		boolean result=py.alertMsgIsDisplayed();
		DriverManager.getDriver().navigate().back();
		si.signout();
		Assert.assertTrue(result);
		LoggerLoad.info("The user should see alert message when no code is entered ");
	
   }
  
  @Test(priority=19)
  public void verify_practisequestions()
  {
	    LoggerLoad.info("TestCase 19: Check Practise Question link navigates to page with content");
	    Graph gp = new Graph(DriverManager.getDriver());
	    SignInPage si = new SignInPage(DriverManager.getDriver());
	    gp.clickGraphLk();
		gp.clickPractiseQues();
		DriverManager.getDriver().navigate().back();
		si.signout();
		Assert.assertTrue(false);
		LoggerLoad.info("The user clicks Practise Questions link");
  }
	
   
}
