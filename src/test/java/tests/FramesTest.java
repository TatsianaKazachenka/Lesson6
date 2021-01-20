package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest{

    @Test
    public void checkIFrameTest() {
        framesPage.openPage();
        framesPage.clickOnIFrameLink();
        String text = framesPage.getIFrameText();
        Assert.assertEquals(text, "Your content goes here.");
    }
}
