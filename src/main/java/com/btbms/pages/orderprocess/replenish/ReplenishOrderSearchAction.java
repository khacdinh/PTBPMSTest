package com.btbms.pages.orderprocess.replenish;

import com.btbms.pages.commons.ReplenishOrderConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReplenishOrderSearchAction {

    private WebDriver driver;

    public ReplenishOrderSearchAction(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = ReplenishOrderConstants.RPORDERNO_ID)
    private WebElement rpOrderNo;

    @FindBy(id = ReplenishOrderConstants.REGISTERUSER_ID)
    private WebElement registerUser;

    @FindBy(id = ReplenishOrderConstants.RESPONSIBLE_DEPT_ID)
    private WebElement responsibleDept;

    @FindBy(id = ReplenishOrderConstants.SAPMO_NO_ID)
    private WebElement sapMoNo;

    @FindBy(id = ReplenishOrderConstants.CUSTOMER_NO_ID)
    private WebElement customerNo;

    @FindBy(id = ReplenishOrderConstants.SEARCH_RPO_HEAD_ORDER_DATE_START_ID)
    private WebElement rpoHeadOrderDateStart;

    @FindBy(id = ReplenishOrderConstants.SEARCH_RPOHEAD_TO_ORDER_DATE_ID)
    private WebElement rpoHeadToOrderDateEnd;

    @FindBy(id = ReplenishOrderConstants.RP_FROM_ORDER_STATUS_ID)
    private WebElement orderStatusStart;

    @FindBy(id = ReplenishOrderConstants.TO_ORDER_STATUS_ID)
    private WebElement orderStatusEnd;

    @FindBy(id = "btnSearch")
    private WebElement btnSearch;

    public ReplenishOrderSearchAction byReplenishOrderNo(String value) {
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
