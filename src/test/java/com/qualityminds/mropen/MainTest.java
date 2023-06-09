package com.qualityminds.mropen;

import com.qualityminds.mropen.constants.BrowserType;
import com.qualityminds.mropen.constants.Envs;
import com.qualityminds.mropen.driver.Login;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void test() {
        Login login = new Login(BrowserType.valueOf("CHROME"), true);
        login.openPage(Envs.valueOf("PROD"));
        login.close();
    }
}
