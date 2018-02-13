package com.mondia.app.service;

import java.util.List;

import com.mondia.app.entity.Operator;

/**
 * Service Interface for Operator entity.
 *
 * @author Mohammed Mostafa
 * @version 1.00
 */
public interface IOperatorService {
	
	List<Operator> getAllOperators();

	Operator getOperatorById(int id);
	
	Operator getOperatorByName(String name);

	boolean addOperator(Operator operator);

	void updateOperator(Operator operator);

	void deleteOperator(int id);

}
