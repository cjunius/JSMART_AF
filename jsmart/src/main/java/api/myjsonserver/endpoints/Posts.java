package api.myjsonserver.endpoints;

import io.restassured.response.Response;

public interface Posts {

    public Response get();

    public Response get(String id);

    public Response post(String body);

    public Response put(String body);

    public Response patch(String body);

    public Response delete(String id);

}
