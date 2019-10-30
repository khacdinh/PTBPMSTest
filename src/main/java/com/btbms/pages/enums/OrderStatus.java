package com.btbms.pages.enums;

import java.util.HashMap;
import java.util.Map;

public enum OrderStatus {
    STATUS_10("10 - 單據錄入"),
    STATUS_20("20 - 部門審批"),
    STATUS_30("30 - 高級主管審批"),
    STATUS_40("40 - 原料組跟單"),
    STATUS_50("50 - CPO組跟單"),
    STATUS_90("90 - 正常結束"),
    STATUS_95("95 - 取消"),
    ;

    private static final Map<String, OrderStatus> lookup = new HashMap<>();

    static {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            lookup.put(orderStatus.getValue(), orderStatus);
        }
    }
    private final String value;

    public String getValue() {
        return this.value;
    }

    OrderStatus(String levelCode) {
        this.value = levelCode;
    }

    public static OrderStatus get(String value) {
        return lookup.get(value);
    }

}
