package com.ninjacrm.objectrepository;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage {
	public AddProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productName")
	private WebElement productNameTextField;
	
	@FindBy(name="productCategory")
	private WebElement productCategoryDropdown;
	
	@FindBy(name="quantity")
	private WebElement qualtityTextField;
	
	@FindBy(name ="price")
	private WebElement priceTextField;
	
	@FindBy(name ="vendorId")
	private WebElement vendorDropDown;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement addProductButton;

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getProductCategoryDropdown() {
		return productCategoryDropdown;
	}

	public WebElement getQualtityTextField() {
		return qualtityTextField;
	}

	public WebElement getPriceTextField() {
		return priceTextField;
	}

	public WebElement getVendorDropDown() {
		return vendorDropDown;
	}

	public WebElement getAddProductButton() {
		return addProductButton;
	}

	
	
}
