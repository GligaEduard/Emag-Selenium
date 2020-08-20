package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "email")
    private WebElement emailTextBox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(className = "gui-btn")
    private WebElement continueButton;

    @FindBy(className = "js-logout-btn")
    private WebElement logOutButton;

    @FindBy()
            private WebElement termAndConditions;

    LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void ensurePageDisplayed() {
        waitForVisibility(emailTextBox);
    }

    public LoginPage inputEmail(String email) {
        emailTextBox.sendKeys(email);
        return this;
    }

    public LoginPage inputPassword(String passw){
        passwordTextBox.sendKeys(passw);
        return this;
    }

    public LoginPage clickOnContinueButton(){
        continueButton.click();
        return this;
    }

    public LoginPage clickOnLogOutButton(){
        logOutButton.click();
        return this;
    }


}
