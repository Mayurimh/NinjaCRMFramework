package com.ninjacrm.compaigntest;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.ninjacrm.generic.fileutilities.ExcelUtilities;
import com.ninjacrm.generic.javautilities.JavaUtilities;
import com.ninjacrm.generic.webdriverutilities.WebDriverUtilities;
import com.ninjacrm.objectrepository.CampaignsPage;
import com.ninjacrm.objectrepository.CreateCampaignPage;
import com.ninjacrm.objectrepository.HomePage;
import com.ninjacrmframe.baseclass.BaseClass;

public class CreateTestForAllTest extends BaseClass{
	@Test(groups = "regression")
	public void CreateCampaignWIthExpDate() throws IOException, InterruptedException {
		// use methods in JavaUtility class for generate date, random data
		JavaUtilities jvu = new JavaUtilities();
		String ranData = jvu.randomData();
		String date = jvu.generateExpectedDate(30);
		
		//read data from excel
		ExcelUtilities exc = new ExcelUtilities();
		String campName = exc.readDataFromExcel("Campaign", 3, 0) + ranData;
		String targetSize = exc.readDataFromExcel("Campaign", 3, 2);
		
		//Home page
		HomePage hp = new HomePage(driver);
		hp.getCampaignLink().click();
				
				
		// click on campaign
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaign().click();

		// create campiagn
		CreateCampaignPage ccp1 = new CreateCampaignPage(driver);
		ccp1.getCampaignNameTextField().sendKeys(campName);
		ccp1.getTagetSizeTextField().sendKeys(targetSize);
		ccp1.getDateTextField().sendKeys(date);
		ccp1.getCreateCampaignButton().click();

		// explicit wait
		
		WebDriverUtilities wb1 = new WebDriverUtilities();
		wb1.elementToBeClickableWait(driver, hp.getAlertMeassage());
		 
		String msg = hp.getAlertMeassage().getText();
		Assert.assertTrue(msg.contains("Successfully Added"));
//		if (msg.contains("Successfully Added")) {
//			Reporter.log("campaign Sucessfully added!",true);
//		} else {
//			Reporter.log("no added!",false);
//		}
	}
	
	@Test(groups = "regression")
	public void CreateCampaignWithManadatoryField() throws IOException, InterruptedException {
		//use methods in JavaUtility class for generate date, random data
		JavaUtilities jvu = new JavaUtilities();
		String ranData = jvu.randomData();
		
		//read data from excel
		ExcelUtilities exc = new ExcelUtilities();
		String campName = exc.readDataFromExcel("Campaign",3, 0)+ranData;
		String targetSize = exc.readDataFromExcel("Campaign", 3, 2);
		
		//home 
		HomePage hp = new HomePage(driver);
		hp.getCampaignLink();
		
		//click on campaign
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaign().click();
		
		
		//create campiagn
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.getCampaignNameTextField().sendKeys(campName);
		ccp.getTagetSizeTextField().sendKeys(targetSize);
		ccp.getCreateCampaignButton().click();
		
		//explicit wait
		
		WebDriverUtilities wb1 = new WebDriverUtilities();
		wb1.elementToBeClickableWait(driver, hp.getAlertMeassage());
		 
		String msg = hp.getAlertMeassage().getText();
		Assert.assertTrue(msg.contains("Successfully Added"));
//		if (msg.contains("Successfully Added")) {
//			Reporter.log("campaign Sucessfully added!",true);
//		} else {
//			Reporter.log("no added!",false);
//		}
	}
	
	@Test(groups = "smoke")
	public void CreateCampaignWithStatusTest() throws IOException, InterruptedException {
		//use methods in JavaUtility class for generate date, random data
		JavaUtilities jvu = new JavaUtilities();
		String ranData = jvu.randomData();
		
		//read data from excel
		ExcelUtilities exc = new ExcelUtilities();
		String campName = exc.readDataFromExcel("Campaign", 3, 0) + ranData;
		String targetSize = exc.readDataFromExcel("Campaign", 3, 2);
		String campaignStatus = exc.readDataFromExcel("Campaign", 3, 1) + ranData;
		// home
		HomePage hp = new HomePage(driver);
		hp.getCampaignLink().click();;

		// click on campaign
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaign().click();

		// create campiagn
		CreateCampaignPage ccp1 = new CreateCampaignPage(driver);
		ccp1.getCampaignNameTextField().sendKeys(campName);
		ccp1.getTagetSizeTextField().sendKeys(targetSize);
		ccp1.getCampaignStatusTextField().sendKeys(campaignStatus);
		ccp1.getCreateCampaignButton().click();

		// explicit wait
		WebDriverUtilities wb1 = new WebDriverUtilities();
		wb1.elementToBeClickableWait(driver, hp.getAlertMeassage());
		 
		String msg = hp.getAlertMeassage().getText();
		Assert.assertTrue(msg.contains("Successfully Added"));
//		SoftAssert s= new SoftAssert();
//		s.assertTrue(msg.contains("Successfully Added"));
//		System.out.println("bye");
//		s.assertAll();
//		if (msg.contains("Successfully Added")) {
//			Reporter.log("campaign Sucessfully added!",true);
//		} else {
//			Reporter.log("no added!",false);
//		}

	}
}
