package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utilities.ExtentReport;
import com.tutorialsninja.qa.utilities.Utilities;

public class MyListeners implements ITestListener {
	ExtentReports extentReport;
	ExtentTest extentTest ;
	//String testname;
	@Override
	public void onStart(ITestContext context) {
		//System.out.println("Excetion of project is started");
		extentReport = ExtentReport.genarateExtentReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testname=result.getName();
		extentTest = extentReport.createTest(testname);
		extentTest.log(Status.INFO, testname+"is started excecuting");
		//System.out.println(testname+" is started excecuting");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testname=result.getName();
		extentTest.log(Status.PASS, testname+" is rus successfully");
		//System.out.println(testname+" is rus successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname=result.getName();
		
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String screenShotFile=Utilities.capturScreenShot(driver, testname);
		extentTest.addScreenCaptureFromPath(screenShotFile); 
		extentTest.log(Status.INFO,result.getThrowable()); 
		extentTest.log(Status.FAIL, testname+" got failed");
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testname=result.getName();
		extentTest.log(Status.INFO,result.getThrowable()); 
		extentTest.log(Status.SKIP, testname+" is skipped");
		
//		System.out.println(testname+" is skipped");
//		System.out.println(result.getThrowable());
	}

	

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentReport.flush();
		String extentreport=System.getProperty("user.dir")+"\\test-output\\Extentreportfolder\\ExtentReport.html";
		File reportfile=new File(extentreport);
		try {
			Desktop.getDesktop().browse(reportfile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Excetion of project is Over");
	}

}
