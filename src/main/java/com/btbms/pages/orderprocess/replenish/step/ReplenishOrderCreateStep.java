package com.btbms.pages.orderprocess.replenish.step;

import com.btbms.pages.enums.HandlingSuggestionType;
import com.btbms.pages.enums.LiabilityAndResponsibleType;
import com.btbms.pages.enums.OrderType;
import com.btbms.pages.orderprocess.replenish.ReplenishOrderListPage;
import net.thucydides.core.annotations.Step;

public class ReplenishOrderCreateStep {

    public ReplenishOrderListPage rep;
    @Step("Move to order Order process on top menu and select  replenish order")
    public void select_replenish_order_in_top_menu() {
        rep.select_replenish_order_in_top_menu();
    }

    @Step
    public void click_button_new(){
        rep.clickNewBtn();
    }

    @Step
    public String get_replenish_order_No_auto_create(){
        return rep.getReplenishOrderNo();
    }

    @Step
    public void fill_in_data(String typeOfSubmit) {
    this.fillTheData(typeOfSubmit);
    }

    @Step
    public void verify_button_submit_to_senior_is_disable(){
        rep.verify().submitToSeniorDisable();
    }

    @Step
    public void click_button_submit_to_dept() {
    this.rep.action().clickButtonSubmitToDept();
    }

    @Step
    public void click_button_save() {
        this.rep.action().clickSave();
    }

    @Step("verify replenish OrderNo Created {0}")
    public void verify_replenish_order_no_create(String repOrderNoGenerate){
        String currentRepOrderNo = rep.verify().getReplenishOrderNo();
        rep.verify().replenishOrderNoCreate(repOrderNoGenerate, currentRepOrderNo);
    }

    @Step("registerUser {0}, status {1}")
    public void verify_in_table_list_with_user_and_status(String registerUser,String status) {
        int firstRecord = 1;
        rep.verifyResult().getTableData().andStartVerify()
                .registerUser(firstRecord, registerUser)
                .orderStatus(firstRecord, status);
    }

    private void fillTheData(String method) {
        this.rep.action().selectOrderType(OrderType.T1_1.getValue())
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
