package numpyninja.dsalgo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import numpyninja.dsalgo.constants.Constants;
import numpyninja.dsalgo.pagefactory.DataStructurePage;
import numpyninja.dsalgo.pagefactory.GetStarted;
import numpyninja.dsalgo.pagefactory.PythonEditorPage;
import numpyninja.dsalgo.pagefactory.SignInPage;
import numpyninja.dsalgo.testBase.BaseClass;
import numpyninja.dsalgo.utilities.LoggerLoad;
import numpyninja.dsalgo.webdrivermanager.DriverManager;

public class DataStructureTestCase extends BaseClass{

	
	
	Constants constant=new Constants();
	
	@BeforeMethod
 	public  void beforemethod()
 	{
 		
 		
 		DataStructurePage ds=new DataStructurePage(DriverManager.getDriver());
 		LoggerLoad.info("I am in Before Method of DataStructureTestcase");
 		DriverManager.getDriver().get(Constants.APP_URL);
 		GetStarted gs=new GetStarted(DriverManager.getDriver());
 		gs.clickgetstartedbtn();
 	    ds.navigateDSHomepage();
 	}
	
	
	@Test(priority=1)
	
	public void Navigate_DataStructureHomepage()
	
	{
	
		DataStructurePage ds=new DataStructurePage(DriverManager.getDriver());
		LoggerLoad.info("I am inside the DataStructureTestcase 1");
		ds.clickDSStarted();
		 boolean result=ds.ValidateURL("https://dsportalapp.herokuapp.com/data-structures-introduction/" );
		 SignInPage sp = new SignInPage(DriverManager.getDriver());
		 //sp.Click_Signout();
		 Assert.assertTrue(result);
		 
		
	
	}
	
	
	@Test(priority=2)
	
	public void Navigate_TimeComplexityPage()
	
	{
	
		DataStructurePage ds=new DataStructurePage(DriverManager.getDriver());
		LoggerLoad.info("I am inside the DataStructureTestcase 2");
		 ds.clickDSStarted();
	     ds.clickTimeComplexity();
	     boolean result=ds.ValidateURL("https://dsportalapp.herokuapp.com/data-structures-introduction/time-complexity/" );
	     SignInPage sp = new SignInPage(DriverManager.getDriver());
			//sp.Click_Signout();
		 Assert.assertTrue(result);
	
}

	@Test(priority=3)
	
	public void Navigate_PythonEditorPage() {
		
		DataStructurePage ds=new DataStructurePage(DriverManager.getDriver());
		SignInPage sp = new SignInPage(DriverManager.getDriver());
		LoggerLoad.info("I am inside the DataStructureTestcase 3");
		ds.clickDSStarted();
		ds.clickTimeComplexity();
		ds.clickTryHere();
		boolean result=ds.ValidateURL("https://dsportalapp.herokuapp.com/tryEditor" );
		DriverManager.getDriver().navigate().back();
		//sp.Click_Signout();
		Assert.assertTrue(result);
		
		
		
	}
	
	
	@Test(priority=4)
	
	public void EnteringValidPythoncode() {

		PythonEditorPage pe=new PythonEditorPage(DriverManager.getDriver());
		SignInPage sp = new SignInPage(DriverManager.getDriver());
		DataStructurePage ds=new DataStructurePage(DriverManager.getDriver());
		LoggerLoad.info("I am inside the DataStructureTestcase 4");
		ds.clickDSStarted();
		ds.clickTimeComplexity();
		ds.clickTryHere();
		pe.enterValidCode();
		pe.clickRun();
		boolean result=pe.ValidateOutput();
		DriverManager.getDriver().navigate().back();
		//sp.Click_Signout();
		Assert.assertTrue(result);
		
	}
	
	
	@Test(priority=5)
	public void EnteringInValidPythoncode() {

		PythonEditorPage pe=new PythonEditorPage(DriverManager.getDriver());
		SignInPage sp = new SignInPage(DriverManager.getDriver());
		DataStructurePage ds=new DataStructurePage(DriverManager.getDriver());
		LoggerLoad.info("I am inside the DataStructureTestcase 4");
		ds.clickDSStarted();
		ds.clickTimeComplexity();
		ds.clickTryHere();
		pe.enterInValidCode();
		pe.clickRun();
		boolean result=pe.alertMsgIsDisplayed();
		DriverManager.getDriver().navigate().back();
		//sp.Click_Signout();
		Assert.assertTrue(result);
		
	}
	
	
	
	
	
	
}