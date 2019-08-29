package jsmart.ui.tests;

import jsmart.ui.pages.GoogleResultsPage;
import jsmart.ui.pages.GoogleSearchPage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static jsmart.WebElementAssert.assertThat;

@Test(groups = {"UI_Tests"})
public class GoogleSearchTest extends BaseUITest {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void googleSearchTest() {
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        GoogleResultsPage resultsPage = searchPage.search("Christopher Junius");

        assertThat(resultsPage.cjLink).isDisplayed();
    }
}
