import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddRemoveElementsTest {
    WebDriver driver;
    Utils utils;
    int countBtnRemovableEl = 2;

    @BeforeMethod
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
        clickCycle(countBtnRemovableEl);;
        //init elements
        List<WebElement> btnRemovableElements = initRemoveBtn();
        //check result
        String message = "Actual = " + String.valueOf(countBtnRemovableEl) + ", expected = " + String.valueOf(btnRemovableElements.size());
        utils.checkResult(String.valueOf(countBtnRemovableEl), String.valueOf(btnRemovableElements.size()), message);
    }

    @Test
    public void removeTest(){
        clickOnRemoveElementButton();
        //init elements
        List<WebElement> btnRemovableElements = initRemoveBtn();
        String message = "Actual = " + String.valueOf(countBtnRemovableEl - 1) + ", expected = " + String.valueOf(btnRemovableElements.size());
        //check result
        utils.checkResult(String.valueOf(countBtnRemovableEl - 1), String.valueOf(btnRemovableElements.size()), message);
    }

    @AfterMethod
    public void exitTest(){
        utils.quitDriver(driver);
    }

    public void clickOnAddElementButton(){
        //click by element
            utils.elementClick(initAddBtn());
    }

    public void clickCycle(int count){
        for(int i = 0; i < count; i++) {
            clickOnAddElementButton();
        }
    }

    public void clickOnRemoveElementButton(){
        clickCycle(countBtnRemovableEl);
        //init elements
        List<WebElement> btnRemovableElements = initRemoveBtn();
        //click by element
        utils.elementClick(btnRemovableElements.get(0));
    }

    public WebElement initAddBtn(){
        return utils.getElementByXpath(driver, Constants.AddRemove.ADD_ELEMENTS);
    }

    public List<WebElement> initRemoveBtn(){
        return utils.getElementsByClassName(driver, Constants.AddRemove.REMOVEBLE_ELEMENTS);
    }
}
