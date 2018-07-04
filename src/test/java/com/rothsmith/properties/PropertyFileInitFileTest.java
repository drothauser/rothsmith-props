/*
 * (c) 2012 FCCI Insurance Group All Rights Reserved.
 */
package com.rothsmith.properties;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.rothsmith.properties.PropertyFileInitializer;
import com.rothsmith.properties.PropertyFileInitializerException;

/**
 * Tests for {@link PropertyFileInitializer#initProperties(String)} that loads a
 * {@link Properties} object from an external properties file.
 * 
 * @author drothauser
 * 
 */
public class PropertyFileInitFileTest {

	/**
	 * Temporary Folder.
	 */
	// CHECKSTYLE:OFF
	@Rule
	public TemporaryFolder tmpFolder = new TemporaryFolder();
	// CHECKSTYLE:ON

	/**
	 * Temporary test properties file.
	 */
	private static String propfilename;

	/**
	 * Key for test properties file.
	 */
	private static final String TEST_KEY = "testkey";

	/**
	 * Value for key in test properties file.
	 */
	private static final String TEST_VALUE = "testvalue";

	/**
	 * Create a temporary property file for testing.
	 * 
	 * @throws IOException
	 *             Possible I/O error.
	 * 
	 */
	@Before
	public void setUp() throws IOException {

		File tmpPropfile = tmpFolder.newFile("test.properties");
		propfilename = tmpPropfile.getAbsolutePath();
		Properties props = new Properties();
		props.setProperty(TEST_KEY, TEST_VALUE);
		Writer out = new FileWriter(tmpPropfile);
		props.store(out, "test properties");

	}

	/**
	 * Test method for {@link PropertyFileInitializer#initProperties(String)}
	 * that loads a {@link Properties} object from a properties file located in
	 * the file system.
	 */
	@Test
	public void testInitProperties() {

		// START SNIPPET: initPropsFromFile
		Properties props =
		    PropertyFileInitializer.initProperties(propfilename);
		// END SNIPPET: initPropsFromFile
		assertThat((String) props.get(TEST_KEY), is(TEST_VALUE));

	}

	/**
	 * Test method for {@link PropertyFileInitializer#initProperties(String)}
	 * that tries to load a {@link Properties} using an invalid file.
	 */
	@Test(expected = PropertyFileInitializerException.class)
	public void testInitPropertiesBadFile() {

		PropertyFileInitializer.initProperties("c:\bogus.properties");

	}

}
