package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	
	WebDriver ldriver;
	
	public EditCustomerPage(WebDriver driver)
	{
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Edit Customer")
	WebElement edit_customer;
	
	@FindBy(name="cusid")
	WebElement customer_id;
	
	@FindBy(name="AccSubmit")
	WebElement accsubmit;
	
	@FindBy(name="emailid")
	WebElement email;

	
	public void set_email(String c_email)
	{
		email.clear();
		email.sendKeys(c_email);
	}
	
	@FindBy(name="sub")
	WebElement submit_edit;
	
	@FindBy(linkText ="Home")
	WebElement homebtn;

	
	public void edit_customerLink()
	{
		edit_customer.click();
	}
	
	public void editSubmit() {
		accsubmit.click();
	}
	
	public void setCustomerid(String id)
	{
		customer_id.sendKeys(id);
	}
	
	public void clickhome()
	{
		homebtn.click();
	}
	
	

	
	public String get_email()
	{
		return email.getAttribute("value");
	}


	public void Submit()
	{
		submit_edit.click();
	}
	
	
	

}
