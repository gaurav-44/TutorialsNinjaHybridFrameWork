package com.tutorialsninja.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	public static  final int wait_time=10;
	public static final int load_time=5;
	
	public static String generateEmailWithTimeStamp() {
		Date date = new Date();
		String timestamp = date.toString().replace(" ", "_").replace(":", "_");
		return "amotoori" + timestamp + "@gmail.com";
	}
	public static String capturScreenShot(WebDriver driver, String testname) {
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenShotFile=System.getProperty("user.dir")+"//ScreenshotFolder//"+testname+".png";
		try {
			FileHandler.copy(screenShot, new File(screenShotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		return screenShotFile;
	}

}
