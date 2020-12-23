import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class NotificationMessageTest {
    WebDriver driver;
    Utils utils;
    WebElement href;
    ArrayList<String> list;
    int count = 0;

    @BeforeTest
    public void initTest(){
        utils = new Utils();
        utils.setPropertyDriver();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //open site
        utils.openSite(driver, Constants.NotificationMessage.URL_ELEMENTS);
        initList();
    }

    @Test(invocationCount = 2)
    public void messageTest(){
        //init elements
        initNotificationMessage();
        testNotificationMessage();
    }

    @AfterTest
    public void exitTest(){
        utils.quitDriver(driver);
    }

    public void testNotificationMessage(){
        //click by element
        utils.elementClick(href);
        //init wait
        WebDriverWait wait = new WebDriverWait(driver, 30);
        //found element
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.NotificationMessage.MESSAGE_ELEMENT)));
        //get text
        String strElement = element.getText().replaceAll("\n×", "");
        String item = list.get(count);

        String message = "Actual = " + strElement + ", expected = " + item;
        //chack result
        utils.checkResult(strElement.trim(), item.trim(), message);
        count ++;
    }

    public void initNotificationMessage(){
        href = utils.getElementByXpath(driver, Constants.NotificationMessage.HREF_ELEMENT);
    }

    public void initList(){
        list = new ArrayList<String>();
        list.add("Action unsuccesful, please try again");
        list.add("Action successful");
    }
}
