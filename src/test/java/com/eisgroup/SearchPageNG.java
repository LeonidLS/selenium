package com.eisgroup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static com.eisgroup.BasePageNG.driver;


public class SearchPageNG /*extends BasePageNG*/ {

    @FindBy(xpath = "//a[@id='searchForm:createAccountBtnAlway']")
    WebElement createCustButton;

    @FindBy(xpath = ".//*[@id='searchForm:customerType']/tbody/tr/td[1]/label")
    WebElement popUpIndividBtn;

    @FindBy(xpath = ".//*[@id='searchForm:customerType']/tbody/tr/td[2]/label")
    WebElement popUpNonIndividBtn;

    @FindBy(xpath = ".//*[@id='searchForm:yes']")
    WebElement popUpWindowOkBtn;


    @Test(priority = 2)
    public void chooseCustomer(){

        LoginPageNG loginPage = new LoginPageNG();
        loginPage.initLoginFeilds();

        PageFactory.initElements(driver, this);


        int indNonIndCust=1;

        createCustButton.click();


        switch(indNonIndCust) {

            case 0:
                popUpIndividBtn.click();
                popUpWindowOkBtn.click();
                break;

            case 1:
                popUpNonIndividBtn.click();
                popUpWindowOkBtn.click();
                break;
        }

    }


}

