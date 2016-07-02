package autoFramework;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * Created by LEON on 02.07.2016.
 */
public class clsActions {
    private static WebDriver driver = new FirefoxDriver();;
    private static String instanceUrl;
    private static String[] custTypes = new String[2];

    public int nn;


     clsActions(String instUrl){
        driver.manage().window().maximize();

        instanceUrl = instUrl;
        driver.get(instanceUrl);
        custTypes[0] = "Individ";
        custTypes[1] = "nonIndivid";

    }


    void mouseHover(){
        WebElement element = driver.findElement(By.linkText("Product Category"));

        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();

        driver.findElement(By.linkText("iPads")).click();

    }

    void DragNDrop(){
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        WebElement From = driver.findElement(By.xpath(".//*[@id='treebox1']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));

        WebElement To = driver.findElement(By.xpath(".//*[@id='treebox2']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));

        Actions builder = new Actions(driver);

        Action dragAndDrop = builder.clickAndHold(From)
                .moveToElement(To)
                .release(To)
                .build();
        dragAndDrop.perform();
    }

    void DragNDrop1(){
        driver.findElement(By.name("j_username")).sendKeys("Username");
        driver.findElement(By.name("j_password")).sendKeys("Password");

        driver.findElement(By.name("login")).click();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        WebElement From = driver.findElement(By.xpath(".//*[@id='userChecklists']/li[1]/a/span"));

        WebElement To = driver.findElement(By.xpath(".//*[@id='userChecklists']/li[4]/a/span"));

        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(From).moveToElement(To)
                .release(To)
                .build();
        dragAndDrop.perform();


    }

    void switchTabs() throws IOException{
        driver.findElement(By.xpath(".//span[text()='Coverage Definition']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath(".//span[text()='Classification Management']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath(".//span[text()='Reinsurance']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath(".//span[text()='Premium Summary']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("topSaveAndExitLink")).click();

        TakesScreenshot ts=(TakesScreenshot)driver;

        File source=ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(source, new File("./Screenshots/SCREENSHOT.jpg"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("Passed!");
    }

    void tabQuote(){
        try{
            driver.findElement(By.id("tabForm:topTabsBarList:5:linkLabel")).click();
        }catch(NoSuchElementException e){
            System.out.print("No such element found!");
        }

    }

    void insurProductDDown(){
        try{
            Select dropDown = new Select(driver.findElement(By.id("policyDataGatherForm:sedit_Policy_aigPolicyDetail_insuranceProductCd")));
            dropDown.selectByIndex(2);
        }catch(NoSuchElementException e){System.out.println("No such element!");
        }
    }

    void insurPlanDDown(){
        try{
            Select dropDown = new Select(driver.findElement(By.id("policyDataGatherForm:sedit_AIGPlanDefinition_planCd")));
            dropDown.selectByIndex(3);
        }catch(NoSuchElementException e){System.out.println("No such element!");
        }
    }

    void selectAction(String Action){
        Select dropDown = new Select(driver.findElement(By.id("producContextInfoForm:moveToBox")));
        if (Action.equals("Data Gather")) {
            dropDown.selectByIndex(2);
            driver.findElement(By.id("producContextInfoForm:btnMoveToDecorete")).click();
        }
        insurProductDDown();
        popupOkClick();
        insurPlanDDown();

    }

    void popupOkClick(){
        try{
            driver.findElement(By.id("productCdConfirmFormInner:okay")).click();
        }catch(NoSuchElementException e){
            System.out.println("No such element!");
        }
    }

    void idQuote(String quoteNum){
        try{
            driver.findElement(By.xpath(".//td[contains(@id, 'quotePageContents:body_quote_list_table')]/a[text()='"+ quoteNum + "']")).click();
        }
        catch(NoSuchElementException e){System.out.print("No such element found!");}

    }

    void makeScr() throws IOException{
        driver.manage().window().maximize();

        driver.get("http://www.facebook.com");

        TakesScreenshot ts=(TakesScreenshot)driver;

        File source=ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(source, new File("./Screenshots/facebook.png"));

        System.out.println("Screenshot was taken!");

        driver.quit();
    }


    void logPass(){
        WebElement logField = driver.findElement(By.id("loginForm:j_username"));
        logField.sendKeys("qa");

        WebElement passField = driver.findElement(By.id("loginForm:j_password"));
        passField.sendKeys("qa");

        driver.findElement(By.id("loginForm:submitForm")).click();

    }

    void btnSearch(){
        WebElement searchBtn = driver.findElement(By.id("searchForm:searchBtn"));
        searchBtn.click();
    }

    void findInTable(){
        driver.get("http://dev2aig4was501.eqxdev.exigengroup.com:9082/cah-app/flow?_flowId=search-main-flow&_flowExecutionKey=e1s1&_windowId=W1450211093362");
        driver.manage().window().maximize();

        String s = driver.findElement(By.xpath("//span[contains(@id,'searchTable1Form:body_searchTable1')]/*/table/tbody/tr[searchTable1Form:body_searchTable1:0]/td[searchTable1Form:body_searchTable1:0]")).getText();

        System.out.println(s);

    }

    void openCustomer(String custType, String custName) throws InterruptedException{

        int i=0;
        String strNames = "";

        if ((custName.equals("")) || (custName.equals(null))) {driver.quit();}
        if ((custType.equals("")) || (custType.equals(null))) {driver.quit();}


        driver.getCurrentUrl();
        driver.findElement(By.id("topQuickSearchForm:searchExtendedBtn")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        if (custType.equals("nonIndivid")){
            WebElement buisName = driver.findElement(By.id("searchForm:searchFormME_businessName"));
            buisName.sendKeys(custName);

            btnSearch();


            try {
                WebElement webEl = driver.findElement(By.xpath(".//*[@id='j_id_1v_3y']/div/form/div/span/table/tbody/tr[contains(@id, 'searchTable1Form:body_searchTable')]/td/a/div/span[text()='" + custName + "']"));
                webEl.click();


            } catch(NoSuchElementException e){
                System.out.println("Element not found!");
            }



        }else if(custType.equals("Individ")){}

    }


}