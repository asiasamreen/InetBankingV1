package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {

	Properties pro;

	public ReadConfig()
	{
		File config = new File("./Configurations\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(config);
			pro= new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("The Error message is :" + e.getMessage());
		}
	}
	
	public String getAppUrl()
	{
		String url = pro.getProperty("Base_url");
		return url;
	}
	
	public String getUserName()
	{
		String name = pro.getProperty("username");
		return name;
	}
	 
	public String getpassword()
	{
		String pwd = pro.getProperty("passwrod");
		return pwd;
	}
	public String getChrome()
	{
		String chrome = pro.getProperty("chromeDriver");
		return chrome;
	}
	public String getFirefox()
	{
		String firefox = pro.getProperty("firefoxDriver");
		return firefox;
	}
	
	public String getEdge()
	{
		String edge = pro.getProperty("edgeDriver");
		return edge;
	}
	

}
