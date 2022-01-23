package com.midTrans.page.constants;

import org.openqa.selenium.By;

/**
 * Using interfaces to store locators. Page factory or property files could have also been used.
 * Also, not marking variables final as Interface variables are by default final and static.
 */
public interface PaymentPageConstants {
	By PAYMENT_OPTIONS = By.xpath("//div[@id='payment-list']/div");
	
	//Once on credit card option, use the following locators
	By CREDIT_CARD_NUM = By.xpath("//input[@name='cardnumber']");
	By EXPIRY_DATE = By.xpath("//input[@placeholder='MM / YY']");
	By CVV = By.xpath("//input[@inputmode='numeric']");
	By TOTAL_AMOUNT = By.className("text-amount-amount");
	By ORDER_ID = By.xpath("//div[@class='order-id-optional']/div");
	By EMAIL = By.xpath("//label[text()='Email']/preceding-sibling::input[@type='email']");
	By PHONE_NO = By.xpath("//label[text()='Phone number']/preceding-sibling::input[@type='tel']");
	By PAY_NOW_BTN = By.xpath("//a[@class='button-main-content']");
	By CC_ERROR_MSG = By.xpath("//div[@class='notice danger']/div[@class='content']");
	
	//When you enter credit card details and 3D page opens, use the following locators
	By FRAME_3D_SECURE_PAGE = By.xpath("//iframe[contains(@src, '/token')]");
	By PASSWORD = By.xpath("//input[@id='PaRes']");
	By OK_BTN = By.xpath("//button[@type='submit']");
	
	//When transaction is done, wait till iframe closes
	By IFRAME = By.tagName("iframe");
	
	//Constant error messages
	String INVALID_CC_ERR_MSG = "Invalid card number";
}
