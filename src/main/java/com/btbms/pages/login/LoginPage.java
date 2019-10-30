package com.btbms.pages.login;

import com.btbms.config.Driver;
import com.btbms.config.PTBProperties;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private LoginPageAction act;
    private LoginPageVerify verify;

    public LoginPageAction act() {
        return act;
    }
    public LoginPageVerify verify() {
        return verify;
    }


    public static LoginPage getInstance() {
        LoginPage loginPage = PageFactory.initElements(Driver.driver, LoginPage.class);
        loginPage.act = PageFactory.initElements(Driver.driver, LoginPageAction.class);;
        loginPage.verify =  PageFactory.initElements(Driver.driver, LoginPageVerify.class);
        PTBProperties properties = PTBProperties.getInstance();
        String url = properties.getProperty("application.url.test");
        Driver.driver.get(url);
        return loginPage;

    }


}
