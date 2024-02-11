package com.project.module.baseTest;

import com.project.module.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    PropertyReader propertyReader = new PropertyReader();
    BrowserFactory browserFactory=new BrowserFactory();
    @BeforeSuite
    public void beforeSuite()
    {
        String browser= propertyReader.getProperty("browser");
        driver=browserFactory.createDriverInstance(browser);
        DriverFactory.getDriverFactoryInstance().setDriver(driver);
        driver=DriverFactory.getDriverFactoryInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @BeforeTest
    public void beforeTest()
    {
        driver.get(propertyReader.getProperty("url"));
    }
    @BeforeClass
    public void beforeClass()
    {

    }
    @BeforeMethod
    public void beforeMethod()
    {

    }
    @AfterMethod
    public void afterMethod()
    {

    }
    @AfterClass
    public void afterClass()
    {

    }
    @AfterTest
    public void afterTest()
    {
        driver=DriverFactory.getDriverFactoryInstance().getDriver();
        if(driver!=null)
        {
            driver.quit();
        }
    }
    @AfterSuite
    public void afterSuite()
    {

    }
}
