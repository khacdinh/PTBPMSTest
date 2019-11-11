package com.btbms.pages.orderprocess.replenish.CURDaction;


import com.btbms.pages.constants.ReplenishOrderConstants;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ReplenishOrderCRUDVerify extends ReplenishOrderForm {
    @FindBy(id = "approvals0.liabilityno")
    public WebElement liabilityNoDep1View;

    @FindBy(id = "approvals1.liabilityno")
    public WebElement liabilityNoDep2View;

    @Managed
    WebDriver driver;

    public ReplenishOrderCRUDVerify(WebDriver driver) {
        this.driver = driver;
    }

    public String getReplenishOrderNo() {
        return this.driver.findElement(By.id(ReplenishOrderConstants.RPORDERNO_ID)).getText();
    }

    public void replenishOrderNoCreate(String expected, String result) {
        Assert.assertEquals(expected, result);
    }

    public void submitToSeniorDisable() {
        Assert.assertFalse(this.driver.findElement(By.id("idBtnSubmitSenior")).isEnabled());
    }


    //View verify
    public ReplenishOrderCRUDVerify replenishOrderNo(String expected) {
        Assert.assertEquals(this.driver.findElement(By.id("rpohead_rporderno")).getAttribute("value").trim(), expected);
        return this;
    }

    public ReplenishOrderCRUDVerify customerNo(String expected) {
        Assert.assertEquals(expected, cusomterNo.getAttribute("value").trim());
        return this;
    }

    public ReplenishOrderCRUDVerify isAllFieldsDisable() {
        validationReadOnly(replenishOrderNo, "Replenish Order No is not readonly");
        validationReadOnly(cusomterNo, "Customer No is not readonly");
        validationReadOnly(finishProductQuantity, "Finish Product Quantity is not readonly");
        validationReadOnly(WIPLocation, "WIP Location is not readonly");
        validationReadOnly(SAPMODeliveryDate, "SAP MO Delivery Date is not disable");
        validationReadOnly(finishProductQuantity, "Finish Product Quantity is not disable");
        validationReadOnly(WIPLocation, "WIP Location is not disable");
        validationReadOnly(orderQtyDept1, "Order Qty  Response Dept 1 is not disable");
        validationReadOnly(orderQtyDept2, "Order Qty  Response Dept 2 is not disable");
        validationReadOnly(orderReason, "Order Reason is not disable");
        validationReadOnly(orderprocess, "Order Process is not disable");

        validationDisabple(SAPMONo, "SAP MO No is not disable");
        validationDisabple(ordertype, "Order Type is not disable");
        validationDisabple(liabilityNoDep1View, "Liability No Response Dept 1 is not disable");
        validationDisabple(liabilityNoDep2View, "Liability No Response Dept 2 is not disable");

        validationDisabple(handlingSuggestion, "Handling Suggestion is not disable");

        return this;
    }

    private void validationReadOnly(WebElement element, String messageIfError) {
        // Assert.assertTrue(element.getAttribute("readOnly").equals("true"), messageIfError);

    }

    private void validationDisabple(WebElement element, String messageIfError) {
        //  Assert.assertFalse(element.isEnabled(), messageIfError);

    }
}
