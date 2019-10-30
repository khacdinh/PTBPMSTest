package com.btbms.pages.enums;

public enum HandlingSuggestionType {
    T01("01 - 存倉作次布"),
    T02("02 - 存倉留待改染深色"),
    T03("03 - SHORT數補布"),
    ;

    private final String value;

    public String getValue() {
        return this.value;
    }

    HandlingSuggestionType(String levelCode) {
        this.value = levelCode;
    }

}
