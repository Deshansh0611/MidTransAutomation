package main.java.page.pojo;

/**
 * We are using Factory here. Objective is to create the object of Sample store page(home page) 
 * and store all the information we could capture in the object of this class.
 * For example, we can capture price and name of pillow on home page/cart page and compare this with that on checkout page
 */
public class SampleStorePojo {
	private Integer pillowPrice;
	private String productName;
	private String cartProductName;
	private Integer cartPillowPrice;
	private Integer cartProductQuantity;

	public Integer getPillowPrice() {
		return pillowPrice;
	}
	public void setPillowPrice(Integer pillowPrice) {
		this.pillowPrice = pillowPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCartProductName() {
		return cartProductName;
	}
	public void setCartProductName(String cartProductName) {
		this.cartProductName = cartProductName;
	}
	public Integer getCartPillowPrice() {
		return cartPillowPrice;
	}
	public void setCartPillowPrice(Integer cartPillowPrice) {
		this.cartPillowPrice = cartPillowPrice;
	}
	public Integer getCartProductQuantity() {
		return cartProductQuantity;
	}
	public void setCartProductQuantity(Integer cartProductQuantity) {
		this.cartProductQuantity = cartProductQuantity;
	}
}
