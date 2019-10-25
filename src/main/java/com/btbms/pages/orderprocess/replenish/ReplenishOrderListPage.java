package com.btbms.pages.orderprocess.replenish;

import com.btbms.pages.commons.ReplenishOrderConstants;
import com.btbms.pages.login.LoginPageAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ReplenishOrderListPage {

    //Create
    private ReplenishOrderCreateAction createRepOrder;
    private ReplenishOrderCreateVerify createVerify;

    //Search
    private ReplenishOrderSearchAction searchOrder;
    private ReplenishOrderSearchVerify verifySearchOrder;
    private WebDriver driver;

    public ReplenishOrderListPage(WebDriver driver) {
        this.driver = driver;
    }

    public ReplenishOrderSearchAction filter() {
        return searchOrder;
    }

    public ReplenishOrderSearchVerify verifySearch() {
        return verifySearchOrder;
    }

    public static ReplenishOrderListPage getCreateInstance(WebDriver driver) {
        ReplenishOrderListPage   replenishOrderListPage = PageFactory.initElements(driver, ReplenishOrderListPage.class);
        replenishOrderListPage.createRepOrder = PageFactory.initElements(driver, ReplenishOrderCreateAction.class);
        replenishOrderListPage.createVerify=PageFactory.initElements(driver, ReplenishOrderCreateVerify.class);
        return  replenishOrderListPage;
    }
    public static ReplenishOrderListPage getSearchInstance(WebDriver driver, ReplenishOrderSearchAction searchOrder, ReplenishOrderSearchVerify verifySearchOrder) {
        ReplenishOrderListPage replenishOrderListPage = PageFactory.initElements(driver, ReplenishOrderListPage.class);
        replenishOrderListPage.searchOrder = searchOrder;
        replenishOrderListPage.verifySearchOrder = verifySearchOrder;
        return replenishOrderListPage;
    }

    public String getReplenishOrderNo() {
        return driver.findElement(ReplenishOrderConstants.RPOHEAD_RPORDERNO).getText();

    }
    public void clickBtnNew() {
        driver.findElement(newButtonName()).click();
    }

    private static By newButtonName() {
        return By.xpath("//*[@id=\"searchRpohead\"]/div[2]/table/tbody/tr/td/input[2]");
    }

    public ReplenishOrderCreateAction createRepOrder() {
        return createRepOrder;
    }
    public ReplenishOrderCreateVerify createVerify() {
        return createVerify;
    }

}
