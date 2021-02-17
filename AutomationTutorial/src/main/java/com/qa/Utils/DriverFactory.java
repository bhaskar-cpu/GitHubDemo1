package com.qa.Utils;

import org.openqa.selenium.WebDriver;

//ThreadLocal present in java.lang using we can achieve multi threading

//here making our driver instance thread safe 
//each thread maintains their own copy of driver instance
//it internally use ThreadLocalMap
//one object state won't be shared with others
//singleton design pattern -- only one instance exist ever,provide global accesss
//to that instance by creating getInstance method

public class DriverFactory {
     
	//private constructor so that no one else should be able to create object of this class
	private DriverFactory() {

	}

	private static DriverFactory instance=null;

	public static DriverFactory getInstance() {
		if(instance==null)
		{
			instance= new DriverFactory();
		}
		return instance;
	}
	
	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	
	public void setDriver(WebDriver driverParm)
	{
		driver.set(driverParm);
	}
	
	public WebDriver getDriver()
	{
		return driver.get();
	}
	
	public void closeBrowser()
	{
		driver.get().quit();
		driver.remove();
	}
}
