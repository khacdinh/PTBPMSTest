package com.test.ptbms.login;

import com.btbms.config.Driver;
import com.btbms.pages.login.LoginPage;
import com.btbms.pages.login.LoginPageAction;
import com.btbms.pages.login.LoginPageVerify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    private static final String DASHBOARD_TITLE = "PTBPMS: Dashboard";
    private static final String WRONG_USERNAME_PASSWORD_MESSAGE = "Your login attempt was not successful, try again.\n" +
            "Caused : Incorrect Password! (USRLOGIN00001)";
    private By messageError = By.className("alert-danger");
    private LoginPageAction act;
    private LoginPageVerify verify;
    private LoginPage loginPage;

    //@BeforeTest
    public void init() {
        Driver.Inittialize();
        WebDriver driver = Driver.driver;
        act = PageFactory.initElements(driver, LoginPageAction.class);
        verify = PageFactory.initElements(driver, LoginPageVerify.class);
        loginPage = LoginPage.getInstance(driver, act, verify);
    }

   // @Test(priority = 1)
    public void user_wrong_password_login() throws Exception {
        loginPage.act().enterUserName("DINO.NGUYEN").enterPassword("ABC123").clickLogin();
        loginPage.verify().valueAsExpected(messageError, WRONG_USERNAME_PASSWORD_MESSAGE);
    }

  //  @Test(priority = 2)
    public void user_can_login() throws Exception {
        loginPage.act().enterUserName("DINO.NGUYEN").enterPassword("Lawson123").clickLogin();
        loginPage.verify().title(DASHBOARD_TITLE);
    }

    //@AfterTest
    public void clean() {
        Driver.driver.close();
    }
}