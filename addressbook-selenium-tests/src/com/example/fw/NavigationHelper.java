package com.example.fw;

import org.openqa.selenium.By;

/**
 * Created by nataliamaslova on 8/2/2014.
 */
public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openMainPage() {
        driver.get(manager.baseUrl + "/addressbookv4.1.4/");
    }

    public void gotoContactPage() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void gotoGroupsPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void gotoHomePage() {
        driver.findElement(By.linkText("home page")).click();
    }

}
