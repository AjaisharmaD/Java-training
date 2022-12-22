package com.ideas2it.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.ideas2it.model.User;
import com.ideas2it.service.UserService;
import com.ideas2it.service.impl.UserServiceImpl;
import com.ideas2it.constants.Constants;

public class Login extends ActionSupport implements SessionAware {
    private String email;
    private String password;
    private SessionMap<String, Object> sessionMap;
    private UserService userService = new UserServiceImpl();

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

    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap)map;
    }

    public String execute() {
        String result = LOGIN;
        User user = userService.getUserByEmailAndPassword(email, password);

        if (null != user) {    
            sessionMap.put("roleId", Constants.ADMIN_ROLE_ID);
            result = SUCCESS;
        } 
        return result;
    }

}