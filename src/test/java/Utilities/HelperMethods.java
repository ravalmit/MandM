package Utilities;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Headers;
import io.restassured.http.Header;
import com.jayway.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import com.jayway.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HelperMethods{
    public Response response = null;
    
    public ArrayList getUserContent(JsonPath jp) {
        ArrayList userContent = jp.get();
        return userContent;
    }

    public ValidatableResponse prepareGet(String path, List<Header> headerlist) {
       // log.info("Prepare to send GET request with path " + path + " and headers " + headerlist.toString());
        try {
            return prepareGetDeleteWhen()
                    .headers((Map<String, ?>) new Headers((com.jayway.restassured.response.Header) headerlist))
                    .get(Constants.apibaseURL + path)
                    .then();
        } catch (Exception e) {
          //  log.error(e.toString());
            return null;
        }
    }

    public ValidatableResponse preparePut(String path, String body) {
      //  log.info ("Prepare to send PUT request with path " + path + " and body " + body.toString());
        try {
            return preparePostPutWhen(body)
                    .put(Constants.apibaseURL + path)
                    .then(); }
        catch (Exception e) {
          //  log.error (e.toString());
            return null;
        }
    }

    public  ValidatableResponse preparePost(String path, String body) {
     //   log.info ("Prepare to send POST request with path " + path + " and body " + body.toString());
        try {
            return preparePostPutWhen(body)
                    .post(Constants.apibaseURL + path)
                    .then(); }
        catch (Exception e) {
          //  log.error (e.toString());
            return null;
        }
    }

    public ValidatableResponse prepareDelete(String path) {
       // log.info ("Prepare to send DELETE request with path " + path);
        try {
            return prepareGetDeleteWhen()
                    .delete(Constants.apibaseURL + path)
                    .then(); }
        catch (Exception e) {
          //  log.error (e.toString());
            return null;
        }
    }

    public String extractJsonPath (ValidatableResponse response, String path) {
        try {
            return response.extract().jsonPath().getString(path); }
        catch (Exception e) {
          //  log.error (e.toString());
            return null;
        }
    }
    public RequestSpecification prepareGetDeleteWhen() {
        try {
            return given()
                  //  .auth()
                  //  .basic(envProperties.get("username").toString(), envProperties.get("password").toString())
                    .log().all()
                    .when(); }
        catch (Exception e) {
          //  log.error(e.toString());
            return null;
        }
    }
    public RequestSpecification preparePostPutWhen(String body) {
        try {
            return given()
              //      .auth()
              //      .basic(envProperties.get("username").toString(), envProperties.get("password").toString())
                    .body(body)
                    .log().all()
                    .when(); }
        catch (Exception e) {
          //  log.error (e.toString());
            return null;
        }
    }
}