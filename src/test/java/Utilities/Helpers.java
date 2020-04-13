package Utilities;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

public class Helpers  {

    public static String path;
    public static String jsonPathTerm;

    public static void setBasePath(String basePathTerm){
        RestAssured.basePath = basePathTerm;
    }

    public static void resetBaseURI (){
        RestAssured.baseURI = null;
    }

    public static void resetBasePath(){
        RestAssured.basePath = null;
    }

    public static void setContentType (ContentType Type){
        given().contentType(Type);
    }

    public static Response getResponsebyPath(String path) {
        return get(path);
    }

    public static Response getResponse() {
        return get();
    }

    public static JsonPath getJsonPath (Response res) {
        String json = res.asString();
        System.out.print("returned json: " + json +"\n");
        return new JsonPath(json);
    }
}
