package com.inetbanking.testCases;



import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import java.util.Set;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;


import org.testng.Assert;
import org.testng.annotations.Test;


import com.inetbanking.pageObjects.CutomerDetailsPage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.ExtentTestManager;
import com.inetbanking.utilities.Helper;


public class TC_AddCustomer_003 extends BaseClass{

	@Test
	public void addCustomer() throws InterruptedException
	{
		ExtentTestManager.startTest("Add customer", "Adding new customer");
		LoginPage lp = new LoginPage(driver);
		logger.info("logging into website");
		lp.setusername(uname);
		lp.setpwd(pwd);
		lp.clickSubmit();//login to website

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		CutomerDetailsPage add_cust = new CutomerDetailsPage(driver);
		logger.info("clicking on new customer link");
		add_cust.clickadd_Customer();
		logger.info("adding customer details");
		logger.info("checking for unexpected ads and other browser windows,just refreshing the page");
		driver.navigate().refresh();
		add_cust.clickadd_Customer();
		//driver.switchTo().defaultContent();
		//add_cust.clickadd_Customer();
		add_cust.set_Cust_Name("Anam");
		add_cust.set_fgender();
		add_cust.set_dob("04", "19", "2013");
		Thread.sleep(2000);
		add_cust.set_address("India");
		add_cust.set_city("Hyderabad");
		add_cust.set_state("Telengana");
		add_cust.set_pin("500059");
		add_cust.set_mobile("1234567890");
		String email = generateRandomString()+"@abc.com";
		add_cust.set_email(email);
		add_cust.set_pwd("anam1234");
		add_cust.submit();	
		logger.info("Details entered");
		if(isAlertPresent())
		{
			driver.switchTo().alert().accept();
			String msg = driver.switchTo().alert().getText();
			logger.info("Alert msg : " +msg);
			Assert.assertTrue(false);
		}else
		{

			Boolean result = driver.getPageSource().contains("Customer Registered Successfully");
			if(result==true)
			{
				Helper.getScreenshot(driver,"addCustomer");
				logger.info("Successfully added new customer");
				Assert.assertTrue(true);
			}
			else
			{			
				logger.info("Unable to add new customer");
				Assert.assertTrue(false);
			}
	}
	}



	public void isFrame() throws InterruptedException
	{

		List<WebElement> outerFrame = driver.findElements(By.xpath("//iframe[starts-with(@id,'google_ads_iframe')][@title='3rd party ad content']"));
		if(outerFrame.size()>0)
		{
			driver.switchTo().frame(0);
			WebElement innerFrame = driver.findElement(By.xpath("//iframe[@id='ad_iframe'][@title='Advertisement']"));
			driver.switchTo().frame(innerFrame);
			WebElement close = driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span"));
			//Helper.flash(close, driver);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", close);
			driver.switchTo().defaultContent();		}
		else
			System.out.println("There are no ads");
	}

	public void handleWindows(){
		String mainWinHandle = driver.getWindowHandle(); // Get your main window
		String subWinHandle = null;

		Set<String> allHandle = driver.getWindowHandles(); // Fetch all handles
		Iterator<String> iterator = allHandle.iterator();
		while (iterator.hasNext()){
			subWinHandle = iterator.next();
		}
		driver.switchTo().window(subWinHandle); // switch to popup

		//Write code to close Ad or skip
		WebElement dismissad = driver.findElement(By.id("dismiss-button"));
		dismissad.click();  
		driver.switchTo().window(mainWinHandle);
	}
}



