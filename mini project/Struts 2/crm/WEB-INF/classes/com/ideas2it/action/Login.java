package com.ideas2it.action;

import com.ideas2it.model.User;
import com.ideas2it.service.UserService;
import com.ideas2it.service.impl.UserServiceImpl;

public class Login {
    private String email;
    private String password;

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String execute() {
        UserService userService = new UserServiceImpl();
    
        User user = userService.getUserByEmailAndPassword(email, password);

        if (null == user) {    
            return "error";
        } 
        return "success";
    }

}