package com.example.tests;

import com.example.fw.User;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by nataliamaslova on 9/28/2014.
 */
public class SignupTest extends TestBase {

    @Test
    public void newUserShouldSignup() {
        User user = new User().setLogin("testuser1").setPassword("123456").setEmail("testuser1@localhost.localdomain");
        app.getAccountHelper().signup(user);
        assertTrue(app.getAccountHelper().isLogged(user.login));
    }
}
