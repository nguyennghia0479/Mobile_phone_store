package com.online.store.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.store.dao.ProductDao;
import com.online.store.model.CartInfo;
import com.online.store.model.ProductInfo;
import com.online.store.service.CartService;

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService {
	@Autowired
	private ProductDao productDao;
	
	private HashMap<Long, CartInfo> cartItems;
	
	public CartServiceImpl() {
		this.cartItems = new HashMap<Long, CartInfo>();
	}
	
	public CartServiceImpl(HashMap<Long, CartInfo> cart) {
		this.cartItems = cart;
	}

	public HashMap<Long, CartInfo> getCartItems() {
		return cartItems;
	}

	public void setCartItems(HashMap<Long, CartInfo> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public void addItemToCart(Long productId) {
		ProductInfo product = this.productDao.getProductInfoById(productId);
		if(product != null) {
			if(this.cartItems.containsKey(productId)) {
				CartInfo item = this.cartItems.get(productId);
				item.setQuantity(item.getQuantity() + 1);
				item.setProductInfo(product);
				this.cartItems.put(productId, item);
			} else {
				CartInfo item = new CartInfo();
				item.setQuantity(1);
				item.setProductInfo(product);
				this.cartItems.put(productId, item);
			}
		}	
	}
	
	@Override
	public void updateCart(Long productId, Integer quantity) {
		ProductInfo product = this.productDao.getProductInfoById(productId);
		if(product != null) {
			CartInfo item = this.cartItems.get(productId);
			item.setQuantity(quantity);
			item.setProductInfo(product);
			this.cartItems.put(productId, item);
		}
	}

	@Override
	public void removeItemFromCart(Long productId) {
		this.cartItems.remove(productId);
	}

	@Override
	public void removeAllItem() {
		this.cartItems.clear();
	}

	@Override
	public Long totalPriceItem() {
		Long total = (long) 0;
		for(CartInfo cart : this.cartItems.values()) {
			total = total + (cart.getProductInfo().getProductPrice() * cart.getQuantity());
		}
		
		return total;
	}
	
	@Override
	public Integer totalQuantityItem() {
		Integer quantity = 0;
		for(CartInfo cart : this.cartItems.values()) {
			quantity = quantity + cart.getQuantity();
		}
		return quantity;
	}

	@Override
	public List<CartInfo> getListItems() {
		List<CartInfo> carts = new ArrayList<>();
		for(CartInfo cart : this.cartItems.values()) {
			carts.add(cart);
		}
		return carts;
	}
}
