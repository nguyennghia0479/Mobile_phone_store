package com.online.store.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.online.store.dao.ProductDao;
import com.online.store.entity.Product;
import com.online.store.model.ProductInfo;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager entityManager;

	private void getPathProductInfo(CriteriaQuery<Object[]> query, Root<Product> rootProduct) {
		Path<Long> productId = rootProduct.get("productId");
		Path<String> productName = rootProduct.get("productName");
		Path<Long> productPrice = rootProduct.get("productPrice");
		Path<byte[]> avatar = rootProduct.get("avatar");
		Path<String> productNameURL = rootProduct.get("productNameURL");
		query.multiselect(productId, productName, productPrice, avatar, productNameURL);
	}

	private void querySortPrice(CriteriaBuilder builder, CriteriaQuery<Object[]> query, String sort,
			Path<Long> productPrice) {
		Long lowestPrice = (long) 0;
		Long highestPrice = (long) 0;
		if (sort.equals("u3")) {
			lowestPrice = (long) 3000000;
			query.where(builder.lessThan(productPrice, lowestPrice));
		} else if (sort.equals("f3t5")) {
			lowestPrice = (long) 3000000;
			highestPrice = (long) 5000000;
			query.where(builder.or(builder.ge(productPrice, lowestPrice)), builder.le(productPrice, highestPrice));
		} else if (sort.equals("f5t10")) {
			lowestPrice = (long) 5000000;
			highestPrice = (long) 10000000;
			query.where(builder.or(builder.ge(productPrice, lowestPrice)), builder.le(productPrice, highestPrice));
		} else if (sort.equals("f10t15")) {
			lowestPrice = (long) 10000000;
			highestPrice = (long) 15000000;
			query.where(builder.or(builder.ge(productPrice, lowestPrice)), builder.le(productPrice, highestPrice));
		} else {
			highestPrice = (long) 15000000;
			query.where(builder.greaterThan(productPrice, highestPrice));
		}
	}

	private String trimString(String keyword) {
		String newString = keyword;
		if (keyword.contains("-")) {
			newString = keyword.replace("-", " ");
		}
		return newString;
	}

	private List<ProductInfo> converObjectToProductInfo(List<Object[]> objects) {
		List<ProductInfo> products = new ArrayList<>();
		ProductInfo product = null;
		for (Object[] values : objects) {
			Long productId = (Long) values[0];
			String productName = (String) values[1];
			Long productPrice = (Long) values[2];
			byte[] avatar = (byte[]) values[3];
			String productNameURL = (String) values[4];
			product = new ProductInfo(productId, productName, productPrice, avatar, productNameURL);
			products.add(product);
		}
		return products;
	}

	@Override
	public List<ProductInfo> findAll() {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
		Root<Product> rootProduct = query.from(Product.class);
		getPathProductInfo(query, rootProduct);
		query.orderBy(builder.asc(rootProduct.get("productName")));
		List<Object[]> objects = this.entityManager.createQuery(query).getResultList();
		List<ProductInfo> products = converObjectToProductInfo(objects);
		return products;
	}

	@Override
	public Product getProductById(Long productId) {
		Product product = this.entityManager.find(Product.class, productId);
		return product;
	}

	@Override
	public ProductInfo getProductInfoById(Long productId) {
		Product product = getProductById(productId);
		if (product == null) {
			return null;
		}
		return new ProductInfo(product.getProductId(), product.getProductName(), product.getProductPrice(),
				product.getAvatar());
	}

	@Override
	public Product getProductByName(String productName) {
		productName = trimString(productName);
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> query = builder.createQuery(Product.class);
		Root<Product> rootProduct = query.from(Product.class);
		query.select(rootProduct).where(builder.like(rootProduct.get("productName"), productName));
		rootProduct.fetch("images");
		List<Product> products = this.entityManager.createQuery(query).getResultList();
		if (products.isEmpty()) {
			return null;
		}
		Product product = products.get(0);
		return product;
	}

	@Override
	public ProductInfo getProductInfoByName(String productName) {
		Product product = getProductByName(productName);
		if (product == null) {
			return null;
		}
		return new ProductInfo(product.getProductId(), product.getProductName(), product.getProductPrice(),
				product.getBrand(), product.getColor(), product.getGuarantee(), product.getTypeScreen(),
				product.getResolution(), product.getFrontCamera(), product.getRearCamera(), product.getChip(),
				product.getRam(), product.getStorage(), product.getBattery(), product.getOperatingSystem(),
				product.getAvatar(), product.getImages());
	}

	@Override
	public List<ProductInfo> searchAutocomplete(String keyword) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<ProductInfo> query = builder.createQuery(ProductInfo.class);
		Root<Product> rootProduct = query.from(Product.class);
		Path<String> productName = rootProduct.get("productName");
		Path<byte[]> avatar = rootProduct.get("avatar");
		Path<String> productNameURL = rootProduct.get("productNameURL");
		query.multiselect(productName, avatar, productNameURL);
		query.where(builder.like(productName, "%" + keyword + "%"));
		List<ProductInfo> products = this.entityManager.createQuery(query).setMaxResults(5).getResultList();
		return products;
	}

	@Override
	public List<ProductInfo> searchProductInfo(String keyword) {
		keyword = trimString(keyword);
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
		Root<Product> rootProduct = query.from(Product.class);
		getPathProductInfo(query, rootProduct);
		query.where(builder.like(rootProduct.get("productName"), "%" + keyword + "%"));
		List<Object[]> objects = this.entityManager.createQuery(query).getResultList();
		List<ProductInfo> products = converObjectToProductInfo(objects);
		return products;
	}

	@Override
	public List<ProductInfo> searchProductBySortPrice(String sort) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
		Root<Product> rootProduct = query.from(Product.class);
		getPathProductInfo(query, rootProduct);
		query.orderBy(builder.asc(rootProduct.get("productPrice")));
		querySortPrice(builder, query, sort, rootProduct.get("productPrice"));
		List<Object[]> objects = this.entityManager.createQuery(query).getResultList();
		List<ProductInfo> products = converObjectToProductInfo(objects);
		return products;
	}

	@Override
	public List<ProductInfo> searchProductBySortBrand(String sortBrand) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
		Root<Product> rootProduct = query.from(Product.class);
		getPathProductInfo(query, rootProduct);
		Path<String> brand = rootProduct.get("brand");
		query.where(builder.like(brand, sortBrand));
		List<Object[]> objects = this.entityManager.createQuery(query).getResultList();
		List<ProductInfo> products = converObjectToProductInfo(objects);
		return products;
	}
}
