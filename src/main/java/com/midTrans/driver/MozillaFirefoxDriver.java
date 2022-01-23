package com.midTrans.driver;

import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class MozillaFirefoxDriver {
	protected FirefoxDriver getDriverInstance() {
		System.setProperty("webdriver.gecko.driver", new File("").getAbsolutePath() + "\\driverExecutables\\geckodriver.exe");
		FirefoxDriver firefoxDriver = new FirefoxDriver();
		firefoxDriver.manage().window().maximize();
		return firefoxDriver;
	}
}
