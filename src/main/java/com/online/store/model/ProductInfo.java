package com.online.store.model;

import java.util.Base64;
import java.util.Set;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.online.store.entity.Comment;
import com.online.store.entity.Image;

public class ProductInfo {
	private Long productId;
	private String productName;
	private Long productPrice;
	private String brand;
	private String color;
	private Integer guarantee;
	private String typeScreen;
	private String resolution;
	private String frontCamera;
	private String rearCamera;
	private String chip;
	private Integer ram;
	private Integer storage;
	private Integer battery;
	private String operatingSystem;
	private byte[] avatar;
	private CommonsMultipartFile file;
	private String productNameURL;
	private Set<Image> images;
	private Set<Comment> comments;

	public ProductInfo() {

	}

	public ProductInfo(String productName, byte[] avatar, String productNameURL) {
		this.productName = productName;
		this.avatar = avatar;
		this.productNameURL = productNameURL;
	}

	public ProductInfo(Long productId, String productName, Long productPrice, byte[] avatar) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.avatar = avatar;
	}

	public ProductInfo(Long productId, String productName, Long productPrice, byte[] avatar, String productNameURL) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.avatar = avatar;
		this.productNameURL = productNameURL;
	}

	public ProductInfo(Long productId, String productName, Long productPrice, String brand, String color,
			Integer guarantee, String typeScreen, String resolution, String frontCamera, String rearCamera, String chip,
			Integer ram, Integer storage, Integer battery, String operatingSystem, byte[] avatar, Set<Image> images) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.brand = brand;
		this.color = color;
		this.guarantee = guarantee;
		this.typeScreen = typeScreen;
		this.resolution = resolution;
		this.frontCamera = frontCamera;
		this.rearCamera = rearCamera;
		this.chip = chip;
		this.ram = ram;
		this.storage = storage;
		this.battery = battery;
		this.operatingSystem = operatingSystem;
		this.avatar = avatar;
		this.images = images;
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

	public CommonsMultipartFile getFile() {
		return file;
	}

	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}

	public String getBase64() {
		return Base64.getEncoder().encodeToString(avatar);
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
