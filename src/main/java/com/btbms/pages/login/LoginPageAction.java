package com.btbms.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageAction {

    private WebDriver driver;

    public LoginPageAction(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageAction enterUserName(String userName) {
        this.driver.findElement(By.id("idUser")).sendKeys(userName);
        return this;
    }

    public LoginPageAction enterPassword(String password) {
        this.driver.findElement(By.id("idPass")).sendKeys(password);
        return this;
    }

    public void clickLogin() {
        this.driver.findElement(By.id("btnSubmit")).click();
    }

}
