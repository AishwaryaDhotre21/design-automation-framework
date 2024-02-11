package com.project.module.implementation;

import com.project.module.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupImpl {
    WebDriver driver;
    @FindBy(id="sign-username")
    private WebElement loginUserName;
    @FindBy(id="sign-password")
    private WebElement loginUserpassword;
    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Sign up')]")
            private WebElement signupText;
    PropertyReader propertyReader = new PropertyReader();
    public SignupImpl(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void signUP()
    {
        signupText.click();
        loginUserName.sendKeys(propertyReader.getProperty("login"));
        loginUserpassword.sendKeys(propertyReader.getProperty("password"));
        loginButton.click();
    }
}
