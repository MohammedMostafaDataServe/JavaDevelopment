package com.mondia.app.service;

import java.util.List;

import com.mondia.app.bus.BusinessException;
import com.mondia.app.entity.Service;

/**
 * Service Interface for Service entity.
 *
 * @author Mohammed Mostafa
 * @version 1.00
 */
public interface IServiceService {
	
	List<Service> getAllServices();

	Service getServiceById(int id);

	List<Service> getServicesByProductId(int productId);

	List<Service> getServicesByOperatorId(int operatorId);

	boolean addService(Service service) throws BusinessException;

	void updateService(Service service);

	void deleteService(int id);

}
