package com.project.module.signUP;

import com.project.module.baseTest.BaseTest;
import com.project.module.baseTest.ReporterFactory;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest
{
    @Test(testName = "Signup Method")
    public void testLogin()
    {
        extentTestReporter= ReporterFactory.getReporterFactoryInstance().getExtentTest();
        extentTestReporter.info("signup test");
        signUPObj.signUP();
    }
}
