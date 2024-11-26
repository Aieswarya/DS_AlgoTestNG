package numpyninja.dsalgo.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetStarted extends BasePage {

	public static WebDriver gsdriver;

	public GetStarted(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[normalize-space()='Get Started']")

	WebElement GETSTARTED_BTN;

	public void clickgetstartedbtn() {
		GETSTARTED_BTN.click();
	}
}
