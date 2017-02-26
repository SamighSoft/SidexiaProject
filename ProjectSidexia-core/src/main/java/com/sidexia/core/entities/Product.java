package com.sidexia.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author GHAOUTA SAMIR
 *
 */
@Entity
@Table(name = "product")
@NamedQueries({
		@NamedQuery(name = "findProductByLabel", query = "select p from Product p where p.labelProduct = :labelProduct "),
		@NamedQuery(name = "findProductByCategory", query = "select p from Product p ,Category c where p.category.idCategory=:idCategory and p.category.idCategory=c.idCategory") })
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5375249590022039408L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProduct;
	@Column(nullable = false, length = 25)
	private String labelProduct;
	@Column(nullable = false)
	private double price;
	@Column(nullable = false)
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Product() {
		super();
	}

	public Product(String labelProduct, double price, int quantity) {
		super();
		this.labelProduct = labelProduct;
		this.price = price;
		this.quantity = quantity;
	}

	/**
	 * @return the idProduct
	 */
	public long getIdProduct() {
		return idProduct;
	}

	/**
	 * @param idProduct
	 *            the idProduct to set
	 */
	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	/**
	 * @return the labelProduct
	 */
	public String getLabelProduct() {
		return labelProduct;
	}

	/**
	 * @param labelProduct
	 *            the labelProduct to set
	 */
	public void setLabelProduct(String labelProduct) {
		this.labelProduct = labelProduct;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idProduct ^ (idProduct >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (idProduct != other.idProduct)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", labelProduct=" + labelProduct + ", price=" + price + ", quantity="
				+ quantity + "]";
	}

}
