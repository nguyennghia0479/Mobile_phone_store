package com.online.store.dao;

import java.util.List;

import com.online.store.entity.Product;
import com.online.store.model.ProductInfo;

public interface ProductDao {
	List<ProductInfo> findAll();
	
	Product getProductById(Long productId);
	
	Product getProductByName(String productName);
	
	ProductInfo getProductInfoById(Long productId);
	
	ProductInfo getProductInfoByName(String productName);
	
	List<ProductInfo> searchAutocomplete(String keyword);
	
	List<ProductInfo> searchProductInfo(String keyword);
	
	List<ProductInfo> searchProductBySortBrand(String brand);
	
	List<ProductInfo> searchProductBySortPrice(String sort);
}
