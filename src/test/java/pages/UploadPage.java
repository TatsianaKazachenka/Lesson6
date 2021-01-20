package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import static pages.constants.BasePageConstants.BASE_URL;
import static pages.constants.UploadPageConstants.URL;

public class UploadPage extends BasePage {
    public UploadPage(WebDriver driver) {
        super(driver);
    }

    public static final By UPLOAD_FILE_INPUT = By.xpath("//*[@id='file-upload']");
    public static final By UPLOAD_FILE_SUBMIT = By.xpath("//*[@id='file-submit']");
    public static final By UPLOADED_DIV = By.xpath("//*[@id='uploaded-files']");

    public void openPage() {
        driver.get(BASE_URL + URL);
    }

    public void uploadFile(String fileName) {
        WebElement upload = driver.findElement(UPLOAD_FILE_INPUT);
        URL pathURL = getClass().getClassLoader().getResource(fileName);
        String path = null;
        try {
            path = Paths.get(pathURL.toURI()).toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        upload.sendKeys(path);
        driver.findElement(UPLOAD_FILE_SUBMIT).click();
    }

    public String getFileName() {
        return driver.findElement(UPLOADED_DIV).getText();
    }
}
