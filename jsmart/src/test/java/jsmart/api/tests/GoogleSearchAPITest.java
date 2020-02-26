package jsmart.api.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.config.RestAssuredConfig.config;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import jsmart.core.BaseAPITest;
import org.testng.annotations.Test;

@Test(groups={"api"})
public class GoogleSearchAPITest extends BaseAPITest {

    @Test
    public void googleSearchAPITest() {

        RestAssured.config = config().logConfig(new LogConfig().defaultStream(getPrintStream()));

        given()
                .filter(new RequestLoggingFilter(LogDetail.ALL))
                .filter(new ResponseLoggingFilter(LogDetail.ALL))
            .when()
                .get("https://www.google.com/search?q=Christopher+Junius")
            .then()
                .assertThat()
                .statusCode(200);
    }
}
