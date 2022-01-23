package com.midTrans.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;
import com.midTrans.driver.SharedDriver;

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
