package com.online.store.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.online.store.dao.BillDao;
import com.online.store.entity.Bill;
import com.online.store.entity.Product;
import com.online.store.model.BillInfo;
import com.online.store.model.ProductInfo;

@Repository("billDao")
public class BillDaoImpl implements BillDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void saveBill(BillInfo billInfo) {
		Bill bill = new Bill();
		List<Product> products = new ArrayList<>();
		Product product = null;
		for(ProductInfo pro: billInfo.getProducts()) {
			Long productId = pro.getProductId();
			product = new Product(productId);
			products.add(product);
		}
		bill.setFullName(billInfo.getFullName());
		bill.setShippingAddress(billInfo.getShippingAddress());
		bill.setPhoneNumber(billInfo.getPhoneNumber());
		bill.setEmail(billInfo.getEmail());
		bill.setTotalPrice(billInfo.getTotalPrice());
		bill.setTotalQuantity(billInfo.getTotalQuantity());
		bill.setPaymnet(billInfo.getPayment());
		bill.setBillDate(new Date());
		bill.setProducts(products);
		this.entityManager.persist(bill);
		this.entityManager.flush();
	}
}
