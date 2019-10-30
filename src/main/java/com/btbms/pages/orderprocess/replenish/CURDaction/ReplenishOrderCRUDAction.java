package com.btbms.pages.orderprocess.replenish.CURDaction;

public class ReplenishOrderCRUDAction extends ReplenishOrderForm {

    /*
     * START Create Part
     */
    public ReplenishOrderCRUDAction selectOrderType(String value) {
        ordertype.sendKeys(value);
        return this;
    }

    public ReplenishOrderCRUDAction withSAPMONo(String value) {
        this.SAPMONo.sendKeys(value);
        return this;
    }

    public ReplenishOrderCRUDAction withSAPMODeliveryDate(String value) {
        this.SAPMODeliveryDate.sendKeys(value);
        return this;
    }

    public ReplenishOrderCRUDAction withCustomerNo(String value) {
        this.cusomterNo.sendKeys(value);
        return this;
    }


    public ReplenishOrderCRUDAction withFinishProductQuantity(String value) {
        this.finishProductQuantity.sendKeys(value);
        return this;
    }

    public ReplenishOrderCRUDAction withWIPLocation(String value) {
        this.WIPLocation.sendKeys(value);
        return this;
    }

    public ReplenishOrderCRUDAction selectHandlingSuggestion(String value) {
        this.handlingSuggestion.sendKeys(value);
        return this;
    }

    public ReplenishOrderCRUDAction selectLiabilityNoDep1(String value) {
        this.liabilityNoDep1.sendKeys(value);
        return this;
    }

    public ReplenishOrderCRUDAction selectLiabilityNoDep2(String value) {
        this.liabilityNoDep2.sendKeys(value);
        return this;
    }

    public ReplenishOrderCRUDAction withOrderQtyDep1(String value) {
        this.orderQtyDept1.clear();
        this.orderQtyDept1.sendKeys(value);
        return this;
    }

    public ReplenishOrderCRUDAction withOrderQtyDep2(String value) {
        this.orderQtyDept2.clear();
        this.orderQtyDept2.sendKeys(value);
        return this;
    }

    public ReplenishOrderCRUDAction withOrderReason(String value) {
        this.orderReason.sendKeys(value);
        return this;
    }

    public ReplenishOrderCRUDAction withOrderProcess(String value) {
        orderprocess.sendKeys(value);
        return this;
    }


    public void clickButtonSubmitToDept() {
        idBtnSubmitDept.click();
    }

    public void clickSave() {
        btnSave.click();
    }

    public void clickDelete() {
        btnDelete.click();
    }

    /*
     * END Create Part
     */
}
