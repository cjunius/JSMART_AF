package jsmart.assertj;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebDriver;

public class WebDriverAssert extends AbstractAssert<WebDriverAssert, WebDriver> {

    public WebDriverAssert(WebDriver driver) {
        super(driver, WebDriverAssert.class);
    }

    public static WebDriverAssert assertThat(WebDriver driver){
        return new WebDriverAssert(driver);
    }

    public WebDriverAssert containsURI(String uri) {
        isNotNull();

        if(!actual.getCurrentUrl().contains(uri)) {
            failWithMessage("Url " + actual.getCurrentUrl() + " did not contain " + uri);
        }
        return this;
    }

    public WebDriverAssert hasURL(String url) {
        isNotNull();

        if(!actual.getCurrentUrl().equalsIgnoreCase(url)) {
            failWithMessage("Url " + actual.getCurrentUrl() + " did not match " + url);
        }
        return this;
    }

    public WebDriverAssert hasTitle(String title) {
        isNotNull();

        if(!actual.getTitle().equals(title)) {
            failWithMessage("Page title " + actual.getTitle() + " did not match " + title);
        }
        return this;
    }

    public WebDriverAssert hasCookie(String name) {
        isNotNull();

        if(actual.manage().getCookieNamed(name) != null) {
            failWithMessage("Did not find cookie with name " + name);
        }
        return this;
    }

}
