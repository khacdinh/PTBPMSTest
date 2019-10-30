package com.btbms.pages.orderprocess.replenish.table;

import com.btbms.config.Driver;
import com.btbms.pages.constants.ReplenishOrderConstants;
import com.btbms.pages.enums.OrderStatus;
import com.btbms.pages.model.ReplenishOrder;
import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ReplenishOrderListTable {

    private static List<ReplenishOrder> replenishOrders = new ArrayList<>();

    public static List<ReplenishOrder> getReplenishOrders() {
        replenishOrders.clear();
        WebElement tables = Driver.driver.findElement(ReplenishOrderConstants.REPLENISH_ORDER_LIST_TABLE_XPATH);

        List<WebElement> rowsTables = tables.findElements(By.tagName("tr"));
        if (CollectionUtils.isNotEmpty(rowsTables)) {
            for (WebElement rowsTable : rowsTables) {
                List<WebElement> columns = rowsTable.findElements(By.tagName("td"));
                if (CollectionUtils.isEmpty(columns)) continue;

                ReplenishOrder replenishOrder = new ReplenishOrder();
                replenishOrder.setReplenishOrderNo(columns.get(1).getText());
                replenishOrder.setRegisterUser(columns.get(2).getText());
                replenishOrder.setOrderCreationDate(columns.get(3).getText());
                replenishOrder.setsAPSalesOrderNo(columns.get(4).getText());
                replenishOrder.setCustomerNo(columns.get(5).getText());
                replenishOrder.setSAPCPONo(columns.get(6).getText());
                replenishOrder.setBusinessGroup(columns.get(7).getText());
                replenishOrder.setOrderStatus(OrderStatus.get(columns.get(8).getText()));
                replenishOrders.add(replenishOrder);
            }
        }

        return replenishOrders;
    }


}
