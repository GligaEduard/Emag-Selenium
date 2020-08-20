package pageobjects;

import config.WebDriverBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
public class RegisterPage extends AbstractPage {

    @FindBy(id = "email")
    WebElement registrationEmail;

    @FindBy(className = "gui-btn")
    private WebElement continueButton;

    @FindBy(id = "r_name")
    private WebElement firstAndLastName;

    @FindBy(id = "r_password")
    private WebElement password;

    @FindBy(id = "r_password_confirmation")
    private WebElement confirmPassword;

    @FindBy(id = "agree_terms")
    private WebElement termAndConditions;






    RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void ensurePageDisplayed() {

    }

    public RegisterPage inputRegistrationEmail(String email){
        registrationEmail.sendKeys(email);
       return this;

    }

    public RegisterPage clickContinue(){
        continueButton.click();
        return this;
    }

    public RegisterPage inputFirstAndLastName(String name){
        firstAndLastName.sendKeys(name);
        return this;
    }

    public RegisterPage inputPassword(String pass){
        password.sendKeys(pass);
        return this;
    }

    public RegisterPage inputPasswordConfirmation(String passwordConfirmation){
        confirmPassword.sendKeys(passwordConfirmation);
        return this;
    }

    public RegisterPage confirmTermAndConditions(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.id("agree_terms")));
//
//        Point point = termAndConditions.getLocation();
//        int height = termAndConditions.getSize().getHeight();
//        int width = termAndConditions.getSize().getWidth();
//        int xpoint = point.getX();
//        int ypoint = point.getY();
//        new Actions(driver).moveByOffset(xpoint+width/2, ypoint+height/2).click().build().perform();
//        System.out.println("Heigth is: " +height );
//        System.out.println("Width is:" +width);
        return this;
    }



}
