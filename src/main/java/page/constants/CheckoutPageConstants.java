package main.java.page.constants;

import org.openqa.selenium.By;

/**
 * Using interfaces to store locators. Page factory or property files could have also been used.
 * Also, not marking variables final as Interface variables are by default final and static.
 */
public interface CheckoutPageConstants {
	By CHECKOUT_POP_UP_FRAME = By.id("snap-midtrans");
	By PRODUCT_AMOUNT = By.xpath("//div[@class='amount-content pull-right']/span[2]");
	By ORDER_ID = By.xpath("//div[@class='order-id-optional']/div");
	By FOOTER_PRODUCT_AMOUNT = By.xpath("//td[@class='table-amount text-body']");
	By FOOTER_PRODUCT_NAME = By.xpath("//td[@class='table-item text-body']");
	By CONTINUE_BTN = By.xpath("//a[@class='button-main-content']");
}
