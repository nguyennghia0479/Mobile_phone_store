package com.online.store.model;

public class CartInfo {
	private ProductInfo productInfo;
	private Integer quantity;

	public CartInfo() {
	}

	public CartInfo(ProductInfo productInfo, Integer quantity) {
		this.productInfo = productInfo;
		this.quantity = quantity;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
