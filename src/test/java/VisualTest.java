
import Utilities.BaseTestVisual;
import Utilities.Constants;
import org.junit.Test;
import PageObjects.HomePage;
import PageObjects.HomeownersInsurancePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.support.PageFactory;


public class VisualTest extends BaseTestVisual {

    public VisualTest() {
        super();
    }

    public void visualFlow() {
        guiSetUp();
        setVisualBatch();
        setupVisualTest();
    }

    @Test
    @Tag("Regression")
    @DisplayName("Verify Home and Homeowners Pages")
    public void baselineTest() {
        System.out.println("Visual test running");
        try {
            driver.get(Constants.visualbaseURL);
        } catch (Exception e) {
            log.error(e);
        }

        eyes.checkWindow("Home Page Window");

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickHomeownersInsuranceButton();

        eyes.checkWindow("Homeowners Page Window");
        eyes.closeAsync();
    }

}
