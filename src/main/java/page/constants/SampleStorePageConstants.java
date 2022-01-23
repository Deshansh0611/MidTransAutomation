package main.java.page.constants;

import org.openqa.selenium.By;

/**
 * Using interfaces to store locators. Page factory or property files could have also been used.
 * Also, not marking variables final as Interface variables are by default final and static.
 */
public interface SampleStorePageConstants {
	By PRODUCT_NAME = By.className("title");
	By PRODUCT_PRICE = By.xpath("//div[@class='price']");
	By BUY_NOW_BTN = By.xpath("//a[@class='btn buy']");
	By CART_CONTENT_POP_UP = By.className("cart-content buying");
	By CART_PRODUCT_NAME_QUANTITY = By.xpath("(//tr[@class='table-content'])[1]");
	By CART_TOTAL_PRICE = By.xpath("//tr[@class='total']/td[3]");

	//Customer details locators
	By CART_CUSTOMER_NAME = By.xpath("//td[text()='Name']/following-sibling::*/input");
	By CART_CUSTOMER_EMAIL = By.xpath("//td[text()='Email']/following-sibling::*/input");
	By CART_CUSTOMER_PHONE_NO = By.xpath("//td[text()='Phone no']/following-sibling::*/input");
	By CART_CUSTOMER_CITY = By.xpath("//td[text()='City']/following-sibling::*/input");
	By CART_CUSTOMER_ADDRESS = By.xpath("//td[text()='Address']/following-sibling::*/textarea");
	By CART_CUSTOMER_POSTAL_CODE = By.xpath("//td[text()='Postal Code']/following-sibling::*/input");
	
	//When shopping cart pop up opens
	By CART_CHECKOUT_BTN = By.className("cart-checkout");
	
	//When successfull transaction is made
	By SUCCESS_TRANSACTION_MSG = By.xpath("//div[@class='trans-status trans-success']");
}
