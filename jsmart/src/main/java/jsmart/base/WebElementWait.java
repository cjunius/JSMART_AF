package jsmart.base;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.awaitility.Awaitility.await;

public class WebElementWait {

    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private WebElement element;
    private Duration duration;

    private long timeout_in_seconds = 30; //seconds
    private long polling_in_ms = 500; //ms

    public WebElementWait(WebDriver driver) {
        this.driver = driver;
    }

    public WebElementWait forElement(WebElement element) {
        this.element = element;
        return this;
    }

    public WebElementWait upTo(Duration duration) {
        this.duration = duration;
        return this;
    }

    public void toExist() {
        await("Element " + element.toString() + " did not exist").atMost(duration).until(() -> element != null);
    }

    public void toNoLongerExist() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout_in_seconds, polling_in_ms);
        webDriverWait.ignoring(NoSuchElementException.class).until(ExpectedConditions.stalenessOf(element));
    }

    public void toAppear() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout_in_seconds, polling_in_ms);
        webDriverWait.ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(element));
    }

    public void toDisappear() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout_in_seconds, polling_in_ms);
        webDriverWait.ignoring(NoSuchElementException.class).until(ExpectedConditions.invisibilityOf(element));
    }



}
