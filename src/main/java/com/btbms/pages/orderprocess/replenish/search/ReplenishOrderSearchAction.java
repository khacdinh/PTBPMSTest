package com.btbms.pages.orderprocess.replenish.search;

import com.btbms.pages.constants.ReplenishOrderConstants;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ReplenishOrderSearchAction extends PageObject {

    @FindBy(id = ReplenishOrderConstants.RPORDERNO_ID)
    private WebElement rpOrderNo;

    @FindBy(id = "registeruser")
    private WebElement registerUser;

    @FindBy(id = "responsibledept")
    private WebElement responsibleDept;

    @FindBy(id = "sapmono")
    private WebElement sapMoNo;

    @FindBy(id = "customerno")
    private WebElement customerNo;

    @FindBy(id = "searchRpohead_orderdate")
    private WebElement rpoHeadOrderDateStart;

    @FindBy(id = "searchRpohead_toOrderDate")
    private WebElement rpoHeadToOrderDateEnd;

    @FindBy(id = "rporderstatus")
    private WebElement orderStatusStart;

    @FindBy(id = "toOrderStatus")
    private WebElement orderStatusEnd;

    @FindBy(id = "btnSearch")
    private WebElement btnSearch;


    public ReplenishOrderSearchAction byReplenishOrderNo(String value) {
        rpOrderNo.clear();
        rpOrderNo.sendKeys(value);
        return this;
    }


    public ReplenishOrderSearchAction byRegisterUser(String value) {
        registerUser.sendKeys(value);
        return this;
    }


    public ReplenishOrderSearchAction selectResponsibleDepartment(String value) {
        responsibleDept.sendKeys(value);
        return this;
    }


    public ReplenishOrderSearchAction bySAPMONo(String value) {
        sapMoNo.sendKeys(value);
        return this;
    }


    public ReplenishOrderSearchAction byCustomerNo(String value) {
        customerNo.sendKeys(value);
        return this;
    }


    public ReplenishOrderSearchAction byOrderCreationDateFrom(String value) {
        rpoHeadOrderDateStart.sendKeys(value);
        return this;
    }

    public ReplenishOrderSearchAction byOrderCreationDateEnd(String value) {
        rpoHeadToOrderDateEnd.sendKeys(value);
        return this;
    }

    public ReplenishOrderSearchAction selectOrderStatusStart(String value) {
        orderStatusStart.sendKeys(value);
        return this;
    }

    public ReplenishOrderSearchAction selectOrderStatusEnd(String value) {
        orderStatusEnd.sendKeys(value);
        return this;
    }

    public void clickBtnSearch() {
        btnSearch.click();
    }
}
