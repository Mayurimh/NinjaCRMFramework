package com.ninzacrm.listeners;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ninjacrmframe.baseclass.BaseClass;

public class ListenerImplementation implements ISuiteListener, ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String testcase = result.getMethod().getMethodName();
//		Reporter.log(""+testcase+"Execution started!",true);
		test = report.createTest(testcase);
		test.log(Status.INFO, ""+testcase+"Execution started!");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testcase = result.getMethod().getMethodName();
//		Reporter.log(""+testcase+"Execution pass!",true);
		test.log(Status.PASS, ""+testcase+"Execution pass!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testcase = result.getMethod().getMethodName();
		
		test.log(Status.FAIL,""+testcase+"Execution fail!");
//		Reporter.log(""+testcase+"Execution fail!",true);
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		String src =ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(src);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testcase = result.getMethod().getMethodName();
		test.log(Status.SKIP,""+testcase+"Execution Skip!");
//		Reporter.log(""+testcase+"Execution Skip!",true);
	}
	
	//advance report -- onFinish() & onStart()

	@Override
	public void onStart(ISuite suite) {
		Reporter.log("Report configuration",true);
		Date d = new Date();
		String date = d.toString().replaceAll(" ", "_").replaceAll(":", "_");
		ExtentSparkReporter spar = new ExtentSparkReporter("./AdvanceReport/ExecutionReport"+date+".html");
		spar.config().setDocumentTitle("NinzaCRM");
		spar.config().setReportName("NinzaReport");
		spar.config().setTheme(Theme.DARK);
		 
		report = new ExtentReports();
		report.attachReporter(spar);
		report.setSystemInfo("System", "asusVivoBook");
		report.setSystemInfo("OS", "Windows11");
		report.setSystemInfo("browser", "chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("Take the backup",true);
		report.flush();
	}
	
}
