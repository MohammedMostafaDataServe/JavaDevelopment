package com.mondia.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mondia.app.bus.BusinessException;
import com.mondia.app.dao.ServiceDAO;
import com.mondia.app.entity.Service;

/**
 * Service implementation for Service entity.
 *
 * @author Mohammed Mostafa
 * @version 1.00
 */
@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {

	@Autowired
	ServiceDAO serviceDAO;

	@Override
	public List<Service> getAllServices() {
		return serviceDAO.getAllServices();
	}

	@Override
	public Service getServiceById(int id) {
		return serviceDAO.getServiceById(id);
	}

	@Override
	public List<Service> getServicesByProductId(int productId) {
		return serviceDAO.getServicesByProductId(productId);
	}

	@Override
	public List<Service> getServicesByOperatorId(int operatorId) {
		return serviceDAO.getServicesByOperatorId(operatorId);
	}

	@Override
	public synchronized boolean addService(Service service) throws BusinessException {
		// Businenss rules for service
		if (service.getOperatorId().isOperatorServiceMandatory()) {
			if (service.getOperatorServiceId() == null) {
				throw new BusinessException(
						"Operator Service ID is mandatory for this opeartor:" + service.getOperatorId().getId());
			}
		}
		if (service.getOperatorId().isOperatorPackageMandatory()) {
			if (service.getOperatorPackageId() == null) {
				throw new BusinessException(
						"Operator Pacakge ID is mandatory for this opeartor:" + service.getOperatorId().getId());
			}
		}
		serviceDAO.addService(service);
		return true;
	}

	@Override
	public void updateService(Service service) {
		serviceDAO.updateService(service);

	}

	@Override
	public void deleteService(int id) {
		serviceDAO.deleteService(id);

	}

}
