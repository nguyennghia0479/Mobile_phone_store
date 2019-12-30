package com.online.store.service;

import java.util.List;

import com.online.store.model.CartInfo;

public interface CartService {
	
	void addItemToCart(Long productId);
	
	void updateCart(Long productId, Integer quantity);
	
	void removeItemFromCart(Long productId);
	
	void removeAllItem();
	
	Long totalPriceItem();
	
	Integer totalQuantityItem();
	
	List<CartInfo> getListItems();
}
