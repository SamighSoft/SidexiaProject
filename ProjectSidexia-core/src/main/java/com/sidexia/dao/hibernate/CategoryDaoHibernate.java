package com.sidexia.dao.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sidexia.core.dao.CategoryDao;
import com.sidexia.core.entities.Category;

/**
 * @author SAMIR GHAOUTA
 *
 */
@Repository("categoryDao")
public class CategoryDaoHibernate extends GenericDaoHibernate<Category, Long> implements CategoryDao {
	/**
	 * Constructor that sets the entity to Category class.
	 */
	public CategoryDaoHibernate() {
		super(Category.class);
	}

	@Override
	public Category saveCategory(Category category) {
		if (category == null) {
			return null;
		}
		return saveCategory(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return this.saveCategory(category);
	}

	@Override
	public void removeCategory(Long categoryId) {
		remove(categoryId);

	}

	@Override
	public Category findCategory(String labelCategory) {
		final Map<String, Object> args = new HashMap<String, Object>();
		args.put("labelCategory", labelCategory);
		// get category using namedQuery
		final List<Category> categories = findByNamedQuery("findCategoryByLabel", args);
		if (categories != null && !categories.isEmpty()) {
			return categories.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Category> getAllCatgories() {
		return getAll();
	}

}
