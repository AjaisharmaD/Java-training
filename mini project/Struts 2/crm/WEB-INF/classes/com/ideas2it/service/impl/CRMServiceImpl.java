package com.ideas2it.service.impl;

import java.util.List;

import com.ideas2it.model.User;
import com.ideas2it.service.CRMService;
import com.ideas2it.service.UserService;
import com.ideas2it.service.impl.UserServiceImpl;
import com.ideas2it.constants.Messages;
import com.ideas2it.exception.CustomException;
import com.ideas2it.logger.CustomLogger;

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
public class CRMServiceImpl implements CRMService {
    private UserService userService;
    private CustomLogger logger;

    public CRMServiceImpl() {
        this.userService = new UserServiceImpl();
        this.logger = new CustomLogger(CRMService.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserByEmailAndPassword(String email, String password) 
                                                throws CustomException {
        logger.info("===== Inside the CRM Service =====");
        User user = userService.getUserByEmailAndPassword(email, password);

        if (null == user) {
	    throw new CustomException(Messages.USER_NOT_FOUND);
	} 
	return user;
    }
}