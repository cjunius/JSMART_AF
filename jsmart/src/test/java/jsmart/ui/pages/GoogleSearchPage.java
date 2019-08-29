package jsmart.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends BasePageObject {

    @FindBy(name = "q")
    private WebElement searchBox;

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public GoogleResultsPage search(String searchString) {
        searchBox.sendKeys(searchString);
        searchBox.submit();
        return new GoogleResultsPage(driver);
    }

}
