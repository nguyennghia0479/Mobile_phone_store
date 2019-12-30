package com.online.store.entity;

import java.io.Serializable;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "IMAGE")
public class Image implements Serializable, Comparable<Image> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IMAGE_ID")
	private Long imageId;
	
	@Column(name = "IMAGE", nullable = false, length = Integer.MAX_VALUE)
	private byte[] image;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID", nullable = false, foreignKey = @ForeignKey(name = "IMAGE_PRODUCT_ID"))
	private Product product;
	
	public Image() {
	}

	public Image(Long imageId, byte[] image) {
		this.imageId = imageId;
		this.image = image;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Transient
	public String getBase64() {
		return Base64.getEncoder().encodeToString(image);
	}

	@Override
	public int compareTo(Image o) {
		return this.getImageId().compareTo(o.getImageId());
	}
}
