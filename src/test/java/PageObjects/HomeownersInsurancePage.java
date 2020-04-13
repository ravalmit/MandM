package PageObjects;

import Utilities.BaseTestGui;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeownersInsurancePage  extends BaseTestGui {

    public HomeownersInsurancePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[text()='Homeowners Insurance Quotes']")
    WebElement hdrHomeownersInsurance;

    public void verifyHomeownersInsurancePage() {
        try {
            hdrHomeownersInsurance.isDisplayed();
            log.info("Homeowners Insurance page is displayed");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
