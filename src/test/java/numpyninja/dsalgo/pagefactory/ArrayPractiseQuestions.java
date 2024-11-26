package numpyninja.dsalgo.pagefactory;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import numpyninja.dsalgo.constants.Constants;
import numpyninja.dsalgo.utilities.LoggerLoad;
import numpyninja.dsalgo.webdrivermanager.DriverManager;

public class ArrayPractiseQuestions extends BasePage {
	
	Constants constant = new Constants();

	public ArrayPractiseQuestions(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//a[@href='/question/1']")
	private WebElement SEARCH_THE_ARRAY_LINK;
	
	@FindBy(xpath="//a[@href='/question/2']")
	private WebElement MAX_CONSECUTIVES_LINK;
	
	@FindBy(xpath="//a[@href='/question/3']")
	private WebElement FIND_NUM_WITH_EVEN_DIGITS_LINK;
	
	@FindBy(xpath="//a[@href='/question/4']")
	private WebElement SQUARES_OF_A_SORTED_ARRAY_LINK;
	
	@FindBy(xpath="//button[@type='button' and text()='Run']")
	private WebElement RUN;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement SUBMIT;
	
	
	@FindBy(xpath="//div[contains(@class,'CodeMirror') and contains(@class,'cm-s-default')]//textarea")
	private WebElement TRY_HERE_EDITOR;
	
	@FindBy(id="answer_form")
	WebElement ANSWER_FORM;
	
	
	@FindBy(id="output")
	WebElement TRY_HERE_OUTPUT;
	
	
	private String[] ATYPES = { "Arrays In Python", "Arrays Using List", "Basic Operations in Lists",
	"Applications of Array" };
	
	private String SEARCH_THE_ARRAY_URL="https://dsportalapp.herokuapp.com/question/1";
	private String MAX_CONSECUTIVES_URL="https://dsportalapp.herokuapp.com/question/2";
	private String FIND_NUM_WITH_EVEN_DIGITS_URL="https://dsportalapp.herokuapp.com/question/3";
	private String SQUARES_OF_A_SORTED_ARRAY_URL="https://dsportalapp.herokuapp.com/question/4";
	
	public void Click_SearchTheArray()
	{
		SEARCH_THE_ARRAY_LINK.click();
	}
	
	public void Click_MaxConsecutives()
	{
		MAX_CONSECUTIVES_LINK.click();
	}
	
	public void Click_FindNumWithEvenDigits()
	{
		FIND_NUM_WITH_EVEN_DIGITS_LINK.click();
	}
	public void Click_SquaresOfSortedArray()
	{
		SQUARES_OF_A_SORTED_ARRAY_LINK.click();
	}
	
	public void click_Run()
	{
		WebDriverWait w1= new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(40));
		w1.until(ExpectedConditions.elementToBeClickable(RUN));
		RUN.click();
	}
	public void click_Submit()
	{
		WebDriverWait webdriverWait= new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(40));
		webdriverWait.until(ExpectedConditions.elementToBeClickable(SUBMIT));
		SUBMIT.click();
	}
	
	
	
	
	public boolean validate_Search_Array_URL()
	{
		boolean result;
		
		 result=DriverManager.getDriver().getCurrentUrl().contains(SEARCH_THE_ARRAY_URL);
		 return result;
	}
	
	public boolean validate_Max_Ones_URL()
	{
		boolean result;
		
		 result=DriverManager.getDriver().getCurrentUrl().equalsIgnoreCase(MAX_CONSECUTIVES_URL);
		 return result;
	}
	public boolean validate_Find_Even_URL()
	{
		boolean result;
		
		 result=DriverManager.getDriver().getCurrentUrl().equalsIgnoreCase(FIND_NUM_WITH_EVEN_DIGITS_URL);
		 return result;
	}
	
	public boolean validate_Sorted_squares_URL()
	{
		boolean result;
		
		 result=DriverManager.getDriver().getCurrentUrl().equalsIgnoreCase(SQUARES_OF_A_SORTED_ARRAY_URL);
		 return result;
	}
	
	
	
	public boolean alertMsgIsDisplayed() {
		boolean result = false;
		try {
			Alert alert = DriverManager.getDriver().switchTo().alert();
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

		WebElement op = DriverManager.getDriver().findElement(By.xpath("//*[@id='output']"));

		String OUTPUT = op.getText();

		if (OUTPUT.contains(constant.PYTHON_EDITOR_OUTPUT)) {
			result = true;
		}
		return result;
	}
		////////////////////
	
	public String getOutputValue() {
		WebDriverWait w1= new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(40));
		w1.until(ExpectedConditions.visibilityOf(TRY_HERE_OUTPUT));
		return TRY_HERE_OUTPUT.getText().trim();
	}
	
	public String getTryHereEditorValue() {
		return TRY_HERE_EDITOR.getText();
	}
		
	public boolean ValidateArrayPractiseOutput(String expectedOutput) {
		boolean RESULT =getOutputValue().equalsIgnoreCase(expectedOutput) ;
		return RESULT;
	}
		
		public void enterCodePractice(String code) {
				
			ANSWER_FORM.click();
			String[] str1 = code.split("\\\\n");

			
			TRY_HERE_EDITOR.sendKeys(Keys.CONTROL+"a");
			TRY_HERE_EDITOR.sendKeys(Keys.DELETE);
			
			for (int i = 0; i < str1.length; i++) {
				
				if (str1[i].contains("\\b")) {

					TRY_HERE_EDITOR.sendKeys(Keys.BACK_SPACE);
				} else {
					TRY_HERE_EDITOR.sendKeys(str1[i]);
					TRY_HERE_EDITOR.sendKeys(Keys.ENTER);
					
				}
			}
			
			
			
		}
		}
