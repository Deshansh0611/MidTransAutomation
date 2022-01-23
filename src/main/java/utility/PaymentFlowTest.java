package main.java.utility;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import main.java.enums.PaymentOptions;
import main.java.page.BasePage;
import main.java.page.CheckoutPage;
import main.java.page.PaymentPage;
import main.java.page.SampleStorePage;
import main.java.page.constants.PaymentFlowTestConstants;
import main.java.page.constants.PaymentPageConstants;
import main.java.page.constants.SampleStorePageConstants;
import main.java.page.pojo.VerificationPojo;

public class PaymentFlowTest extends BasePage implements SampleStorePageConstants
, PaymentPageConstants, PaymentFlowTestConstants{
	private static final Logger logger = Logger.getLogger(PaymentFlowTest.class.getName());
	SampleStorePage sampleStore = new SampleStorePage();
	CheckoutPage checkout = new CheckoutPage();
	PaymentPage payment = new PaymentPage();

	@BeforeMethod
	public void openSampleStore() {
		logger.log(Level.INFO, "Running test class: PaymentFlowTest. Opening web site url.");
		sharedDriver.get(SAMPLE_STORE_URL);
	}

	@Test
	public void testSuccessFlow() {
		logger.log(Level.INFO, "Running test case: testSuccessFlow");
		//Checking first of all if Buy button exists
		sampleStore.addPillowAndCheckout();
		checkout.completeCheckoutAndGoToPayment();
		payment.completePaymentAndPlaceOrder(PaymentOptions.CREDITCARD, "4811111111111114", "02/20", "123", "112233");

		//Verifying product name across different pages
		softAssert.assertEquals(
				VerificationPojo.getSampleStoreFactory().getProductName()
				, VerificationPojo.getCheckoutFactory().getProductName(), PRODUCT_NAME_VALIDATION_FAIL);
		//Verifying order id across different pages
		softAssert.assertEquals(VerificationPojo.getCheckoutFactory().getOrderId()
				,VerificationPojo.getPaymentFactory().getOrderId(), ORDER_ID_VALIDATION_FAIL);
		//Verifying price across different pages
		softAssert.assertTrue(VerificationPojo.getSampleStoreFactory().getPillowPrice()
				.equals(VerificationPojo.getCheckoutFactory().getFooterTotalPrice()) &&
				VerificationPojo.getCheckoutFactory().getFooterTotalPrice()
				.equals(VerificationPojo.getCheckoutFactory().getTotalPrice()) &&
				VerificationPojo.getCheckoutFactory().getTotalPrice()
				.equals(VerificationPojo.getPaymentFactory().getAmount()));
		//Verifying order success message on home page after order is places
		softAssert.assertEquals(VerificationPojo.getOrderSuccessMsg(), ORDER_SUCCESS_MSG, ORDER_SUCCESS_MSG_VALIDATION_FAIL);
		softAssert.assertAll();
	}

	@Test
	public void testFailureFlow() {
		logger.log(Level.INFO, "Running test case: testFailureFlow");
		sampleStore.addPillowAndCheckout();
		checkout.completeCheckoutAndGoToPayment();
		payment.paymentFailureScenario(PaymentOptions.CREDITCARD, "4811111111111113", "02/20", "123");
		//Verifying price across different pages
		softAssert.assertTrue(VerificationPojo.getSampleStoreFactory().getPillowPrice()
				.equals(VerificationPojo.getCheckoutFactory().getFooterTotalPrice()) &&
				VerificationPojo.getCheckoutFactory().getFooterTotalPrice()
				.equals(VerificationPojo.getCheckoutFactory().getTotalPrice()) &&
				VerificationPojo.getCheckoutFactory().getTotalPrice()
				.equals(VerificationPojo.getPaymentFactory().getAmount()));
		//Verifying error message on payment page
		softAssert.assertTrue(null != VerificationPojo.getPaymentFactory().getCcErroMsg() &&
				VerificationPojo.getPaymentFactory().getCcErroMsg().equalsIgnoreCase(INVALID_CC_ERR_MSG),
				CC_VALIDATION_FAIL);
		softAssert.assertAll();
	}
}
