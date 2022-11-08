package com.ideas2it.service;
import java.util.List;

import com.ideas2it.constants.Messages;
import com.ideas2it.exception.NotFoundException;
import com.ideas2it.model.User;
import com.ideas2it.service.UserService;

public class CRMService {
    private UserService userService;

    public CRMService() {
        this.userService = new UserService();
    }

    public User validUser(String email, String password) throws NotFoundException {
        List<User> users = userService.getAll();

        for (User user: users) {
            if (user.getEmailId().equals(email) && user.getPassword().equals(password)) {
                return user;
            } 
        }
        return null;
    }
}