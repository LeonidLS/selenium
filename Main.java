package com.eisgroup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by LEON on 06.07.2016.
 */
public class Main {

    public static WebDriver driver = new FirefoxDriver();


    public static void main(String[] args){

        driver.get("http://sfoeiswas02.sjclab.exigengroup.com:9081/ipb-app/login.xhtml");

        BasePage basePage = new BasePage(driver);

        LoginPage logPage = new LoginPage("qa", "qa");

        basePage.searchButton.click();

        SearchPage searchPage = new SearchPage();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        searchPage.createCustButton.click();

        searchPage.chooseCustomer(1);

        CustomerPage custPage = new CustomerPage();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        custPage.fillCustomerFields("crmForm:generalInfoLeft_businessType", "", "Combo");
        custPage.fillCustomerFields("crmForm:generalInfoLeft_legalName", "Boris Fedorov", "");
        custPage.fillCustomerFields("crmForm:generalInfoLeft_legalId", "1231312312312", "");
        custPage.fillCustomerFields("crmForm:generalInfoLeft_dateStartedInputDate", "07/01/2012", "");
        custPage.fillCustomerFields("crmForm:sicInfo_sicDivision", "", "Combo");
        custPage.fillCustomerFields("crmForm:sicInfo_sicIndustry", "", "Combo");
        custPage.fillCustomerFields("crmForm:sicInfo_sicCode", "", "Combo");
        custPage.fillCustomerFields("crmForm:salesInfo_source", "", "Combo");
        custPage.fillCustomerFields("crmForm:addressInfo_0_countryCd", "", "Combo");
        custPage.fillCustomerFields("crmForm:addressInfo_0_postalCode", "10001", "");







    }
}
