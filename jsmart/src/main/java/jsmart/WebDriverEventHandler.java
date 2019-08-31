package jsmart;

import com.aventstack.extentreports.service.ExtentTestManager;

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
        ExtentTestManager.getTest().info("Accepting Alert");
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Successfully accepted alert");
        ExtentTestManager.getTest().pass("Successfully accepted alert");
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Dismissing alert");
        ExtentTestManager.getTest().info("Dismissing Alert");
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Successfully dismissed alert");
        ExtentTestManager.getTest().pass("Successfully dismissed alert");
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Navigating to " + s);
        ExtentTestManager.getTest().info("Navigating to " + s);
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Successfully navigated to " + s);
        ExtentTestManager.getTest().pass("Successfully navigated to " + s);
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Navigating back");
        ExtentTestManager.getTest().info("Navigating back");
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Successfully navigated back");
        ExtentTestManager.getTest().pass("Successfully navigated back");
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Navigating forward");
        ExtentTestManager.getTest().info("Navigating forward");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Successfully navigated forward");
        ExtentTestManager.getTest().pass("Successfully navigated forward");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Refreshing");
        ExtentTestManager.getTest().info("Refreshing");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Successfully refreshed");
        ExtentTestManager.getTest().pass("Successfully refreshed");
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Finding WebElement using locator " + by);
        ExtentTestManager.getTest().info("Finding WebElement using locator " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Found WebElement using locator " + by);
        ExtentTestManager.getTest().pass("Found WebElement using locator " + by);
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Clicking on WebElement " + webElement);
        ExtentTestManager.getTest().info("Clicking on WebElement " + webElement);
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Successfully clicked on WebElement " + webElement);
        ExtentTestManager.getTest().pass("Successfully clicked on WebElement " + webElement);
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        Logger log = getLogger();
        if (charSequences.length == 0) {
            log.info("Clearing the value in WebElement " + webElement);
            ExtentTestManager.getTest().info("Clearing the value in WebElement " + webElement);
        } else {
            String value = charSequenceArrayToString(charSequences);
            log.info("Changing value of WebElement " + webElement + " to " + value);
            ExtentTestManager.getTest().info("Changing value of WebElement " + webElement + " to " + value);
        }
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        Logger log = getLogger();
        if (charSequences.length == 0) {
            log.info("Successfully cleared the value in WebElement " + webElement);
            ExtentTestManager.getTest().pass("Successfully cleared the value in WebElement " + webElement);
        } else {
            String value = charSequenceArrayToString(charSequences);
            log.info("Successfully changed value of WebElement " + webElement + " to " + value);
            ExtentTestManager.getTest().pass("Successfully changed value of WebElement " + webElement + " to " + value);
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
        ExtentTestManager.getTest().info("Executing script " + s);
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Successfully executed script " + s);
        ExtentTestManager.getTest().pass("Successfully executed script " + s);
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Switching to window " + s);
        ExtentTestManager.getTest().info("Switching to window " + s);
    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        Logger log = getLogger();
        log.info("Successfully switched to window " + s);
        ExtentTestManager.getTest().pass("Successfully switched to window " + s);
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        Logger log = getLogger();
        log.error("THROWABLE: ", throwable);
        ExtentTestManager.getTest().fail(throwable);
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        Logger log = getLogger();
        log.info("Attempting to capture a screenshot");
        ExtentTestManager.getTest().info("Attempting to capture a screenshot");
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        Logger log = getLogger();
        log.info("Successfully captured a screenshot");
        if(screenshot instanceof String) {
            ExtentTestManager.getTest().addScreenCaptureFromBase64String((String) screenshot, "Screenshot");
        }
    }


    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        Logger log = getLogger();
        log.info("Getting text from element " + element);
        ExtentTestManager.getTest().info("Getting text from element " + element);
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        Logger log = getLogger();
        log.info("Successfully retrieved text " + text + " from element " + element);
        ExtentTestManager.getTest().pass("Successfully retrieved text " + text + " from element " + element);
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
