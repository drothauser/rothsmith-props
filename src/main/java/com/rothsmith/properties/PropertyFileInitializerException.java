/*
 * (c) 2012 FCCI Insurance Group All Rights Reserved.
 */
package com.rothsmith.properties;

/**
 * Class for raising exceptions during property file processing.
 * 
 * @author drothauser
 * 
 */
public class PropertyFileInitializerException
        extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public PropertyFileInitializerException() {
		super();
	}

	/**
	 * Construct PropertyFileInitializerException with an error message.
	 * 
	 * @param message
	 *            error message
	 */
	public PropertyFileInitializerException(String message) {
		super(message);
	}

	/**
	 * Construct PropertyFileInitializerException with the {@link Throwable}
	 * that caused the exception.
	 * 
	 * @param cause
	 *            {@link Throwable} that caused the exception.
	 */
	public PropertyFileInitializerException(Throwable cause) {
		super(cause);
	}

	/**
	 * Construct PropertyFileInitializerException with an error message and the
	 * cause.
	 * 
	 * @param message
	 *            error message
	 * @param cause
	 *            {@link Throwable} that caused the exception.
	 */
	public PropertyFileInitializerException(String message, Throwable cause) {
		super(message, cause);
	}

}
