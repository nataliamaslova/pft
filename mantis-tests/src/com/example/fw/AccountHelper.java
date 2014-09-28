package com.example.fw;

import org.openqa.selenium.By;

/**
 * Created by nataliamaslova on 9/28/2014.
 */
public class AccountHelper extends HelperWithWebDriverBase {

    public AccountHelper(ApplicationManager manager) {
        super(manager);
    }


    public void signup(User user)  {
        openUrl("/");
        click(By.cssSelector("span.bracket-link"));
        type(By.name("username"), user.login);
        type(By.name("email"), user.email);
        click(By.cssSelector("input.button"));

        pause(3000);
        Msg msg = manager.getMailHelper().getNewMail(user.login, user.password);
        String confirmationLink = msg.getConfirmationLink();

        openAbsoluteUrl(confirmationLink);
        type(By.name("password"), user.password);
        type(By.name("password_confirm"), user.password);
        click(By.cssSelector("input.button"));
    }

    public boolean isLogged(String re) {
        return false;
    }
}
