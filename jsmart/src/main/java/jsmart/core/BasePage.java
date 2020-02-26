package jsmart.core;

import jsmart.utils.PropertiesReader;
import jsmart.waits.WebElementWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

abstract public class BasePage {

    protected Environments environment;
    protected WebDriver driver;
    protected WebElementWait wait;
    protected Properties properties;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebElementWait(driver);

        environment = Environments.valueOf(System.getProperty("jsmart.env", "PROD"));
        properties = PropertiesReader.forEnvironment(environment);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    abstract public BasePage waitForPageToLoad();

}
