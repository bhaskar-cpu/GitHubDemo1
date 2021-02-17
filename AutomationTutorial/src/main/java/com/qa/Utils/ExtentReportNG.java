package com.qa.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.ReusableComponents.ConfigReader;

public class ExtentReportNG {

	public static ExtentReports setupExtentReport() {
		SimpleDateFormat format = new SimpleDateFormat();
		Date date = new Date();
		String actualDate = format.format(date);

		String reportPath = System.getProperty("user.dir") + "/Reports/ExecutionReport_" + actualDate + ".html";

		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(reportPath);
		sparkreporter.config().setDocumentTitle("Document Title");
		sparkreporter.config().setReportName("Report Name");
		sparkreporter.config().setTheme(Theme.DARK);

		ExtentReports extentreport = new ExtentReports();
		extentreport.attachReporter(sparkreporter);
		extentreport.setSystemInfo("Executed on Environment", ConfigReader.prop.getProperty("appUrl"));
		extentreport.setSystemInfo("Executed on Browser", ConfigReader.prop.getProperty("Browser"));
		extentreport.setSystemInfo("Executed on OS", System.getProperty("os.name"));
		extentreport.setSystemInfo("Executed by User", System.getProperty("user.dir"));

		return extentreport;

	}
}
