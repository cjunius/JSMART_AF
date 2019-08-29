package jsmart.ui.tests;

import jsmart.SuiteConfiguration;
import jsmart.WebDriverEventHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseUITest extends SuiteConfiguration {

    protected WebDriver webDriver;
    protected EventFiringWebDriver driver;
    protected WebDriverEventListener webDriverEventListener;

    @BeforeClass(alwaysRun = true)
    public void UITestSetup() {
        webDriver = BROWSER.initialize();
        driver = new EventFiringWebDriver(webDriver);
        webDriverEventListener = new WebDriverEventHandler();
        driver.register(webDriverEventListener);
    }

    @AfterClass(alwaysRun = true)
    public void UITestTeardown() {
        if (driver != null) {
            driver.quit();
            driver.unregister(webDriverEventListener);
        }
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}
