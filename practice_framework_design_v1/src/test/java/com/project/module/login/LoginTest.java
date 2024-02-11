package com.project.module.login;

import com.project.module.baseTest.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(testName = "Login Method")
    public void testLogin()
    {
        loginObj.login();
    }

}

