package com.inetbanking.utilities;

import java.util.Objects;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



import com.aventstack.extentreports.Status;


import com.inetbanking.testCases.BaseClass;



public class Reporting extends BaseClass  implements ITestListener {

	
	
	    private static String getTestMethodName(ITestResult iTestResult) {
	        return iTestResult.getMethod().getConstructorOrMethod().getName();
	    }


	    public void onStart(ITestContext iTestContext) {
	        logger.info("I am in onStart method " + iTestContext.getName());
	        iTestContext.setAttribute("WebDriver", BaseClass.driver);
	    }


	    public void onFinish(ITestContext iTestContext) {
	    	logger.info("I am in onFinish method " + iTestContext.getName());
	        //Do tier down operations for ExtentReports reporting!
	        ExtentManager.extentReports.flush();
	    }


	    public void onTestStart(ITestResult iTestResult) {
	    	logger.info(getTestMethodName(iTestResult) + " test is starting.");
	    }


	    public void onTestSuccess(ITestResult iTestResult) {
	    	logger.info(getTestMethodName(iTestResult) + " test is succeed.");
	        //ExtentReports log operation for passed tests.
	       ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	    }


	    public void onTestFailure(ITestResult iTestResult) {
	    	logger.info(getTestMethodName(iTestResult) + " test is failed.");

	        //Get driver from BaseTest and assign to local webdriver variable.
	       // Object testClass = iTestResult.getInstance();
	        WebDriver driver = BaseClass.driver;
            //String Screenpath = Helper.getScreenshot(driver,getTestMethodName(iTestResult));
	        //Take base64Screenshot screenshot for extent reports
	        String base64Screenshot =
	            "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);

	        //ExtentReports log and screenshot operations for failed tests.
                ExtentTestManager.getTest().log(Status.FAIL, "Test Failed",
	            ExtentTestManager.getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
	    }


	    public void onTestSkipped(ITestResult iTestResult) {
	    	logger.info(getTestMethodName(iTestResult) + " test is skipped.");
	        //ExtentReports log operation for skipped tests.
	        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	    }


	    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	    	logger.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	    }   
	}