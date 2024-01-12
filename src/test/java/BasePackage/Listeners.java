package BasePackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import DataPackage.ExtentReportNG;

public class Listeners extends BaseTest implements ITestListener {
	
	WebDriver driver;
	ExtentTest test;
	ExtentReports report = ExtentReportNG.reportSetUp();
	ThreadLocal<ExtentTest> extendTest = new ThreadLocal<ExtentTest>();
	
	  @Override		
	    public void onTestStart(ITestResult arg0) {					
	        // TODO Auto-generated method stub
		  test = report.createTest(arg0.getMethod().getMethodName());	
		  extendTest.set(test);
	    }		

	    @Override		
	    public void onTestSuccess(ITestResult arg0) {					
	        // TODO Auto-generated method stub	
	    	extendTest.get().log(Status.PASS, "Test Has passed");
	        		
	    }
	    @Override		
	    public void onTestFailure(ITestResult arg0) {					
	        // TODO Auto-generated method stub
	    	extendTest.get().fail(arg0.getThrowable()); //for throw error message
	    			
	    		try {
					driver = (WebDriver) arg0.getTestClass().getRealClass().getField("driver")
							.get(arg0.getInstance());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	
	    	String filepath = null;
	    	
	    	try {
				filepath = getscreenshot(arg0.getMethod().getMethodName(), driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	extendTest.get().addScreenCaptureFromPath(filepath, arg0.getMethod().getMethodName());
	        		
	    }		

	    @Override		
	    public void onTestSkipped(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }	
	    @Override		
	    public void onFinish(ITestContext arg0) {					
	        // TODO Auto-generated method stub	
	    	report.flush();		
	    }		

	    @Override		
	    public void onStart(ITestContext arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }	


}
