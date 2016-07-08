package com.eisgroup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by LEON on 06.07.2016.
 */
public class LoginPage extends BasePage{


    public LoginPage(String userLogin, String userPswd) {
        super(driver);

        loginField.sendKeys(userLogin);
        pswdField.sendKeys(userPswd);

        loginBtn.click();
    }


    @FindBy(name = "loginForm:j_username")
    public WebElement loginField;

    @FindBy(name = "loginForm:j_password")
    public WebElement pswdField;

    @FindBy(name = "loginForm:submitForm")
    public WebElement loginBtn;


}

