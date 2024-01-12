package DataPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	
	static ExtentReports report;
	
	public static ExtentReports reportSetUp() {
		
		//Extentreports, ExtentSparkReporter
		
				String path = System.getProperty("user.dir")+"\\reports\\index.html";
				ExtentSparkReporter spark = new ExtentSparkReporter(path);
				spark.config().setReportName("Test Automation");
				spark.config().setDocumentTitle("Test Report");
				
				report = new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("QA", "Soumyadeep Ghosh");
				return report;
	}

}
