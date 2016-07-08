package com.eisgroup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchPage extends BasePage{

    public SearchPage() {
       super(driver);
    }

    @FindBy(name = "searchForm:createAccountBtnAlway")
    WebElement createCustButton;

    @FindBy(id = "searchForm:yes")
    WebElement popUpWindowYesBtn;

    private WebElement chooseCustomer;


    public void chooseCustomer(int indNonIndCust){

        switch(indNonIndCust) {

            case 0:
                chooseCustomer = driver.findElement(By.id("searchForm:customerType:0"));
                chooseCustomer.click();
                popUpWindowYesBtn.click();
                break;

            case 1:
                chooseCustomer = driver.findElement(By.id("searchForm:customerType:1"));
                chooseCustomer.click();
                popUpWindowYesBtn.click();
                break;
         }

        }



 }


