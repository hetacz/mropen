package com.qualityminds.mropen.wdm;


import com.qualityminds.mropen.constants.BrowserType;
import com.qualityminds.mropen.wdm.driver.ChromeDriverManager;
import com.qualityminds.mropen.wdm.driver.EdgeDriverManager;
import com.qualityminds.mropen.wdm.driver.FirefoxDriverManager;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class DriverManagerFactory {

    @Contract("_ -> new")
    public @NotNull DriverManager getManager(@NotNull BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                return new ChromeDriverManager();
            case FIREFOX:
                return new FirefoxDriverManager();
            case EDGE:
                return new EdgeDriverManager();
            default:
                throw new IllegalArgumentException();
        }
    }
}
