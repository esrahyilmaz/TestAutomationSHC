package com.fadv.automation.core;

import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    private DriverFactory(){
        //do nothing... do not allow initialization outside of this class
    }

    private static DriverFactory driverInstance = new DriverFactory();

    public static DriverFactory getInstance(){
        return driverInstance;
    }

    static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

    public static RemoteWebDriver getMultiDriver(){
        return driver.get();
    }

    public void setMultiDriver(RemoteWebDriver driverParam) {
        driver.set(driverParam);
    }

        public void removeMultiDriver(){
            driver.get().quit();
            driver.remove();
        }

}
