package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


//TODO remove all NG postfixes
public class BasePageNG {

    protected static WebDriver driver ;

    public BasePageNG() {
        //TODO Move to WebDriver factory initialization of the WebDriver instance
        driver = new FirefoxDriver();
        driver.get("http://sfoeiswas02.sjclab.exigengroup.com:9081/ipb-app/login.xhtml");
        PageFactory.initElements(driver, this);

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }
    // TODO move elements to separate Common Page
    @FindBy(name = "topQuickSearchForm:searchExtendedBtn")
    public WebElement searchButton;

    @FindBy(xpath = ".//*[@id='tabForm:topTabsBarList:1:linkLabel']")
    public WebElement customerTabSelection;

    //TODO rename to navigateToCustomerPageNG(), should return CustomerPageNG
    public void selectCustTab(){
        customerTabSelection.click();
    }

}
