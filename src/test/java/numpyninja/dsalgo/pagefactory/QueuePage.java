package numpyninja.dsalgo.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import numpyninja.dsalgo.constants.Constants;

public class QueuePage {

	WebDriver gdriver;
	Constants constants = new Constants();

    public QueuePage(WebDriver driver) {
        gdriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath="//a[@href='queue']")
	  public WebElement btngetStarted;

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


	 // ---------------------------------------Methods Implementation--------------------------------------------------------------



	  public void ClickgetstartedQueue()
	  {
		  btngetStarted.click();
	  }


	  public void ClickImplementationofQueuePython() {

		  implementationOfQueueInPython.click();

	  }


	  public void ClickImplementationusingCollections() {
		  implementationUsingCollectionsDeque.click();
	  }


	  public void ClickimplementationusingArrays() {
		  implementationUsingArray.click();
	  }


	  public void ClickQueueOperations() {
		  queueOperations.click();
	  }


	  public void ClickPracticeQuestion() {

		  practice.click();
	  }


}






