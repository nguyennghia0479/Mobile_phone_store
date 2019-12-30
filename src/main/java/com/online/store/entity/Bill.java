package com.online.store.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BILL")
public class Bill implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BILL_ID")
	private Long billId;

	@Column(name = "FULL_NAME", nullable = false)
	private String fullName;

	@Column(name = "SHIPPING_ADDRESS", nullable = false)
	private String shippingAddress;

	@Column(name = "PHONE_NUMBER", nullable = false, length = 11)
	private String phoneNumber;

	@Column(name = "EMAIL", nullable = true)
	private String email;

	@Column(name = "BILL_DATE", nullable = false)
	private Date billDate;

	@Column(name = "TOTAL_PRICE", nullable = false)
	private Long totalPrice;

	@Column(name = "TOTAL_QUANTITY", nullable = false)
	private Integer totalQuantity;

	@Column(name = "PAYMENT", nullable = false)
	private String paymnet;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "BILL_PRODUCT", joinColumns = { @JoinColumn(name = "BILL_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "PRODUCT_ID") })
	private List<Product> products = new ArrayList<>();

	public Bill() {
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public String getPaymnet() {
		return paymnet;
	}

	public void setPaymnet(String paymnet) {
		this.paymnet = paymnet;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
