package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static pages.constants.BasePageConstants.BASE_URL;
import static pages.constants.ContextMenuPageConstants.URL;

public class ContextMenuPage extends BasePage {
    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public static final By ELEMENT_FOR_CONTEXT_MENU = By.xpath("//*[@id='hot-spot']");

    public void openPage() {
        driver.get(BASE_URL + URL);
    }

    public void clickElementContextMenu() {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(ELEMENT_FOR_CONTEXT_MENU);
        actions.contextClick(element).perform();
    }

    public Alert getAlert(){
        return driver.switchTo().alert();
    }

    public String getTextForAlert(Alert alert) {
        return alert.getText();
    }

    public void closeAlert(Alert alert) {
        alert.accept();
    }
}
