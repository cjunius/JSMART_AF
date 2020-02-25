package jsmart.base;

import jsmart.WebElementWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class BasePage {

    private static final int TIMEOUT = 5; // in Seconds
    private static final int POLLING = 100; // in Milliseconds

    protected WebDriver driver;
    protected WebElementWait wait;

    public BasePage(WebDriver driver) {
        this(driver, Duration.ofSeconds(TIMEOUT));
    }

    public BasePage(WebDriver driver, Duration timeout) {
        this(driver, timeout, Duration.ofMillis(POLLING));
    }

    public BasePage(WebDriver driver, Duration timeout, Duration polling) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebElementWait(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    abstract public BasePage waitForPageToLoad();

}
