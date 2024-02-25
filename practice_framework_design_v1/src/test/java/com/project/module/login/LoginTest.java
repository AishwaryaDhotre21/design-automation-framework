package com.project.module.login;

import com.aventstack.extentreports.Status;
import com.project.module.baseTest.BaseTest;
import com.project.module.baseTest.ReporterFactory;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(testName = "Login Method")
    public void testLogin()
    {
        extentTestReporter= ReporterFactory.getReporterFactoryInstance().getExtentTest();
        extentTestReporter.log(Status.INFO,"login test");
        loginObj.login();
    }

}

