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
        click(By.linkText("add new"));
    }

    public void gotoGroupsPage() {
        click(By.linkText("groups"));
    }

    public void gotoHomePage() {
        click(By.linkText("home page"));
    }

}
