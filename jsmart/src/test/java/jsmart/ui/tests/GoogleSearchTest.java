package jsmart.ui.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.service.ExtentTestManager;
import jsmart.ui.pages.GoogleResultsPage;
import jsmart.ui.pages.GoogleSearchPage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static jsmart.WebElementAssert.assertThat;

@Test(groups = {"UI_Tests"})
public class GoogleSearchTest extends BaseUITest {

    @BeforeClass
    public void testSetup() {
        driver.get(environment.getURL());
    }

    @Test
    public void googleSearchTest() {
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        GoogleResultsPage resultsPage = searchPage.search("Christopher Junius");

        assertThat(resultsPage.cjLink).isDisplayed();

        String screenshotInBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        //ExtentTestManager.getTest().addScreenCaptureFromBase64String(screenshotInBase64, "Search Result Screenshot");
    }
}
