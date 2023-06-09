package com.qualityminds.mropen.driver;

import com.qualityminds.mropen.constants.BrowserType;
import com.qualityminds.mropen.wdm.DriverManagerFactory;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseDriver {

    private final WebDriverWait wait;
    private final ThreadLocal<WebDriver> driver;

    protected BaseDriver(BrowserType browserType, long timeout, boolean isHeadless) {
        this.driver = new ThreadLocal<>();
        driver.set(isHeadless
                ? DriverManagerFactory.getManager(browserType).createDriverHeadless()
                : DriverManagerFactory.getManager(browserType).createDriver());
        this.wait = new WebDriverWait(driver.get(), Duration.ofSeconds(timeout));
    }

    protected WebDriver driver() {
        return driver.get();
    }

    public void close() {
        driver.get().quit();
    }

    protected <T> WebElement getClickableElement(T locator) {
        return wait.until(isBy(locator)
                ? ExpectedConditions.elementToBeClickable((By) locator)
                : ExpectedConditions.elementToBeClickable((WebElement) locator));
    }

    protected <T> WebElement getVisibleElement(T locator) {
        return wait.until(isBy(locator)
                ? ExpectedConditions.visibilityOfElementLocated((By) locator)
                : ExpectedConditions.visibilityOf((WebElement) locator));
    }

    protected WebElement getExistingElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        // return ExpectedConditions.presenceOfElementLocated(locator).apply(driver());
    }

    protected void waitForTitle(String title) {
        wait.until(ExpectedConditions.titleIs(title));
    }

    private <T> boolean isBy(@NotNull T value) {
        return value.getClass().getName().contains("By");
    }

}
