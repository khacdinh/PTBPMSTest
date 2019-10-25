package com.test.ptbms.ReplenishOrderList;

import com.btbms.config.Driver;
import com.btbms.pages.commons.HandlingSuggestionType;
import com.btbms.pages.commons.LiabilityAndResponsibleType;
import com.btbms.pages.commons.OrderStatus;
import com.btbms.pages.commons.OrderType;
import com.btbms.pages.navigation.OrderProcessMenu;
import com.btbms.pages.navigation.OrderProcessType;
import com.btbms.pages.orderprocess.replenish.ReplenishOrderListPage;
import com.btbms.pages.orderprocess.replenish.ReplenishOrderSearchAction;
import com.btbms.pages.orderprocess.replenish.ReplenishOrderSearchVerify;
import com.test.ptbms.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class ReplenishOrderListPageTest extends BaseTest {
    private ReplenishOrderListPage rep;

    //Search
    private ReplenishOrderSearchAction searchOrder;
    private ReplenishOrderSearchVerify verifySearchOrder;

   // @Test
    public void add_new_replenish_order() {
        WebDriver driver = Driver.driver;
        rep = ReplenishOrderListPage.getCreateInstance(driver);
        //Go to ReplenishOrderListPage
        OrderProcessMenu.goTo(OrderProcessType.REPLENISH_ORDER);
        //Create create button new
        rep.clickBtnNew();
        //Store Replenish Order No
        String repOrderNoGenerate = rep.getReplenishOrderNo();
        //Fill the data
        rep.createRepOrder().selectOrderType(OrderType.T1_1.getValue())
                .withSAPMONo("125")
                .withSAPMODeliveryDate("2019-10-27")
                .withFinishProductQuantity("100")
                .withWIPLocation("wip1")
                .selectHandlingSuggestion(HandlingSuggestionType.T01.getValue())
                .selectLiabilityNoDep1(LiabilityAndResponsibleType.T02.getValue())
                .selectLiabilityNoDep2(LiabilityAndResponsibleType.T05.getValue())
                .withOrderQtyDep1("50")
                .withOrderQtyDep2("50")
                .withOrderReason("add_new_replenish_order: Reason")
                .withOrderProcess("add_new_replenish_order: Order Process:");
        //Verify button submit to senior disable
        rep.createVerify().submitToSeniorDisable();
        //Click submit to Dept
        rep.createRepOrder().clickButtonSubmitToDept();
        //Verify Replenish Order No create
        String currentRepOrderNo = rep.createVerify().getReplenishOrderNo();
        rep.createVerify().replenishOrderNo(repOrderNoGenerate, currentRepOrderNo);
        Driver.driver.findElement(By.xpath("//*[@id=\"navbar\"]/li[3]/a")).click();
    }

    @Test
    public void search_replenish_order() throws Exception {
        WebDriver driver = Driver.driver;
        OrderProcessMenu.goTo(OrderProcessType.REPLENISH_ORDER);
        //WebDriver driver = DriverBase.getDriver();
        searchOrder = PageFactory.initElements(driver, ReplenishOrderSearchAction.class);
        verifySearchOrder = PageFactory.initElements(driver, ReplenishOrderSearchVerify.class);
        rep = ReplenishOrderListPage.getSearchInstance(driver, searchOrder, verifySearchOrder);
        //
        rep.filter()
                .byReplenishOrderNo("RP00000468")
                .byRegisterUser("DAVID.CHEN")
                .selectResponsibleDepartment(LiabilityAndResponsibleType.T01.getValue())
                .bySAPMONo("0006006579A4")
                .byCustomerNo("0022123")
                .byOrderCreationDateFrom("2019-10-17")
                .byOrderCreationDateEnd("2019-10-31")
                .selectOrderStatusStart(OrderStatus.STATUS_40.getValue())
                .selectOrderStatusEnd(OrderStatus.STATUS_40.getValue())
                .clickBtnSearch();
        rep.verifySearch().byRegisterUser("DAVID.CHEN");
        Driver.driver.quit();
    }

}
