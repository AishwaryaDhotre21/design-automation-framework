package com.mystore.implementation;

import com.mystore.common.BasePage;
import com.mystore.objectRepository.TshirtSection;
import com.mystore.utills.AssertStatements;
import com.mystore.utills.PropertiesReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TshirtSectionPageImpl extends BasePage implements TshirtSection {

    protected WebDriver driver=getDriver();
    AssertStatements obj=new AssertStatements(driver);
    public TshirtSectionPageImpl(WebDriver driver)
    {
        super(driver);
    }
    List<WebElement> li_of_dress_Web_elements;
    PropertiesReader propertiesReader=new PropertiesReader();
    public void process_dress_list()
    {
        scrollDown();
        li_of_dress_Web_elements=getWebElements("XPATH",tshirts);
        String[] listOfDress=propertiesReader.getProperty("tshirt_names").split(",");
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
        scrollDown();
        getWebElement("XPATH",addToCartButton).click();
        obj.waitForElementToBeVisible(getWebElement("XPATH",cartVerificationWindow));
        obj.waitForElementToBeVisible(getWebElement("XPATH",continueShopping));
        getWebElement("XPATH",continueShopping).click();
    }
}
