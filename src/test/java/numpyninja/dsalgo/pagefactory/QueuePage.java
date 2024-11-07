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

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QueuePage {

	WebDriver gdriver;
	Constants constants = new Constants();

    public QueuePage(WebDriver driver) {
        gdriver = driver;
        PageFactory.initElements(driver, this);
    }
	
    @FindBy (xpath="//a[@href='queue']")
	  public WebElement getStarted;
	
	@FindBy (xpath="//*[contains(@href,'implementation-lists')]")
	public WebElement implementationOfQueueInPython;
	
	@FindBy (xpath="//*[contains(@href,'implementation-collections')]")
	public WebElement implementationUsingCollectionsDeque;
	
	@FindBy (xpath="//*[contains(@href,'Implementation-array')]")
	public WebElement implementationUsingArray;
	
	@FindBy (xpath="//*[contains(@href,'QueueOp')]")
	public WebElement queueOperations;
	
	@FindBy (xpath="//*[contains(@href,'practice')]")
	public WebElement practice;	
	
	@FindBy (xpath="//*[contains(@href,'tryEditor')]")
	public WebElement editor;
	  
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
	
	public void run() {
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