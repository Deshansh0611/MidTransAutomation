package main.java.driver;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;

public class MozillaFirefoxDriver {
	protected FirefoxDriver getDriverInstance() {
		System.setProperty("webdriver.gecko.driver", new File("").getAbsolutePath() + "\\driverExecutables\\geckodriver.exe");
		FirefoxDriver firefoxDriver = new FirefoxDriver();
		firefoxDriver.manage().window().maximize();
		return firefoxDriver;
	}
}
