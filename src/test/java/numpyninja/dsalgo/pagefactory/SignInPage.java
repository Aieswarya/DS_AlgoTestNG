package numpyninja.dsalgo.pagefactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import numpyninja.dsalgo.constants.Constants;

public class SignInPage {

	public WebDriver ldriver;
	
	 private String INVALID_USERNAME;
	 private String INVALID_PASSWORD;
     private String EXPECTED_LOGIN_ERROR_MSG;

	public SignInPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	Constants con = new Constants();

	// ----------------------- Web Elements---------------------//

	@FindBy(xpath = "//a[normalize-space()='Sign in']")
	WebElement btnSignin;

	@FindBy(id = "id_username")
	@CacheLookup
	WebElement txtusername;

	@FindBy(id = "id_password")
	@CacheLookup
	WebElement txtpassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnlogin;

	@FindBy(xpath = "//div[contains(text(),'You are logged in')]")
	WebElement loginsuccessmsg;

	@FindBy(xpath = "//a[contains(text(),'TechieExplorers')]")
	WebElement usernameasdisplayedlink;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement invalidusrnamepswd;

	
   
	
	// ----------------MethodsImplementation----------------------------------------//

	public void navigateSignIn() {
		GetStarted gs = new GetStarted(ldriver);
		gs.clickgetstartedbtn();
	}

	public void clickSignIn() {
		btnSignin.click();
	}

	public void ValidCredentials() {

		txtusername.clear();
		txtusername.sendKeys(con.USERNAME);

		txtpassword.clear();
		txtpassword.sendKeys(con.PASSWORD);

	}

	public void clickLogin() {
		btnlogin.click();
	}

	public boolean getLoginMessage() {

		boolean result = loginsuccessmsg.isDisplayed();

		return result;
	}

	public boolean isUsernameDisplayedAsLink() {

		boolean result = usernameasdisplayedlink.getText().equalsIgnoreCase(con.USERNAME);
		return result;
	}

	public String getInvalidLoginmsg() {

		String invalidmsg = invalidusrnamepswd.getText();

		return invalidmsg;

	}

	public void readInvalidCredentials(String Sheetname, int rownumber) throws FileNotFoundException {

		try {

			FileInputStream file = new FileInputStream(new File("Data.xlsx"));

			XSSFWorkbook workbook = new XSSFWorkbook(file);

			Sheet sheet = workbook.getSheet(Sheetname);

			Row row = sheet.getRow(rownumber);

			INVALID_USERNAME = row.getCell(0).getStringCellValue();

			if (rownumber == 3) 
			{
				INVALID_PASSWORD = "";
			} else {
				INVALID_PASSWORD = row.getCell(1).getStringCellValue();
			}

			EXPECTED_LOGIN_ERROR_MSG = row.getCell(2).getStringCellValue();

			doLogin(INVALID_USERNAME, INVALID_PASSWORD);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public boolean ValidateLoginErrorMsg(int rownumber) {
		boolean result = false;
		if (rownumber == 3) {

			String msg = txtpassword.getAttribute("validationMessage");
			result = msg.contains(EXPECTED_LOGIN_ERROR_MSG);

		} else {
			result = invalidusrnamepswd.getText().equalsIgnoreCase(EXPECTED_LOGIN_ERROR_MSG);
		}

		return result;

	}

	public void doLogin(String username, String password) {

		txtusername.clear();
		txtusername.sendKeys(username);

		txtpassword.clear();
		txtpassword.sendKeys(password);

		
	}

	
	
	




}
