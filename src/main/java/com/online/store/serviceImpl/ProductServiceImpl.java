package com.online.store.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.store.dao.ProductDao;
import com.online.store.model.ProductInfo;
import com.online.store.service.ProductService;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public List<ProductInfo> findAll() {
		return this.productDao.findAll();
	}

	@Override
	public ProductInfo getProductInfoById(Long productId) {
		return this.productDao.getProductInfoById(productId);
	}

	@Override
	public ProductInfo getProductInfoByName(String productName) {
		return this.productDao.getProductInfoByName(productName);
	}

	@Override
	public List<ProductInfo> searchAutocomplete(String keyword) {
		return this.productDao.searchAutocomplete(keyword);
	}

	@Override
	public List<ProductInfo> searchProductInfo(String keyword) {
		return this.productDao.searchProductInfo(keyword);
	}

	@Override
	public List<ProductInfo> searchProductBySortPrice(String sort) {
		return this.productDao.searchProductBySortPrice(sort);
	}

	@Override
	public List<ProductInfo> searchProductBySortBrand(String brand) {
		return this.productDao.searchProductBySortBrand(brand);
	}
}
