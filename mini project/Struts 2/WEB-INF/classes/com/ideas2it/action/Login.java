package com.ideas2it.action;

import com.ideas2it.service.Sample;

public class Login {
    private int id;
    private String email;
    private String password;

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    public String login() {
        Sample sample = new Sample();
        String samString = sample.sampleMethod(email);

        if (samString != null) {
            return "success";
        } 
        return "error";
    }
}