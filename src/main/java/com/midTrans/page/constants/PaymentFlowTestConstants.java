package com.midTrans.page.constants;

public interface PaymentFlowTestConstants {
	String SAMPLE_STORE_URL = "https://demo.midtrans.com/";
	
	String ORDER_SUCCESS_MSG = "Thank you for your purchase.Get a nice sleep.";
	
	//Assertion failure messages
	String ORDER_SUCCESS_MSG_VALIDATION_FAIL = "Order success message validation failed."; 
	String CC_VALIDATION_FAIL = "Credit card eror message validation failure.";
	String PRODUCT_NAME_VALIDATION_FAIL = "Product name validation failure.";
	String ORDER_ID_VALIDATION_FAIL = "Order id validation failed.";
}
