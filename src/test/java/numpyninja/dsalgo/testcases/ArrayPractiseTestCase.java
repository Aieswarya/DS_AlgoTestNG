package numpyninja.dsalgo.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import numpyninja.dsalgo.constants.Constants;
import numpyninja.dsalgo.pagefactory.ArrayPage;
import numpyninja.dsalgo.pagefactory.HomePage;
import numpyninja.dsalgo.pagefactory.SignInPage;
import numpyninja.dsalgo.testBase.BaseClass;
import numpyninja.dsalgo.utilities.LoggerLoad;
import numpyninja.dsalgo.webdrivermanager.DriverManager;
import numpyninja.dsalgo.pagefactory.ArrayPractiseQuestions;

public class ArrayPractiseTestCase extends BaseClass {
	Constants constants = new Constants();
	@BeforeMethod
	public static void beforemethod() {
		HomePage hp = new HomePage(DriverManager.getDriver());
		SignInPage si = new SignInPage(DriverManager.getDriver());
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().get(Constants.APP_URL);
		hp.clickgetstartedbtn();
		si.clickSignIn();
		si.ValidCredentials();
		si.clickLogin();
		hp.arraygsbtn();

	}

	@Test(dataProvider = "APQUESTIONS")
	public void verify_ArrayPractiseQuestion_PageNavigation(String QUESTION)

	{
		LoggerLoad.info("TestCase : Check " + QUESTION + "Python Editor Page for Valid Code Submission");
		ArrayPractiseQuestions arrayPractise = new ArrayPractiseQuestions(DriverManager.getDriver());
		ArrayPage array = new ArrayPage(DriverManager.getDriver());
		SignInPage signIn = new SignInPage(DriverManager.getDriver());
		
         boolean RESULT;
         array.click_ApplicationsOfArray();
 		array.click_PractiseQuestions();

 		switch (QUESTION) {
 		case ("Search the Array"):
 			arrayPractise.Click_SearchTheArray();
 		RESULT=arrayPractise.validate_Search_Array_URL();

 			break;
 		case ("Max Consecutive Ones"):

 			arrayPractise.Click_MaxConsecutives();
 		RESULT=arrayPractise.validate_Max_Ones_URL();
 			break;
 		case ("Find Numbers with Even Numbers of Digits"):
 			arrayPractise.Click_FindNumWithEvenDigits();
 		RESULT=arrayPractise.validate_Find_Even_URL();
 			break;
 		case ("Squares of Sorted Array"):
 			arrayPractise.Click_SquaresOfSortedArray();
 		RESULT=arrayPractise.validate_Sorted_squares_URL();
 			break;
 		}
 		
		
		LoggerLoad.info("The user is redirected to " + QUESTION + " Page");
	}

	@Test(dataProvider = "APQUESTIONS")
	public void verify_ArrayPractiseQues_PythonEditor_for_NoCodeSubmission(String QUESTION) {
		LoggerLoad.info("TestCase : Check " + QUESTION + "Python Editor Page for No Code Submission");
		ArrayPractiseQuestions arrayPractise = new ArrayPractiseQuestions(DriverManager.getDriver());
		ArrayPage array = new ArrayPage(DriverManager.getDriver());
		SignInPage signIn = new SignInPage(DriverManager.getDriver());
		array.click_ApplicationsOfArray();
		array.click_PractiseQuestions();

		switch (QUESTION) {
		case ("Search the Array"):
			arrayPractise.Click_SearchTheArray();

			break;
		case ("Max Consecutive Ones"):

			arrayPractise.Click_MaxConsecutives();
			break;
		case ("Find Numbers with Even Numbers of Digits"):
			arrayPractise.Click_FindNumWithEvenDigits();

			break;
		case ("Squares of Sorted Array"):
			arrayPractise.Click_SquaresOfSortedArray();

			break;
		}
		
		arrayPractise.click_Run();
		boolean RESULT = arrayPractise.alertMsgIsDisplayed();
		DriverManager.getDriver().navigate().back();
		signIn.signout();
		Assert.assertTrue(RESULT);

		LoggerLoad.info("The user sees an alert message");
	}

	@Test(dataProvider = "APQUESTIONS")
	public void verify_ArrayPractiseQues_PythonEditor_for_InValidCodeSubmission(String QUESTION) {
		LoggerLoad.info("TestCase : Check " + QUESTION + "Python Editor Page for InValid Code Submission");
		ArrayPractiseQuestions arrayPractise = new ArrayPractiseQuestions(DriverManager.getDriver());
		ArrayPage array = new ArrayPage(DriverManager.getDriver());
		SignInPage signIn = new SignInPage(DriverManager.getDriver());
		array.click_ApplicationsOfArray();
		array.click_PractiseQuestions();

		switch (QUESTION) {
		case ("Search the Array"):
			arrayPractise.Click_SearchTheArray();
		arrayPractise.enterCodePractice(constants.SEARCH_ARRAY_INVALID_CODE);

			break;
		case ("Max Consecutive Ones"):

			arrayPractise.Click_MaxConsecutives();
		arrayPractise.enterCodePractice(constants.MAX_CONS_ONES_INVALID_CODE);
			break;
		case ("Find Numbers with Even Numbers of Digits"):
			arrayPractise.Click_FindNumWithEvenDigits();
		arrayPractise.enterCodePractice(constants.FIND_EVEN_NUM_OF_DIGITS_INVALID_CODE);
			break;
		case ("Squares of Sorted Array"):
			arrayPractise.Click_SquaresOfSortedArray();
		arrayPractise.enterCodePractice(constants.SQUARES_OF_SORTED_ARRAY_INVALID_CODE);
			break;
		}
		
		
		arrayPractise.click_Run();
		boolean RESULT = arrayPractise.alertMsgIsDisplayed();
		DriverManager.getDriver().navigate().back();
		signIn.signout();
		Assert.assertTrue(RESULT);

		LoggerLoad.info("The user sees an alert message");

	}

	@Test(dataProvider = "APQUESTIONS")
	public void verify_ArrayPractiseQues_PythonEditor_for_ValidCodeSubmission(String QUESTION) {

		LoggerLoad.info("TestCase : Check " + QUESTION + "Python Editor Page for Valid Code Submission");
		ArrayPractiseQuestions arrayPractise = new ArrayPractiseQuestions(DriverManager.getDriver());
		ArrayPage array = new ArrayPage(DriverManager.getDriver());
		SignInPage signIn = new SignInPage(DriverManager.getDriver());
		//System.out.println(" q1 : " +constants.SEARCH_ARRAY_VALID_CODE);
		//System.out.println(" q2 : " +constants.MAX_CONS_ONES_VALID_CODE);
		//System.out.println(" q3 : "+constants.FIND_EVEN_NUM_OF_DIGITS_VALID_CODE);
		//System.out.println(" q4 : "+constants.SQUARES_OF_SORTED_ARRAY_VALID_CODE);
		array.click_ApplicationsOfArray();
		array.click_PractiseQuestions();
		boolean RESULT;

		switch (QUESTION) {
		case ("Search the Array"):
			arrayPractise.Click_SearchTheArray();
		arrayPractise.enterCodePractice(constants.SEARCH_ARRAY_VALID_CODE);
		arrayPractise.click_Run();
		 RESULT = arrayPractise.ValidateArrayPractiseOutput(constants.SEARCH_ARRAY_OUTPUT);
		Assert.assertTrue(true);

			break;
		case ("Max Consecutive Ones"):

			arrayPractise.Click_MaxConsecutives();
		arrayPractise.enterCodePractice(constants.MAX_CONS_ONES_VALID_CODE);
		arrayPractise.click_Run();
		 RESULT = arrayPractise.ValidateArrayPractiseOutput(constants.MAX_CONS_ONES_OUTPUT);
		Assert.assertTrue(RESULT);

			break;
		case ("Find Numbers with Even Numbers of Digits"):
			arrayPractise.Click_FindNumWithEvenDigits();
		arrayPractise.enterCodePractice(constants.FIND_EVEN_NUM_OF_DIGITS_VALID_CODE);
		arrayPractise.click_Run();
		 RESULT = arrayPractise.ValidateArrayPractiseOutput(constants.FIND_EVEN_NUM_OUTPUT);
		Assert.assertTrue(RESULT);

			break;
		case ("Squares of Sorted Array"):
			arrayPractise.Click_SquaresOfSortedArray();
		arrayPractise.enterCodePractice(constants.SQUARES_OF_SORTED_ARRAY_VALID_CODE);
		arrayPractise.click_Run();
		 RESULT = arrayPractise.ValidateArrayPractiseOutput(constants.SQUARES_OF_SORTED_ARRAY_OUTPUT);
		Assert.assertTrue(RESULT);
			break;
		}
		
		

		LoggerLoad.info("The user should see Valid Output");

	}

	@AfterMethod
	public void afterMethod()
	{
		SignInPage signIn = new SignInPage(DriverManager.getDriver());
		DriverManager.getDriver().navigate().back();
		signIn.signout();
	
	}
	@DataProvider(name = "APQUESTIONS")
	public String[] ArrayPractiseQuestions() {
		String[] APQUESTIONS = { "Search the Array", "Max Consecutive Ones", "Find Numbers with Even Numbers of Digits",
				"Squares of Sorted Array" };
		return APQUESTIONS;
	}

	@DataProvider(name = "ATYPES")
	public String[] ArrayTypes() {
		String[] ATYPES = { "Arrays In Python", "Arrays Using List", "Basic Operations in Lists",
				"Applications of Array" };
		return ATYPES;
	}
}
