/**
 * 
 */
package com.sidexia.core.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author GHAOUTA SAMIR
 *
 */
@Entity
@Table(name = "category")
@NamedQueries({ @NamedQuery(name = "findCategoryByLabel", query = "select c from Category c where c.labelCategory = :labelCategory ") })
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6889764693418598940L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategory;
	@Column(nullable = false, length = 30)
	private String labelCategory;
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Product> productList;

	public Category() {
		super();
	}

	public Category(String labelCategory) {
		super();
		this.labelCategory = labelCategory;
	}

	/**
	 * @return the idCategory
	 */
	public long getIdCategory() {
		return idCategory;
	}

	/**
	 * @param idCategory
	 *            the idCategory to set
	 */
	public void setidCategory(long idCategory) {
		this.idCategory = idCategory;
	}

	/**
	 * @return the labelCategory
	 */
	public String getLabelCategory() {
		return labelCategory;
	}

	/**
	 * @param labelCategory
	 *            the labelCategory to set
	 */
	public void setLabelCategory(String labelCategory) {
		this.labelCategory = labelCategory;
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
		result = prime * result + (int) (idCategory ^ (idCategory >>> 32));
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
		Category other = (Category) obj;
		if (idCategory != other.idCategory)
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
		return "Category [idCategory=" + idCategory + ", labelCategory=" + labelCategory + "]";
	}

}
