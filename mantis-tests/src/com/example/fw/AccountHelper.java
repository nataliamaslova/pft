package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        delayInMs(10000);
        String msg = manager.getMailHelper().getNewMail(user.login, user.password);
        String confirmationLink = getConfirmationLink(msg);

        openAbsoluteUrl(confirmationLink);
        type(By.name("password"), user.password);
        type(By.name("password_confirm"), user.password);
        click(By.cssSelector("input.button"));
    }

    public String getConfirmationLink(String text) {
        Pattern regex = Pattern.compile("http\\S*");
        Matcher matcher = regex.matcher(text);
        if (matcher.find()) {
            return matcher.group();
        } else {
            return "";
        }
    }

    public void login(User user) {
        openUrl("/");
        type(By.name("username"), user.login);
        type(By.name("password"), user.password);
        click(By.cssSelector("input.button"));
    }

    public String loggedUser(User user) {
        WebElement element = findElement(By.cssSelector("td.login-info-left span"));
        return element.getText();
    }
}
