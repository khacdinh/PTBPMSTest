package com.btbms.pages.login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageVerify {
    private WebDriver driver;

    public LoginPageVerify(WebDriver driver) {
        this.driver = driver;
    }

    public void valueAsExpected(By element, String expectedValue) {
        String result = driver.findElement(element).getText();
        Assert.assertEquals(expectedValue, result);
    }

    public void title(String titleExpected) {
        Assert.assertNotEquals(driver.getTitle(), titleExpected);
    }

}
