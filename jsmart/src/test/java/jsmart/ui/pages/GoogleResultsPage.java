package jsmart.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleResultsPage extends BasePageObject {

    @FindBy(partialLinkText = "Christopher Junius")
    public WebElement cjLink;

    public GoogleResultsPage(WebDriver driver) {
        super(driver);
    }

}