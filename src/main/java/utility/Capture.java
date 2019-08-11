package utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Capture {
	WebDriver driver;
	public String captureScreenshot(WebDriver driver,String ts_name) {
		this.driver=driver;
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		System.out.println(ts_name);
		String path=System.getProperty("user.dir")+"/Reports/"+ts_name+".png";
		File dest=new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return path;
		
		
	}

}
