package main.java.page;

import main.java.page.builders.CheckoutBuilder;

public class CheckoutPage {
	CheckoutBuilder checkoutBuilder = new CheckoutBuilder();

	public void completeCheckoutAndGoToPayment() {
		checkoutBuilder.waitTillPageReady().publishCheckoutFactory().continueToPayment();
	}
}
