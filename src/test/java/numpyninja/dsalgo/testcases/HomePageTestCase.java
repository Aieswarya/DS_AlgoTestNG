package numpyninja.dsalgo.testcases;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class HomePageTestCase extends BaseClass {
	
	private static final Logger LOGGER = LogManager.getLogger(HomePageTestCase.class);
	
	@Test(dataProvider="ddoptions")
	public void verify_WarningMsg_for_ddselect_withoutsignin(String type) {
		
		HomePage hp = new HomePage(DriverManager.getDriver());
		
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
			
	    
		LOGGER.info("The user checks warning message is displayed");
     }
    
	
	

	@DataProvider(name="ddoptions")
	public static String[] ddoptions()
	{
		String[] ddoptions = {"Array","Linked List","Stack","Queue","Tree","Graph"};
		return ddoptions;
	}
	
	
	@BeforeMethod
	public static void beforemethod()
	{
		HomePage hp = new HomePage(DriverManager.getDriver());
		DriverManager.getDriver().get(Constants.APP_URL);
		 hp.clickgetstartedbtn();
	}
	
	
	
}
