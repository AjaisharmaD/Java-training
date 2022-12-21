package com.ideas2it.exception;

/**
 * <h1> Custom Exception </h1>
 * <p>
 * Custom exception to throw an Exception of Not Found
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   27-10-2022
 */
public class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}