package com.btbms.pages.orderprocess.replenish.create;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReplenishOrderCreateAction {
    private WebDriver driver;

    public ReplenishOrderCreateAction(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "rpohead_sapmono")
    private WebElement rpoheadSapmono;

    @FindBy(id = "rpohead_modeliverydate")
    private WebElement rpoheadModeliverydate;

    @FindBy(id = "rpohead_finishproductqty")
    private WebElement rpoheadFinishproductqty;

    @FindBy(id = "rpohead_rpordertype")
    private WebElement rpoheadRpordertype;

    @FindBy(id = "rpohead_wiplocation")
    private WebElement rpoheadWiplocation;

    @FindBy(id = "rpohead_handlingsuggestion")
    private WebElement rpoheadHandlingsuggestion;

    @FindBy(id = "approval_liability1")
    private WebElement approvalLiability1;

    @FindBy(id = "approval_liability2")
    private WebElement approvalLiability2;

    @FindBy(id = "orderQty1")
    private WebElement orderQty1;
    @FindBy(id = "orderQty2")
    private WebElement orderQty2;
    @FindBy(id = "rpohead_orderreason")
    private WebElement rpoheadOrderreason;

    @FindBy(id = "rpohead_orderprocess")
    private WebElement rpoheadOrderprocess;

    @FindBy(id = "idBtnSubmitDept")
    private WebElement idBtnSubmitDept;

    @FindBy(id = "btnDefault")
    private WebElement btnSave;


    /*
     * START Create Part
     */
    public ReplenishOrderCreateAction selectOrderType(String value) {
        rpoheadRpordertype.sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction withSAPMONo(String value) {
        this.rpoheadSapmono.sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction withSAPMODeliveryDate(String value) {
        this.rpoheadModeliverydate.sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction withFinishProductQuantity(String value) {
        this.rpoheadFinishproductqty.sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction withWIPLocation(String value) {
        this.rpoheadWiplocation.sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction selectHandlingSuggestion(String value) {
        this.rpoheadHandlingsuggestion.sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction selectLiabilityNoDep1(String value) {
        this.approvalLiability1.sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction selectLiabilityNoDep2(String value) {
        this.approvalLiability2.sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction withOrderQtyDep1(String value) {
        this.orderQty1.clear();
        this.orderQty1.sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction withOrderQtyDep2(String value) {
        this.orderQty2.clear();
        this.orderQty2.sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction withOrderReason(String value) {
       this.rpoheadOrderreason.sendKeys(value);
        return this;
    }

    public ReplenishOrderCreateAction withOrderProcess(String value) {
        rpoheadOrderprocess.sendKeys(value);
        return this;
    }

    public void clickButtonSubmitToDept() {
        idBtnSubmitDept.click();
    }

    public  void clickSave() {
        btnSave.click();
    }

    /*
     * END Create Part
     */
}
