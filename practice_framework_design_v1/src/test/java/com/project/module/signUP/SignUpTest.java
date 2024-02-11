package com.project.module.signUP;

import com.project.module.baseTest.BaseTest;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest
{
    @Test(testName = "Signup Method")
    public void testLogin()
    {
        signUPObj.signUP();
    }
}
