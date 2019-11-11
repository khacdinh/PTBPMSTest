package com.test.ptbms.base;

import com.btbms.pages.login.LoginStep;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@Ignore
public class BaseTest {
    @Managed
    WebDriver driver;

    @Steps
    LoginStep loginStep;

    @Before
    public void init() {
        loginStep.enter_username_and_password("DINO.NGUYEN", "Lawson123");
        loginStep.click_login();
    }


}
