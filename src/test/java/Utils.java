import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Utils {
    public void setPropertyDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    public void openSite(WebDriver driver, String site){
        driver.get(site);
    }

    public String getTextElementByElementByXpath(WebElement mainElement, String element){
        return mainElement.findElement(By.xpath(element)).getText();
    }

    public WebElement getElementByXpath(WebDriver driver, String element){
        return driver.findElement(By.xpath(element));
    }

    public List<WebElement> getElementsByXpath(WebDriver driver, String element){
        return driver.findElements(By.xpath(element));
    }

    public List<WebElement> getElementsByElementByClass(WebElement element, String elements){
        return element.findElements(By.className(elements));
    }

    public List<WebElement> getElementsByClassName(WebDriver driver, String className){
        return driver.findElements(By.className(className));
    }

    public String getTextElementByTagName(WebElement element, String tagName){
        return element.findElement(By.tagName(tagName)).getText();
    }

    public List<WebElement> getElementsByTagName(WebDriver driver, String tagName){
        return driver.findElements(By.tagName(tagName));
    }

    public WebElement getElementByTagName(WebElement element, String tagName){
        return element.findElement(By.tagName(tagName));
    }

    public WebElement getElementByTagName(WebDriver driver, String tagName){
        return driver.findElement(By.tagName(tagName));
    }

    public void clickByElementName(WebDriver driver, String name){
        driver.findElement(By.name(name)).click();
    }

    public void checkResult(String actualCategoryText, String expectedCategoryText, String message){
        Assert.assertEquals(actualCategoryText, expectedCategoryText, message);
    }

    public void closeDriver(WebDriver driver){
        driver.close();
    }

    public void quitDriver(WebDriver driver){
        driver.quit();
    }

    public void elementClick(WebElement element){
        element.click();
    }
}
