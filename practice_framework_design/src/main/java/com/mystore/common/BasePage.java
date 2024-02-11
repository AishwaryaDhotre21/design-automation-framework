package com.mystore.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver)
    {
        this.driver=driver;
    }
    public WebElement getWebElement(String identifierType, String identifierValue)
    {
        switch (identifierType)
        {
            case "XPATH":
                return driver.findElement(By.xpath(identifierValue));
            case "CSS":
                return driver.findElement(By.cssSelector(identifierValue));
            case "ID":
                return driver.findElement(By.id(identifierValue));
            case "NAME":
                return driver.findElement(By.name(identifierValue));
            case "TAGNAME":
                return driver.findElement(By.tagName(identifierValue));
            case "CLASSNAME":
                return driver.findElement(By.className(identifierValue));
            case "LINKTEXT":
                return driver.findElement(By.linkText(identifierValue));
            default:
                return null;
        }
    }
    public List<WebElement> getWebElements(String identifierType, String identifierValue)
    {
        switch (identifierType)
        {
            case "XPATH":
                return driver.findElements(By.xpath(identifierValue));
            case "CSS":
                return driver.findElements(By.cssSelector(identifierValue));
            case "ID":
                return driver.findElements(By.id(identifierValue));
            case "NAME":
                return driver.findElements(By.name(identifierValue));
            case "TAGNAME":
                return driver.findElements(By.tagName(identifierValue));
            case "CLASSNAME":
                return driver.findElements(By.className(identifierValue));
            case "LINKTEXT":
                return driver.findElements(By.linkText(identifierValue));
            default:
                return null;
        }
    }
    public void scrollUp()
    {

    }
    public void scrollDown()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }
    public WebDriver getDriver()
    {
        return driver;
    }
}
