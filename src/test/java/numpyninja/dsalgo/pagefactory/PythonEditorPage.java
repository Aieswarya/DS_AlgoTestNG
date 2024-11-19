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
import numpyninja.dsalgo.utilities.LoggerLoad;

public class PythonEditorPage {
	
	public WebDriver ldriver;
	Constants con=new Constants();
	
	public PythonEditorPage (WebDriver rdriver) {
		
	    ldriver=rdriver;
	    PageFactory.initElements(rdriver, this);

}
	
	@FindBy(xpath="//button[text()='Run']")
	@CacheLookup
	WebElement btnrun;
	  
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
			LoggerLoad.info("Alert MSG is displayed" + ALERT_MSG);
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

}
