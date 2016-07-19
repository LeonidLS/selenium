package com.eisgroup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static com.eisgroup.BasePageNG.driver;


/**
 * Created by LEON on 16.07.2016.
 */
public class CustomerPageNG {

    @FindBy(xpath = "//select[@id='crmForm:generalInfoLeft_businessType']")
    WebElement nonIndTypeCombo;

    @FindBy(xpath = "//input[@id='crmForm:generalInfoLeft_legalName']")
    WebElement nameLegalField;

    @FindBy(xpath = "//input[@id='crmForm:generalInfoLeft_legalId']")
    WebElement eisField;

    @FindBy(xpath = "//input[@id='crmForm:generalInfoLeft_dateStartedInputDate']")
    WebElement dateBuisStartedField;

    @FindBy(xpath = "//select[@id='crmForm:sicInfo_sicDivision']")
    WebElement divisionCombo;

    @FindBy(xpath = "//select[@id='crmForm:sicInfo_sicIndustry']")
    WebElement industryCombo;

    @FindBy(xpath = "//select[@id='crmForm:sicInfo_sicCode']")
    WebElement sicDescriptionCombo;

    @FindBy(xpath = "//select[contains(@id,'crmForm:salesInfo_source')]")
    WebElement leadSourceCombo;

    @FindBy(xpath = "//select[contains(@id,'crmForm:salesInfo_rating')]")
    WebElement ratingCombo;

    @FindBy(xpath = "//select[@id='crmForm:addressInfo_0_addressTypeCd']")
    WebElement addrTypeCombo;

    @FindBy(xpath = "//select[@id='crmForm:addressInfo_0_countryCd']")
    WebElement countryCombo;

    @FindBy(xpath = "//input[contains(@id,'crmForm:addressInfo_0_postalCode')]")
    WebElement zipPostCodeField;

    @FindBy(xpath = "//input[@id='crmForm:addressInfo_0_city']")
    WebElement cityField;

    @FindBy(xpath = "//select[contains(@id,'crmForm:addressInfo_0_stateProvCd')]")
    WebElement stateProvinceCombo;

    @FindBy(xpath = "//input[contains(@id,'crmForm:addressInfo_0_addressLine1')]")
    WebElement addrLine1Field;

    public void fillCustomerFields(String elementId, String sendData, String listType) {
        //   WebElement customerFields = driver.findElement(By.name(""));

        if (listType.equals("Combo")) {
            Select dropDown = new Select(driver.findElement(By.xpath(elementId)));
            dropDown.selectByIndex(2);
        } else {
            WebElement customerFields = driver.findElement(By.xpath(elementId));
            customerFields.sendKeys(sendData);
        }

    }

    @Test(priority = 3)
    public void implementFilling(){

        SearchPageNG searchPageNG = new SearchPageNG();
        searchPageNG.chooseCustomer();

        PageFactory.initElements(driver, this);


        Select nonIndTypeDDown = new Select(nonIndTypeCombo);
        nonIndTypeDDown.selectByIndex(2);

        nameLegalField.sendKeys("Michael Jackson");
        eisField.sendKeys("1231312312312");
        dateBuisStartedField.sendKeys("05/01/2016");

        Select divisionDDown = new Select(divisionCombo);
        divisionDDown.selectByIndex(2);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        industryCombo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='crmForm:sicInfo_sicIndustry']")));

        Select industryDDown = new Select(industryCombo);
        industryDDown.selectByIndex(1);

        sicDescriptionCombo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='crmForm:sicInfo_sicCode']")));
        Select sicDescriptionDDown = new Select(sicDescriptionCombo);
        sicDescriptionDDown.selectByIndex(2);

        Select leadSourceDDown = new Select(leadSourceCombo);
        leadSourceDDown.selectByIndex(2);

        Select ratingDDown = new Select(ratingCombo);
        ratingDDown.selectByIndex(2);

        Select addrTypeDDown = new Select(addrTypeCombo);
        addrTypeDDown.selectByIndex(6);

        Select countryComboDDown = new Select(countryCombo);
        countryComboDDown.selectByIndex(228);

        zipPostCodeField.sendKeys("10001");
        cityField.sendKeys("NY");

        Select stateProvinceDDown = new Select(stateProvinceCombo);
        stateProvinceDDown.selectByValue("NY");

        addrLine1Field.sendKeys("Trassa E95");

    }


}
