package com.btbms.pages.orderprocess.replenish;

import com.btbms.pages.commons.ReplenishOrderConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class ReplenishOrderCreateVerify {
    private WebDriver driver;
    public ReplenishOrderCreateVerify(WebDriver driver) {
        this.driver = driver;
    }

    public String getReplenishOrderNo() {
        return driver.findElement(By.id(ReplenishOrderConstants.RPORDERNO_ID)).getText();
    }

    public void replenishOrderNo(String expected, String result) {
        Assert.assertEquals(expected, result);
    }

    public void submitToSeniorDisable() {
        Assert.assertFalse(driver.findElement(ReplenishOrderConstants.ID_BTN_SUBMIT_SENIOR).isEnabled());
    }
}
