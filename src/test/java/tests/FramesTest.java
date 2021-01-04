package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest{

    @Test
    public void checkIFrameTest() {
        framesPage.openPage();
        framesPage.clockIFrame();
        String text = framesPage.getTextIFrame();
        Assert.assertEquals(text, "Your content goes here.");
    }
}
