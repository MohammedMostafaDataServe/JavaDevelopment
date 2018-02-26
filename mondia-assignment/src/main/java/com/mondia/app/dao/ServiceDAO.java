package com.mondia.app.dao;

import java.util.List;

import com.mondia.app.entity.Service;

/**
 * Data access object interface for Service entity.
 * 
 * @author Mohammed Mostafa
 *
 */
public interface ServiceDAO {

	List<Service> getAllServices();

	Service getServiceById(int id);

	List<Service> getServicesByProductId(int productId);

	List<Service> getServicesByOperatorId(int operatorId);

	void addService(Service service);

	void updateService(Service service);

	void deleteService(int id);

}
