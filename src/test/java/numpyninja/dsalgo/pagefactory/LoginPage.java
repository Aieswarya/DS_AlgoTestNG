package numpyninja.dsalgo.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver webDriver)
	{
	    PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(name="username")
	@CacheLookup
	WebElement inputUsername;
	  
	@FindBy(name="password")
	@CacheLookup
	WebElement inputPassword;
	
	@FindBy(xpath= "//input[@value=\'Login\']")
	@CacheLookup
	WebElement btnLogin;
	  
	public void SetUserName(String uName) {
	    inputUsername.clear();
	    inputUsername.sendKeys(uName);
	}
	  
	   
	public void SetPassword(String pwd) {
	    inputPassword.clear();
	    inputPassword.sendKeys(pwd);
	}  
	  
	  
	public void ClickBtnLogin() {
	    btnLogin.click();
	}
}
