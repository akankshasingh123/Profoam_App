package com.qa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.collect.ImmutableMap;
import com.logger.Log;
import com.qa.base.BaseClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class KeyboardActions extends BaseClass {
	
	
	/**
     * Reusable method to enter value from keyboard in Appium.
     */
	
	public static boolean enterValue(By locator, String elemName, String Value) {
		Log.info("Sending values to element: '" + elemName + "'");

        try {
            driver.findElement(locator).sendKeys(Value);
            Log.info("Input '" + Value + "' into element: '" + elemName + "'");
            return true;
        } catch (Throwable inputException) {
            Log.error("Error while inputting into element: '" + elemName + "'", inputException);
            return false;
        }
    }
	
	
	/**
     * Reusable method to hide the keyboard in Appium.
     */
	
    public static void hideKeyboard() {
    	try {
            if (driver.isKeyboardShown()) {
                driver.hideKeyboard();
                Log.info("Keyboard hidden successfully.");
            } else {
                Log.info("Keyboard is not displayed.");
            }
        } catch (WebDriverException e) {
            Log.error("Failed to hide keyboard", e);
        }
    }
	
	
	/**
     * Reusable method to press enter from keyboard in Appium.
     */
	
	public static boolean enter() {
		Log.info("Pressing ENTER key on keyboard.");

        try {
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).perform();
            Log.info("ENTER key pressed successfully.");
            return true;
        } catch (Throwable enterException) {
            Log.error("Error while pressing ENTER key", enterException);
            return false;
        }
    }
	
     
     

}
