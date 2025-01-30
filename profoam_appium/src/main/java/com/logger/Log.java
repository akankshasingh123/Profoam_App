package com.logger;

import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 * Contains all the methods to show the logs on the console 
 * and save the logs in LogFile.txt for each run.
 */
public class Log {

    private static final Logger LOGGER = Logger.getLogger("logger");
    private static final PatternLayout layout = new PatternLayout("%d{dd MMM yyyy HH:mm:ss} %5p %c{1} - %m%n");
    private static FileAppender appender;
    private static ConsoleAppender consoleAppender;

    static {
        try {
            // Console Appender Configuration
            if (LOGGER.getAppender("console") == null) {
                consoleAppender = new ConsoleAppender(layout, "System.out");
                consoleAppender.setName("console");
                LOGGER.addAppender(consoleAppender);
            }

            // File Appender Configuration
            if (LOGGER.getAppender("file") == null) {
                appender = new FileAppender(layout, "LogFile//LogFile.txt", true);
                appender.setName("file");
                LOGGER.addAppender(appender);
            }

            // Setting default log level to INFO
            LOGGER.setLevel(Level.INFO);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Method to display errors in logs.
     * 
     * @param className   Name of the class where the error occurred.
     * @param methodName  Name of the method where the error occurred.
     * @param exception   Stack trace or exception message.
     */
    public static void logError(String className, String methodName, String exception) {
        LOGGER.error("ClassName: " + className);
        LOGGER.error("MethodName: " + methodName);
        LOGGER.error("Exception: " + exception);
        LOGGER.error("-----------------------------------------------------------------------------------");
    }

    /**
     * Method to log detailed error with exception.
     *
     * @param message   Custom error message.
     * @param throwable Exception object to log stack trace.
     */
    public static void error(String message, Throwable throwable) {
        LOGGER.error(message, throwable);
    }

    /**
     * Method to display information in logs.
     * 
     * @param message Message to be displayed.
     */
    public static void info(String message) {
        LOGGER.info(message);
    }
}