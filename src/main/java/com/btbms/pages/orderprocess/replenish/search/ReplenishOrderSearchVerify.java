package com.btbms.pages.orderprocess.replenish.search;

import com.btbms.pages.enums.OrderStatus;
import com.btbms.pages.model.ReplenishOrder;
import org.apache.commons.collections.CollectionUtils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.NoSuchElementException;

public class ReplenishOrderSearchVerify {
    private WebDriver driver;

    List<ReplenishOrder> replenishOrders;

    public List<ReplenishOrder> getReplenishOrders() {
        return replenishOrders;
    }

    public void setReplenishOrders(List<ReplenishOrder> replenishOrders) {
        this.replenishOrders = replenishOrders;
    }

    public ReplenishOrderSearchVerify(WebDriver driver) {
        this.driver = driver;
    }


    public ReplenishOrderSearchVerify byRegisterUser(int resultNumber, String value) {
        if (CollectionUtils.isEmpty(replenishOrders)) {
            throw new NoSuchElementException("No data in table ReplenishOrder");
        }
        Assertions.assertThat(replenishOrders.get(resultNumber - 1).getRegisterUser().trim()).isEqualTo(value);
        return this;
    }

    public ReplenishOrderSearchVerify byOrderStatus(int resultNumber, String orderStatus) {
        if (CollectionUtils.isEmpty(replenishOrders)) {
            throw new NoSuchElementException("No data in table ReplenishOrder");
        }
        Assertions.assertThat(replenishOrders.get(resultNumber - 1).getOrderStatus().getValue()).isEqualTo(orderStatus);
        return this;
    }
}
