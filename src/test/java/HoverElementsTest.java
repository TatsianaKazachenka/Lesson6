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

    @BeforeMethod
    public void initTest() {
        utils = new Utils();
        utils.setPropertyDriver();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //open site
        utils.openSite(driver, Constants.Hovers.URL_ELEMENTS);
    }

    @Test
    public void hoversTestProfil() {
        initHover();
        initList();
        testProfil();
    }

    @Test
    public void hoversTestCheck() {
        //init elements
        initHover();
        initList();
        testCheck();
    }

    public void testCheck() {
        Actions builder = new Actions(driver);
        List<WebElement> hrefElementsList = new ArrayList<WebElement>();
        int count = hoversElements.size();
        for (int i = 0; i < count; i++) {
            initHover();
            WebElement element = hoversElements.get(i);
            builder.moveToElement(element).perform();
            //get element by tag name
            WebElement href = utils.getElementByTagName(element, "a");
            hrefElementsList.add(href);
            utils.elementClick(href);

            String text404 = utils.getElementByTagName(driver, "h1").getText();
            String message = "Actual = " + text404 + ", expected = " + Constants.Hovers.NOT_FOUND_TEXT;
            //check result
            utils.checkResult(text404, Constants.Hovers.NOT_FOUND_TEXT, message);
            driver.navigate().back();
        }
    }

    public void testProfil() {
        //mouse movement and grip
        Actions builder = new Actions(driver);

        List<String> textElementsList = new ArrayList<String>();
        for (WebElement element : hoversElements) {
            builder.moveToElement(element).perform();
            //get element by tag name
            String textElement = utils.getTextElementByTagName(element, "h5");
            textElementsList.add(textElement);
            int count = textElementsList.size();
            String item = list.get(count-1);
            String message = "Actual = " + textElement + ", expected = " + item;
            //check result
            utils.checkResult(textElement, item, message);
        }
    }

    public void initHover() {
        WebElement hover = utils.getElementByXpath(driver, Constants.Hovers.ID_ELEMENTS);
        hoversElements = utils.getElementsByElementByClass(hover, Constants.Hovers.CLASSNAME_ELEMENTS);
    }

    public void initList() {
        list = new ArrayList<String>();
        list.add("name: user1");
        list.add("name: user2");
        list.add("name: user3");
    }

    @AfterMethod
    public void exitTest() {
        utils.quitDriver(driver);
    }
}
