package com.btbms.pages.login;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

public class LoginStep {
    public LoginPage loginPage;
    private static final String LOGIN_TITLE = "PTBPMS | Login";
    private static final String WRONG_USERNAME_PASSWORD_MESSAGE = "Your login attempt was not successful, try again.\n" +
            "Caused : Incorrect Password! (USRLOGIN00001)";
    private By messageError = By.className("alert-danger");

    @Step("Enter the userName {0} and password {1}")
    public void enter_username_and_password(String userName, String password) {
        loginPage.act().enterUserName(userName).enterPassword(password);
    }

    @Step("User click Login Button")
    public void click_login() {
        loginPage.act().clickLogin();
    }

    @Step
    public void should_not_in_login_page() {
        loginPage.verify().title(LOGIN_TITLE);
    }

    @Step
    public void should_not_login_page() {
        loginPage.verify().valueAsExpected(messageError, WRONG_USERNAME_PASSWORD_MESSAGE);
    }


}
