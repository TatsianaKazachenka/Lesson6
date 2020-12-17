import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TyposElementsTest {
    WebDriver driver;
    Utils utils;
    WebElement typosElement;

    @BeforeMethod
    public void initTest(){
        utils = new Utils();
        utils.setPropertyDriver();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //open site
        utils.openSite(driver, Constants.Typos.URL_ELEMENTS);
    }

    @Test
    public void typosTest(){
        //init elements
        initTypos();
        testTypos();
    }

    @AfterMethod
    public void exitTest(){
        utils.quitDriver(driver);
    }

    public void testTypos(){
        //get text
        String trStr = utils.getTextElementByElementByXpath(typosElement, Constants.Typos.XPATH_FOR_P);
        String message = "Actual = " + trStr + ", expected = " + Constants.Typos.ELEMENT_RIGTH_TEXT;
        //check result
        utils.checkResult(trStr, Constants.Typos.ELEMENT_RIGTH_TEXT, message);
    }

    public void initTypos(){
        typosElement = utils.getElementByXpath(driver, Constants.Typos.ID_ELEMENTS);
    }
}
