package tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    @Test
    public void checkСontextMenuMessageTest() {
        contextMenuPage.openPage();
        contextMenuPage.clickElementContextMenu();
        Alert alert =  contextMenuPage.getAlert();
        String messageAlert = contextMenuPage.getTextForAlert(alert);
        Assert.assertEquals(messageAlert, "You selected a context menu");
        contextMenuPage.closeAlert(alert);
    }
}
