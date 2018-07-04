/*
 * (c) 2012 FCCI Insurance Group All Rights Reserved.
 */
package com.rothsmith.environment;

import java.util.Map;

/**
 * Class for determining the current running environment (e.g. DEV,QA, etc.) as
 * defined in the OS's system environment.
 * 
 * @author drothauser
 * 
 */
public class SysEnvVarFinder implements EnvVarFinder {

	/**
	 * {@link Map} of system environment variables. Initially will reference
	 * {@link System#getenv()} that returns a map of system environment
	 * variables.
	 */
	private Map<String, String> envMap = System.getenv();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String fetchEnvVar(String envVarname) {

		// Set env to SANDBOX as a default.
		String env = Env.Names.SBX.name();

		String currEnv = envMap.get(envVarname);

		for (Env.Names envName : Env.Names.values()) {
			if (envName.name().equalsIgnoreCase(currEnv)) {
				env = currEnv;
				break;
			}
		}

		return env;

	}

	/**
	 * Set the {@link Map} that contains the system environment variables. By
	 * default, envMap will reference {@link System#getenv()}. This method will
	 * override that assignment and will generally be used for unit testing.
	 * 
	 * @param envMap
	 *            the envMap to set
	 */
	public void setEnvMap(Map<String, String> envMap) {
		this.envMap = envMap;
	}
}
