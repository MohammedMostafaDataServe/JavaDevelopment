package com.mondia.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mondia.app.entity.Product;

/**
 * JPA DAO implementation for Product entity.
 *
 * @author Mohammed Mostafa
 * @version 1.00
 */
@Transactional
@Repository
public class ProductDAOImpl implements ProductDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Product> getAllProducts() {
		TypedQuery<Product> query = entityManager.createNamedQuery("Product.findAll", Product.class);
		return (List<Product>) query.getResultList();
	}

	@Override
	public Product getProductById(int id) {
		return entityManager.find(Product.class, id);
	}

	@Override
	public Product getProductByName(String name) {
		return entityManager.find(Product.class, name);
	}

	@Override
	public void addProduct(Product product) {
		entityManager.persist(product);

	}

	@Override
	public void updateProduct(Product product) {
		Product currentProduct = getProductById(product.getId());
		currentProduct.setName(product.getName());
		currentProduct.setDescription(product.getDescription());
		currentProduct.setMinPrice(product.getMinPrice());
		currentProduct.setMaxPrice(product.getMaxPrice());
		currentProduct.setServicesList(product.getServicesList());
		entityManager.flush();

	}

	@Override
	public void deleteProduct(int id) {
		entityManager.remove(getProductById(id));

	}

	@Override
	public boolean ProductExist(String name) {
		TypedQuery<Product> query = entityManager.createNamedQuery("Product.findByName", Product.class);
		int count = query.setParameter(1, name).getResultList().size();
		return count > 0 ? true : false;
	}

}
