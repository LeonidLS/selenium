package com.eisgroup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;


public class LoginPageNG extends BasePageNG {

    @FindBy(xpath = ".//*[@id='loginForm:j_username']")
    public WebElement loginField;

    @FindBy(xpath = ".//*[@id='loginForm:j_password']")
    public WebElement pswdField;

    @FindBy(xpath = ".//*[@id='loginForm:submitForm']")
    public WebElement loginBtn;

    @Test(priority = 1)
    public void initLoginFeilds() {

        loginField.sendKeys("qa");
        pswdField.sendKeys("qa");
        loginBtn.click();

        super.selectCustTab();

        driver.getCurrentUrl();
    }
}
