package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTest extends BaseTest{

    @Test
    public void findCheckboxTest() {
        String fileName = "TestUpload.txt";
        uploadPage.openPage();
        uploadPage.uploadFile(fileName);
        String name = uploadPage.getFileName();
        Assert.assertEquals(name, fileName);
    }
}
