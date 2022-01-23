package com.midTrans.helper;

import java.io.IOException;

public class DriverInstanceTerminator {
	public static void terminateInstances() {
		try {
			Process cprocess = Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
			cprocess.waitFor();
			Process fprocess = Runtime.getRuntime().exec("taskkill /im firefox.exe /f");
			fprocess.waitFor();
			Process gprocess = Runtime.getRuntime().exec("taskkill /im geckodriver.exe /f");
			gprocess.waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
}
