package com.eisgroup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePageNG {

    protected static WebDriver driver ;

    public BasePageNG() {
        driver = new FirefoxDriver();
        driver.get("http://sfoeiswas02.sjclab.exigengroup.com:9081/ipb-app/login.xhtml");
        PageFactory.initElements(driver, this);

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @FindBy(name = "topQuickSearchForm:searchExtendedBtn")
    public WebElement searchButton;

    @FindBy(xpath = ".//*[@id='tabForm:topTabsBarList:1:linkLabel']")
    public WebElement customerTabSelection;

    public void selectCustTab(){
        customerTabSelection.click();


        //   driver.getCurrentUrl();


    }

}
