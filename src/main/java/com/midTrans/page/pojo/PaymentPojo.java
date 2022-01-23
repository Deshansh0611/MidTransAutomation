package com.midTrans.page.pojo;

public class PaymentPojo {
	private Integer amount;
	private String orderId;
	private String email;
	private String phoneNum;
	private String ccErroMsg;

	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getCcErroMsg() {
		return ccErroMsg;
	}
	public void setCcErroMsg(String ccErroMsg) {
		this.ccErroMsg = ccErroMsg;
	}
}
