package jsmart.ui.pages;

import jsmart.assertj.WebElementAssert;
import jsmart.core.BasePage;
import jsmart.core.SmokeTestable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleResultsPage extends BasePage implements SmokeTestable {

    @FindBy(xpath = "//div[@id='result-stats']|//div[@id='mBMHK']")
    private WebElement resultStats;

    @FindBy(xpath = "//a[@href='https://www.flickr.com/photos/christopherjunius/']")
    public WebElement cjLink;

    public GoogleResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoogleResultsPage navigateTo() {
        driver.get("https://www.google.com/search?q=Christopher+Junius");
        return this.waitForPageToLoad();
    }

    @Override
    public GoogleResultsPage waitForPageToLoad() {
        wait.forElement(resultStats).toAppear();
        return this;
    }

    @Override
    public GoogleResultsPage verifyPageLoaded() {
        WebElementAssert.assertThat(resultStats).isDisplayed();
        return this;
    }

}