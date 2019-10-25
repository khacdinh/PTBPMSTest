package com.btbms.pages.commons;

public enum OrderStatus {
    STATUS_10("10 - 單據錄入"),
    STATUS_20("20 - 部門審批"),
    STATUS_30("30 - 高級主管審批"),
    STATUS_40("40 - 原料組跟單"),
    STATUS_50("50 - CPO組跟單"),
    STATUS_90("90 - 正常結束"),
    STATUS_95("95 - 取消"),
    ;
    private final String value;

    public String getValue() {
        return this.value;
    }

    OrderStatus(String levelCode) {
        this.value = levelCode;
    }

}
