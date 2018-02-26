package com.mondia.app.service;

import java.util.List;

import com.mondia.app.entity.Product;

/**
 * Service Interface for Produce entity.
 *
 * @author Mohammed Mostafa
 * @version 1.00
 */
public interface IProductService {
	
	List<Product> getAllProducts();

	Product getProductById(int id);

	boolean addProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(int productId);


}
