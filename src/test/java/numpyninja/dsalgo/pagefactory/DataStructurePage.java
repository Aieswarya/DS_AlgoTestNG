package numpyninja.dsalgo.pagefactory;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import numpyninja.dsalgo.constants.Constants;


public class DataStructurePage {

public WebDriver ldriver;
	
	public DataStructurePage(WebDriver rdriver) {
	
		    ldriver=rdriver;
		    PageFactory.initElements(rdriver, this);
	
	}
	
	Constants con=new Constants();
	private static final Logger LOGGER= LogManager.getLogger(DataStructurePage.class);
	
	//-------------------------Web Elements----------------------------------------//
	
	
	@FindBy(xpath="//a[@href='data-structures-introduction']")
	@CacheLookup
	WebElement btngetstarted;
	
	@FindBy(xpath ="//a[@href='time-complexity']")
	@CacheLookup
	WebElement btntimecomplx;
	
	@FindBy(xpath="//a[@href='/tryEditor']")
	@CacheLookup
	WebElement btntryhere;
	
	
	@FindBy(xpath="//button[text()='Run']")
	@CacheLookup
	WebElement btnrun;
	
	
	
    @FindBy(xpath="//a[normalize-space()='Practice Questions']")
    @CacheLookup
    WebElement btnprcques;
    
    //--------------------------------------Methods Implementation----------------------------------------//
    
   
    public void navigateDSHomepage() {
    	
    	SignInPage sp=new SignInPage(ldriver);
    	sp.clickSignIn();
    	sp.ValidCredentials();
    	sp.clickLogin();
    	
    	
    }
    
    public void clickDSStarted() {
    	ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	btngetstarted.click();
    	
    }
    
    public boolean ValidateURL(String expURL) {
    	
    	boolean result=false;
    	
    	if(ldriver.getCurrentUrl().equalsIgnoreCase(expURL)) {
    		
    		result=true;
    	}
    	return result;
    
    }
    
    
    public void clickTimeComplexity() {
    	ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	btntimecomplx.click();
    	
    }
    
    public void clickTryHere() {
    	btntryhere.click();
    }
    
    
    public void enterValidCode() {
		ldriver.findElement(By.cssSelector(".CodeMirror-scroll")).click();
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("window.scrollTo(0,0)");
		ldriver.findElement(By.cssSelector("div:nth-child(1) > textarea"))
				.sendKeys("print" + con.PYTHON_EDITOR_INPUT);

	}
	
	
	public void enterInValidCode() {
		ldriver.findElement(By.cssSelector(".CodeMirror-scroll")).click();
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("window.scrollTo(0,0)");
		ldriver.findElement(By.cssSelector("div:nth-child(1) > textarea"))
				.sendKeys("Print " + con.PYTHON_EDITOR_INPUT);

	}

	

	public void noCodeEntered() {
		ldriver.findElement(By.cssSelector(".CodeMirror-scroll")).click();
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("window.scrollTo(0,0)");
		ldriver.findElement(By.cssSelector("div:nth-child(1) > textarea")).sendKeys("");

	}

	public boolean alertMsgIsDisplayed() {
		boolean result = false;
		try {
			Alert alert = ldriver.switchTo().alert();
			String ALERT_MSG = alert.getText();
			LOGGER.info("Alert MSG is displayed" + ALERT_MSG);
			result = true;
			alert.accept();
		} catch (NoAlertPresentException exception) {
			exception.printStackTrace();
		}
		return result;
	}

	public boolean ValidateOutput() {
		boolean result = false;

		WebElement op = ldriver.findElement(By.xpath("//*[@id='output']"));

		String OUTPUT = op.getText();

		if (OUTPUT.contains(con.PYTHON_EDITOR_OUTPUT)) {
			result = true;
		}
		return result;

	}
    
    public void clickRun() {
    	btnrun.click();
       
    }
  
   
    public void clickPracticeQuestions() {
    	ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	btnprcques.click();
    }
    
}
	

