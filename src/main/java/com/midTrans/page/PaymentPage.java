package com.midTrans.page;

import com.midTrans.enums.PaymentOptions;
import com.midTrans.page.builders.PaymentBuilder;

public class PaymentPage {
	PaymentBuilder paymentBuilder = new PaymentBuilder("creditCardDetails");
	
	public void completePaymentAndPlaceOrder(PaymentOptions paymentOption, String ccNum, String ccExpiry
			, String ccCvv, String otp) {
		paymentBuilder.waitTillPageReady().selectPaymentOption(paymentOption)
			.enterCreditCardDetails(ccNum, ccExpiry, ccCvv).publishPaymentFactory()
			.clickPayNow().waitTill3DSecurePageReady().enterOTPOn3DPage(otp)
			.completeTransaction().waitTillPageReady().checkSuccessMsg();
	}
	
	public void paymentFailureScenario(PaymentOptions paymentOption, String ccNum, String ccExpiry
			, String ccCvv) {
		paymentBuilder.waitTillPageReady().selectPaymentOption(paymentOption)
			.enterCreditCardDetails(ccNum, ccExpiry, ccCvv).clickPayNow().publishPaymentFactory();
	}
}
