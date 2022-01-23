package main.java.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class SharedDriver extends EventFiringWebDriver {
	public SharedDriver(WebDriver driver) {
		super(driver);
	}
}