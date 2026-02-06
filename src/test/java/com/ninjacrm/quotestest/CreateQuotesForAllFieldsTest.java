package com.ninjacrm.quotestest;

import java.io.IOException;


import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninjacrm.generic.fileutilities.ExcelUtilities;
import com.ninjacrm.generic.javautilities.JavaUtilities;
import com.ninjacrm.generic.webdriverutilities.WebDriverUtilities;
import com.ninjacrm.objectrepository.CreateQuotesPage;
import com.ninjacrm.objectrepository.HomePage;
import com.ninjacrm.objectrepository.QuotesPage;
import com.ninjacrm.objectrepository.SelectContactPage;
import com.ninjacrm.objectrepository.SelectOpportunityPage;
import com.ninjacrmframe.baseclass.BaseClass;
import com.ninzacrm.listeners.RetryAnalyzerTest;

public class CreateQuotesForAllFieldsTest extends BaseClass{
	//IRetryAnalyzer
	
	@Test(groups = "smoke", retryAnalyzer = RetryAnalyzerTest.class)
	public void createQuotesForAllFieldsTest() throws IOException {
		WebDriverUtilities wd = new WebDriverUtilities();
		
		JavaUtilities jv = new JavaUtilities();
		String ranData = jv.randomData();
		String date = jv.generateExpectedDate(25);

		ExcelUtilities excel = new ExcelUtilities();
		String subject = excel.readDataFromExcel("Quotes", 1, 0)+ranData;
		String stage = excel.readDataFromExcel("Quotes", 1, 1)+ranData;
		String billAdd = excel.readDataFromExcel("Quotes", 1, 2)+ranData;
		String poBox = excel.readDataFromExcel("Quotes", 1, 3);
		String city = excel.readDataFromExcel("Quotes", 1, 4)+ranData;
		String state = excel.readDataFromExcel("Quotes", 1, 5);
		String postalCode = excel.readDataFromExcel("Quotes", 1, 6);
		String country = excel.readDataFromExcel("Quotes", 1, 7);
		String address = excel.readDataFromExcel("Quotes", 1, 8);
		String shipbox = excel.readDataFromExcel("Quotes", 1, 9);
		String scity = excel.readDataFromExcel("Quotes", 1, 10);
		String sstate = excel.readDataFromExcel("Quotes", 1, 11);
		String spostalcode = excel.readDataFromExcel("Quotes", 1, 12);
		String scountry = excel.readDataFromExcel("Quotes", 1, 13);

		HomePage hp = new HomePage(driver);
		hp.getQuotesButton().click();

		CreateQuotesPage cqp = new CreateQuotesPage(driver);
		cqp.getCreateQuoteButton().click();

		QuotesPage qp = new QuotesPage(driver);
		qp.getSubjectTextField().sendKeys(subject);
		qp.getValidTillTextField().sendKeys(date);
		qp.getQuoteStageTextField().sendKeys(stage);
		qp.getOpportunityDropdown().click();
		
		String parent = driver.getWindowHandle();
		wd.switchToWebPage(driver, "http://49.249.28.218:8098/selectOpportunity.html");
		
		SelectOpportunityPage sopp = new SelectOpportunityPage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(sopp.getSelectOpportunityButton()));
		
		sopp.getSelectOpportunityButton().click();
		
		driver.switchTo().window(parent);

		qp.getContactDropDown().click();
		
		wd.switchToWebPage(driver, "http://49.249.28.218:8098/selectContact.html");

		SelectContactPage scp = new SelectContactPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(scp.getselectContactButton()));
		scp.getselectContactButton().click();
		driver.switchTo().window(parent);

		// billing and shipping
		qp.getBillAddTextField().sendKeys(billAdd);
		qp.getBillPoBoxTextField().sendKeys(poBox);
		qp.getBittCityTextField().sendKeys(city);
		qp.getBittStateTextField().sendKeys(state);
		
		qp.getBillPostalCodeTextField().sendKeys(postalCode);
		qp.getBillCountryTextField().sendKeys(country);

		qp.getShipAddressTextField().sendKeys(address);
		qp.getShipPoBoxTextField().sendKeys(shipbox);
		qp.getShipCityTextField().sendKeys(scity);
		qp.getShipState().sendKeys(sstate);
		qp.getShipPostalCode().sendKeys(spostalcode);
		qp.getShipCountryTextField().sendKeys(scountry);

		// product
		qp.getProductButton().click();

		wd.switchToWebPage(driver, "http://49.249.28.218:8098/selectProduct.html");
		wd.elementToBeClickableWait(driver, hp.getSelectProductButton());
		
		hp.getSelectProductButton().click();
		driver.switchTo().window(parent);
		
		qp.getCreateQuoteButton().click();

		// explicit wait

		wd.elementToBeClickableWait(driver, hp.getAlertMeassage());

		String msg = hp.getAlertMeassage().getText();
		Assert.assertTrue(msg.contains("Successfully Added"));
	}
}
