package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.constants.BasePageConstants;
import pages.constants.ContextMenuPageConstants;

public class ContextMenuPage extends BasePage {
    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public static final By ELEMENT_FOR_CONTEXT_MENU = By.xpath("//*[@id='hot-spot']");

    public void openPage() {
        String url = BasePageConstants.BASE_URL + ContextMenuPageConstants.URL;
        driver.get(url);
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
        String textAlert = alert.getText();
        return textAlert;
    }

    public void closeAlert(Alert alert) {
        alert.accept();
    }
}
