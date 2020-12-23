import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TableElementsTest {
    WebDriver driver;
    Utils utils;
    WebElement tableElement;
    ArrayList<String> list;
    int count = 0;

    @BeforeMethod
    public void initTest(){
        utils = new Utils();
        utils.setPropertyDriver();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //open site
        utils.openSite(driver, Constants.Tables.URL_ELEMENTS);
    }

    @Test(invocationCount = 5)
    public void uncheckedFirstTest(){
        //init elements
        initTable();
        initList();
        testTable();
    }

    @AfterMethod
    public void exitTest(){
        utils.quitDriver(driver);
    }

    public void testTable(){
        String item = list.get(count);
        count ++;
        //get only td with table
        String xpath = "//tr[1]//td[" + count + "]";
        //get text
        String trStr = utils.getTextElementByElementByXpath(tableElement, xpath);
        String message = "Actual = " + trStr + ", expected = " + item;
        //check result
        utils.checkResult(trStr, item, message);
    }

    public void initTable(){
        tableElement = utils.getElementByXpath(driver, Constants.Tables.ID_ELEMENTS);
    }

    public void initList(){
        list = new ArrayList <String>();
        list.add("Smith");
        list.add("John");
        list.add("jsmith@gmail.com");
        list.add("$50.00");
        list.add("http://www.jsmith.com");
    }
}
