package com.btbms.pages.navigation;

public class TopMenuSelector {
    public static class OrderProcess {
        public static void selectReplenishOrder() {
            MenuSelector.select("//*[@id=\"navbar\"]/li[2]/a", "//*[@id=\"navbar\"]/li[2]/ul/li[1]/a");
        }
    }
}
