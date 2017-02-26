/**
 * 
 */
package com.sidexia.core.dao;

import java.util.List;

import com.sidexia.core.entities.Product;

/**
 * @author SAMIR GHAOUTA
 *
 */
public interface ProductDao extends GenericDao<Product, Long> {

	/**
	 * to save a product
	 * 
	 * @param product
	 * @return the persisted object
	 */
	public Product saveProduct(Product product);

	/**
	 * to update a Product
	 * 
	 * @param Product
	 * @return the updated object
	 */
	public Product updateProduct(Product product);

	/**
	 * to remove a Product
	 * 
	 * @param ProductId
	 */
	public void removeProduct(Long ProductId);

	/**
	 * get a specific Product
	 * 
	 * @return List of populated categories
	 */
	public Product findProduct(String labelProduct);

	/**
	 * used to get all categories
	 * 
	 * @return List of populated categories
	 */
	public List<Product> getAllProducts();

	/**
	 * used to get products of a specified category
	 * 
	 * @return List of populated categories
	 */
	public List<Product> getProductsByCategory(Long categoryId);

}
