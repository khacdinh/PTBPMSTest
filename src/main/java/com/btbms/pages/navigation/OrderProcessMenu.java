package com.btbms.pages.navigation;

public class OrderProcessMenu {
    public static void goTo(OrderProcessType orderProcessType) {
        switch (orderProcessType) {
            case REPLENISH_ORDER:
                TopMenuSelector.OrderProcess.selectReplenishOrder();
                break;
            default:
                break;
        }
    }
}
