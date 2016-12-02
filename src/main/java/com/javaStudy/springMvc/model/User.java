package com.javaStudy.springMvc.model;

/**
 * Created by mmikilchenko on 02.12.2016.
 */
import org.springframework.stereotype.Component;


@Component
public class User {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
