package com.qa.Utils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.qa.ReusableComponents.ConfigReader;

public class BaseTest 
{
	BrowserFactory bf= new BrowserFactory();
	WebDriver driver=null;
	Properties prop=null;
	public String browser,appUrl;
	
	@BeforeSuite
	public void intialization()
	{
		prop=ConfigReader.initProperties();
		browser=prop.getProperty("Browser");
		appUrl=prop.getProperty("appUrl");
	}
	
	@BeforeClass
    public void LaunchApplication()
    {
    	DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));
    	driver=DriverFactory.getInstance().getDriver();
    	System.out.println(driver);
    	driver.manage().window().maximize();
    	driver.get(appUrl);
    }
	
	@AfterClass
	public void CloseApplication()
	{
		DriverFactory.getInstance().closeBrowser();
	}
}
