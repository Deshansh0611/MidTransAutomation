package com.midTrans.page.builders;

import java.util.Properties;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.midTrans.helper.PropertyHelper;
import com.midTrans.page.constants.SampleStorePageConstants;
import com.midTrans.page.pojo.SampleStorePojo;
import com.midTrans.page.pojo.VerificationPojo;

/**
 * This page will use builder design pattern to perform multiple operations. 
 * Currently each page has very limited operations. But, in future if number of operations increase, it will come handy.
 */
public class SampleStoreBuilder extends ParentBuilder implements SampleStorePageConstants{
	public SampleStoreBuilder(String propertyName) {
		super(propertyName);
	}
	
	public SampleStoreBuilder() {
		
	}

	public SampleStoreBuilder publishSampleStoreFactory() {
		SampleStorePojo sampleStoreFactory = new SampleStorePojo();
		sampleStoreFactory.setProductName(actionUtil.getElementText(PRODUCT_NAME));
		sampleStoreFactory.setPillowPrice(Integer.parseInt(actionUtil.getElementText(PRODUCT_PRICE).
				split("Rp")[1].replaceAll(",", "").trim()));
		sampleStoreFactory.setCartPillowPrice(Integer.parseInt(actionUtil.getElementText(CART_TOTAL_PRICE)
				.replaceAll(",", "").trim()));
		sampleStoreFactory.setCartProductQuantity(Integer.parseInt(actionUtil.getElementText(CART_PRODUCT_NAME_QUANTITY)
				.split("×")[1].trim()));
		sampleStoreFactory.setCartProductName(actionUtil.getElementText(CART_PRODUCT_NAME_QUANTITY)
				.split("×")[0].trim());
		VerificationPojo.setSampleStoreFactory(sampleStoreFactory);
		return this;
	}

	@Override
	public SampleStoreBuilder waitTillPageReady() {
		getWaitObj().until(ExpectedConditions.presenceOfAllElementsLocatedBy(BUY_NOW_BTN));
		return this;
	}

	public SampleStoreBuilder addProductToCart() {
		actionUtil.clickElement(BUY_NOW_BTN);
		return this;
	}

	public SampleStoreBuilder fillCustomerDetails() {
		actionUtil.inputText(CART_CUSTOMER_NAME, testData.getProperty("customerName"));
		actionUtil.inputText(CART_CUSTOMER_EMAIL, testData.getProperty("customerEmail"));
		actionUtil.inputText(CART_CUSTOMER_PHONE_NO, testData.getProperty("customerPhoneNo"));
		actionUtil.inputText(CART_CUSTOMER_CITY, testData.getProperty("customerCity"));
		actionUtil.inputText(CART_CUSTOMER_ADDRESS, testData.getProperty("customerAddress"));
		actionUtil.inputText(CART_CUSTOMER_POSTAL_CODE, testData.getProperty("customerPostalCode"));
		return this;
	}

	/**
	 * Here, a common build method could also have been written in the parent class.
	 * Each class would have overridden that and called next page. Just before that we could have published the factory.
	 * Picked up this approach as I feel we should publish factory only when it is required.
	 */
	public void continueToPayment() {
		actionUtil.clickElement(CART_CHECKOUT_BTN);
	}
	
	public void checkSuccessMsg() {
		String successMsg = null;
		if(actionUtil.getElementsList(SUCCESS_TRANSACTION_MSG).size() != 0)
			successMsg = actionUtil.getElementText(actionUtil.getElementsList(SUCCESS_TRANSACTION_MSG).get(0))
				.replace("\n", "").replace("\r", "").trim();
		VerificationPojo.setOrderSuccessMsg(successMsg);
	}
}
