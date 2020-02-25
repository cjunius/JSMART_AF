package api.myjsonserver.endpoints.impl;

import api.myjsonserver.endpoints.Posts;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostsImpl implements Posts {

    private static final String POSTS_ENDPOINT = "https://my-json-server.typicode.com/cjunius/myjsonserver/posts";
    private static final String POSTS_ID_ENDPOINT = "https://my-json-server.typicode.com/cjunius/myjsonserver/posts/{id}";

    @Override
    public Response get() {
        return given().when().get(POSTS_ENDPOINT);
    }

    @Override
    public Response get(String id) {
        return given().pathParam("id", id).when().get(POSTS_ID_ENDPOINT);
    }

    @Override
    public Response post(String body) {
        return given().body(body).when().post(POSTS_ENDPOINT);
    }

    @Override
    public Response put(String body) {
        return given().body(body).when().put(POSTS_ENDPOINT);
    }

    @Override
    public Response patch(String body) {
        return given().body(body).when().patch(POSTS_ENDPOINT);
    }

    @Override
    public Response delete(String id) {
        return given().pathParam("id", id).when().delete(POSTS_ID_ENDPOINT);
    }

}
