package numpyninja.dsalgo.pagefactory;


import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import numpyninja.dsalgo.constants.Constants;

public class LinkedList {

	public WebDriver lldriver;
	Constants constants=new Constants();

	public LinkedList(WebDriver rdriver) {
		lldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@href='introduction']")
	@CacheLookup
	private WebElement LLINTRO_LK;
	@FindBy(xpath = "//a[@href='creating-linked-list']")
	@CacheLookup
	private WebElement CREATE_LL_LK;
	@FindBy(xpath = "//a[@href='types-of-linked-list']")
	@CacheLookup
	private WebElement TYPE_OF_LL_LK;
	@FindBy(xpath = "//a[@href='implement-linked-list-in-python']")
	@CacheLookup
	private WebElement IMPLEMENT_LL_LK;
	@FindBy(xpath = "//a[@href='traversal']")
	@CacheLookup
	private WebElement TRAVERSE_LL_LK;
	@FindBy(xpath = "//a[@href='insertion-in-linked-list']")
	@CacheLookup
	private WebElement INSERTION_LL_LK;
	@FindBy(xpath = "//a[@href='deletion-in-linked-list']")
	@CacheLookup
	private WebElement DELETION_LL_LK;

	@FindBy(xpath = "//a[@href='/linked-list/practice']")
	@CacheLookup
	private WebElement PRACTISE_HERE;

	
	boolean result = false;

	public void click_llIntro_link() {
		LLINTRO_LK.click();
	}

	public void click_Createll_link() {
		CREATE_LL_LK.click();
	}

	public void click_Typeofll_link() {
		TYPE_OF_LL_LK.click();
	}

	public void click_Implementll_link() {
		try {
		IMPLEMENT_LL_LK.click();
		}
		catch(StaleElementReferenceException exception) 
		{
			IMPLEMENT_LL_LK.click();
		}
	}

	public void click_Insertll_link() {
		INSERTION_LL_LK.click();
	}

	public void click_Deletell_link() {
		DELETION_LL_LK.click();
	}

	public void click_Traversell_link() {
		TRAVERSE_LL_LK.click();
	}

	public void clickPractiseQuestions() {
		PRACTISE_HERE.click();
	}

	public boolean Validate_LLIntro_URL() {
		result = lldriver.getCurrentUrl().equalsIgnoreCase(constants.LLINTRO_URL);
		return result;
	}

	public boolean Validate_ImplementLL_URL() {
		result = lldriver.getCurrentUrl().equalsIgnoreCase(constants.IMPLEMENT_LL_URL);
		return result;
	}

	public boolean Validate_TypesOfLL_URL() {
		result = lldriver.getCurrentUrl().equalsIgnoreCase(constants.TYPE_OF_LL_URL);
		return result;
	}

	public boolean Validate_TraverseLL_URL() {
		result = lldriver.getCurrentUrl().equalsIgnoreCase(constants.TRAVERSE_LL_URL);
		return result;
	}

	public boolean Validate_CreateLL_URL() {
		result = lldriver.getCurrentUrl().equalsIgnoreCase(constants.CREATE_LL_URL);
		return result;
	}

	public boolean Validate_DeleteLL_URL() {
		result = lldriver.getCurrentUrl().equalsIgnoreCase(constants.DELETION_LL_URL);
		return result;
	}

	public boolean Validate_InsertLL_URL() {
		result = lldriver.getCurrentUrl().equalsIgnoreCase(constants.INSERTION_LL_URL);
		return result;
	}

}
