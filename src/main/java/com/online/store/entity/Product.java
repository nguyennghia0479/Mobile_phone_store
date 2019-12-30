package com.online.store.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private Long productId;

	@Column(name = "PRODUCT_NAME", nullable = false)
	private String productName;

	@Column(name = "PRODUCT_PRICE", nullable = false)
	private Long productPrice;

	@Column(name = "BRAND", nullable = false, length = 30)
	private String brand;

	@Column(name = "COLOR", nullable = false, length = 20)
	private String color;

	@Column(name = "GUARANTEE", nullable = false)
	private Integer guarantee;

	@Column(name = "TYPE_SCREEN", nullable = false, length = 20)
	private String typeScreen;

	@Column(name = "RESOLUTION", nullable = false, length = 20)
	private String resolution;

	@Column(name = "FRONT_CAMERA", nullable = false, length = 20)
	private String frontCamera;

	@Column(name = "REAR_CAMERA", nullable = false, length = 20)
	private String rearCamera;

	@Column(name = "CHIP", nullable = false, length = 20)
	private String chip;

	@Column(name = "RAM", nullable = false)
	private Integer ram;

	@Column(name = "STORAGE", nullable = false)
	private Integer storage;

	@Column(name = "BATTERY", nullable = false)
	private Integer battery;

	@Column(name = "OPERATING_SYSTEM", nullable = false, length = 20)
	private String operatingSystem;

	@Column(name = "AVATAR", nullable = false, length = Integer.MAX_VALUE)
	private byte[] avatar;

	@Column(name = "PRODUCT_NAME_URL", nullable = false)
	private String productNameURL;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private Set<Image> images = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private Set<Comment> comments = new HashSet<>();

	public Product() {
	}
	
	public Product(Long productId) {
		this.productId = productId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getGuarantee() {
		return guarantee;
	}

	public void setGuarantee(Integer guarantee) {
		this.guarantee = guarantee;
	}

	public String getTypeScreen() {
		return typeScreen;
	}

	public void setTypeScreen(String typeScreen) {
		this.typeScreen = typeScreen;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getFrontCamera() {
		return frontCamera;
	}

	public void setFrontCamera(String frontCamera) {
		this.frontCamera = frontCamera;
	}

	public String getRearCamera() {
		return rearCamera;
	}

	public void setRearCamera(String rearCamera) {
		this.rearCamera = rearCamera;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public Integer getRam() {
		return ram;
	}

	public void setRam(Integer ram) {
		this.ram = ram;
	}

	public Integer getStorage() {
		return storage;
	}

	public void setStorage(Integer storage) {
		this.storage = storage;
	}

	public Integer getBattery() {
		return battery;
	}

	public void setBattery(Integer battery) {
		this.battery = battery;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public String getProductNameURL() {
		return productNameURL;
	}

	public void setProductNameURL(String productNameURL) {
		this.productNameURL = productNameURL;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
}
