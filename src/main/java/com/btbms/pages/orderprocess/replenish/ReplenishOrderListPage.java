package com.btbms.pages.orderprocess.replenish;

import com.btbms.config.Driver;
import com.btbms.pages.constants.ReplenishOrderConstants;
import com.btbms.pages.orderprocess.replenish.CURDaction.ReplenishOrderCRUDAction;
import com.btbms.pages.orderprocess.replenish.CURDaction.ReplenishOrderCRUDVerify;
import com.btbms.pages.orderprocess.replenish.search.ReplenishOrderSearchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReplenishOrderListPage {

    //Create
    private ReplenishOrderCRUDAction act;
    private ReplenishOrderCRUDVerify verify;

    //Search
    private ReplenishOrderSearchAction searchOrder;
    private ReplenishOrderTableVerify verifyResult;

    //View

    public static ReplenishOrderListPage getInstance() {
        ReplenishOrderListPage replenishOrderListPage = PageFactory.initElements(Driver.driver, ReplenishOrderListPage.class);
        replenishOrderListPage.verifyResult = PageFactory.initElements(Driver.driver, ReplenishOrderTableVerify.class);
        replenishOrderListPage.act = PageFactory.initElements(Driver.driver, ReplenishOrderCRUDAction.class);
        replenishOrderListPage.verify = PageFactory.initElements(Driver.driver, ReplenishOrderCRUDVerify.class);
        replenishOrderListPage.searchOrder = PageFactory.initElements(Driver.driver, ReplenishOrderSearchAction.class);

        return replenishOrderListPage;
    }

    public ReplenishOrderSearchAction filter() {
        return searchOrder;
    }

    public ReplenishOrderTableVerify verifyResult() {

        return verifyResult;
    }


    public String getReplenishOrderNo() {
        return Driver.driver.findElement(By.id("rpohead_rporderno")).getText();

    }

    public void clickNewBtn() {
        Driver.driver.findElement(newButtonName()).click();
    }

    private static By newButtonName() {
        return By.xpath("//*[@id=\"searchRpohead\"]/div[2]/table/tbody/tr/td/input[2]");
    }
    public static void clickViewBtn() {
        clickButton(ReplenishOrderConstants.VIEW_REPLENISH_ORDER_LIST_XPATH);
    }


    public static void clickEditBtn() {
        clickButton(ReplenishOrderConstants.EDIT_REPLENISH_ORDER_LIST_XPATH);
    }

    public static void clickDeleteBtn() {
        clickButton(ReplenishOrderConstants.DELETE_REPLENISH_ORDER_LIST_XPATH);
    }

    private static void clickButton(By buttonType) {
        WebElement tables = Driver.driver.findElement(ReplenishOrderConstants.REPLENISH_ORDER_LIST_TABLE_XPATH);
        List<WebElement> rowsTables = tables.findElements(By.tagName("tr"));
        for (WebElement rowsTable : rowsTables) {
            List<WebElement> links = rowsTable.findElements(By.id("navbar"));
            for (WebElement link : links) {
                Actions action = new Actions(Driver.driver);
                action.moveToElement(link);
                action.perform();
                rowsTable.findElement(buttonType).click();
                return;
            }
        }
    }

    public ReplenishOrderCRUDAction action() {
        return act;
    }

    public ReplenishOrderCRUDVerify verify() {
        return verify;
    }
}
