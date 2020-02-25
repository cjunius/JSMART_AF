package jsmart.base;

import jsmart.Browsers;
import jsmart.Environments;
import jsmart.WebElementWait;
import jsmart.logging.WebDriverEventHandler;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseUITest {

    protected Environments environment;
    protected Browsers browser;

    protected WebDriver driver;
    protected Actions actions;
    protected JavascriptExecutor executor;
    protected WebElementWait wait;

    @BeforeClass(alwaysRun = true)
    public void UITestSetup() {
        environment = Environments.valueOf(System.getProperty("jsmart.env", "PROD"));
        browser = Browsers.valueOf(System.getProperty("jsmart.browser", "CHROME"));

        //Disabled most selenium messages
        Logger.getLogger("org.openqa.selenium").setLevel(Level.WARNING);

        WebDriver webDriver = browser.initialize();
        driver = WebDriverEventHandler.register(webDriver);
        actions = new Actions(driver);
        executor = (JavascriptExecutor) driver;
        wait = new WebElementWait(driver);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
                ImageIO.write(screenshot.getImage(), "png", new File(".//screenshots//" + result.getMethod().getMethodName() + System.currentTimeMillis() + ".png"));
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }

    }

    @AfterClass(alwaysRun = true)
    public void UITestTeardown() {
        if(driver != null) {
            driver.close();
            driver.quit();
        }
    }

}
