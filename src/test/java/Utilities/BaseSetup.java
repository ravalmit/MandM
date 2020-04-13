package Utilities;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseSetup {
    Properties  envProperties = null;
    protected Logger log = LogManager.getLogger("rootLogger");

    public BaseSetup(){
        Properties  envProperties = null;
        RestAssured restAssured;
            System.out.println("Going here first");
            getApplicationProperties();
            configureEnvironmentSetting();
        }
        public void getApplicationProperties(){
            log.info("Environment: " + System.getProperty("environment"));
            InputStream is = null;
            try {
                this.envProperties = new Properties();
                is = this.getClass().getResourceAsStream("/"+System.getProperty("environment")+".properties");
                envProperties.load(is);
            } catch (FileNotFoundException e) {
                log.error (e.toString());
            } catch (IOException e) {
                log.error (e.toString());
            }
        }
    public void configureEnvironmentSetting(){

        RestAssured.baseURI = envProperties.get("host").toString();
        RestAssured.basePath = "/";
        RestAssured.port = Integer.parseInt(envProperties.get("port").toString());
    }
    public String getBaseURI () {
        return envProperties.get("host").toString();
    }
}
