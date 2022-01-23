package main.java.helper;

import java.util.Set;

import main.java.driver.SharedDriver;
import org.openqa.selenium.Cookie;

public class CookieHelper {
	public static boolean deleteAllCookies(SharedDriver driver) {
		driver.manage().deleteAllCookies();
		return (getCookiesList(driver) != null && getCookiesList(driver).size() > 0) ? true : false;
	}
	
	public static Set<Cookie> getCookiesList(SharedDriver driver) {
		return driver.manage().getCookies();
	}
}
