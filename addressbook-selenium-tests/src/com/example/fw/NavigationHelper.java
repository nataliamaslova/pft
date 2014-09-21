package com.example.fw;

import org.openqa.selenium.By;

/**
 * Created by nataliamaslova on 8/2/2014.
 */
public class NavigationHelper extends WebDriverHelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void mainPage() {
        if (! onMainPage()) {
            click(By.linkText("home"));
            delayInMs(200);
        }
    }

    public void contactPage() {
        if (! onContactPage()) {
            click(By.linkText("add new"));
            delayInMs(200);
        }
    }

    public void groupsPage() {
        if (! onGroupsPage()) {
            click(By.linkText("groups"));
            delayInMs(200);
        }
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
        return driver.findElements(By.name("submit")).size() > 0;
    }

}
