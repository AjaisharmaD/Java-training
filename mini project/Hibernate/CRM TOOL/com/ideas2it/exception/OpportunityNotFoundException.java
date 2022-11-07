package com.ideas2it.exception;

/**
 * <h1> Opportunity Not Found Exception </h1>
 * <p>
 * Custom exception to throw an Exception of Opportunity Not Found
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   27-10-2022
 */
public class OpportunityNotFoundException extends Exception {
    public OpportunityNotFoundException(String message) {
        super(message);
    }
}