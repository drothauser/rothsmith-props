/*
 * (c) 2012 FCCI Insurance Group All Rights Reserved.
 */
package com.rothsmith.environment;

/**
 * Interface for looking up the current running environment designation e.g.
 * DEV, QA, etc.
 * 
 * @version $Id: EnvVarFinder.java 634 2012-08-08 00:26:24Z drarch $
 * 
 * @author drothauser
 * 
 */
public interface EnvVarFinder {

	/**
	 * This method returns the value of of the given environment variable name.
	 * 
	 * @param envVarname
	 *            environment variable name e.g. 'FCCI_ENV'
	 * 
	 * @return The value of environment variable name.
	 */
	String fetchEnvVar(String envVarname);

}