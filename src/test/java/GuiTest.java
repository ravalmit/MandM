import PageObjects.HomePage;
import PageObjects.HomeownersInsurancePage;
import PageObjects.RentersInsurancePage;
import Utilities.BaseTestGui;
import Utilities.Constants;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

public class GuiTest extends BaseTestGui {

    public GuiTest() {
        super();
    }

    public void guiFlow() {
        guiSetUp();
    }

    HomePage homePage = new HomePage();
    HomeownersInsurancePage homeownersInsurancePage = new HomeownersInsurancePage();
    RentersInsurancePage rentersInsurancePage = new RentersInsurancePage();

    @Before
    public void setup() {
        try {
            driver.get(Constants.guibaseURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Validate web page title")
    public void usaaCheckTitleTest() {
        System.out.println("GUI check running");
        try {
            driver.get(Constants.guibaseURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String expectedPageTitle = "Insurance, Banking, Investments & Retirement | USAA";
        Assert.assertTrue("Test Failed", driver.getTitle().contains(expectedPageTitle));
        log.error("No title found on page");
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Validate Homeowners Insurance page")
    public void verifyHomeownersInsurance() {
        homePage.verifyHomeRentersInsuranceSection();
        homePage.clickHomeownersInsuranceButton();
        homeownersInsurancePage.verifyHomeownersInsurancePage();
        log.info("TEST PASSED");
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Validate Renters Insurance page")
    public void verifyRentersInsurance() throws Exception {
        homePage.verifyHomeRentersInsuranceSection();
        homePage.clickRentersInsuranceButton();
        rentersInsurancePage.verifyRentersInsurancePage();
        log.info("TEST PASSED");
    }

}
