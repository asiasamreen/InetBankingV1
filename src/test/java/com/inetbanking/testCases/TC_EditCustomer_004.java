package com.inetbanking.testCases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.EditCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.ExtentTestManager;
import com.inetbanking.utilities.Helper;

public class TC_EditCustomer_004 extends BaseClass{
  @Test
  public void EditCustomer() throws InterruptedException
  {
	  ExtentTestManager.startTest("Edit Customer Details", "Edit customer details of an existing customer, only editable fields");
	  
	  LoginPage lp = new LoginPage(driver);
	  logger.info("Logging into Inet Banking website");
	  logger.info("Setting username");
	  lp.setusername(uname);
	  logger.info("Setting passwrod");
	  lp.setpwd(pwd);
	  logger.info("submit");
	  lp.clickSubmit();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  logger.info("Successfully logged in");
	  logger.info("click on edit customer link");
	  EditCustomerPage edit_details = new EditCustomerPage(driver);
	  
	  edit_details.edit_customerLink();
	  logger.info("Checking for unexpected ads and windows");
	  //closeads();
	  driver.navigate().refresh();
	  edit_details.edit_customerLink();
	  logger.info("Setting customer id");
	  edit_details.setCustomerid("79552");
	  Thread.sleep(10);
	  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  edit_details.editSubmit();
	  Thread.sleep(10);
	  Helper.scrollTillEnd(driver);
	  Thread.sleep(10);
	  logger.info("Editing details like email address");
	 // doubleClick(driver.findElement(By.name("city")));
	  //Thread.sleep(10);
	  String email = generateRandomString() +"@abc.com";
	  System.out.println("email : " + email);
	  edit_details.set_email(email);
	  Thread.sleep(10);
	  String updatedemail = edit_details.get_email();
	  System.out.println("email : " + updatedemail);
	  Helper.scrollTillEnd(driver);
	  Thread.sleep(10);
	  edit_details.Submit();
	  Thread.sleep(10);
	 
	  if(isAlertPresent())
	  {
		  Alert alert = driver.switchTo().alert();
		  String msg = alert.getText();
		  logger.info("Alert msg :" + msg);
		  alert.accept(); 
		  
	  }
	  
	  /*logger.info("verifying the updated details");
	  edit_details.edit_customerLink();
	  edit_details.setCustomerid("79552");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  edit_details.editSubmit();
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofNanos(30));
	  if(updatedemail.equals(email))
		  logger.info("email Updated successfully");
	  else
		  logger.info("Something went wrong with city update");*/
	  
	  
	  Helper.scrollTillEnd(driver);
	  logger.info("Navigating to home page");
	  edit_details.clickhome();
	  closeads();
	  logger.info("Logging out");
	  lp.clicklogout();
	  driver.switchTo().alert().accept();//succefully logged out alert box.
	  }
  }
	  
	  
	  
	  
  

