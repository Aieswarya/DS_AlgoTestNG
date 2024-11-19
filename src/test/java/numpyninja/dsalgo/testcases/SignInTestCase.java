package numpyninja.dsalgo.testcases;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import numpyninja.dsalgo.constants.Constants;
import numpyninja.dsalgo.pagefactory.SignInPage;
import numpyninja.dsalgo.testBase.BaseClass;
import numpyninja.dsalgo.utilities.ExcelUtils;
import numpyninja.dsalgo.utilities.LoggerLoad;
import numpyninja.dsalgo.webdrivermanager.DriverManager;



public class SignInTestCase extends BaseClass {
	 String username;
	 String password;
	 String message;
	 private  static final Logger LOGGER= LogManager.getLogger(SignInTestCase.class);
     Constants constant=new Constants();
     
     
     
 	@BeforeMethod
 	public  void beforemethod()
 	{
 		
 		
 		SignInPage sp = new SignInPage(DriverManager.getDriver());
 		DriverManager.getDriver().get(Constants.APP_URL);
 		sp.navigateSignIn();
 	}
 	
 	
 	@Test(dataProvider="InvalidTestData",priority=6)
	public void NegativeTest(String username, String password,String expectedErrorMsg) {
		
		SignInPage sp = new SignInPage(DriverManager.getDriver());
		LoggerLoad.info("TestCase 6: Check warning message displayed for Invalid credentials");
		sp.clickSignIn();
		sp.doLogin(username, password);
	    sp.clickLogin();
	    boolean result= sp.ValidateLoginErrorMsg(password,expectedErrorMsg);
        Assert.assertTrue(result);
        LoggerLoad.info("Verified Warning message");
	}
	
	
	
	@DataProvider(name="InvalidTestData")
	public String[][] readInvalidCredentials() throws IOException {
		     ExcelUtils reader=new ExcelUtils();
		     int totalrows=reader.getRowCount("INVALID_LOGIN");
             int totalcolumns=reader.getCellCount("INVALID_LOGIN",1);
             String LoginData[][]=new String[totalrows][totalcolumns];
             for(int i=1;i<=totalrows;i++) {
            	 
            	 for(int j=0;j<totalcolumns;j++)  {
            		 LoginData[i-1][j]=reader.getCellData("INVALID_LOGIN", i, j);
            		 }
            	 } 
            
             return LoginData;
	  }
	
	
	@Test(priority=7)
	public void verify_SignIn_logged_In() {
		
	LoggerLoad.info("Testcase 7: Check login message");
	SignInPage sp = new SignInPage(DriverManager.getDriver());

	sp.clickSignIn();
	sp.ValidCredentials();
	sp.clickLogin();
	boolean result=sp.getLoginMessage();
	Assert.assertTrue(result);
	LoggerLoad.info("Verified LogIn message");
	    
	}   
	
	
	@Test(priority=8)
	
	public void verify_signIn_Display_of_username() {
		
		LoggerLoad.info("Testcase 8: Check UserName display ");
		SignInPage sp = new SignInPage(DriverManager.getDriver());
		boolean result=sp.isUsernameDisplayedAsLink();
		Assert.assertTrue(result);
		LoggerLoad.info("Verified UserName Display");
	}
}

		 
		 
		 
	    
	



