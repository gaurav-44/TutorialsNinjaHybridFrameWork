package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	WebDriver driver;
	
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccount;
	@FindBy(linkText="Login")
	private WebElement loginButton;
	@FindBy(linkText="Register")
	private WebElement register;
	
	public HomePage(WebDriver driver) {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMyAccount() {
		myAccount.click();
	}
	public void clickOnLogin() {
		loginButton.click();
	}
	public void clickOnRegister() {
		register.click();
	}
	

}
