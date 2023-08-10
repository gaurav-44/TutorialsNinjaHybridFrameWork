package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "input-firstname")
	WebElement firstName;
	@FindBy(id="input-lastname")
	WebElement lasttName;
	@FindBy(id="input-email")
	WebElement emailAddress;
	@FindBy(id="input-telephone")
	WebElement telePhoneNumber;
	@FindBy(id="input-password")
	WebElement password;
	@FindBy(id="input-confirm")
	WebElement confirmPassword;
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	WebElement newsletterYes;
	@FindBy(xpath="//input[@name='newsletter'][@value='0']")
	WebElement newsletterNO;
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement privacyTerms;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement submitButton;
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement userCreatedMessage;
	@FindBy(css="div[class*='alert-dismissible']")
	WebElement invaliEmailErrorMessage;
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	WebElement fNameErrorMessage;
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	WebElement lNameErrorMessage;
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	WebElement emailErrorMessage;
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	WebElement telephoneErrorMessage;
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	WebElement passwordErrorMessage;
	
	public void enterFirstName(String FName) {
		firstName.sendKeys(FName);
	}
	public void enterLastName(String LName) {
		lasttName.sendKeys(LName);
	}
	public void enterEmailAddrss(String Email) {
		emailAddress.sendKeys(Email);
	}
	public void entertelephone(String tele) {
		telePhoneNumber.sendKeys(tele);
	}
	public void enterPassword(String Pass) {
		password.sendKeys(Pass);
	}
	public void enterConfirmPassword(String Pass) {
		confirmPassword.sendKeys(Pass);
	}
	public void NewsLetterYes() {
		newsletterYes.click();
	}
	public void NewsLetterNo() {
		newsletterNO.click();
	}
	public void PrivacyTerms() {
		privacyTerms.click();
	}
	public void submitUser() {
		submitButton.click();
	}
	public String SuccessfullUserMessage() {
		String SuccessfullUserMessage= userCreatedMessage.getText();
		return SuccessfullUserMessage;
	}
	public boolean WrongEmailErrorMessage() {
		WebElement unSuccessfullUserMessage= invaliEmailErrorMessage;
		boolean result=unSuccessfullUserMessage.isDisplayed();
		return result;
	}
	public String firstNameErrorMessage() {
		String firstNameErrorMessage= fNameErrorMessage.getText();
		return firstNameErrorMessage;
	}
	public String lastNameErrorMessage() {
		String lastNameErrorMessage= lNameErrorMessage.getText();
		return lastNameErrorMessage;
	}
	public String emailErrorMessage() {
		String emaErrorMessage= emailErrorMessage.getText();
		return emaErrorMessage;
	}
	public String teleErrorMessage() {
		String teleErrorMessage= telephoneErrorMessage.getText();
		return teleErrorMessage;
	}
	public String passErrorMessage() {
		String passErrorMessage= passwordErrorMessage.getText();
		return passErrorMessage;
	}
	


}
