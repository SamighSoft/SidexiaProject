/**
 * 
 */
package com.sidexia.service.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidexia.core.dao.ProductDao;
import com.sidexia.core.entities.Product;
import com.sidexia.service.ProductManager;

/**
 * @author SAMIR GHAOUTA
 *
 */
@Service("productManager")
public class ProductManagerImpl implements ProductManager {

	private transient ProductDao dao;

	@Autowired
	public ProductManagerImpl(ProductDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sidexia.service.GenericManager#getAll()
	 */
	public List<Product> getAll() {
		return dao.getAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sidexia.service.GenericManager#getAllDistinct()
	 */
	public List<Product> getAllDistinct() {
		return dao.getAllDistinct();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sidexia.service.ProductManager#saveProduct(com.sidexia.core.entities.
	 * Product)
	 */
	public Product saveProduct(Product product) {
		return dao.saveProduct(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sidexia.service.ProductManager#updateProduct(com.sidexia.core.
	 * entities.Product)
	 */
	public Product updateProduct(Product product) {
		return dao.updateProduct(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sidexia.service.ProductManager#removeProduct(java.lang.Long)
	 */
	public void removeProduct(Long ProductId) {
		dao.remove(ProductId);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sidexia.service.ProductManager#findProduct(java.lang.String)
	 */
	public Product findProduct(String labelProduct) {
		return dao.findProduct(labelProduct);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sidexia.service.ProductManager#getAllProducts()
	 */
	public List<Product> getAllProducts() {
		return dao.getAllProducts();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sidexia.service.ProductManager#getProductsByCategory(java.lang.Long)
	 */
	public List<Product> getProductsByCategory(Long categoryId) {
		return dao.getProductsByCategory(categoryId);
	}

}
