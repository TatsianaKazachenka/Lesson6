import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckboxElementsTest {
    WebDriver driver;
    Utils utils;
    List<WebElement> checkboxElements;

    @BeforeMethod
    public void initTest(){
        utils = new Utils();
        utils.setPropertyDriver();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //open site
        utils.openSite(driver, Constants.Checkboxes.URL_ELEMENTS);
    }

    @Test
    public void uncheckedFirstTest(){
        //init elements
        initCheckboxElements();
        isCheckboxCheckedTest(checkboxElements.get(0), false, false);
    }

    @Test
    public void checkedFirstTest(){
        //init elements
        initCheckboxElements();
        isCheckboxCheckedTest(checkboxElements.get(0), true, true);
    }

    @Test
    public void checkedSecondTest(){
        //init elements
        initCheckboxElements();
        isCheckboxCheckedTest(checkboxElements.get(1), true, false);
    }

    @Test
    public void uncheckedSecondTest(){
        //init elements
        initCheckboxElements();
        isCheckboxCheckedTest(checkboxElements.get(1), false, true);
    }

    @AfterMethod
    public void exitTest(){
        utils.quitDriver(driver);
    }

    public void isCheckboxCheckedTest(WebElement checkbox, boolean isSelected, boolean isClick){
        if(isClick){
            //click by element
            utils.elementClick(checkbox);
        }
        //check elements
        boolean isChecked = isCheckboxChecked(checkbox);
        String message = "Actual = " + String.valueOf(isChecked) + ", expected = " + String.valueOf(isSelected);
        //check result
        utils.checkResult(String.valueOf(isChecked), String.valueOf(isSelected), message);
    }

    public boolean isCheckboxChecked(WebElement checkbox){
        return checkbox.isSelected();
    }

    public void initCheckboxElements(){
        checkboxElements = utils.getElementsByXpath(driver, Constants.Checkboxes.TYPENAME_ELEMENTS);
    }
}
