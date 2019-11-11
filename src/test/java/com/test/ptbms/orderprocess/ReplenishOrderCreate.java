package com.test.ptbms.orderprocess;

import com.btbms.pages.enums.OrderStatus;
import com.test.ptbms.base.BaseTest;
import com.btbms.pages.orderprocess.replenish.step.ReplenishOrderCreateStep;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class ReplenishOrderCreate extends BaseTest{

    @Managed
    WebDriver driver;

    @Steps
    public ReplenishOrderCreateStep createStep;

    @Test
    public void add_new_replenish_order_by_SubmitToDept() {
        //Go to ReplenishOrderListPage
        createStep.select_replenish_order_in_top_menu();
        //Create create button new
        createStep.click_button_new();
        //Store Replenish Order No
        String repOrderNoGenerate = createStep.get_replenish_order_No_auto_create();
        //Fill the data
        createStep.fill_in_data("Submit to dev");
        //Verify button submit to senior disable
        createStep.verify_button_submit_to_senior_is_disable();
        //Click submit to Dept
        createStep.click_button_submit_to_dept();
        //Verify Replenish Order No create
        createStep.verify_replenish_order_no_create(repOrderNoGenerate);
        //Verify in table list
        createStep.verify_in_table_list_with_user_and_status( "DINO.NGUYEN",OrderStatus.STATUS_20.getValue());
    }

    @Test
    public void add_new_replenish_order_save() {
        //Go to ReplenishOrderListPage
        createStep.select_replenish_order_in_top_menu();
        //Create create button new
        createStep.click_button_new();
        //Store Replenish Order No
        String repOrderNoGenerate = createStep.get_replenish_order_No_auto_create();
        //Fill the data
        createStep.fill_in_data("Submit to dev");
        //Verify button submit to senior disable
        createStep.verify_button_submit_to_senior_is_disable();
        //Click submit to Dept
        createStep.click_button_save();
        //Verify Replenish Order No create
        createStep.verify_replenish_order_no_create(repOrderNoGenerate);
        //Verify in table list
        createStep.verify_in_table_list_with_user_and_status( "DINO.NGUYEN",OrderStatus.STATUS_10.getValue());
    }

}
