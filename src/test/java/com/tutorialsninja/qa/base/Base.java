package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utilities.Utilities;

public class Base {
	WebDriver driver;
	public Properties prop;
	public Properties prop1;
	public Base(){
		prop = new Properties ();
		File propFile =new File (System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		
		try {
			 FileInputStream fis = new FileInputStream(propFile);
			 prop.load(fis);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//System.out.println(prop.getProperty("browserName")+"browsernameis the");
			}
		prop1 = new Properties ();
		File propFile1 =new File (System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\testData.properties");
		try {
		FileInputStream fis1 = new FileInputStream(propFile1);
		prop1.load(fis1);
		}catch (Throwable e) {
			e.printStackTrace();
		}
		
		//prop.load(fis);
	}
	public WebDriver initialiseBrowserAndOpenTheApplication(String browserName) {
		
		if (browserName.equalsIgnoreCase("chrome")) {
			//driver= new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver=new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}
		else if(browserName.equals("edge")) {
			driver= new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.wait_time));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.load_time));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}

}
