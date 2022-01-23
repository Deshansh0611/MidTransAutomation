package com.midTrans.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHelper {
	private static PropertyHelper instance;
	private static String propertyFilePath = null;

	private PropertyHelper(String fileName) {
		propertyFilePath = new File("").getAbsolutePath() + "\\testData\\" + fileName + ".properties";
	}

	//Create a Singleton instance. We need only one instance of Property Helper.
	public static synchronized Properties getProperty(String fileName) {
		if (instance == null) 
			instance = new PropertyHelper(fileName);
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(propertyFilePath));
		} catch (IOException e) {
			System.out.println("Properties file cannot be found");
		}
		return prop;
	}
}
