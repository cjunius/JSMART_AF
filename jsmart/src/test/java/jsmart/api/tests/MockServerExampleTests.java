package jsmart.api.tests;

import org.mockserver.integration.ClientAndServer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import org.hamcrest.Matchers;

public class MockServerExampleTests {

    private ClientAndServer mockServer;

    @BeforeClass
    public void beforeClass() {
        mockServer = startClientAndServer(1080);

        mockServer.when(
            request()
                .withMethod("Get")
                .withPath("/BasicGet")
            )
            .respond(
                response()
                    .withHeader("TestHeader","TestHeader")
                    .withBody("Test Body")
            );

            mockServer.when(
                request()
                    .withMethod("Get")
                    .withPath("/JSON")
                )
                .respond(
                    response()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"Test\": \"Example\" }")
                );

            mockServer.when(
                request()
                    .withMethod("Get")
                    .withPath("/XML")
                )
                .respond(
                    response()
                        .withHeader("Content-Type", "application/xml")
                        .withBody("<notes><note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note></notes>")
                );

    }

    @AfterClass
    public void afterClass() {
        mockServer.stop();
    }

    @Test
    public void mockServerBasicGetTest() {
        RestAssured
            .given()
            .when()
                .get("http://localhost:1080/BasicGet")
            .then()
                .assertThat()
                    .statusCode(200)
                    .header("TestHeader","TestHeader")
                    .body(Matchers.stringContainsInOrder("Test","Body"));

        RestAssured
            .given()
                .body("Test")
            .when()
                .post("http://localhost:1080/BasicGet")
            .then()
                .assertThat()
                .statusCode(404);

        RestAssured
            .given()
            .when()
                .put("http://localhost:1080/BasicGet")
            .then()
                .assertThat()
                .statusCode(404);

        RestAssured
            .given()
            .when()
                .delete("http://localhost:1080/BasicGet")
            .then()
                .assertThat()
                .statusCode(404);

    }

    @Test
    public void mockServerJSONTest() {
        RestAssured
            .given()
            .when()
                .get("http://localhost:1080/JSON")
            .then()
                .assertThat()
                    .statusCode(200)
                    .body("Test", Matchers.equalTo("Example"));
    }

    @Test
    public void mockServerXMLTest() {
        RestAssured
            .given()
            .when()
                .get("http://localhost:1080/XML")
            .then()
                .assertThat()
                    .statusCode(200)
                    .body("notes.note[0].to", Matchers.equalTo("Tove"))
                    .body("notes.note[0].from", Matchers.equalTo("Jani"))
                    .body("notes.note[0].heading", Matchers.equalTo("Reminder"))
                    .body("notes.note[0].body", Matchers.equalTo("Don't forget me this weekend!"));
    }
    
}
