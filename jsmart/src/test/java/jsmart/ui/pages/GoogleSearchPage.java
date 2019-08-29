package jsmart.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class GoogleSearchPage extends BasePageObject {

    @FindBy(name = "q")
    private WebElement searchBox;

    public GoogleSearchPage(EventFiringWebDriver driver) {
        super(driver);
    }

    public void search(String searchString) {
        searchBox.sendKeys(searchString);
        searchBox.submit();
    }

}
