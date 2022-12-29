package com.ideas2it.crmtool.logger;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * <h1>
 *     Custom Logger
 * </h1>
 * <p>
 *     Contains the Logging levels like debug
 *     info, warn, error
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 29-12-2022
 */
public class CustomLogger {
    private final Logger logger;

    public CustomLogger(Class<?> className) {
        this.logger = LogManager.getLogger(className);
    }

    /**
     * <h1> Debug </h1>
     * <p>
     * Gets the debug Log of the Application
     * </p>
     *
     * @param message - a message to be Logged in the file as Debug
     */
    public void debug(String message) {
        logger.debug(message);
    }

    /**
     * <h1> Info </h1>
     * <p>
     * Gets the info Log of the Application
     * </p>
     *
     * @param message - a message to be Logged in the file as Info
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
     * @param message - a message to be Logged in the file as Warn
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
     * @param message - a message to be Logged in the file as Error
     */
    public void error(String message) {
        logger.error(message);
    }
}
