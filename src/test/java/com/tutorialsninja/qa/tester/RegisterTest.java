package com.tutorialsninja.qa.tester;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utilities.Utilities;

public class RegisterTest extends Base{
	public RegisterTest(){
		super();
		// TODO Auto-generated constructor stub
	}
	public WebDriver driver;

	@BeforeMethod()
	public void BeforeMethod() {
		driver = initialiseBrowserAndOpenTheApplication(prop.getProperty("browserName"));
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
	    homepage.clickOnRegister();;
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Register")).click();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyRegisteringWithValidCredentials() { 
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.enterFirstName(prop1.getProperty("firstName"));
		registerpage.enterLastName(prop1.getProperty("lastName"));
		registerpage.enterEmailAddrss(Utilities. generateEmailWithTimeStamp());
		registerpage.entertelephone(prop1.getProperty("telePhone"));
		registerpage.enterPassword(prop.getProperty("validPass"));
		registerpage.enterConfirmPassword(prop.getProperty("validPass"));
		registerpage.NewsLetterNo();
		registerpage.PrivacyTerms();
		registerpage.submitUser();
		Assert.assertEquals (registerpage.SuccessfullUserMessage(), prop1.getProperty("userCreatedMessage"));
//	    driver.findElement(By.id("input-firstname")).sendKeys(prop1.getProperty("firstName")); 
//	    driver.findElement(By.id("input-lastname")).sendKeys(prop1.getProperty("lastName"));
//		driver.findElement(By.id("input-email")).sendKeys(Utilities. generateEmailWithTimeStamp());
//		driver.findElement(By.id("input-telephone")).sendKeys(prop1.getProperty("telePhone"));
//		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPass")); 
//		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPass"));
//		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click(); 
//		driver.findElement(By.name("agree")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//		String actualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
//		Assert.assertEquals (actualSuccessHeading, "Your Account Has Been Created!");
		}
	@Test(priority=2)
	public void verifyRegisteringWithNoNewsletter() { 
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.enterFirstName(prop1.getProperty("firstName"));
		registerpage.enterLastName(prop1.getProperty("lastName"));
		registerpage.enterEmailAddrss(Utilities. generateEmailWithTimeStamp());
		registerpage.entertelephone(prop1.getProperty("telePhone"));
		registerpage.enterPassword(prop.getProperty("validPass"));
		registerpage.enterConfirmPassword(prop.getProperty("validPass"));
		registerpage.NewsLetterNo();
		registerpage.PrivacyTerms();
		registerpage.submitUser();
		Assert.assertEquals (registerpage.SuccessfullUserMessage(), prop1.getProperty("userCreatedMessage"));
//	    driver.findElement(By.id("input-firstname")).sendKeys(prop1.getProperty("firstName")); 
//	    driver.findElement(By.id("input-lastname")).sendKeys(prop1.getProperty("lastName"));
//		driver.findElement(By.id("input-email")).sendKeys(Utilities. generateEmailWithTimeStamp());
//		driver.findElement(By.id("input-telephone")).sendKeys(prop1.getProperty("telePhone"));
//		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPass")); 
//		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPass"));
//		driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).click(); 
//		driver.findElement(By.name("agree")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//		String actualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
//		Assert.assertEquals (actualSuccessHeading, "Your Account Has Been Created!");
		}
	@Test(priority=3)
	public void verifyRegisteringWithInvaliEmail() { 
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.enterFirstName(prop1.getProperty("firstName"));
		registerpage.enterLastName(prop1.getProperty("lastName"));
		registerpage.enterEmailAddrss(prop.getProperty("validEmail"));
		registerpage.entertelephone(prop1.getProperty("telePhone"));
		registerpage.enterPassword(prop.getProperty("validPass"));
		registerpage.enterConfirmPassword(prop.getProperty("validPass"));
		registerpage.NewsLetterNo();
		registerpage.PrivacyTerms();
		registerpage.submitUser();
		registerpage.WrongEmailErrorMessage();
//	    driver.findElement(By.id("input-firstname")).sendKeys(prop1.getProperty("firstName")); 
//	    driver.findElement(By.id("input-lastname")).sendKeys(prop1.getProperty("lastName"));
//		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
//		driver.findElement(By.id("input-telephone")).sendKeys(prop1.getProperty("telePhone"));
//		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPass")); 
//		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPass"));
//		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click(); 
//		driver.findElement(By.name("agree")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//		WebElement error = driver.findElement(By.cssSelector("div[class*='alert-dismissible']"));
//		Assert.assertTrue(error.isDisplayed());
		}
	@Test(priority=4)
	public void verifyRegisteringWithNoValidCredentials(){
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.submitUser();
		Assert.assertEquals(registerpage.firstNameErrorMessage(), prop1.getProperty("fNameMissingError"));
		Assert.assertEquals(registerpage.lastNameErrorMessage(), prop1.getProperty("lNameMissingError"));
		Assert.assertEquals(registerpage.emailErrorMessage(), prop1.getProperty("emailmissingError"));
		Assert.assertEquals(registerpage.teleErrorMessage(), prop1.getProperty("telePhoneMissingError"));
		Assert.assertEquals(registerpage.passErrorMessage(), prop1.getProperty("passMissingError"));
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//		String FName=driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
//		Assert.assertEquals(FName, prop1.getProperty("fNameMissingError"));
//		String LName=driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
//		Assert.assertEquals(LName, prop1.getProperty("lNameMissingError"));
//		String Email=driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
//		Assert.assertEquals(Email, prop1.getProperty("emailMissingError"));
//		String TPhone=driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
//		Assert.assertEquals(TPhone, prop1.getProperty("telePhoneMissingError"));
//		String Passw=driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
//		Assert.assertEquals(Passw, prop1.getProperty("passMissingError"));
		
		
	}
}