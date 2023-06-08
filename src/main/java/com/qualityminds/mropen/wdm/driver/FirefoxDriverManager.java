package com.qualityminds.mropen.wdm.driver;

import com.qualityminds.mropen.wdm.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager implements DriverManager {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.firefoxdriver().cachePath("drivers").setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @Override
    public WebDriver createDriverHeadless() {
        return null;
//        WebDriverManager.firefoxdriver().cachePath("drivers").setup();
//        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("--window-size=1920,1080", "-headless");
//        return new FirefoxDriver(options);
    }
}
