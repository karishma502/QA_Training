package com.ddf.test.LoginTest;

import org.testng.annotations.Test;

import com.ddf.base.BaseUI_v2;

public class loginTest_v2 extends BaseUI_v2 {

	@Test
	public void testOne() throws InterruptedException {
		invokeBrowser("chrome");
		openURL("websiteURL");
		elementClick("CreateBtn_Xpath");
		//enterText("usernameTextbox_Xpath","U S E R N A M E");
		
		elementClick("fullname");
		enterText("fullname","Karishma");
		
		elementClick("email");
		enterText("email","karishmakate@gmail.com");
		
		elementClick("pass");
		enterText("pass","karishmakate123");
		
		elementClick("retype_pass");
		enterText("retype_pass","karishmakate123");
		
		elementClick("alt_email");
		enterText("alt_email","karishmakate198@gmail.com");
		
		elementClick("checkbox");
		
		elementClick("mobile_no");
		enterText("mobile_no","123456");
		
		elementClick("gender");
		

		elementClick("country");
		enterText("country","India");
		

		elementClick("city");
		enterText("city","Sangli");
		
		elementClick("submit");
		
		
		//elementClick("signinBtn_Xpath");
		//enterText("usernameTextbox_Xpath","U S E R N A M E");
		
		//elementClick("signinBtn_Xpath");
		//enterText("usernameTextbox_Xpath","U S E R N A M E");
		Thread.sleep(2000);
		tearDown();
	}
	
	//@Test(dependsOnMethods="testOne")
	public void testTwo() {
		invokeBrowser("chrome");
		openURL("https://money.rediff.com/index.html");
		//test code to show next function usage - above code not changed to use properties file 
		tearDown();
	}
	
	//@Test(dependsOnMethods="testTwo")
	
	public void testThree() {
		invokeBrowser("chrome");
		openURL("https://shopping.rediff.com/");
		//test code to show next function usage - above code not changed to use properties file
		tearDown();
	}
}
