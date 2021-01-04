package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTest extends BaseTest{

    @Test
    public void findCheckboxTest() {
        uploadPage.openPage();
        uploadPage.uploadFile();
        String name = uploadPage.getFileName();
        Assert.assertEquals(name, "TestUpload.txt");
    }
}
