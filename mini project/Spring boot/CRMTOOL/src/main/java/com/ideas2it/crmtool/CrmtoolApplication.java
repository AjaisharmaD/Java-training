package com.ideas2it.crmtool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrmtoolApplication {

    public static void main(String[] args) {
        System.out.println("Spring Boot is Running");
        SpringApplication.run(CrmtoolApplication.class, args);
    }

}
