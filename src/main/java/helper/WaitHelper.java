package main.java.helper;

import java.util.concurrent.TimeUnit;

import main.java.driver.SharedDriver;

public class WaitHelper {
	public static void implicitWait(SharedDriver sharedDriver){
		sharedDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public static void waitFor(long millisec){
		try {
			Thread.sleep(millisec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
