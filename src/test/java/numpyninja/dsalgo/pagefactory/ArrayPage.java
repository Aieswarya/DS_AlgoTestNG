package numpyninja.dsalgo.pagefactory;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import numpyninja.dsalgo.constants.Constants;

public class ArrayPage {
	  
	public final String HOME = "https://dsportalapp.herokuapp.com/home";
	public final String ARRAY_PAGE_URL = "https://dsportalapp.herokuapp.com/array/";
	public final String ARRAY_PYTHON_URL = "https://dsportalapp.herokuapp.com/array/arrays-in-python/";
	public final String ARRAY_LIST_URL = "https://dsportalapp.herokuapp.com/array/arrays-using-list/";
	public final String ARRAY_BASIC_URL = "https://dsportalapp.herokuapp.com/array/basic-operations-in-lists/";
	public final String ARRAY_APPS_URL = "https://dsportalapp.herokuapp.com/array/applications-of-array/";
	public final String ARRAY_PRACTICE = "https://dsportalapp.herokuapp.com/array/practice";
	public final String EDITOR = "https://dsportalapp.herokuapp.com/tryEditor";
	
	WebDriver gdriver;
	Constants constants = new Constants();
	
	  public ArrayPage(WebDriver webDriver)
	  {
		  gdriver = webDriver;
	      PageFactory.initElements(webDriver, this);
	  }
	  
	  @FindBy (xpath="//a[@href='array']")
	  @CacheLookup
	  public WebElement getStarted;
	  
	  @FindBy (xpath="//*[contains(@href,'tryEditor')]")
	  @CacheLookup
	  public WebElement editor;
	  
	  @FindBy (xpath="//*[contains(@href,'arrays-in-python')]")
	  @CacheLookup
	  public WebElement arraysInPython; 
	  
	  @FindBy (xpath="//*[contains(@href,'arrays-using-list')]")
	  @CacheLookup
	  public WebElement arraysUsingList;
	  
	  @FindBy (xpath="//*[contains(@href,'basic-operations-in-lists')]")
	  @CacheLookup
	  public WebElement arraysBasicList;
	  
	  @FindBy (xpath="//*[contains(@href,'applications-of-array')]")
	  @CacheLookup
	  public WebElement arraysApps;
	  
	  @FindBy (xpath="//*[contains(@href,'practice')]")
	  @CacheLookup
	  public WebElement practice;
	  
	  @FindBy (xpath="//*[@id='answer_form']/div/div")
	  @CacheLookup
	  public WebElement pythonEditor;
	  
	  @FindBy (xpath="//*[@id='answer_form']/button")
	  @CacheLookup
	  public WebElement pythonRun;
	  
	public void enterInValidCode() {
		gdriver.findElement(By.cssSelector(".CodeMirror-scroll")).click();
		JavascriptExecutor js = (JavascriptExecutor) gdriver;
		js.executeScript("window.scrollTo(0,0)");
		gdriver.findElement(By.cssSelector("div:nth-child(1) > textarea"))
				.sendKeys("Print " + constants.PYTHON_EDITOR_INPUT);
		pythonRun.click();
	}

	public void enterValidCode() {
		gdriver.findElement(By.cssSelector(".CodeMirror-scroll")).click();
		JavascriptExecutor js = (JavascriptExecutor) gdriver;
		js.executeScript("window.scrollTo(0,0)");
		gdriver.findElement(By.cssSelector("div:nth-child(1) > textarea"))
				.sendKeys("print" + constants.PYTHON_EDITOR_INPUT);
		pythonRun.click();
	}

	public boolean ValidateOutput() {
		boolean result = false;
		WebElement op = gdriver.findElement(By.xpath("//*[@id='output']"));
		String OUTPUT = op.getText();

		if (OUTPUT.contains(constants.PYTHON_EDITOR_OUTPUT)) {
			result = true;
		}
		return result;
	}
	
	public void run() {
		pythonRun.click();
	}

	public boolean alertMsgIsDisplayed() {
		boolean result = false;
		try {
			Alert alert = gdriver.switchTo().alert();
			result = true;
			alert.accept();
		} catch (NoAlertPresentException exception) {
			exception.printStackTrace();
		}
		return result;
	}
}