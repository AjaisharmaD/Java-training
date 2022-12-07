package com.ideas2it.service;
import java.util.List;

import com.ideas2it.constants.Messages;
import com.ideas2it.exception.CustomException;
import com.ideas2it.logger.CustomLogger;
import com.ideas2it.model.User;
import com.ideas2it.service.UserService;

public class CRMService {
    private UserService userService;
    private CustomLogger logger;

    public CRMService() {
        this.userService = new UserService();
        this.logger = new CustomLogger(CRMService.class);
    }

    public User getByEmailAndPassword(String email,
                                      String password) throws CustomException {
        logger.info("inside crm service");
        User user = userService.getByEmailAndPassword(email, password);

        if (null != user) {
            return user;
        } 
        return null;
    }
}