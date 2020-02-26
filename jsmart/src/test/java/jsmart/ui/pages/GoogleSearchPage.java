package jsmart.ui.pages;

import jsmart.assertj.WebElementAssert;
import jsmart.core.BasePage;
import jsmart.core.SmokeTestable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends BasePage implements SmokeTestable {

    @FindBy(name = "q")
    private WebElement searchBox;

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public GoogleResultsPage search(String searchString) {
        searchBox.sendKeys(searchString);
        searchBox.submit();
        return new GoogleResultsPage(driver).waitForPageToLoad();
    }

    public GoogleSearchPage waitForPageToLoad() {
        wait.forElement(searchBox).toAppear();
        return this;
    }

    public GoogleSearchPage navigateTo() {
        driver.get("https://www.google.com");
        return this.waitForPageToLoad();
    }

    public GoogleSearchPage verifyPageLoaded() {
        WebElementAssert.assertThat(searchBox).isDisplayed();
        return this;
    }

}
