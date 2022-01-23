package com.midTrans.enums;

/**
 * This enum is created to select the payment options. Each enum is associated with an integer.
 * This is done so that no switch case handling is required and we can simply get the payment type index and click.
 */
public enum PaymentOptions {
	CREDITCARD(0), ATMBANKTRANSFER(1), GOPAY(2), BCAKLIKPAY(3), CIMBCLICKS(4), DANAMON(5), 
	EPAYBRI(6), LINE(7), TELKOMSEL(8), INDOMARET(9), ALFAMART(10), AKULAKU(11);

	private final int index;
	private PaymentOptions(int index) {
		this.index = index;
	}
	
	public int getValue() {
		return index; 
	}
}
