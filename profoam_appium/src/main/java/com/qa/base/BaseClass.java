package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.logger.Log;
import com.pageObjects.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	
	public static AndroidDriver driver;
	public AppiumDriverLocalService server;
	public static AppiumDriver appiumDriver;
	public static WebDriverWait wait;
	static Properties CONFIG = new Properties();
	public static Log logger = new Log();
	
	
	
	/**
     *  method to Start Appium server.
     */
	@BeforeMethod
	public void ConfigureAppium() throws MalformedURLException{
		
		String nodePathOnPc = "C://Users//Akanksha.Singh//AppData//Roaming//npm//node_modules//appium//lib//main.js";
		File nodePath = new File(nodePathOnPc);
		
		server = new AppiumServiceBuilder().
				withAppiumJS(nodePath).withIPAddress("192.168.29.67").usingPort(4723).build();
		
		server.start();// Starts the server
		Log.info("Appium Server started successfully.");

		
        // Set the path to the APK file
		String apkpath =System.getProperty("user.dir")+"//src//test//java//com//resources//app-release.apk";
		
		// Configure UiAutomator2Options
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(getPropertyValue("deviceName"));
		options.setApp(apkpath);
		
		// Start Appium Driver
		Log.info("Initializing Appium Driver...");
		URL url = new URL(getPropertyValue("appiumURL"));
		driver = new AndroidDriver(url, options);
	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Log.info("Appium Driver initialized successfully.");
					
		
	}
	
	
	
	
	/**
     *  method to Stop Appium server.
     */
	@AfterMethod
	public void tearDown() {
		Log.info("Stopping Appium Server...");
		try {
            if (driver != null) {
                driver.quit();
            }
            if (server != null) {
                server.stop();
            }
            Log.info("Appium Server stopped successfully.");
        } catch (Exception e) {
            Log.error("Error while stopping Appium Server.", e);
        }
		
	}
	
	
	/**
	 * Method to load the config.properties file and return the value for a given key 
	 */
    public static String getPropertyValue(String key) {
        Properties props = new Properties();
        String value = null;
        String configPath = System.getProperty("user.dir")+ "/src/test/java/com/resources/config.properties";
        
        try (InputStream input = new FileInputStream(configPath)) {
            // Load the properties file
            props.load(input);
            
            // Retrieve the value for the given key
            value = props.getProperty(key);
            Log.info("Loaded property '" + key + "' with value: " + value);


        } catch (IOException ex) {
        	Log.error("Failed to load property '" + key + "'.", ex);
        }

        return value;
    }
    
    
    public void LoginToApplication() {
    	Log.info("Launching the app and logging in...");
        try {
            //LoginPage.verifyTitle();
            LoginPage.clickSkip();
            LoginPage.loginBtn();
            LoginPage.setEmailAddress(getPropertyValue("emailId"));
            LoginPage.setPassword(getPropertyValue("password"));
            //LoginPage.login();
            Log.info("Logged into the application successfully.");
        } catch (Exception e) {
            Log.error("Error during login process.", e);
            throw e;
        }
    }
    
    @BeforeMethod(alwaysRun = true)
    public void Login() {
    	try {
    		LoginToApplication();
    	} catch(Exception e) {
    		Log.error("Error while logging into the application: " + e.getMessage(), e);
    		throw e;
    	}
    	
    }
    
  
    
	
	 
    

}
