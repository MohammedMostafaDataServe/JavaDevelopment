package com.mondia.app.bus;

/**
 * All business implementation specific exceptions must be wrapped by this
 * exception.
 *
 * @author Mohammed Mostafa
 * @version 1.00
 */
public class BusinessException extends Exception {

	/**
	 * Construct new BusinessException object.
	 */
	public BusinessException() {
		super();
	}

	/**
	 * Construct new BusinessException object.
	 * 
	 * @param msg
	 *            Exception error message.
	 */
	public BusinessException(String msg) {
		super(msg);
	}

}
