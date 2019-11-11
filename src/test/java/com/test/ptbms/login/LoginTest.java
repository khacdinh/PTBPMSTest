package com.test.ptbms.login;

import com.btbms.pages.login.LoginStep;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest {
    @Managed
    WebDriver driver;

    @Steps
    LoginStep loginStep;

    @Test
    public void  userLoginOK() {
        loginStep.enter_username_and_password("DINO.NGUYEN","Lawson123");
        loginStep.click_login();
        loginStep.should_not_in_login_page();
    }

    @Test
    public void  userLoginNOK() {
        loginStep.enter_username_and_password("DINO.NGUYEN","Lawson2123");
        loginStep.click_login();
        loginStep.should_not_login_page();
    }
}
