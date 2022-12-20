package com.ideas2it.service;

import com.ideas2it.model.User;
import com.ideas2it.exception.CustomException;

/**
 * <h1> CRM Service </h1>
 * <p> 
 * CRM Service is used to check the credentials of the user
 * which are email and password. 
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 16-09-2022
 */
public interface CRMService {
    
    /**
     * <h1> CRM Service </h1>
     * <p> 
     * CRM Service is used to check the credentials of the user
     * which are email and password. 
     * </p>
     *
     * @param email    - Email Id to Loign
     * @param password - Password to Login
     *
     * @return User    - user object which hold the details of the user
     */
    public User getUserByEmailAndPassword(String email, String password) 
                                                 throws CustomException;
}