package resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Practice.AppiumFramework.EcommBase;

public class Listeners implements ITestListener{
	ExtentTest test;
	ExtentReports exten = ExtentReporterNG.getReportObject();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = exten.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());
	//	WebDriver driver;
		String testMethodName = result.getMethod().getMethodName();
		try {
			EcommBase.getScreenshot(testMethodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		exten.flush();

	}

}
