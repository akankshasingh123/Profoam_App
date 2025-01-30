package com.assertions;
import org.testng.Assert;
import com.logger.Log;

import com.qa.base.BaseClass;

public class mobileAssertion extends BaseClass {
	
	/**
     * Reusable method for assert equals in Appium.
     */
	
	public static void assertEquals(Object actual, Object expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
            Log.info("Assertion Passed: " + message);
        } catch (AssertionError e) {
        	Log.error("Assertion Failed: " + message, e);
            throw e; // Rethrow to ensure the test fails.
        }
    }
	
	/**
     * Reusable method for assert True in Appium.
     */
	
	public static void assertTrue(boolean condition, String message) {
        try {
            Assert.assertTrue(condition, message);
            Log.info("Assertion Passed: " + message);
        } catch (AssertionError e) {
        	Log.error("Assertion Failed: " + message, e);
            throw e; // Rethrow to ensure the test fails.
        }
    }

}
