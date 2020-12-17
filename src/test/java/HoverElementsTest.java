import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HoverElementsTest {
    WebDriver driver;
    Utils utils;
    List<WebElement> hoversElements;
    ArrayList<String> list;
    int countCheck = 0;
    int countProfil = 0;

    @BeforeMethod
    public void initTest(){
        utils = new Utils();
        utils.setPropertyDriver();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //open site
        utils.openSite(driver, Constants.Hovers.URL_ELEMENTS);
    }

    @Test(invocationCount = 3)
    public void hoversTestProfil(){
        //init elements
        initHover();
        initList();
        testProfil();
    }

    @Test(invocationCount = 3)
    public void hoversTestCheck(){
        //init elements
        initHover();
        initList();
        testCheck();
    }

    public void testCheck(){
        WebElement hoversElement = hoversElements.get(countCheck);

        //mouse movement and grip
        Actions builder = new Actions(driver);
        builder.moveToElement(hoversElement).perform();

        //get element by tag name
        WebElement href = utils.getElementByTagName(hoversElement, "a");
        //click by element
        utils.elementClick(href);

        String text404 = utils.getElementByTagName(driver, "h1").getText();
        String message = "Actual = " + text404 + ", expected = " + Constants.Hovers.NOT_FOUND_TEXT;
        //check result
        utils.checkResult(text404, Constants.Hovers.NOT_FOUND_TEXT, message);
        countCheck ++;
    }

    public void testProfil(){
        //mouse movement and grip
        Actions builder = new Actions(driver);
        WebElement hoversElement = hoversElements.get(countProfil);
        builder.moveToElement(hoversElement).perform();

        String item = list.get(countProfil);
        //get element by tag name
        String textElement =  utils.getTextElementByTagName(hoversElement, "h5");

        String message = "Actual = " + textElement + ", expected = " + item;
        //check result
        utils.checkResult(textElement, item, message);
        countProfil ++;
    }

    public void initHover(){
        WebElement hover = utils.getElementByXpath(driver, Constants.Hovers.ID_ELEMENTS);
        hoversElements = utils.getElementsByElementByClass(hover, Constants.Hovers.CLASSNAME_ELEMENTS);
    }

    public void initList(){
        list = new ArrayList<String>();
        list.add("name: user1");
        list.add("name: user2");
        list.add("name: user3");
    }

    @AfterMethod
    public void exitTest(){
        utils.quitDriver(driver);
    }
}
