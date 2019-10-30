package com.btbms.pages.orderprocess.replenish;

import com.btbms.config.Driver;
import com.btbms.pages.enums.Action;
import com.btbms.pages.orderprocess.replenish.create.ReplenishOrderCreateAction;
import com.btbms.pages.orderprocess.replenish.create.ReplenishOrderCreateVerify;
import com.btbms.pages.orderprocess.replenish.search.ReplenishOrderSearchAction;
import com.btbms.pages.orderprocess.replenish.search.ReplenishOrderSearchVerify;
import com.btbms.pages.orderprocess.replenish.table.ReplenishOrderListTable;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class ReplenishOrderListPage {

    //Create
    private ReplenishOrderCreateAction act;
    private ReplenishOrderCreateVerify createVerify;

    //Search
    private ReplenishOrderSearchAction searchOrder;
    private ReplenishOrderTableVerify verifyResult;

    public static ReplenishOrderListPage getInstance(Action action) {
        ReplenishOrderListPage replenishOrderListPage = PageFactory.initElements(Driver.driver, ReplenishOrderListPage.class);
        replenishOrderListPage.verifyResult = PageFactory.initElements(Driver.driver, ReplenishOrderTableVerify.class);
        switch (action){
            case CREATE:
                replenishOrderListPage.act = PageFactory.initElements(Driver.driver, ReplenishOrderCreateAction.class);
                replenishOrderListPage.createVerify = PageFactory.initElements(Driver.driver, ReplenishOrderCreateVerify.class);
                break;
            case SEARCH:
                replenishOrderListPage.searchOrder = PageFactory.initElements(Driver.driver, ReplenishOrderSearchAction.class);
                break;
        }
        return replenishOrderListPage;
    }

    public ReplenishOrderSearchAction filter() {
        return searchOrder;
    }

    public ReplenishOrderTableVerify verifyResult(){

        return verifyResult;
    }


    public String getReplenishOrderNo() {
        return Driver.driver.findElement(By.id("rpohead_rporderno")).getText();

    }
    public void clickBtnNew() {
        Driver.driver.findElement(newButtonName()).click();
    }

    private static By newButtonName() {
        return By.xpath("//*[@id=\"searchRpohead\"]/div[2]/table/tbody/tr/td/input[2]");
    }

    public ReplenishOrderCreateAction action() {
        return act;
    }
    public ReplenishOrderCreateVerify createVerify() {
        return createVerify;
    }
}
