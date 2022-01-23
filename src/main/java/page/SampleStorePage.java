package main.java.page;

import main.java.page.builders.SampleStoreBuilder;
import main.java.page.constants.SampleStorePageConstants;

/**
 * This class will have all the steps for test cases. This way, all heavy lift and shift activities will be 
 * separated from test cases and it will have focus only on assertions.
 */
public class SampleStorePage extends BasePage implements SampleStorePageConstants {

	SampleStoreBuilder sampleStoreBuilder = new SampleStoreBuilder("customerDetails");

	public void addPillowAndCheckout() {
		sampleStoreBuilder.waitTillPageReady().addProductToCart().fillCustomerDetails()
			.publishSampleStoreFactory().continueToPayment();
	}

}
