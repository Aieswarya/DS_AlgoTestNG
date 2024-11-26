package numpyninja.dsalgo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import numpyninja.dsalgo.constants.Constants;
import numpyninja.dsalgo.pagefactory.Graph;
import numpyninja.dsalgo.pagefactory.HomePage;
import numpyninja.dsalgo.pagefactory.LinkedList;
import numpyninja.dsalgo.pagefactory.PythonEditorPage;
import numpyninja.dsalgo.pagefactory.SignInPage;
import numpyninja.dsalgo.pagefactory.Tree;
import numpyninja.dsalgo.testBase.BaseClass;
import numpyninja.dsalgo.utilities.LoggerLoad;
import numpyninja.dsalgo.webdrivermanager.DriverManager;

public class TreeTestCase extends BaseClass {
	@BeforeMethod
	public static void beforemethod() {
		HomePage hp = new HomePage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		DriverManager.getDriver().get(Constants.APP_URL);
		hp.clickgetstartedbtn();
		si.clickSignIn();
		si.ValidCredentials();
		si.clickLogin();
		hp.treegsbtn();

	}

	@Test(dataProvider="TTYPES")
	public void verify_pagenavigation_for_Treetypes(String type) {
		LoggerLoad.info("TestCase : Check Tree types Page Navigation from Tree Home Page");
		Tree tt = new Tree(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		boolean result;

		switch (type) {
		case ("Overview of Trees"):
			tt.click_Overview_of_trees();
			result = tt.Validate_OverviewOfTreePage();
			//si.signout();
			Assert.assertTrue(result);
			break;
		case ("Terminologies"):
			tt.click_Terminoloies();
			result = tt.Validate_TerminologiesPage();
			//si.signout();
			Assert.assertTrue(result);
			break;
		case ("Types of Trees"):
			tt.click_TypesOfTrees();
			result = tt.Validate_TypesofTreesPage();
			//si.signout();
			Assert.assertTrue(result);
			break;
		case ("Tree Traversals"):
			tt.click_TreeTraversals();
			result = tt.Validate_TreeTraversalsPage();
			//si.signout();
			Assert.assertTrue(result);
			break;
		case ("Traversals-Illustration"):
			tt.click_TraversalsIllustrations();
			result = tt.Validate_TraversalsIllustrationPage();
			//si.signout();
			Assert.assertTrue(result);
			break;
		case ("Binary Trees"):
			tt.click_BinaryTree();
			result = tt.Validate_BinaryTreePage();
			//si.signout();
			Assert.assertTrue(result);
			break;
		case ("Types of Binary Trees"):
			System.out.println("I am going to  click type of Binary Tree");
			tt.click_TypesOfBinaryTree();
			result = tt.Validate_TypesOfBinaryTreePage();
			//si.signout();
			Assert.assertTrue(result);
			break;
		case ("Implementation in Python"):
			tt.click_ImplementationInPython();
			result = tt.Validate_ImplementationInPythonPage();
			//si.signout();
			Assert.assertTrue(result);
			break;
		case ("Binary Tree Traversals"):
			tt.click_BinaryTreeTraversals();
			result = tt.Validate_BinaryTreeTraversalsPage();
			//si.signout();
			Assert.assertTrue(result);
			break;
		case ("Implementation of Binary Trees"):
			tt.click_ImplementationOfBinaryTrees();
			result = tt.Validate_ImplementationOfBinaryTreesPage();
			//si.signout();
			Assert.assertTrue(result);
			break;
		case ("Application of Binary Trees"):
			tt.click_ApplicationsofBinaryTree();
			result = tt.Validate_ApplicationOfBinaryTreesPage();
			//si.signout();
			Assert.assertTrue(result);
			break;
		case ("Binary Search Tree"):
			System.out.println("I am going to click type of Binary Search Tree");
			tt.click_BinarySearchTree();
			result = tt.Validate_BinarySearchTreePage();
			
			Assert.assertTrue(result);
			break;
		case ("Implementation of BST"):
			System.out.println("I am going to click type of Implementation Binary Search Tree");
			tt.click_ImplementationOfBST();
			result = tt.Validate_ImplementationOfBST();
			
			Assert.assertTrue(result);
			break;
		}

		LoggerLoad.info("The user is redirected to Tree " + type + " page");

	}

	@Test(dataProvider = "TTYPES")
	public void verify_pythonEditorPageNavigation_for_Treetypes(String type) {
		LoggerLoad.info("TestCase : Check Tree type Python Editor Page Navigation");
		Tree tt = new Tree(DriverManager.getDriver());
		PythonEditorPage py = new PythonEditorPage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		boolean result;

		switch (type) {
		case ("Overview of Trees"):
			tt.click_Overview_of_trees();

			break;
		case ("Terminologies"):
			tt.click_Terminoloies();

			break;
		case ("Types of Trees"):
			tt.click_TypesOfTrees();

			break;
		case ("Tree Traversals"):
			tt.click_TreeTraversals();

			break;
		case ("Traversals-Illustration"):
			tt.click_TraversalsIllustrations();
			break;
		case ("Binary Trees"):
			tt.click_BinaryTree();
			break;
		case ("Types of Binary Trees"):
			System.out.println("I am going to  click type of Binary Tree");
			tt.click_TypesOfBinaryTree();
			break;
		case ("Implementation in Python"):
			tt.click_ImplementationInPython();
			break;
		case ("Binary Tree Traversals"):
			tt.click_BinaryTreeTraversals();
			break;
		case ("Implementation of Binary Trees"):
			tt.click_ImplementationOfBinaryTrees();
			break;
		case ("Application of Binary Trees"):
			tt.click_ApplicationsofBinaryTree();
			break;
		case ("Binary Search Tree"):
			System.out.println("I am going to click type of Binary Search Tree");
			tt.click_BinarySearchTree();
			break;
		case ("Implementation of BST"):
			System.out.println("I am going to click type of Implementation Binary Search Tree");
			tt.click_ImplementationOfBST();
			break;

		}
		py.clickTryHere();
		result = py.editorPgIsDisplayed();
		//DriverManager.getDriver().navigate().back();
		//si.signout();
		Assert.assertTrue(result);

		LoggerLoad.info("The user is redirected to Tree " + type + " Python Editor page");

	}

	@Test(dataProvider = "TTYPES")
	public void verify_pythonEditor_for_noCodeSubmission(String type) {

		LoggerLoad.info("TestCase : Check Tree type Python Editor functionality for No code submission");
		Tree tt = new Tree(DriverManager.getDriver());
		PythonEditorPage py = new PythonEditorPage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		boolean result;

		switch (type) {
		case ("Overview of Trees"):
			tt.click_Overview_of_trees();

			break;
		case ("Terminologies"):
			tt.click_Terminoloies();

			break;
		case ("Types of Trees"):
			tt.click_TypesOfTrees();

			break;
		case ("Tree Traversals"):
			tt.click_TreeTraversals();

			break;
		case ("Traversals-Illustration"):
			tt.click_TraversalsIllustrations();
			break;
		case ("Binary Trees"):
			tt.click_BinaryTree();
			break;
		case ("Types of Binary Trees"):
			tt.click_TypesOfBinaryTree();
			break;
		case ("Implementation in Python"):
			tt.click_ImplementationInPython();
			break;
		case ("Binary Tree Traversals"):
			tt.click_BinaryTreeTraversals();
			break;
		case ("Implementation of Binary Trees"):
			tt.click_ImplementationOfBinaryTrees();
			break;
		case ("Application of Binary Trees"):
			tt.click_ApplicationsofBinaryTree();
			break;
		case ("Binary Search Tree"):
			tt.click_BinarySearchTree();
			break;
		case ("Implementation of BST"):
			tt.click_ImplementationOfBST();
			break;
		}

		py.clickTryHere();
		py.noCodeEntered();
		py.clickRun();
		result = py.alertMsgIsDisplayed();
		//DriverManager.getDriver().navigate().back();
		//si.signout();
		Assert.assertTrue(result);

		LoggerLoad.info("The user should see an alert window");

	}

	@Test(dataProvider = "TTYPES")
	public void verify_TreepythonEditor_for_InvalidCodeSubmission(String type) {
		LoggerLoad.info("TestCase : Check Tree type Python Editor functionality for Invalid code submission");
		Tree tt = new Tree(DriverManager.getDriver());
		PythonEditorPage py = new PythonEditorPage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		boolean result;

		switch (type) {
		case ("Overview of Trees"):
			tt.click_Overview_of_trees();

			break;
		case ("Terminologies"):
			tt.click_Terminoloies();

			break;
		case ("Types of Trees"):
			tt.click_TypesOfTrees();

			break;
		case ("Tree Traversals"):
			tt.click_TreeTraversals();
			break;
		case ("Traversals-Illustration"):
			tt.click_TraversalsIllustrations();
			break;
		case ("Binary Trees"):
			tt.click_BinaryTree();
			break;
		case ("Types of Binary Trees"):
			tt.click_TypesOfBinaryTree();
			break;
		case ("Implementation in Python"):
			tt.click_ImplementationInPython();
			break;
		case ("Binary Tree Traversals"):
			tt.click_BinaryTreeTraversals();
			break;
		case ("Implementation of Binary Trees"):
			tt.click_ImplementationOfBinaryTrees();
			break;
		case ("Application of Binary Trees"):
			tt.click_ApplicationsofBinaryTree();
			break;
		case ("Binary Search Tree"):
			tt.click_BinarySearchTree();
			break;
		case ("Implementation of BST"):
			tt.click_ImplementationOfBST();
			break;
		}

		py.clickTryHere();
		py.enterInValidCode();
		py.clickRun();
		result = py.alertMsgIsDisplayed();
		//DriverManager.getDriver().navigate().back();
		//si.signout();
		Assert.assertTrue(result);

		LoggerLoad.info("The user should see an alert window");

	}

	@Test(dataProvider = "TTYPES")
	public void verify_TreepythonEditor_for_ValidCodeSubmission(String type) {
		LoggerLoad.info("TestCase : Check Tree type Python Editor functionality for Valid code submission " +type);
		Tree tt = new Tree(DriverManager.getDriver());
		PythonEditorPage py = new PythonEditorPage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		boolean result;

		switch (type) {
		case ("Overview of Trees"):
			System.out.println("I am going to click 1");
			tt.click_Overview_of_trees();
			break;
		case ("Terminologies"):
			System.out.println("I am going to click 2");
		    tt.click_Terminoloies();
			break;
		case ("Types of Trees"):
			System.out.println("I am going to click 3");
			tt.click_TypesOfTrees();
			break;
		case ("Tree Traversals"):
			System.out.println("I am going to click 4");
			tt.click_TreeTraversals();
			break;
		case ("Traversals-Illustration"):
			System.out.println("I am going to click 5");
			tt.click_TraversalsIllustrations();
			break;
		case ("Binary Trees"):
			System.out.println("I am going to click 6");
			tt.click_BinaryTree();
			break;
		case ("Types of Binary Trees"):
			System.out.println("I am going to click 7");
			System.out.println("Iam in Binary Tree");
			tt.click_TypesOfBinaryTree();
			break;
		case ("Implementation in Python"):
			System.out.println("I am going to click 8");
			tt.click_ImplementationInPython();
			break;
		case ("Binary Tree Traversals"):
			System.out.println("I am going to click 9");
			tt.click_BinaryTreeTraversals();
			break;
		case ("Implementation of Binary Trees"):
			System.out.println("I am going to click 10");
			tt.click_ImplementationOfBinaryTrees();
			break;
		case ("Application of Binary Trees"):
			System.out.println("I am going to click 11");
			tt.click_ApplicationsofBinaryTree();
			break;
		case ("Binary Search Tree"):
			System.out.println("I am going to click 12");
			tt.click_BinarySearchTree();
			break;
		case ("Implementation of BST"):
			System.out.println("I am going to click 13");
			tt.click_ImplementationOfBST();
			break;
		}

		py.clickTryHere();
		py.enterValidCode();
		py.clickRun();
		result = py.ValidateOutput();
		//DriverManager.getDriver().navigate().back();
		//si.signout();
		Assert.assertTrue(result);

		LoggerLoad.info("The user should see an alert window");

	}

	@Test
	public void verify_practiseQuestionsLink_TreeModule() {
		LoggerLoad.info("TestCase : Check Practise Question link navigates to page with content");
	    Tree tt = new Tree(DriverManager.getDriver());
	    SignInPage si = new SignInPage(DriverManager.getDriver());
	    tt.click_ApplicationsofBinaryTree();
	    tt.click_PractiseQuestions();
		//DriverManager.getDriver().navigate().back();
		//si.signout();
		Assert.assertTrue(false);
		LoggerLoad.info("The user clicks Practise Questions link");

	}

	@DataProvider(name = "TTYPES")
	public String[] treeTypes() {
		String[] TTYPES = { "Overview of Trees", "Terminologies", "Types of Trees", "Tree Traversals",
				"Traversals-Illustration", "Binary Trees" ,"Types of Binary Trees", "Implementation in Python",
				"Binary Tree Traversals", "Implementation of Binary Trees", "Application of Binary Trees",
				"Binary Search Tree" ,"Implementation of BST" };

		return TTYPES;
	}
	
	@AfterMethod
	public void afterMethod()
	{
		SignInPage signIn = new SignInPage(DriverManager.getDriver());
		DriverManager.getDriver().navigate().back();
		signIn.signout();
	}

}
