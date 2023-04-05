package com.inetbanking.testCases;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;
import com.inetbanking.utilities.XUtils;


public class BaseClass {
	
	ReadConfig rc = new ReadConfig();
	
	public String url = rc.getAppUrl();
	public String uname = rc.getUserName();
	public String pwd = rc.getpassword();
	public String browser ="Chrome";
	public static WebDriver driver;
	public static Logger logger;
	//public ExtentTest  test;
	
	@BeforeSuite
	public void setupSuite()
	{
		logger = Logger.getLogger("InetBanking");
		PropertyConfigurator.configure("log4j.properties");
	}
	
	
	@BeforeClass
	 @Parameters ("browser") 
	public void setup(@Optional("chrome")String br)
	{		
		if(br.equals("chrome"))
		{
		System.setProperty("webDriver.chrome.driver", rc.getChrome());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-extensions");
		options.addArguments("test-type");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
		}
		else if(br.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", rc.getFirefox());
			driver= new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("edge"))
		{
			System.setProperty("webDriver.edge.driver", rc.getEdge());
			driver= new EdgeDriver();
		}
		logger.info("Executing on broswer : " + br);
		driver.get(url);
		driver.manage().deleteAllCookies();
		logger.info("Application inet banking starts..");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}
	
	
		public void   writedata()
		{
			String path ="H:\\workspace_selenium_java\\InetBankingV1\\src\\test\\java\\com\\inetbanking\\testData\\inetbanking_testcases.xlsx" ;
			//XUtils xutils = new XUtils(path);
			String sheet ="Countries";
			XUtils.writedata(path,sheet);
			//return data;
		}
		
		public boolean isAlertPresent()
		{
			try {
				driver.switchTo().alert();
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
		public void doubleClick(WebElement element)
		{
			Actions act = new Actions(driver);
			act.doubleClick(element).perform();
		}
		public void closeads() {
			driver.navigate().refresh();
			//driver.switchTo().defaultContent();
		}
		
		public String generateRandomString()
		{
			String random=RandomStringUtils.randomAlphabetic(8);
			return random;
		}


		public String generateRandomNumber()
		{
			String number= RandomStringUtils.randomAlphanumeric(8);
			return number;
		}

		
	@AfterClass
	public void teardown()
	{
		driver.quit();
		
	}   
	}