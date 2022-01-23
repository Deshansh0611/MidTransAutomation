package com.midTrans.listeners;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.midTrans.driver.InitiateDriver;
import com.midTrans.driver.SharedDriver;
import com.midTrans.page.BasePage;

/**
 * Purpose of this listener is to capture screenshot whenever test fails. 
 * We are capturing the ITestResult with which method name can be captured. This is the name we give to the screenshot.
 */
public class ReportingListener extends BasePage implements ITestListener{

	public static final String pathToSaveScreenshot = new File("").getAbsolutePath() + "\\screenshot\\";
	private static final Logger logger = Logger.getLogger(ReportingListener.class.getName());
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.log(Level.INFO, "Test case passed. Not capturing screenshot.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String failedMethodName = result.getName().toString().trim();
		logger.log(Level.WARNING, "Test case with method " + failedMethodName + " failed.");
		SharedDriver driver = InitiateDriver.getSharedDriverInstance();
		takeScreenShot(failedMethodName, driver);
	}

	public void takeScreenShot(String failedMethodName, WebDriver driver) {
		logger.log(Level.INFO, "Taking screenshot of page.");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(pathToSaveScreenshot + failedMethodName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
