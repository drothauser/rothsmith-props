/*
 * (c) 2012 FCCI Insurance Group All Rights Reserved.
 */
package com.rothsmith.properties;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.rothsmith.properties.PropertyFileInitializer;

/**
 * JUnit test suite that tests all {@link PropertyFileInitializer}
 * functionality.
 * 
 * @version $Id: PropertyFileInitAllTests.java 634 2012-08-08 00:26:24Z drarch $
 * 
 * @author drothauser
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({ PropertyFileInitFileTest.class,
    PropertyFileInitResourceTest.class })
@SuppressWarnings("PMD.AtLeastOneConstructor")
public class PropertyFileInitAllTests {

}
