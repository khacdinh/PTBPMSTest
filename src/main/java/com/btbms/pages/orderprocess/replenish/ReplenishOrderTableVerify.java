package com.btbms.pages.orderprocess.replenish;

import com.btbms.config.Driver;
import com.btbms.pages.model.ReplenishOrder;
import com.btbms.pages.orderprocess.replenish.table.ReplenishOrderListTable;
import org.apache.commons.collections.CollectionUtils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ReplenishOrderTableVerify {

    List<ReplenishOrder> replenishOrders=new ArrayList<>();

    public List<ReplenishOrder> getReplenishOrders() {
        return replenishOrders;
    }

    public void setReplenishOrders(List<ReplenishOrder> replenishOrders) {
        this.replenishOrders = replenishOrders;
    }

    public ReplenishOrderTableVerify getTableData(){
        this.replenishOrders.clear();
        this.replenishOrders.addAll(ReplenishOrderListTable.getReplenishOrders());
        return this;
    }
    public ReplenishOrderTableVerify andStartVerify(){
        return this;
    }

    public ReplenishOrderTableVerify byRegisterUser(int resultNumber, String value) {
        if (CollectionUtils.isEmpty(replenishOrders)) {
            throw new NoSuchElementException("No data in table ReplenishOrder");
        }
        Assertions.assertThat(value).isEqualTo(replenishOrders.get(resultNumber - 1).getRegisterUser().trim());
        return this;
    }

    public ReplenishOrderTableVerify byOrderStatus(int resultNumber, String orderStatus) {
        if (CollectionUtils.isEmpty(replenishOrders)) {
            throw new NoSuchElementException("No data in table ReplenishOrder");
        }
        Assertions.assertThat(orderStatus).isEqualTo(replenishOrders.get(resultNumber - 1).getOrderStatus().getValue());
        return this;
    }
}
