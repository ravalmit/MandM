package Utilities;

import Utilities.Constants;
import Utilities.HelperMethods;
import Utilities.Helpers;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class BaseTestApi {
    public Response res = null;
    public JsonPath jp = null;
    public Logger log = LogManager.getLogger("BaseTestApi");

    HelperMethods testUtils = new HelperMethods();

    @Before
    public  void setup(){
        RestAssured.baseURI = Constants.apibaseURL;
        Helpers.setContentType(ContentType.JSON);
    }


    }

