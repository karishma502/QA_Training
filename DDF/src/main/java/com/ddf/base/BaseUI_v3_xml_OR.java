package com.ddf.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ddf.utils.ExtentReportManager;
import com.ddf.utils.DateUtils;

//Demo to be given for xml object repository 
//Exercise - implement xml for object repository 

//Extent reports - added extent reports 
//logging from the test case itself

public class BaseUI_v3_xml_OR {

	public WebDriver driver;
	public Properties prop;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	public File xmlinputFile;
	public SAXReader saxReader;
	public Document xmlDocument;
	
	//xml implemented for only one element - sign in button click 
	//in invokebrowser - xml file is loaded
	//used inthe element click function 
	//Same will apply in case of complete implementation - TBD as exercise
	
	
	public void invokeBrowser(String browserName) throws DocumentException {
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//src//test//resources//drivers//chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		if(xmlinputFile == null)
		{
	    try {
			xmlinputFile = new File(System.getProperty("user.dir")
					+ "//src//test//resources//objectRepository/temp_xmlor.xml");
	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	    }
	    saxReader = new SAXReader();					
	    xmlDocument = saxReader.read(xmlinputFile);	
		}
		
		if (prop == null) {
			prop = new Properties();


			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")
						+ "//src//test//resources//objectRepository/projectConfig.properties");
				prop.load(file);
			} catch (Exception e) {
				//reportFail(e.getMessage());
				e.printStackTrace();
			}

		}

		
	}

	//public void 
	
	public void openURL(String websiteURLkey) {
		driver.get(prop.getProperty(websiteURLkey));
	}

	public void tearDown() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

	/****************** Identify Element ***********************/
	public WebElement getElement(String locatorKey) {
		WebElement element = null;
// zohoLoginTextBox_ClassName
		
		try {
			if (locatorKey.endsWith("_Id")) {
				//element = driver.findElement(By.id(prop.getProperty(locatorKey)));
				String temp = xmlDocument.selectSingleNode("//rediff/"+locatorKey).getText();	
				System.out.println("Locator key using xml is:"+temp);
				element=driver.findElement(By.id(temp));
				logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_Xpath")) {
				//element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
				String temp = xmlDocument.selectSingleNode("//rediff/"+locatorKey).getText();	
				System.out.println("Locator key using xml is:"+temp);
				element=driver.findElement(By.xpath(temp));
				logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_ClassName")) {
				element = driver.findElement(By.className(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_CSS")) {
				element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_LinkText")) {
				element = driver.findElement(By.linkText(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_PartialLinkText")) {
				element = driver.findElement(By.partialLinkText(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_Name")) {
				element = driver.findElement(By.name(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else {
				reportFail("Failing the Testcase, Invalid Locator " + locatorKey);
			}
		} catch (Exception e) {

			// Fail the TestCase and Report the error
			reportFail(e.getMessage());
			e.printStackTrace();
		}

		return element;
	}
	
	
	
	public void elementClick(String xpathkey) {
		//driver.findElement(By.xpath(prop.getProperty(xpathkey))).click();
		//xml file loading implemented only for this function for demo purposes
		String xpath_xml = xmlDocument.selectSingleNode("//rediff/"+xpathkey).getText();	
		System.out.println("Locator key is:"+xpath_xml);
		driver.findElement(By.xpath(xpath_xml)).click();
	}

	public void enterText(String xpathkey, String data) {
		driver.findElement(By.xpath(prop.getProperty(xpathkey))).sendKeys(data);
	}
	
	//Reporting functions 
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShotOnFailure();
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}
	
	public void takeScreenShotOnFailure() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + "//ScreenShots//" + DateUtils.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "//ScreenShots//" + DateUtils.getTimeStamp() + ".png");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
