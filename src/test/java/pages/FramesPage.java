package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static pages.constants.BasePageConstants.BASE_URL;
import static pages.constants.FramesPageConstants.URL;

public class FramesPage extends BasePage{
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public static final By HREF_IFRAME = By.xpath("//*[@id='content']//a[contains(@href,'iframe')]");
    public static final By IFRAME_TEXT = By.xpath("//*[@id='tinymce']/p");

    public void openPage() {
        driver.get(BASE_URL + URL);
    }

    public void clickOnIFrameLink() {
        driver.findElement(HREF_IFRAME).click();
    }

    public String getIFrameText() {
        driver.switchTo().frame("mce_0_ifr");
        WebElement element = driver.findElement(IFRAME_TEXT);
        return element.getText();
    }
}
