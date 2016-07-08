package com.eisgroup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by lsushchenko on 7/8/2016.
 */



public class CustomerPage extends BasePage {
    public CustomerPage() {
        super(driver);
    }

    //@FindBy(name = "")

    public void fillCustomerFields(String elementId, String sendData, String listType) {
     //   WebElement customerFields = driver.findElement(By.name(""));

        if (listType.equals("Combo")) {
            Select dropDown = new Select(driver.findElement(By.id(elementId)));
            dropDown.selectByIndex(2);
        } else {
            WebElement customerFields = driver.findElement(By.id(elementId));
            customerFields.sendKeys(sendData);
        }

    }

}
