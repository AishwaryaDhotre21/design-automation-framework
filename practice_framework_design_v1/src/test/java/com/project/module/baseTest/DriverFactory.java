package com.project.module.baseTest;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    ThreadLocal <WebDriver> threadLocalDriver=new ThreadLocal<WebDriver>();
    private DriverFactory(){}

    private static DriverFactory driverFactoryInstance=new DriverFactory();

    public static DriverFactory getDriverFactoryInstance()
    {
        return driverFactoryInstance;
    }

    public WebDriver getDriver()
    {
        return threadLocalDriver.get();
    }
    public void setDriver(WebDriver driver)
    {
        threadLocalDriver.set(driver);
    }

}
