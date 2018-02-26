package com.mondia.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mondia.app.dao.ProductDAO;
import com.mondia.app.entity.Product;

/**
 * Service implementation for Product entity.
 *
 * @author Mohammed Mostafa
 * @version 1.00
 */
@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}

	@Override
	public Product getProductById(int id) {
		return productDAO.getProductById(id);
	}

	@Override
	public synchronized boolean addProduct(Product product) {
		if (productDAO.ProductExist(product.getName())) {
			return false;
		}
		productDAO.addProduct(product);
		return true;
	}

	@Override
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);

	}

	@Override
	public void deleteProduct(int productId) {
		productDAO.deleteProduct(productId);

	}

}
