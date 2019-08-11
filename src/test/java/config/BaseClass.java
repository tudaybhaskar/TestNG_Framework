package config;

//import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import objects.Login_Page;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

//import utility.*;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
//import org.testng.ITestResult;
import org.testng.Reporter;

public class BaseClass {
  protected static WebDriver driver;
  public WebDriverWait wait;
  public ExtentHtmlReporter reporter;
  public ExtentReports reports;
  public ExtentTest test;
  
  @BeforeClass
  public void beforeClass() {
	  Reporter.log("===========@before class is invoked=======");
	  setDriverProperty();
	  driver=new ChromeDriver();
	  System.out.println("Maven testing started");
	  driver.get("https://www.adactin.com/HotelApp/");
	  driver.manage().window().maximize(); 
	  wait=new WebDriverWait(driver,20);
  }
  
  @AfterClass
  public void afterclass() {
	  driver.quit();
	  System.out.println("======@After class is invoked======");
  }
  public void setDriverProperty() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
  }
  public static void login(WebDriver driver) {
	  driver.get("https://www.adactin.com/HotelApp/");
	  driver.findElement(By.xpath(Login_Page.getXpath_UserName())).sendKeys("testselenium123");
	  driver.findElement(By.xpath(Login_Page.getXpath_Password())).sendKeys("testselenium123");
	  driver.findElement(By.xpath(Login_Page.getXpath_LoginBtn())).click();
  }
  @AfterSuite
  public void afterSuite() throws AddressException, MessagingException {
	  utility.JavaEmail.sendEmail();
	  System.out.println("======Suite is closed======");
  }
 
	


 
}
