package jsmart.ui.pages;

import jsmart.assertj.WebElementAssert;
import jsmart.base.BasePage;
import jsmart.base.SmokeTestPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends BasePage implements SmokeTestPage {

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
        System.out.println("Opening www.google.com");
        driver.get("https://www.google.com");
        return this.waitForPageToLoad();
    }

    public Validations verify() {
        return new Validations();
    }
    public class Validations extends PageValidations {

        public Validations pageLoaded() {
            WebElementAssert.assertThat(searchBox).isDisplayed();
            return this;
        }

    }

}
