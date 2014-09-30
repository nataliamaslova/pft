package com.example.tests;

import com.example.fw.AccountHelper;
import com.example.fw.JamesHelper;
import com.example.fw.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by nataliamaslova on 9/28/2014.
 */
public class SignupTest extends TestBase {

    public User user = new User().setLogin("testuser3").setPassword("123456")
            .setEmail("testuser3@localhostl.localdomain");

    private JamesHelper james;

    private AccountHelper accHelper;

    @BeforeClass
    public void createMailUser() {
        james = app.getJamesHelper();
        accHelper = app.getAccountHelper();
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
        accHelper.signup(user);
        accHelper.login(user);
        assertThat(accHelper.loggedUser(user), equalTo(user.login));
    }
}
