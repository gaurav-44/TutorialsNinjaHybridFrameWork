package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;

	public SearchPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="input[placeholder='Search']")
	WebElement searchWindow;
	@FindBy(xpath="//div[@id='search']/span/button")
	WebElement searchButton;
	@FindBy(linkText="HP LP3065")
	WebElement productName;
	@FindBy(xpath="//div[@id='content']/p[2]")
	WebElement invalidProductSearchMessage;
	
	
	
	public void clickOnSearchWindow(String product) {
		searchWindow.sendKeys(product);;
	}
	public void clickOnSearchButton() {
		searchButton.click();
	}
	public String copyProductName() {
		String product=productName.getText();
		return product;
	}
	public String inValidProductSearchMessage() {
		String message=invalidProductSearchMessage.getText();
		return message;
	}

}
