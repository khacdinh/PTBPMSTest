package com.btbms.pages.login;


import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageObject {
    private LoginPageAction act;
    private LoginPageVerify verify;

    @Managed
    WebDriver driver;

    public LoginPageAction act() {
        return act;
    }

    public LoginPageVerify verify() {
        return verify;
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        open();
        this.act = PageFactory.initElements(driver, LoginPageAction.class);
        this.verify = PageFactory.initElements(driver, LoginPageVerify.class);

    }

}
