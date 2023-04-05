package com.inetbanking.testCases;

import java.io.IOException;
import java.time.Duration;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.ExtentTestManager;
import com.inetbanking.utilities.Helper;
import com.inetbanking.utilities.XUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(description= "Invalid login scenario,reading testdata from excel sheet",dataProvider = "login_data")
	public void Invalidlogin(String uname,String pwd) throws IOException
	{

		ExtentTestManager.startTest("InValidLogin_DD Test","Invalid login scenario,reading from excel file").createNode("invalid username and pwd");
		logger.info("loginTest_002");
		LoginPage lp = new LoginPage(driver);
		logger.info("Setting Username..");
		lp.setusername(uname);
		logger.info("Setting password..");
		lp.setpwd(pwd);
		logger.info("Click Submit..");
		lp.clickSubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		if(isAlertPresent()==true)
		{
			logger.info("closing invalid login alert");
			driver.switchTo().alert().accept();//close invalid login alert
			driver.switchTo().defaultContent();
			logger.info("invalid username and pwd, login unsuccessful");
			Assert.assertTrue(true);
		}
		else {
			if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
			{
				logger.info("valid username and pwd, login successful");
				Helper.scrollTillEnd(driver);
				lp.clicklogout();
				logger.info("closing logout alert");
				driver.switchTo().alert().accept();//close logout alert
				driver.switchTo().defaultContent();
				Assert.assertTrue(true);
			}
		}
	}




	@DataProvider(name="login_data")
	public String[][] getTestData() throws IOException
	{
		String path =System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/inetbanking_testcases.xlsx" ;
		String sheet ="Login_Details";
		int totalrows = XUtils.getRowCount(path,sheet);
		int totalcolumns = XUtils.getColumnCount(path,sheet);
		String[][] login_data = new String[totalrows][totalcolumns];

		for(int i=1;i<=totalrows;i++)
		{			
			for(int j=0;j<totalcolumns;j++)
			{
				login_data[i-1][j]=XUtils.getData(path,sheet, i, j);
			}
		}
		return login_data;
	}


	@Test
	public void logintest2()
	{

		writedata();
		Assert.assertTrue(true);
	}


}
