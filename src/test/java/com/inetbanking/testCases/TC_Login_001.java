package com.inetbanking.testCases;



import java.time.Duration;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.ExtentTestManager;




public class TC_Login_001 extends BaseClass{

	//here logger is the object for log4j and test is the object of extenttest to log information and other things.
	@Test(description  = " valid login scenario ")
	public void logintest()
	{
		ExtentTestManager.startTest("Login Test","valid login scenario,reading from configuration file");
		logger.info("loginTest_001");
		LoginPage lp = new LoginPage(driver);
		logger.info("Setting Username..");
		lp.setusername(uname);
		logger.info("Setting password..");
		lp.setpwd(pwd);
		logger.info("Click Submit..");
		lp.clickSubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("Verifying the Page title..");
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("testcase passed..");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("testcase failed");
		}
	}
}
