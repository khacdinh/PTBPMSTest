package com.btbms.pages.orderprocess.replenish;

import com.btbms.pages.model.ReplenishOrder;
import com.btbms.pages.orderprocess.replenish.CURDaction.ReplenishOrderForm;
import com.btbms.pages.orderprocess.replenish.table.ReplenishOrderListTable;
import net.thucydides.core.annotations.Managed;
import org.apache.commons.collections.CollectionUtils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ReplenishOrderTableVerify extends ReplenishOrderForm {

    List<ReplenishOrder> replenishOrders = new ArrayList<>();

    public List<ReplenishOrder> getReplenishOrders() {
        return replenishOrders;
    }

    public void setReplenishOrders(List<ReplenishOrder> replenishOrders) {
        this.replenishOrders = replenishOrders;
    }

    @Managed
    WebDriver driver;

    public ReplenishOrderListTable replenishOrderListTable;

    public ReplenishOrderTableVerify(WebDriver driver) {
        this.driver = driver;
        replenishOrderListTable= PageFactory.initElements(driver, ReplenishOrderListTable.class);
    }

    public ReplenishOrderTableVerify getTableData() {
        this.replenishOrders.clear();
        this.replenishOrders.addAll(replenishOrderListTable.getReplenishOrders2());
        return this;
    }

    public ReplenishOrderTableVerify andStartVerify() {
        return this;
    }


    public ReplenishOrderTableVerify registerUser(int resultNumber, String value) {
        if (CollectionUtils.isEmpty(replenishOrders)) {
            throw new NoSuchElementException("No data in table ReplenishOrder");
        }
        Assertions.assertThat(replenishOrders.get(resultNumber - 1).getRegisterUser().trim()).isEqualTo(value);
        return this;
    }


    public ReplenishOrderTableVerify orderStatus(int resultNumber, String orderStatus) {
        if (CollectionUtils.isEmpty(replenishOrders)) {
            throw new NoSuchElementException("No data in table ReplenishOrder");
        }
        Assertions.assertThat(orderStatus).isEqualTo(replenishOrders.get(resultNumber - 1).getOrderStatus().getValue());
        return this;
    }


}
