package com.ideas2it.exception;

/**
 * <h1> Lead Not Found Exception </h1>
 * <p>
 * Custom exception to throw an Exception of Lead Not Found
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   27-10-2022
 */
public class LeadNotFoundException extends Exception {
    public LeadNotFoundException(String message) {
        super(message);
    }
}