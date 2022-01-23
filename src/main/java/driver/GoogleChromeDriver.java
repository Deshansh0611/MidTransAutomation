package main.java.driver;

import java.io.File;
import java.util.logging.Level;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

public class GoogleChromeDriver {
	protected ChromeDriver getDriverInstance() {
		System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "\\driverExecutables\\chromedriver.exe");
		LoggingPreferences pref = new LoggingPreferences();
		pref.enable(LogType.BROWSER, Level.WARNING);
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		return chromeDriver;
	}
}
