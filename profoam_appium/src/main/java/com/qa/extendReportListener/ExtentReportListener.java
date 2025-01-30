package com.qa.extendReportListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.logger.Log;
import com.qa.base.BaseClass;
import com.qa.recording.MyScreenRecorder;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportListener implements ITestListener{
	
	
	private ExtentReports extent = ExtendReportNG.getReportObject();
    private ExtentTest test;

    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        Log.info("Test Started: " + result.getMethod().getMethodName());
        MyScreenRecorder.startRecording(BaseClass.driver);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");
        Log.info("Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
//    	extentTest.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());
//      Log.error("Test Failed: " + result.getMethod().getMethodName(), result.getThrowable());
    	
    	
//    	WebDriver driver = BaseClass.driver; // Access the WebDriver instance from BaseClass
//        String methodName = result.getMethod().getMethodName();
//        String screenshotPath = takeScreenshot(driver, methodName);
//
//        try {
//            extentTest.get()
//                    .fail("Test Failed: " + result.getThrowable(),
//                            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//        } catch (Exception e) {
//            extentTest.get().fail("Test Failed, but screenshot could not be attached: " + e.getMessage());
//        }
//
//        Log.error("Test Failed: " + methodName, result.getThrowable());
    	
    	WebDriver driver = BaseClass.driver;
        String methodName = result.getMethod().getMethodName();
        
        MyScreenRecorder.stopRecording((AndroidDriver) driver, methodName);
        
        String screenshotPath = takeScreenshot(driver, methodName);
        try {
            extentTest.get()
                    .fail("Test Failed: " + result.getThrowable(),
                            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (Exception e) {
            extentTest.get().fail("Test Failed, but screenshot could not be attached: " + e.getMessage());
        }
        Log.error("Test Failed: " + methodName, result.getThrowable());

        
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Test Skipped");
        Log.info("Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        Log.info("Test Suite Execution Completed");
    }
    
    
    /**
     * Captures a screenshot and returns the file path.
     *
     * @param driver WebDriver instance
     * @param methodName Name of the test method
     * @return Path to the screenshot
     */
    private String takeScreenshot(WebDriver driver, String methodName) {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/screenshots/" + methodName + "_" + timestamp + ".png";

        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(filePath));
            Log.info("Screenshot captured for method: " + methodName);
        } catch (IOException e) {
            Log.error("Failed to capture screenshot for method: " + methodName, e);
        }

        return filePath;
    }
        
}


