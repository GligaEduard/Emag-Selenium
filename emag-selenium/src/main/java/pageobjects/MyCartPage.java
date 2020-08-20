package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
public class MyCartPage extends AbstractPage {
    @FindBy(className = "empty-cart-primary-btn")
    WebElement goBackToShopButton;




    MyCartPage(WebDriver driver) {
        super(driver);
    }



    @Override
    public void ensurePageDisplayed() {
    }

    public MyCartPage backToShop(){
        goBackToShopButton.click();
        return this;
    }
}
