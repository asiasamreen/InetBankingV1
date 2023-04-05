package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
 
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)//this driver will be passed from testcase class.
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	@FindBy (name= "uid")
	WebElement username;
	@FindBy (name ="password")
	WebElement passwd ;
	@FindBy (name ="btnLogin")
	WebElement loginbtn;
	@FindBy (partialLinkText ="Log out")
	WebElement logoutbtn;
	
	public void setusername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void setpwd(String pwd)
	{
		passwd.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		loginbtn.click();
	}
	public void clicklogout()
	{
		logoutbtn.click();
	}
	
}
