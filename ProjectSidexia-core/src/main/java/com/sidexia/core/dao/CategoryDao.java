/**
 * 
 */
package com.sidexia.core.dao;

import java.util.List;

import com.sidexia.core.entities.Category;

/**
 * @author SAMIR GHAOUTA
 *
 */
public interface CategoryDao extends GenericDao<Category, Long> {

	/**
	 * to save a category
	 * 
	 * @param category
	 * @return the persisted object
	 */
	public Category saveCategory(Category category);

	/**
	 * to save a category
	 * 
	 * @param category
	 * @return the persisted object
	 */
	public Category updateCategory(Category category);

	/**
	 * to remove a category
	 * 
	 * @param categoryId
	 */
	public void removeCategory(Long categoryId);

	/**
	 * get a specific category
	 * 
	 * @return List of populated categories
	 */
	public Category findCategory(String labelCategory);

	/**
	 * used to get all categories
	 * 
	 * @return List of populated categories
	 */
	public List<Category> getAllCatgories();

}
