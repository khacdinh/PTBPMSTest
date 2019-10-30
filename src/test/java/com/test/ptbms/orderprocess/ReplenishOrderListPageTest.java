package com.test.ptbms.orderprocess;

import com.btbms.config.Driver;
import com.btbms.pages.enums.*;
import com.btbms.pages.navigation.OrderProcessMenu;
import com.btbms.pages.navigation.OrderProcessType;
import com.btbms.pages.orderprocess.replenish.ReplenishOrderListPage;
import com.test.ptbms.base.BaseTest;
import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ReplenishOrderListPageTest extends BaseTest {
    private ReplenishOrderListPage rep;
    private static final Logger LOGGER = Logger.getLogger(ReplenishOrderListPageTest.class);

    @Test
    public void add_new_replenish_order_by_SubmitToDept() {
        rep = ReplenishOrderListPage.getInstance(Action.CREATE);
        //Go to ReplenishOrderListPage
        OrderProcessMenu.goTo(OrderProcessType.REPLENISH_ORDER);
        //Create create button new
        rep.clickBtnNew();
        //Store Replenish Order No
        String repOrderNoGenerate = rep.getReplenishOrderNo();
        Reporter.log("ReplenishOrderNo: " + repOrderNoGenerate, true);

        //Fill the data
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        fillTheData(nameOfCurrMethod);
        //Verify button submit to senior disable
        rep.createVerify().submitToSeniorDisable();
        //Click submit to Dept
        rep.action().clickButtonSubmitToDept();
        //Verify Replenish Order No create
        String currentRepOrderNo = rep.createVerify().getReplenishOrderNo();

        rep.createVerify().replenishOrderNo(repOrderNoGenerate, currentRepOrderNo);
        int firstRecord = 1;
        rep.verifyResult().getTableData().andStartVerify()
                .byRegisterUser(firstRecord, "DINO.NGUYEN")
                .byOrderStatus(firstRecord, OrderStatus.STATUS_20.getValue());
    }

    @Test
    public void add_new_replenish_order_save() {
        rep = ReplenishOrderListPage.getInstance(Action.CREATE);
        //Go to ReplenishOrderListPage
        OrderProcessMenu.goTo(OrderProcessType.REPLENISH_ORDER);
        //Create create button new
        rep.clickBtnNew();
        //Store Replenish Order No
        String repOrderNoGenerate = rep.getReplenishOrderNo();
        LOGGER.info("ReplenishOrderNo:" + repOrderNoGenerate);
        //Fill the data
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        fillTheData(nameOfCurrMethod);
        //Verify button submit to senior disable
        rep.createVerify().submitToSeniorDisable();
        //Click submit to Dept
        rep.action().clickSave();
        //Verify Replenish Order No create
        String currentRepOrderNo = rep.createVerify().getReplenishOrderNo();
        rep.createVerify().replenishOrderNo(repOrderNoGenerate, currentRepOrderNo);

        int firstRecord = 1;
        rep.verifyResult().getTableData().andStartVerify()
                .byRegisterUser(firstRecord, "DINO.NGUYEN").byOrderStatus(firstRecord, OrderStatus.STATUS_10.getValue());
    }

    @Test
    public void search_replenish_order() {
        OrderProcessMenu.goTo(OrderProcessType.REPLENISH_ORDER);
        rep = ReplenishOrderListPage.getInstance(Action.SEARCH);
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

        int firstRecord = 1;
        rep.verifyResult().getTableData().andStartVerify()
                .byRegisterUser(firstRecord, "DAVID.CHEN").byOrderStatus(firstRecord, OrderStatus.STATUS_40.getValue());
        Driver.driver.quit();
    }

    private void fillTheData(String method) {
        rep.action().selectOrderType(OrderType.T1_1.getValue())
                .withSAPMONo("125")
                .withSAPMODeliveryDate("2019-10-27")
                .withFinishProductQuantity("100")
                .withWIPLocation("wip1")
                .selectHandlingSuggestion(HandlingSuggestionType.T01.getValue())
                .selectLiabilityNoDep1(LiabilityAndResponsibleType.T02.getValue())
                .selectLiabilityNoDep2(LiabilityAndResponsibleType.T05.getValue())
                .withOrderQtyDep1("50")
                .withOrderQtyDep2("50")
                .withOrderReason("Reason: " + method)
                .withOrderProcess("Order Process: " + method);
    }

    @AfterTest
    public void clean() {
        Driver.driver.quit();
    }

}
