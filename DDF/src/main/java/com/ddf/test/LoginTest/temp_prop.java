package com.ddf.test.LoginTest;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class temp_prop   {
	public Properties prop;
	
	@Test
	public void readprop() {
		if (prop == null) {
			prop = new Properties();


			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\objectRepository\\projectConfig.properties");
				System.out.println(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\objectRepository\\projectConfig.properties");
				prop.load(file);
				String key="signinBtn_Xpath";
				String propvalue = prop.getProperty(key);
				System.out.println("Sign in button xpath is:"+propvalue);

			} catch (Exception e) {
				//reportFail(e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
