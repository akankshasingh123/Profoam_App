package com.qa.extendReportListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportNG {
	
	private static ExtentReports extent;

    /**
     * Initializes the ExtentReports instance with desired configuration.
     * 
     * @return ExtentReports instance
     */
    public static ExtentReports getReportObject() {
        String path = System.getProperty("user.dir") + "/reports/ProfoamReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Profoam App Automation Results");
        reporter.config().setDocumentTitle("Profoam Test Report");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Akanksha Singh");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("App", "Profoam");
        return extent;
    }
}


