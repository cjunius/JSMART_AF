package jsmart.waits;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.awaitility.Awaitility.await;

public class WebElementWait {

    private WebDriver driver;
    private WebElement element;
    private Duration timeout = Duration.ofSeconds(30);
    private Duration polling = Duration.ofMillis(500);

    public WebElementWait(WebDriver driver) {
        this.driver = driver;
    }

    public WebElementWait forElement(WebElement element) {
        this.element = element;
        return this;
    }

    public WebElementWait atMost(Duration duration) {
        this.timeout = duration;
        return this;
    }

    public WebElementWait usingFrequency(Duration duration) {
        this.polling = duration;
        return this;
    }

    public void toExist() {
        await("Element " + element.toString() + " did not exist").atMost(timeout).until(() -> element != null);
    }

    public void toNoLongerExist() {
        getWebDriverWait().ignoring(NoSuchElementException.class).until(ExpectedConditions.stalenessOf(element));
    }

    public void toAppear() {
        getWebDriverWait().ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(element));
    }

    public void toDisappear() {
        getWebDriverWait().ignoring(NoSuchElementException.class).until(ExpectedConditions.invisibilityOf(element));
    }

    private WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, timeout.getSeconds(), polling.toMillis());
    }

}
