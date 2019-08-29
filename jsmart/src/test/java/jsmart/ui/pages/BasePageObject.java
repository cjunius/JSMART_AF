package jsmart.ui.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

abstract public class BasePageObject {

    private EventFiringWebDriver driver;

    public BasePageObject(EventFiringWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
