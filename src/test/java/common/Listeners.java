package common;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		Reporter.log("onTestStart: Method name is - " + result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		Reporter.log("onTestSuccess: Status of execution is - " + result.getStatus());
	}
	
	public void onTestFailure(ITestResult result) {
		Reporter.log("onTestFailure: Status of execution is - " + result.getStatus());
	}
}
