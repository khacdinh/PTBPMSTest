package com.btbms.config;

import com.btbms.listeners.ScreenshotListener;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
@Listeners(ScreenshotListener.class)
public class Driver {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }


    public static void setUp() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
         driver = new ChromeDriver();
    }
}
