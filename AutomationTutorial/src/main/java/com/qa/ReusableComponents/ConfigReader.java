package com.qa.ReusableComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{

   public static Properties initProperties()
   {
	   Properties prop =new Properties();
 	  FileInputStream input;
		try {
			input = new FileInputStream(new File("./src/test/resources/config/config.properties"));
			prop.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	 return prop; 
   }
}
