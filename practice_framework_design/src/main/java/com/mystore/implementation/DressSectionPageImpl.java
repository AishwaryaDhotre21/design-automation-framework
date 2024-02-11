package com.mystore.implementation;

import com.mystore.common.BasePage;
import com.mystore.utills.AssertStatements;
import com.mystore.utills.PropertiesReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.mystore.objectRepository.*;
import org.openqa.selenium.WebElement;


import java.util.List;

public class DressSectionPageImpl extends BasePage implements DressSectionPage {

    protected WebDriver driver=getDriver();
    AssertStatements obj=new AssertStatements(driver);
    List<WebElement> li_of_dress_Web_elements;

    PropertiesReader propertiesReader=new PropertiesReader();
    public DressSectionPageImpl(WebDriver driver) {
        super(driver);
    }
   /* public void process_dress_list() throws InterruptedException {
        li_of_dress_Web_elements=getWebElements("XPATH",dresses);
        li_of_add_to_cart_button_WebElements=getWebElements("XPATH",addToCartButton);
        String[] listOfDress=propertiesReader.getProperty("dress_names").split(",");
        int i;
        for (String str:listOfDress)
        {
            System.out.println(str);
            for(i=0;i<li_of_dress_Web_elements.size();i++)
            {
                System.out.println(li_of_dress_Web_elements.get(i).getText());
                if(li_of_dress_Web_elements.get(i).getText().equalsIgnoreCase(str))
                {
                    Thread.sleep(5000);
                    li_of_add_to_cart_button_WebElements.get(i).click();
                }
            }
        }

    }*/

    public void process_dress_list()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,500)");
        li_of_dress_Web_elements=getWebElements("XPATH",dresses);
        String[] listOfDress=propertiesReader.getProperty("dress_names").split(",");
        for(int i=0;i<listOfDress.length;i++)
        {
            for (WebElement e : li_of_dress_Web_elements) {
                if (e.getText().equalsIgnoreCase(listOfDress[i]))
                {
                    obj.waitForElementToBeClickable(e);
                    System.out.println(e.getText());
                    e.click();
                    this.addToCart();
                    driver.navigate().back();
                    break;
                }
            }
        }
    }
    public void addToCart()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        getWebElement("XPATH",addToCartButton).click();
        obj.waitForElementToBeVisible(getWebElement("XPATH",cartVerificationWindow));
        obj.waitForElementToBeVisible(getWebElement("XPATH",continueShopping));
        getWebElement("XPATH",continueShopping).click();
    }

}
