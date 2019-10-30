package com.test.ptbms.login;

import com.btbms.config.Driver;
import com.btbms.listeners.ScreenshotListener;
import com.btbms.pages.login.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private static final String LOGIN_TITLE = "PTBPMS | Login";
    private static final String WRONG_USERNAME_PASSWORD_MESSAGE = "Your login attempt was not successful, try again.\n" +
            "Caused : Incorrect Password! (USRLOGIN00001)";
    private By messageError = By.className("alert-danger");
    private LoginPage loginPage;

    @BeforeMethod
    public void init() {
        Driver.setUp();
        loginPage = LoginPage.getInstance();
    }

    @Test(priority = 1)
    public void user_wrong_password_login() throws Exception {
        loginPage.act().enterUserName("DINO.NGUYEN").enterPassword("ABC123").clickLogin();
        loginPage.verify().valueAsExpected(messageError, WRONG_USERNAME_PASSWORD_MESSAGE);
        Driver.driver.quit();
    }

    @Test(priority = 2)
    public void user_can_login() throws Exception {
        loginPage.act().enterUserName("DINO.NGUYEN").enterPassword("Lawson123").clickLogin();
        loginPage.verify().title(LOGIN_TITLE);
        Driver.driver.quit();
    }

}