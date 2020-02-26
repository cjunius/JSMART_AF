package jsmart.ui.tests;

import jsmart.core.BaseUITest;
import jsmart.ui.pages.GoogleResultsPage;
import jsmart.ui.pages.GoogleSearchPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static jsmart.assertj.WebElementAssert.assertThat;

@Test(groups = {"UI_Tests"})
public class GoogleSearchTest extends BaseUITest {

    @BeforeClass
    public void testSetup() {
        driver.get(properties.getProperty("url"));
    }

    @Test
    public void googleSearchTest() {
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        GoogleResultsPage resultsPage = searchPage.search("Christopher Junius");

        assertThat(resultsPage.cjLink).isDisplayed();
    }
}
