package com.test.ptbms.orderprocess;

import com.btbms.config.Driver;
import com.btbms.pages.enums.HandlingSuggestionType;
import com.btbms.pages.enums.LiabilityAndResponsibleType;
import com.btbms.pages.enums.OrderStatus;
import com.btbms.pages.enums.OrderType;
import com.btbms.pages.model.ReplenishOrder;
import com.btbms.pages.navigation.OrderProcessMenu;
import com.btbms.pages.navigation.OrderProcessType;
import com.btbms.pages.orderprocess.replenish.ReplenishOrderListPage;
import com.btbms.pages.orderprocess.replenish.table.ReplenishOrderListTable;
import com.test.ptbms.base.BaseTest;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.List;

public class ReplenishOrderListPageTest extends BaseTest {
    private ReplenishOrderListPage rep;
    private static final Logger LOGGER = Logger.getLogger(ReplenishOrderListPageTest.class);

    @Test
    public void add_new_replenish_order_by_SubmitToDept() {
        rep = ReplenishOrderListPage.getInstance();
        //Go to ReplenishOrderListPage
        OrderProcessMenu.goTo(OrderProcessType.REPLENISH_ORDER);
        //Create create button new
        rep.clickNewBtn();
        //Store Replenish Order No
        String repOrderNoGenerate = rep.getReplenishOrderNo();
        Reporter.log("ReplenishOrderNo: " + repOrderNoGenerate, true);

        //Fill the data
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        fillTheData(nameOfCurrMethod);
        //Verify button submit to senior disable
        rep.verify().submitToSeniorDisable();
        //Click submit to Dept
        rep.action().clickButtonSubmitToDept();
        //Verify Replenish Order No create
        String currentRepOrderNo = rep.verify().getReplenishOrderNo();

        rep.verify().replenishOrderNoCreate(repOrderNoGenerate, currentRepOrderNo);
        int firstRecord = 1;
        rep.verifyResult().getTableData().andStartVerify()
                .registerUser(firstRecord, "DINO.NGUYEN")
                .orderStatus(firstRecord, OrderStatus.STATUS_20.getValue());
    }

    @Test
    public void add_new_replenish_order_save() {
        rep = ReplenishOrderListPage.getInstance();
        //Go to ReplenishOrderListPage
        OrderProcessMenu.goTo(OrderProcessType.REPLENISH_ORDER);
        //Create create button new
        rep.clickNewBtn();
        //Store Replenish Order No
        String repOrderNoGenerate = rep.getReplenishOrderNo();
        LOGGER.info("ReplenishOrderNo:" + repOrderNoGenerate);
        //Fill the data
        String nameOfCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        fillTheData(nameOfCurrMethod);
        //Verify button submit to senior disable
        rep.verify().submitToSeniorDisable();
        //Click submit to Dept
        rep.action().clickSave();
        //Verify Replenish Order No create
        String currentRepOrderNo = rep.verify().getReplenishOrderNo();
        rep.verify().replenishOrderNoCreate(repOrderNoGenerate, currentRepOrderNo);

        int firstRecord = 1;
        rep.verifyResult().getTableData().andStartVerify()
                .registerUser(firstRecord, "DINO.NGUYEN").orderStatus(firstRecord, OrderStatus.STATUS_10.getValue());
    }

    @Test
    public void search_replenish_order() {
        OrderProcessMenu.goTo(OrderProcessType.REPLENISH_ORDER);
        rep = ReplenishOrderListPage.getInstance();
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
                .registerUser(firstRecord, "DAVID.CHEN").orderStatus(firstRecord, OrderStatus.STATUS_40.getValue());
    }

    @Test
    public void view_replenish_order() {
        //Go to the table
        OrderProcessMenu.goTo(OrderProcessType.REPLENISH_ORDER);
        rep = ReplenishOrderListPage.getInstance();

        //Get data in table
        List<ReplenishOrder> replenishOrders = ReplenishOrderListTable.getReplenishOrders();

        ReplenishOrder firstReplenishOrder = replenishOrders.get(0);
        // Search
        rep.filter()
                .byReplenishOrderNo(firstReplenishOrder.getReplenishOrderNo())
                .clickBtnSearch();
        //Click button view
        rep.clickViewBtn();

        //Verify
        rep.verify().isAllFieldsDisable().replenishOrderNo(firstReplenishOrder.getReplenishOrderNo()).customerNo(firstReplenishOrder.getCustomerNo());
        Driver.driver.quit();
    }

    @Test
    public void delete_replenish_order(){
        //Go to the table
        OrderProcessMenu.goTo(OrderProcessType.REPLENISH_ORDER);
        rep = ReplenishOrderListPage.getInstance();

        //Get data in table
        List<ReplenishOrder> replenishOrders = ReplenishOrderListTable.getReplenishOrders();

        ReplenishOrder firstReplenishOrder = replenishOrders.get(0);
        String replenishOrderNo = firstReplenishOrder.getReplenishOrderNo();
        // Search
        rep.filter()
                .byReplenishOrderNo(replenishOrderNo)
                .clickBtnSearch();

        //Click button delete in table result
        rep.clickDeleteBtn();
        //Verify
        rep.verify().isAllFieldsDisable();
        rep.action().clickDelete();
        List<ReplenishOrder> replenishOrdersAfterDelete = ReplenishOrderListTable.getReplenishOrders();
        Assert.assertEquals(0,replenishOrdersAfterDelete.size());
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


}
