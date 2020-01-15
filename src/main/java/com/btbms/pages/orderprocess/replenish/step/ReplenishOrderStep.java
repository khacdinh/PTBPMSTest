package com.btbms.pages.orderprocess.replenish.step;

import com.btbms.pages.enums.HandlingSuggestionType;
import com.btbms.pages.enums.LiabilityAndResponsibleType;
import com.btbms.pages.enums.OrderStatus;
import com.btbms.pages.enums.OrderType;
import com.btbms.pages.model.ReplenishOrder;
import com.btbms.pages.orderprocess.replenish.ReplenishOrderListPage;
import net.thucydides.core.annotations.Step;

public class ReplenishOrderStep {

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


    @Step
    public void click_button_new(){
        page.clickNewBtn();
    }

    @Step
    public String get_replenish_order_No_auto_create(){
        return page.getReplenishOrderNo();
    }

    @Step
    public void fill_in_data(String typeOfSubmit) {
        this.fillTheData(typeOfSubmit);
    }

    @Step
    public void verify_button_submit_to_senior_is_disable(){
        page.verify().submitToSeniorDisable();
    }

    @Step
    public void click_button_submit_to_dept() {
        this.page.action().clickButtonSubmitToDept();
    }

    @Step
    public void click_button_save() {
        this.page.action().clickSave();
    }

    @Step("verify replenish OrderNo Created {0}")
    public void verify_replenish_order_no_create(String repOrderNoGenerate){
        String currentRepOrderNo = page.verify().getReplenishOrderNo();
        page.verify().replenishOrderNoCreate(repOrderNoGenerate, currentRepOrderNo);
    }

    @Step("registerUser {0}, status {1}")
    public void verify_in_table_list_with_user_and_status(String registerUser,String status) {
        int firstRecord = 1;
        page.verifyResult().getTableData().andStartVerify()
                .registerUser(firstRecord, registerUser)
                .orderStatus(firstRecord, status);
    }

    @Step
    public void search_by_replenish_orderno_and_click_btn_search(String ReplenishOrderNo) {
        page.filter()
                .byReplenishOrderNo(ReplenishOrderNo)
                .clickBtnSearch();
    }

    @Step
    public void clicBtnViewInRow() {
        page.clickViewBtn();
    }

    @Step
    public void verify_view_page(ReplenishOrder firstReplenishOrder) {
        page.verify().isAllFieldsDisable().replenishOrderNo(firstReplenishOrder.getReplenishOrderNo()).customerNo(firstReplenishOrder.getCustomerNo());

    }

    private void fillTheData(String method) {
        this.page.action().selectOrderType(OrderType.T1_1.getValue())
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
