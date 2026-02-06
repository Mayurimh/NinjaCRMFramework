package com.ninjacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectContactPage {
	
	public SelectContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "(//tbody/child::tr/descendant::button)[1]")
	private WebElement selectContactButton;

	public WebElement getselectContactButton() {
		return selectContactButton;
	}
}
