package com.btbms.pages.orderprocess.replenish.step;

import com.btbms.pages.enums.LiabilityAndResponsibleType;
import com.btbms.pages.enums.OrderStatus;
import com.btbms.pages.orderprocess.replenish.ReplenishOrderListPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import org.junit.runner.RunWith;

public class ReplenishOrderSearchStep {

    public ReplenishOrderListPage page;

    @Step("Move to order Order process on top menu and select  replenish order")
    public void select_replenish_order_in_top_menu() {
        page.select_replenish_order_in_top_menu();
    }

    @Step("Fill in the data")
    public void fill_in_data_filter() {
        page.filter()
                .byReplenishOrderNo("RP00000457")
                .byRegisterUser("RONALD.ALLAN")
                .selectResponsibleDepartment(LiabilityAndResponsibleType.T01.getValue())
                .clickBtnSearch();
    }

    @Step
    public void verify_search_result() {
        int firstRecord = 1;
        page.verifyResult().getTableData().andStartVerify()
                .registerUser(firstRecord, "RONALD.ALLAN").orderStatus(firstRecord, OrderStatus.STATUS_20.getValue());
    }
}
