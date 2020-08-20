package chrome.test.smoke;

import chrome.test.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends AbstractTest {

    @Test
    public void titleExist() {
        String title = homePage.getTitle();
        Assert.assertEquals(title, "eMAG.ro - Libertate în fiecare zi");
    }


    @Test
    public void userCanAccessMyAccountAndInputHisEmail() {
        homePage.goToLogin().inputEmail("BogaSefuOTOMEISHAN");
    }


    @Override
    public String getBrowserType() {
        return "Chrome" ;
    }
}
