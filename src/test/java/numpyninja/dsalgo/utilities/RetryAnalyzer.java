package numpyninja.dsalgo.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int failedcount=0;  //counter to keep track of retry attempts
	int limitcount=2;  // The max limit to retry running of failed test cases, Set the value to the number of times we want to retry

	@Override //Method to attempt retries for failure tests
	public boolean retry(ITestResult result) {

		if(failedcount<limitcount) {

			failedcount++;
		    return true;

	}

	return false;



	}

}







