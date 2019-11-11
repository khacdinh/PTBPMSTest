package com.btbms.pages.navigation;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenuSelector extends PageObject {

    @Managed
    WebDriver driver;

    public MenuSelector(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public void select(String mainMenuXpath, String subMenuXpath) {
        Actions action = new Actions(this.driver);
        WebElement mainMenu = this.driver.findElement(By.xpath(mainMenuXpath));
        action.moveToElement(mainMenu);
        WebElement subMenu = this.driver.findElement(By.xpath(subMenuXpath));
        action.moveToElement(subMenu).click().build().perform();
    }
}
