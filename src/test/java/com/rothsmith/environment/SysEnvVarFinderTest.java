/*
 * (c) 2012 FCCI Insurance Group All Rights Reserved.
 */
package com.rothsmith.environment;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rothsmith.environment.Env;
import com.rothsmith.environment.SysEnvVarFinder;

/**
 * Tests for {@link SysEnvVarFinder}. The class tests each possible value of a
 * FCCI system environment. It will also test what happens when there is no such
 * variable defined in the system environment. In that case, it should return
 * the 'SBX' (SANDBOX).
 * 
 * @author drothauser
 * 
 */
@RunWith(Parameterized.class)
public class SysEnvVarFinderTest {

	/**
	 * Collection of environment values to test with.
	 * 
	 * @return {@link Collection} of browser types.
	 */
	@Parameters
	public static Collection<Object[]> browsers() {
		Object[][] testenvs = new Object[][] { { Env.Names.SBX },
		    { Env.Names.DEV }, { Env.Names.TST }, { Env.Names.QA },
		    { Env.Names.UAT }, { Env.Names.PRD }, { null }, { "" } };
		return Arrays.asList(testenvs);
	}

	/**
	 * The environment value under test.
	 */
	private final String env;

	/**
	 * Instance of {@link SysEnvVarFinder} used to lookup the currently running
	 * environment from the OS's system environment variables.
	 */
	private SysEnvVarFinder envVarFinder;

	/**
	 * Initialize the test fixture's env variable.
	 * 
	 * @param env
	 *            the environment to test.
	 */
	@SuppressWarnings("PMD.NullAssignment")
	public SysEnvVarFinderTest(Object env) {
		this.env = (env instanceof Env.Names) ? ((Env.Names) env).name()
		    : (String) env;

	}

	/**
	 * Set up the test by setting the test fixture's environment variable in the
	 * system environment {@link Map#} used by {@link SysEnvVarFinder}.
	 */
	@Before
	public void setUp() {

		envVarFinder = new SysEnvVarFinder();
		Map<String, String> envMap = new HashMap<String, String>();
		envMap.put(Env.FCCI_ENV_VARNAME, env);
		envVarFinder.setEnvMap(envMap);

	}

	/**
	 * Test method for {@link SysEnvVarFinder#fetchEnvVar(String)}. If the
	 * environment variable to test is undefined, SBX (SANDBOX) will be
	 * expected.
	 */
	@Test
	public void testEnv() {

		String expectedEnv =
		    (StringUtils.isBlank(env) ? Env.Names.SBX.name() : env);

		assertThat(envVarFinder.fetchEnvVar("FCCI_ENV"), is(expectedEnv));

	}
}
