package com.inetbanking.testCases;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class test_windowhandler {



		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriver driver = new ChromeDriver(options);
			
			driver.get("http://www.dwuser.com/education/content/the-magical-iframe-tag-an-introduction/");
			Thread.sleep(2000);
			driver.manage().window().maximize();
			driver.switchTo().frame("myDemoFrame");
			String framehtml = driver.getPageSource();
	        System.out.println("************start******************");
	        System.out.println(framehtml);
	        System.out.println("************end******************");        
	        driver.switchTo().defaultContent(); // switch to parent    
			String parenttitle = driver.getTitle();
	        System.out.println("Parent title:- "+parenttitle);
		}

	}
