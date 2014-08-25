package com.example.fw;

import org.openqa.selenium.By;

/**
 * Created by nataliamaslova on 8/2/2014.
 */
public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void mainPage() {
        if (! onMainPage()) {
            click(By.linkText("home"));
        }
    }

    public void contactPage() {
        if (! onContactPage()) {
            click(By.linkText("add new"));
        }
    }

    public void groupsPage() {
        if (! onGroupsPage()) {
            click(By.linkText("groups"));
        }
    }

    public void gotoHomePage() {
        click(By.linkText("home page"));
    }

    private boolean onMainPage() {
        return driver.findElements(By.id("maintable")).size() > 0;
    }

    private boolean onGroupsPage() {
        if (driver.getCurrentUrl().contains("/group.php")
                && driver.findElements(By.name("new")).size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean onContactPage() {
        return driver.findElements(By.xpath("//h1[contains(text(),'Edit / add address book entry')]")).size() > 0;
    }

}
