package com.btbms.pages.orderprocess.replenish.CURDaction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReplenishOrderForm {
    @FindBy(id = "rpohead_rporderno")
    public WebElement replenishOrderNo;

    @FindBy(id = "rpohead_sapmono")
    public WebElement SAPMONo;

    @FindBy(id = "rpohead_modeliverydate")
    public WebElement SAPMODeliveryDate;

    @FindBy(id = "rpohead_customerno")
    public WebElement cusomterNo;

    @FindBy(id = "rpohead_finishproductqty")
    public WebElement finishProductQuantity;

    @FindBy(id = "rpohead_rpordertype")
    public WebElement ordertype;

    @FindBy(id = "rpohead_wiplocation")
    public WebElement WIPLocation;

    @FindBy(id = "rpohead_handlingsuggestion")
    public WebElement handlingSuggestion;

    @FindBy(id = "approval_liability1")
    public WebElement liabilityNoDep1;


    @FindBy(id = "approval_liability2")
    public WebElement liabilityNoDep2;

    @FindBy(id = "orderQty1")
    public WebElement orderQtyDept1;
    @FindBy(id = "orderQty2")
    public WebElement orderQtyDept2;
    @FindBy(id = "rpohead_orderreason")
    public WebElement orderReason;

    @FindBy(id = "rpohead_orderprocess")
    public WebElement orderprocess;

    @FindBy(id = "idBtnSubmitDept")
    public WebElement idBtnSubmitDept;

    @FindBy(id = "btnDefault")
    public WebElement btnSave;

    @FindBy(id = "btnDefault")
    public WebElement btnDelete;
}
