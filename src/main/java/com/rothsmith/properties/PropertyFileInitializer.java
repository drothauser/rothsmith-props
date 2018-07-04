/*
 * (c) 2012 FCCI Insurance Group All Rights Reserved.
 */
package com.rothsmith.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Utility class providing convenience methods for accessing properties files.
 * </p>
 * 
 * @author drothauser
 */
public final class PropertyFileInitializer {

	/**
	 * SLF4J Logger for PropertyFileInitializer.
	 */
	private static final Logger LOGGER =
	    LoggerFactory.getLogger(PropertyFileInitializer.class);

	/**
	 * Private constructor to thwart instantiation.
	 */
	private PropertyFileInitializer() {
	}

	/**
	 * This method creates a {@link Properties} object from the given properties
	 * file.
	 * 
	 * @param propFile
	 *            path and file name of the properties file
	 * @return {@link Properties} object
	 */
	public static Properties initProperties(String propFile) {

		Properties props = null;
		FileInputStream fis = null;
		try {
			props = new java.util.Properties();
			fis = new FileInputStream(propFile);
			props.load(fis);
		} catch (IOException e) {
			String errmsg = "IO Exception caught reading " + propFile + ":" + e;
			LOGGER.error(errmsg, e);
			throw new PropertyFileInitializerException(errmsg, e);
		} finally {
			IOUtils.closeQuietly(fis);
		}

		return props;

	}

	/**
	 * This method creates a {@link Properties} object from the given properties
	 * file in the class package.
	 * 
	 * @param resPropFile
	 *            the name of the properties file in the package structure.
	 * @return {@link Properties} object
	 */
	@SuppressWarnings("PMD.SimplifyStartsWith")
	public static Properties initPropertiesResource(final String resPropFile) {

		Properties props = null;
		InputStream is = null;
		try {
			props = new Properties();
			is = PropertyFileInitializer.class.getResourceAsStream(resPropFile);
			if (is == null) {
				throw new PropertyFileInitializerException(
				    resPropFile + " does not exist.");
			}
			props.load(is);

		} catch (IOException e) {
			String errmsg =
			    "IO Exception caught reading " + resPropFile + ":" + e;
			LOGGER.error(errmsg, e);
			throw new PropertyFileInitializerException(errmsg, e);
		} finally {
			IOUtils.closeQuietly(is);
		}

		return props;

	}

	/**
	 * This method creates a {@link Properties} object from the given properties
	 * file in the class path.
	 * 
	 * @param classpathPropFile
	 *            the name of the properties file to find in the classpath.
	 * @return {@link Properties} object
	 */
	@SuppressWarnings("PMD.SimplifyStartsWith")
	public static Properties initPropertiesClasspath(
	    final String classpathPropFile) {

		String propsFilepath = (StringUtils.startsWith(classpathPropFile, "/"))
		    ? StringUtils.substringAfter(classpathPropFile, "/")
		    : classpathPropFile;

		Properties props = null;
		InputStream is = null;
		try {
			URL url = ClassLoader.getSystemResource(propsFilepath);
			File propsFile = FileUtils.toFile(url);
			if (propsFile == null) {
				throw new PropertyFileInitializerException(
				    String.format("%s not found in classpath.", propsFilepath));
			}
			LOGGER.debug(String.format("Found %s: %s.", classpathPropFile,
			    propsFile.getAbsoluteFile()));
			is = FileUtils.openInputStream(propsFile);
			props = new Properties();
			props.load(is);

		} catch (IOException e) {
			String errmsg =
			    "IO Exception caught reading " + classpathPropFile + ":" + e;
			LOGGER.error(errmsg, e);
			throw new PropertyFileInitializerException(errmsg, e);
		} finally {
			IOUtils.closeQuietly(is);
		}

		return props;

	}
}
