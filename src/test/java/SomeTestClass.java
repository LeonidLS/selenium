import org.testng.annotations.Test;
import pageobjects.CustomerPageNG;
import pageobjects.LoginPageNG;
import pageobjects.SearchPageNG;

public class SomeTestClass {

    @Test(priority = 1) // rename to understandable title (loginToAppTest)
    public void initLoginFeilds() {

        //TODO: move to method on pageobjects.LoginPageNG loginToApp(User user)
        LoginPageNG loginPageNG = new LoginPageNG();

        loginPageNG.loginField.sendKeys("qa");
        loginPageNG.pswdField.sendKeys("qa");
        loginPageNG.loginBtn.click();

        loginPageNG.selectCustTab();

        //TODO: following not a step from test case
        //loginPageNG.driver.getCurrentUrl();
    }

    @Test(priority = 2) // rename to initiateCreateCustomer
    public void chooseCustomer() {

        //TODO loginPage.loginToApp(send constant, read about Enums in java to store user's credentials in)
        initLoginFeilds();

        //TODO remove odd pageinit invocation
        //PageFactory.initElements(driver, this);

        int indNonIndCust = 1;

        CustomerPageNG customerPageNG = new CustomerPageNG();
        //TODO: use method instead of createCustButton direct usege
        //customerPageNG.createCustButton.click();

        //TODO: selection of the Individual or Non Individual add to new class for CustomerTypeSelectionPopUp and use from there
        //TODO: should have method selectCustomerType(String type)
/*        switch (indNonIndCust) {

            case 0:
                popUpIndividBtn.click();
                popUpWindowOkBtn.click();
                break;

            case 1:
                popUpNonIndividBtn.click();
                popUpWindowOkBtn.click();
                break;
        }*/

    }


    @Test(priority = 3)
    public void implementFilling() {

        SearchPageNG searchPageNG = new SearchPageNG();
        chooseCustomer();
        //TODO: use initial BasePage constructor instead
//        PageFactory.initElements(driver, this);


        /*Select nonIndTypeDDown = new Select(nonIndTypeCombo);
        nonIndTypeDDown.selectByIndex(2);*/
        //TODO: Move to method fillCustomerFields from CustomerPageNG
 /*       nameLegalField.sendKeys("Michael Jackson");
        eisField.sendKeys("1231312312312");
        dateBuisStartedField.sendKeys("05/01/2016");

        Select divisionDDown = new Select(divisionCombo);
        divisionDDown.selectByIndex(2);
        // waits move to separate util class waitForElementEnabled(WebElement element, long timeout), should fail if element is not enabled during defined timeout
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

        addrLine1Field.sendKeys("Trassa E95");*/

    }

}
