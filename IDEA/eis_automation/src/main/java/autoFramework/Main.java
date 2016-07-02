package autoFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by LEON on 02.07.2016.
 */
public class Main {

        public static void xpath_practice1() {
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();

            driver.get("http://toolsqa.com/automation-practice-table");

            String sRow = "1";
            String sCol = "2";


            WebElement mySelect = driver.findElement(By.xpath(".//*[@class='content']/table/tbody/tr[" + sRow + "]/td[" + sCol + "]"));


            String fromCell = driver.findElement(By.xpath(".//*[@class='content']/table/tbody/tr[" + sRow + "]/td[" + sCol + "]")).getText();

//  System.out.println(fromCell);

//  Select oSelect = new Select(element);

            fromCell = driver.findElement(By.xpath(".//*[@class='content']/table/tbody/tr[" + 2 + "]/td[" + 1 + "]")).getText();


            String getCells = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div/div/table/tbody/tr[2]/th")).getText();

            String loopStr;

            //System.out.println(loopStr);

            String strFirstClmn = driver.findElement(By.xpath(".//*[@class='content']/table/tbody/tr[" + 2 + "]/th")).getText();

            System.out.println(strFirstClmn);

            for (int i = 1; i <= 5; i++) {
                loopStr = driver.findElement(By.xpath(".//*[@class='content']/table/tbody/tr[2]/td[" + i + "]")).getText();
                System.out.println(loopStr);

            }


            driver.close();

        }



    public static void xpath_practice(){
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://toolsqa.com/automation-practice-table/");

        String sCellValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[2]")).getText();
        System.out.println(sCellValue);

        driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[6]/a")).click();



        driver.close();
    }

    public static void multiselect() throws InterruptedException{
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.get("http://toolsqa.com/automation-practice-form/");

        WebElement element = driver.findElement(By.name("selenium_commands"));

        Select oSelect = new Select(element);

        //multiselList.get(0).click();

        oSelect.selectByIndex(3);

        oSelect.getOptions().size();

        Thread.sleep(2000);

        oSelect.deselectByIndex(3);

        oSelect.selectByVisibleText("Navigation Commands");
        Thread.sleep(2000);
        oSelect.deselectByVisibleText("Navigation Commands");


        for (int i=0; i< oSelect.getOptions().size(); i++){
            oSelect.selectByIndex(i);
            String s1 = oSelect.getOptions().get(i).getText();
            System.out.println(s1);

        }

        Thread.sleep(1500);

        oSelect.deselectAll();


//	driver.findElement(By.cssSelector("select[value='Selenium IDE']"));

        Thread.sleep(1000);



        driver.close();
    }

    public static void tryselect() throws InterruptedException{

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("http://toolsqa.com/automation-practice-form/");


        WebElement element = driver.findElement(By.id("continents"));

        Select oSelect = new Select(element);

        List <WebElement> elemsCount = oSelect.getOptions();
        String s1 = elemsCount.get(3).getText();
        oSelect.selectByVisibleText(s1);

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);

        oSelect.selectByIndex(1);

        int dDownSize = elemsCount.size();

        for (int i=0; i<dDownSize; i++){
            String s2 = elemsCount.get(i).getText();
            System.out.print(" elem #" + i + " " + s2);
        }

        oSelect.selectByIndex(dDownSize-1);
        Thread.sleep(1000);



        driver.quit();

    }

    public static void clarify(){
        WebDriver drive = new FirefoxDriver();

    }
    public static void example(){
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://toolsqa.com/automation-practice-form");

        List<WebElement> rdBtn_Sex = driver.findElements(By.name("sex"));

        boolean bValue = false;

        bValue = rdBtn_Sex.get(0).isSelected();

        if(bValue == true){

            rdBtn_Sex.get(1).click();
        }

        WebElement rdBtn_Exp = driver.findElement(By.id("exp-2"));
        rdBtn_Exp.click();

        List<WebElement> chkBx_Profession = driver.findElements(By.name("profession"));

        int iSize = chkBx_Profession.size();

        for(int i=0; i < iSize ; i++ ){

            String sValue = chkBx_Profession.get(i).getAttribute("value");


            if (sValue.equalsIgnoreCase("Automation Tester")){
                chkBx_Profession.get(i).click();

                break;
            }
        }

        WebElement oCheckBox = driver.findElement(By.cssSelector("input[value='Selenium IDE']"));
        oCheckBox.click();

        // Kill the browser
        driver.quit();

    }

    public static void sel_desel(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://toolsqa.com/automation-practice-form/");


        List<WebElement> RadBut = driver.findElements(By.name("sex"));

        boolean ifSelect = false;

        ifSelect = RadBut.get(1).isSelected();


        if (ifSelect == false){
            RadBut.get(1).click();
        }

        driver.findElement(By.id("exp-2")).click();

        List<WebElement> ProfCheckList = driver.findElements(By.name("profession"));
        int ListSize = ProfCheckList.size();

        for (int i=0; i<ListSize; i++) {
            if (ProfCheckList.get(i).getAttribute("value").equalsIgnoreCase("Automation Tester")){
                ProfCheckList.get(i).click();
                break;
            }
        }

        driver.findElement(By.cssSelector("input[value='Selenium IDE'")).click();
    }

    public static void findEl() throws InterruptedException{
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://www.toolsqa.com/automation-practice-form/");
        driver.findElement(By.name("firstname")).sendKeys("Peter");
        driver.findElement(By.name("lastname")).sendKeys("Pen");
        driver.findElement(By.id("submit")).click();

        driver.findElement(By.partialLinkText("Partial")).click();
        System.out.println("Partial Link Test Pass");
        String ButName = driver.findElements(By.tagName("Button")).toString();
        System.out.print("Button Name = " + ButName);
        driver.findElement(By.linkText("Link Test")).click();
        System.out.println("Link Test Pass");
        // driver.close();
    }

    public static void navi(){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.DemoQA.com");
        driver.findElement(By.xpath(".//*[@id='menu-item-374']/a")).click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().to("http://www.DemoQA.com");
        driver.navigate().refresh();
        driver.close();
    }

    public static void exec(){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://demoqa.com/frames-and-windows/");
        driver.findElement(By.xpath(".//*[@id='tabs-1']/div/p/a")).click();

        driver.close();
    }

    public static void first() throws InterruptedException{

        boolean Flag=false;

        WebDriver driver = new FirefoxDriver();


        driver.get("http://www.store.demoqa.com");

        String Title = driver.getTitle();
        System.out.print(Title + "\n");
        System.out.println("Title length = " + Title.length());
        System.out.println("Page source length = " + driver.getPageSource().length());

        System.out.println("Current URL = " + driver.getCurrentUrl());

        String CurrUrl = driver.getCurrentUrl();

        if (CurrUrl.contains("store.demoqa.com")) Flag = true;
        else Flag = false;

        String MyUrl = "http://store.demoqa.com/";

        if (CurrUrl.equals(MyUrl)) Flag = true;
        else Flag = false;


        System.out.println("If it's http://store.demoqa.com currently open? " + Flag);

        System.out.println("Successfully opened the website www.Store.Demoqa.com");

        Thread.sleep(5);

        driver.quit();

    }

    public static void main(String[] args) throws InterruptedException, IOException {

        clsActions mHover = new clsActions("http://store.demoqa.com/");
        mHover.mouseHover();

            clsActions doAct = new clsActions("http://dev2aig4was501.eqxdev.exigengroup.com:9082/cah-app/");
             doAct.logPass();
             doAct.openCustomer("nonIndivid", "unicast_ni");
             doAct.tabQuote();
             doAct.idQuote("0701448");
             doAct.selectAction("Data Gather");
             doAct.switchTabs();




}

    }

