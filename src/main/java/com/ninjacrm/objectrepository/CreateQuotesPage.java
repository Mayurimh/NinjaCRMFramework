package com.ninjacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateQuotesPage {
	
	public CreateQuotesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//span[text()='Create Quote']")
	private WebElement createQuoteButton;
	
	public WebElement getCreateQuoteButton() {
		return createQuoteButton;
	}
}
