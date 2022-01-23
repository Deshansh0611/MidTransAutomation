package main.java.page.builders;

import main.java.enums.PaymentOptions;
import main.java.page.constants.PaymentPageConstants;
import main.java.page.pojo.PaymentPojo;
import main.java.page.pojo.VerificationPojo;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentBuilder extends ParentBuilder implements PaymentPageConstants {

	public PaymentBuilder(String propertyName) {
		super(propertyName);
	}

	@Override
	public PaymentBuilder waitTillPageReady() {
		getWaitObj().until(ExpectedConditions.presenceOfElementLocated(PAYMENT_OPTIONS));
		return this;
	}

	public PaymentBuilder publishPaymentFactory() {
		PaymentPojo paymentFactory = new PaymentPojo();
		paymentFactory.setAmount(Integer.parseInt(actionUtil.getElementText(TOTAL_AMOUNT).replace(",", "").trim()));
		paymentFactory.setOrderId(actionUtil.getElementText(ORDER_ID));
		paymentFactory.setEmail(actionUtil.getElementText(EMAIL));
		paymentFactory.setPhoneNum(actionUtil.getElementText(PHONE_NO));
		if(actionUtil.getElementsList(CC_ERROR_MSG).size() != 0)
			paymentFactory.setCcErroMsg(actionUtil.getElementText(actionUtil.getElementsList(CC_ERROR_MSG).get(0)));
		VerificationPojo.setPaymentFactory(paymentFactory);
		return this;
	}

	/**
	 * Enum with index associated is created so that no switch/if-else statements are required to select payment type.
	 */
	public PaymentBuilder selectPaymentOption(PaymentOptions paymentOption) {
		actionUtil.clickElement(actionUtil.getElementsList(PAYMENT_OPTIONS)
				.get(paymentOption.getValue()));
		return this;
	}

	public PaymentBuilder enterCreditCardDetails(String ccNum, String expiry, String cvv) {
		actionUtil.inputText(CREDIT_CARD_NUM, ccNum);
		actionUtil.inputText(EXPIRY_DATE, expiry);
		actionUtil.inputText(CVV, cvv);
		return this;
	}

	public PaymentBuilder clickPayNow() {
		actionUtil.clickElement(PAY_NOW_BTN);
		return this;
	}
	
	public PaymentBuilder waitTill3DSecurePageReady() {
		getWaitObj().until(ExpectedConditions.presenceOfElementLocated(FRAME_3D_SECURE_PAGE));
		actionUtil.switchToFrame(FRAME_3D_SECURE_PAGE);
		getWaitObj().until(ExpectedConditions.presenceOfElementLocated(PASSWORD));
		return this;
	}
	
	public PaymentBuilder enterOTPOn3DPage(String otp) {
		actionUtil.inputText(PASSWORD, otp);
		return this;
	}
	
	public SampleStoreBuilder completeTransaction() {
		actionUtil.clickElement(OK_BTN);
		getWaitObj().until(ExpectedConditions.presenceOfElementLocated(IFRAME));
		getWaitObj().until(ExpectedConditions.invisibilityOfElementLocated(IFRAME));
		return new SampleStoreBuilder();
	}
}
