package com.qualityminds.mropen;

import com.qualityminds.mropen.constants.BrowserType;
import com.qualityminds.mropen.constants.Envs;
import com.qualityminds.mropen.driver.Login;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

@Slf4j
public class Main {

    private static final char EQUALS = '=';

    public static void main(String @NotNull [] args) {
        if (args.length != 4) {
            log.error("Wrong number of arguments. Expected 4, got {}", args.length);
            log.warn("Give args like this --username=user --password=pass --browser=chrome --env=dev");
            throw new IllegalArgumentException("Wrong number of arguments. Expected 4, got " + args.length);
        }
        String username = args[0].substring(args[0].indexOf(EQUALS) + 1);
        String password = args[1].substring(args[1].indexOf(EQUALS) + 1);
        String browser = args[2].substring(args[2].indexOf(EQUALS) + 1);
        String env = args[3].substring(args[3].indexOf(EQUALS) + 1);

        log.info("Username: {}, password: {}, browser: {}, env: {}", username, password, browser, env);

        Login login = new Login(BrowserType.valueOf(browser.toUpperCase()));
        login.openPage(Envs.valueOf(env.toUpperCase()));
        login.acceptCookies();
        login.clickLoginBtn();
        login.enterEmail(username);
        login.clickContinueBtn();
        login.enterPassword(password);
        login.clickFinalLoginBtn();
    }

}
