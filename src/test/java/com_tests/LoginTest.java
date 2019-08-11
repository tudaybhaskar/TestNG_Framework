package com_tests;
//import java.lang.reflect.Method;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
//import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import config.BaseClass;
import objects.Login_Page;
//import objects.SearchHotel_Page;

import org.testng.annotations.BeforeTest;

import java.awt.print.Printable;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
//import org.testng.Reporter;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebElement;

import utility.Capture;
public class LoginTest extends BaseClass {


	@BeforeTest
	public void beforTesting() {
		
		System.out.println(" @Before test");
		reporter=new ExtentHtmlReporter("./Reports/LoginTest.html");
		reports= new ExtentReports();
		reports.attachReporter(reporter);
		test=reports.createTest("LoginTest");
		

	}
	
	
	@Test
	public void testLogin() throws Exception{
		driver.findElement(By.xpath(Login_Page.getXpath_UserName())).sendKeys("testselenium123");
		driver.findElement(By.xpath(Login_Page.getXpath_Password())).sendKeys("testselenium123");
		driver.findElement(By.xpath(Login_Page.getXpath_LoginBtn())).click();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//title[contains(text(),'AdactIn.com - Search Hotel')]")));
		}catch(Exception kl) {
			
		}
		String title=driver.getTitle();
		Assert.assertEquals(title,"AdactIn.com - Search Hotel");
		test.pass("Assertion passed");
	 }
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		System.out.println("After Method started");
		Capture cap=new Capture(); 
		String path;
		System.out.println(result);
		if(ITestResult.SUCCESS==result.getStatus()) {
			path=cap.captureScreenshot(driver,result.getName());
			MediaEntityModelProvider media=MediaEntityBuilder.createScreenCaptureFromPath("./Reports/LoginTest.jpg").build();
			test.pass("Success Screenshot", media);
			test.pass("Screenshot").addScreenCaptureFromPath(path);
				 
		 } else {
			 System.out.println("Test case failed");
			 path=cap.captureScreenshot(driver,result.getName());
			 MediaEntityModelProvider media1=MediaEntityBuilder.createScreenCaptureFromPath("./Reports/LoginTest.jpg").build();
			 test.fail("Failed screenshot", media1);
			 test.fail("Screenshot").addScreenCaptureFromPath(path);
				 
		 }
		
	}
	 @AfterTest
	 public void afterTest() throws IOException {
		
		System.out.println("Maven test ended");
		System.out.println(" @After Test");
		reports.flush();	
	}
	 
	  

}
