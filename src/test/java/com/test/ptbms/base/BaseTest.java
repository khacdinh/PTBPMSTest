package com.test.ptbms.base;

import com.btbms.config.Driver;
import com.btbms.listeners.ScreenshotListener;
import com.btbms.pages.login.LoginPage;
import com.btbms.pages.login.LoginPageAction;
import com.btbms.pages.login.LoginPageVerify;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;


@Listeners(ScreenshotListener.class)
public class BaseTest {
    private LoginPageAction act;
    private LoginPageVerify verify;
    private LoginPage loginPage;

    @BeforeTest
    public void init() {
        Driver.Inittialize();
        WebDriver driver = Driver.driver;
        act = PageFactory.initElements(driver, LoginPageAction.class);
        verify = PageFactory.initElements(driver, LoginPageVerify.class);
        loginPage = LoginPage.getInstance(driver, act, verify);
        loginPage.act().enterUserName("DINO.NGUYEN").enterPassword("Lawson123").clickLogin();
    }

    @AfterTest
    public void clean() {
        Driver.driver.close();
    }
}
