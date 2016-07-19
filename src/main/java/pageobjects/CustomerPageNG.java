package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static pageobjects.BasePageNG.driver;

public class CustomerPageNG {

    //TODO for each element from UI create accessories (set and get values from ui methods)
    // DOn't forget about incapsulation add correct prefixes, should be protected
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

    //TODO method should receive Customer class for filling all mandatory fields
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




}
