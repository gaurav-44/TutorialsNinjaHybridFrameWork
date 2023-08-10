package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="input-email")
	WebElement emailAddress;
	@FindBy(id="input-password")
	WebElement passWord;
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	@FindBy(linkText="Edit your account information")
	WebElement accountInformation;
	@FindBy(css="div[class*='alert-dismissible']")
	WebElement invalidCredMessage;
	
	public void enterEmailID(String emailText) {
		emailAddress.sendKeys(emailText);
	}
	public void enterPassword(String passText) {
		passWord.sendKeys(passText);
	}
	public void clickOnLogin() {
		loginButton.click();
	}
	public boolean accountInformationMessage() {
		boolean message=accountInformation.isDisplayed();
		return message;
		
	}
	public boolean inValidCredMessageDisplay() {
		boolean message1=invalidCredMessage.isDisplayed();
		return message1;
	}
	

}
