package com.ideas2it.logger;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * <h1> Custom Logger </h1>
 * <p>
 * Log the Informations and Exceptions of the Application.
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   10-10-2022
 */
public class CustomLogger {
    private Logger logger;

    public CustomLogger(Class<?> className) {
        this.logger = LogManager.getLogger(className);
    }

    /**
     * <h1> Info </h1>
     * <p>
     * Gets the info Log of the Application
     * </p>
     *
     * @param message - a message to be Logged in the file
     */
    public void info(String message) {
        logger.info(message);
    }

    /**
     * <h1> Warn </h1>
     * <p>
     * Gets the warn Log of the Application
     * </p>
     *
     * @param message - a message to be Logged in the file
     */
    public void warn(String message) {
        logger.warn(message);
    }

    /**
     * <h1> Error </h1>
     * <p>
     * Gets the error Log of the Application
     * </p>
     *
     * @param message - a message to be Logged in the file
     */
    public void error(String message) {
        logger.error(message);
    }
}