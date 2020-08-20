package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.util.concurrent.TimeUnit;

/**
 * The type Appium driver builder.
 */
public abstract class WebDriverBuilder {

    /**
     * For chrome web driver builder.
     *
     * @return the chrome driver builder
     */

    public static ChromeDriverBuilder forChrome() {
        return new ChromeDriverBuilder();
    }

    /**
     * For firefox web driver builder
     *
     * @return the firefox driver builder
     */

    public static FirefoxDriverBuidler forFirefox(){return new FirefoxDriverBuidler();}
    /**
     * WebDriver Builder that uses chrome as browser.
     */
    public static class ChromeDriverBuilder extends WebDriverBuilder {
        ChromeDriver chromeDriver;
        public ChromeDriver build() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            instantiateDriver(chromeOptions);
            chromeDriver.get("https://www.emag.ro");
            return chromeDriver;
        }

        private void instantiateDriver(ChromeOptions chromeOptions) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            chromeDriver = new ChromeDriver(chromeOptions);
            chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
    }

    /**
     * WebDriver Builder that uses firefox as browser.
     */
    public static class FirefoxDriverBuidler extends WebDriverBuilder{
        FirefoxDriver firefoxDriver;
        public FirefoxDriver build(){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("start-maximized");
            instatiateDriver(firefoxOptions);
            firefoxDriver.get("https://www.emag.ro");
            return firefoxDriver;
        }

        private void instatiateDriver(FirefoxOptions firefoxOptions) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
            firefoxDriver = new FirefoxDriver(firefoxOptions);
            firefoxDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);




        }
    }

}
