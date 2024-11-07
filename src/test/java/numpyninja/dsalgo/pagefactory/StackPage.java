package numpyninja.dsalgo.pagefactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StackPage {

	
	
WebDriver ldriver;
	
	public StackPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
 
	//-------------------------------WEB ELEMENTS-------------------------//
	
	@FindBy(xpath="//a[@href='stack']")
	@CacheLookup
	WebElement btnstack;
	
	@FindBy(xpath = "//a[text()='Operations in Stack']")
	@CacheLookup
	WebElement btnOperationsinstck;

	@FindBy(xpath = "//a[text()='Implementation']")
	@CacheLookup
	WebElement btnImplementation;
	
	@FindBy(xpath = "//a[text()='Applications']")
	@CacheLookup
	WebElement btnApplications;
	
	@FindBy(xpath = "//a[text()='Try here>>>']")
	@CacheLookup
	WebElement btntryhere;
	
	@FindBy(xpath="//button[text()='Run']")
	@CacheLookup
	WebElement btnrun;
	
    @FindBy(xpath = "//a[text()='Practice Questions']")
	@CacheLookup
	WebElement btnPracticeQuestions;
    
    //--------------------------------------Methods Implementation--------------------------------------//
    
    public void clickStackGetStarted() {
    	System.out.println("Inside click stack GS");
    	btnstack.click();
    	System.out.println("clicked Stack GS");
   }
    
   public void clickOperationsinStack() {
	   btnOperationsinstck.click();
   }
    
    public void clickImplementation() {
    	btnImplementation.click();
    }
    
	public void clickApplications() {
		btnApplications.click();
	}
	
	public void clickTryhere() {
		btntryhere.click();
	}
	
	public void clickRun() {
		btnrun.click();
	}
	
	public void clickPracticeQuestions() {
		btnPracticeQuestions.click();
	}
	
}
	

