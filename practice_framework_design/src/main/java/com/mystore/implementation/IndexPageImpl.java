package com.mystore.implementation;

import com.mystore.common.BasePage;
import org.openqa.selenium.WebDriver;
import com.mystore.objectRepository.*;

public class IndexPageImpl extends BasePage implements IndexPage
{
    public IndexPageImpl(WebDriver driver) {
        super(driver);
    }
    public void click_dress_section()
    {
        getWebElement("XPATH",dressButton).click();
    }
    public void clickCartButton()
    {
        getWebElement("XPATH",cartButton).click();
    }
    public void click_tshirt_section()
    {
        getWebElement("XPATH",tshirtButton).click();
    }
}
