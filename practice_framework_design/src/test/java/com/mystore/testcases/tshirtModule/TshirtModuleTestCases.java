package com.mystore.testcases.tshirtModule;

import com.mystore.testcases.baseTest.BaseTest;
import org.testng.annotations.Test;

public class TshirtModuleTestCases extends BaseTest
{

    @Test(priority = 1,testName = "Click tshirt button to navigate to dress section")
    public void demo()
    {
        logger.info("Clicking Dresses button");
        indexPageObj.click_tshirt_section();
    }
    @Test(priority = 2,testName = "select dresses to add it in cart")
    public void demo1() throws InterruptedException {
        logger.info("Adding dresses to cart");
        tshirtSectionPageObj.process_dress_list();
    }
    @Test(priority = 3,testName = "Do cheeckout")
    public void demo2()
    {
        logger.info("Click on cart button to checkout");
        indexPageObj.clickCartButton();
    }

}
