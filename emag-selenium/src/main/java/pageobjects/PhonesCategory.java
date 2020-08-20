package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

public class PhonesCategory extends AbstractPage {

    @FindBy(className = "emg-fashion-grid-banner-widget-slot-wrapper")
    WebElement appleButton;

    @FindBy(className = "widget-column-type-banner_2_2")
    WebElement huaweiButton;

    @FindBy(className = "widget-column-type-banner_2_3")
            WebElement samsungSmartwatchButton;

    @FindBy(className = "btn-emag")
            WebElement addToCart;

    PhonesCategory(WebDriver driver) {
        super(driver);
    }

    @Override
    public void ensurePageDisplayed() {

    }

    public PhonesCategory openAppleCategory(){
        appleButton.click();
        return this;
    }

    public PhonesCategory openHuaweiCategory(){
        huaweiButton.click();
        return this;
    }

    public PhonesCategory openSamsungSmartwatchCategory(){
        samsungSmartwatchButton.click();
        return this;
    }

    public PhonesCategory addToCart(){
      //  addToCart.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.className("btn-emag")));
        return this;
    }


}
