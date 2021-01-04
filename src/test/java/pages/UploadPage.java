package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.constants.BasePageConstants;
import pages.constants.UploadPageConstants;

public class UploadPage extends BasePage {
    public UploadPage(WebDriver driver) {
        super(driver);
    }

    public static final By UPLOAD_FILE_INPUT = By.xpath("//*[@id='file-upload']");
    public static final By UPLOAD_FILE_SUBMIT = By.xpath("//*[@id='file-submit']");
    public static final By UPLOADED_DIV = By.xpath("//*[@id='uploaded-files']");

    public void openPage() {
        String url = BasePageConstants.BASE_URL + UploadPageConstants.URL;
        driver.get(url);
    }

    public void uploadFile(){
        WebElement upload = driver.findElement(UPLOAD_FILE_INPUT);
        upload.sendKeys("\\src\\test\\resources\\TestUpload.txt");
        driver.findElement(UPLOAD_FILE_SUBMIT).click();
    }

    public String getFileName(){
        return driver.findElement(UPLOADED_DIV).getText();
    }
}
