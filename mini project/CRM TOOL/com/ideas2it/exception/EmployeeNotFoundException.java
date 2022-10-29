package com.ideas2it.exception;

/**
 * <h1> Employee Not Found Exception </h1>
 * <p>
 * Custom exception to throw an Exception of Employee Not Found
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   27-10-2022
 */
public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}