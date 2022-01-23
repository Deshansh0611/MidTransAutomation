package com.midTrans.page;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.asserts.SoftAssert;

import com.midTrans.page.BasePage;
import com.midTrans.helper.CookieHelper;
import com.midTrans.driver.InitiateDriver;
import com.midTrans.driver.SharedDriver;

public abstract class BasePage {
	private static final Logger logger = Logger.getLogger(BasePage.class.getName());
	public SharedDriver sharedDriver = InitiateDriver.getSharedDriverInstance();
	public static SoftAssert softAssert = getInstance();

	private static final SoftAssert getInstance() {
		if (softAssert == null) {
			softAssert = new SoftAssert();
		}
		return softAssert;
	}

	public boolean deleteCookies() {
		try {
			CookieHelper.deleteAllCookies(sharedDriver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteLocalStorage() {
		try {
			LocalStorage local = (LocalStorage) ((SessionStorage) sharedDriver);
			local.clear();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public WebDriverWait getWaitObj() {
		WebDriverWait wait = new WebDriverWait(sharedDriver, 30);
		return wait;
	}
	
	public void getJsErrors(String testName) {
		// Capture all JSerrors and print In console.
		LogEntries jserrors = sharedDriver.manage().logs().get(LogType.BROWSER);
		logger.info("Console logs for the method " + testName);
		for (LogEntry error : jserrors) {
			logger.info(error.getMessage());
		}
	}
	
	//Teardown method
	@AfterSuite
	public void closeAllInstances() {
		logger.log(Level.INFO, "Execution completed. Closing all browser instances.");
		sharedDriver.quit();
	}
}
