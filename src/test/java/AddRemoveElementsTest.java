import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddRemoveElementsTest {
    WebDriver driver;
    Utils utils;
    int countBtnRemovableEl = 2;
    List<WebElement> btnRemovableElements;

    @BeforeTest
    public void initTest(){
        utils = new Utils();
        utils.setPropertyDriver();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //open site
        utils.openSite(driver, Constants.AddRemove.URL_ELEMENTS);
    }

    @Test
    public void addTest(){
        //init elements
        WebElement btnAddElements = utils.getElementByXpath(driver, Constants.AddRemove.ADD_ELEMENTS);
        //click by element
        for(int i = 0; i < countBtnRemovableEl; i++) {
            utils.elementClick(btnAddElements);
        }
        //init elements
        btnRemovableElements = utils.getElementsByClassName(driver, Constants.AddRemove.REMOVEBLE_ELEMENTS);
        //check result
        String message = "Actual = " + String.valueOf(countBtnRemovableEl) + ", expected = " + String.valueOf(btnRemovableElements.size());
        utils.checkResult(String.valueOf(countBtnRemovableEl), String.valueOf(btnRemovableElements.size()), message);
    }

    @Test
    public void removeTest(){
        //click by element
        utils.elementClick(btnRemovableElements.get(0));
        //init elements
        btnRemovableElements = utils.getElementsByClassName(driver, Constants.AddRemove.REMOVEBLE_ELEMENTS);
        String message = "Actual = " + String.valueOf(countBtnRemovableEl - 1) + ", expected = " + String.valueOf(btnRemovableElements.size());
        //check result
        utils.checkResult(String.valueOf(countBtnRemovableEl - 1), String.valueOf(btnRemovableElements.size()), message);
    }

    @AfterTest
    public void exitTest(){
        utils.quitDriver(driver);
    }
}
