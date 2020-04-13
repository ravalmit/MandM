package Utilities;

import com.applitools.eyes.*;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.StitchMode;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTestVisual {
    public static WebDriver driver;
    public static EyesRunner runner;
    public static Eyes eyes;
    public static BatchInfo batch;
    public Logger log = LogManager.getLogger("BaseTestGui");

   @BeforeClass
    public static void guiSetUp(){
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }
    @BeforeClass
    public static void setVisualBatch() {
        batch = new BatchInfo("USAA batch");
    }
    @Before
    public void setupVisualTest() {
        runner = new ClassicRunner();
        eyes = new Eyes(runner);
        eyes.setApiKey(Constants.Apikey);
        eyes.setBatch(batch);
        eyes.open(driver, "Demo App", "Smoke Test", new RectangleSize(1200, 800));
        eyes.setMatchLevel(MatchLevel.LAYOUT);
        eyes.setForceFullPageScreenshot(true);
        eyes.setStitchMode(StitchMode.SCROLL);
    }
    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @After
    public void applitearDown(){
        eyes.abortIfNotClosed();
        TestResultsSummary allTestResults = runner.getAllTestResults();
        System.out.println(allTestResults);
    }
}
