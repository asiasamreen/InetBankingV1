package com.inetbanking.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	    public static final ExtentReports extentReports = new ExtentReports();

	    public synchronized static ExtentReports createExtentReports() {
	        ExtentSparkReporter reporter = new ExtentSparkReporter("./test-output/extent-report_"+Helper.getCurrentDate() +".html");
	        //reporter.config().setReportName("Sample Extent Report");
	        extentReports.attachReporter(reporter);
	        //extentReports.setSystemInfo("laptop", "SW Test Academy");
	        //extentReports.setSystemInfo("Author", "Samreen");
	        return extentReports;
	    }
	}


