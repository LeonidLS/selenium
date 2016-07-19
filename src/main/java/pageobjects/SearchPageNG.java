package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchPageNG extends BasePageNG {

    @FindBy(xpath = "//a[@id='searchForm:createAccountBtnAlway']")
    WebElement createCustButton;

    @FindBy(xpath = ".//*[@id='searchForm:customerType']/tbody/tr/td[1]/label")
    WebElement popUpIndividBtn;

    @FindBy(xpath = ".//*[@id='searchForm:customerType']/tbody/tr/td[2]/label")
    WebElement popUpNonIndividBtn;

    @FindBy(xpath = ".//*[@id='searchForm:yes']")
    WebElement popUpWindowOkBtn;


}

