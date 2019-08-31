package jsmart.api.tests;

import static io.restassured.RestAssured.given;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

@Test(groups={"api"})
public class GoogleSearchAPITest extends ExtentITestListenerClassAdapter {

    @Test
    public void googleSearchAPITest() throws Exception {

        final ByteArrayOutputStream requestBAOS = new ByteArrayOutputStream();
        final ByteArrayOutputStream responseBAOS = new ByteArrayOutputStream();
        try (PrintStream requestPS = new PrintStream(requestBAOS, true, "UTF-8");
                PrintStream responsePS = new PrintStream(responseBAOS, true, "UTF-8")) {

            given()
                    .filter(new RequestLoggingFilter(LogDetail.ALL, requestPS))
                    .filter(new ResponseLoggingFilter(LogDetail.ALL, responsePS))
                .when()
                    .get("https://jsonplaceholder.typicode.com/todos/1")
                .then()
                    .assertThat()
                    .statusCode(200);

        } catch (AssertionError e) {
            String request = new String(requestBAOS.toByteArray(), StandardCharsets.UTF_8);
            ExtentTestManager.getTest().info(request.replace("\n", "<br />").replaceAll("  ", "&nbsp;&nbsp;"));

            String response = new String(responseBAOS.toByteArray(), StandardCharsets.UTF_8);
            ExtentTestManager.getTest().fail(response.replace("\n", "<br />").replaceAll("  ", "&nbsp;&nbsp;"));

            ExtentTestManager.getTest().fail(e);

            throw e;
        }
        String request = new String(requestBAOS.toByteArray(), StandardCharsets.UTF_8);
        ExtentTestManager.getTest().info(request.replace("\n", "<br />").replaceAll("  ", "&nbsp;&nbsp;"));

        String response = new String(responseBAOS.toByteArray(), StandardCharsets.UTF_8);
        ExtentTestManager.getTest().pass(response.replace("\n", "<br />").replaceAll("  ", "&nbsp;&nbsp;"));

    }
}
