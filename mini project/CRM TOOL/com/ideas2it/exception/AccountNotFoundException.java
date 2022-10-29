package com.ideas2it.exception;

/**
 * <h1> Account Not Found Exception </h1>
 * <p>
 * Custom exception to throw an Exception of Account Not Found
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   27-10-2022
 */
public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}