package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CutomerDetailsPage {
	
	WebDriver ldriver;
	
	public CutomerDetailsPage(WebDriver driver)
	{
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText ="New Customer")
	WebElement add_customer;
	
	
	@FindBy(linkText="Delete Customer")
	WebElement delete_customer;
	
	@FindBy(name="name")
	WebElement cust_name;
	@FindBy(xpath="//input[@value='f']")
	WebElement fgender;
	@FindBy(xpath="//input[@value='m']")
	WebElement mgender;
	@FindBy(name="dob")
	WebElement dob;
	@FindBy(name="addr")
	WebElement address;
	@FindBy(name="city")
	WebElement city;
	@FindBy(name="state")
	WebElement state;
	@FindBy(name="pinno")
	WebElement pin;
	
	@FindBy(name="telephoneno")
	WebElement mobile;
	@FindBy(name="emailid")
	WebElement email;
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(name="sub")
	WebElement submit;
	
	@FindBy(name="res")
	WebElement reset;
	
	@FindBy(linkText ="Customer Registered Successfully!!!")
	WebElement registered;
	
	@FindBy(linkText="Continue")
	WebElement c_continue;
	
	@FindBy(id="dismiss-button")
	WebElement dismissad;
	
	public void clickadd_Customer()
	{
		add_customer.click();
	}
	
	
	public void delete_customer()
	{
		delete_customer.click();
	}
	
	public void set_Cust_Name(String cname)
	{
		cust_name.sendKeys(cname);
	}

	public void set_mgender()
	{
			mgender.click();
	}
	
	public void set_fgender()
	{
			fgender.click();
	}
	
	public void set_dob(String mm, String dd,String yyyy) throws InterruptedException
	{
		//dob.clear();
		dob.sendKeys(mm);
		Thread.sleep(1000);
		dob.sendKeys(dd);
		Thread.sleep(1000);
		dob.sendKeys(yyyy);
		Thread.sleep(1000);
	}
	public void set_address(String c_addr)
	{
		address.sendKeys(c_addr);
	}

	public void set_city(String c_city)
	{
		city.sendKeys(c_city);
	}
	
	
	
	public void set_state(String c_state)
	{
		state.sendKeys(c_state);
	}

	
	public void set_pin(String c_pin)
	{
		pin.sendKeys(c_pin);
	}

	public void set_mobile(String number)
	{
		mobile.sendKeys(number);
	}
	public void set_email(String c_email)
	{
		email.sendKeys(c_email);
	}

	public void set_pwd(String c_pwd)
	{
		pwd.sendKeys(c_pwd);
	}
	
	public void submit() {
		submit.click();
	}
	
	
	 public void reset()
	 {
		 reset.click();
	 }
	
	public void dismissadd()
	{
		dismissad.click();
	}
	
	
}
