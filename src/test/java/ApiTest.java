import Utilities.BaseTestApi;
import Utilities.Constants;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import static Utilities.Constants.apibaseURL;
import static io.restassured.RestAssured.given;

public class ApiTest extends BaseTestApi {

    public ApiTest() {
        super();
    }

    @Test
    @Tag("Integration")
    @DisplayName("Check Status Code is 200")
    public void validateStatusCode() {
        RequestSpecification httpRequest = given();
        Response response = httpRequest.get(apibaseURL + Constants.apiPosts);
        int statusCode = response.getStatusCode();
        System.out.println("API todo status code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Check all posts returned")
    public void validateGet() {
        given()
                .when().
                get(apibaseURL + Constants.apiPosts).
                then().
                statusCode(200).log().all();
    }

    @Test
    @Tag("Integration")
    @DisplayName("Check PUT works for posts in blog")
    public void validatePut() {
        RequestSpecification request = given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("title", "foo");
        requestParams.put("body", "bar");
        requestParams.put("userId", "11");
        request.body(requestParams.toJSONString());
        Response response = request.put(apibaseURL + Constants.apiCrud);
        int statusCode = response.getStatusCode();
        System.out.println(response.asString());
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    @Tag("Integration")
    @DisplayName("Check POST works for posts in blog")
    public void validatePost() {
        RequestSpecification request = given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("title", "bar");
        requestParams.put("body", "bar");
        requestParams.put("userId", "1");

        request.body(requestParams.toJSONString());
        Response response = request.post(apibaseURL + Constants.apiPosts);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Check DELETE works for posts in blog")
    public void validateDelete() {
        RequestSpecification request = given();
        Response response = request.delete(apibaseURL + Constants.apiCrud);
        int statusCode = response.getStatusCode();
        System.out.println(response.asString());
        Assert.assertEquals(statusCode, 200);
    }

}

