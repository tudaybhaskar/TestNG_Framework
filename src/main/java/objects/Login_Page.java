package objects;

public class Login_Page {
	
	private static String xpath_UserName="//input[@id='username']";
	private static String xpath_Password="//input[@id='password']";
	private static String xpath_LoginBtn="//input[@name='login']";
	
	public static String getXpath_UserName() {
		return xpath_UserName;
	}
	
	public static String getXpath_Password() {
		return xpath_Password;
	}
	public static String getXpath_LoginBtn() {
		return xpath_LoginBtn;
	}
}
