/*
 * (c) 2012 FCCI Insurance Group All Rights Reserved.
 */
package com.rothsmith.environment;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Tests for {@link Env}.
 * 
 * @author drothauser
 * 
 */
public class EnvTest {

	/**
	 * Simple test method for {@link com.rothsmith.environment.Env#getEnv()}.
	 * Because this test will be run either locally or in a continuous
	 * integration environment, the expected value will be 'SBX' (Sandbox).
	 */
	@Test
	public void testGetEnv() {

		// START SNIPPET: getEnv
		String env = Env.getEnv();
		// END SNIPPET: getEnv

		assertThat(env, is(Env.Names.SBX.name()));
	}

}
