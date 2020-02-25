package jsmart.logging;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverEventHandler extends ExtentITestListenerClassAdapter implements WebDriverEventListener {

    public static WebDriver register(WebDriver webDriver) {
        WebDriverEventListener webDriverEventListener = new WebDriverEventHandler();
        return new EventFiringWebDriver(webDriver).register(webDriverEventListener);
    }

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Accepting Alert");
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Successfully accepted alert");
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Dismissing alert");
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Successfully dismissed alert");
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Navigating to " + s);
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Successfully navigated to " + s);
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Navigating back");
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Successfully navigated back");
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Navigating forward");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Successfully navigated forward");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Refreshing");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Successfully refreshed");
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Finding WebElement using locator " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Found WebElement using locator " + by);
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Clicking on WebElement " + webElement);
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Successfully clicked on WebElement " + webElement);
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        Logger log = getLogger();
        if (charSequences.length == 0) {
            log.info("Clearing the value in WebElement " + webElement);
        } else {
            String value = charSequenceArrayToString(charSequences);
            log.info("Changing value of WebElement " + webElement + " to " + value);
        }
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        Logger log = getLogger();
        if (charSequences.length == 0) {
            log.info("Successfully cleared the value in WebElement " + webElement);
        } else {
            String value = charSequenceArrayToString(charSequences);
            log.info("Successfully changed value of WebElement " + webElement + " to " + value);
        }
    }

    private String charSequenceArrayToString(CharSequence[] charSequences) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charSequences.length; i++) {
            sb.append(charSequences[i]);
        }
        return sb.toString();
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Executing script " + s);
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Successfully executed script " + s);
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Switching to window " + s);
    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Successfully switched to window " + s);
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        Logger log = getLogger();
        log.error("THROWABLE: ", throwable);
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        Logger log = getLogger();
        log.info("Attempting to capture a screenshot");
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        Logger log = getLogger();
        log.info("Successfully captured a screenshot");
    }


    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        Logger log = getLogger();
        log.info("Getting text from element " + element);
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        Logger log = getLogger();
        log.info("Successfully retrieved text " + text + " from element " + element);
    }

    private Logger getLogger() {
        return LoggerFactory.getLogger(getCallingClass());
    }

    private String getCallingClass() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        
        for (int i = stackTraceElements.length - 2; i >= 0; i--) {
            if (stackTraceElements[i].getClassName().contains("jsmart.ui.pages")) {
                return stackTraceElements[i].getClassName();
            }
        }

        for (int i = stackTraceElements.length - 2; i >= 0; i--) {
            if (stackTraceElements[i].getClassName().contains("jsmart.ui.tests")) {
                return stackTraceElements[i].getClassName();
            }
        }

        return "";
    }

}
