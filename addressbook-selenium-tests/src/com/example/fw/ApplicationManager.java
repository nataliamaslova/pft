package com.example.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by nataliamaslova on 8/2/2014.
 */
public class ApplicationManager {

    public WebDriver driver;
    public String baseUrl;

    public NavigationHelper navigationHelper;
    public GroupHelper groupHelper;
    public ContactHelper contactHelper;

    public ApplicationManager() {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        navigationHelper = new NavigationHelper(this);
        groupHelper = new GroupHelper(this);
        contactHelper = new ContactHelper(this);
    }

    public void stop() {
        driver.quit();
    }

}
