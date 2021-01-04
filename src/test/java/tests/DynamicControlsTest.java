package tests;

import org.testng.annotations.Test;
import org.testng.Assert;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void findCheckboxTest() {
        dynamicControlsPage.openPage();
        boolean isCheckbox = dynamicControlsPage.isFindCheckbox();
        Assert.assertTrue(isCheckbox);
    }

    @Test
    public void checkMessageTest() {
        dynamicControlsPage.openPage();
        dynamicControlsPage.clockRemoveAddBtn();
        dynamicControlsPage.waitShowElement();
        String message = dynamicControlsPage.getMessage();
        Assert.assertEquals(message, "It's gone!");
    }

    @Test
    public void isCheckboxExistsTest() {
        dynamicControlsPage.openPage();
        dynamicControlsPage.clockRemoveAddBtn();
        dynamicControlsPage.waitShowElement();
        boolean isCheckbox = dynamicControlsPage.isFindCheckbox();
        Assert.assertFalse(isCheckbox);
    }
}
