package com.mondia.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mondia.app.entity.Operator;

/**
 * JPA DAO implementation for Operator entity.
 *
 * @author Mohammed Mostafa
 * @version 1.00
 */
@Transactional
@Repository
public class OperatorDAOImpl implements OperatorDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Operator> getAllOperators() {
		TypedQuery<Operator> query = entityManager.createNamedQuery("Operator.findAll", Operator.class);
		return (List<Operator>) query.getResultList();
	}

	@Override
	public Operator getOperatorById(int id) {
		return entityManager.find(Operator.class, id);
	}

	@Override
	public Operator getOperatorByName(String name) {
		return entityManager.find(Operator.class, name);
	}

	@Override
	public void addOperator(Operator operator) {
		entityManager.persist(operator);

	}

	@Override
	public void updateOperator(Operator operator) {
		Operator currentOperator = getOperatorById(operator.getId());
		currentOperator.setName(operator.getName());
		currentOperator.setCountry(operator.getCountry());
		currentOperator.setOperatorServiceFlag(operator.getOperatorServiceFlag());
		currentOperator.setOperatorPackageFlag(operator.getOperatorPackageFlag());
		currentOperator.setServicesList(operator.getServicesList());
		entityManager.flush();

	}

	@Override
	public void deleteOperator(int id) {
		entityManager.remove(getOperatorById(id));

	}

	@Override
	public boolean OperatorExist(String name) {
		TypedQuery<Operator> query = entityManager.createNamedQuery("Operator.findByName", Operator.class);
		int count = query.setParameter(1, name).getResultList().size();
		return count > 0 ? true : false;
	}

}
