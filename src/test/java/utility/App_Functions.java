package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import config.BaseClass;

public class App_Functions extends BaseClass {
	
	public static void selectByText(String value_text,String ele_xpath) {
		WebElement element= driver.findElement(By.xpath(ele_xpath));
		Select select=new Select(element);
		select.selectByVisibleText(value_text);
	}
	public static void setText(String value_text,String ele_xpath) {
		WebElement element= driver.findElement(By.xpath(ele_xpath));
		element.sendKeys(value_text);
	}
	public static void click(String ele_xpath) {
		WebElement element= driver.findElement(By.xpath(ele_xpath));
		element.click();
	}
	public static void clear(String ele_xpath) {
		WebElement element= driver.findElement(By.xpath(ele_xpath));
		element.clear();
	}
  
}
