package com.mondia.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mondia.app.dao.OperatorDAO;
import com.mondia.app.entity.Operator;

/**
 * Service implementation for Operator entity.
 *
 * @author Mohammed Mostafa
 * @version 1.00
 */
@Service
public class OperatorService implements IOperatorService {

	@Autowired
	OperatorDAO operatorDAO;

	@Override
	public List<Operator> getAllOperators() {
		return operatorDAO.getAllOperators();
	}

	@Override
	public Operator getOperatorById(int id) {
		return operatorDAO.getOperatorById(id);
	}

	@Override
	public Operator getOperatorByName(String name) {
		return operatorDAO.getOperatorByName(name);
	}

	@Override
	public synchronized boolean addOperator(Operator operator) {
		if (operatorDAO.OperatorExist(operator.getName())) {
			return false;
		} else {
			operatorDAO.addOperator(operator);
			return true;

		}
	}

	@Override
	public void updateOperator(Operator operator) {
		operatorDAO.updateOperator(operator);

	}

	@Override
	public void deleteOperator(int id) {
		operatorDAO.deleteOperator(id);

	}

}
