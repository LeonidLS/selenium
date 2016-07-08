package com.eisgroup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

   protected static WebDriver driver ;

    public BasePage(WebDriver driverC) {
        PageFactory.initElements(driverC, this);
         driver = driverC;
    }

    @FindBy(name = "topQuickSearchForm:searchExtendedBtn")
    public WebElement searchButton;

}
