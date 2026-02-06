package com.ninjacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Campaigns")
	private WebElement campaignLink;

	@FindBy(linkText = "Products")
	private WebElement productsLink;

	@FindBy(xpath = "//div[@class='user-icon']")
	private WebElement profileIcon;

	@FindBy(xpath = "//div[@class='dropdown-item logout']")
	private WebElement logoutIcon;

	@FindBy(linkText = "Quotes")
	private WebElement quotesButton;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement alertMeassage;

	@FindBy(xpath = "//button[@aria-label='close']")
	private WebElement closeMessageClick;

	
	// for quotes class
	@FindBy(id="search-input")
	private WebElement searchField;
	
	public WebElement getSearchField() {
		return searchField;
	}

	@FindBy(xpath = "(//tbody/child::tr/descendant::button)[1]")
	private WebElement selectProductButton;

	public WebElement getSelectProductButton() {
		return selectProductButton;
	}

	public WebElement getAlertMeassage() {
		return alertMeassage;
	}

	public WebElement getCloseMessageClick() {
		return closeMessageClick;
	}

	public WebElement getQuotesButton() {
		return quotesButton;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getLogoutIcon() {
		return logoutIcon;
	}

}
