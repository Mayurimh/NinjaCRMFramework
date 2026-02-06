package com.ninjacrmframe.baseclass;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ninjacrm.generic.fileutilities.PropertiesUtilities;
import com.ninjacrm.objectrepository.HomePage;
import com.ninjacrm.objectrepository.LoginPage;


public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	PropertiesUtilities prop = new PropertiesUtilities();
	
	@BeforeSuite(groups = {"smoke","regression"})
	public void beforeSuite() {
		Reporter.log("Connect to database!", true);
	}

	@BeforeTest(groups = {"smoke","regression"})
	public void beforeTest() {
		Reporter.log("Precondition!", true);
	}

//	@Parameters("browser")
	@BeforeClass(groups = {"smoke","regression"})
	public void beforeClass() throws IOException {
		String BROWSER = prop.readAllDataFromPropertiesFile("browser");
//		String BROWSER = browser;
		if (BROWSER.equals("chrome")) {
			// to remove that popup : change the password
			ChromeOptions settings = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(settings);
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		sdriver=driver;
	}
	
	@BeforeMethod(groups = {"smoke","regression"})
	public void beforeMethod() throws IOException {
		String URL = prop.readAllDataFromPropertiesFile("url");
		String USERNAME = prop.readAllDataFromPropertiesFile("username");
		String PASSWORD = prop.readAllDataFromPropertiesFile("password");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(URL);
		// login
		LoginPage lp = new LoginPage(driver);
		lp.getUserNameTextField().sendKeys(USERNAME);
		lp.getPasswordTextField().sendKeys(PASSWORD);
		lp.getSignInButton().click();
	}
	
	@AfterMethod(groups = {"smoke","regression"})
	public void afterMethod() {
		HomePage hp = new HomePage(driver);
		hp.getCloseMessageClick().click();
		hp.getProfileIcon().click();
		hp.getLogoutIcon().click();
	}
	
	@AfterClass(groups = {"smoke","regression"})
	public void afterClass() {
		driver.close();
	}
	
	@AfterTest(groups = {"smoke","regression"})
	public void afterTest() {
		Reporter.log("PostCondition!",true);
	}
	
	@AfterSuite(groups = {"smoke","regression"})
	public void afterSuite() {
		Reporter.log("Connection closed!",true);
	}
}
