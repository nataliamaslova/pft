package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by nataliamaslova on 8/2/2014.
 */
public abstract class WebDriverHelperBase extends HelperBase {

    protected WebDriver driver;
    private WebDriverWait wait;

    public WebDriverHelperBase(ApplicationManager manager) {
        super(manager);
        this.driver = manager.getDriver();
        wait = new WebDriverWait(driver, 10);
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
        try {
            return driver.findElement(by);
        } catch (Exception e)  {
            return null;
        }
    }

    protected List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

}
