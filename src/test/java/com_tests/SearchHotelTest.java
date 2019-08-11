package com_tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import config.BaseClass;

import objects.SearchHotel_Page;
import utility.App_Functions;
import utility.Capture;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class SearchHotelTest extends BaseClass {
  @Test
  public void search_Hotel() throws Throwable{
	  App_Functions.selectByText("Sydney", SearchHotel_Page.getXpath_SelectLocations());
	  App_Functions.selectByText("Hotel Creek", SearchHotel_Page.getXpath_SelectHotels());
	  App_Functions.selectByText("Standard", SearchHotel_Page.getXpath_SelectRoomType());
	  App_Functions.selectByText("2 - Two", SearchHotel_Page.getXpath_SelectRooms());
	  App_Functions.clear( SearchHotel_Page.getXpath_DatePickIn());
	  App_Functions.setText("03/08/2019", SearchHotel_Page.getXpath_DatePickIn());
	  App_Functions.clear( SearchHotel_Page.getXpath_DatePickOut());
	  App_Functions.setText("04/08/2019", SearchHotel_Page.getXpath_DatePickOut());
	  App_Functions.selectByText("2 - Two", SearchHotel_Page.getXpath_SelectNoOfAdults());
	  App_Functions.selectByText("2 - Two", SearchHotel_Page.getXpath_SelectNoOfChild());
	  App_Functions.click(SearchHotel_Page.getButton_Search());
	  try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//title[contains(text(),'AdactIn.com - Select Hotel')]")));
	  }catch(Exception kl) {
			
	  }
	  String title=driver.getTitle();
	  Assert.assertEquals(title,"AdactIn.com - Select Hotel");
	  test.pass("Assertion passed");
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println(" @Before test");
	  reporter=new ExtentHtmlReporter("./Reports/SearchHotelTest.html");
	  reports= new ExtentReports();
	  reports.attachReporter(reporter);
	  test=reports.createTest("SearchHotel_Test");
	  

  }
  @BeforeMethod
  public void beforeMethod() {
	  try {
		  if(driver.findElement(By.xpath(SearchHotel_Page.getXpath_SelectHotels())).isDisplayed()) {
			  test.pass("Search Hotel Page is displayed");
		  }
	  }catch(Exception g) {
		  test.info("Search Hotel Page is not displayed");
		  System.out.println("Search Hotel Page is not displayed");
		  login(driver);
		  test.info("BaseClass Login method i called again");
			
	  }
  }
  @AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		System.out.println("After Method started");
		Capture cap=new Capture(); 
		String path;
		System.out.println(result);
		if(ITestResult.SUCCESS==result.getStatus()) {
			path=cap.captureScreenshot(driver,result.getName());
			MediaEntityModelProvider media=MediaEntityBuilder.createScreenCaptureFromPath("./Reports/com_tests.SearchHotel.jpg").build();
			test.pass("Success Screenshot", media);
			test.pass("Screenshot").addScreenCaptureFromPath(path);
				 
		 } else {
			 System.out.println("Test case failed");
			 path=cap.captureScreenshot(driver,result.getName());
			 MediaEntityModelProvider media1=MediaEntityBuilder.createScreenCaptureFromPath("./Reports/com_tests.SearchHotel.jpg").build();
			 test.fail("Failed screenshot", media1);
			 test.fail("Screenshot").addScreenCaptureFromPath(path);
				 
		 }
		
	}

  @AfterTest
  public void afterTest() throws IOException {
		System.out.println("Search Hotel test ended");
		System.out.println(" @After Test");
		reports.flush();	
	}
	
}
