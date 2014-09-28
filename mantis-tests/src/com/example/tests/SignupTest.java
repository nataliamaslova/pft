package com.example.tests;

import com.example.fw.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by nataliamaslova on 9/28/2014.
 */
public class SignupTest extends TestBase {

    public User user = new User().setLogin("testuser2").setPassword("123456")
            .setEmail("testuser2@localhost.localdomain");

    @BeforeClass
    public void createUser() {
        if (!app.getJamesHelper().doesUserExist(user.login)) {
            app.getJamesHelper().createUser(user.login, user.password);
        }
    }

    @AfterClass
    public void deleteMailUser() {
        if (app.getJamesHelper().doesUserExist(user.login)) {
            app.getJamesHelper().deleteUser(user.login);
        }
    }

    @Test
    public void newUserShouldSignup() {
        app.getAccountHelper().signup(user);
        assertTrue(app.getAccountHelper().isLogged(user.login));
    }
}
