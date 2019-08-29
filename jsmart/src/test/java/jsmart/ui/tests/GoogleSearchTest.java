package jsmart.ui.tests;

import jsmart.ui.pages.GoogleSearchPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test(groups = {"UI_Tests"})
public class GoogleSearchTest extends BaseUITest {

    @BeforeClass
    public void testSetup() {
        driver.get(ENVIRNONMENT.getURL());
    }

    @Test
    public void googleSearchTest() {
        GoogleSearchPage page = new GoogleSearchPage(driver);
        page.search("Christopher Junius");

        assertThat(driver.findElement(By.partialLinkText("Christopher Junius"))).isNotNull();
    }

}
