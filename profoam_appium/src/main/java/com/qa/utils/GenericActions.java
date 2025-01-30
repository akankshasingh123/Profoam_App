package com.qa.utils;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.logger.Log;
import com.qa.base.BaseClass;

public class GenericActions extends BaseClass {
	
	
	/**
     * Reusable method to verify element is displayed in Appium.
     */
	
	public static Boolean verifyElementDisplayed(By locator, String elemName) {
		Log.info("Verifying whether Element: '" + elemName + "' is present");

        try {
            driver.findElement(locator).isDisplayed();
            Log.info(elemName + " is displayed successfully.");
        } catch (Throwable isElementPresentException) {
            Log.error("Error while verifying element: '" + elemName + "'", isElementPresentException);
            return false;
        }
        return true;
    }
	
	/**
     * Reusable method to enter random number in Appium.
     */

   public int randamNumberGenerator(int min, int max) {
	   int number = (int) (Math.random() * (max - min + 1) + min);
       Log.info("Generated random number: " + number);
       return number;
	}
   
   /**
    * Reusable method to retrieve text in Appium.
    */
   
   public static String retrieveText(By locator, String elemName) {
	   String retrievedText = null;
       Log.info("Retrieving text from: " + elemName);

       try {
           retrievedText = driver.findElement(locator).getText().trim();
           Log.info("Retrieved text: " + retrievedText);
       } catch (Throwable retrieveTextException) {
           Log.error("Error while retrieving text from '" + elemName + "'", retrieveTextException);
           return "Fail: Error while retrieving text from '" + elemName + "'";
       }

       return retrievedText;

   }
   
   /**
    * Reusable method to verify element disappeared in Appium.
    */
   
   public static Boolean verifyElementDisappeared(By locator, String elemName) throws Exception {
       System.out.println("Verifying whether Element : '" + elemName + "' is present");

       try {
           wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
           System.out.println(elemName + " is present");

       } catch (Throwable isElementPresentException) {

           // Log error
           System.err.println("Error while verifying - '" + elemName + "' element Present : " + isElementPresentException.getMessage());
           return false;
       }
       return true;
   }
   
   /**
    * Reusable method to verify Text present in Appium.
    */
   
   public static String verifyTextPresent(String expText) {
	   Log.info("Verifying text: '" + expText + "' is present in the page source");

       try {
           assertTrue(driver.getPageSource().contains(expText));
           Log.info("'" + expText + "' is present in the page source.");
           return "Pass: '" + expText + "' is present in the page source.";
       } catch (Throwable verifyTextPresentError) {
           Log.error("Error while verifying text presence in page source: " + expText, verifyTextPresentError);
           return "Fail: Error while verifying text presence in page source.";
       }
   }

}
