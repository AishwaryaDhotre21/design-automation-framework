package com.mystore.testcases.baseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mystore.implementation.DressSectionPageImpl;
import com.mystore.implementation.IndexPageImpl;
import com.mystore.implementation.TshirtSectionPageImpl;
import com.mystore.utills.GenerateExtentReport;
import com.mystore.utills.PropertiesReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;
    protected PropertiesReader objPropertiesReader=new PropertiesReader();
    GenerateExtentReport objGenExtentReport=new GenerateExtentReport();
    protected ExtentReports extent;
    protected ExtentTest logger;
    protected IndexPageImpl indexPageObj;
    protected DressSectionPageImpl dressSectionPageObj;
    protected TshirtSectionPageImpl tshirtSectionPageObj;
    @BeforeSuite
    public void beforeSuite()
    {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        indexPageObj =new IndexPageImpl(driver);
        dressSectionPageObj=new DressSectionPageImpl(driver);
        tshirtSectionPageObj=new TshirtSectionPageImpl(driver);
    }
    @BeforeClass
    public void beforeClass()
    {
        driver=getDriver();
        String homePageLink=objPropertiesReader.getProperty("url");
        driver.get(homePageLink);
        driver.manage().window().maximize();
        objGenExtentReport.createReport();
    }
    @AfterClass
    public void afterSuite()
    {
        extent.flush();
        driver.quit();
    }
    @BeforeMethod
    public void beforeMethod(Method testMethod) {
        extent=objGenExtentReport.getExtent();
        Test test= testMethod.getAnnotation(Test.class);
        logger=extent.createTest("Test case:-"+test.testName()+"<br>Description:-"+test.description());
    }
    @AfterMethod
    public void afterMethod(ITestResult result, Method testMethod)
    {
        Test test=testMethod.getAnnotation(Test.class);
        String className=result.getTestClass().getName();
        String newClassName=create_canonical_class_name(className);

        if(result.getStatus() == ITestResult.FAILURE)
        {
            logger.log(Status.FAIL,"<b>Function Name :"+result.getName()+"</b>");// prints the function name
            logger.fail(result.getThrowable());// prints the exception raised
        }
        else if(result.getStatus() == ITestResult.SKIP)
        {
            logger.log(Status.SKIP,"<b>Function Name:- "+result.getName()+"</b>");
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            logger.log(Status.PASS,"<b>Function Name:- "+result.getName()+"</b>");
        }
        logger.log(Status.INFO,"<b>Test Class Name:- "+result.getTestClass().getName()+"</b>");

        logger.info("<b>Canonical Class name:- " + newClassName+"</b>");
    }

    public WebDriver getDriver()
    {
        return driver;
    }
    public String create_canonical_class_name(String className)
    {
        String[] array=className.split("\\.");
        System.out.println(array);
        String newClassName=array[array.length-1];
        System.out.println("Class Name:-"+newClassName);
        return newClassName;
    }
}
