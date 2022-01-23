package com.midTrans.page.builders;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.midTrans.page.constants.CheckoutPageConstants;
import com.midTrans.page.pojo.CheckoutPojo;
import com.midTrans.page.pojo.VerificationPojo;

public class CheckoutBuilder extends ParentBuilder implements CheckoutPageConstants{

	@Override
	public CheckoutBuilder waitTillPageReady() {
		getWaitObj().until(ExpectedConditions.presenceOfElementLocated(CHECKOUT_POP_UP_FRAME));
		//Since this page is in an iframe, switching to iframe
		actionUtil.switchToFrame(CHECKOUT_POP_UP_FRAME);
		getWaitObj().until(ExpectedConditions.presenceOfElementLocated(ORDER_ID));
		return this;
	}
	
	public CheckoutBuilder publishCheckoutFactory() {
		CheckoutPojo checkoutFactory = new CheckoutPojo();
		checkoutFactory.setOrderId(actionUtil.getElementText(ORDER_ID));
		checkoutFactory.setTotalPrice(Integer.parseInt(actionUtil.getElementText(PRODUCT_AMOUNT)
				.replaceAll(",", "").trim()));
		checkoutFactory.setFooterTotalPrice(Integer.parseInt(actionUtil.getElementText(FOOTER_PRODUCT_AMOUNT)
				.replaceAll(",", "").trim()));
		checkoutFactory.setProductName(actionUtil.getElementText(FOOTER_PRODUCT_NAME));
		VerificationPojo.setCheckoutFactory(checkoutFactory);
		return this;
	}
	
	public void continueToPayment() {
		actionUtil.clickElement(CONTINUE_BTN);
	}
}
