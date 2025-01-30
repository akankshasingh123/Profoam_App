package com.qa.recording;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.CanRecordScreen;
import java.util.Base64;
import java.io.FileOutputStream;
import java.io.IOException;
import com.logger.Log;

/**
 * Utility class for recording Appium test executions.
 */

public class MyScreenRecorder {
	
	
private static final String VIDEO_DIR = System.getProperty("user.dir") + "/screenrecordings/";
    
    /**
     * Starts screen recording on the Android device.
     * 
     * @param driver AndroidDriver instance
     */
    public static void startRecording(AndroidDriver driver) {
    	if (driver instanceof CanRecordScreen) {
            ((CanRecordScreen) driver).startRecordingScreen(
                new AndroidStartScreenRecordingOptions()
                        .withTimeLimit(Duration.ofMinutes(5))
                        .withVideoSize("1280x720")
                        .withBitRate(5000000)
                        .enableBugReport()
            );
            Log.info("Screen recording started.");
        }
    }

    /**
     * Stops the recording and saves the video file in the specified directory.
     * 
     * @param driver AndroidDriver instance
     * @param methodName Name of the test method
     */
    public static void stopRecording(AndroidDriver driver, String methodName) {
        if (driver instanceof CanRecordScreen) {
            String base64Video = ((CanRecordScreen) driver).stopRecordingScreen();
            saveVideoFile(base64Video, methodName);
            Log.info("Screen recording stopped and saved.");
        }
    }

    /**
     * Saves the screen recording as an MP4 file.
     * 
     * @param base64Video Base64 encoded video string
     * @param methodName Name of the test method
     */
    private static void saveVideoFile(String base64Video, String methodName) {
        try {
            File dir = new File(VIDEO_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String filePath = VIDEO_DIR + methodName + "_" + timestamp + ".mp4";

            byte[] decodedVideo = Base64.getDecoder().decode(base64Video);
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                fos.write(decodedVideo);
            }

            Log.info("Screen recording saved at: " + filePath);
        } catch (IOException e) {
            Log.error("Failed to save screen recording.", e);
        }
    }
}


