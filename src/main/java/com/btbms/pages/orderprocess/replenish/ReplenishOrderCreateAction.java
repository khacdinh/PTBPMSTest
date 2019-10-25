package com.btbms.pages.orderprocess.replenish;

import com.btbms.pages.commons.ReplenishOrderConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class ReplenishOrderCreateAction {
    private WebDriver driver;

    public ReplenishOrderCreateAction(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = ReplenishOrderConstants.RPOHEAD_SAPMONOSTR)
    private WebElement rpoheadSapmono;

    /*
     * START Create Part
     */
    public ReplenishOrderCreateAction selectOrderType(String value) {
        this.select(ReplenishOrderConstants.RPOHEADP_PORDERTYPE, value);
        return this;
    }

    public ReplenishOrderCreateAction withSAPMONo(String value) {
        this.rpoheadSapmono.sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction withSAPMODeliveryDate(String value) {
        driver.findElement(ReplenishOrderConstants.RPOHEAD_MODELIVERYDATE).sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction withFinishProductQuantity(String value) {
        driver.findElement(ReplenishOrderConstants.RPOHEAD_FINISHPRODUCTQTY).sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction withWIPLocation(String value) {
        driver.findElement(ReplenishOrderConstants.RPOHEAD_WIPLOCATION).sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction selectHandlingSuggestion(String value) {
        driver.findElement(ReplenishOrderConstants.RPOHEAD_HANDLINGSUGGESTION).sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction selectLiabilityNoDep1(String value) {
        driver.findElement(ReplenishOrderConstants.APPROVAL_LIABILITY1).sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction selectLiabilityNoDep2(String value) {
        driver.findElement(ReplenishOrderConstants.APPROVAL_LIABILITY2).sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction withOrderQtyDep1(String value) {
        WebElement orderQt1 = driver.findElement(ReplenishOrderConstants.ORDER_QTY1);
        orderQt1.clear();
        orderQt1.sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction withOrderQtyDep2(String value) {
        WebElement orderQt2 = driver.findElement(ReplenishOrderConstants.ORDER_QTY2);
        orderQt2.clear();
        orderQt2.sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction withOrderReason(String value) {
        driver.findElement(ReplenishOrderConstants.RPOHEAD_ORDERREASON).sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction withOrderProcess(String value) {
        driver.findElement(ReplenishOrderConstants.RPOHEAD_ORDERPROCESS).sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return this;
    }

    public void clickButtonSubmitToDept() {
        driver.findElement(ReplenishOrderConstants.ID_BTN_SUBMIT_DEPT).click();
    }

    private void select(By selectionId, String value) {
        Select dropdown = new Select(driver.findElement(selectionId));
        dropdown.selectByVisibleText(value);
    }


    /*
     * END Create Part
     */
}
