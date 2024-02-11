package com.mystore.utills;

import com.mystore.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssertStatements {

    WebDriver driver;
    WebDriverWait wait;
    public AssertStatements(WebDriver driver)
    {
        this.driver=driver;
    }
    public void waitForElementToBeClickable(WebElement e)
    {
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }
    public void waitForElementToBeVisible(WebElement e)
    {
        wait=new WebDriverWait(driver,10);
       wait.until(ExpectedConditions.visibilityOf(e));
    }
}
