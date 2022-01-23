package main.java.page.builders;

import java.util.Properties;

import main.java.helper.PropertyHelper;
import main.java.page.BasePage;
import main.java.utility.ActionUtily;

abstract class ParentBuilder extends BasePage {
	ActionUtily actionUtil = ActionUtily.getActionUtilInstance(sharedDriver);
	Properties testData = null;
	
	public ParentBuilder(String propertyFile) {
		testData = PropertyHelper.getProperty(propertyFile);
	}
	
	public ParentBuilder() {
		
	}
	
	public abstract ParentBuilder waitTillPageReady();
}
