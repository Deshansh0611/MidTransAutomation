package com.midTrans.page;

import com.midTrans.page.builders.CheckoutBuilder;

public class CheckoutPage {
	CheckoutBuilder checkoutBuilder = new CheckoutBuilder();

	public void completeCheckoutAndGoToPayment() {
		checkoutBuilder.waitTillPageReady().publishCheckoutFactory().continueToPayment();
	}
}
