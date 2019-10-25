package com.btbms.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static final String URL = "http://132.147.72.181:8383/PTBPMS/";
    private static final String DASHBOARD_TITLE = "PTBPMS: Dashboard";
    private static final String WRONG_USERNAME_PASSWORD_MESSAGE = "Your login attempt was not successful, try again.\n" +
            "Caused : Incorrect Password! (USRLOGIN00001)";

    private LoginPageAction act;
    private LoginPageVerify verify;

    private WebDriver driver;

    public LoginPageAction act() {
        return act;
    }


    public LoginPageVerify verify() {
        return verify;
    }

    public static LoginPage getInstance(WebDriver driver, LoginPageAction act, LoginPageVerify verify) {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.act = act;
        loginPage.verify = verify;
        driver.get(URL);
        return loginPage;

    }

    public static LoginPage getInstance(WebDriver driver, LoginPageAction act) {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.act = act;
        driver.get(URL);

        return loginPage;
    }

}
