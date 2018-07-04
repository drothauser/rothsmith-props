/*
 * (c) 2012 FCCI Insurance Group All Rights Reserved.
 */
package com.rothsmith.environment;

/**
 * Stores the value of the FCCI environment variable, {@value #FCCI_ENV_VARNAME}
 * , as defined in the OS's system environment. The value will be one of the
 * following:
 * 
 * <ul>
 * <li>{@link FcciEnvs#SBX} - Sandbox/local testing</li>
 * <li>{@link FcciEnvs#DEV} - Development environment</li>
 * <li>{@link FcciEnvs#TST} - Testing environment</li>
 * <li>{@link FcciEnvs#QA} &nbsp; - QA environment</li>
 * <li>{@link FcciEnvs#STG} - Staging/Pre-production environment</li>
 * <li>{@link FcciEnvs#UAT} - User Acceptance Testing (pre-production)
 * environment constant.</li>
 * <li>{@link FcciEnvs#PRD} - Production Environment</li>
 * </ul>
 * 
 * See {@link FcciEnvs} for more information on the environment values.
 * 
 * @author drothauser
 * 
 */
public enum Env {

	/**
	 * Enum singleton instance.
	 */
	INSTANCE;

	/**
	 * Environment variable name that will contain the value of the current
	 * running system.
	 */
	public static final String FCCI_ENV_VARNAME = "FCCI_ENV";

	/**
	 * Environment name of the currently running system.
	 */
	private final String env =
	    new SysEnvVarFinder().fetchEnvVar(FCCI_ENV_VARNAME);

	/**
	 * Get the environment variable of the currently running system.
	 * 
	 * @return one of the following values:
	 *         <ul>
	 *         <li>{@link #SBX} - Sandbox/local testing</li>
	 *         <li>{@link #DEV} - Development environment</li>
	 *         <li>{@link #TST} - Testing environment</li>
	 *         <li>{@link #QA} &nbsp; - QA environment</li>
	 *         <li>{@link #STG} - Staging/Pre-PRD environment</li>
	 *         <li>{@link #UAT} - User Acceptance Testing (pre-production)
	 *         environment constant.</li>
	 *         <li>{@link #PRD} - Production Environment</li>
	 *         </ul>
	 */
	public static String getEnv() {
		return INSTANCE.env;
	}

	/**
	 * An enumeration of environment names used at FCCI.
	 * 
	 * <ul>
	 * <li>{@link #SBX} - Sandbox/local testing</li>
	 * <li>{@link #DEV} - Development environment</li>
	 * <li>{@link #TST} - Testing environment</li>
	 * <li>{@link #QA} &nbsp; - QA environment</li>
	 * <li>{@link #STG} - Staging/Pre-production environment</li>
	 * <li>{@link #UAT} - User Acceptance Testing (pre-production) environment
	 * constant.</li>
	 * <li>{@link #PRD} - Production Environment</li>
	 * </ul>
	 */
	public enum Names {

		/**
		 * Sandbox environment constant.
		 */
		SBX(),

		/**
		 * Development environment constant.
		 */
		DEV,

		/**
		 * Test environment constant.
		 */
		TST,

		/**
		 * QA environment constant.
		 */
		QA,


		/**
		 * Training environment constant.
		 */
		TRN,


		/**
		 * Staging environment constant.
		 * 
		 * @deprecated Use UAT instead.
		 */
		@Deprecated
		STG,

		/**
		 * User Acceptance Testing (pre-production) environment constant.
		 */
		UAT,

		/**
		 * Production environment constant.
		 */
		PRD;

	}

}
