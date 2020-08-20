package pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public abstract class AbstractPage {
    protected WebDriver driver;
    AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }

    private WebDriver getDriver() {
        return this.driver;
    }

    private FluentWait<WebDriver> fluentWait() {
        return new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15)).ignoring(NoSuchElementException.class);
    }

    public abstract void ensurePageDisplayed();

    protected WebElement waitForVisibility(final WebElement webElement) {
        fluentWait().until(visibilityOf(webElement));
        return webElement;
    }

}