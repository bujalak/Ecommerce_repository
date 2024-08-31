package Abstarct_components;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Com.qa.resources.Extent_reports;
import Practice.Testbase;

public class Listeners extends Testbase implements ITestListener{
	
	ExtentTest test;
	ThreadLocal<ExtentTest> thread = new ThreadLocal<ExtentTest>();
	
	
	
	ExtentReports extent = Extent_reports.get_report();
	@Override
	public void onTestStart(ITestResult result) {
		
		test =extent.createTest(result.getMethod().getMethodName());
		thread.set(test);
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test passes");
		
	}
	
	@Override
   public void onTestFailure(ITestResult result) {
		
		thread.get().fail(result.getThrowable());
	try {
		driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		String filepath = null;
		try {
		 filepath = getscreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}
   public void onTestSkipped(ITestResult result) {
		
	}
   public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	   
   }
   
   public void onFinish(ITestContext result) {
	   extent.flush();
   }
	
	
}
