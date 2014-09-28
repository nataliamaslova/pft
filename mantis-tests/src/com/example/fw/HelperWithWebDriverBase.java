package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by nataliamaslova on 9/28/2014.
 */
public class HelperWithWebDriverBase {

    protected ApplicationManager manager;
    protected WebDriver driver;
    protected WebDriverHelper webDriverHelper;

    public HelperWithWebDriverBase(ApplicationManager manager) {
        this.manager = manager;
//        this.driver = manager.getWebDriverHelper().
    }

    protected void openUrl(String string) {
        driver.get(manager.getProperty("baseUrl") + string);
    }

    protected void openAbsoluteUrl(String string) {
        driver.get(string);
    }

    protected void type(By locator, String text) {
        if (text != null) {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void selectByText(By locator, String text) {
        if (text != null) {
            new Select(driver.findElement(locator)).selectByVisibleText(text);
        }
    }

    protected WebElement findElement(By by) {
        return driver.findElement(by);
    }

    protected List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    protected void delayInMs(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
