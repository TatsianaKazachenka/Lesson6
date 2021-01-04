package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.constants.BasePageConstants;
import pages.constants.DynamicControlsConstants;

public class DynamicControlsPage extends BasePage {
    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public static final By REMOVE_ADD_CHECKBOX = By.xpath("//*[@id='checkbox']/input[@type='checkbox']");
    public static final By REMOVE_ADD_BUTTON = By.xpath("//*[@id='checkbox-example']/button[@type='button']");
    public static final By REMOVE_ADD_MESSAGE = By.xpath("//*[@id='message']");

    public void openPage() {
        String url = BasePageConstants.BASE_URL + DynamicControlsConstants.URL;
        driver.get(url);
    }

    public boolean isFindCheckbox() {
        try {
            WebElement element = driver.findElement(REMOVE_ADD_CHECKBOX);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clockRemoveAddBtn() {
        driver.findElement(REMOVE_ADD_BUTTON).click();
    }

    public void waitShowElement() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(REMOVE_ADD_MESSAGE));
    }

    public String getMessage() {
        WebElement element = driver.findElement(REMOVE_ADD_MESSAGE);
        return element.getText();
    }
}
