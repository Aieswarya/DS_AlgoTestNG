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
import numpyninja.dsalgo.webdrivermanager.DriverManager;

public class ArrayPage {

	WebDriver gdriver;
	Constants constants = new Constants();

	public ArrayPage(WebDriver webDriver) {
		gdriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(xpath = "//a[@href='array']")
	@CacheLookup
	public WebElement ARRAY_GETSTARTED;

	@FindBy(xpath = "//*[contains(@href,'tryEditor')]")
	@CacheLookup
	public WebElement TRY_HERE;

	@FindBy(xpath = "//*[contains(@href,'arrays-in-python')]")
	@CacheLookup
	public WebElement ARRAYS_IN_PYTHON;

	@FindBy(xpath = "//*[contains(@href,'arrays-using-list')]")
	@CacheLookup
	public WebElement ARRAYS_USING_LIST;

	@FindBy(xpath = "//*[contains(@href,'basic-operations-in-lists')]")
	@CacheLookup
	public WebElement BASIC_OPS_IN_LIST;

	@FindBy(xpath = "//*[contains(@href,'applications-of-array')]")
	@CacheLookup
	public WebElement APPLICATIONS_OF_ARRAY;

	@FindBy(xpath = "//*[contains(@href,'practice')]")
	@CacheLookup
	public WebElement PRACTISE_QUESTIONS;

	@FindBy(xpath = "//*[@id='answer_form']/div/div")
	@CacheLookup
	public WebElement PYTHON_EDITOR;

	@FindBy(xpath = "//*[@id='answer_form']/button")
	@CacheLookup
	public WebElement RUN;

	public void enterInValidCode() {
		gdriver.findElement(By.cssSelector(".CodeMirror-scroll")).click();
		JavascriptExecutor js = (JavascriptExecutor) gdriver;
		js.executeScript("window.scrollTo(0,0)");
		gdriver.findElement(By.cssSelector("div:nth-child(1) > textarea"))
				.sendKeys("Print " + constants.PYTHON_EDITOR_INPUT);
		RUN.click();
	}

	public void enterValidCode() {
		gdriver.findElement(By.cssSelector(".CodeMirror-scroll")).click();
		JavascriptExecutor js = (JavascriptExecutor) gdriver;
		js.executeScript("window.scrollTo(0,0)");
		gdriver.findElement(By.cssSelector("div:nth-child(1) > textarea"))
				.sendKeys("print" + constants.PYTHON_EDITOR_INPUT);
		RUN.click();
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
		RUN.click();
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

	public void click_ApplicationsOfArray()

	{
		APPLICATIONS_OF_ARRAY.click();
	}

	public void click_ArraysInPython() {
		ARRAYS_IN_PYTHON.click();
	}

	public void click_BasicOpsInList() {
		BASIC_OPS_IN_LIST.click();
	}

	public void click_ArraysUsingList() {
		ARRAYS_USING_LIST.click();
	}

	public void click_PractiseQuestions() {
		PRACTISE_QUESTIONS.click();
	}

	public boolean Validate_ArrayInPython_URL() {
		boolean RESULT = DriverManager.getDriver().getCurrentUrl().contains(constants.ARRAY_PYTHON_URL);
		return RESULT;
	}

	public boolean Validate_ArraysUsingList_URL() {
		boolean RESULT = DriverManager.getDriver().getCurrentUrl().contains(constants.ARRAY_LIST_URL);
		return RESULT;
	}

	public boolean Validate_BasicOpsInList_URL() {
		boolean RESULT = DriverManager.getDriver().getCurrentUrl().contains(constants.ARRAY_BASIC_URL);
		return RESULT;
	}

	public boolean Validate_ApplicationsOfArray_URL() {
		boolean RESULT = DriverManager.getDriver().getCurrentUrl().contains(constants.ARRAY_APPS_URL);
		return RESULT;
	}
}