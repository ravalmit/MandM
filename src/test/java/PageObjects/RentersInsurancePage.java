package PageObjects;

import Utilities.BaseTestGui;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RentersInsurancePage extends BaseTestGui {

    public RentersInsurancePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[text()='Renters Insurance'][@class='eagle-h1']")
    WebElement hdrRentersInsurance;

    public void verifyRentersInsurancePage() {
        try {
            hdrRentersInsurance.isDisplayed();
            log.info("Renters Insurance page is displayed");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
