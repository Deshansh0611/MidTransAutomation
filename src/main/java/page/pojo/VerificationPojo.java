package main.java.page.pojo;

/*
 * This pojo/bean will be used to store objects of different pages to be used for assertions.
 */
public class VerificationPojo {
	private static PaymentPojo paymentFactory;
	private static SampleStorePojo sampleStoreFactory;
	private static CheckoutPojo checkoutFactory;
	private static String orderSuccessMsg;
	
	public static PaymentPojo getPaymentFactory() {
		return paymentFactory;
	}
	public static void setPaymentFactory(PaymentPojo paymentFactory) {
		VerificationPojo.paymentFactory = paymentFactory;
	}
	public static SampleStorePojo getSampleStoreFactory() {
		return sampleStoreFactory;
	}
	public static void setSampleStoreFactory(SampleStorePojo sampleStoreFactory) {
		VerificationPojo.sampleStoreFactory = sampleStoreFactory;
	}
	public static CheckoutPojo getCheckoutFactory() {
		return checkoutFactory;
	}
	public static void setCheckoutFactory(CheckoutPojo checkoutFactory) {
		VerificationPojo.checkoutFactory = checkoutFactory;
	}
	public static String getOrderSuccessMsg() {
		return orderSuccessMsg;
	}
	public static void setOrderSuccessMsg(String setOrderSuccessMsg) {
		VerificationPojo.orderSuccessMsg = setOrderSuccessMsg;
	}
}
