package com.midTrans.driver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.midTrans.driver.SharedDriver;
import com.midTrans.helper.DriverInstanceTerminator;

public class InitiateDriver {
	private static SharedDriver sharedDriver;
	static String browser;

	private static SharedDriver getSharedDriver() throws Exception {
		browser = System.getenv("Browser");
		if (browser == null) {
			browser = "CHROME";
		}
		DriverInstanceTerminator.terminateInstances();
		
		GoogleChromeDriver chromDriver = new GoogleChromeDriver();
		MozillaFirefoxDriver firefoxDriver = new MozillaFirefoxDriver();
		SharedDriver sharedDriver;
		
		switch (browser) {
		case "FIREFOX":
			sharedDriver = new SharedDriver(firefoxDriver.getDriverInstance());
			break;
		case "CHROME":
			sharedDriver = new SharedDriver(chromDriver.getDriverInstance());
			break;
		default:
			sharedDriver = new SharedDriver(chromDriver.getDriverInstance());
		}
		return sharedDriver;
	}
	
	public static synchronized final SharedDriver getSharedDriverInstance() {
		if (sharedDriver == null) { //add reflection
			try {
				sharedDriver = getSharedDriver();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sharedDriver;
	}

	public static boolean stopDriver() {
		if (sharedDriver != null) {
			sharedDriver.close();
			sharedDriver.quit();
			return true;
		}
		return false;
	}

	public static String takeScreenShot() {
		String screenshotPath = null;
		try {
			screenshotPath = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss").format(new GregorianCalendar().getTime())
					+ "screenshot.png";
			File scrFile = ((TakesScreenshot) sharedDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotPath;
	}
}
