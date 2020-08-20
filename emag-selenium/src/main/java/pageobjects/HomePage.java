package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(id = "my_account")
    private WebElement myAccountButton;

    @FindBy(className = "megamenu-list-department__department-name")
    private WebElement phonesCategoryButton;

    @FindBy(id = "my_account")
    private WebElement registerPageButton;

    @FindBy(id = "my_cart")
    private WebElement myCartPage;

    public HomePage(WebDriver driver) {
        super(driver);
    }



    @Override
    public void ensurePageDisplayed() {

    }

    public String getTitle() {
        return driver.getTitle();
    }

    public LoginPage goToLogin() {
        myAccountButton.click();
        return new LoginPage(driver);
    }

    public PhonesCategory openPhonesCategory(){
        phonesCategoryButton.click();
        return new  PhonesCategory(driver);
    }

    public RegisterPage openRegisterPage(){
        registerPageButton.click();
        return new RegisterPage(driver);
    }

    public MyCartPage openMyCart(){
        myCartPage.click();
        return new MyCartPage(driver);
    }
}
