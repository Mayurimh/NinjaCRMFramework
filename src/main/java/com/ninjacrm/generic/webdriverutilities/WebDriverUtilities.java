package com.ninjacrm.generic.webdriverutilities;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtilities {
	public void selectByVal(WebElement webEle,String value) {
		Select sec= new Select(webEle);
		sec.selectByValue(value);
	}
	public void deselectByVal(WebElement webEle, String value) {
		Select sec= new Select(webEle);
		sec.deselectByValue(value);
	}
	
	public void selectByIndex(WebElement webEle,int i) {
		Select sec= new Select(webEle);
		sec.selectByIndex(i);
	}
	public void unselectByIndex(WebElement webEle, int i) {
		Select sec= new Select(webEle);
		sec.deselectByIndex(i);
	}
	
	public void getAllOption(WebElement webele) {
		Select sel = new Select(webele);
		List<WebElement> list = sel.getOptions();
		for(WebElement li : list) {
			System.out.println(li.getText());
		}
	}
	
	public List<String> getAllOptionInList(WebElement webele) {
		Select sel = new Select(webele);
		List<WebElement> list = sel.getOptions();
		List<String> str = new ArrayList<String>();
		for(WebElement li : list) {
			str.add(li.getText());
		}
		return str;
	}
	
	public void contextClick(WebDriver driver,  WebElement web) {
		Actions act = new Actions(driver);
		act.contextClick(web).perform();
	}
	
	
	public void takeScreenShot(WebDriver driver) throws IOException {
		String time = LocalTime.now().toString().replace(":", "-");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+time+".png");
		FileHandler.copy(src,dest);
	}
	
	public void takeScreenShot(WebElement elem) throws IOException {
		String time = LocalTime.now().toString().replace(":", "-");
		File src = elem.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+time+".png");
		FileHandler.copy(src,dest);
	}
	
	
	public void checkElementToBeClickable(WebDriver driver, WebElement webele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(webele));
	}
	
	
	public void scrollWebPage(WebDriver driver,int x, int y)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
		
	}	
	
	public void elementToBeClickableWait(WebDriver driver,WebElement web) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(web));
	}
	
	public void switchToWebPage(WebDriver driver, String url) {
		Set<String> listOfAdd = driver.getWindowHandles();
		for(String a : listOfAdd) {
			driver.switchTo().window(a);
			String curUrl = driver.getCurrentUrl();
			if(curUrl.contains(url)) {
				break;
			}
		}
	}
}
