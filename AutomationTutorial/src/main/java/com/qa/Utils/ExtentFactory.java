package com.qa.Utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory 
{
	private ExtentFactory() {

	}

	private static ExtentFactory instance=null;

	public static ExtentFactory getInstance() {
		if(instance==null)
		{
			instance= new ExtentFactory();
		}
		return instance;
	}
	
	public static ThreadLocal<ExtentTest> extent=new ThreadLocal<ExtentTest>();
	
	public void setExtent(ExtentTest extentTestObj)
	{
		extent.set(extentTestObj);
	}
	
	public ExtentTest getExtent()
	{
		return extent.get();
	}
	
	public void removeExtentObject()
	{
		extent.remove();
	}
}
