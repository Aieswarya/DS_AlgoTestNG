package numpyninja.dsalgo.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import numpyninja.dsalgo.constants.Constants;
import numpyninja.dsalgo.pagefactory.Graph;
import numpyninja.dsalgo.pagefactory.HomePage;
import numpyninja.dsalgo.pagefactory.LinkedList;
import numpyninja.dsalgo.pagefactory.PythonEditorPage;
import numpyninja.dsalgo.pagefactory.SignInPage;
import numpyninja.dsalgo.testBase.BaseClass;
import numpyninja.dsalgo.utilities.LoggerLoad;
import numpyninja.dsalgo.webdrivermanager.DriverManager;

public class LinkedListTestCase extends BaseClass {
	
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
	     hp.linkedlistgs();
			
	}
	
	@Test(dataProvider="lltypes")
	public void verify_pagenavigation_for_LinkedListtypes(String type) {
		
		LoggerLoad.info("TestCase : Check Linked List Page Navigation from Linked List Home Page");
		LinkedList ll = new LinkedList(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		boolean result;
		
		
		switch(type) {
			case("Introduction"):
				ll.click_llIntro_link();
			    result=ll.Validate_LLIntro_URL();
			    si.signout();
			    Assert.assertTrue(result);
			    break;
			case("Creating Linked List"):
				ll.click_Createll_link();
			result=ll.Validate_CreateLL_URL();
			 si.signout();
			    Assert.assertTrue(result);
			break;
			case("Types of Linked List"):
				ll.click_Typeofll_link();
			result=ll.Validate_TypesOfLL_URL();
			 si.signout();
			    Assert.assertTrue(result);
			break;
			case("Implement Linked List in Python"):
				ll.click_Implementll_link();
			result=ll.Validate_ImplementLL_URL();
			 si.signout();
			    Assert.assertTrue(result);
			break;
			case("Traversal"):
				ll.click_Traversell_link();
			result=ll.Validate_TraverseLL_URL();
			 si.signout();
			    Assert.assertTrue(result);
			break;
			case("Insertion"):
				ll.click_Insertll_link();
			result=ll.Validate_InsertLL_URL();
			 si.signout();
			    Assert.assertTrue(result);
			break;
			case("Deletion"):
				ll.click_Deletell_link();
			result=ll.Validate_DeleteLL_URL();
			 si.signout();
			    Assert.assertTrue(result);
			break;
		}
		
		
		
		LoggerLoad.info("The user is redirected to LinkedList " +type+ " page");
		
		
	}
	
	@Test(dataProvider="lltypes")
	public void verify_pythonEditorPageNavigation_for_LinkedListtypes(String type)
	{
		LoggerLoad.info("TestCase : Check Linked List Python Editor Page Navigation from Linked List Home Page");
		LinkedList ll = new LinkedList(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		PythonEditorPage py=new PythonEditorPage(DriverManager.getDriver());
		boolean result;
		
		
		switch(type) {
			case("Introduction"):
				ll.click_llIntro_link();
			     break;
			case("Creating Linked List"):
				ll.click_Createll_link();
			break;
			case("Types of Linked List"):
				ll.click_Typeofll_link();
			break;
			case("Implement Linked List in Python"):
				ll.click_Implementll_link();
			break;
			case("Traversal"):
				ll.click_Traversell_link();
			break;
			case("Insertion"):
				ll.click_Insertll_link();
			break;
			case("Deletion"):
				ll.click_Deletell_link();
			
			break;
		}
		
		py.clickTryHere();
	    result=py.editorPgIsDisplayed();
	    DriverManager.getDriver().navigate().back();
		si.signout();
		Assert.assertTrue(result);
		
		LoggerLoad.info("The user is redirected to LinkedList " +type+ " Editor page");
		
		
		
	}
	
	@Test(dataProvider="lltypes")
	public void verify_pythonEditor_for_noCodeSubmission(String type)
	{
		LoggerLoad.info("TestCase : Check Linked List Python Editor for No Code Submission");
		LinkedList ll = new LinkedList(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		PythonEditorPage py=new PythonEditorPage(DriverManager.getDriver());
		boolean result;
		
		
		switch(type) {
			case("Introduction"):
				ll.click_llIntro_link();
			    
			    break;
			case("Creating Linked List"):
				ll.click_Createll_link();
			
			break;
			case("Types of Linked List"):
				ll.click_Typeofll_link();
			break;
			case("Implement Linked List in Python"):
				ll.click_Implementll_link();
			break;
			case("Traversal"):
				ll.click_Traversell_link();
			break;
			case("Insertion"):
				ll.click_Insertll_link();
			break;
			case("Deletion"):
				ll.click_Deletell_link();
			break;
		}
		py.clickTryHere();
	    py.noCodeEntered();
		py.clickRun();
		result=py.alertMsgIsDisplayed();
		DriverManager.getDriver().navigate().back();
		si.signout();
		Assert.assertTrue(result);
		
		
		LoggerLoad.info("The user should see alert message for No code ");
		
		
	}
	
	@Test(dataProvider="lltypes")
	public void verify_pythonEditor_for_InvalidCodeSubmission(String type)
	{
		LoggerLoad.info("TestCase : Check Linked List Python Editor for Invalid Code Submission");
		LinkedList ll = new LinkedList(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		PythonEditorPage py=new PythonEditorPage(DriverManager.getDriver());
		
		switch(type) {
			case("Introduction"):
				ll.click_llIntro_link();
			    py.clickTryHere();		    
			    break;
			case("Creating Linked List"):
				ll.click_Createll_link();
			py.clickTryHere();
			break;
			case("Types of Linked List"):
				ll.click_Typeofll_link();
			py.clickTryHere();
		    break;
			case("Implement Linked List in Python"):
				ll.click_Implementll_link();
			py.clickTryHere();
		    break;
			case("Traversal"):
				ll.click_Traversell_link();
			py.clickTryHere();
		    break;
			case("Insertion"):
				ll.click_Insertll_link();
			py.clickTryHere();
		    break;
			case("Deletion"):
				ll.click_Deletell_link();
			py.clickTryHere();
		   break;
		}
		
		py.enterInValidCode();
		py.clickRun();
		boolean result=py.alertMsgIsDisplayed();
		DriverManager.getDriver().navigate().back();
		si.signout();
		Assert.assertTrue(result);
		LoggerLoad.info("The user should see alert message for Invalid code ");
		}
	
	@Test(dataProvider="lltypes")
	public void verify_pythonEditor_for_ValidCodeSubmission(String type)
	{
		LoggerLoad.info("TestCase : Check Linked List Python Editor for Valid Code submission");
		LinkedList ll = new LinkedList(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		PythonEditorPage py=new PythonEditorPage(DriverManager.getDriver());
		
		switch(type) {
			case("Introduction"):
				ll.click_llIntro_link();
			    py.clickTryHere();		    
			    break;
			case("Creating Linked List"):
				ll.click_Createll_link();
			py.clickTryHere();
			break;
			case("Types of Linked List"):
				ll.click_Typeofll_link();
			py.clickTryHere();
		    break;
			case("Implement Linked List in Python"):
				ll.click_Implementll_link();
			py.clickTryHere();
		    break;
			case("Traversal"):
				ll.click_Traversell_link();
			py.clickTryHere();
		    break;
			case("Insertion"):
				ll.click_Insertll_link();
			py.clickTryHere();
		    break;
			case("Deletion"):
				ll.click_Deletell_link();
			py.clickTryHere();
		   break;
		}
		
		py.enterValidCode();
		py.clickRun();
		boolean result=py.ValidateOutput();
		DriverManager.getDriver().navigate().back();
		si.signout();
		Assert.assertTrue(result);
		LoggerLoad.info("The user should see valid output ");
		
	}
	
	@Test
	public void verify_practiseQuestionsLink_LinkedListModule()
	{
		LoggerLoad.info("TestCase: Check Practise Question link navigates to page with content");
	    LinkedList ll = new LinkedList(DriverManager.getDriver());
	    SignInPage si = new SignInPage(DriverManager.getDriver());
	    ll.click_Createll_link();
		ll.clickPractiseQuestions();
		DriverManager.getDriver().navigate().back();
		si.signout();
		Assert.assertTrue(false);
		LoggerLoad.info("The user clicks Practise Questions link");
	}
	
	@DataProvider(name="lltypes")
	public String[] linkedListTypes()
	{
		String[] lltypes = {"Introduction","Creating Linked List","Types of Linked List","Implement Linked List in Python","Traversal","Insertion","Deletion"};
		return lltypes;
	}

}
