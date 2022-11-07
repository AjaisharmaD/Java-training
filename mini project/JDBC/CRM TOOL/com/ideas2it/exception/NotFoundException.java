package com.ideas2it.exception;

/**
 * <h1> Not Found Exception </h1>
 * <p>
 * Custom exception to throw an Exception of Not Found
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   27-10-2022
 */
public class NotFoundException extends Exception {
    public NotFoundException(String message) {
        super(message);
    }
}