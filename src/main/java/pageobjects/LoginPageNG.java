package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPageNG extends BasePageNG {

    @FindBy(xpath = ".//*[@id='loginForm:j_username']")
    public WebElement loginField;

    @FindBy(xpath = ".//*[@id='loginForm:j_password']")
    public WebElement pswdField;

    @FindBy(xpath = ".//*[@id='loginForm:submitForm']")
    public WebElement loginBtn;


    // method for loginToApp(Users user){
    // will use user.getLogin() and user.getPassword()}

}
