package com.ninjacrm.objectrepository;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	
	public CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[text()='Create Campaign']")
	private WebElement createCampaignButton;
	
	public WebElement getCreateCampaign() {
		return createCampaignButton;
	}
}
