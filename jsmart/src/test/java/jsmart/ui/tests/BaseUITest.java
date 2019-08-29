package jsmart.ui.tests;

import jsmart.SuiteConfiguration;
import jsmart.WebDriverEventHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseUITest extends SuiteConfiguration {

    protected EventFiringWebDriver driver;
    protected WebDriverEventListener webDriverEventListener= new WebDriverEventHandler();

    @BeforeClass(alwaysRun = true)
    public void UITestSetup() {
        WebDriver webDriver = browser.initialize();
        driver = new EventFiringWebDriver(webDriver).register(webDriverEventListener);
        driver.get(environment.getURL());
    }

    @AfterClass(alwaysRun = true)
    public void UITestTeardown() {
        if (driver != null) {
            ((EventFiringWebDriver) driver).unregister(webDriverEventListener);
            driver.quit();
        }
    }

}
