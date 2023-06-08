package com.qualityminds.mropen.driver;

import com.qualityminds.mropen.constants.BrowserType;
import com.qualityminds.mropen.constants.Envs;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

@Slf4j
public class Login extends BaseDriver {

    private final By shadowRootContainer = By.id("usercentrics-root");
    private final By appContainer = By.cssSelector("[data-testid='uc-app-container']");
    private final By acceptCookieBtn = By.cssSelector("[data-testid='uc-accept-all-button']");
    private final By loginBtn = By.cssSelector("button.login-button");
    private final By emailFld = By.id("email");
    private final By continueBtn = By.id("continue");
    private final By passwordFld = By.id("password");
    private final By finalLoginBtn = By.id("next");


    public Login(BrowserType browserType) {
        super(browserType, 10);
    }

    public void openPage(@NotNull Envs envs) {
        driver().get(envs.getUrl());
        waitForTitle("RiskSuite");
        log.info("Page loaded.");
    }

    public void acceptCookies() {
        SearchContext shadowRoot = getExistingElement(shadowRootContainer).getShadowRoot();
        getVisibleElement(shadowRoot.findElement(appContainer));
        getClickableElement(shadowRoot.findElement(acceptCookieBtn)).click();
    }

    public void clickLoginBtn() {
        getClickableElement(loginBtn).click();
        waitForTitle("Risk Suite | Location Risk Intelligence");
    }

    public void enterEmail(@NotNull String email) {
        getVisibleElement(emailFld).sendKeys(email);
    }

    public void clickContinueBtn() {
        getClickableElement(continueBtn).click();
        getVisibleElement(passwordFld);
    }

    public void enterPassword(@NotNull String password) {
        getVisibleElement(passwordFld).sendKeys(password);
    }

    public void clickFinalLoginBtn() {
        getClickableElement(finalLoginBtn).click();
        waitForTitle("RiskSuite");
    }
}
