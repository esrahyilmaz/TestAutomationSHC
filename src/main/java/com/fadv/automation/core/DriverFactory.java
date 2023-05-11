package com.fadv.automation.core;

import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
    private static DriverFactory driverInstance = new DriverFactory();

    private DriverFactory() {
        //do nothing... do not allow initialization outside of this class
    }

    public static DriverFactory getInstance() {
        return driverInstance;
    }

    public static RemoteWebDriver getMultiDriver() {
        return driver.get();
    }

    public void setMultiDriver(RemoteWebDriver driverParam) {
        driver.set(driverParam);
    }

    public void removeMultiDriver() {
        driver.get().quit();
        driver.remove();
    }

}
