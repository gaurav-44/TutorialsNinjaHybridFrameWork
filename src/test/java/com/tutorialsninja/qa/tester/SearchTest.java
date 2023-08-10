package com.tutorialsninja.qa.tester;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends Base {
	public SearchTest(){
		super();
	}
	
	public WebDriver driver;

	@BeforeMethod()
	public void BeforeMethod() {
		driver = initialiseBrowserAndOpenTheApplication(prop.getProperty("browserName"));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void searchValidProduct() {
		SearchPage searchpage=new SearchPage(driver);
		searchpage.clickOnSearchWindow(prop1.getProperty("validProduct"));
		searchpage.clickOnSearchButton();
		Assert.assertEquals (searchpage.copyProductName(), prop.getProperty("product"));
		//driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(prop1.getProperty("validProduct"));
		//driver.findElement(By.xpath("//div[@id='search']/span/button")).click();
		//String productname=driver.findElement(By.linkText("HP LP3065")).getText();
		//Assert.assertEquals(productname, "HP LP3065");
	}
	
	@Test(priority=2)
	public void searchInValidProduct() {
		SearchPage searchpage=new SearchPage(driver);
		searchpage.clickOnSearchWindow(prop1.getProperty("inValidProduct"));
		searchpage.clickOnSearchButton();
		Assert.assertEquals(searchpage.inValidProductSearchMessage(), prop1.getProperty("invalidsearch"));
		//driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(prop1.getProperty("inValidProduct"));
		//driver.findElement(By.xpath("//div[@id='search']/span/button")).click();
		//String productname=driver.findElement(By.xpath("//div[@id='content']/p[2]")).getText();
		//Assert.assertEquals(productname, "There is no product that matches the search criteria.");
	}
	@Test(priority=3)
	public void searchNoProduct() {
		SearchPage searchpage=new SearchPage(driver);
		searchpage.clickOnSearchWindow("");
		searchpage.clickOnSearchButton();
		Assert.assertEquals(searchpage.inValidProductSearchMessage(), prop1.getProperty("invalidsearch"));
		
//		driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys("");
//		driver.findElement(By.xpath("//div[@id='search']/span/button")).click();
//		String productname=driver.findElement(By.xpath("//div[@id='content']/p[2]")).getText();
//		Assert.assertEquals(productname, "There is no product that matches the search criteria.");
	}

}
