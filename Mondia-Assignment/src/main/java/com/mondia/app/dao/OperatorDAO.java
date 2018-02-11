package com.mondia.app.dao;

import java.util.List;

import com.mondia.app.entity.Operator;

/**
 * Data access object interface for Operator entity.
 * 
 * @author Mohammed Mostafa
 *
 */
public interface OperatorDAO {
	
	List<Operator> getAllOperators();

	Operator getOperatorById(int id);
	
	Operator getOperatorByName(String name);

	void addOperator(Operator operator);

	void updateOperator(Operator operator);

	void deleteOperator(int id);

	boolean OperatorExist(String name);

}
