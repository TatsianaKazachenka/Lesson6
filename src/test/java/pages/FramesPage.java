package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.constants.BasePageConstants;
import pages.constants.FramesPageConstants;

public class FramesPage extends BasePage{
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public static final By HREF_IFRAME = By.xpath("//*[@id='content']//a[contains(@href,'iframe')]");
    public static final By IFRAME_TEXT = By.xpath("//*[@id='tinymce']/p");

    public void openPage() {
        String url = BasePageConstants.BASE_URL + FramesPageConstants.URL;
        driver.get(url);
    }

    public void clockIFrame() {
        driver.findElement(HREF_IFRAME).click();
    }

    public String getTextIFrame() {
        driver.switchTo().frame("mce_0_ifr");
        WebElement element = driver.findElement(IFRAME_TEXT);
        return element.getText();
    }
}
