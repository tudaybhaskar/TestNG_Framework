package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
// org.openqa.selenium.WebElement;

public class SearchHotel_Page {
	//WebDriver driver;
	ExtentTest test;
	
	private static String dropdown_SelectLocations="//select[@id='location']";
	private static String dropdown_SelectHotels="//select[@id='hotels']";
	private static String dropdown_SelectRoomType="//select[@id='room_type']";
	private static String dropdown_SelectRooms="//select[@id='room_nos']";
	private static String input_DatePickIn="//input[@id='datepick_in']";
	private static String input_DatePickOut="//input[@id='datepick_out']";
	private static String dropdown_SelectAdultRoom="//select[@id='adult_room']";
	private static String dropdown_SelectChildRoom="//select[@id='child_room']";
	private static String button_Search="//input[@id='Submit' and @value='Search']";
	//td[@class='login_title' and text()='Search Hotel ']
	public static String getSearchHotel_title() {
		return "AdactIn.com - Search Hotel";
	}
	//select[@id='location']-Hotel Creek
	//select[@id='hotels']-Sydney
	//select[@id='room_type']-Standard
	//select[@id='room_nos']
	//input[@id='datepick_in']
	//input[@id='datepick_out']
	//select[@id='adult_room']
	//select[@id='child_room']
	
	//input[@type='submit' and @value='Search']
	//td[text()='Select Hotel ' and @class='login_title']
	
	

	public static String getXpath_SelectLocations() {
		return dropdown_SelectLocations;
	}

	public static String getXpath_SelectHotels() {
		return dropdown_SelectHotels;
	}

	public static String getXpath_SelectRoomType() {
		return dropdown_SelectRoomType;
	}

	public static String getXpath_SelectRooms() {
		return dropdown_SelectRooms;
	}

	public static String getXpath_DatePickIn() {
		return input_DatePickIn;
	}

	public static String getXpath_DatePickOut() {
		return input_DatePickOut;
	}

	public static String getXpath_SelectNoOfAdults() {
		return dropdown_SelectAdultRoom;
	}

	public static String getXpath_SelectNoOfChild() {
		return dropdown_SelectChildRoom;
	}
	
	public static void selectByText(WebElement element,String value_text) {
		Select select=new Select(element);
		select.selectByVisibleText(value_text);
	}

	public static String getButton_Search() {
		return button_Search;
	}
	

}
