package com.ninjacrm.producttest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ninjacrmframe.baseclass.BaseClass;

import com.ninjacrm.generic.fileutilities.ExcelUtilities;
import com.ninjacrm.generic.javautilities.JavaUtilities;
import com.ninjacrm.generic.webdriverutilities.WebDriverUtilities;
import com.ninjacrm.objectrepository.AddProductPage;
import com.ninjacrm.objectrepository.HomePage;
import com.ninjacrm.objectrepository.ProductsPage;
public class CreateProductAllFieldTest extends BaseClass{
	@Test(groups = "regression")
	public void createProductAllFieldTest() throws IOException{
		WebDriverUtilities wd = new WebDriverUtilities();
		JavaUtilities jv = new JavaUtilities();
		String ranData = jv.randomData();
		
		ExcelUtilities excel = new ExcelUtilities();
		String productname = excel.readDataFromExcel("Product", 1, 0)+ranData;
		String quantity = excel.readDataFromExcel("Product",1,1);
		String ppu = excel.readDataFromExcel("Product", 1, 2);
		
		HomePage hp = new HomePage(driver);
		ProductsPage pp = new ProductsPage(driver);
		AddProductPage app = new AddProductPage(driver);
		
		//product page
		hp.getProductsLink().click();
		pp.getAddProductButton().click();
		
		//addproduct
		WebDriverUtilities wb1 = new WebDriverUtilities();
		app.getProductNameTextField().sendKeys(productname);
		WebElement procat=  app.getProductCategoryDropdown();
		wd.selectByIndex(procat, 2);
		
		WebElement quan =  app.getQualtityTextField();
		quan.clear();
		quan.clear();
		quan.sendKeys(quantity);
		
		WebElement price  = app.getPriceTextField();
		price.clear();
		price.sendKeys(ppu);
		
		wb1.elementToBeClickableWait(driver, app.getVendorDropDown());
		WebElement venId = app.getVendorDropDown();
		wd.selectByIndex(venId, 3);
		wb1.elementToBeClickableWait(driver, venId);
		app.getAddProductButton().click();
		
		
		wb1.elementToBeClickableWait(driver, hp.getAlertMeassage());
		 
		String msg = hp.getAlertMeassage().getText();
		Assert.assertTrue(msg.contains("Successfully Added"));

//		if (msg.contains("Successfully Added")) {
//			Reporter.log("product Sucessfully added!",true);
//		} else {
//			Reporter.log("no added!",false);
//		}

		
}
}
