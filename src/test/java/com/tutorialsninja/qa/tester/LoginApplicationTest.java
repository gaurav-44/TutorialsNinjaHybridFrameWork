package com.tutorialsninja.qa.tester;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utilities.Utilities;

public class LoginApplicationTest extends Base {
	public LoginApplicationTest(){
		super();
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver;
	//LoginPage loginpage=new LoginPage(driver);

	@BeforeMethod()
	public void BeforeMethod() {
		
		driver = initialiseBrowserAndOpenTheApplication(prop.getProperty("browserName"));
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
	    homepage.clickOnLogin();
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Login")).click();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@Test(priority=1)
	public void verifyloginWithValidCredentials() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterEmailID(prop.getProperty("validEmail"));
		//loginpage.enterPassword(prop.getProperty("validPass"));
		loginpage.enterPassword("test22222");
		loginpage.clickOnLogin();
		Assert.assertTrue(loginpage.accountInformationMessage());
		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPass"));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

	}

	@Test(priority=2)
	public void verifyloginWithInValidCredentials() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterEmailID(Utilities.generateEmailWithTimeStamp());
		loginpage.enterPassword("test22222");
		//loginpage.enterPassword(prop1.getProperty("invalidPass"));
		loginpage.clickOnLogin();
		loginpage.inValidCredMessageDisplay();
		//driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.id("input-password")).sendKeys(prop1.getProperty("invalidPass"));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		//WebElement error = driver.findElement(By.cssSelector("div[class*='alert-dismissible']"));
		//Assert.assertTrue(error.isDisplayed());

	}

	@Test(priority=3)
	public void verifyloginWithInValidEmailID() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterEmailID(Utilities.generateEmailWithTimeStamp());
		loginpage.enterPassword(prop.getProperty("validPass"));
		loginpage.clickOnLogin();
		loginpage.inValidCredMessageDisplay();
		//driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPass"));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		//WebElement error = driver.findElement(By.cssSelector("div[class*='alert-dismissible']"));
		//Assert.assertTrue(error.isDisplayed());

	}

	@Test(priority=4)
	public void verifyloginWithInValidPassword() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterEmailID(prop.getProperty("validEmail"));
		loginpage.enterPassword(prop1.getProperty("invalidPass"));
		loginpage.clickOnLogin();
		loginpage.inValidCredMessageDisplay();
		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.id("input-password")).sendKeys("generateEmailWithTimeStamp()");
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		//WebElement error = driver.findElement(By.cssSelector("div[class*='alert-dismissible']"));

	}

	

}
