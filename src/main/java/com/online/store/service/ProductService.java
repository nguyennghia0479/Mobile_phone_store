package com.online.store.service;

import java.util.List;

import com.online.store.model.ProductInfo;

public interface ProductService {
	List<ProductInfo> findAll();

	ProductInfo getProductInfoById(Long productId);

	ProductInfo getProductInfoByName(String productName);

	List<ProductInfo> searchAutocomplete(String keyword);

	List<ProductInfo> searchProductInfo(String keyword);
	
	List<ProductInfo> searchProductBySortBrand(String brand);
	
	List<ProductInfo> searchProductBySortPrice(String sort);
}
