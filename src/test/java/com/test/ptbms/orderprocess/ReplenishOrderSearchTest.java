package com.test.ptbms.orderprocess;

import com.btbms.pages.model.ReplenishOrder;
import com.btbms.pages.orderprocess.replenish.ReplenishOrderListPage;
import com.btbms.pages.orderprocess.replenish.table.ReplenishOrderListTable;
import com.test.ptbms.base.BaseTest;
import com.btbms.pages.orderprocess.replenish.step.ReplenishOrderSearchStep;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ReplenishOrderSearchTest  extends BaseTest{

    public ReplenishOrderListPage rep;

    @Steps
    public ReplenishOrderSearchStep replenishOrderListStep;


    @Test
    public void search_replenish_order() {
        replenishOrderListStep.select_replenish_order_in_top_menu();
        replenishOrderListStep.fill_in_data_filter();
        replenishOrderListStep.verify_search_result();
    }

    // @Test
    public void view_replenish_order() {
        //Go to the table
        //OrderProcessMenu.goTo(OrderProcessType.REPLENISH_ORDER);

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
        //  Driver.driver.quit();
    }

    //    @Test
    public void delete_replenish_order() {
        //Go to the table
      //  OrderProcessMenu.goTo(OrderProcessType.REPLENISH_ORDER);
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
        Assert.assertEquals(0, replenishOrdersAfterDelete.size());
    }

}
