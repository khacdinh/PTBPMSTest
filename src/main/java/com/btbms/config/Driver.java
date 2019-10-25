package com.btbms.config;

import com.btbms.listeners.ScreenshotListener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
@Listeners(ScreenshotListener.class)
public class Driver {
    static {
        File file = new File(
                Driver.class.getClassLoader().getResource("drivers/chromedriver.exe").getFile()
        );
        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
    }

    public static RemoteWebDriver driver;

    public static RemoteWebDriver getDriver() {
        return driver;
    }

    private static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<DriverFactory>());
    private static ThreadLocal<DriverFactory> driverFactoryThread;
    public static void Inittialize() {
        driver = new ChromeDriver();
//        driverFactoryThread = ThreadLocal.withInitial(() -> {
//            DriverFactory driverFactory = new DriverFactory();
//            webDriverThreadPool.add(driverFactory);
//            return driverFactory;
//        });
//        instance = driverFactoryThread.get().getDriver();
    }
}
