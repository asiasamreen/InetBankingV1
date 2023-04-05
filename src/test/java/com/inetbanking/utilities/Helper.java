package com.inetbanking.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;





public class Helper{

	 //methods for handling alerts,screenshots, frames,windows,sync issues, javascript executor, current date
	static JavascriptExecutor js;

	public  static String getCurrentDate()
	{
		DateFormat customdateformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();

		return customdateformat.format(currentDate);
	}
	

	public static String getScreenshot(WebDriver driver,String tcname)
	{
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath = System.getProperty("user.dir")+"/Screenshots/" +tcname+"_"+ getCurrentDate() + ".png";
		 File destination = new File(screenshotpath);
		try {
			FileHandler.copy(screenshot,destination );
		} catch (Exception e) {
			System.out.println("Unable to copy screenshot " + e.getMessage());
		}
		return screenshotpath;
		
	}
	
	public static void scrollTillElement(WebDriver driver,WebElement element)
	{		
       js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView(true);", element);

	}
	public static void scroll(WebDriver driver)
	{
		js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500);");
     }
	public static void scrollTillEnd(WebDriver driver)
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
     }
	
	
	 public static void flash(WebElement element, WebDriver driver)	
	   {
		  String bgcolor =  element.getCssValue("backgroundColor");
		  System.out.println("backgroud color : " + bgcolor);
		  //String color = "red";
		  for(int i=0;i<=500;i++)
		  {
			  changeColor("#000000", element, driver); 
			  changeColor(bgcolor,element, driver); 
			   }
	   }
	   
	   public static void changeColor(String color, WebElement element,WebDriver driver)
	   {
		   JavascriptExecutor js =  ((JavascriptExecutor) driver);
		    js.executeScript("arguments[0].style.backgroundColor='"+color+"' ", element);
		    try
		    {
		    	Thread.sleep(10);
		    }catch(Exception e) {
		 	   }
   
	  }



}
