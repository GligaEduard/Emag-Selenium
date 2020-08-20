package chrome.test;

import config.WebDriverBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.HomePage;

public abstract class AbstractTest {

    public ChromeDriver driver;
    public HomePage homePage;
    public FirefoxDriver firefoxDriver;
    private String browserType;

    @BeforeMethod(alwaysRun = true)
    public void connect() {
        this.browserType = getBrowserType();

        if (browserType.equals("Chrome")) {
            this.driver = WebDriverBuilder.forChrome().build();
            homePage = new HomePage(this.driver);
        } else if (browserType.equals("Firefox")) {
            this.firefoxDriver = WebDriverBuilder.forFirefox().build();
            homePage = new HomePage(firefoxDriver);
        } else try {
            throw new Exception("Browser type not supported");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebDriver getAnotherDriver(String browserType) {
        WebDriver driver = null;

        if (browserType.equals("Chrome")) {
            driver= WebDriverBuilder.forChrome().build();
        } else if (browserType.equals("Firefox")) {
            driver= WebDriverBuilder.forFirefox().build();
        } else try {
            throw new Exception("Browser type not supported");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;

    }
    public void killDriver(WebDriver driver){
        driver.quit();
    }

    @AfterMethod(alwaysRun = true)
    public void kill() {
        this.browserType = getBrowserType();

        if (browserType.equals("Chrome")) {
            driver.quit();
        } else if (browserType.equals("Firefox")) {
            firefoxDriver.quit();
        } else try {
            throw new Exception("Browser type not supported");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public abstract String getBrowserType();




   }

