package com.test.ptbms.base;

import com.btbms.config.Driver;
import com.btbms.listeners.ScreenshotListener;
import com.btbms.pages.login.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;


@Listeners(ScreenshotListener.class)
public class BaseTest {
    @BeforeTest
    public void init() {
        Driver.setUp();
        Driver.driver.manage().deleteAllCookies();
        LoginPage loginPage = LoginPage.getInstance();
        loginPage.act().enterUserName("DINO.NGUYEN").enterPassword("Lawson123").clickLogin();
    }

    @AfterTest
    public void clean() {
        Driver.driver.quit();
    }

}
