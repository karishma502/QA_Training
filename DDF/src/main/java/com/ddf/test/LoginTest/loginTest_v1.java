package com.ddf.test.LoginTest;

import org.testng.annotations.Test;

import com.ddf.base.BaseUI_V1;


public class loginTest_v1 extends BaseUI_V1 {

	@Test
	public void testOne() throws InterruptedException {
		
		invokeBrowser("chrome");
		//invokeBrowser("firefox");
		openURL("https://www.rediff.com/");
		elementClick("//a[contains(text(),'Sign in')]");
		enterText("//input[@id='login1']","U S E R N A M E");
		System.out.println("test 1 run");
		Thread.sleep(2000);
		tearDown();
	}
	
	//Call a different browser - firefox
	@Test(dependsOnMethods="testOne")
	public void testTwo() throws InterruptedException {
		invokeBrowser("chrome");
		//invokeBrowser("firefox");
		openURL("https://money.rediff.com/index.html");
		System.out.println("test 2 run");
		
		tearDown();
	}
	
	//Exercise - Call a different browser - Edge
	@Test(dependsOnMethods="testTwo")
	public void testThree() throws InterruptedException {
		invokeBrowser("chrome");
		//invokeBrowser("firefox");
		openURL("https://shopping.rediff.com/");
		System.out.println("test 3 run");
		tearDown();
	}
}
