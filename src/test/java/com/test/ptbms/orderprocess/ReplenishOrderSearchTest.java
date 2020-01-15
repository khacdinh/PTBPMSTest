package com.test.ptbms.orderprocess;

import com.btbms.pages.enums.OrderStatus;
import com.btbms.pages.model.ReplenishOrder;
import com.btbms.pages.orderprocess.replenish.ReplenishOrderListPage;
import com.btbms.pages.orderprocess.replenish.step.ReplenishOrderStep;
import com.btbms.pages.orderprocess.replenish.table.ReplenishOrderListTable;
import com.test.ptbms.base.BaseTest;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReplenishOrderSearchTest extends BaseTest {

    public ReplenishOrderListPage rep;

    @Steps
    public ReplenishOrderStep step;


    @Test
    public void search_replenish_order() {
        step.select_replenish_order_in_top_menu();
        step.fill_in_data_filter();
        step.verify_search_result();
    }

    @Test
    public void add_new_replenish_order_by_SubmitToDept() {
        //Go to ReplenishOrderListPage
        step.select_replenish_order_in_top_menu();
        //Create create button new
        step.click_button_new();
        //Store Replenish Order No
        String repOrderNoGenerate = step.get_replenish_order_No_auto_create();
        //Fill the data
        step.fill_in_data("Submit to dev");
        //Verify button submit to senior disable
        step.verify_button_submit_to_senior_is_disable();
        //Click submit to Dept
        step.click_button_submit_to_dept();
        //Verify Replenish Order No create
        step.verify_replenish_order_no_create(repOrderNoGenerate);
        //Verify in table list
        step.verify_in_table_list_with_user_and_status("DINO.NGUYEN", OrderStatus.STATUS_20.getValue());
    }

    @Test
    public void add_new_replenish_order_save() {
        //Go to ReplenishOrderListPage
        step.select_replenish_order_in_top_menu();
        //Create create button new
        step.click_button_new();
        //Store Replenish Order No
        String repOrderNoGenerate = step.get_replenish_order_No_auto_create();
        //Fill the data
        step.fill_in_data("For Btn Save");
        //Verify button submit to senior disable
        step.verify_button_submit_to_senior_is_disable();
        //Click submit to Dept
        step.click_button_save();
        //Verify Replenish Order No create
        step.verify_replenish_order_no_create(repOrderNoGenerate);
        //Verify in table list
        step.verify_in_table_list_with_user_and_status("DINO.NGUYEN", OrderStatus.STATUS_10.getValue());
    }

    @Test
    public void view_replenish_order() {
        //Go to ReplenishOrderListPage
        step.select_replenish_order_in_top_menu();
        //Get data in table
        ReplenishOrderListTable replenishOrderListTable = PageFactory.initElements(this.driver, ReplenishOrderListTable.class);
        List<ReplenishOrder> replenishOrders = replenishOrderListTable.getReplenishOrders();
        ReplenishOrder firstReplenishOrder = replenishOrders.get(0);
        // Search
        step.search_by_replenish_orderno_and_click_btn_search(firstReplenishOrder.getReplenishOrderNo());
        //Click button view
        step.clicBtnViewInRow();
        //Verify
        step.verify_view_page(firstReplenishOrder);
    }

    //    @Test
    public void delete_replenish_order() {
        //Go to the table
        //  OrderProcessMenu.goTo(OrderProcessType.REPLENISH_ORDER);
        //Get data in table
        List<ReplenishOrder> replenishOrders = null;

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
        List<ReplenishOrder> replenishOrdersAfterDelete = null;
        Assert.assertEquals(0, replenishOrdersAfterDelete.size());
    }

}
