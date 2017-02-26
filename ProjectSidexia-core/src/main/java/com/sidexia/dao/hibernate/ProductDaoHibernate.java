package com.sidexia.dao.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sidexia.core.dao.ProductDao;
import com.sidexia.core.entities.Product;

/**
 * @author SAMIR GHAOUTA
 *
 */
@Repository("productDao")
public class ProductDaoHibernate extends GenericDaoHibernate<Product, Long> implements ProductDao {
	/**
	 * Constructor that sets the entity to Product class.
	 */
	public ProductDaoHibernate() {
		super(Product.class);
	}

	@Override
	public Product saveProduct(Product Product) {
		if (Product == null) {
			return null;
		}
		return saveProduct(Product);
	}

	@Override
	public Product updateProduct(Product Product) {
		return this.saveProduct(Product);
	}

	@Override
	public void removeProduct(Long ProductId) {
		remove(ProductId);

	}

	@Override
	public Product findProduct(String labelProduct) {
		final Map<String, Object> args = new HashMap<String, Object>();
		args.put("labelProduct", labelProduct);
		// get Product using namedQuery
		final List<Product> categories = findByNamedQuery("findProductByLabel", args);
		if (categories != null && !categories.isEmpty()) {
			return categories.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Product> getAllProducts() {
		return getAll();
	}

	@Override
	public List<Product> getProductsByCategory(Long idCategory) {
		final Map<String, Object> args = new HashMap<String, Object>();
		args.put("idCategory", idCategory);
		// get Product by category using namedQuery
		return findByNamedQuery("findProductByLabel", args);

	}

}
