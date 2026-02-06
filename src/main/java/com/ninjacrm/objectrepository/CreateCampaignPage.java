package com.ninjacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="campaignName")
	private WebElement campaignNameTextField;
	
	@FindBy(name="targetSize")
	private WebElement tagetSizeTextField;
	
	@FindBy(xpath="//input[@type='date']")
	private WebElement dateTextField;

	public WebElement getDateTextField() {
		return dateTextField;
	}

	@FindBy(xpath = "//button[text()='Create Campaign']")
	private WebElement createCampaignButton;
	
	@FindBy(name="campaignStatus")
	private WebElement campaignStatusTextField;

	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getTagetSizeTextField() {
		return tagetSizeTextField;
	}

	public WebElement getCreateCampaignButton() {
		return createCampaignButton;
	}

	public WebElement getCampaignStatusTextField() {
		return campaignStatusTextField;
	}
	
	
}
