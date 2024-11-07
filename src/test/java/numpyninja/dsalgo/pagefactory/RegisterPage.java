package numpyninja.dsalgo.pagefactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	        
	public String url;
	  
	  public RegisterPage(WebDriver webDriver)
	  {
	      PageFactory.initElements(webDriver, this);
	      url = "https://dsportalapp.herokuapp.com/register";
	  }

	  @FindBy(name="username")
	  @CacheLookup
	  WebElement inputUsername;
	  
	  @FindBy(id="id_password1")
	  @CacheLookup
	  WebElement inputPassword;
	  
	  @FindBy(id="id_password2")
	  @CacheLookup
	  WebElement inputPassword2;
	
	  @FindBy(xpath="//input[@value=\'Register\']")
	  @CacheLookup
	  WebElement btnRegister;
	
	  @FindBy(xpath="/html/body/div[3]")
	  @CacheLookup
	  WebElement alert;
	  
	  public void SetUserName(String uName) {
		   inputUsername.clear();
		   inputUsername.sendKeys(uName);
	  }

	  public void SetPassword(String pwd) {
		   inputPassword.clear();
		   inputPassword.sendKeys(pwd);
	  }

	  public void SetPassword2(String pwd) {
		   inputPassword2.clear();
		   inputPassword2.sendKeys(pwd);
	  }

	  public void ClickBtnRegister() {
		   btnRegister.click();
	  }
		  
	  public void isUsernameRequiredErrorDisplayed(String uName) {
		   inputPassword2.clear();
		   inputPassword2.sendKeys(uName);
	  }
	  
	  public void PasswordMismatchErrorDisplayed(String pwd) {
		   inputPassword2.clear();
		   inputPassword2.sendKeys(pwd);
	  }

	  public void WeakPasswordErrorDisplayed(String pwd1) {
		   inputPassword2.clear();
		   inputPassword2.sendKeys(pwd1);
	  }
	  
	  public String ErrorMessage() {
		  return alert.getText();
	  }

}
