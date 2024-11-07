package numpyninja.dsalgo.pagefactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import numpyninja.dsalgo.webdrivermanager.DriverManager;

//tagname[@attributeName='value']
//tagname[text()='value']

//
public class HomePage {

	public WebDriver hdriver;

	public HomePage(WebDriver rdriver) {
		System.out.println("Entered HomePage POM constructor");
		hdriver = rdriver;
		System.out.println("Going to instantiate Web Elements in HomePage");
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//*[@id=\"navbarCollapse\"]/div[1]/div/a")
	@CacheLookup
	private WebElement DS_DROPDOWN;

	@FindBy(xpath = "//div[@class='dropdown-menu show']//a")
	@CacheLookup
	private WebElement DROPDOWN_LIST;

	@FindBy(xpath = "//a[contains(@href,'/array')]")
	@CacheLookup
	private WebElement DD_ARRAY;

	@FindBy(xpath = "//a[contains(@href,'/linked-list')]")
	@CacheLookup
	private WebElement DD_LINKEDLIST;

	@FindBy(xpath = "//a[contains(@href,'/stack')]")
	@CacheLookup
	private WebElement DD_STACK;

	@FindBy(xpath = "//a[contains(@href,'/queue')]")
	@CacheLookup
	private WebElement DD_QUEUE;

	@FindBy(xpath = "//a[contains(@href,'/tree')]")
	@CacheLookup
	private WebElement DD_TREE;

	@FindBy(xpath = "//a[contains(@href,'/graph')]")
	@CacheLookup
	private WebElement DD_GRAPH;

	@FindBy(xpath = "//a[contains(@href,/data-structures-introduction)]")
	@CacheLookup
	private WebElement DS_INTRO_GS;

	@FindBy(xpath = "//a[@href='array']")
	@CacheLookup
	private WebElement ARRAY_GS;

	@FindBy(xpath = "//a[@href='linked-list']")
	@CacheLookup
	private WebElement LINKEDLIST_GS;

	@FindBy(xpath = "//a[@href='stack']")
	@CacheLookup
	private WebElement STACK_GS;

	@FindBy(xpath = "//a[@href='queue']")
	@CacheLookup
	private WebElement QUEUE_GS;

	@FindBy(xpath = "//a[@href='tree']")
	@CacheLookup
	private WebElement TREE_GS;

	@FindBy(xpath = "//a[@href='graph']")
	@CacheLookup
	private WebElement GRAPH_GS;

	@FindBy(xpath = "//div[@role='alert']")
	@CacheLookup
	private WebElement LOGGED_IN_MSG;

	@FindBy(xpath = "//div[contains(text(),'You are not logged in')]")
	@CacheLookup
	private WebElement NOT_LOGGED_IN_MSG;

	@FindBy(xpath = "/html/body/div[1]/nav/a")
	@CacheLookup
	private WebElement NUMPY_NINJA;

	@FindBy(xpath = "//button[normalize-space()='Get Started']")
	private WebElement GETSTARTED_BTN;

	public void clickgetstartedbtn() {
		System.out.println("Inside Home Page pom given");
		hdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		GETSTARTED_BTN.click();

	}

	private String dsintropage = "https://dsportalapp.herokuapp.com/data-structures-introduction/";
	private String arraypage = "https://dsportalapp.herokuapp.com/array/";
	private String llpage = "https://dsportalapp.herokuapp.com/linked-list/";
	private String stackpage = "https://dsportalapp.herokuapp.com/stack/";
	private String queuepage = "https://dsportalapp.herokuapp.com/queue/";
	private String treepage = "https://dsportalapp.herokuapp.com/tree/";
	private String graphpage = "https://dsportalapp.herokuapp.com/graph/";
	private String gspage = "https://dsportalapp.herokuapp.com/";

	public void dropdown() {

		DS_DROPDOWN.click();
	}

	public boolean getdropdownoptions(int count, String options) {
		System.out.println("Entered the POM action method");
		boolean result = false;
		List<WebElement> ddlist = hdriver.findElements(By.xpath("//div[@class='dropdown-menu show']//a"));
		String[] givenlist = options.split(",");
		int counter = 0;

		for (WebElement i : ddlist) {
			String given = i.getText();
			if (Arrays.asList(givenlist).contains(given)) {
				System.out.println(i);
				counter += 1;
				result = true;
			} else {
				// log4j implement
				System.out.println(" Element not present in given list");
				result = false;
				break;
			}

		}

		if (counter == count) {
			System.out.println("all count elements present!");
		}
		return result;
	}

	public void ddarraybtn() {
		dropdown();
		DD_ARRAY.click();

	}

	public void ddlinkedListbtn() {
		dropdown();
		DD_LINKEDLIST.click();
	}

	public void ddstackbtn() {
		dropdown();
		DD_STACK.click();
	}

	public void ddqueuebtn() {
		dropdown();
		DD_QUEUE.click();
	}

	public void ddtreebtn() {
		dropdown();
		DD_TREE.click();
	}

	public void ddgraphbtn() {
		dropdown();
		DD_GRAPH.click();
	}

	public void dsIntrogsbtn() {
		DS_INTRO_GS.click();
	}

	public void arraygsbtn() {
		ARRAY_GS.click();
	}

	public void linkedlistgs() {
		LINKEDLIST_GS.click();

	}

	public void stackgsbtn() {
		STACK_GS.click();

	}

	public void queuegs()

	{
		QUEUE_GS.click();
	}

	public void treegsbtn() {
		TREE_GS.click();
	}

	public void graphgsbtn() {
		GRAPH_GS.click();
	}

	public void clickNumpyNinja() {
		hdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		NUMPY_NINJA.click();
	}

	public boolean VerifyWarningMsg() {
		boolean result = NOT_LOGGED_IN_MSG.isDisplayed();
		return result;
	}

	public boolean VerifySignInMsg() {
		boolean result = LOGGED_IN_MSG.isDisplayed();
		return result;
	}

	public boolean DSIntroPageIsDisplayed() {
		boolean result = hdriver.getCurrentUrl().equalsIgnoreCase(dsintropage);
		return result;
	}

	public boolean ArrayPageIsDisplayed() {
		boolean result = hdriver.getCurrentUrl().equalsIgnoreCase(arraypage);
		return result;
	}

	public boolean StackPageIsDisplayed() {
		boolean result = hdriver.getCurrentUrl().equalsIgnoreCase(stackpage);
		return result;
	}

	public boolean LLPageIsDisplayed() {
		boolean result = hdriver.getCurrentUrl().equalsIgnoreCase(llpage);
		return result;
	}

	public boolean QueuePageIsDisplayed() {
		boolean result = hdriver.getCurrentUrl().equalsIgnoreCase(queuepage);
		return result;
	}

	public boolean TreePageIsDisplayed() {
		boolean result = hdriver.getCurrentUrl().equalsIgnoreCase(treepage);
		return result;
	}

	public boolean GraphPageIsDisplayed() {
		boolean result = hdriver.getCurrentUrl().equalsIgnoreCase(graphpage);
		return result;
	}

	public boolean GetStartedPageIsDisplayed() {
		boolean result = hdriver.getCurrentUrl().equalsIgnoreCase(gspage);
		return result;
	}

}
