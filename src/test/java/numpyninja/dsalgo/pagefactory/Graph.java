package numpyninja.dsalgo.pagefactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import numpyninja.dsalgo.constants.Constants;


public class Graph {

	WebDriver gdriver;
	Constants constants = new Constants();
	private static final Logger LOGGER = LogManager.getLogger(Graph.class);

	public Graph(WebDriver rdriver) {
		gdriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//a[@href='graph']")
	@CacheLookup
	private static WebElement GRAPH_LK;

	@FindBy(xpath = "//a[contains(@href,'/tryEditor')]")
	@CacheLookup
	private static WebElement TRYHERE_BTN;

	@FindBy(xpath = "//*[@id=\"answer_form\"]")
	@CacheLookup
	private static WebElement geditor;

	//@FindBy(xpath = "//*[@id=\"answer_form\"]/button")
	@FindBy(xpath="//*[@id='answer_form']/button")
	@CacheLookup
	private static WebElement RUN_BTN;

	@FindBy(xpath = "//a[@href='graph-representations']")
	@CacheLookup
	private static WebElement GRAPHREP_LK;

	@FindBy(xpath = "//*[@id=\"answer_form\"]/input")
	@CacheLookup
	private static WebElement grEditor;

	@FindBy(xpath = "//a[contains(@href,'/graph/practice')]")
	@CacheLookup
	private static WebElement PRACTISE_QUESTIONS;

	private String GRAPHPG_URL = "https://dsportalapp.herokuapp.com/graph/graph/";
	private String GRAPHREP_URL = "https://dsportalapp.herokuapp.com/graph/graph-representations/";
	private String EDITOR_URL = "https://dsportalapp.herokuapp.com/tryEditor";

	public void clickGraphLk() {
		GRAPH_LK.click();
	}

	public void clickGrapRepLk() {
		GRAPHREP_LK.click();
	}

	public void clickTryHere() {
		TRYHERE_BTN.click();
	}

	public void clickRun() {
		RUN_BTN.click();
	}

	public void grEditorform(String inputcode) {
		grEditor.sendKeys(inputcode);
	}

	public void geditorform(String inputcode) {
		geditor.sendKeys(inputcode);
	}

	public void clickPractiseQues() {
		PRACTISE_QUESTIONS.click();
	}

	public boolean graphPgIsDisplayed() {
		boolean result = gdriver.getCurrentUrl().equalsIgnoreCase(GRAPHPG_URL);
		return result;
	}

	public boolean graphRepPgIsDisplayed() {
		boolean result = gdriver.getCurrentUrl().equalsIgnoreCase(GRAPHREP_URL);
		return result;
	}

	public boolean editorPgIsDisplayed() {
		boolean result = gdriver.getCurrentUrl().equalsIgnoreCase(EDITOR_URL);
		return result;
	}

	public void enterInValidCode() {
		gdriver.findElement(By.cssSelector(".CodeMirror-scroll")).click();
		JavascriptExecutor js = (JavascriptExecutor) gdriver;
		js.executeScript("window.scrollTo(0,0)");
		gdriver.findElement(By.cssSelector("div:nth-child(1) > textarea"))
				.sendKeys("Print " + constants.PYTHON_EDITOR_INPUT);

	}

	public void enterValidCode() {
		gdriver.findElement(By.cssSelector(".CodeMirror-scroll")).click();
		JavascriptExecutor js = (JavascriptExecutor) gdriver;
		js.executeScript("window.scrollTo(0,0)");
		gdriver.findElement(By.cssSelector("div:nth-child(1) > textarea"))
				.sendKeys("print" + constants.PYTHON_EDITOR_INPUT);

	}

	public void noCodeEntered() {
		gdriver.findElement(By.cssSelector(".CodeMirror-scroll")).click();
		JavascriptExecutor js = (JavascriptExecutor) gdriver;
		js.executeScript("window.scrollTo(0,0)");
		gdriver.findElement(By.cssSelector("div:nth-child(1) > textarea")).sendKeys("");

	}

	public boolean alertMsgIsDisplayed() {
		boolean result = false;
		try {
			Alert alert = gdriver.switchTo().alert();
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

		WebElement op = gdriver.findElement(By.xpath("//*[@id='output']"));

		String OUTPUT = op.getText();

		if (OUTPUT.contains(constants.PYTHON_EDITOR_OUTPUT)) {
			result = true;
		}
		return result;

	}
}
