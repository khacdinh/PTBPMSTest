package com.btbms.pages.enums;

public enum OrderType {
    T1_1("1.1 - 緯編補布单"),
    T1_2("1.2 - 經編補布单"),
    T1_3("1.3 - 扁機補布单"),
    T2_1("2.1 - 針織廠补纱单"),
    T2_2("2.2 - 染纱厂补纱单"),
    T2_3("2.3 - 经编补纱单"),
    ;

    private final String value;

    OrderType(String levelCode) {
        this.value = levelCode;
    }

    public String getValue() {
        return this.value;
    }

}
