package main.java.utility;

import java.util.List;

import main.java.driver.SharedDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ActionUtily {
	SharedDriver sharedDriver;
	private static ActionUtily actionUtl;
	private ActionUtily(SharedDriver sharedDriver) {
		this.sharedDriver = sharedDriver;
	}

	/**
	 * Singleton approach
	 */
	public static synchronized ActionUtily getActionUtilInstance(SharedDriver sharedDriver) {
		if(actionUtl == null)
			actionUtl = new ActionUtily(sharedDriver);
		return actionUtl;
	}

	public void inputText(String elmLocator, String input) {
		sharedDriver.findElement(By.xpath(elmLocator)).clear();
		sharedDriver.findElement(By.xpath(elmLocator)).sendKeys(input);
	}

	public void inputText(By elmLocator, String input) {
		sharedDriver.findElement(elmLocator).clear();
		sharedDriver.findElement(elmLocator).sendKeys(input);
	}

	public void inputText(WebElement elm, String input) {
		elm.clear();
		elm.sendKeys(input);
	}

	public void clickElement(String elmLocator) {
		sharedDriver.findElement(By.xpath(elmLocator)).click();
	}

	public void clickElement(By elmLocator) {
		sharedDriver.findElement(elmLocator).click();
	}

	public void clickElement(WebElement elm) {
		elm.click();
	}

	public String getElementText(String elmLocator) {
		return sharedDriver.findElement(By.xpath(elmLocator)).getText();
	}

	public String getElementText(By elmLocator) {
		return sharedDriver.findElement(elmLocator).getText();
	}

	public String getElementText(WebElement elm) {
		return elm.getText();
	}
	
	public void switchToFrame(int index) {
		sharedDriver.switchTo().frame(index);
	}
	
	public void switchToFrame(By elmLocator) {
		sharedDriver.switchTo().frame(sharedDriver.findElement(elmLocator));
	}
	
	public List<WebElement> getElementsList(By elmLocator){
		return sharedDriver.findElements(elmLocator);
	}
}
