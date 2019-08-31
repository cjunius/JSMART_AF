package jsmart.ui.tests;

import jsmart.SuiteConfiguration;
import jsmart.WebDriverEventHandler;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseUITest extends SuiteConfiguration {

    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void UITestSetup() {
        WebDriver webDriver = browser.initialize();
        driver = WebDriverEventHandler.register(webDriver);
    }

    @AfterClass(alwaysRun = true)
    public void UITestTeardown() {
        driver.quit();
    }

}
