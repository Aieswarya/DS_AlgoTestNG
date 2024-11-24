package numpyninja.dsalgo.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;
import numpyninja.dsalgo.webdrivermanager.DriverManager;

public class AllureExecutionListener implements ITestListener {

	private static String getTestMethodname(ITestResult iTestResult) {

		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
    @Attachment
	public byte[] saveFailureScreenshot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
    @Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
    }
    @Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("I am in onTestFailure method " + getTestMethodname(iTestResult) + "failed");
		WebDriver driver = DriverManager.getDriver();
		if (driver instanceof WebDriver) {
			System.out.println("Screenshot captured for testcase:" + getTestMethodname(iTestResult));
			saveFailureScreenshot(driver);
		}
		saveTextLog(getTestMethodname(iTestResult) + "failed and screenshot taken!");
	}

}
