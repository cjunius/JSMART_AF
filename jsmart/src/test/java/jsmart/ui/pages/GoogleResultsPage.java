package jsmart.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleResultsPage extends BasePageObject {

    @FindBy(id = "resultStats")
    private WebElement resultStats;

    @FindBy(xpath = "//a[@href='https://www.flickr.com/photos/christopherjunius/']")
    public WebElement cjLink;

    public GoogleResultsPage(WebDriver driver) {
        super(driver);
        waitForPageToLoad();
    }

    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(resultStats));
    }

}