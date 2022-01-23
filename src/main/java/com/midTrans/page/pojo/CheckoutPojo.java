package com.midTrans.page.pojo;

public class CheckoutPojo {
	private String orderId;
	private Integer totalPrice;
	private Integer footerTotalPrice;
	private String productName;

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getFooterTotalPrice() {
		return footerTotalPrice;
	}
	public void setFooterTotalPrice(Integer footerTotalPrice) {
		this.footerTotalPrice = footerTotalPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
}
