package com.mondia.app.dao;

import java.util.List;

import com.mondia.app.entity.Product;

/**
 * Data access object interface for Product entity.
 * 
 * @author Mohammed Mostafa
 *
 */
public interface ProductDAO {

	List<Product> getAllProducts();

	Product getProductById(int id);
	
	Product getProductByName(String name);

	void addProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(int id);

	boolean ProductExist(String name);

}
