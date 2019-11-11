package com.btbms.pages.orderprocess.replenish;

import com.btbms.pages.constants.ReplenishOrderConstants;
import com.btbms.pages.navigation.MenuSelector;
import com.btbms.pages.orderprocess.replenish.CURDaction.ReplenishOrderCRUDAction;
import com.btbms.pages.orderprocess.replenish.CURDaction.ReplenishOrderCRUDVerify;
import com.btbms.pages.orderprocess.replenish.search.ReplenishOrderSearchAction;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@RunWith(SerenityRunner.class)
public class ReplenishOrderListPage extends PageObject {

    //Create
    private ReplenishOrderCRUDAction act;
    private ReplenishOrderCRUDVerify verify;

    //Search
    private ReplenishOrderSearchAction searchOrder;
    private ReplenishOrderTableVerify verifyResult;

    public MenuSelector menuSelector;

    @Managed
    WebDriver driver;

    public ReplenishOrderListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        menuSelector = PageFactory.initElements(driver, MenuSelector.class);
        this.verifyResult = PageFactory.initElements(this.driver, ReplenishOrderTableVerify.class);
        this.act = PageFactory.initElements(this.driver, ReplenishOrderCRUDAction.class);
        this.verify = PageFactory.initElements(this.driver, ReplenishOrderCRUDVerify.class);
        this.searchOrder = PageFactory.initElements(this.driver, ReplenishOrderSearchAction.class);
    }

    public void select_replenish_order_in_top_menu() {
        menuSelector.select("//*[@id=\"navbar\"]/li[2]/a", "//*[@id=\"navbar\"]/li[2]/ul/li[1]/a");
    }

    public ReplenishOrderSearchAction filter() {
        return searchOrder;
    }

    public ReplenishOrderTableVerify verifyResult() {

        return verifyResult;
    }

    public String getReplenishOrderNo() {
        return this.driver.findElement(By.id("rpohead_rporderno")).getText();

    }

    public void clickNewBtn() {
        this.driver.findElement(newButtonName()).click();
    }



    private static By newButtonName() {
        return By.xpath("//*[@id=\"searchRpohead\"]/div[2]/table/tbody/tr/td/input[2]");
    }

    public void clickViewBtn() {
        clickButton(ReplenishOrderConstants.VIEW_REPLENISH_ORDER_LIST_XPATH);
    }


    public void clickEditBtn() {
        clickButton(ReplenishOrderConstants.EDIT_REPLENISH_ORDER_LIST_XPATH);
    }

    public void clickDeleteBtn() {
        clickButton(ReplenishOrderConstants.DELETE_REPLENISH_ORDER_LIST_XPATH);
    }

    private void clickButton(By buttonType) {
        WebElement tables = this.driver.findElement(ReplenishOrderConstants.REPLENISH_ORDER_LIST_TABLE_XPATH);
        List<WebElement> rowsTables = tables.findElements(By.tagName("tr"));
        for (WebElement rowsTable : rowsTables) {
            List<WebElement> links = rowsTable.findElements(By.id("navbar"));
            for (WebElement link : links) {
                Actions action = new Actions(this.driver);
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
