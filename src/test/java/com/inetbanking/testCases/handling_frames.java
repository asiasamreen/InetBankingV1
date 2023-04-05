package com.inetbanking.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class handling_frames {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webDriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.findElement(By.name("uid")).sendKeys("mngr484794");
		driver.findElement(By.name("password")).sendKeys("dEpanan");
		driver.findElement(By.name("btnLogin")).click();
		WebElement link = driver.findElement(By.linkText("New Customer"));
		
		link.click();
		WebElement outerFrame= driver.findElement(By.xpath("//iframe[starts-with(@id,'google_ads_iframe')][@title='3rd party ad content']"));
		driver.switchTo().frame(outerFrame);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//WebElement innerFrame = driver.findElement(By.xpath("//iframe[@id='ad_iframe']"));
		//driver.switchTo().frame(innerFrame);
		driver.findElement(By.xpath("//div[@id='card']//div[@id='dismiss-button']")).click();
		/*try {
		int size = driver.findElements(By.tagName("iframe")).size();
				//(By.xpath("//iframe[@id='ad_iframe']")).size();
		System.out.println(size);
		
		//if(size>0) {
		for(int i=0;i<=size;i++)
		{
			String framename = driver.findElements(By.tagName("iframe["+i+"]")).toString();
			System.out.println(framename);
		}
		
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='ad_iframe']")));
		 WebElement close =driver.findElement(By.xpath("//div[@id='dismiss-button']"));
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", close);
		 //switchTo.frame(driver.findElement(By.xpath("")));       
		//driver.findElement(By.id("dismiss-button")).click(); //Close Ad
		//}
		}catch(Exception e)
		{
			System.out.println("unable to handle ad " +e.getMessage());
		}
		driver.switchTo().defaultContent(); // Return to main window*/
	
		
		

	}

}
