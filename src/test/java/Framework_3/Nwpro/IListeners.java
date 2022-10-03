package Framework_3.Nwpro;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rahulsheetyacademy.abstactcomp.ExtentReportNg;

public class IListeners extends BaseTest implements ITestListener  {

	ExtentReports Extent=ExtentReportNg.getExtentNg();
	ExtentTest 	test;
	ThreadLocal<ExtentTest>  extenttest= new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	test=Extent.createTest(result.getMethod().getMethodName());
	extenttest.set(test);
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extenttest.get().log(Status.PASS, "TestPassed");
	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extenttest.get().fail(result.getThrowable());
		String testMethodName=result.getMethod().getMethodName();
		try {
			
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		}
		 catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		try {
			extenttest.get().addScreenCaptureFromPath(getScreenshotPath(testMethodName,driver), testMethodName);
			getScreenshotPath(testMethodName,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
		
	
			

			// TODO Auto-generated catch block
//		       test.addScreenCaptureFromBase64String(getScreenshotPath(testMethodName,driver), testMethodName);
//		 getScreenshotPath(testMethodName,driver);
		
	
		
		
	
	
		
	

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Extent.flush();
		
	}
	

}
