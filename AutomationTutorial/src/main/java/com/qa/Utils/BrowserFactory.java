package com.qa.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory 
{
	   public WebDriver driver=null;
	  
       public WebDriver createBrowserInstance(String browsername)
       {
    	   if(browsername.equals("Chrome"))
    	   {
    		   ChromeOptions options= new ChromeOptions();
    		   options.addArguments("--incognito");
    		   WebDriverManager.chromedriver().setup();
    		   driver=new ChromeDriver(options);
    	   }
    	   else if(browsername.equals("Firefox"))
    	   {
    		   FirefoxOptions foptions= new FirefoxOptions();
    		   foptions.addArguments("-private");
    		   WebDriverManager.firefoxdriver().setup();
    		   driver=new FirefoxDriver(foptions);
    	   }
    	   else if(browsername.equals("ie"))
    	   {
    		   InternetExplorerOptions ioptions= new InternetExplorerOptions();
    		   ioptions.addCommandSwitches("-private");
    		   WebDriverManager.iedriver().setup();
    		   driver=new InternetExplorerDriver(ioptions);
    	   }
    	   else
    	    {
    		  System.out.println("Browser details not exists, Pass a valid browser name");
    		  return null;
    	    }
    
		return driver;
       }
     
}
