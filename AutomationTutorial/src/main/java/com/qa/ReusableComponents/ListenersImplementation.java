package com.qa.ReusableComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.Utils.DriverFactory;
import com.qa.Utils.ExtentFactory;
import com.qa.Utils.ExtentReportNG;

public class ListenersImplementation implements ITestListener{
	
	static ExtentReports report;
    ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test=report.createTest(result.getMethod().getMethodName());
		ExtentFactory.getInstance().setExtent(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		ExtentFactory.getInstance().getExtent().log(Status.PASS,"Test Case: "+result.getMethod().getMethodName()+" is Passed");
		ExtentFactory.getInstance().removeExtentObject();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		ExtentFactory.getInstance().getExtent().log(Status.FAIL,"Test Case: "+result.getMethod().getMethodName()+" is Failed");
		ExtentFactory.getInstance().getExtent().log(Status.FAIL,result.getThrowable());
	     
	    File src=((TakesScreenshot)DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
	    SimpleDateFormat format= new SimpleDateFormat();
	    Date date=new Date();
	    String actualDate= format.format(date);
	    
	    String screenshot= System.getProperty("user.dir")+
	    		"/Reports/Screenshots/"+actualDate+".jpeg";
	    File dest=new File(screenshot);
	    
	    try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(screenshot,"Test Case Failure Screenshot");
		ExtentFactory.getInstance().removeExtentObject();
	    
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		ExtentFactory.getInstance().getExtent().log(Status.SKIP,"Test Case: "+result.getMethod().getMethodName()+" is Skipped");
		ExtentFactory.getInstance().removeExtentObject();
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
		report=ExtentReportNG.setupExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		report.flush();
	}

}
