package com.ninjacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuotesPage {
	public QuotesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="subject")
	private WebElement subjectTextField;
	
	@FindBy(name="validTill")
	private WebElement validTillTextField;
	
	@FindBy(name = "quoteStage")
	private WebElement quoteStageTextField;
	
	@FindBy(xpath="//label[text()='Opportunity']/following-sibling::div/child::button")
	private WebElement opportunityDropdown;
	
	@FindBy(xpath="//label[text()='Contact']/following-sibling::div/child::button")
	private WebElement contactDropDown;
	
	@FindBy(xpath="//label[text()='Billing Address']/following-sibling::textarea")
	private WebElement billAddTextField;
	
	@FindBy(xpath="//label[text()='Billing PO Box']/following-sibling::input")
	private WebElement billPoBoxTextField;
	
	@FindBy(xpath="//label[text()='Billing City']/following-sibling::input")
	private WebElement bittCityTextField;
	
	@FindBy(xpath = "//label[text()='Billing State']/following-sibling::input")
	private WebElement bittStateTextField;
	
	@FindBy(xpath="//label[text()='Billing Postal Code']/following-sibling::input")
	private WebElement billPostalCodeTextField;
	
	@FindBy(xpath = "//label[text()='Billing Country']/following-sibling::input")
	private WebElement billCountryTextField;

	@FindBy(xpath="//label[text()='Shipping Address']/following-sibling::textarea")
	private WebElement shipAddressTextField;
	
	@FindBy(xpath="//label[text()='Shipping PO Box']/following-sibling::input")
	private WebElement shipPoBoxTextField;
	
	@FindBy(xpath="//label[text()='Shipping City']/following-sibling::input")
	private WebElement shipCityTextField;
	
	
	@FindBy(xpath="//label[text()='Shipping State']/following-sibling::input")
	private WebElement shipState;
	
	@FindBy(xpath="//label[text()='Shipping Postal Code']/following-sibling::input")
	private WebElement shipPostalCode;
	
	@FindBy(xpath="//label[text()='Shipping Country']/following-sibling::input")
	private WebElement shipCountryTextField;
	
	@FindBy(xpath="//label[text()='Products']/following-sibling::div/button")
	private WebElement ProductButton;
	
	@FindBy(xpath ="//button[text()='Create Quote']")
	private WebElement createQuoteButton;
	
	public WebElement getContactDropDown() {
		return contactDropDown;
	}
	
	public WebElement getSubjectTextField() {
		return subjectTextField;
	}

	public WebElement getValidTillTextField() {
		return validTillTextField;
	}

	public WebElement getQuoteStageTextField() {
		return quoteStageTextField;
	}

	public WebElement getOpportunityDropdown() {
		return opportunityDropdown;
	}

	public WebElement getBillAddTextField() {
		return billAddTextField;
	}

	public WebElement getBillPoBoxTextField() {
		return billPoBoxTextField;
	}

	public WebElement getBittCityTextField() {
		return bittCityTextField;
	}

	public WebElement getBittStateTextField() {
		return bittStateTextField;
	}

	public WebElement getBillPostalCodeTextField() {
		return billPostalCodeTextField;
	}

	public WebElement getBillCountryTextField() {
		return billCountryTextField;
	}

	public WebElement getShipAddressTextField() {
		return shipAddressTextField;
	}

	public WebElement getShipPoBoxTextField() {
		return shipPoBoxTextField;
	}

	public WebElement getShipCityTextField() {
		return shipCityTextField;
	}

	public WebElement getShipState() {
		return shipState;
	}

	public WebElement getShipPostalCode() {
		return shipPostalCode;
	}

	public WebElement getShipCountryTextField() {
		return shipCountryTextField;
	}

	public WebElement getProductButton() {
		return ProductButton;
	}

	public WebElement getCreateQuoteButton() {
		return createQuoteButton;
	}

	
	
}
