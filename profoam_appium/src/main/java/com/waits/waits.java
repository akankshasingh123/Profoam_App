package com.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.logger.Log;
import com.qa.base.BaseClass;

public class waits extends BaseClass {
	
	
	/**
     * Reusable method to wait for a while in Appium.
     */
	public static void waitForWhile(long waits) {
	    try {
	        if (waits <= 0) {
	            throw new IllegalArgumentException("Wait duration must be positive.");
	        }
	        Log.info("Pausing test case for " + waits / 1000 + " sec");
	        Thread.sleep(waits);
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt(); // Restore interrupted status
	        Log.error("Thread was interrupted during sleep", e);
	        throw new RuntimeException("Thread was interrupted during sleep", e);
	    }
	}
	
	
	/**
     * Reusable method to wait until element is loaded in Appium.
     */
	public static boolean waitForElementToLoad(By locator, String elemName)
    {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Log.info(elemName + " element loaded successfully.");

        } catch (Throwable isElementPresentException) {
            // Log error
        	//Log.error("Error while verifying - '" + elemName + "' element Present : " + isElementPresentException.getMessage());
        	Log.error("Error while waiting for element: " + elemName, isElementPresentException);
            return false;
        }
        return true;
    }
	
	
	/**
     * Reusable method to wait until element is clickable in Appium.
     */
	public static boolean waitForElementToClickable(By locator, String elemName)
    {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            Log.info(elemName + " element is clickable.");

        } catch (Throwable isElementPresentException) {

            // Log error
        	 Log.error("Error while waiting for element to be clickable: " + elemName, isElementPresentException);
            return false;
        }
        return true;
    }
	
	public static void waitUntilElementIsVisible(By locator, int timeout) {
		try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Log.info("Element located by " + locator.toString() + " is visible.");
        } catch (Throwable e) {
            Log.error("Error while waiting for element visibility: " + locator.toString(), e);
            throw new RuntimeException("Failed to wait until element is visible", e);
        }
    }
	
	
	
	
	
	

}
