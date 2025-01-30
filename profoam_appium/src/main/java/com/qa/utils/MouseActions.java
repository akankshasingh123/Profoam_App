package com.qa.utils;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;
import com.logger.Log;
import com.qa.base.BaseClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MouseActions extends BaseClass {
	
	
	/**
     * Reusable method to click from mouse in Appium.
     */
	public static boolean click(By locator, String elemName) {

		try {
            Log.info("Waiting till " + elemName + " is displayed");
            Log.info("Clicking on " + elemName);
            driver.findElement(locator).click();
            Log.info("Clicked on " + elemName);
        } catch (Throwable e) {
            Log.error("Error with clicking on " + elemName, e);
            return false;
        }
        return true;
    }
	
	
	/**
     * Reusable method to scroll to element using UIScrollable from mouse in Appium.
     */
	public static WebElement scrollToElementUsingUiScrollable(By locator) {
		try {
            Log.info("Scrolling to element using UiScrollable: " + locator);
            return driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().resourceId(\"" + locator.toString() + "\"))"));
        } catch (NoSuchElementException e) {
            Log.error("Element not found after scrolling using UiScrollable: " + locator, e);
            throw new RuntimeException("Element not found after scrolling using UiScrollable: " + locator, e);
        }
    }
	
	/**
     * Reusable method to Swipes until the specified locator is displayed.
     */
    public static void swipeUntilElementIsVisible(By locator) throws InterruptedException {
    	boolean isElementVisible = false;

        while (!isElementVisible) {
            try {
                WebElement element = driver.findElement(locator);
                isElementVisible = element.isDisplayed();
            } catch (NoSuchElementException e) {
                // Continue scrolling
            }
            Thread.sleep(5000);
        }
        Log.info("Element is visible after swiping");
    }
    
    /**
     * Reusable method to Swipes until the specified locator is displayed using UI Swipe
     */
    public static void scrollToElementUsingUIwithSwipe(By locator, int maxScrolls) {
    	 WebElement element = null;
         int currentScrolls = 0;

         while (currentScrolls < maxScrolls) {
             try {
                 element = driver.findElement(locator);
                 if (element.isDisplayed()) {
                     // Element is found and displayed, exit the loop
                     Log.info("Element found: " + element);
                     break;
                 }
             } catch (Exception e) {
                 // Element not found yet, perform swipe
                 verticalSwipeAction();
             }
             currentScrolls++;
         }

         if (element == null || !element.isDisplayed()) {
             Log.info("Element not found after " + maxScrolls + " scrolls.");
         }
	}
    
    
    /**
     * Reusable method to Vertical Swipe
     */
	public static void verticalSwipeAction() {
		Log.info("Performing vertical swipe action");
        // Define input source for the touch
        PointerInput finger = new PointerInput(Kind.TOUCH, "finger");

        // Define screen height dimensions for swipe
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();

        int startX = screenWidth / 2; // Horizontal center of the screen
        int startY = (int) (screenHeight * 0.8); // Starting point, lower part of the screen
        int endY = (int) (screenHeight * 0.2);   // End point, upper part of the screen

        // Create a swipe action using W3C Actions
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), Origin.viewport(), startX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the swipe action
        driver.perform(Arrays.asList(swipe));
	}
	
	
	/**
     * Reusable method to Scroll to top.
     */
	public static boolean scrollUpToTop()
    {
		Log.info("Scrolling up to the top");
        try {
            driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "up"));
            Thread.sleep(2000);
        } catch (Throwable e) {
            Log.error("Failed to scroll up because: " + e.getMessage(), e);
            return false;
        }
        return true;
    }
	
	
	/**
     * Reusable method to Scroll to Bottom.
     */
	public static boolean scrollDownToBottom()
    {
		Log.info("Scrolling down to the bottom");
        try {
            driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));
        } catch (Throwable e) {
            Log.error("Failed to scroll down because: " + e.getMessage(), e);
            return false;
        }
        return true;
    }
	
	
	/**
     * Reusable method to Single Swipe to down.
     */
	public static void singleSwipeDown() throws Exception {
		Log.info("Performing single swipe down");
        HashMap<String, String> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        driver.executeScript("mobile: swipe", scrollObject);
        Log.info("Scroll successful");

    }
	
	
	/**
     * Reusable method to Single Swipe to right.
     */
    public static void singleSwipeRight() throws Exception {
    	Log.info("Performing single swipe right");
        HashMap<String, String> scrollObject = new HashMap<>();
        scrollObject.put("direction", "right");
        driver.executeScript("mobile: swipe", scrollObject);
        Log.info("Scroll successful");

    }
    
    
    /**
     * Reusable method to Single Swipe to Left.
     */
    public static void singleSwipeLeft() throws Exception {
    	 Log.info("Performing single swipe left");
         HashMap<String, String> scrollObject = new HashMap<>();
         scrollObject.put("direction", "left");
         driver.executeScript("mobile: swipe", scrollObject);
         Log.info("Scroll successful");

    }
    
    
    /**
     * Reusable method to Single Swipe to Up.
     */
    public static void singleSwipeUp() throws Exception {
    	Log.info("Performing single swipe up");
        HashMap<String, String> scrollObject = new HashMap<>();
        scrollObject.put("direction", "up");
        driver.executeScript("mobile: swipe", scrollObject);
        Log.info("Scroll successful");

    }
    
    public static WebElement scrollDownUsingUiScrollable() {
    	try {
            Log.info("Scrolling down using UiScrollable");
            return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
        } catch (NoSuchElementException e) {
            Log.error("Element not found after scrolling down using UiScrollable", e);
            throw new RuntimeException("Element not found after scrolling down using UiScrollable", e);
        }
    }
    
    public static WebElement scrollTopUsingUiScrollable() {
    	try {
            Log.info("Scrolling to top using UiScrollable");
            return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).flingToBeginning(10)"));
        } catch (NoSuchElementException e) {
            Log.error("Element not found after scrolling up using UiScrollable", e);
            throw new RuntimeException("Element not found after scrolling up using UiScrollable", e);
        }
    }
    
    
 

    
   

	

}
