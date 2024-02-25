package com.project.module.baseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.project.module.implementation.LoginImpl;
import com.project.module.implementation.SignupImpl;
import com.project.module.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    GenerateExtentReport generateExtentReport=new GenerateExtentReport();
    protected ExtentReports extentReports;
    protected ExtentTest extentTestReporter;
    PropertyReader propertyReader = new PropertyReader();
    BrowserFactory browserFactory=new BrowserFactory();
    protected LoginImpl loginObj;
    protected SignupImpl signUPObj;
    @BeforeSuite
    public void beforeSuite()
    {
        generateExtentReport.createExtentSparkReport();
    }
    @BeforeTest
    public void beforeTest()
    {
        String browser= propertyReader.getProperty("browser");
        driver=browserFactory.createDriverInstance(browser);
        DriverFactory.getDriverFactoryInstance().setDriver(driver);
        driver=DriverFactory.getDriverFactoryInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginObj=new LoginImpl(driver);
        signUPObj=new SignupImpl(driver);
      //  driver=DriverFactory.getDriverFactoryInstance().getDriver();
        driver.get(propertyReader.getProperty("url"));
    }
    @BeforeClass
    public void beforeClass()
    {

    }
    @BeforeMethod
    public void beforeMethod(Method testMethod)
    {
        Test test= testMethod.getAnnotation(Test.class);
        extentReports=generateExtentReport.getExtentReports();
        extentTestReporter=extentReports.createTest("Test case:-"+test.testName()+"<br>Description:-"+test.description());
        ReporterFactory.getReporterFactoryInstance().setExtentTest(extentTestReporter);
    }
    @AfterMethod
    public void afterMethod(ITestResult result)
    {
        extentTestReporter=ReporterFactory.getReporterFactoryInstance().getExtentTest();
        if(result.getStatus() == ITestResult.FAILURE)
        {
            extentTestReporter.log(Status.FAIL,"<b>Function Name :"+result.getName()+"</b>");
            extentTestReporter.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SKIP)
        {
            extentTestReporter.skip("<b>Function Name:- "+result.getName()+"</b>");
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            extentTestReporter.pass("<b>Function Name:- "+result.getName()+"</b>");
        }
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
        extentReports=generateExtentReport.getExtentReports();
        extentReports.flush();
    }
}
