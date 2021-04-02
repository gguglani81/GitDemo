package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports exten;

	
	
	public static ExtentReports getReportObject() {
		
		
		String path = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter temp = new ExtentSparkReporter(path);
		temp.config().setDocumentTitle("Test Results");
		temp.config().setReportName("Web Automation Report");
		exten = new ExtentReports();
		exten.attachReporter(temp);
		exten.setSystemInfo("Tester", "Gaurav Gugani");
		exten.setSystemInfo("Owner", "Komal Gugani");
		return exten;
		
	}



	
}
