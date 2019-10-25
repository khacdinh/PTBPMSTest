package com.btbms.pages.navigation;

import com.btbms.config.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenuSelector {
    public static void select(String mainMenuXpath,String subMenuXpath) {
        Actions action = new Actions(Driver.driver);
        WebElement mainMenu = Driver.driver.findElement(By.xpath(mainMenuXpath));
        action.moveToElement(mainMenu);
        WebElement subMenu = Driver.driver.findElement(By.xpath(subMenuXpath));
        action.moveToElement(subMenu).click().build().perform();
    }
}
