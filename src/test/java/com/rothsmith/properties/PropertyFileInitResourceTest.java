/*
 * (c) 2012 FCCI Insurance Group All Rights Reserved.
 */
package com.rothsmith.properties;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Properties;

import org.junit.Test;

import com.rothsmith.properties.PropertyFileInitializer;
import com.rothsmith.properties.PropertyFileInitializerException;

/**
 * Tests for {@link PropertyFileInitializer#initPropertiesResource(String)} that
 * loads a {@link Properties} object from a properties file on the classpath.
 * 
 * @author drothauser
 * 
 */
public class PropertyFileInitResourceTest {

	/**
	 * Key for test properties file.
	 */
	private static final String TEST_KEY = "testkey";

	/**
	 * Value for key in test properties file.
	 */
	private static final String TEST_VALUE = "testvalue";

	/**
	 * Test method for
	 * {@link PropertyFileInitializer#initPropertiesResource(String)} that loads
	 * a {@link Properties} object from a properties file in the class package
	 * structure.
	 */
	@Test
	public void testInitPropertiesResource() {

		// START SNIPPET: initPropsFromResource
		Properties props =
		    PropertyFileInitializer
		        .initPropertiesResource("/test.properties");

		// END SNIPPET: initPropsFromResource

		assertThat((String) props.get(TEST_KEY), is(TEST_VALUE));

	}

	/**
	 * Test method for
	 * {@link PropertyFileInitializer#initPropertiesResource(String)} that
	 * attempts to load a {@link Properties} object from a properties file in
	 * the class package structure. The properties file given doesn't have a
	 * leading "/" character and won't be able to be found.
	 */
	@Test(expected = PropertyFileInitializerException.class)
	public void testInitPropertiesResourceNoPath() {

		PropertyFileInitializer.initPropertiesResource("test.properties");

	}

	/**
	 * Test method for
	 * {@link PropertyFileInitializer#initPropertiesResource(String)} that loads
	 * a {@link Properties} object from a properties file found in the
	 * classpath.
	 */
	@Test
	public void testInitPropertiesClasspath() {

		// START SNIPPET: initPropsFromClasspath
		Properties props =
		    PropertyFileInitializer
		        .initPropertiesClasspath("test.properties");

		// END SNIPPET: initPropsFromClasspath

		assertThat((String) props.get(TEST_KEY), is(TEST_VALUE));

	}

	/**
	 * Test method for
	 * {@link PropertyFileInitializer#initPropertiesResource(String)} that loads
	 * a {@link Properties} object from a properties file in the classpath. The
	 * file name begins with a &quot;/&quot; (root) however the
	 * initPropertiesResource method with remove it.
	 */
	@Test
	public void testInitPropertiesClasspathRoot() {

		Properties props =
		    PropertyFileInitializer
		        .initPropertiesClasspath("/test.properties");

		assertThat((String) props.get(TEST_KEY), is(TEST_VALUE));

	}

	/**
	 * Test method for
	 * {@link PropertyFileInitializer#initPropertiesResource(String)} that tries
	 * to load a {@link Properties} using a file that doesn't exist in the
	 * classpath.
	 */
	@Test(expected = PropertyFileInitializerException.class)
	public void testInitPropertiesBadResource() {

		PropertyFileInitializer.initPropertiesResource("bogus.properties");

	}

	/**
	 * Test method for
	 * {@link PropertyFileInitializer#initPropertiesResource(String)} that tries
	 * to load a {@link Properties} using a file that doesn't exist in the
	 * classpath. The bogus file name begins with a &quot;/&quot;.
	 */
	@Test(expected = PropertyFileInitializerException.class)
	public void testInitPropertiesBadResourceRoot() {

		PropertyFileInitializer.initPropertiesResource("/bogus.properties");

	}

}
