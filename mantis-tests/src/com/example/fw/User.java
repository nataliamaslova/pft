package com.example.fw;

/**
 * Created by nataliamaslova on 9/28/2014.
 */
public class User {
    public String login;
    public String email;
    public String password;

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

}
