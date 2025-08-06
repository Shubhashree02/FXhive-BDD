package com.fxhive.pages;
import com.fxhive.utils.ConfigUtil;
import com.fxhive.core.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Parent class for every page object.
 * Holds generic Selenium actions and explicit–wait helpers.
 */
public abstract class BasePage {

    private static final int TIMEOUT = ConfigUtil.getTimeout();        // seconds
    private final WebDriver driver;
    private final WebDriverWait wait;

    protected BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    /* ----------- Core wait helpers ----------- */

    protected WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /* ----------- Common page actions ---------- */

    protected void click(By locator) {
        waitForClickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement e = waitForVisible(locator);
        e.clear();
        e.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForVisible(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        try {
            return waitForVisible(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected void selectByVisibleText(By locator, String text) {
        Select dropdown = new Select(waitForClickable(locator));
        dropdown.selectByVisibleText(text);
    }

    /* ----------- Browser-level helpers -------- */

    public void navigateTo(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
