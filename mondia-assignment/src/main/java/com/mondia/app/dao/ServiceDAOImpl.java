package com.mondia.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mondia.app.entity.Service;

/**
 * JPA DAO implementation for Service entity.
 *
 * @author Mohammed Mostafa
 * @version 1.00
 */
@Transactional
@Repository
public class ServiceDAOImpl implements ServiceDAO {

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Service> getAllServices() {
		TypedQuery<Service> query = entityManager.createNamedQuery("Service.findAll", Service.class);
		return (List<Service>) query.getResultList();
	}

	@Override
	public Service getServiceById(int id) {
		return entityManager.find(Service.class, id);
	}

	@Override
	public List<Service> getServicesByProductId(int productId) {
		TypedQuery<Service> query = entityManager.createNamedQuery("Service.findByProductId", Service.class);
		return (List<Service>) query.setParameter(1, productId).getResultList();

	}

	@Override
	public List<Service> getServicesByOperatorId(int operatorId) {
		TypedQuery<Service> query = entityManager.createNamedQuery("Service.findByOperatorId", Service.class);
		return (List<Service>) query.setParameter(1, operatorId).getResultList();
	}

	@Override
	public void addService(Service service) {
		entityManager.persist(service);

	}

	@Override
	public void updateService(Service service) {
		Service currentService = getServiceById(service.getId());
		currentService.setName(service.getName());
		currentService.setType(service.getType());
		currentService.setProductId(service.getProductId());
		currentService.setOperatorId(service.getOperatorId());
		currentService.setOperatorServiceId(service.getOperatorServiceId());
		currentService.setOperatorPackageId(service.getOperatorPackageId());
		entityManager.flush();

	}

	@Override
	public void deleteService(int id) {
		entityManager.remove(getServiceById(id));

	}

}
