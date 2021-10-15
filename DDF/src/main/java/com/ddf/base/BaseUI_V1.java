package com.ddf.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//v1 - browser invoke and other basic functions
public class BaseUI_V1{

	public WebDriver driver;

	//Exercise 
	// Complete the function to invoke - firefox & edge browsers
	public void invokeBrowser(String browserName) throws InterruptedException {
		//if(browserName.equals(anObject))
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//src//test//resources//drivers//chromedriver.exe");
			
			driver=new ChromeDriver();
		
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "//src//test//resources//drivers//geckodriver.exe");
			
			driver=new FirefoxDriver();
			
		}
	}

	public void openURL(String websiteURL) {
		//we are using this function so that we can easily extend the functionality
		driver.get(websiteURL);
	}

	public void tearDown() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void elementClick(String xpath) {
		//try catch block
		//logging - click is successful 
		driver.findElement(By.xpath(xpath)).click();
	}

	public void enterText(String xpath, String data) {
		//used to enter text - give more specifics 
		driver.findElement(By.xpath(xpath)).sendKeys(data);
	}
}
