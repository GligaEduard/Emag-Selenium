package regression;

import chrome.test.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;

public class RegresionTesting extends AbstractTest {


    // REGISTER
    @Test
    public void userCanClickRegisterButton(){
        homePage.openRegisterPage();
    }
    @Test
    public void userCanInputRegistrationEmail(){
        homePage.openRegisterPage().inputRegistrationEmail("petigliga@gmail.com");
    }
    @Test
    public void userCanPressContinueButton(){
        homePage.openRegisterPage().inputRegistrationEmail("petigliga@gmail.com").clickContinue();
    }
    @Test
    public void userCanFillEveryFieldFromRegistrationPage() {
        homePage.openRegisterPage()
                .inputRegistrationEmail("peewrtigliga@gmail.com")
                .clickContinue()
                .inputFirstAndLastName("Gliga Peter Eduard")
                .inputPassword("Parolamea123")
                .inputPasswordConfirmation("Parolamea123");
    }
    @Test
    public void userCanCreateANewAccount(){
        homePage.openRegisterPage()
                .inputRegistrationEmail("pedsdfsdsftip@gmail.com")
                .clickContinue()
                .inputFirstAndLastName("Gliga Peter Eduard")
                .inputPassword("Parolamea123")
                .inputPasswordConfirmation("Parolamea123")
                .confirmTermAndConditions()
                .clickContinue();
    }

// LOGIN


    @Test
    public void userCanClickGoToRegisterButton(){
        homePage.goToLogin();
    }

    @Test
    public void userCanInputLoginEmail(){
        homePage.goToLogin().inputEmail("petigliga@gmail.com");
    }

    @Test
    public void userCanClickContinueButton(){
        homePage.goToLogin().inputEmail("petigliga@gmail.com").clickOnContinueButton();
    }


    @Test
    public void userCanSuccessfullyLogin(){
        homePage.goToLogin()
                .inputEmail("petigliga@gmail.com")
                .clickOnContinueButton()
                .inputPassword("Parolamea123")
                .clickOnContinueButton();


    }
    @Test
    public void userCanNotLogInWithWronngPassword(){
        homePage.goToLogin()
                .inputEmail("petigliga@gmail.com")
                .clickOnContinueButton()
                .inputPassword("ParolaGresita")
                .clickOnContinueButton();

    }

    //TEST A PRODUCT

    @Test
    public void phonesCategory(){
        homePage.openPhonesCategory();
    }

    @Test
    public void appleCategory(){
        homePage.openPhonesCategory().openAppleCategory();
    }

    @Test
    public void huaweiCategory(){
        homePage.openPhonesCategory().openHuaweiCategory();
    }

    @Test
    public void samungSmartwatchCategory(){
        homePage.openPhonesCategory().openSamsungSmartwatchCategory();
    }

    @Test

    public void addToCartHuaweiProduct(){
        homePage.openPhonesCategory().openHuaweiCategory().addToCart();
       WebDriver drivereanu = getAnotherDriver("Firefox");
        HomePage homepageSecondDriver = new HomePage(drivereanu);
        homepageSecondDriver.openMyCart();
        killDriver(drivereanu);
        WebDriver drivreada = getAnotherDriver("Firefox");
        HomePage homePageThirdDriver = new HomePage(drivreada);
        homePageThirdDriver.goToLogin();
        killDriver(drivreada);
    }

    //MY CART

    @Test

    public void openMyCartPage(){ homePage.openMyCart();}

    @Test

    public void backToShopButton(){ homePage.openMyCart().backToShop();}

    @Override
    public String getBrowserType() {
        return "Firefox";
    }
}
