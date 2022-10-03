package rahulsheetyacademy.abstactcomp;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNg {
	static ExtentReports Extent;
	public static ExtentReports getExtentNg() {
	String path=System.getProperty("user.dir")+ "\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web AutoMation Testing");
	reporter.config().setDocumentTitle("TestResults");
	 Extent= new ExtentReports();
	Extent.attachReporter(reporter);
	Extent.setSystemInfo("QA", "PAVAN");
	
	return Extent;

}
	}