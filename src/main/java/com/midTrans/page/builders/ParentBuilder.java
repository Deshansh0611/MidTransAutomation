package com.midTrans.page.builders;

import java.util.Properties;

import com.midTrans.driver.SharedDriver;
import com.midTrans.helper.PropertyHelper;
import com.midTrans.page.BasePage;
import com.midTrans.utility.ActionUtily;

abstract class ParentBuilder extends BasePage{
	ActionUtily actionUtil = ActionUtily.getActionUtilInstance(sharedDriver);
	Properties testData = null;
	
	public ParentBuilder(String propertyFile) {
		testData = PropertyHelper.getProperty(propertyFile);
	}
	
	public ParentBuilder() {
		
	}
	
	public abstract ParentBuilder waitTillPageReady();
}
