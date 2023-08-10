package com.tutorialsninja.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	static ExtentReports extentReport;
	public static ExtentReports genarateExtentReport() {
		
		extentReport =new ExtentReports();
		File extentReportFile=new File(System.getProperty("user.dir")+"\\test-output\\Extentreportfolder\\ExtentReport.html");
		ExtentSparkReporter sparkreporter=new ExtentSparkReporter(extentReportFile);
		
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setReportName("The tutorials Ninja Website");
		sparkreporter.config().setDocumentTitle("TN Automation Report");
		sparkreporter.config().setTimeStampFormat("dd/MM/yyyy  hh:mm:ss");
		
		extentReport.attachReporter(sparkreporter);
		
		Properties configProp=new Properties();
		File configPropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		try {
		FileInputStream fis=new FileInputStream(configPropFile);
		configProp.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", configProp.getProperty("browser"));
		extentReport.setSystemInfo("Valid EmailID", configProp.getProperty("validEmail"));
		extentReport.setSystemInfo("Valid Password", configProp.getProperty("validPass"));
		extentReport.setSystemInfo("Valid EmailID", configProp.getProperty("validEmail"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("User", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extentReport;
		
		
		
	}

}
